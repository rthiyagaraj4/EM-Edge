/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.util.ArrayList;

/**
 * Bean Class used to represent the XHGatewayListElementBean
 *
 */

public class XHGatewayListElementBean 
{ 										   
	private String protocol_link_id;
	private String protocol_link_name;
	private String Option_yn;
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
  
 																	   

							 
													   									   

/**
   * constructor XHGatewayListElementBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  

	  
   public XHGatewayListElementBean(String protocol_link_id,String protocol_link_name,String Option_yn)
   {
     this.protocol_link_id = protocol_link_id;
     this.protocol_link_name = protocol_link_name;
     this.Option_yn = Option_yn;
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
     ArrayList arrList = new ArrayList(3);
     arrList.add(protocol_link_id);
     arrList.add(protocol_link_name);
     arrList.add(Option_yn);
     return(arrList);
     
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(3);
    arrList.add(this.protocol_link_id);
    arrList.add(this.protocol_link_name);
    arrList.add(this.Option_yn);
    return(arrList);		    
  }
/**
   * Method gets Databasedata array 							  
   * @ return string array
   */
   public String[] getDatabaseData()    
  {
    //return(new String[]{"",this.elementCode,this.inuseYN, this.formatType,this.elementValue,translate_entity,ehis_entity,concatenate_Attributes,Translate_query,this.fieldchange});
	return(new String[]{"",this.protocol_link_id,this.protocol_link_name,this.Option_yn});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {																		 
    return(this.changed);
  }

  public XHGatewayListElementBean(String Option_yn)
{
	this.Option_yn=Option_yn;
}

 public void setOptionYN(String opt)
  {
    this.Option_yn =  opt;
  }

	public String getOptionYN()
  {
    return(this.Option_yn);
  }

																				  


}
//end of class
