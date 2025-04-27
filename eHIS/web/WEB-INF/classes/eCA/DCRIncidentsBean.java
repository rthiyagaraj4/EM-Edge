/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import webbeans.eCommon.ConnectionManager;

public class DCRIncidentsBean implements java.io.Serializable
{
	private CommonCollectionUtils<String, HashMap<String, String>> incident = null;
	private CommonCollectionUtils<String, CommonCollectionUtils> incdDtl = null;
	private CommonCollectionUtils<String, CommonCollectionUtils> indexConsDlt = null;
	private CommonCollectionUtils<String, HashMap> dcrData = null;
	private CommonCollectionUtils<String, HashMap<String, HashMap<String, String>>> indConsData = null;
	private CommonCollectionUtils<String, CommonCollectionUtils<String, HashMap<String, HashMap<String, String>>>> keyData = null;
	private HashMap<String,HashMap<String,HashMap<String,HashMap<String,String>>>> table= null;
	private HashMap<String,HashMap<String,String>> sequence = null;
	private HashMap<String, HashMap<String, String>> index = null;
	private HashMap<String, HashMap<String, String>> constraint = null;
	private Properties userInfo = null;

	public DCRIncidentsBean()
	{
		incdDtl = new CommonCollectionUtils<String, CommonCollectionUtils>();
		incident = new CommonCollectionUtils<String, HashMap<String, String>>();
		table = new HashMap<String,HashMap<String,HashMap<String,HashMap<String,String>>>>();
		sequence = new HashMap<String, HashMap<String,String>>();
		indexConsDlt = new CommonCollectionUtils<String, CommonCollectionUtils>();
		index = new HashMap<String,HashMap<String,String>>();
		constraint = new HashMap<String,HashMap<String,String>>();
	}

	private void setIndex(String key, HashMap<String,String> map)
	{
		index.put(key, map);
	}

	public  HashMap<String,String> getIndex(String incdRefNo, String tblName, String indexName)
	{
		
		Set<String> keySet = index.keySet();
		for(String key : keySet)
		{
			String []str = key.split("`~");
			if(str != null)
			{
				if(str[0].equals(incdRefNo) && str[1].equals(tblName) && str[2].equals(indexName))
				{
					return index.get(key);
				}
			}
		}
		return null;
	}

	private void setConstraint(String key, HashMap<String,String> map)
	{
		constraint.put(key, map);
	}

	public  HashMap<String,String> getConstraint(String incdRefNo, String tblName, String indexName)
	{
		
		Set<String> keySet = constraint.keySet();
		for(String key : keySet)
		{
			String []str = key.split("`~");
			if(str != null)
			{
				if(str[0].equals(incdRefNo) && str[1].equals(tblName) && str[2].equals(indexName))
				{
					return constraint.get(key);
				}
			}
		}
		return null;
	}

	public boolean processReq(String action, String incdRefNo, HashMap map)
	{
		if(map != null && !incdRefNo.equals("") && !action.equals(""))
		{
			if(action.equals("INCD")){
				return setIncidentValues(incdRefNo, map);
			}
			else{
				return setTabelData(incdRefNo, action, map);
			}
		}
		return false;

	}

	public CommonCollectionUtils<String, CommonCollectionUtils>  getIndexesOrConstraints()
	{
		return indexConsDlt;
	}

	public void setIndexesOrConstraints(String incdRefNo, String action, String keyName, HashMap<String, HashMap<String, String>> map)
	{
		Set<String> keySet = map.keySet();
		CommonCollectionUtils  []ccUtils = indexConsDlt.getByKey(incdRefNo);
		boolean beanContains = false;

		if(ccUtils != null)
		{
			for(int i = 0; i < ccUtils.length; i++)
			{
				CommonCollectionUtils []indexCons = (CommonCollectionUtils[]) ccUtils[i].getByKey(action);
				
				if( indexCons != null)
				{
					//List<String> tblNames = null;
					
					for(int k =0; k < indexCons.length; k++)
					{
						HashMap<String, HashMap<String, String>> []indCons = (HashMap[]) indexCons[k].getByKey(keyName);

						if(indCons != null)
						{
							
							
							for(int j = 0; j < indCons.length; j++)
							{
								HashMap<String, HashMap<String, String>> hMap = (HashMap<String, HashMap<String, String>>) indCons[k];
								for(String indConsKey : keySet)
								{
									beanContains =  true;
									if(action.equals("CONSTRAINT"))
									{
										Set<String> tblNameSet = map.keySet();
										for(String str :tblNameSet){
											String key = incdRefNo+"`~"+keyName+"`~"+str;
											setConstraint(key, map.get(str));
										}
									}
									else if(action.equals("INDEX"))
									{
										Set<String> tblNameSet = map.keySet();
										for(String str :tblNameSet){
											String key = incdRefNo+"`~"+keyName+"`~"+str;
											setIndex(key, map.get(str));
										}
									}
									hMap.put(indConsKey, map.get(indConsKey));
								}
							}
						}
						else
						{
							
							beanContains = true;
							if(action.equals("CONSTRAINT"))
							{
								Set<String> tblNameSet = map.keySet();
								for(String str :tblNameSet){
									String key = incdRefNo+"`~"+keyName+"`~"+str;
									setConstraint(key, map.get(str));
								}
							}
							else if(action.equals("INDEX"))
							{
								Set<String> tblNameSet = map.keySet();
								for(String str :tblNameSet){
									String key = incdRefNo+"`~"+keyName+"`~"+str;
									setIndex(key, map.get(str));
								}
							}
							indexCons[k].add(keyName, map);
						}

					}
				}
			}
		}
		
		if(!beanContains)
		{
			if(action.equals("CONSTRAINT"))
			{
				Set<String> tblNameSet = map.keySet();
				for(String str :tblNameSet){
					String key = incdRefNo+"`~"+keyName+"`~"+str;
					setConstraint(key, map.get(str));
				}
			}
			else if(action.equals("INDEX"))
			{
				Set<String> tblNameSet = map.keySet();
				for(String str :tblNameSet){
					String key = incdRefNo+"`~"+keyName+"`~"+str;
					setIndex(key, map.get(str));
				}
			}
			keyData = new  CommonCollectionUtils<String, CommonCollectionUtils<String,HashMap<String,HashMap<String,String>>>>();
			indConsData = new CommonCollectionUtils<String, HashMap<String, HashMap<String, String>>>();
			indConsData.add(keyName, map);
			keyData.add(action, indConsData);
			indexConsDlt.add(incdRefNo, keyData);
		}
	   
	}

