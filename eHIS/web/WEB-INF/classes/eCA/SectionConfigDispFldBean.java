/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import eCommon.Common.*;
import webbeans.eCommon.*;

public class SectionConfigDispFldBean implements java.io.Serializable
{

    private LinkedList<String> dispColumn;
    private LinkedList<String> fieldReffColumn;
	private LinkedList<String> allColumns;
	private HashMap<String, String> mandatoryYN;
	private HashMap<String, ArrayList<String>> selectedData;
	private String key = "SectionConfigDispFldBean";
	private String subKey = "SectionConfigDispFldBean";
	private boolean keyFlag = true;
	private int rIndex;

	public SectionConfigDispFldBean()
	{
		this.selectedData = new HashMap<String, ArrayList<String>>();
	}

	private void setRIndex(int rIndex)
	{
		this.rIndex = rIndex;
	}

	private int getRIndex()
	{
		return this.rIndex;
	}

	private void setKeyFlag(boolean flag)
	{
		this.keyFlag = flag;
	}

	private boolean getKeyFlag()
	{
		return this.keyFlag;
	}

	private void setKey(String key)
	{
		this.key = key;
	}

	private String getKey()
	{
		return this.key;
	}

	private void setSubKey(String key)
	{
		this.subKey = key;
	}

	private String getSubKey()
	{
		return this.subKey;
	}

	private void setSelectedData(HashMap<String, ArrayList<String>> selectedData)
	{
		this.selectedData = selectedData;
	}

	public HashMap<String, ArrayList<String>> getSelectedData()
	{
		return this.selectedData;
	}


	private void setMandatoryYN(HashMap<String, String> mandatoryYN)
	{
		this.mandatoryYN = mandatoryYN;
	}

	public HashMap<String, String> getMandatoryYN()
	{
		return this.mandatoryYN;
	}

	private void setAllColumns(LinkedList<String> allColumns)
	{
		this.allColumns = allColumns;
	}

	public LinkedList<String> getAllColumns()
	{
		return this.allColumns;
	}

	private void setFieldReffColumn(LinkedList<String> list)
    {
        this.fieldReffColumn = list;
    }

    public LinkedList<String> getFieldReffColumn()
    {
        return this.fieldReffColumn;
    }

	private void setDispColumn(LinkedList<String> list)
    {
        this.dispColumn = list;
    }

    public LinkedList<String> getDispColumn()
    {
        return this.dispColumn;
    }

	public void setSectionConfig(String key, int index1, int index2)
    {
		if(key.equals(getKey()))
		{
			setKeyFlag(false);
		}
		else
		{
			setKey(key);
			if(getSelectedData() != null)
			{
				getSelectedData().clear();
			}
			setKeyFlag(true);

		}
		if(getKeyFlag())
		{
			setKey(key);
			Connection con=null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try
			{
				String sql = "SELECT RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY = ? ORDER BY DEFAULT_ORDER_SEQ";
				con =  ConnectionManager.getConnection();
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, key);
				rs = pst.executeQuery();
				LinkedList<String> fieldRefDesc = new LinkedList<String>();
				LinkedList<String> fieldReff = new LinkedList<String>();
				LinkedList<String> allCols =  new LinkedList<String>();
				HashMap<String, String> mandatory = new HashMap<String, String>();

				while(rs.next())
				{
					allCols.add(rs.getString(1)+"#"+rs.getString(2)	+"#"+rs.getString(3)+"#"+rs.getString(4));
					fieldRefDesc.add(rs.getString(4));
					fieldReff.add(rs.getString(3));
					mandatory.put(rs.getString(3), rs.getString(5));

				}
				setMandatoryYN(mandatory);
				setDispColumn(fieldRefDesc);
				setFieldReffColumn(fieldReff);
				setAllColumns(allCols);
				Set<String> keySet = getMandatoryYN().keySet();
				for(String keyStr : keySet)
				{
					String check = getMandatoryYN().get(keyStr);
					if(check.equals("Y"))
					{
						int fieldIndex = getFieldReffColumn().indexOf(keyStr);
						addSelected(getFieldReffColumn().get(fieldIndex), new Integer((fieldIndex)+1).toString());
					}
				}
			}
			catch (Exception se)
			{
				
				se.printStackTrace();
			}
			finally
			{
				try
				{
					if(con != null)
					{
					   ConnectionManager.returnConnection(con);
					}
					if(rs != null)
					{
						rs.close();
					}
					if(pst != null)
					{
						pst.close();
					}
					}
				catch (SQLException se)
				{
					
					se.printStackTrace();
				}

			}
		}

