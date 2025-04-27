/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 *
 * Created on 5/26/2010 related to IN021332
 * @author Archana Dhal
 */
package eCA;

import java.util.ArrayList;
import java.util.List;

public class RecClinicalNotesLinkRepBean implements java.io.Serializable
{

	private List<String> selRowId = null;
	private List<String> selRowNm = null;
	
	public RecClinicalNotesLinkRepBean() 
	{
		selRowId = new ArrayList<String>();
		selRowNm = new ArrayList<String>();
	}
	
	public void clearBean()
	{
		this.selRowId.clear();
		this.selRowNm.clear();
	}
	
	public void addSelectedRow(String rowId)
	{
		if(!this.selRowId.contains(rowId))
		{
			this.selRowId.add(rowId);
		}
	}
	
	public void removeSelectedRow(String rowId)
	{
		if(this.selRowId.contains(rowId))
		{
			this.selRowId.remove(rowId);
		}
	}
	
	public List<String> getSelectedRows()
	{
		return this.selRowId.size() > 0 ? this.selRowId : null;
	}

	public void setSelectedRowNum(String rNum)
	{
		if(!selRowNm.contains(rNum))
		{
			this.selRowNm.add(rNum);
		}
	}

	public void removeSelectedRowNum(String rNum)
	{
		if(selRowNm.contains(rNum))
		{
			this.selRowNm.remove(rNum);
		}
	}

	public List<String> getSelectedRowNum()
	{
		
		return this.selRowNm.size() > 0 ? this.selRowNm : null;
	}
}
