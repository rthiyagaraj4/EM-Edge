/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common;

public class MultiRecordBean implements java.io.Serializable
{

    java.util.ArrayList DbRecords   =   null;
	java.util.ArrayList SelectRecords   =   null;
	java.util.ArrayList DbRecordsOriginal   =   null;

	public String tempChkM1 = "";
	public String tempChkM2 = "";

	/**
	  * The default constructor
	  */
    public MultiRecordBean(){
        DbRecords		=   new java.util.ArrayList();
		SelectRecords   =   new java.util.ArrayList();
		DbRecordsOriginal   =   new java.util.ArrayList(); //Original Db tab
    }

	/**
	  * Constructor with ArrayList objects as a parameter
	  */
	public MultiRecordBean(MultiRecordBean DbRecords, MultiRecordBean SelectRecords){
		this.DbRecords	=	new java.util.ArrayList(DbRecords.DbRecords);
		this.SelectRecords	=	new java.util.ArrayList(SelectRecords.SelectRecords);
	}

	/**
	  * Used for getting the Associated record set handle
	  * @return java.util.ArrayList for the current record set.
	  */
	public java.util.ArrayList getAllDBRecords(){
		//System.out.println("====="+DbRecords.size());
		return this.DbRecords;
	}

	/**
	  * Used for getting the Selected record set handle
	  * @return java.util.ArrayList for the current record set.
	  */
	public java.util.ArrayList getAllSelectRecords(){
		return this.SelectRecords;
	}

	/**
	  * Used to find the record set size
	  * @param value refers the type Record property
	  * @return size of the record set
	  */
    public int getSize(String value)
	{
        int size = 0;
		if(value.equals("DB"))
		{
			if(DbRecords!=null)
				size    =   DbRecords.size();
		}else if(value.equals("SELECT"))
		{
			if(SelectRecords!=null)
				size    =   SelectRecords.size();
		}
		else if(value.equalsIgnoreCase("DBORIGINAL"))
		{
			if(DbRecordsOriginal!=null)
				size    =   DbRecordsOriginal.size();
		}
        return size;
    }

	/**
	  * Used to clear the Associated records set ArrayList content
	  * @return true on clearing
	  */
	public boolean clearDBRec() throws Exception 
	{
        DbRecords.clear();
        return true;
    }

	/**
	  * Used to clear the Selected records set ArrayList content
	  * @return true on clearing
	  */
	public boolean clearSelectRec() throws Exception 
	{
        SelectRecords.clear();
        return true;
    }
	
	 /****************************************************************************
	 * Used to clear the Associated Original records set ArrayList content
	  * @return true on clearing
	  */
    public void clearDBRecOriginal(){
		if(!DbRecordsOriginal.isEmpty())
        DbRecordsOriginal.clear();
     }
/****************************************************************************/