	private boolean setTabelData(String incdRefNo, String action, HashMap map)
	{
		Set<String> keySet = map.keySet();
		boolean isBeanContain = false;
		CommonCollectionUtils []beanDCRData = incdDtl.getByKey(incdRefNo);

		if(beanDCRData != null)
		{
			for(int i = 0;i < beanDCRData.length;i++ )
			{
				HashMap []beanTbls = (HashMap[]) beanDCRData[i].getByKey(action);
				if(beanTbls != null)
				{
					for (int j = 0;j < beanTbls.length;j++ )
					{
						HashMap beanTblMap = (HashMap) beanTbls[j];
						
						for(String key: keySet)
						{
							
							
							if(beanTblMap.containsKey(key))
							{
								if(action.equals("TABLE")){
									String str = incdRefNo+"`~"+key;
									setTable(str, (HashMap<String,HashMap<String,HashMap<String,String>>>)map.get(key));
								}
								else if(action.equals("SEQUENCE")){
									String str = incdRefNo+"`~"+key;
									setSequence(str, (HashMap<String, String>)map.get(key));
								}
								beanTblMap.put(key, map.get(key));
								isBeanContain = true;
								break;
							}
						}
					}
				}
			}
		}

		if(!isBeanContain)
		{
			if(beanDCRData == null)
			{

				if(action.equals("TABLE")){
					Set<String> tblNameSet = map.keySet();
					for(String str :tblNameSet){
						String key = incdRefNo+"`~"+str;
						setTable(key, map);
					}
				}
				else if(action.equals("SEQUENCE"))
				{
					Set<String> tblNameSet = map.keySet();
					
					
					for(String str :tblNameSet){
						String key = incdRefNo+"`~"+str;
						setSequence(key, (HashMap<String, String>)map.get(str));
					}
				}
				dcrData = new CommonCollectionUtils<String, HashMap>();
				dcrData.add(action, map);
				incdDtl.add(incdRefNo, dcrData);
			}
			else
			{
				if(action.equals("TABLE")){
					Set<String> tblNameSet = map.keySet();
					for(String str :tblNameSet){
						String key = incdRefNo+"`~"+str;
						setTable(key, map);
					}
				}
				else if(action.equals("SEQUENCE"))
				{
					Set<String> tblNameSet = map.keySet();
					
					
					for(String str :tblNameSet){
						String key = incdRefNo+"`~"+str;
						setSequence(key, (HashMap<String, String>)map.get(str));
					}
				}
				incdDtl.get(incdRefNo).add(action, map);
			}

		}
		
		return true;

	}

	private void setSequence(String key, HashMap<String,String> map)
	{
		sequence.put(key, map);
	}

	public HashMap<String,String> getSequence(String incdRefNo, String sequenceName)
	{
		
		Set<String> tblKeySet = sequence.keySet();
		for(String tblStr : tblKeySet){
			String []str = tblStr.split("`~");
			if(str[0].equals(incdRefNo) && str[1].equals(sequenceName))
			{
				return sequence.get(tblStr);
			}
		}
		return null;
	}

	public HashMap<String,HashMap<String,HashMap<String,String>>>  getTable(String incdRef, String tblName)
	{
		
		Set<String> tblKeySet = table.keySet();
		for(String tblStr : tblKeySet){
			String []str = tblStr.split("`~");
			if(str[0].equals(incdRef) && str[1].equals(tblName))
			{
				return table.get(tblStr);
			}
		}
		return null;
	}
	private void setTable(String key, HashMap<String,HashMap<String,HashMap<String,String>>> beanTable)
	{
		table.put(key, beanTable);
		
	}

	public CommonCollectionUtils getIncidentDetails()
	{
		return  incdDtl;
	}

	private boolean setIncidentValues(String incdRefNo, HashMap<String, String> map)
	{
		if(!incident.containsKey(incdRefNo))
		{
			incident.add(incdRefNo, map);
			return  true;
		}
		else
		{
			CommonCollectionUtils<String, HashMap<String, String>> clone = (CommonCollectionUtils) incident.clone();
			List<String> keys = clone.keyList();
			incident.clear();

			for(String str: keys)
			{
				if(str.equals(incdRefNo))
				{
					incident.add(str, map);
				}
				else
				{
					incident.add(str, clone.get(str));
				}
			}

			//incident.removeKey(incdRefNo);
			//incident.add(incdRefNo, map);
			return  true;
		}
	}

	public void getDCRData(){
		
		List<String> incList = incdDtl.keyList();
		for (String incdKeys : incList)
		{
			CommonCollectionUtils collectionUtils = incdDtl.get(incdKeys);
			/*List<String> tblList = collectionUtils.keyList();
			for (String tblKeys : tblList)
			{
				if (tblKeys.equals("TABLE"))
				{
					processTableData((HashMap)collectionUtils.get(tblKeys));
				}else if (tblKeys.equals("INDEX")){

				}else if (tblKeys.equals("SEQUENCE")){

				}else if (tblKeys.equals("CONSTRAINT")){

				}else if (tblKeys.equals("GEN SCRIPTS")){

				}

			}*/
			HashMap<String,HashMap<String,HashMap>>  []tblData = (HashMap[]) collectionUtils.getByKey("TABLE");
			if(tblData != null){
				for(int k = 0; k < tblData.length; k++){
					processTableData(tblData[k]);
				}
			}
			
		}

	}

	private void processTableData(HashMap<String,HashMap<String,HashMap>> tblHash)
	{
		Set<String> actionSet = tblHash.keySet();
		for (String actionKeys : actionSet )
		{
			
			HashMap<String,HashMap> actionMap = tblHash.get(actionKeys);
			Set<String> tblDataSet = actionMap.keySet();
			for (String tblDataKeys : tblDataSet)
			{
				// -----
				if (tblDataKeys.equals("tblHeader"))
				{
					HashMap<String,HashMap<String,String>> tblHdr =  actionMap.get(tblDataKeys);
				}else if (tblDataKeys.equals("tblColHash"))
				{
					HashMap<String,HashMap<String,String>> tblCol =  actionMap.get(tblDataKeys);
					Set<String> tblColSet = tblCol.keySet();
					Object[] rowObj = tblColSet.toArray();
					Arrays.sort(rowObj);
					
					int k = 2;
					for (Object rowOrder: rowObj )
					{
						HashMap<String,String> tblColData =  tblCol.get(rowOrder.toString());

						
						k++;

					}

				}


			}

		}
	}