		if(index1 != index2)
		{
			setDispColumn(fieldOrder(getDispColumn(), index1, index2));
			setAllColumns(fieldOrder(getAllColumns(), index1, index2));
			setFieldReffColumn(fieldOrder(getFieldReffColumn(), index1, index2));
			if(getSelectedData().size() > 0 )
			{
				Set<String> selKeys = getSelectedData().keySet();
				for(String fieldRefKey : selKeys)
				{
					addSelected(fieldRefKey, new Integer((getFieldReffColumn().indexOf(fieldRefKey))+1).toString());
				}
			}
		}
    }

    public void setSectionConfig(String sql, String key1, String key2, int index1, int index2)
    {
		if(key1.equals(getKey()) && key2.equals(getSubKey()))
		{
			setKeyFlag(false);
		}
		else
		{
			setKey(key1);
			setSubKey(key2);
			if(getSelectedData() != null)
			{
				getSelectedData().clear();
			}
			setKeyFlag(true);

		}
		if(getKeyFlag())
		{
			setKey(key1);
			setSubKey(key2);
			Connection con=null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try
			{
				con =  ConnectionManager.getConnection();
				pst = con.prepareStatement(sql);
				pst.setString(1, key1);
				pst.setString(2, key2);
				rs = pst.executeQuery();
				LinkedList<String> fieldRefDesc = new LinkedList<String>();
				LinkedList<String> fieldReff = new LinkedList<String>();
				LinkedList<String> allCols =  new LinkedList<String>();
				HashMap<String, String> mandatory = new HashMap<String, String>();

				while(rs.next())
				{
					allCols.add(rs.getString(1)+"#"+rs.getString(2)	+"#"+rs.getString(3)+"#"+rs.getString(4));
					fieldRefDesc.add(rs.getString(4));
					fieldReff.add(rs.getString(3));
					mandatory.put(rs.getString(3), rs.getString(5));

				}
				setMandatoryYN(mandatory);
				setDispColumn(fieldRefDesc);
				setFieldReffColumn(fieldReff);
				setAllColumns(allCols);

				Set<String> keySet = getMandatoryYN().keySet();
				for(String keyStr : keySet)
				{
					String check = getMandatoryYN().get(keyStr);
					if(check.equals("Y"))
					{
						int fieldIndex = getFieldReffColumn().indexOf(keyStr);
						addSelected(getFieldReffColumn().get(fieldIndex), new Integer((fieldIndex)+1).toString());
					}
				}

			}
			catch (Exception se)
			{
				
				se.printStackTrace();
			}
			finally
			{
				try
				{
					if(con != null)
					{
					   ConnectionManager.returnConnection(con);
					}
					if(rs != null)
					{
						rs.close();
					}
					if(pst != null)
					{
						pst.close();
					}
					}
				catch (SQLException se)
				{
					
					se.printStackTrace();
				}

			}
		}

		if(index1 != index2)
		{
			setDispColumn(fieldOrder(getDispColumn(), index1, index2));
			setAllColumns(fieldOrder(getAllColumns(), index1, index2));
			setFieldReffColumn(fieldOrder(getFieldReffColumn(), index1, index2));
			if(getSelectedData().size() > 0 )
			{
				Set<String> selKeys = getSelectedData().keySet();
				for(String fieldRefKey : selKeys)
				{
					addSelected(fieldRefKey, new Integer((getFieldReffColumn().indexOf(fieldRefKey))+1).toString());
				}
			}
		}
    }

    private LinkedList<String> fieldOrder(LinkedList<String> list, int index1, int index2)
    {
		String str1 = (String)list.get(index1);
		if(index2 == 0)
		{
			list.addFirst(str1);
		}
		else if(index2 == (list.size() - 1))
		{
			list.addLast(str1);
		}
		else if(index2 > index1)
		{
			list.add(index2+1, str1);
		}
		else if(index1 > index2)
		{
			list.add(index2, str1);
		}

		if(index2 < index1)
		{
			list.remove(index1+1);
		}
		else if(index2 > index1)
		{
 		   list.remove(index1);
		}
		return list;
    }

	public boolean addSelected(String key, String orCount)
	{

		ArrayList<String> row = null;
		List<String> listData = getAllColumns();
		String result_category = "";
		String result_sub_category = "";
		String field_ref = "";
		String default_order_seq = orCount;

		for(String str : listData)
		{
			String split[] = str.split("#");
			result_category = split[0];
			result_sub_category = split[1];
			field_ref = split[2];

			String check = getMandatoryYN().get(field_ref);

			if(check!= null && check.equals("Y"))
			{
				row = new ArrayList<String>();
				row.add(result_category);
				row.add(result_sub_category);
				row.add(field_ref);
				row.add(new Integer(getFieldReffColumn().indexOf(field_ref)+1).toString());
				getSelectedData().put(field_ref, row);
				setSelectedData(getSelectedData());
			}

			if(key.equals(field_ref))
			{
				row = new ArrayList<String>();
				row.add(result_category);
				row.add(result_sub_category);
				row.add(field_ref);
				row.add(default_order_seq);
				getSelectedData().put(key, row);
				setSelectedData(getSelectedData());
				key = "";
			}
		}

		return true;
	}

	public boolean removeSelected(String key)
	{
		if(getSelectedData().containsKey(key))
		{
			getSelectedData().remove(key);
			return true;
		}
		return false;
	}

	public void clearBean()
	{
		setKey("SectionConfigDispFldBean");
		setSubKey("SectionConfigDispFldBean");

		if(getSelectedData() != null)
		{
			selectedData.clear();
		}
		if(mandatoryYN != null)
		{
			mandatoryYN.clear();
		}
		clearLists(getAllColumns());
		clearLists(getDispColumn());
		clearLists(getFieldReffColumn());

		setKeyFlag(true);
	}

	private void clearLists(List<String> list)
	{
		if(list != null)
		{
			Iterator itr = list.iterator();
			while(itr.hasNext())
			{
				itr.next();
				itr.remove();
			}
		}
	}

	public void setFieldOrder(List<String> list)
	{
		int cnt = 0;

		for(String fieldRef : list)
		{
			int index = getFieldReffColumn().indexOf(fieldRef);
			getFieldReffColumn().remove(fieldRef);
			String st = getDispColumn().remove(index);
			String st1 = getAllColumns().remove(index);


			if(cnt == 0)
			{
				getFieldReffColumn().addFirst(fieldRef);
				getDispColumn().addFirst(st);
				getAllColumns().addFirst(st1);
			}
			else
			{
				getFieldReffColumn().add(cnt, fieldRef);
				getDispColumn().add(cnt, st);
				getAllColumns().add(cnt, st1);
			}
			cnt++;
		}
	}
}