	/**
	  * Used to add a record into the Associted record ArrayList
	  * @param recordObject refers collection object
	  * @return true if the content is successfully added else false
	  */
    public boolean putObject (Object recordObject) throws Exception {
		try{
            DbRecords.add(recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@putObject: "+e);
        }
        return true;
    }

	/**
	  * Used to add a record into the Selected record ArrayList
	  * @param recordObject refers collection object
	  * @return true if the content is successfully added else false
	  */
	public boolean putListObject (Object recordObject) throws Exception {
		try{
            SelectRecords.add(recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@putObject: "+e);
        }
        return true;
    }


	/**
	  * Used to set a record into the Associted record ArrayList at the desired position
	  *	@param index refers position.
	  * @param recordObject refers collection object.
	  * @return true if the content is successfully set in the corresponding index else false
	  */
    public boolean setObject (int index, Object recordObject) throws Exception {
        try{
			if( index < getSize("DB") )
	            DbRecords.set(index, recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@setObject: "+e);
        }
        return true;
    }

	/**
	  * Used to set a record into the Selected record ArrayList at the desired position
	  * @param index refers position.
	  * @param recordObject refers collection object.
	  * @return true if the content is successfully set in the corresponding index else false
	  */
	public boolean setListObject (int index, Object recordObject) throws Exception {
        try{
			if( index < getSize("SELECT") )
	            SelectRecords.set(index, recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@setObject: "+e);
        }
        return true;
    }

	/**
	  * Used to get a record from the Associted record ArrayList at the desired position
	  * @param index refers position.
	  * @return true if the content is successfully set in the corresponding index else false
	  */
    public java.lang.Object getObject (int row) throws Exception {
        java.lang.Object recordObject   =   null;
        if(DbRecords!=null) {
			if( row < getSize("DB") )
	            recordObject = (java.lang.Object) DbRecords.get(row);
		}
        return recordObject;
    }

	/*Added By Uma
		*********************************************************************/
	public java.lang.Object getObjectOriginal(int row) throws Exception {
		//tempChkM2 +=""+1;
		tempChkM2 = tempChkM2+""+1;
        java.lang.Object recordObject   =   null;
        if(DbRecordsOriginal!=null) {
			if( row < getSize("DBORIGINAL") )
	            recordObject = (java.lang.Object) DbRecordsOriginal.get(row);
		}
        return recordObject;
    }
/*************************************************************************/

	/**
	  * Used to get a record from the Selected record ArrayList at the desired position
	  * @param index refers position.
	  * @return true if the content is successfully set in the corresponding index else false
	  */
	public java.lang.Object getListObject (int row) throws Exception {
        java.lang.Object recordObject   =   null;


        if(SelectRecords!=null) {
			if( row < getSize("SELECT") )
	            recordObject = (java.lang.Object) SelectRecords.get(row);
		}
        return recordObject;
    }

	/**
	  * Used to remove a record from the Associted record set ArrayList at the desired position
	  * @param row refers to a index position.
	  * @return true if the object is successfully removed else false
	  */
    public boolean removeObject (int row) throws Exception {
		if( row < getSize("DB") ) {
			DbRecords.remove(row);
			return true;
		}
		else {
			return false;
		}
    }

	/**
	  * Used to search for a record from the Associted record set ArrayList at the desired position
	  * @param code refers the key for searching
	  * @return true if the object is searched successfully else false
	  */
	public boolean containsElement(String code) throws Exception{
		java.util.HashMap hash = new java.util.HashMap();
		boolean containsElement = false;
		boolean existFlag		= false;
		String status ="";
		if(DbRecords!=null){

			for(int i=0; i<DbRecords.size(); i++){

				hash =(java.util.HashMap)getObject(i);
				//System.out.println("in containsElement#####1111hash="+hash);
				containsElement = hash.containsValue(code);
				//System.out.println("in containsElement#####1111containsElement="+containsElement);
				if(containsElement){
					status = (String)hash.get("status");
						if(status.equals("N")){
							existFlag = true;
							break;
						}
					}
				}
			}
			return existFlag;
		}

	/**
	  * Used to fetch for a valid record in a database from the Associted record set
	  * ArrayList at the desired position
	  * @param serachObject refers the key for searching
	  * @return String as "Y" if the object is searched successfully else "N"
	  */
	public String getValidKey(String serachObject) throws Exception{
		java.util.HashMap hash = new java.util.HashMap();
		boolean containsElement = false;
		String valid="N";
		if(DbRecords!=null){
			for(int i=0; i<DbRecords.size(); i++){
				hash =(java.util.HashMap)getObject(i);
				containsElement = hash.containsValue(serachObject);	 
				if(containsElement){
					valid = (String)hash.get("valid");
					break;
				}
			}
		}
		return valid;
	}

	/**
	  * Used to search for a object from the other Collection Object
	  * @param searchObject refers the key for searching
	  * @return true if the object is searched successfully else false
	  */
    public boolean containsObject (String searchObject) throws Exception {
        boolean containsRecord  =   false;
		containsRecord = containsElement(searchObject);
		return containsRecord;
    }

	/**
	  * Used to return the index of the search object
	  * @param searchObject refers the key for searching
	  * @return the index of the search object
	  */
	public int indexOfObject (java.lang.Object searchObject) throws Exception {
        int recordIndex     =   -1;
        if(DbRecords!=null)
            recordIndex =  DbRecords.indexOf(searchObject);
        return recordIndex;
    }

	/**
	  * Used to remove record from the Associated ArrayList based on existence the record
	  * in the ArrayList.
	  *	@param searchObject refers the key for searching
	  * @return true if sucessfully deleted else false
	  */
	public boolean removeRecord(java.util.HashMap searchObject)throws Exception{
		String searchCode =(String)searchObject.get("code");
		java.util.HashMap hash = new java.util.HashMap();
		boolean containsElement = false;
		boolean deleteRecord = false;
		String valid = "";
 		if(DbRecords!=null){
			for(int i=0; i<DbRecords.size(); i++){
				hash =(java.util.HashMap)getObject(i);
				containsElement = hash.containsValue(searchCode);
				if(containsElement){
					valid = (String)hash.get("valid");
					if(valid.equals("N")){
						deleteRecord = removeObject(i);
						break;
					}
				}
			}
		}
		return deleteRecord;
	}

	/**
	  * Used to Scan for a particular record based on the key
	  * in the Associated ArrayList.
	  * @param searchObject refers object for searching
	  * @return foundIndex as -1 when not found else the index position
	  */
	public int scanRecord(java.util.HashMap searchObject)throws Exception{
		boolean containsElement = false;
		int foundIndex = -1;
		String searchCode =(String)searchObject.get("code");
		java.util.HashMap hash = new java.util.HashMap();
		if(DbRecords!=null){
			for(int i=0; i<DbRecords.size(); i++){
				hash =(java.util.HashMap)getObject(i);
				containsElement = hash.containsValue(searchCode);
				if(containsElement){
					foundIndex = i;
					break;
				}
			}
		}
		return foundIndex;
	}

	/**
	  * Used to set the latest status of the bean value and inturn
	  * keep both to ArrayList in Synchronize, based on the operations
	  * performed on them.
	  * @param rowIndex refers the row Position.
	  *	@param value refers to the latest value.
	  */
	public boolean setBeanValue(int rowIndex, String value)throws Exception{
		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = 0;
		java.util.HashMap hash = new java.util.HashMap();

		hash = (java.util.HashMap)getListObject(rowIndex);

		
		if(value.equals("Y")){
			hash.put("associate_yn", "Y");
			altSelRecord = setListObject(rowIndex, hash);

			if(altSelRecord){
				foundIndex = scanRecord(hash);
				if(foundIndex != -1){
					altDBRecord = setObject(foundIndex,hash);
				}else{
					altDBRecord = putObject(hash);
				}
			}
		}else if(value.equals("N")){
			hash.put("associate_yn", "D");
			altSelRecord = setListObject(rowIndex, hash);   
			if(altSelRecord){
				altDBRecord =removeRecord(hash);
			}

		}
		return altDBRecord;
	}


	/**
	  * Used to set the latest status of the bean value in the Associted records and inturn
	  * keep both to ArrayList in Synchronize, based on the operations
	  * performed on them.
	  * @param rowIndex refers the row Position.
	  *	@param value refers to the latest value.
	  */
	public boolean setDBBeanValue(int rowIndex, String value)throws Exception{
		boolean altDBRecord =	false;
		String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)getObject(rowIndex);
		//System.out.println("hash#########################"+hash)	;
		valid = (String)hash.get("valid");
		if(valid.equals("Y")){
			if(value.equals("N")){
				hash.put("associate_yn", "D");
				altDBRecord = setObject(rowIndex,hash);
			}else if(value.equals("Y")){
				hash.put("associate_yn", "Y");
				altDBRecord = setObject(rowIndex,hash);
			}
		}else if(valid.equals("N")){
			if(value.equals("N")){
				hash.put("associate_yn", "D");
				hash.put("status"	   , "Y");
				altDBRecord = setObject(rowIndex,hash);
			}else if(value.equals("Y")){
				hash.put("associate_yn", "Y");
				altDBRecord = setObject(rowIndex,hash);
			}
		}
		return altDBRecord;
	}

 public boolean setDBBeanValue(int rowIndex, String value, String value1)throws Exception{
		boolean altDBRecord =	false;
		String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)getObject(rowIndex);
		valid = (String)hash.get("valid");
		if(valid.equals("Y")){
			if(value.equals("N")){
				hash.put("associate_yn", "D");
				if(value1.equals("N")){
                 hash.put("default_yn", "D");
				}
				altDBRecord = setObject(rowIndex,hash);
			}else if(value.equals("Y")){
			hash.put("associate_yn", "Y");
            if(value1.equals("Y")){
				  hash.put("default_yn", "Y");
				}
				else
				{
					hash.put("default_yn", "N");
				}
				altDBRecord = setObject(rowIndex,hash);
			}
		}
		else if(valid.equals("N"))
		{
			if(value.equals("N"))
			{
				 if(value1.equals("N"))
				{
					hash.put("default_yn", "D");
				}
				hash.put("associate_yn", "D");
				hash.put("status"	   , "Y");
				altDBRecord = setObject(rowIndex,hash);
			}
			else if(value.equals("Y"))
			{
				 if(value1.equals("Y"))
				{
					  hash.put("default_yn", "Y");
				}
				else
				{
					 hash.put("default_yn", "N");
				}
				hash.put("associate_yn", "Y");
				altDBRecord = setObject(rowIndex,hash);
			}
		}
		return altDBRecord;
	}

   public boolean setBeanValue(int rowIndex, String value,String value1)throws Exception
   {
		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = 0;
		java.util.HashMap hash = new java.util.HashMap();
        hash = (java.util.HashMap)getListObject(rowIndex);
		if(value.equals("Y"))
		{
			if(value1.equals("Y"))
			{	
			   hash.put("default_yn", "Y");
			}
			else
			{ 
				 hash.put("default_yn", "N");
			}

			hash.put("associate_yn", "Y");
			altSelRecord = setListObject(rowIndex, hash);

			if(altSelRecord)
			{
				foundIndex = scanRecord(hash);
				if(foundIndex != -1)
				{
					altDBRecord = setObject(foundIndex,hash);
				}
				else
				{
					altDBRecord = putObject(hash);
				}
			}
		}
		else if(value.equals("N"))
		{
			if(value1.equals("Y"))
			{	
			   hash.put("default_yn", "Y");
			}
			else
			{
				 hash.put("default_yn", "N");
			}
			hash.put("associate_yn", "D");
			altSelRecord = setListObject(rowIndex, hash);   
			if(altSelRecord)
			{
				altDBRecord =removeRecord(hash);
			}
		}
		return altDBRecord;
	}

	 public void putObjectOriginal (Object recordObject)
	{
		try
		{
	         DbRecordsOriginal.add(recordObject);
        }
		catch(Exception e)
		{
			System.out.println("put"+e.toString());
		}
	}
	/*****************Search with String Keys Only in OriginaL dBrECORDS*******************************/
public int containsElementInOriginalDB(String pkeyValues[]) throws Exception{
	java.util.HashMap hash = new java.util.HashMap();

	if(getSize("DBORIGINAL") <= 0)
		return -1 ;


	for(int i=0; i<DbRecordsOriginal.size(); i++){
		int len = pkeyValues.length -1 ;
		hash =(java.util.HashMap)getObjectOriginal(i);
		boolean existFlag		= false;

		while(len >= 0){
			existFlag = hash.containsValue((pkeyValues[len]).trim());
			if(!existFlag)
			break;
			--len;
		}

		if(existFlag)
		return i ;


	}//End of for loop


	return -1;

}


}//end of class




