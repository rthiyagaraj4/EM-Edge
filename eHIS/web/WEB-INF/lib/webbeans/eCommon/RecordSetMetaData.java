/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
  * Used to store the records and properties that are related to the RecordSet.
  * @author			ArulKumarRaja.N
  * @version		1.0
  * @created-on		16th Sep 2002.
  * @modified-on	21st Jan 2003.
  */

package webbeans.eCommon;

public class RecordSetMetaData extends webbeans.eCommon.RecordSet implements java.io.Serializable
{
	java.util.Properties recordSetMetaData	=	null;

	/**
	  * The default constructor
	  */
	public RecordSetMetaData()
    {
		super();
        recordSetMetaData	=	new	java.util.Properties();
    }

	/**
	  * Constructor with recordSet object as a parameter
	  */
	public RecordSetMetaData(RecordSet recordSet)
	{
		super(recordSet);
        recordSetMetaData	=	new	java.util.Properties();
	}

	/**
	  * Used for set the record set property as key value pair
	  * @param propertyName refers the name of the property
	  * @param propertyValue refers the value of the property
	  * @return true if the property is set successfully otherwise false.
	  */
	public boolean setRecordSetProperty(String propertyName, Object propertyValue)
	{
		if(recordSetMetaData!=null)
		{
			recordSetMetaData.put ( propertyName, propertyValue );
			return true;
		}
		else return false;
	}

	/**
	  * Used for set the record set property as key value pair
	  * @param propertyName refers the name of the property
	  * @throws java.lang.NullPointerException when the recordSetMetaData object is null
	  * @see java.lang.NullPointerException
	  * @return the property value associated with the property name as an object.
	  */
	public Object getRecordSetProperty(String propertyName) throws NullPointerException
	{
		return recordSetMetaData.get ( propertyName );
	}
}
