/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common;
import java.util.*;

public class OrderEntryRecordBean implements java.io.Serializable
{
	// Used For the Checked Entries
	java.util.HashMap		hashPatient				=	null;
	java.util.HashMap		hashOrdersEntries		=	null;
	// Till Here---------Checked Entries

	// Used For the Order Format(Storage) (Also used for storing PH Remarks)
	java.util.Properties	orderFormatCatalogOrders=	null;
	boolean					order_format_status		=	false;
	// Till Here----------------Order Format

	/*
	 * 	Constructor Called
	 */
	public OrderEntryRecordBean()
	{
		hashPatient				= new java.util.HashMap();
		hashOrdersEntries		= new java.util.HashMap();
		//orderFormatCatalogOrders= new java.util.Properties();
	}
	public java.util.Properties getOrderFormatCatalogOrders(){
		return this.orderFormatCatalogOrders;
	}
	public void setOrderFormatCatalogOrders(java.util.Properties	orderFormatCatalogOrders){
		this.orderFormatCatalogOrders = orderFormatCatalogOrders;
	}
	/*
	 *	To clear for the Current Patient
	 */
	public void clearBean()
	{
		if( hashPatient	!= null )
		{
			hashPatient.clear();
			//hashPatient			= null;
		}
		else
			hashPatient			= new java.util.HashMap();

	 	if( hashOrdersEntries != null )
	 	{
	 		hashOrdersEntries.clear();
	 		//hashOrdersEntries	= null;
		}
	 	else
			hashOrdersEntries	= new java.util.HashMap();

		if(orderFormatCatalogOrders!=null)
		{
			orderFormatCatalogOrders.clear();
			orderFormatCatalogOrders = null;
		}
		/*else
			orderFormatCatalogOrders = new java.util.Properties();*/

	}
	/*
	 *	To set for the Current Patient
	 */
	public synchronized java.util.HashMap setPatient(String patient_id)
	{
		hashOrdersEntries		= new java.util.HashMap();
		hashPatient.put(patient_id,hashOrdersEntries);
		return hashOrdersEntries;
	}

	/*
	 *   Get for the Current Patient
	 */
	public synchronized java.util.HashMap getPatient(String patient_id)
	{
		hashOrdersEntries			=	(java.util.HashMap) hashPatient.get(patient_id);
		if(hashOrdersEntries==null)
		{
			hashOrdersEntries		=	new java.util.HashMap();
			hashPatient.put(patient_id,hashOrdersEntries);
		}
		return hashOrdersEntries;
	}

	/*
	 *   To set the checked Entries into the Bean.
	 */
	public synchronized boolean setCheckedEntries (String property_name, java.util.HashMap property_value ) throws Exception
	{
		boolean status 				= true;
		try
		{
			hashOrdersEntries.put(property_name,property_value );
		}
		catch(Exception e)
		{
			status	=	false;
			throw new Exception("Exception :When Setting the Entries "+e);
		}
 		return status;
	} // end of setCheckedEntries

	/*
	 *  Get Method to Get the checked Entries
	 */
	public synchronized java.util.HashMap getCheckedEntries(String prop_id) throws Exception
	{
			java.util.HashMap		hash_checked_entries_values		=	null;
			hash_checked_entries_values	=	( java.util.HashMap ) hashOrdersEntries.get(prop_id);
			if(hash_checked_entries_values!=null)
				return	hash_checked_entries_values;
			else return null;
	} // end of getCheckedEntries(java.lang.String)

	/*
	 *  Split the Values to get the code and to know whether it is a Hidden Field or Checkbox
	 */
	public synchronized String[] getKey(String checkedKey) throws Exception
	{
		String[] recordKey = new String[2];
		if(checkedKey!=null)
		{
			if(checkedKey.length() > 0)
			{
				recordKey[0] = checkedKey.substring(0,2);  // To know whether it is checkbox or hidden Field
				recordKey[1] = checkedKey.substring(2,checkedKey.length());  // Code or Value
			}
		}
		return recordKey;
	}

	/*
	 *   To check whether the entry is present or not
	 */
	public synchronized boolean containsValue(String prop_id, String find_string) throws Exception
	{
		java.util.HashMap	checked_entries	=	null;
		boolean status = true;
		try
		{
			checked_entries		=	( java.util.HashMap )	hashOrdersEntries.get(prop_id);
			if( checked_entries != null )
			{
				if(checked_entries.containsKey(find_string))
					status = true;
				else
				   status  = false;
			}
			else    status = false;
		}
		catch(Exception e)
		{
			status = false;
			System.err.println("Exception in containsValue method (Logical Bean)"+e.toString());
		}
		if(checked_entries!=null) {
			checked_entries.clear();
			//checked_entries = null;
		}
		return status;
	} // End of containsValue

