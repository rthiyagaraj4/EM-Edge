/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eFM;

import java.util.*;

public class FileDeficiencyMonitoring  implements java.io.Serializable
{
	java.util.ArrayList	recordSetDeficiency	=	null;

	public FileDeficiencyMonitoring()
	{
		recordSetDeficiency	=	new java.util.ArrayList();
	}

	public int getSize()
	{
		int size = 0;
		if(recordSetDeficiency!=null)
			size	=	recordSetDeficiency.size();
		return size;
	}

	public boolean clearAll() throws Exception
	{
		recordSetDeficiency.clear();
		return true;
	}

	public boolean putObject (java.util.HashMap htRecord) throws Exception
	{
		try
		{
			recordSetDeficiency.add(htRecord);
		}
		catch(Exception e)
		{
			throw new Exception("Exception@putObject: "+e);
		}
		return true;
	}

	public boolean setObject (int index, java.util.HashMap htRecord) throws Exception
	{
		try
		{
			recordSetDeficiency.set(index, htRecord);
		}
		catch(Exception e)
		{
			throw new Exception("Exception@setObject: "+e);
		}
		return true;
	}

	public java.util.HashMap getObject (int row) throws Exception
	{
		java.util.HashMap htRecord	=	null;
		if(recordSetDeficiency!=null)
			htRecord = (java.util.HashMap) recordSetDeficiency.get(row);
		return htRecord;
	}

	public boolean removeObject (int row) throws Exception
	{
		this.recordSetDeficiency.remove(row);
		return true;
	}

	public boolean isDetailAddDuplicateExists (java.util.HashMap newRecord) throws Exception
	{
		String	new_facility_id		=	"";
		String	new_encounter_id	=	"";
		String	new_file_no			=	"";
		String	new_deficiency_code =	"";

		String	curr_facility_id	=	"";
		String  curr_encounter_id	=	"";
		String	curr_file_no		=	"";
		String  curr_deficiency_code=	"";
		boolean	duplicateExists		=	false;

		java.util.HashMap	currentRecord	=	null;

		new_facility_id		=	(String)	newRecord.get("facility_id");
		new_encounter_id	=	(String)	newRecord.get("encounter_id");
		new_file_no			=	(String)	newRecord.get("file_no");
		new_deficiency_code =	(String)	newRecord.get("defi_code");

		for( int i=0; i<this.getSize(); i++ )
		{
			currentRecord	=	this.getObject(i);
			curr_facility_id	=	(String)	currentRecord.get("facility_id");
			curr_encounter_id	=	(String)	currentRecord.get("encounter_id");
			curr_file_no		=	(String)	currentRecord.get("file_no");
			curr_deficiency_code=	(String)	currentRecord.get("defi_code");

			if( (curr_facility_id.equals(new_facility_id)) && (curr_encounter_id.equals(new_encounter_id)) && (curr_file_no.equals(new_file_no)) && (curr_deficiency_code.equals(new_deficiency_code)) )
			{
				duplicateExists	=	true;
				break;
			}
		}
		return duplicateExists;
	}

	public boolean isDetailModDuplicateExists (java.util.HashMap newRecord, int recordIndex) throws Exception
	{
		String	new_facility_id		=	"";
		String	new_encounter_id	=	"";
		String	new_file_no			=	"";
		String	new_deficiency_code =	"";

		String	curr_facility_id	=	"";
		String  curr_encounter_id	=	"";
		String	curr_file_no		=	"";
		String  curr_deficiency_code=	"";
		boolean	MduplicateExists	=	false;

		java.util.HashMap	currentRecord	=	null;

		new_facility_id		=	(String)	newRecord.get("facility_id");
		new_encounter_id	=	(String)	newRecord.get("encounter_id");
		new_file_no			=	(String)	newRecord.get("file_no");
		new_deficiency_code =	(String)	newRecord.get("defi_code");

		for( int i=0; i<this.getSize(); i++ )
		{
			currentRecord	=	this.getObject(i);
			curr_facility_id	=	(String)	currentRecord.get("facility_id");
			curr_encounter_id	=	(String)	currentRecord.get("encounter_id");
			curr_file_no		=	(String)	currentRecord.get("file_no");
			curr_deficiency_code=	(String)	currentRecord.get("defi_code");

			if(i!=recordIndex)
			{
				if( (curr_facility_id.equals(new_facility_id)) && (curr_encounter_id.equals(new_encounter_id)) && (curr_file_no.equals(new_file_no)) && (curr_deficiency_code.equals(new_deficiency_code)) )
				{
					MduplicateExists	=	true;
					break;
				}
			}
		}
		return MduplicateExists;
	}

	public boolean isHeaderDuplicateExists (java.util.HashMap newRecord) throws Exception
	{
		String	new_facility_id		=	"";
		String	new_encounter_id	=	"";
		String	curr_facility_id	=	"";
		String  curr_encounter_id	=	"";

		boolean	HduplicateExists		=	false;

		java.util.HashMap	currentRecord	=	null;

		new_facility_id		=	(String)	newRecord.get("facility_id");
		new_encounter_id	=	(String)	newRecord.get("encounter_id");

		for( int i=0; i<this.getSize(); i++ )
		{
			currentRecord	=	this.getObject(i);
			curr_facility_id	=	(String)	currentRecord.get("facility_id");
			curr_encounter_id	=	(String)	currentRecord.get("encounter_id");

			if( (curr_facility_id.equals(new_facility_id)) && (curr_encounter_id.equals(new_encounter_id)) )
			{
				HduplicateExists	=	true;
				break;
			}
		}
		return HduplicateExists;
	}

}
