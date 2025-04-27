/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------	
21/01/2019		        IN067421			    B Haribabu						                             ML-BRU-SCF-1815 
-------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;

import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;

public class ItemMovementShowItemBean extends StTransaction implements Serializable{

	private String query_type;
	private String result_criteria;
	private String store_code;
	private String item_code;
	private String item_class;
	private String from;
	private String to;
	private String trn_code;
	private String stock_item;
	private String month_opening_qty;
	private String month_closing_qty;

	public String getFrom() {
		 return this.from;  
	}

	public String getTo() {
		 return this.to; 
	}
	
	public void setMonth_opening_qty(String month_opening_qty) {
		 this.month_opening_qty = month_opening_qty;  
	}

	public String getMonth_opening_qty() {
		 return this.month_opening_qty;  
	}
	
	public void setMonth_closing_qty(String month_closing_qty) {
		 this.month_closing_qty = month_closing_qty;  
	}

	public String getMonth_closing_qty() {
		 return this.month_closing_qty;  
	}

	public void setQuery_type(String query_type) {
		 this.query_type = query_type;  
	}

	public void setResult_criteria(String result_criteria) {
		 this.result_criteria = result_criteria; 
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;  
	}

	public String getStore_code() {
		 return this.store_code;  
	}

	public String getItem_code() {
		 return this.item_code;  
	}

	public void setItem_code(String item_code) {
		 this.item_code = item_code;  
	}

	public void setItem_class(String item_class) {
		 this.item_class = item_class;  
	}

	public void setFrom(String from) {
		 this.from = from;  
	}

	public void setTo(String to) {
		 this.to = to;  
	}
	
	public String getTrn_code() {
		 return this.trn_code;  
	}

	public void setTrn_code(String trn_code) {
		 this.trn_code = trn_code;  
	}
	
	public void setStock_item(String stock_item) {
		 this.stock_item = stock_item;  
	}


	public String checkForZero(String in_val)
	{
		return checkForNull(in_val,"0").equals("0")?"&nbsp;":in_val;
	}

