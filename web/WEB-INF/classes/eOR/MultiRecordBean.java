/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

public class MultiRecordBean implements java.io.Serializable{

    java.util.ArrayList DbRecords   =   null;
	java.util.ArrayList SelectRecords   =   null;

    public MultiRecordBean(){
        DbRecords		=   new java.util.ArrayList();
		SelectRecords   =   new java.util.ArrayList();
    }

	public MultiRecordBean(MultiRecordBean DbRecords, MultiRecordBean SelectRecords){
		this.DbRecords	=	new java.util.ArrayList(DbRecords.DbRecords);
		this.SelectRecords	=	new java.util.ArrayList(SelectRecords.SelectRecords);
	}

	public java.util.ArrayList getAllDBRecords(){
		return this.DbRecords;
	}

	public java.util.ArrayList getAllSelectRecords(){
		return this.SelectRecords;
	}

    public int getSize(String value){
        int size = 0;
		if(value.equals("DB")){
			if(DbRecords!=null)
				size    =   DbRecords.size();
		}else if(value.equals("SELECT")){
			if(SelectRecords!=null)
				size    =   SelectRecords.size();

		}
        return size;
    }

    public boolean clearDBRec() throws Exception {
        DbRecords.clear();
        return true;
    }

	public boolean clearSelectRec() throws Exception {
        SelectRecords.clear();
        return true;
    }

    public boolean putObject (Object recordObject) throws Exception {
		try{
            DbRecords.add(recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@putObject: "+e);
        }
        return true;
    }

	public boolean putListObject (Object recordObject) throws Exception {
		try{
            SelectRecords.add(recordObject);
        }
        catch(Exception e){
            throw new Exception("Exception@putObject: "+e);
        }
        return true;
    }


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

    public java.lang.Object getObject (int row) throws Exception {
        java.lang.Object recordObject   =   null;
        if(DbRecords!=null) {
			if( row < getSize("DB") )
		//		System.out.println("@@@inMultRecgetObjVals :"+DbRecords);
	            recordObject = (java.lang.Object) DbRecords.get(row);
		}
        return recordObject;
    }

	public java.lang.Object getListObject (int row) throws Exception {
        java.lang.Object recordObject   =   null;
        if(SelectRecords!=null) {
			if( row < getSize("SELECT") )
	            recordObject = (java.lang.Object) SelectRecords.get(row);
		}
        return recordObject;
    }

    public boolean removeObject (int row) throws Exception {
		if( row < getSize("DB") ) {
			DbRecords.remove(row);
			return true;
		}
		else {
			return false;
		}
    }

public boolean containsElement(String code) throws Exception{

	java.util.HashMap hash = new java.util.HashMap();
	boolean containsElement = false;
	boolean existFlag		= false;
	String status ="";
	if(DbRecords!=null){

		for(int i=0; i<DbRecords.size(); i++){

			hash =(java.util.HashMap)getObject(i);
			containsElement = hash.containsValue(code);
			if(containsElement){
				status = (String)hash.get("status");
					if(status.equals("N")){
						existFlag = true;
						break;
					}
			}
					//else
					//	continue;
			/*
			code =(String)hash.get("code");
			valid = (String)hash.get("valid");
			if(valid.equals("Y")){
			containsRecord = code.equals(searchObject);
			}
			*/
			}
		}
		return existFlag;
	}


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

    public boolean containsObject (String searchObject) throws Exception {
        boolean containsRecord  =   false;
		containsRecord = containsElement(searchObject);
		return containsRecord;
    }

	/*public String isAssociated(String searchObject) throws Exception {
        String code = "", associate_yn="N";
		java.util.HashMap hash = new java.util.HashMap();

		if(DbRecords!=null){
			for(int i=0; i<DbRecords.size(); i++){
			hash =(java.util.HashMap)getObject(i);
			code =(String)hash.get("code");
			if(code.equals("searchObject")){
				associate_yn = (String)hash.get("associate_yn");
				return associate_yn;
			}

			break;
			}
		}
		return associate_yn;
    }
	*/
    public int indexOfObject (java.lang.Object searchObject) throws Exception {
        int recordIndex     =   -1;
        if(DbRecords!=null)
            recordIndex =  DbRecords.indexOf(searchObject);
        return recordIndex;
    }

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

	/***Alter Record**Starts here**/
	public int scanRecord(java.util.HashMap searchObject)throws Exception{
		boolean containsElement = false;
		//boolean alterRecord = false;
		//String valid = "";
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
					//valid = (String)hash.get("valid");
					//if(valid.equals("N")){
					//	alterRecord = setObject(i,hash);
					//	break;
					//}else{
					//	alterRecord = putObject(hash);
					//	break;
					//}
				}
			}
		}
		return foundIndex;
	}
	/***Ends Here****/
	public boolean setBeanValue(int rowIndex, String value)throws Exception{
		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = 0;
		//String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		//java.util.HashMap hashDB = new java.util.HashMap();

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
				/*
				index = indexOfObject(hash);
				if(index == -1)
					altDBRecord = putObject(hash);
				else
					altDBRecord = setObject(index,hash);
				*/
			}

		}else if(value.equals("N")){
			hash.put("associate_yn", "D");
			altSelRecord = setListObject(rowIndex, hash);
			if(altSelRecord){
				altDBRecord =removeRecord(hash);
				/*
				index = indexOfObject(hash);
				if(index != -1){
					hashDB =  (java.util.HashMap)getObject(index);
					valid =(String)hashDB.get("valid");
					if(valid.equals("N")){
						altDBRecord = removeObject(index);
					}
				}
				*/
			}

		}
		return altDBRecord;
		//return index;
	}

	/********/

	public boolean setDBBeanValue(int rowIndex, String value)throws Exception{
		boolean altDBRecord =	false;
		String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)getObject(rowIndex);
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
	/********/

}//end of class




