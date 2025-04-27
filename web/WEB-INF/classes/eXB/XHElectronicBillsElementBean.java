/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB; 
import java.util.ArrayList;

/**
 * Bean Class used to represent the XHElectronicBillsElementBean
 *
 */

public class XHElectronicBillsElementBean 
{ 	
    private ArrayList allRecords=new ArrayList();
	private boolean changed = false;

 /**															 						   
   * Method sets changed boolean value
   * 
   */
 
   public void setChanged()										    
  {
    this.changed =  true;
  }

/**
   * Method sets elementsvalue
   * @param  String str
   */
  
 																	   
		
	  
   public XHElectronicBillsElementBean(ArrayList elements)
   {
		 this.allRecords=elements;

    }
 /**
   * Method gets clr
   * 
   */  
   /**
   * Method gets  description 
   * 
   */
 
/**
   * Method gets Arraydata 
   * @return ArrayList																		 
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
	 ArrayList arrList = new ArrayList(1);
     arrList.add(this.allRecords);
     return(arrList);
   }
/**
   * Method gets Arraydata 								    
   * @return ArrayList
   */
  public ArrayList getArrayData()	  
  {
  										    
    return(this.allRecords);
  }		
/**
   * Method gets Databasedata array 							  
   * @ return string array
   */
   public String[] getDatabaseData()    
  {
    return(new String[]{(this.allRecords).toString()});	
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {																		 	 
    return(this.changed);
  }

  												  
 

public void setData(ArrayList str)
  {																	   
    this.allRecords = str;
  }

  public ArrayList getData()
  {
   return (this.allRecords);
  }																				  


}
//end of class