	/*
	 *  To Remove the Entry
	 */
	public synchronized boolean removeCheckedEntries (String prop_id,String prop_value )  throws Exception
	{
		boolean status 							= false;
		java.util.HashMap	hashOrderEntries	= null;
		try
		{
			hashOrderEntries		=	( java.util.HashMap )	hashOrdersEntries.get(prop_id);
			if(hashOrderEntries!=null)
			{
				hashOrderEntries.remove	( prop_value );
				status = true;
			}
			else status = false;
		} // end of try
		catch(Exception e)
		{
			status = false;
			System.err.println("Exception in removeCheckedEntries method (Logical Bean)"+e.toString());
			throw new Exception("Exception :When removing the entries "+e);
		}
		// dO NOT USE THIS, IT WILL CLEAR ALL THE VALUES.
		/*if(hashOrderEntries!=null) {
			hashOrderEntries.clear();
			//hashOrderEntries = null;
		}*/
		return status;
	}  // End of removeCheckedEntries

	//****************** Till Here For the Checked Entries ****************************//

	/*
	 *	For the Order Format (Storing the Template and retrieving back)
	 *
	 */

	/*
	 *  Setting the Order Format Template
	 */
		public synchronized boolean setOrderFormats (String catalog_code, String property_name, java.lang.Object property_value )  throws java.lang.Exception
		{	//.......The property_name-------has the value as (catalog_code+seq_num)
			java.util.Properties order_format =	null;
			try
			{
				java.util.Properties orderFormatCatalogOrders= getOrderFormatCatalogOrders();
				if (orderFormatCatalogOrders != null)
				{
					order_format		= (java.util.Properties) orderFormatCatalogOrders.get(catalog_code);
				
					if(order_format== null)
					{
						order_format	= new java.util.Properties();
						order_format.put(property_name,property_value);
						orderFormatCatalogOrders.put( catalog_code,order_format);
					}
					else
					{
						order_format.put(property_name,property_value);
						orderFormatCatalogOrders.put(catalog_code,order_format);
					}
				}else{
				
					if(order_format== null)
					{
						order_format	= new java.util.Properties();
						orderFormatCatalogOrders	= new java.util.Properties();
						order_format.put(property_name,property_value);
						orderFormatCatalogOrders.put( catalog_code,order_format);
					}				
				}
				
				setOrderFormatCatalogOrders(orderFormatCatalogOrders);
		
				order_format_status	= true;
			} // end of try
			catch(Exception e)
			{
				order_format_status	= false;
				System.err.println("Exception in setOrderFormats method (Logical Bean)"+e.toString());
				throw new Exception("Exception when setting the values");
			} // end of catch
			return order_format_status;
		} // end of setOrderFormats

	/*
	 *	Retrieving the Order Format Template
	 */
		public synchronized java.lang.Object getOrderFormats(String catalog_code, String property_name) throws java.lang.Exception
		{
			java.util.Properties order_format			 =	null;
			java.lang.Object flex_fields_property_value  =	null;
			java.util.Properties orderFormatCatalogOrders= getOrderFormatCatalogOrders();
			if (orderFormatCatalogOrders != null)
			{
				order_format = ((java.util.Properties) orderFormatCatalogOrders.get(catalog_code));
				if(order_format!=null)
				{
					flex_fields_property_value	=	order_format.get(property_name);
					return	flex_fields_property_value;
				}
			}			
			return null;
		} // end of getOrderFormats(java.lang.String)

	/*
	 *    Removing  the OrderFormat (CANCEL)
	 */
		public synchronized boolean removeOrderFormats (String catalog_code, String property_name )  throws java.lang.Exception
		{
			java.util.Properties order_format =	null;
			try
			{
				java.util.Properties orderFormatCatalogOrders= getOrderFormatCatalogOrders();
				if (orderFormatCatalogOrders != null)
				{
					order_format		= (java.util.Properties) orderFormatCatalogOrders.get(catalog_code);
					if(order_format!=null)
					{
						order_format.remove	( property_name );
						orderFormatCatalogOrders.put(catalog_code,order_format);
						order_format_status	=	true;
					}
				}
				
			} // end of try
			catch(Exception e)
			{
				order_format_status	=	false;
				System.err.println("Exception in removeOrderFormats method (Logical Bean)"+e.toString());
				throw new Exception("When Removing from the Bean");
			} // end of catch
			return order_format_status;
		} // end of removeOrderFormats
	//****************** Till Here For the Order Format ****************************//
} // end of class EntryStorage