	public CommonCollectionUtils<String, HashMap<String, String>> getIncidentValues()
	{
		return  incident;
	}

	public void clearBean()
	{
		incdDtl.clear();
		incident.clear();
		table.clear();
		sequence.clear();
		indexConsDlt.clear();
		index.clear();
		constraint.clear();
	}

	public boolean isTableExists(String incdRef, String tblName)
	{
		Set<String> tblKeySet = table.keySet();
		for(String tblStr : tblKeySet){
			String []str = tblStr.split("`~");
			if(str[0].equals(incdRef) && str[1].equals(tblName))
			{
				return true;
			}
		}
		return false;
	}

	public boolean isSequenceExists(String incdRef, String seqName)
	{
		Set<String> tblKeySet = sequence.keySet();
		for(String tblStr : tblKeySet){
			String []str = tblStr.split("`~");
			if(str[0].equals(incdRef) && str[1].equals(seqName))
			{
				return true;
			}
		}
		return false;
	}

	public boolean loadDCRData(String dcrID)
	{
		Connection con = null;
		PreparedStatement incdPsmt = null,tblPsmt = null,tblColsPsmt=null,consPsmt = null,indxPsmt = null,
		consColPst= null, indColsPst = null, seqPst = null;
		ResultSet rsIncd = null,rsTbl = null,rsCons = null,rsIndx = null, rsTblCols = null, rsConsCols = null,
		rsIndCols = null, rsSeq= null;

		String incdQuery = "SELECT Incident_ref,incident_desc,CRF_SCF_ICN_NO from DCR_INCIDENT where DCR_REF=?";

		String tblQuery = "SELECT tbl.incident_ref, tbl.table_name, tbl.comments, tbl.table_space_name," +
				"tbl.table_type, tbl.faclity_spec_yn, tbl.module_id, tbl.ddl_type FROM dcr_tables tbl " +
				"WHERE tbl.dcr_ref =? AND tbl.incident_ref = ?";

		String tblColsQry = "SELECT tblcols.column_name,tblcols.comments,tblcols.col_order_seq, " +
				"tblcols.ddl_type,tblcols.data_type,tblcols.data_length,tblcols.data_precision, " +
				"tblcols.nullable_yn,tblcols.DEFAULT_VALUE, tblcols.dflt_val_type,tblCols.PKey_YN " +
				"FROM dcr_tab_columns tblcols WHERE tblCols.dcr_ref = ? AND tblCols.incident_ref = ? " +
				"AND tblcols.table_name = ?";

		String consQuery = "SELECT cons.incident_ref, cons.constraint_name, cons.ddl_type,cons.constraint_type, " +
				"cons.table_name, cons.search_condition,cons.r_table_name, cons.r_constraint_name, " +
				"cons.delete_rule FROM dcr_constraints cons WHERE cons.dcr_ref = ? AND cons.incident_ref = ? " +
				"AND cons.TABLE_NAME=?";

		String consColsQry = "SELECT conscols.column_name,conscols.POSITION FROM dcr_cons_columns conscols " +
				"WHERE conscols.dcr_ref = ? AND conscols.incident_ref = ? AND conscols.table_name = ? AND " +
				"AND conscols.table_name = ? conscols.CONSTRAINT_NAME =? ";

		String indexQuery = "SELECT ind.incident_ref, ind.index_name, ind.table_name, ind.index_type," +
				"ind.table_space_name, ind.ddl_type FROM dcr_indexes ind WHERE ind.dcr_ref = ? " +
				"AND ind.incident_ref = ? AND ind.table_name = ?";

		String indexColsQry = "SELECT indcols.column_name,indcols.col_order_seq, indcols.asc_descend_ind FROM  " +
				"dcr_ind_columns indcols WHERE indcols.dcr_ref = ? AND indcols.incident_ref = ? " +
				"AND indcols.table_name = ? AND indcols.index_name = ?";

		String seqQry = "Select SEQUENCE_NAME, DDL_TYPE, START_VALUE, MAX_VALUE, INCREMENT_BY, CYCLE_YN " +
				"from DCR_SEQUENCE where DCR_REF = ? and INCIDENT_REF = ? order by 1";
		try
		{
			con = ConnectionManager.getConnection();
			incdPsmt = con.prepareStatement(incdQuery);
			incdPsmt.setString(1,dcrID);
			rsIncd = incdPsmt.executeQuery();
			HashMap<String,String> dcrData = null;

			while (rsIncd.next())
			{
				dcrData = new HashMap<String,String>();
				String incRef = rsIncd.getString("Incident_ref");

				dcrData.put("incRef",incRef);
				dcrData.put("incSPR",rsIncd.getString("CRF_SCF_ICN_NO"));
				dcrData.put("incDes",rsIncd.getString("incident_desc"));
				processReq("INCD",rsIncd.getString("Incident_ref"),dcrData);

				tblPsmt = con.prepareStatement(tblQuery);
				tblPsmt.setString(1,dcrID);
				tblPsmt.setString(2,incRef);
				rsTbl = tblPsmt.executeQuery();

				HashMap<String,HashMap<String,String>> tblHeader =
					new HashMap<String,HashMap<String,String>>();
				HashMap<String,HashMap<String,String>> tblColHash =
					new HashMap<String,HashMap<String,String>>();
				HashMap<String,HashMap> tblMap = new HashMap<String,HashMap>();
				HashMap<String,HashMap> dcrHash = new HashMap<String,HashMap>();

				while (rsTbl.next())
				{
					dcrData = new HashMap<String,String>();
					String tblName = rsTbl.getString("table_name");
					dcrData.put("mode", rsTbl.getString("ddl_type"));
					dcrData.put("tableName", tblName);
					dcrData.put("tableType", rsTbl.getString("table_type"));
					dcrData.put("facilitySpec", rsTbl.getString("faclity_spec_yn"));
					dcrData.put("incAduit", null);
					dcrData.put("moduleId", rsTbl.getString("module_id"));
					dcrData.put("baseSchema", rsTbl.getString("table_space_name"));
					dcrData.put("Comments", rsTbl.getString("comments"));

					tblColsPsmt = con.prepareStatement(tblColsQry);
					tblColsPsmt.setString(1, dcrID);
					tblColsPsmt.setString(2, incRef);
					tblColsPsmt.setString(3, tblName);
					rsTblCols = tblColsPsmt.executeQuery();
					int i = 0;
					HashMap<String,String> tblCols = null;
					while(rsTblCols.next())
					{
						tblCols = new HashMap<String, String>();
						tblCols.put("order_"+i, rsTblCols.getString("col_order_seq"));
						tblCols.put("colName_"+i, rsTblCols.getString("column_name"));
						tblCols.put("dataType_"+i, rsTblCols.getString("data_type"));
						tblCols.put("colSize_"+i, rsTblCols.getString("data_length"));
						tblCols.put("colPrecision_"+i, rsTblCols.getString("data_precision"));
						tblCols.put("chkNull_"+i, rsTblCols.getString("nullable_yn"));
						tblCols.put("chkPK_"+i, rsTblCols.getString("PKey_YN"));
						tblCols.put("defType_"+i, rsTblCols.getString("dflt_val_type"));
						tblCols.put("defValue_"+i, rsTblCols.getString("DEFAULT_VALUE"));

						tblColHash.put("Cols"+i,tblCols);
						i++;
					}
					dcrData.put("rowCount", new Integer(i).toString());
					tblMap.put("tblHeader",dcrData);
					tblMap.put("tblColHash", tblColHash);
					dcrHash.put(tblName, tblMap);
					processReq("TABLE",incRef, dcrHash);

					consPsmt = con.prepareStatement(consQuery);
					consPsmt.setString(1,dcrID);
					consPsmt.setString(2,incRef);
					consPsmt.setString(3,tblName);
					rsCons = consPsmt.executeQuery();

					while (rsCons.next())
					{
						HashMap<String, HashMap<String, String>> dcrConst = new HashMap<String, HashMap<String, String>>();
						String consName = rsCons.getString("CONSTRAINT_NAME");
						dcrData = new HashMap<String,String>();

						dcrData.put("incRef", incRef);
						dcrData.put("mode", rsCons.getString("DDL_TYPE"));
						dcrData.put("costName", consName);
						dcrData.put("tableName", rsCons.getString("TABLE_NAME"));
						dcrData.put("costType", rsCons.getString("CONSTRAINT_TYPE"));

						consColPst = con.prepareStatement(consColsQry);
						consColPst.setString(1, dcrID);
						consColPst.setString(2, incRef);
						consColPst.setString(3, tblName);
						consColPst.setString(4, consName);
						rsConsCols = consColPst.executeQuery();
						String consCols = "";
						while(rsConsCols.next())
						{
							consCols = rsConsCols.getString("COLUMN_NAME")+"<<>>"+rsConsCols.getInt("POSITION");
							consCols += "`~";
						}
						dcrData.put("constraintCols", consCols);
						dcrData.put("fKeyCols",null);// need to be clarify ....
						dcrConst.put(consName, dcrData);
						setIndexesOrConstraints(incRef, "CONSTRAINT" ,tblName, dcrConst);
					}

					indxPsmt = con.prepareStatement(indexQuery);
					indxPsmt.setString(1,dcrID);
					indxPsmt.setString(2,incRef);
					indxPsmt.setString(3,tblName);
					rsIndx = indxPsmt.executeQuery();

					while (rsIndx.next())
					{
						HashMap<String, HashMap<String, String>> dcrIndex = new HashMap<String, HashMap<String, String>>();
						dcrData = new HashMap<String,String>();
						String indexName = rsIndx.getString("Index_name");
						dcrData.put("incRef",incRef);
						dcrData.put("mode", rsIndx.getString("DDL_TYPE"));
						dcrData.put("indexName", indexName);
						dcrData.put("tableName", rsIndx.getString("TABLE_NAME"));
						dcrData.put("keyType", rsIndx.getString("INDEX_TYPE"));

						indColsPst = con.prepareStatement(indexColsQry);
						indColsPst.setString(1,dcrID);
						indColsPst.setString(2,incRef);
						//indColsPst.setString(3,tblName);
						indColsPst.setString(3,indexName);
						rsIndCols = indxPsmt.executeQuery();
						String indCols = "";
						while(rsIndCols.next())
						{
							indCols = rsConsCols.getString("column_name")+"<<>>"+rsConsCols.getInt("col_order_seq");
							indCols += "`~";
						}
						dcrData.put("indexedCols", indCols);

						dcrIndex.put(indexName,dcrData);
						setIndexesOrConstraints(incRef, "INDEX", indexName, dcrIndex);
					}
				}

				seqPst = con.prepareStatement(seqQry);
				seqPst.setString(1, dcrID);
				seqPst.setString(1, incRef);
				rsSeq = seqPst.executeQuery();
				while(rsSeq.next())
				{
					dcrData = new HashMap<String,String>();
					String seqName = rsSeq.getString("");
					dcrData.put("incRef", incRef);
					dcrData.put("mode", rsSeq.getString("DDL_TYPE"));
					dcrData.put("seqName", seqName);
					dcrData.put("startsWith",rsSeq.getString("START_VALUE"));
					dcrData.put("maxNum",rsSeq.getString("MAX_VALUE"));
					dcrData.put("incmentBy",rsSeq.getString("INCREMENT_BY"));
					dcrData.put("cycle", rsSeq.getString("CYCLE_YN"));

					dcrHash.put(seqName, dcrData);
					processReq("SEQUENCE", incRef, dcrHash);
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSQLObj(rsIncd, "ResultSet");
			closeSQLObj(rsTbl, "ResultSet");
			closeSQLObj(rsTblCols, "ResultSet");
			closeSQLObj(rsCons, "ResultSet");
			closeSQLObj(rsConsCols, "ResultSet");
			closeSQLObj(rsIndx, "ResultSet");
			closeSQLObj(rsIndCols, "ResultSet");
			closeSQLObj(rsSeq, "ResultSet");

			closeSQLObj(incdPsmt, "PreparedStatement");
			closeSQLObj(tblColsPsmt, "PreparedStatement");
			closeSQLObj(tblPsmt, "PreparedStatement");
			closeSQLObj(consColPst, "PreparedStatement");
			closeSQLObj(consPsmt, "PreparedStatement");
			closeSQLObj(indColsPst, "PreparedStatement");
			closeSQLObj(indxPsmt, "PreparedStatement");
			closeSQLObj(seqPst, "PreparedStatement");

			closeSQLObj(con, "Connection");

		}
	 return false;
	}

	public String closeSQLObj(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{

				if(objectType.equalsIgnoreCase("ResultSet"))
				{
					ResultSet rs = (ResultSet)object;
					rs.close();
				}
				else if(objectType.equalsIgnoreCase("PreparedStatement"))
				{
					PreparedStatement pst = (PreparedStatement)object;
					pst.close();
				}
				else if(objectType.equalsIgnoreCase("Connection"))
				{
					Connection con = (Connection) object;
					con.close();
				}
			}
			catch(Exception se)
			{
				return se.toString();
			}
		}
		return "Object Closed.";
	}

	public String saveDCRData(String dcrID, String dcrDesc)
	{
		Connection con = null;

		try
		{
			String dcrQuery = "insert into dcr_details (dcr_ref,dcr_remarks ,dcr_raised_date,dcr_raised_by_id ," +
			"dcr_closed_date ,dcr_closed_by_id ,dcr_status) values (?,?,SYSDATE,?,SYSDATE,?,?)";

			String incdQuery = "insert into dcr_incident (incident_ref,incident_desc ,crf_scf_icn_no," +
					"dcr_ref,ADDED_BY_USER, ADDED_DATE) values (?,?,?,?,?,SYSDATE)";

			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			saveDCR(dcrID, dcrDesc, dcrQuery, con);
			
			saveINCDData(dcrID, incdQuery, con);
			con.commit();
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			e.printStackTrace();
		 	return e.getMessage();
		}
		finally
		{
			closeSQLObj(con, "Connection");
		}
		return null;
	}
	private void saveDCR(String dcrId, String dcrDes, String dcrQry, Connection con) throws Exception
	{
		PreparedStatement pst = con.prepareStatement(dcrQry);
		
		pst.setString(1, dcrId);
		pst.setString(2, dcrDes);
		pst.setString(3, (String)getUserInfo().get("login_user"));
		pst.setString(4, (String)getUserInfo().get("login_user"));
		pst.setString(5, "O");
		pst.execute();
		closeSQLObj(pst, "PreparedStatement");
	}

	private void saveINCDData(String dcrId, String incdQry, Connection con) throws Exception
	{
		List<String> incdList = getIncidentValues().keyList();

		String tblQuery = "insert into dcr_tables (incident_ref,table_name,comments,table_space_name," +
				"table_type,faclity_spec_yn,module_id,added_by_user,added_date	,ddl_type,dcr_ref,include_audit_yn) " +
				"values (?,?,?,?,?,?,?,?,SYSDATE,?,?,?)";

		String tblColsQuery = "insert into dcr_tab_columns (incident_ref,table_name,column_name,comments," +
				"col_order_seq,ddl_type,data_type,data_length,data_precision,nullable_yn,default_value," +
				"dflt_val_type,added_by_user,added_date,dcr_ref,PKEY_YN) values (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?)";

		String seqQry = "insert into  DCR_SEQUENCE (INCIDENT_REF, SEQUENCE_NAME, DDL_TYPE, START_VALUE, " +
				"MAX_VALUE, INCREMENT_BY, CYCLE_YN, ADDED_BY_USER, ADDED_DATE, DCR_REF)" +
				" values(?,?,?,?,?,?,?,?,SYSDATE,?)";

		String consQuery = "insert into dcr_constraints (incident_ref,constraint_name,ddl_type," +
				"constraint_type, table_name,search_condition,r_table_name,r_constraint_name,delete_rule," +
				"added_by_user, added_date,dcr_ref) values (?,?,?,?,?,?,?,?,?,?,SYSDATE,?)";

		String consColsQuery = "insert into dcr_cons_columns (incident_ref, constraint_name,table_name," +
				"column_name,position,added_by_user,added_date,dcr_ref) values (?, ?,?,?,?,?,SYSDATE,?)";

		String indxQuery = "insert into dcr_indexes (incident_ref,index_name,table_name,index_type," +
				"table_space_name,ddl_type,added_by_user,added_date,dcr_ref,UNIQUE_INDEX_YN) " +
				"values (?,?,?,?,?,?,?,SYSDATE,?,?)";

		String indxColsQuery = "insert into dcr_ind_columns (incident_ref,index_name,column_name," +
				"col_order_seq,asc_descend_ind,added_by_user,added_date,dcr_ref) " +
				"values (?,?,?,?,?,?,SYSDATE,?)";

		PreparedStatement tblpst = con.prepareStatement(tblQuery);
		PreparedStatement tblcolpst = con.prepareStatement(tblColsQuery);
		PreparedStatement conspst = con.prepareStatement(consQuery);
		PreparedStatement conscolpst = con.prepareStatement(consColsQuery);
		PreparedStatement indexpst = con.prepareStatement(indxQuery);
		PreparedStatement indexcolpst = con.prepareStatement(indxColsQuery);
		PreparedStatement seqpst = con.prepareStatement(seqQry);


		for(String incd : incdList)
		{
			HashMap<String, String> incdMap = (HashMap) getIncidentValues().get(incd);
			String incdRef = incdMap.get("incRef");
			incdMap.get("incSPR");
			incdMap.get("incDes");
			PreparedStatement pst = con.prepareStatement(incdQry);
			pst.setString(1, incdRef);
			pst.setString(2, incdMap.get("incDes"));
			pst.setString(3, incdMap.get("incSPR"));
			pst.setString(4, dcrId);
			pst.setString(5, (String)getUserInfo().get("login_user"));
			pst.execute();
			closeSQLObj(pst, "PreparedStatement");

			CommonCollectionUtils []beanDCRData = incdDtl.getByKey(incdRef);

			

			if(beanDCRData != null)
			{
				
				for(int i = 0;i < beanDCRData.length;i++ )
				{
					HashMap []beanTbls = (HashMap[]) beanDCRData[i].getByKey("TABLE");
					if(beanTbls != null)
					{
						for (int j = 0;j < beanTbls.length;j++ )
						{

							HashMap beanTblMap = (HashMap) beanTbls[j];
							
							saveTable(beanTblMap,  dcrId, incdRef, tblpst,tblcolpst,con);
						}
					}

					HashMap []beanSeq = (HashMap[]) beanDCRData[i].getByKey("SEQUENCE");
					if(beanSeq != null)
					{
						for(int k = 0; k< beanSeq.length; k++)
						{
							HashMap seqMap = beanSeq[k];
							Set<String> seqSet = seqMap.keySet();
							for(String seqName : seqSet)
							{
								
								saveSequence((HashMap)seqMap.get(seqName), incdRef, dcrId, seqpst,con);
							}
						}
					}
				}
			}

					CommonCollectionUtils  []ccUtils = indexConsDlt.getByKey(incdRef);
					
					if(ccUtils != null)
					{
						
						for(int v = 0; v < ccUtils.length; v++)
						{
							CommonCollectionUtils []index = (CommonCollectionUtils[]) ccUtils[v].getByKey("INDEX");
							CommonCollectionUtils []cons = (CommonCollectionUtils[]) ccUtils[v].getByKey("CONSTRAINT");
							
							if( index != null)
							{
								for(int a = 0; a < index.length; a++)
								{
									List<String> indexList = index[a].keyList();
									for(String indexName :indexList)
									{
										//saveIndexes((HashMap)index[a].get(indexName), incdRef, dcrId,  indexpst,indexcolpst,con);
										HashMap indexMaps = (HashMap)index[a].get(indexName);
										Set<String> indexSet = indexMaps.keySet();
										for(String indexKeyName : indexSet)
										{
											saveIndexes((HashMap)indexMaps.get(indexKeyName), incdRef, dcrId,  indexpst,indexcolpst,con);
										}
									}
								}

							}
							
							if(cons != null)
							{
								for(int r =0; r< cons.length;r++)
								{
									List<String> consList = cons[r].keyList();
									for(String consName : consList)
									{
										//saveConstraints((HashMap)cons[r].get(consName), incdRef, dcrId,  conspst,conscolpst,con);
										HashMap consMaps = (HashMap)cons[r].get(consName);
										Set<String> consSet = consMaps.keySet();
										for(String conKeyName : consSet)
										{
											saveConstraints((HashMap)consMaps.get(conKeyName), incdRef, dcrId,  conspst,conscolpst,con);
										}
									}
								}
							}
						}
					}
			//	}
			//}
		}

		closeSQLObj(tblpst, "PreparedStatement");
		closeSQLObj(tblcolpst, "PreparedStatement");
		closeSQLObj(conspst, "PreparedStatement");
		closeSQLObj(conscolpst, "PreparedStatement");
		closeSQLObj(indexpst, "PreparedStatement");
		closeSQLObj(indexcolpst, "PreparedStatement");
		closeSQLObj(seqpst, "PreparedStatement");
		//incident_ref,incident_desc ,crf_scf_icn_no," +
		//"dcr_ref,ADDED_BY_USER, ADDED_DATE
		//CommonCollectionUtils []beanDCRData = incdDtl.getByKey(incdRefNo);
	}

	private void saveTable(HashMap tblMap, String DCRId,
			String incdRef, PreparedStatement pst,PreparedStatement colpst,Connection con) throws Exception
	{
		Set<String> keySet = tblMap.keySet();
		int rowCount = 0;
		String tableName = "";
		String comments = "";
		String mode = "";

		PreparedStatement pstDeL = null;

		for(String tblKey : keySet)
		{
			HashMap tblHash =  (HashMap)tblMap.get(tblKey);
			Set<String> keySet1 = tblHash.keySet();
			for (String tblKey1 :  keySet1)
			{

				if(tblKey1.equals("tblHeader"))
				{
					
					HashMap<String, String> tblHeader = (HashMap) tblHash.get(tblKey1);
					rowCount =  new Integer(checkNullString(tblHeader.get("rowCount"))).intValue();
					tableName = checkNullString(tblHeader.get("tableName"));
					comments = checkNullString(tblHeader.get("Comments"));
					mode = checkNullString(tblHeader.get("mode"));

					String tblDelQry = "delete from DCR_TABLES where INCIDENT_REF = ? and TABLE_NAME = ? " +
							"and  DCR_REF = ?";
					String tblDelColsQry = "delete from DCR_TAB_COLUMNS where INCIDENT_REF = ? and " +
							"TABLE_NAME = ? and  DCR_REF = ?";

					pstDeL = con.prepareStatement(tblDelQry);
					pstDeL.setString(1, incdRef);
					pstDeL.setString(2, tableName);
					pstDeL.setString(3, DCRId);
					pstDeL.execute();
					closeSQLObj(pstDeL, "PreparedStatement");

					pstDeL = con.prepareStatement(tblDelColsQry);
					pstDeL.setString(1, incdRef);
					pstDeL.setString(2, tableName);
					pstDeL.setString(3, DCRId);
					pstDeL.execute();
					closeSQLObj(pstDeL, "PreparedStatement");
					//pst = con.prepareStatement(headerQry);

					pst.setString(1, incdRef);
					pst.setString(2, tableName);
					pst.setString(3, comments);
					pst.setString(4, checkNullString(tblHeader.get("baseSchema")));
					pst.setString(5, checkNullString(tblHeader.get("tableType")));
					pst.setString(6, checkNullString(tblHeader.get("facilitySpec")));
					pst.setString(7, checkNullString(tblHeader.get("moduleId")));
					pst.setString(8, (String)getUserInfo().get("login_user"));
					pst.setString(9, mode);
					pst.setString(10, DCRId);
					pst.setString(11, checkNullString(tblHeader.get("incAduit")));
					pst.execute();
				}
				else if(tblKey1.equals("tblColHash"))
				{
					HashMap tblCols = (HashMap) tblHash.get("tblColHash");
					
					//pst = con.prepareStatement(colsQry);
					for(int i = 2; i< rowCount; i++)
					{
						HashMap<String, String> cols = (HashMap)tblCols.get("Cols"+i);

						colpst.setString(1, incdRef);
						colpst.setString(2, tableName);
						colpst.setString(3, checkNullString(cols.get("colName_"+i)));
						colpst.setString(4, comments);
						colpst.setInt(5, Integer.parseInt(checkNullString(cols.get("order_"+i))));
						colpst.setString(6, mode);
						colpst.setString(7, checkNullString(cols.get("dataType_"+i)));
						colpst.setInt(8, Integer.parseInt(checkNullString(cols.get("colSize_"+i))));
						colpst.setInt(9, Integer.parseInt(checkNullString(cols.get("colPrecision_"+i))));
						colpst.setString(10, checkNullString(cols.get("chkNull_"+i)));
						colpst.setString(11, checkNullString(cols.get("defValue_"+i)));
						colpst.setString(12, checkNullString(cols.get("defType_"+i)));
						colpst.setString(13, (String)getUserInfo().get("login_user"));
						colpst.setString(14, DCRId);
						colpst.setString(15,  checkNullString(cols.get("chkPK_"+i)));
						colpst.execute();
					}
				}
			}
		}
	}

	private void saveSequence(HashMap<String, String> seqMap, String incdRef, String DCRId,
			PreparedStatement pst,Connection con) throws Exception
	{

		String delSeqQry = "delete from DCR_SEQUENCE where INCIDENT_REF = ? and SEQUENCE_NAME = ? and DCR_REF = ?";
		PreparedStatement pst1 = con.prepareStatement(delSeqQry);
		pst1.setString(1, incdRef);
		pst1.setString(2, checkNullString(seqMap.get("seqName")));
		pst1.setString(3, DCRId);
		pst1.execute();
		closeSQLObj(pst1, "PreparedStatement");
		
		//pst = con.prepareStatement(seqQry);
		pst.setString(1, incdRef);
		pst.setString(2, checkNullString(seqMap.get("seqName")));
		pst.setString(3,  checkNullString(seqMap.get("mode")));
		pst.setInt(4,  Integer.parseInt(checkNullString(seqMap.get("startsWith"))));
		pst.setInt(5, Integer.parseInt(checkNullString(seqMap.get("maxNum"))));
		pst.setInt(6, Integer.parseInt(checkNullString(seqMap.get("incmentBy"))));
		pst.setString(7, checkNullString(seqMap.get("cycle")));
		pst.setString(8, (String)getUserInfo().get("login_user"));
		pst.setString(9, DCRId);
		pst.execute();
	}

	private void saveConstraints(HashMap<String, String> consMap, String incdRef, String DCRId,
			PreparedStatement pst,PreparedStatement colpst,Connection con) throws Exception
	{
		String delConsQry = "delete from DCR_CONSTRAINTS where INCIDENT_REF = ? and CONSTRAINT_NAME = ? " +
				"and DCR_REF = ?";
		PreparedStatement pst1 = con.prepareStatement(delConsQry);
		pst1.setString(1, incdRef);
		pst1.setString(2, checkNullString(consMap.get("costName")));
		pst1.setString(3, DCRId);
		pst1.execute();
		closeSQLObj(pst1, "PreparedStatement");

		String delConsColQry = "delete from DCR_CONS_COLUMNS where INCIDENT_REF = ? and CONSTRAINT_NAME = ? " +
				"and DCR_REF = ?";
		pst1 = con.prepareStatement(delConsColQry);
		pst1.setString(1, incdRef);
		pst1.setString(2, checkNullString(consMap.get("costName")));
		pst1.setString(3, DCRId);
		pst1.execute();
		closeSQLObj(pst1, "PreparedStatement");
		
	//	pst = con.prepareStatement(consQry);
		pst.setString(1, incdRef);
		pst.setString(2, checkNullString(consMap.get("costName")));
		pst.setString(3, checkNullString(consMap.get("mode")));
		pst.setString(4, checkNullString(consMap.get("costType")));
		pst.setString(5, checkNullString(consMap.get("tableName")));
		pst.setString(6, checkNullString(consMap.get("search_condition")));// search_condition ---> no map found from bean.
		pst.setString(7, checkNullString(consMap.get("r_table_name")));
		pst.setString(8, checkNullString(consMap.get("r_constraint_name")));
		pst.setString(9, checkNullString(consMap.get("delete_rule")));
		pst.setString(10, (String)getUserInfo().get("login_user"));
		pst.setString(11, DCRId);
		pst.execute();



	//	closeSQLObj(pst, "PreparedStatement");


		String conCols = checkNullString(consMap.get("constraintCols"));
		String fCols = checkNullString(consMap.get("fKeyCols"));

		if(!conCols.equals(""))
		{
			StringTokenizer colsToken = new StringTokenizer(conCols, "`~");
			//pst = con.prepareStatement(consColQry);
			while(colsToken.hasMoreTokens())
			{
				colpst.setString(1, incdRef);
				colpst.setString(2, checkNullString(consMap.get("costName")));
				colpst.setString(3, checkNullString(consMap.get("tableName")));
				colpst.setString(4, colsToken.nextToken());
				colpst.setInt(5, 0);// value should be mapped
				colpst.setString(6, (String)getUserInfo().get("login_user"));
				colpst.setString(7, DCRId);
				colpst.execute();
			}
			//closeSQLObj(pst, "PreparedStatement");
		}

		if(!fCols.equals(""))
		{
			StringTokenizer colsToken = new StringTokenizer(fCols, "`~");
		//	pst = con.prepareStatement(consColQry);
			while(colsToken.hasMoreTokens())
			{
				colpst.setString(1, incdRef);
				colpst.setString(2, checkNullString(consMap.get("costName")));
				colpst.setString(3, checkNullString(consMap.get("tableName")));
				colpst.setString(4, colsToken.nextToken());
				colpst.setInt(5, 0);// value should be mapped
				colpst.setString(6, (String)getUserInfo().get("login_user"));
				colpst.setString(7, DCRId);
				colpst.execute();
			}
			//closeSQLObj(pst, "PreparedStatement");
		}

		//incident_ref, constraint_name,table_name,
		//column_name,position,added_by_user,added_date,dcr_ref
 	}

	private void saveIndexes(HashMap<String, String> indexMap, String incdRef, String DCRId,
			PreparedStatement pst,PreparedStatement colpst,Connection con) throws Exception
	{
		String delIndexQry = "delete from DCR_INDEXES where INCIDENT_REF = ? and INDEX_NAME = ? " +
				"and TABLE_NAME = ? AND  DCR_REF = ?";
		PreparedStatement pst1 = con.prepareStatement(delIndexQry);
		pst1.setString(1, incdRef);
		pst1.setString(2, checkNullString(indexMap.get("indexName")));
		pst1.setString(3, checkNullString(indexMap.get("tableName")));
		pst1.setString(4, DCRId);
		pst1.execute();
		closeSQLObj(pst1, "PreparedStatement");

		String delIndexColQry = "delete from DCR_INDEXES where INCIDENT_REF = ? and INDEX_NAME = ? " +
				"AND  DCR_REF = ?";
		pst1 = con.prepareStatement(delIndexColQry);
		pst1.setString(1, incdRef);
		pst1.setString(2, checkNullString(indexMap.get("indexName")));
		pst1.setString(3, DCRId);
		pst1.execute();
		closeSQLObj(pst1, "PreparedStatement");

		//pst = con.prepareStatement(indexQry);
		
		pst.setString(1, incdRef);
		pst.setString(2, checkNullString(indexMap.get("indexName")));
		pst.setString(3, checkNullString(indexMap.get("tableName")));
		pst.setString(4, checkNullString(indexMap.get("keyType")));
		pst.setString(5, "EHIS_DATA");
		pst.setString(6, checkNullString(indexMap.get("mode")));
		pst.setString(7, (String)getUserInfo().get("login_user"));
		pst.setString(8, DCRId);
		pst.setString(9, checkNullString(indexMap.get("indexType")));
		pst.execute();

		//incident_ref,index_name,table_name,index_type," +
		//"table_space_name,ddl_type,added_by_user,added_date,dcr_ref,UNIQUE_INDEX_YN

		String indexCols = checkNullString(indexMap.get("indexedCols"));


		if(!indexCols.equals(""))
		{
			StringTokenizer indexToken = new StringTokenizer(indexCols, "`~");
		//	pst = con.prepareStatement(indexColQry);
			while(indexToken.hasMoreTokens())
			{
				colpst.setString(1, incdRef);
				colpst.setString(2, checkNullString(indexMap.get("indexName")));
				colpst.setString(3, indexToken.nextToken());
				colpst.setInt(4, 0);// value should be mapped
				colpst.setInt(5, 1);// value should be mapped
				colpst.setString(6, (String)getUserInfo().get("login_user"));
				colpst.setString(7, DCRId);
				colpst.execute();
			}
			//closeSQLObj(pst, "PreparedStatement");
		}


		//(incident_ref,index_name,table_name,index_type," +
				//"table_space_name,ddl_type,added_by_user,added_date,dcr_ref)
		//incident_ref,index_name,column_name," +
		//"col_order_seq,asc_descend_ind,added_by_user,added_date,dcr_ref




	}

	private String checkNullString(String str)
	{
		if(str == null)
		{
			return  "";
		}
		return str;

	}

	public HashMap getModuleIDs()
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "select module_id, module_name from sm_module order by 1";
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			moduleHash= new HashMap();
			while (rs.next())
			{
				moduleHash.put(rs.getString(1),rs.getString(2));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	public HashMap getDataTypes()
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "select data_type, data_type_desc from drp_data_type order by 1";
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			moduleHash= new HashMap();
			while (rs.next())
			{
				moduleHash.put(rs.getString(1),rs.getString(2));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	public HashMap getTables(String moduleId)
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "";
			if (moduleId.equals(""))
			{
				strQuery = "select table_name,comments,table_space_name,table_type,faclity_spec_yn," +
						"pc_synonym_name,module_id from drp_tables order by 1";
			}else{
				strQuery = "select table_name,comments,table_space_name,table_type,faclity_spec_yn," +
						"pc_synonym_name,module_id from drp_tables where module_id = ? order by 1";
			}
			 con = ConnectionManager.getConnection();
			 pstmt = con.prepareStatement(strQuery);

			if (!moduleId.equals(""))
				pstmt.setString(1,moduleId);

			rs = pstmt.executeQuery();

			while (rs.next())
			{
				moduleHash.put(rs.getString("table_name"),rs.getString("module_id"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	public HashMap getConstraints(String tableName)
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "";
			if (tableName.equals(""))
			{
				strQuery = "select constraint_name,constraint_type,table_name,search_condition,r_table_name,r_constraint_name,delete_rule   from drp_constraints order by 1";
			}else{
				strQuery = "select constraint_name,constraint_type,table_name,search_condition,r_table_name,r_constraint_name,delete_rule   from drp_constraints where table_name=? order by 1";
			}
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);

			if (!tableName.equals(""))
				pstmt.setString(1,tableName);

			rs = pstmt.executeQuery();
			moduleHash= new HashMap();
			while (rs.next())
			{
				moduleHash.put(rs.getString("constraint_name"),rs.getString("table_name"));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	public HashMap getIndexes(String tableName)
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "";
			if (tableName.equals(""))
			{
				strQuery = "select index_name,table_name,index_type,table_space_name from drp_indexes order by 1";
			}else{
				strQuery = "select index_name,table_name,index_type,table_space_name from drp_indexes where table_name=? order by 1";
			}
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);

			if (!tableName.equals(""))
				pstmt.setString(1,tableName);

			rs = pstmt.executeQuery();
			moduleHash= new HashMap();
			while (rs.next())
			{
				moduleHash.put(rs.getString("index_name"),rs.getString("table_name"));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	public HashMap getSequences(String seqName)
	{
		HashMap moduleHash= new HashMap();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			String strQuery = "";
			if(seqName.equals(""))
			{
				strQuery = "select SEQUENCE_NAME, DDL_TYPE, START_VALUE, MAX_VALUE, INCREMENT_BY, CYCLE_YN, ADDED_BY_USER, ADDED_DATE, DCR_REF from DCR_SEQUENCE orderby 1";
			}else
			{
				strQuery = "select SEQUENCE_NAME, DDL_TYPE, START_VALUE, MAX_VALUE, INCREMENT_BY, CYCLE_YN, ADDED_BY_USER, ADDED_DATE, DCR_REF from DCR_SEQUENCE where SEQUENCE_NAME = ? orderby 1";
			}

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);

			rs = pstmt.executeQuery();

			while (rs.next())
			{
				moduleHash.put(rs.getString("index_name"),rs.getString("table_name"));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}

		return moduleHash;
	}

	private Properties getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(Properties userInfo)
	{

		this.userInfo = userInfo;
	}
}