	public ArrayList loadData() throws Exception {	
	try	{
	if(query_type.equals("summary")) {
			ArrayList alParameters=new ArrayList();
			alParameters.add(this.item_code);
			alParameters.add(this.item_code);
			alParameters.add(this.item_class);
			alParameters.add(this.store_code);
		if(from.equals("0") && to.equals("0"))
		{
				from = "190001";
				to = "999912";
		}
		if(from.equals("0"))
		{
				from = "190001";
		}
		if(to.equals("0"))
		{
				to = "999912";
		}

			alParameters.add(this.from);
			alParameters.add(this.to);
			alParameters.add(getLoginFacilityId());
		
		if(result_criteria.equals("quantity")) 
			{
			//String Sql="SELECT   MOVE_YEAR || TO_CHAR (MOVE_MONTH, '00') ORDERBYPERIOD,TO_CHAR (MOVE_MONTH, '00') || '/' || MOVE_YEAR PERIOD,DECODE (TRIM (TO_CHAR ((  SUM (MONTH_OPENING_QTY)+ NVL (SUM (OBS_QTY), 0)),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ((  SUM (MONTH_OPENING_QTY)+ NVL (SUM (OBS_QTY), 0)),'999,999,999,999,999,999,999.99'))) IN_OPEN_BAL,DECODE (TRIM (TO_CHAR (SUM (GRN_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (GRN_QTY),'999,999,999,999,999,999,999.99'))) IN_GRN,DECODE (TRIM (TO_CHAR (SUM (POS_ADJ_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_ADJ_QTY),'999,999,999,999,999,999,999.99'))) IN_ADJ,DECODE (TRIM (TO_CHAR (SUM (POS_VAR_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_VAR_QTY),'999,999,999,999,999,999,999.99'))) IN_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY > 0  THEN MFG_QTY ELSE 0 END), '999,999,999,999,999,999,999.99' ) ) ) IN_MFG_REC, DECODE (TRIM (TO_CHAR (SUM (SRT_QTY), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM (SRT_QTY), '999,999,999,999,999,999,999.99' ) ) ) IN_SALE_RET, DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END), '999,999,999,999,999,999,999.99' ) ) ) IN_PROD, DECODE (TRIM (TO_CHAR (SUM (IN_TFR_QTY), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM (IN_TFR_QTY), '999,999,999,999,999,999,999.99' ) ) ) IN_TFR, DECODE (TRIM (TO_CHAR (SUM (RTV_QTY), '999,999,999,999,999,999,999.99' )), '.00', '0.00', TRIM (TO_CHAR (SUM (RTV_QTY),'999,999,999,999,999,999,999.99' ) ) ) OUT_RTV, DECODE (TRIM (TO_CHAR (SUM (NEG_ADJ_QTY), '999,999,999,999,999,999,999.99' ) ),'.00', '0.00',TRIM (TO_CHAR (SUM (NEG_ADJ_QTY),'999,999,999,999,999,999,999.99'))) OUT_ADJ,DECODE (TRIM (TO_CHAR (SUM (NEG_VAR_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (NEG_VAR_QTY),'999,999,999,999,999,999,999.99'))) OUT_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END),'999,999,999,999,999,999,999.99' )),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END),'999,999,999,999,999,999,999.99'))) OUT_MFG,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END), '999,999,999,999,999,999,999.99' ))) OUT_PROD, DECODE (TRIM (TO_CHAR (SUM (SAL_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (SAL_QTY),'999,999,999,999,999,999,999.99'))) OUT_SALE,DECODE (TRIM (TO_CHAR (SUM (CONS_QTY + SAL_QTY + SRT_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (CONS_QTY + SAL_QTY + SRT_QTY),'999,999,999,999,999,999,999.99'))) OUT_CONS,DECODE(TRIM (TO_CHAR (SUM (MONTH_CLOSING_QTY),'999,999,999,999,999,999,999.99') ),'.00', '0.00',TRIM (TO_CHAR (SUM (MONTH_CLOSING_QTY),'999,999,999,999,999,999,999.99'))) OUT_CLOS_BAL,DECODE(TRIM (TO_CHAR (SUM (IN_ISS_QTY + IN_URG_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (IN_ISS_QTY + IN_URG_QTY),'999,999,999,999,999,999,999.99'))) IN_INV_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (IN_RET_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (IN_RET_QTY),'999,999,999,999,999,999,999.99'))) IN_INV_RET_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST),'999,999,999,999,999,999,999.99'))) OUT_INV_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS),'999,999,999,999,999,999,999.99'))) OUT_NS_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_RET_QTY_ST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (OUT_RET_QTY_ST),'999,999,999,999,999,999,999.99'))) OUT_INV_RET_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_RET_QTY_NS),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (OUT_RET_QTY_NS),'999,999,999,999,999,999,999.99'))) OUT_NS_RET_STORE,DECODE (TRIM (TO_CHAR (SUM (OUT_TFR_QTY),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (OUT_TFR_QTY),'999,999,999,999,999,999,999.99'))) OUT_TFR,DECODE(TRIM (TO_CHAR ((  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), '999,999,999,999,999,999,999.99' ) ),'.00', '0.00', TRIM (TO_CHAR ((  SUM (GRN_QTY) + SUM (POS_ADJ_QTY) + SUM (POS_VAR_QTY) + SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0  END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), '999,999,999,999,999,999,999.99' ) ) ) TOTAL_INFLOW, DECODE(TRIM (TO_CHAR ((  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY) + SUM (NEG_VAR_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), '999,999,999,999,999,999,999.99' ) ),'.00', '0.00',TRIM (TO_CHAR ((  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY)+ SUM (NEG_VAR_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), '999,999,999,999,999,999,999.99' ) ) ) TOTAL_OUTFLOW,DECODE (TRIM (TO_CHAR (SUM(SUM (GRN_QTY)) OVER (), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM(SUM (GRN_QTY)) OVER (), '999,999,999,999,999,999,999.99' ))) GRN_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (POS_ADJ_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (POS_ADJ_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) POS_ADJ_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (POS_VAR_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (POS_VAR_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) POS_VAR_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99' )),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99'))) MFG_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (SRT_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (SRT_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) IN_SALE_RET_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END)) OVER (),'999,999,999,999,999,999,999.99'))) IN_PROD_COLUMN,DECODE (TRIM (TO_CHAR (SUM (SUM(RTV_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (RTV_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) OUT_RTV_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (NEG_ADJ_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (NEG_ADJ_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) OUT_ADJ_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (NEG_VAR_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (NEG_VAR_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) OUT_VAR_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99'))) OUT_MFG_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END)) OVER (),'999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99' ) ) ) OUT_PROD_COLUMN, DECODE (TRIM (TO_CHAR (SUM(SUM (SAL_QTY)) OVER (), '999,999,999,999,999,999,999.99' ) ),'.00', '0.00', TRIM (TO_CHAR (SUM(SUM (SAL_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) OUT_SALE_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CONS_QTY + SAL_QTY + SRT_QTY)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (CONS_QTY + SAL_QTY + SRT_QTY)) OVER (),'999,999,999,999,999,999,999.99'))) OUT_CONS_COLUMN,DECODE(TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), '999,999,999,999,999,999,999.99' ) ) ) TOTAL_TOTAL_INFLOW, DECODE (TRIM (TO_CHAR (SUM (  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY) + SUM (NEG_VAR_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), '999,999,999,999,999,999,999.99' )),'.00', '0.00',TRIM (TO_CHAR (SUM (  SUM (RTV_QTY)+ SUM (NEG_ADJ_QTY)+ SUM (NEG_VAR_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)+ SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), '999,999,999,999,999,999,999.99' ) ) ) TOTAL_TOTAL_OUTFLOW FROM ST_ITEM_MOVE_SUMM A, MM_ITEM B WHERE A.ITEM_CODE = B.ITEM_CODE AND (B.ITEM_CODE = ? OR (? IS NULL AND B.ITEM_CLASS_CODE = ?)) AND A.STORE_CODE = NVL (?, A.STORE_CODE) AND MOVE_YEAR * 100 + MOVE_MONTH BETWEEN ? AND ? AND A.FACILITY_ID = ? GROUP BY MOVE_MONTH, MOVE_YEAR ORDER BY ORDERBYPERIOD";
			/**
			* @Name - Priya
			* @Date - 03/02/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Modified by priya as if the value of quantity fields is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so commented the below coding and modified the query by calling the function 'st_display_decimals' 
			*/
			/*
			String Sql="SELECT   MOVE_YEAR || TO_CHAR (MOVE_MONTH, '00') ORDERBYPERIOD,TO_CHAR (MOVE_MONTH, '00') || '/' || MOVE_YEAR PERIOD,DECODE (TRIM (TO_CHAR ((  SUM (MONTH_OPENING_QTY)+ NVL (SUM (OBS_QTY), 0)),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR ((  SUM (MONTH_OPENING_QTY)+ NVL (SUM (OBS_QTY), 0)),'REPLACE_CHAR'))) IN_OPEN_BAL,DECODE (TRIM (TO_CHAR (SUM (GRN_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (GRN_QTY),'REPLACE_CHAR'))) IN_GRN,DECODE (TRIM (TO_CHAR (SUM (POS_ADJ_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (POS_ADJ_QTY),'REPLACE_CHAR'))) IN_ADJ,DECODE (TRIM (TO_CHAR (SUM (POS_VAR_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (POS_VAR_QTY),'REPLACE_CHAR'))) IN_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END), 'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY > 0  THEN MFG_QTY ELSE 0 END), 'REPLACE_CHAR' ) ) ) IN_MFG_REC, DECODE (TRIM (TO_CHAR (SUM (SRT_QTY), 'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM (SRT_QTY), 'REPLACE_CHAR' ) ) ) IN_SALE_RET, DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END), 'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END), 'REPLACE_CHAR' ) ) ) IN_PROD, DECODE (TRIM (TO_CHAR (SUM (IN_TFR_QTY), 'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM (IN_TFR_QTY), 'REPLACE_CHAR' ) ) ) IN_TFR, DECODE (TRIM (TO_CHAR (SUM (RTV_QTY), 'REPLACE_CHAR' )), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM (RTV_QTY),'REPLACE_CHAR' ) ) ) OUT_RTV, DECODE (TRIM (TO_CHAR (SUM (NEG_ADJ_QTY), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (NEG_ADJ_QTY),'REPLACE_CHAR'))) OUT_ADJ,DECODE (TRIM (TO_CHAR (SUM (NEG_VAR_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (NEG_VAR_QTY),'REPLACE_CHAR'))) OUT_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END),'REPLACE_CHAR' )),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END),'REPLACE_CHAR'))) OUT_MFG,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END), 'REPLACE_CHAR' ))) OUT_PROD, DECODE (TRIM (TO_CHAR (SUM (SAL_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (SAL_QTY),'REPLACE_CHAR'))) OUT_SALE,DECODE (TRIM (TO_CHAR (SUM (CONS_QTY + SAL_QTY + SRT_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (CONS_QTY + SAL_QTY + SRT_QTY),'REPLACE_CHAR'))) OUT_CONS,DECODE(TRIM (TO_CHAR (SUM (MONTH_CLOSING_QTY),'REPLACE_CHAR') ),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (MONTH_CLOSING_QTY),'REPLACE_CHAR'))) OUT_CLOS_BAL,DECODE(TRIM (TO_CHAR (SUM (IN_ISS_QTY + IN_URG_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (IN_ISS_QTY + IN_URG_QTY),'REPLACE_CHAR'))) IN_INV_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (IN_RET_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (IN_RET_QTY),'REPLACE_CHAR'))) IN_INV_RET_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST),'REPLACE_CHAR'))) OUT_INV_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS),'REPLACE_CHAR'))) OUT_NS_ISS_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_RET_QTY_ST),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (OUT_RET_QTY_ST),'REPLACE_CHAR'))) OUT_INV_RET_STORE,DECODE(TRIM (TO_CHAR (SUM (OUT_RET_QTY_NS),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (OUT_RET_QTY_NS),'REPLACE_CHAR'))) OUT_NS_RET_STORE,DECODE (TRIM (TO_CHAR (SUM (OUT_TFR_QTY),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (OUT_TFR_QTY),'REPLACE_CHAR'))) OUT_TFR,DECODE(TRIM (TO_CHAR ((  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR', TRIM (TO_CHAR ((  SUM (GRN_QTY) + SUM (POS_ADJ_QTY) + SUM (POS_VAR_QTY) + SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0  END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), 'REPLACE_CHAR' ) ) ) TOTAL_INFLOW,DECODE(TRIM (TO_CHAR ((  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY) + SUM (NEG_VAR_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR',TRIM (TO_CHAR ((  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY)+ SUM (NEG_VAR_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), 'REPLACE_CHAR' ) ) ) TOTAL_OUTFLOW,DECODE (TRIM (TO_CHAR (SUM(SUM (GRN_QTY)) OVER (), 'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM(SUM (GRN_QTY)) OVER (), 'REPLACE_CHAR' ))) GRN_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (POS_ADJ_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (POS_ADJ_QTY)) OVER (),'REPLACE_CHAR'))) POS_ADJ_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (POS_VAR_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (POS_VAR_QTY)) OVER (),'REPLACE_CHAR'))) POS_VAR_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR' )),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR'))) MFG_QTY_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (SRT_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (SRT_QTY)) OVER (),'REPLACE_CHAR'))) IN_SALE_RET_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END)) OVER (),'REPLACE_CHAR'))) IN_PROD_COLUMN,DECODE (TRIM (TO_CHAR (SUM (SUM(RTV_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (RTV_QTY)) OVER (),'REPLACE_CHAR'))) OUT_RTV_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (NEG_ADJ_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (NEG_ADJ_QTY)) OVER (),'REPLACE_CHAR'))) OUT_ADJ_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (NEG_VAR_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (NEG_VAR_QTY)) OVER (),'REPLACE_CHAR'))) OUT_VAR_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR'))) OUT_MFG_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END)) OVER (),'REPLACE_CHAR' ) ), '.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END)) OVER (), 'REPLACE_CHAR' ) ) ) OUT_PROD_COLUMN, DECODE (TRIM (TO_CHAR (SUM(SUM (SAL_QTY)) OVER (), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR', TRIM (TO_CHAR (SUM(SUM (SAL_QTY)) OVER (),'REPLACE_CHAR'))) OUT_SALE_COLUMN,DECODE(TRIM (TO_CHAR (SUM(SUM (CONS_QTY + SAL_QTY + SRT_QTY)) OVER (),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (CONS_QTY + SAL_QTY + SRT_QTY)) OVER (),'REPLACE_CHAR'))) OUT_CONS_COLUMN,DECODE(TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (POS_ADJ_QTY)+ SUM (POS_VAR_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), 'REPLACE_CHAR' ) ) ) TOTAL_TOTAL_INFLOW,DECODE (TRIM (TO_CHAR (SUM (  SUM (RTV_QTY) + SUM (NEG_ADJ_QTY) + SUM (NEG_VAR_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), 'REPLACE_CHAR' )),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (  SUM (RTV_QTY)+ SUM (NEG_ADJ_QTY)+ SUM (NEG_VAR_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)+ SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), 'REPLACE_CHAR' ) ) ) TOTAL_TOTAL_OUTFLOW,DECODE(TRIM (TO_CHAR ((  SUM (GRN_QTY)+ SUM (IN_ISS_QTY + IN_URG_QTY)+ SUM (IN_RET_QTY)+ SUM (IN_TFR_QTY)+ SUM (POS_ADJ_QTY)+SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR', TRIM (TO_CHAR ((  SUM (GRN_QTY) + SUM (IN_ISS_QTY + IN_URG_QTY)+ SUM (IN_RET_QTY)+ SUM (IN_TFR_QTY)+ SUM (POS_ADJ_QTY) + SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0  END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ), 'REPLACE_CHAR' ) ) ) TOTAL_INFLOW_STORE,	DECODE(TRIM (TO_CHAR ((  SUM (RTV_QTY)+ SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)+ SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)+ SUM (OUT_RET_QTY_ST)+ SUM (OUT_RET_QTY_NS)+ SUM (OUT_TFR_QTY) + SUM (NEG_ADJ_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), 'REPLACE_CHAR' ) ),'.00', 'REPLACE_STR',TRIM (TO_CHAR ((  SUM (RTV_QTY)+ SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)+ SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)+ SUM (OUT_RET_QTY_ST)+ SUM (OUT_RET_QTY_NS)+ SUM (OUT_TFR_QTY) + SUM (NEG_ADJ_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ), 'REPLACE_CHAR' ) ) ) TOTAL_OUTFLOW_STORE,DECODE(TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (IN_ISS_QTY + IN_URG_QTY)+ SUM (IN_RET_QTY)+ SUM (IN_TFR_QTY)+ SUM (POS_ADJ_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (  SUM (GRN_QTY)+ SUM (IN_ISS_QTY + IN_URG_QTY)+ SUM (IN_RET_QTY)+ SUM (IN_TFR_QTY)+ SUM (POS_ADJ_QTY)+ SUM (CASE WHEN MFG_QTY > 0 THEN MFG_QTY ELSE 0 END) + SUM (SRT_QTY) + SUM (CASE WHEN PRT_QTY > 0 THEN PRT_QTY ELSE 0 END) ) OVER (), 'REPLACE_CHAR' ) ) ) TOTAL_TOTAL_INFLOW_STORE,DECODE (TRIM (TO_CHAR (SUM (  SUM (RTV_QTY)+ SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)+ SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)+ SUM (OUT_RET_QTY_ST)+ SUM (OUT_RET_QTY_NS)+ SUM (OUT_TFR_QTY) + SUM (NEG_ADJ_QTY) + SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END) + SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), 'REPLACE_CHAR' )),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (  SUM (RTV_QTY)+ SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)+ SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)+ SUM (OUT_RET_QTY_ST)+ SUM (OUT_RET_QTY_NS)+ SUM (OUT_TFR_QTY)+ SUM (NEG_ADJ_QTY)+ SUM (CASE WHEN MFG_QTY < 0 THEN MFG_QTY ELSE 0 END)+ SUM (CASE WHEN PRT_QTY < 0 THEN PRT_QTY ELSE 0 END) + SUM (SAL_QTY) ) OVER (), 'REPLACE_CHAR' ) ) ) TOTAL_TOTAL_OUTFLOW_STORE,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_TFR_QTY)) OVER(), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM (SUM(IN_TFR_QTY)) OVER(), 'REPLACE_CHAR'))) IN_TFR_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_ISS_QTY + IN_URG_QTY)) OVER(), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (IN_ISS_QTY + IN_URG_QTY)) OVER (), 'REPLACE_CHAR'))) IN_INV_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_RET_QTY)) OVER (), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (IN_RET_QTY)) OVER (), 'REPLACE_CHAR'))) IN_INV_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)) OVER(),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (OUT_ISS_QTY_ST + OUT_URG_QTY_ST)) OVER (),'REPLACE_CHAR'))) OUT_INV_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)) OVER(),'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (OUT_ISS_QTY_NS + OUT_URG_QTY_NS)) OVER (),'REPLACE_CHAR'))) OUT_NS_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_RET_QTY_ST)) OVER(), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (OUT_RET_QTY_ST)) OVER(), 'REPLACE_CHAR'))) OUT_INV_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_RET_QTY_NS)) OVER(), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (OUT_RET_QTY_NS)) OVER(), 'REPLACE_CHAR'))) OUT_NS_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_TFR_QTY)) OVER(), 'REPLACE_CHAR')),'.00', 'REPLACE_STR',TRIM (TO_CHAR (SUM(SUM (OUT_TFR_QTY)) OVER(), 'REPLACE_CHAR'))) OUT_TFR_COLUMN	FROM ST_ITEM_MOVE_SUMM A, MM_ITEM B WHERE A.ITEM_CODE = B.ITEM_CODE AND (B.ITEM_CODE = ? OR (? IS NULL AND B.ITEM_CLASS_CODE = ?)) AND A.STORE_CODE = NVL (?, A.STORE_CODE) AND MOVE_YEAR * 100 + MOVE_MONTH BETWEEN ? AND ? AND A.FACILITY_ID = ? GROUP BY MOVE_MONTH, MOVE_YEAR ORDER BY ORDERBYPERIOD";
			/**
					* @Name - krishna
					* @Date - 24/12/2009
					* @Inc# - CRF537.1
					* @Desc - No of decimal positions
			
			int no_of_decimals=Integer.parseInt(checkForNull((String)fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("NO_OF_DECIMALS"),"0"));
			String format_string="999,999,999,999,999,999,999.99";
			String decode_string="0.00";
			if(no_of_decimals==1 ){
				format_string="999,999,999,999,999,999,999.9";
				decode_string="0.0";
			}else if(no_of_decimals==3 ){
				format_string="999,999,999,999,999,999,999.999";
				decode_string="0.000";
			}else if(no_of_decimals==4 ){
				format_string="999,999,999,999,999,999,999.9999";
				decode_string="0.0000";
			}
			Sql=Sql.replaceAll("REPLACE_STR",decode_string);
			ArrayList alRecords	= fetchRecords(Sql.replaceAll("REPLACE_CHAR",format_string), alParameters); */
			String Sql="SELECT   move_year || TO_CHAR (move_month, '00') orderbyperiod, TO_CHAR (move_month, '00') || '/' || move_year period, st_display_decimals((  SUM (month_opening_qty) + NVL (SUM (obs_qty), 0) ),'Y') in_open_bal, st_display_decimals((SUM (grn_qty)),'Y') in_grn, st_display_decimals((SUM (pos_adj_qty)),'Y') in_adj, st_display_decimals((SUM (pos_var_qty)),'Y') in_var, st_display_decimals((SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END)),'Y') in_mfg_rec, st_display_decimals((SUM (srt_qty)),'Y') in_sale_ret, st_display_decimals((SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END)),'Y') in_prod, st_display_decimals((SUM (in_tfr_qty)),'Y') in_tfr, st_display_decimals((SUM (rtv_qty)),'Y') out_rtv, st_display_decimals((SUM (neg_adj_qty)),'Y') out_adj, st_display_decimals((SUM (neg_var_qty)),'Y') out_var, st_display_decimals((SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END)),'Y') out_mfg, st_display_decimals((SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END)),'Y') out_prod, st_display_decimals((SUM (sal_qty)),'Y') out_sale, st_display_decimals((SUM (cons_qty + sal_qty + srt_qty)),'Y') out_cons,          st_display_decimals((SUM (month_closing_qty)),'Y') out_clos_bal,          st_display_decimals((SUM (in_iss_qty + in_urg_qty)),'Y') in_inv_iss_store,          st_display_decimals((SUM (in_ret_qty)),'Y') in_inv_ret_store,          st_display_decimals((SUM (out_iss_qty_st + out_urg_qty_st)),'Y') out_inv_iss_store, st_display_decimals((SUM (out_iss_qty_ns + out_urg_qty_ns)),'Y') out_ns_iss_store, st_display_decimals((SUM (out_ret_qty_st)),'Y') out_inv_ret_store,          st_display_decimals((SUM (out_ret_qty_ns)),'Y') out_ns_ret_store,         st_display_decimals((SUM (out_tfr_qty)),'Y') out_tfr, st_display_decimals(((  SUM (grn_qty) + SUM (pos_adj_qty) + SUM (pos_var_qty) + SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END) + SUM (srt_qty) + SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END) )),'Y') total_inflow, st_display_decimals (((  SUM (rtv_qty) + SUM (neg_adj_qty) + SUM (neg_var_qty) + SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END) + SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END) + SUM (sal_qty) )),'Y') total_outflow, st_display_decimals((SUM (SUM (grn_qty)) OVER ()),'Y') grn_qty_column, st_display_decimals((SUM (SUM (pos_adj_qty)) OVER ()),'Y') pos_adj_column,          st_display_decimals((SUM (SUM (pos_var_qty)) OVER ()),'Y') pos_var_qty_column,          st_display_decimals((SUM (SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END)) OVER ()),'Y') mfg_qty_column, st_display_decimals((SUM (SUM (srt_qty)) OVER ()),'Y') in_sale_ret_column, st_display_decimals((SUM (SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END)) OVER ()),'Y') in_prod_column, st_display_decimals((SUM (SUM (rtv_qty)) OVER ()),'Y') out_rtv_column, st_display_decimals((SUM (SUM (neg_adj_qty)) OVER ()),'Y') out_adj_column, st_display_decimals((SUM (SUM (neg_var_qty)) OVER ()),'Y') out_var_column, st_display_decimals((SUM (SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END)) OVER ()),'Y') out_mfg_column, st_display_decimals((SUM (SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END)) OVER ()),'Y') out_prod_column,          st_display_decimals((SUM (SUM (sal_qty)) OVER ()),'Y') out_sale_column,          st_display_decimals((SUM (SUM (cons_qty + sal_qty + srt_qty)) OVER ()),'Y') out_cons_column, st_display_decimals ((SUM (  SUM (grn_qty) + SUM (pos_adj_qty) + SUM (pos_var_qty) + SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END) + SUM (srt_qty) + SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END) ) OVER ()),'Y') total_total_inflow, st_display_decimals((SUM (  SUM (rtv_qty) + SUM (neg_adj_qty) + SUM (neg_var_qty) + SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END) + SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END) + SUM (sal_qty) ) OVER ()),'Y') total_total_outflow, st_display_decimals(((  SUM (grn_qty) + SUM (in_iss_qty + in_urg_qty) + SUM (in_ret_qty) + SUM (in_tfr_qty) + SUM (pos_adj_qty) + SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END) + SUM (srt_qty) + SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END) )),'Y') total_inflow_store, st_display_decimals(((  SUM (rtv_qty) + SUM (out_iss_qty_st + out_urg_qty_st) + SUM (out_iss_qty_ns + out_urg_qty_ns) + SUM (out_ret_qty_st) + SUM (out_ret_qty_ns) + SUM (out_tfr_qty) + SUM (neg_adj_qty) + SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END) + SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END) + SUM (sal_qty) )),'Y') total_outflow_store, st_display_decimals((SUM (  SUM (grn_qty) + SUM (in_iss_qty + in_urg_qty) + SUM (in_ret_qty) + SUM (in_tfr_qty) + SUM (pos_adj_qty) + SUM (CASE WHEN mfg_qty > 0 THEN mfg_qty ELSE 0 END) + SUM (srt_qty) + SUM (CASE WHEN prt_qty > 0 THEN prt_qty ELSE 0 END) ) OVER ()),'Y') total_total_inflow_store, st_display_decimals ((SUM (  SUM (rtv_qty) + SUM (out_iss_qty_st + out_urg_qty_st) + SUM (out_iss_qty_ns + out_urg_qty_ns) + SUM (out_ret_qty_st) + SUM (out_ret_qty_ns) + SUM (out_tfr_qty) + SUM (neg_adj_qty) + SUM (CASE WHEN mfg_qty < 0 THEN mfg_qty ELSE 0 END) + SUM (CASE WHEN prt_qty < 0 THEN prt_qty ELSE 0 END) + SUM (sal_qty) ) OVER ()),'Y') total_total_outflow_store, st_display_decimals((SUM (SUM (in_tfr_qty)) OVER ()),'Y') in_tfr_column, st_display_decimals ((SUM (SUM (in_iss_qty + in_urg_qty)) OVER ()),'Y') in_inv_iss_store_column,          st_display_decimals((SUM (SUM (in_ret_qty)) OVER ()),'Y') in_inv_ret_store_column, st_display_decimals((SUM (SUM (out_iss_qty_st + out_urg_qty_st)) OVER ()),'Y') out_inv_iss_store_column,          st_display_decimals((SUM (SUM (out_iss_qty_ns + out_urg_qty_ns)) OVER ()),'Y') out_ns_iss_store_column, st_display_decimals((SUM (SUM (out_ret_qty_st)) OVER ()),'Y') out_inv_ret_store_column, st_display_decimals((SUM (SUM (out_ret_qty_ns)) OVER ()),'Y') out_ns_ret_store_column, st_display_decimals((SUM (SUM (out_tfr_qty)) OVER ()),'Y') out_tfr_column FROM st_item_move_summ a, mm_item b    WHERE a.item_code = b.item_code AND (b.item_code = ? OR (? IS NULL AND b.item_class_code = ?) ) AND a.store_code = NVL (?, a.store_code) AND move_year * 100 + move_month BETWEEN ? AND ? AND a.facility_id = ? GROUP BY move_month, move_year ORDER BY orderbyperiod"; 			
			ArrayList alRecords	= fetchRecords(Sql, alParameters);
			/**END**/
			return alRecords;
			}
		else {
			//String sql="SELECT   MOVE_YEAR || TO_CHAR (MOVE_MONTH, '00') ORDERBYPERIOD,TO_CHAR (MOVE_MONTH, '00') || '/' || MOVE_YEAR PERIOD,DECODE (TRIM (TO_CHAR ((  SUM (MONTH_OPENING_VALUE)+ NVL (SUM (OBS_COST), 0)),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ((  SUM (MONTH_OPENING_VALUE)+ NVL (SUM (OBS_COST), 0)),'999,999,999,999,999,999,999.99'))) IN_OPEN_BAL,DECODE (TRIM (TO_CHAR (SUM (GRN_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (GRN_COST),'999,999,999,999,999,999,999.99'))) IN_GRN,DECODE (TRIM (TO_CHAR (SUM (POS_ADJ_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_ADJ_COST),'999,999,999,999,999,999,999.99'))) IN_ADJ,DECODE (TRIM (TO_CHAR (SUM (POS_VAR_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_VAR_COST),'999,999,999,999,999,999,999.99')))  IN_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END), '999,999,999,999,999,999,999.99' ) ),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END), '999,999,999,999,999,999,999.99' ) )) IN_MFG_REC,DECODE (TRIM (TO_CHAR (SUM (SRT_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (SRT_COST),'999,999,999,999,999,999,999.99'))) IN_SALE_RET,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END), '999,999,999,999,999,999,999.99' ) ))  IN_PROD,  DECODE (TRIM (TO_CHAR (SUM (RTV_COST), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (RTV_COST),'999,999,999,999,999,999,999.99'))) OUT_RTV, DECODE (TRIM (TO_CHAR (SUM (NEG_ADJ_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00', TRIM (TO_CHAR (SUM (NEG_ADJ_COST),'999,999,999,999,999,999,999.99')))OUT_ADJ,DECODE (TRIM (TO_CHAR (SUM (NEG_VAR_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (NEG_VAR_COST),'999,999,999,999,999,999,999.99')))OUT_VAR,DECODE (TRIM (TO_CHAR ( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END), '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END), '999,999,999,999,999,999,999.99')))OUT_MFG,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END), '999,999,999,999,999,999,999.99' ) ) ) OUT_PROD, DECODE (TRIM (TO_CHAR ( SUM (IN_TFR_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ( SUM (IN_TFR_COST),'999,999,999,999,999,999,999.99'))) IN_TFR,DECODE (TRIM (TO_CHAR (  SUM (SAL_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  SUM (SAL_COST),'999,999,999,999,999,999,999.99')))  OUT_SALE,DECODE (TRIM (TO_CHAR (  SUM (CONS_COST + SAL_COST + SRT_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  SUM (CONS_COST + SAL_COST + SRT_COST),'999,999,999,999,999,999,999.99')))  OUT_CONS,DECODE (TRIM (TO_CHAR (   SUM (MONTH_CLOSING_VALUE),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM (MONTH_CLOSING_VALUE),'999,999,999,999,999,999,999.99'))) OUT_CLOS_BAL,DECODE (TRIM (TO_CHAR (   SUM (IN_ISS_COST + IN_URG_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (    SUM (IN_ISS_COST + IN_URG_COST),'999,999,999,999,999,999,999.99'))) IN_INV_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (IN_RET_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (    SUM (IN_RET_COST),'999,999,999,999,999,999,999.99'))) IN__INV_RET_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST) ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST) ,'999,999,999,999,999,999,999.99'))) OUT_INV_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS) ,'999,999,999,999,999,999,999.99')))    OUT_NS_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_RET_COST_ST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (    SUM (OUT_RET_COST_ST) ,'999,999,999,999,999,999,999.99')))  OUT_INV_RET_STORE,DECODE (TRIM (TO_CHAR (   SUM (OUT_RET_COST_NS),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_RET_COST_NS) ,'999,999,999,999,999,999,999.99'))) OUT_NS_RET_STORE, DECODE (TRIM (TO_CHAR (  SUM (OUT_TFR_COST),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_TFR_COST) ,'999,999,999,999,999,999,999.99'))) OUT_TFR,DECODE (TRIM (TO_CHAR (  (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) ,'999,999,999,999,999,999,999.99'))) TOTAL_INFLOW,DECODE (TRIM (TO_CHAR ( (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)+ SUM (SAL_COST))  ,'999,999,999,999,999,999,999.99'))) TOTAL_OUTFLOW,DECODE (TRIM (TO_CHAR (  SUM( SUM (GRN_COST)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  SUM( SUM (GRN_COST)) OVER () ,'999,999,999,999,999,999,999.99'))) GRN_QTY_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (POS_ADJ_COST)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ( SUM( SUM (POS_ADJ_COST)) OVER () ,'999,999,999,999,999,999,999.99'))) POS_ADJ_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (POS_VAR_COST)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (POS_VAR_COST)) OVER () ,'999,999,999,999,999,999,999.99')))  POS_VAR_QTY_COLUMN,DECODE (TRIM (TO_CHAR (   SUM(SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END)) OVER (), '999,999,999,999,999,999,999.99' )),'.00', '0.00',TRIM (TO_CHAR (  SUM( SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END)) OVER () ,'999,999,999,999,999,999,999.99')))  MFG_QTY_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (SRT_COST)) OVER (),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR ( SUM( SUM (SRT_COST)) OVER () ,'999,999,999,999,999,999,999.99' )))  IN_SALE_RET_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END)) OVER () ,'999,999,999,999,999,999,999.99' )),'.00', '0.00',TRIM (TO_CHAR (  SUM(SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END)) OVER ()  , '999,999,999,999,999,999,999.99')))   IN_PROD_COLUMN,DECODE (TRIM (TO_CHAR (SUM(  SUM (RTV_COST)) OVER () ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (   SUM(SUM (RTV_COST)) OVER () ,'999,999,999,999,999,999,999.99')))  OUT_RTV_COLUMN,DECODE (TRIM (TO_CHAR (SUM(  SUM (NEG_ADJ_COST)) OVER () ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(  SUM (NEG_ADJ_COST)) OVER () ,'999,999,999,999,999,999,999.99'))) OUT_ADJ_COLUMN,DECODE (TRIM (TO_CHAR ( SUM(  SUM (NEG_VAR_COST)) OVER () ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM(  SUM (NEG_VAR_COST)) OVER () ,'999,999,999,999,999,999,999.99'))) OUT_VAR_COLUMN,DECODE (TRIM (TO_CHAR (SUM(   SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END)) OVER () , '999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END)) OVER () ,'999,999,999,999,999,999,999.99')))  OUT_MFG_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)) OVER () , '999,999,999,999,999,999,999.99' ) ),'.00', '0.00', TRIM (TO_CHAR (SUM(  SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)) OVER () , '999,999,999,999,999,999,999.99' ) ))  OUT_PROD_COLUMN, DECODE (TRIM (TO_CHAR (SUM(SUM (SAL_COST)) OVER () ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (SAL_COST)) OVER () ,'999,999,999,999,999,999,999.99')))  OUT_SALE_COLUMN,DECODE (TRIM (TO_CHAR ( SUM(  SUM (CONS_COST + SAL_COST + SRT_COST)) OVER () ,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  SUM(  SUM (CONS_COST + SAL_COST + SRT_COST)) OVER () ,'999,999,999,999,999,999,999.99'))) OUT_CONS_COLUMN,DECODE (TRIM (TO_CHAR (  SUM (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (   SUM (  SUM (GRN_COST) + SUM (POS_ADJ_COST) + SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE  WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , '999,999,999,999,999,999,999.99' ))) TOTAL_TOTAL_INFLOW,DECODE (TRIM (TO_CHAR (   SUM (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () , '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (    SUM (  SUM (RTV_COST) + SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST) + SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () ,'999,999,999,999,999,999,999.99'))) TOTAL_TOTAL_OUTFLOW FROM ST_ITEM_MOVE_SUMM A, MM_ITEM B   WHERE A.ITEM_CODE = B.ITEM_CODE AND (   B.ITEM_CODE = ? OR (? IS NULL AND B.ITEM_CLASS_CODE = ?) ) AND A.STORE_CODE = NVL (?, A.STORE_CODE) AND MOVE_YEAR * 100 + MOVE_MONTH BETWEEN ? AND ? AND A.FACILITY_ID = ? GROUP BY MOVE_MONTH, MOVE_YEAR ORDER BY ORDERBYPERIOD ";
			String sql="SELECT   MOVE_YEAR || TO_CHAR (MOVE_MONTH, '00') ORDERBYPERIOD,TO_CHAR (MOVE_MONTH, '00') || '/' || MOVE_YEAR PERIOD,DECODE (TRIM (TO_CHAR ((  SUM (MONTH_OPENING_VALUE)+ NVL (SUM (OBS_COST), 0)),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ((  SUM (MONTH_OPENING_VALUE)+ NVL (SUM (OBS_COST), 0)),'REPLACE_CHAR'))) IN_OPEN_BAL,DECODE (TRIM (TO_CHAR (SUM (GRN_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (GRN_COST),'REPLACE_CHAR'))) IN_GRN,DECODE (TRIM (TO_CHAR (SUM (POS_ADJ_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_ADJ_COST),'REPLACE_CHAR'))) IN_ADJ,DECODE (TRIM (TO_CHAR (SUM (POS_VAR_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (POS_VAR_COST),'REPLACE_CHAR')))  IN_VAR,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END), 'REPLACE_CHAR' ) ),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END), 'REPLACE_CHAR' ) )) IN_MFG_REC,DECODE (TRIM (TO_CHAR (SUM (SRT_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (SRT_COST),'REPLACE_CHAR'))) IN_SALE_RET,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END), 'REPLACE_CHAR' ) ))  IN_PROD,  DECODE (TRIM (TO_CHAR (SUM (RTV_COST), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (RTV_COST),'REPLACE_CHAR'))) OUT_RTV, DECODE (TRIM (TO_CHAR (SUM (NEG_ADJ_COST),'REPLACE_CHAR')),'.00', '0.00', TRIM (TO_CHAR (SUM (NEG_ADJ_COST),'REPLACE_CHAR')))OUT_ADJ,DECODE (TRIM (TO_CHAR (SUM (NEG_VAR_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (NEG_VAR_COST),'REPLACE_CHAR')))OUT_VAR,DECODE (TRIM (TO_CHAR ( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END), 'REPLACE_CHAR')))OUT_MFG,DECODE (TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END), 'REPLACE_CHAR' ) ) ) OUT_PROD, DECODE (TRIM (TO_CHAR ( SUM (IN_TFR_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( SUM (IN_TFR_COST),'REPLACE_CHAR'))) IN_TFR,DECODE (TRIM (TO_CHAR (  SUM (SAL_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  SUM (SAL_COST),'REPLACE_CHAR')))  OUT_SALE,DECODE (TRIM (TO_CHAR (  SUM (CONS_COST + SAL_COST + SRT_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  SUM (CONS_COST + SAL_COST + SRT_COST),'REPLACE_CHAR')))  OUT_CONS,DECODE (TRIM (TO_CHAR (   SUM (MONTH_CLOSING_VALUE),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM (MONTH_CLOSING_VALUE),'REPLACE_CHAR'))) OUT_CLOS_BAL,DECODE (TRIM (TO_CHAR (   SUM (IN_ISS_COST + IN_URG_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (    SUM (IN_ISS_COST + IN_URG_COST),'REPLACE_CHAR'))) IN_INV_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (IN_RET_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (    SUM (IN_RET_COST),'REPLACE_CHAR'))) IN_INV_RET_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST) ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST) ,'REPLACE_CHAR'))) OUT_INV_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS) ,'REPLACE_CHAR')))    OUT_NS_ISS_STORE,DECODE (TRIM (TO_CHAR (    SUM (OUT_RET_COST_ST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (    SUM (OUT_RET_COST_ST) ,'REPLACE_CHAR')))  OUT_INV_RET_STORE,DECODE (TRIM (TO_CHAR (   SUM (OUT_RET_COST_NS),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_RET_COST_NS) ,'REPLACE_CHAR'))) OUT_NS_RET_STORE, DECODE (TRIM (TO_CHAR (  SUM (OUT_TFR_COST),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM (OUT_TFR_COST) ,'REPLACE_CHAR'))) OUT_TFR,DECODE (TRIM (TO_CHAR (  (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) ,'REPLACE_CHAR'))) TOTAL_INFLOW,DECODE (TRIM (TO_CHAR ( (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)+ SUM (SAL_COST))  ,'REPLACE_CHAR'))) TOTAL_OUTFLOW, DECODE (TRIM (TO_CHAR (  SUM( SUM (GRN_COST)) OVER (),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  SUM( SUM (GRN_COST)) OVER () ,'REPLACE_CHAR'))) GRN_QTY_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (POS_ADJ_COST)) OVER (),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( SUM( SUM (POS_ADJ_COST)) OVER () ,'REPLACE_CHAR'))) POS_ADJ_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (POS_VAR_COST)) OVER (),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (POS_VAR_COST)) OVER () ,'REPLACE_CHAR')))  POS_VAR_QTY_COLUMN,DECODE (TRIM (TO_CHAR (   SUM(SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END)) OVER (), 'REPLACE_CHAR' )),'.00', '0.00',TRIM (TO_CHAR (  SUM( SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END)) OVER () ,'REPLACE_CHAR')))  MFG_QTY_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (SRT_COST)) OVER (),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( SUM( SUM (SRT_COST)) OVER () ,'REPLACE_CHAR' )))  IN_SALE_RET_COLUMN,DECODE (TRIM (TO_CHAR ( SUM( SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END)) OVER () ,'REPLACE_CHAR' )),'.00', '0.00',TRIM (TO_CHAR (  SUM(SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END)) OVER ()  , 'REPLACE_CHAR')))   IN_PROD_COLUMN,DECODE (TRIM (TO_CHAR (SUM(  SUM (RTV_COST)) OVER () ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (   SUM(SUM (RTV_COST)) OVER () ,'REPLACE_CHAR')))  OUT_RTV_COLUMN,DECODE (TRIM (TO_CHAR (SUM(  SUM (NEG_ADJ_COST)) OVER () ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(  SUM (NEG_ADJ_COST)) OVER () ,'REPLACE_CHAR'))) OUT_ADJ_COLUMN,DECODE (TRIM (TO_CHAR ( SUM(  SUM (NEG_VAR_COST)) OVER () ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(  SUM (NEG_VAR_COST)) OVER () ,'REPLACE_CHAR'))) OUT_VAR_COLUMN,DECODE (TRIM (TO_CHAR (SUM(   SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END)) OVER () , 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END)) OVER () ,'REPLACE_CHAR')))  OUT_MFG_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)) OVER () , 'REPLACE_CHAR' ) ),'.00', '0.00', TRIM (TO_CHAR (SUM(  SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)) OVER () , 'REPLACE_CHAR' ) ))  OUT_PROD_COLUMN, DECODE (TRIM (TO_CHAR (SUM(SUM (SAL_COST)) OVER () ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM( SUM (SAL_COST)) OVER () ,'REPLACE_CHAR')))  OUT_SALE_COLUMN,DECODE (TRIM (TO_CHAR ( SUM(  SUM (CONS_COST + SAL_COST + SRT_COST)) OVER () ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  SUM(  SUM (CONS_COST + SAL_COST + SRT_COST)) OVER () ,'REPLACE_CHAR'))) OUT_CONS_COLUMN,DECODE (TRIM (TO_CHAR (  SUM (  SUM (GRN_COST)+ SUM (POS_ADJ_COST)+ SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , 'REPLACE_CHAR' ) ), '.00', '0.00', TRIM (TO_CHAR (   SUM (  SUM (GRN_COST) + SUM (POS_ADJ_COST) + SUM (POS_VAR_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE  WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , 'REPLACE_CHAR' ))) TOTAL_TOTAL_INFLOW,DECODE (TRIM (TO_CHAR (   SUM (  SUM (RTV_COST)+ SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () , 'REPLACE_CHAR' ) ), '.00', '0.00', TRIM (TO_CHAR (    SUM (  SUM (RTV_COST) + SUM (NEG_ADJ_COST)+ SUM (NEG_VAR_COST) + SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () ,'REPLACE_CHAR'))) TOTAL_TOTAL_OUTFLOW,DECODE (TRIM (TO_CHAR (  (  SUM (GRN_COST) + SUM (IN_ISS_COST + IN_URG_COST)+ SUM (IN_RET_COST)+ SUM (IN_TFR_COST)+ SUM (POS_ADJ_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (  (  SUM (GRN_COST) + SUM (IN_ISS_COST + IN_URG_COST)+ SUM (IN_RET_COST)+ SUM (IN_TFR_COST)+ SUM (POS_ADJ_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) ,'REPLACE_CHAR'))) TOTAL_INFLOW_STORE,	DECODE (TRIM (TO_CHAR ( (  SUM (RTV_COST) + SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)+ SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)+ SUM (OUT_RET_COST_ST)+ SUM (OUT_RET_COST_NS)+ SUM (OUT_TFR_COST)+ SUM (NEG_ADJ_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) ,'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR ( (  SUM (RTV_COST) + SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)+ SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)+ SUM (OUT_RET_COST_ST)+ SUM (OUT_RET_COST_NS)+ SUM (OUT_TFR_COST)+ SUM (NEG_ADJ_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END)+ SUM (SAL_COST))  ,'REPLACE_CHAR'))) TOTAL_OUTFLOW_STORE,	DECODE (TRIM (TO_CHAR (  SUM (  SUM (GRN_COST) + SUM (IN_ISS_COST + IN_URG_COST)+ SUM (IN_RET_COST)+ SUM (IN_TFR_COST)+ SUM (POS_ADJ_COST)+ SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , 'REPLACE_CHAR' ) ), '.00', '0.00', TRIM (TO_CHAR (   SUM (  SUM (GRN_COST)  + SUM (IN_ISS_COST + IN_URG_COST)+ SUM (IN_RET_COST)+ SUM (IN_TFR_COST)+ SUM (POS_ADJ_COST) + SUM (CASE WHEN MFG_COST > 0 THEN MFG_COST ELSE 0 END) + SUM (SRT_COST) + SUM (CASE  WHEN PRT_COST > 0 THEN PRT_COST ELSE 0 END) ) OVER () , 'REPLACE_CHAR' ))) TOTAL_TOTAL_INFLOW_STORE,DECODE (TRIM (TO_CHAR (   SUM (  SUM (RTV_COST) + SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)+ SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)+ SUM (OUT_RET_COST_ST)+ SUM (OUT_RET_COST_NS)+ SUM (OUT_TFR_COST)+ SUM (NEG_ADJ_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () , 'REPLACE_CHAR' ) ), '.00', '0.00', TRIM (TO_CHAR (    SUM (  SUM (RTV_COST) + SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)+ SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)+ SUM (OUT_RET_COST_ST)+ SUM (OUT_RET_COST_NS)+ SUM (OUT_TFR_COST) + SUM (NEG_ADJ_COST)+ SUM (CASE WHEN MFG_COST < 0 THEN MFG_COST ELSE 0 END) + SUM (CASE WHEN PRT_COST < 0 THEN PRT_COST ELSE 0 END) + SUM (SAL_COST) ) OVER () ,'REPLACE_CHAR'))) TOTAL_TOTAL_OUTFLOW_STORE,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_TFR_COST)) OVER(), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM (SUM(IN_TFR_COST)) OVER(), 'REPLACE_CHAR'))) IN_TFR_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_ISS_COST + IN_URG_COST)) OVER(), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (IN_ISS_COST + IN_URG_COST)) OVER (), 'REPLACE_CHAR'))) IN_INV_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (IN_RET_COST)) OVER (), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (IN_RET_COST)) OVER (), 'REPLACE_CHAR'))) IN_INV_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)) OVER(),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (OUT_ISS_COST_ST + OUT_URG_COST_ST)) OVER (),'REPLACE_CHAR'))) OUT_INV_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)) OVER(),'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (OUT_ISS_COST_NS + OUT_URG_COST_NS)) OVER (),'REPLACE_CHAR'))) OUT_NS_ISS_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_RET_COST_ST)) OVER(), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (OUT_RET_COST_ST)) OVER(), 'REPLACE_CHAR'))) OUT_INV_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_RET_COST_NS)) OVER(), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (OUT_RET_COST_NS)) OVER(), 'REPLACE_CHAR'))) OUT_NS_RET_STORE_COLUMN,DECODE (TRIM (TO_CHAR (SUM(SUM (OUT_TFR_COST)) OVER(), 'REPLACE_CHAR')),'.00', '0.00',TRIM (TO_CHAR (SUM(SUM (OUT_TFR_COST)) OVER(), 'REPLACE_CHAR'))) OUT_TFR_COLUMN FROM ST_ITEM_MOVE_SUMM A, MM_ITEM B   WHERE A.ITEM_CODE = B.ITEM_CODE AND (   B.ITEM_CODE = ? OR (? IS NULL AND B.ITEM_CLASS_CODE = ?) ) AND A.STORE_CODE = NVL (?, A.STORE_CODE) AND MOVE_YEAR * 100 + MOVE_MONTH BETWEEN ? AND ? AND A.FACILITY_ID = ? GROUP BY MOVE_MONTH, MOVE_YEAR ORDER BY ORDERBYPERIOD ";
			ArrayList alRecords_value = fetchRecords(sql.replaceAll("REPLACE_CHAR","999,999,999,999,999,999,999.99"), alParameters);
			return alRecords_value;
			}
		}
		else
		{
			ArrayList alParameters_detail=new ArrayList();
		if(from.equals("0") && to.equals("0"))
		{
				from = "190001";
				to = "999912";
		}
		if(from.equals("0"))
		{
				from = "190001";
		}
		if(to.equals("0"))
		{
				to = "999912";
		}
			alParameters_detail.add(this.from);
			alParameters_detail.add(this.to);
			alParameters_detail.add(this.item_code);
			alParameters_detail.add(this.store_code);
			alParameters_detail.add(this.trn_code);
			alParameters_detail.add(this.trn_code);
			alParameters_detail.add(this.stock_item);
			alParameters_detail.add(this.stock_item);
			
		//ArrayList alRecords	= fetchRecords(getStRepositoryValue("SQL_ST_ITEM_MOVEMENT_DETAIL"), alParameters_detail);
		  //the above query is modified from doc_Date to posted_Date  by Ganga Tuesday, August 14, 2012 for Medicity - Since repository is old query modiied in bean

		  String dtlsql = "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,a.supp_code supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn ";
			
		  ArrayList alRecords	= fetchRecords(dtlsql, alParameters_detail);

			
		return alRecords;
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return null;
	}

	public void load_month_closing_qty()
	{
	try{
		ArrayList alParameters_close=new ArrayList();
		alParameters_close.add(this.to);
		alParameters_close.add(this.item_code);
		alParameters_close.add(this.store_code);
		alParameters_close.add(getLoginFacilityId());
		HashMap hmClosing = null;
		//String Sql="SELECT  DECODE (TRIM (TO_CHAR (MONTH_CLOSING_QTY,'REPLACE_CHAR')),'', '',TRIM (TO_CHAR (MONTH_CLOSING_QTY,'REPLACE_CHAR'))) MONTH_CLOSING_QTY FROM ST_ITEM_MOVE_SUMM WHERE move_year *100 + move_month =?  AND ITEM_CODE=? AND STORE_CODE=? and FACILITY_ID=? "; // Commented for ML-BRU-SCF-1815
		String Sql = "SELECT month_closing_qty FROM st_item_move_summ WHERE move_year * 100 + move_month = ? AND item_code = ? AND store_code = ? AND facility_id = ?";
		/**
					* @Name - krishna
					* @Date - 24/12/2009
					* @Inc# - CRF537.1
					* @Desc - No of decimal positions
		*/
		//String openingbalance=String.valueOf(Double.parseDouble(checkForNull((String)fetchRecord("select month_opening_qty FROM st_item_move_summ WHERE move_year * 100 + move_month = '201901' AND item_code = 'ACA123' AND store_code = 'RPAEPH' AND facility_id = 'RP'").get("MONTH_OPENING_QTY"),"0")));
		//System.out.println("openingbalance>>>" + openingbalance);
		// Commented for ML-BRU-SCF-1815 start
		/*int no_of_decimals=Integer.parseInt(checkForNull((String)fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("NO_OF_DECIMALS"),"0"));
			String format_string="999,999,999,999,999,999,999.99";
			if(no_of_decimals==1 ){
				format_string="999,999,999,999,999,999,999.9";
			}else if(no_of_decimals==3 ){
				format_string="999,999,999,999,999,999,999.999";
			}else if(no_of_decimals==4 ){
				format_string="999,999,999,999,999,999,999.9999";
			}
			
		hmClosing = fetchRecord(Sql.replaceAll("REPLACE_CHAR",format_string), alParameters_close); */
		// Commented for ML-BRU-SCF-1815 end
		hmClosing = fetchRecord(Sql, alParameters_close);
		month_closing_qty=(String)hmClosing.get("MONTH_CLOSING_QTY");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void load_month_opening_qty()
	{
	try{
		ArrayList alParameters_open=new ArrayList();
		alParameters_open.add(this.from);
		alParameters_open.add(this.item_code);
		alParameters_open.add(this.store_code);
		alParameters_open.add(getLoginFacilityId());
		HashMap hmOpening = null;
		//String Sql="SELECT    DECODE (TRIM (TO_CHAR (MONTH_OPENING_QTY,'REPLACE_CHAR') ),'', '',TRIM (TO_CHAR (MONTH_OPENING_QTY,'REPLACE_CHAR'))) MONTH_OPENING_QTY FROM ST_ITEM_MOVE_SUMM WHERE move_year *100 + move_month =? AND ITEM_CODE=? AND STORE_CODE=? and FACILITY_ID=?"; // Commented for ML-BRU-SCF-1815
		String Sql = "SELECT month_opening_qty FROM st_item_move_summ WHERE move_year * 100 + move_month = ? AND item_code = ? AND store_code = ? AND facility_id = ?";
		/**
					* @Name - krishna
					* @Date - 24/12/2009
					* @Inc# - CRF537.1
					* @Desc - No of decimal positions
		*/
		// Commented for ML-BRU-SCF-1815 start
		/*int no_of_decimals=Integer.parseInt(checkForNull((String)fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("NO_OF_DECIMALS"),"0"));
			String format_string="999,999,999,999,999,999,999.99";
			if(no_of_decimals==1 ){
				format_string="999,999,999,999,999,999,999.9";
			}else if(no_of_decimals==3 ){
				format_string="999,999,999,999,999,999,999.999";
			}else if(no_of_decimals==4 ){
				format_string="999,999,999,999,999,999,999.9999";
			}
			
		hmOpening = fetchRecord(Sql.replaceAll("REPLACE_CHAR",format_string), alParameters_open); */
		// Commented for ML-BRU-SCF-1815 end
		hmOpening = fetchRecord(Sql, alParameters_open);

		

		month_opening_qty=(String)hmOpening.get("MONTH_OPENING_QTY");
		}
		catch(Exception e){
e.printStackTrace();
		}
	
	}
	
	public void clear()
	{
	this.month_closing_qty="";
	this.month_opening_qty="";
	this.query_type="";
	this.result_criteria="";
	this.store_code="";
	this.item_code="";
	this.item_class="";
	this.from="";
	this.to="";
	}
}
