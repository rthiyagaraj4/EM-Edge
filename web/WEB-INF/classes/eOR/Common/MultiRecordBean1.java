/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
---------------------------------------------------------------------------------------------------------------------------------
*/

package eOR.Common ;
import javax.servlet.http.*;
import java.util.*;

public class MultiRecordBean1 implements java.io.Serializable{

	java.util.ArrayList DbRecordsOriginal   =   null;
	java.util.ArrayList DbRecords			=   null;
	java.util.ArrayList SelectRecords       =   null;

	public String tempChkM1 = "";
	public String tempChkM2 = "";

    public MultiRecordBean1(){
        DbRecords			=   new java.util.ArrayList(); //Ascc tab
		SelectRecords		=   new java.util.ArrayList(); //Select tab
		DbRecordsOriginal   =   new java.util.ArrayList(); //Original Db tab
    }


	/**
		Store all the records when a particular Alphabet is selected.
	*/
	public java.util.ArrayList getAllDBRecords(){
		return this.DbRecords;
	}


	/**
		Store the records when the particluar rec is selected + the rec
		first selected from DataBase
	*/
	public java.util.ArrayList getAllSelectRecords(){
		return this.SelectRecords;
	}


	/****************************************************************************/

    public int getSize(String value){
        int size = 0;
		if(value.equalsIgnoreCase("DB")){
			if(DbRecords!=null)
				size    =   DbRecords.size();
		}else if(value.equalsIgnoreCase("SELECT")){
			if(SelectRecords!=null)
				size    =   SelectRecords.size();
		}else if(value.equalsIgnoreCase("DBORIGINAL")){
			if(DbRecordsOriginal!=null)
				size    =   DbRecordsOriginal.size();
		}
        return size;
    }

/****************************************************************************/
    public void clearDBRec(){
		if(!DbRecords.isEmpty())
        DbRecords.clear();
     }
 /****************************************************************************/
    public void clearDBRecOriginal(){
		if(!DbRecordsOriginal.isEmpty())
        DbRecordsOriginal.clear();
     }
/****************************************************************************/
	public void clearSelectRec() {
		if(!SelectRecords.isEmpty())
        SelectRecords.clear();
    }
/****************************************************************************/
 public void putObject (Object recordObject) {
		try{
            DbRecords.add(recordObject);
        }catch(Exception e){System.out.println("put"+e.toString());}
 }
/****************************************************************************/
 public void putObjectOriginal (Object recordObject){
		try{
            DbRecordsOriginal.add(recordObject);
        }catch(Exception e){System.out.println("put"+e.toString());}
 }
/****************************************************************************/
	public void putListObject (Object recordObject){
		try{
            SelectRecords.add(recordObject);
        }catch(Exception e){System.out.println("put"+e.toString());}
    }

/**************DbRecords*****************************************************/

  public void setObject (String pKey[], Object recordObject) throws Exception {

  try{
		int index =	containsElement(pKey) ;

		if(index == -1){
			putObject(recordObject);
			return ;
	}

		DbRecords.remove(index);
		DbRecords.add(index,recordObject);

	 }catch(Exception e){
            throw new Exception("Exception@setObject: "+e);
     }
}

/*********************************************************************/
	public java.lang.Object getObject (int row) throws Exception {
		//tempChkM1 +=""+1 ;
		tempChkM1 = tempChkM1+""+1 ;
        java.lang.Object recordObject   =   null;
        if(DbRecords!=null) {
			if( row < getSize("DB") )
	            recordObject = (java.lang.Object) DbRecords.get(row);
		}
        return recordObject;
    }
/*********************************************************************/
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
	public java.lang.Object getListObject (int row) throws Exception {
        java.lang.Object recordObject   =   null;
        if(SelectRecords!=null) {
			if( row < getSize("SELECT") )
	            recordObject = (java.lang.Object) SelectRecords.get(row);
		}
        return recordObject;
    }
/**********************************************************************/
public boolean removeObject (int row) throws Exception {

		if( row < getSize("DB") ) {
			DbRecords.remove(row);
			return true;
		}
		else {
			return false;
		}
 }

//ADD new
/*****************Search with String Keys Only in DB Records*******************************/
public int containsElement(String pkeyValues[]) throws Exception{

	java.util.HashMap hash = new java.util.HashMap();

	if(getSize("DB") <= 0)
		return -1 ;


	for(int i=0; i<DbRecords.size(); i++){
		int len = pkeyValues.length -1 ;
		hash =(java.util.HashMap)getObject(i);
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
/********  modified in ascc tab*******/
public void setDBBeanValue(int rowIndex, Hashtable ht)throws Exception {
		String valid ="";
		String  include = (String)ht.get("include");
		java.util.HashMap hash = null;
		hash = (java.util.HashMap)getObject(rowIndex);
		valid = (String)hash.get("valid");

		if(valid.equals("Y")){	//Db Record
			if(include.equals("N")){
				hash.put("associate_yn", "N");
			}else if(include.equals("Y")){
				hash.put("associate_yn", "Y");
			}
		}else if(valid.equals("N")){
			if(include.trim().equalsIgnoreCase("N")){
				hash.put("associate_yn", "N");
				hash.put("status"	   , "Y");
			}else if(include.trim().equalsIgnoreCase("Y")){
				hash.put("associate_yn", "Y");
			}
		}


	    Enumeration keys = ht.keys() ;
		while(keys.hasMoreElements()){
		Object key = keys.nextElement();
		hash.put(key,ht.get(key));
		}

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

/***********************************************************************/
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

	//IN062992, starts
	public void setObjectOriginal (String pKey[], Object recordObject) throws Exception 
	{
		try
		{
			int index =	containsElement(pKey) ;

			if(index == -1)
			{
				putObjectOriginal(recordObject);
				return ;
			}

			DbRecordsOriginal.remove(index);
			DbRecordsOriginal.add(index,recordObject);
		}
		catch(Exception e)
		{
			throw new Exception("Exception@setObjectOriginal: "+e);
		}
	}
	//IN062992, ends
}//end of class
