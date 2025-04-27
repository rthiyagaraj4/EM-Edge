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
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
06/03/2015	IN054317		VijayakumarK	06/03/2015							CRF-SS- AAKH-CRF-0057.2 /02 - Issues in
																				Reprint document [IN:054317]
-------------------------------------------------------------------------------------------------------------------------------
*/
package eSS;

import eCommon.Common.CommonAdapter;
import eSS.Common.SsTransaction;
import eSS.Common.SsRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class RePrintDocReportBean extends SsTransaction
implements Serializable
{
	public ArrayList getResult(String trn_type,String doc_type_code, String fr_st_code, String dt_from,String dt_to,String doc_no)   throws Exception
	{
		System.out.print("in bean ");
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		ArrayList record = new ArrayList();
		ArrayList result	=	new ArrayList();
		String sql	= "";
		try
		{
			connection = getConnection();


			if(trn_type.equals("REQ")) {

				System.out.print("in bean in RET");
				sql = SsRepository.getSsKeyValue("SQL_SS_TRANS_SUMM_REQ_REPORT");

				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1,login_facility_id);
				preparedstatement.setString(2,doc_type_code);
				preparedstatement.setString(3,doc_no);
				preparedstatement.setString(4,fr_st_code);
				//IN054317 starts
				//preparedstatement.setString(5,fr_st_code); commented to avoid passing parameter to req_on_store_code
				//preparedstatement.setString(6,dt_from);
				//preparedstatement.setString(7,dt_to);
				//preparedstatement.setString(8,getLanguageId());
				preparedstatement.setString(5,dt_from);
				preparedstatement.setString(6,dt_to);
				preparedstatement.setString(7,getLanguageId());
				//IN054317 ends

				resultset = preparedstatement.executeQuery();

				while(resultset!=null && resultset.next()) {
					record	=	new ArrayList();

					String	p_doc_type_code	=resultset.getString("doc_type_code");
					String	p_doc_type_desc	=resultset.getString("doc_type_desc");
					String	p_doc_no			=resultset.getString("doc_no");
					String	p_doc_date		=resultset.getString("doc_date");
					String	p_doc_ref			=resultset.getString("doc_ref");
					String	p_fm_store_code	=resultset.getString("req_by_store_code");
					String	p_fm_store_desc	=resultset.getString("req_by_store_desc");
					String	p_to_store_code	=resultset.getString("req_on_store_code");
					String	p_to_store_desc	=resultset.getString("req_on_store_desc");

					record.add(p_doc_type_code);
					record.add(p_doc_type_desc);
					record.add(p_doc_no);
					record.add(p_doc_date);
					record.add(p_doc_ref);
					record.add(p_fm_store_code);
					record.add(p_fm_store_desc);
					record.add(p_to_store_code);
					record.add(p_to_store_desc);

					result.add(record);
				}
			}


			else if(trn_type.equals("RTG")) {
				sql = SsRepository.getSsKeyValue("SQL_SS_TRANS_SUMM_RGT_REPORT");
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1,login_facility_id);
				preparedstatement.setString(2,doc_type_code);
				preparedstatement.setString(3,doc_no);
				preparedstatement.setString(4,fr_st_code);
				//IN054317 starts
				/*preparedstatement.setString(5,fr_st_code);
				preparedstatement.setString(6,dt_from);
				preparedstatement.setString(7,dt_to);
				preparedstatement.setString(8,getLanguageId());*/
				preparedstatement.setString(5,dt_from);
				preparedstatement.setString(6,dt_to);
				preparedstatement.setString(7,getLanguageId());

				resultset = preparedstatement.executeQuery();
				System.out.print("in bean in RTG");

				while(resultset!=null && resultset.next()) {
					record	=	new ArrayList();

					String	p_doc_type_code	=resultset.getString("doc_type_code");
					String	p_doc_type_desc	=resultset.getString("doc_type_desc");
					String	p_doc_no			=resultset.getString("doc_no");
					String	p_doc_date		=resultset.getString("doc_date");
					String	p_doc_ref			=resultset.getString("doc_ref");
					String	p_fm_store_code	=resultset.getString("fr_store_code");
					String	p_fm_store_desc	=resultset.getString("fr_store_desc");
					String	p_to_store_code	=resultset.getString("to_store_code");
					String	p_to_store_desc	=resultset.getString("to_store_desc");

					record.add(p_doc_type_code);
					record.add(p_doc_type_desc);
					record.add(p_doc_no);
					record.add(p_doc_date);
					record.add(p_doc_ref);
					record.add(p_fm_store_code);
					record.add(p_fm_store_desc);
					record.add(p_to_store_code);
					record.add(p_to_store_desc);

					result.add(record);
				}
			}



		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw exception;
		}
		finally
		{
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception exception2)
			{
				exception2.printStackTrace();
			}
		}
		return result;
	}


	String p_trn_type;
	String doc_type;

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	public String getp_trn_type() {
		return p_trn_type;
	}

	public void setp_trn_type(String p_trn_type) {
		this.p_trn_type =checkForNull( p_trn_type);
	}

	public String getTransction_code_List()
	{
		String optionValues = null;
		ArrayList alOptionValues = new ArrayList(); 	
		alOptionValues = getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRANSACTION_SELECT_LIST"));
		//alOptionValues.remove(0);
		//IN054317 starts
		//optionValues = getListOptionTag(alOptionValues);
		optionValues = getListOptionTag(alOptionValues,"REQ");
		//IN054317 ends
		return optionValues;


	}

	public String getTransctionTypeList(String trnType){
		String optionValues = null;
		ArrayList alOptionValues = new ArrayList(); 	
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(trnType);
		alParam.add(getLanguageId());
		//alOptionValues = getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRANSACTION_SELECT_LIST"));
		alOptionValues = getListOptionArrayList("select a.doc_type_code,b.short_desc from ss_trn_doc_type a, sy_doc_type_master_lang_vw b  where a.doc_type_code= b.doc_type_code and a.trn_type =?  AND b.language_id=?", alParam);
		alOptionValues.remove(0);
		optionValues = getListOptionTag(alOptionValues);
		return optionValues;
	}

}
