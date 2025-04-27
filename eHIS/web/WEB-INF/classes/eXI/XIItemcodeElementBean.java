/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
import java.util.ArrayList;

/**
 * Bean Class used to represent the XIItemcodeElementBean
 *
 */

public class XIItemcodeElementBean 
{ 
 private String item_code;private String long_desc;private String xi_uom_code;private String item_class_code;private String material_group_code;private String gen_uom_code;private String qty_on_order;private String sale_uom_code;private String completed_yn;
 private String application_id;private String facility_id;private String event_type;private String trx_no;private String trx_date;private String load_status;private String comm_status;
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
   * Method gets in use
   * 
   */
   public String getCompletedYN()
   {
    return (completed_yn);
   }

/**
   * Method sets CompletedYN
   * @param  String str
   */
    public void setCompletedYN(String str)
    {
       this.completed_yn = str;
     }

/**
   * Method gets format type
   * 
   */
  public String getSaleUomCode()
  {
    return (sale_uom_code);
  }

/**
   * Method sets SaleUomCode
   * @param  String str
   */

  public void setSaleUomCode(String str)
  {
    this.sale_uom_code = str;
  } 






public String getGenUomCode()
  {
    return (gen_uom_code);
  }

/**
   * Method sets GenUomCode
   * @param  String str
   */

  public void setGenUomCode(String str)
  {
   this.gen_uom_code = str;
  }










/**
   * constructor XIItemcodeElementBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
   public XIItemcodeElementBean(String item_code,String long_desc,String xi_uom_code,String item_class_code,String material_group_code,String gen_uom_code,String qty_on_order,String sale_uom_code,String completed_yn,String application_id,String facility_id,String event_type,String trx_no,String trx_date,String load_status,String comm_status )
   {
     this.item_code = item_code;
     this.long_desc = long_desc;
     this.xi_uom_code = xi_uom_code;
     this.item_class_code = item_class_code;
     this.material_group_code = material_group_code;
	 this.gen_uom_code = gen_uom_code;
	 this.qty_on_order=qty_on_order;
	this.sale_uom_code=sale_uom_code;
	this.completed_yn=completed_yn;
this.application_id=application_id;
this.facility_id=facility_id;
this.event_type=event_type;
this.trx_no=trx_no;
this.trx_date=trx_date;
this.load_status=load_status;
this.comm_status=comm_status;
   }
 
   /**
   * Method gets mastrer coden 
   * 
   */
  public String getMasterCode()
  {
    return(this.item_code);
  }
   /**
   * Method gets  description 
   * 
   */
  public String getDescription()
  {
    return(this.long_desc);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setMasterCode(String str)
  {
    this.item_code =  str;
  }
  /**
   * Method sets clr
   * @param  String str
   */
 
  /**
   * Method sets description
   * @param  String str
   */
  public void setDescription(String str)
  {
    this.long_desc = str;
  }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
     ArrayList arrList = new ArrayList(6);
     arrList.add(item_code);
     arrList.add(long_desc);
     arrList.add(xi_uom_code);
     arrList.add(this.item_class_code);
     arrList.add(this.material_group_code);
	 arrList.add(this.gen_uom_code);
     return(arrList);
  
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(15);
    
    arrList.add(item_code);
    arrList.add(long_desc);
    arrList.add(xi_uom_code);
    arrList.add(this.item_class_code);
    arrList.add(this.material_group_code);
	arrList.add(this.gen_uom_code);
    arrList.add(qty_on_order);
    arrList.add(sale_uom_code);
    arrList.add(completed_yn);
	arrList.add(this.application_id);
	arrList.add(this.facility_id);
	arrList.add(this.event_type);
	arrList.add(this.trx_no);
	arrList.add(this.trx_date);
	arrList.add(this.load_status);
	arrList.add(this.comm_status);
	//arrList.add(Translate_query);
	//arrList.add(Masterid);
	//arrList.add(fieldchange);



	   
    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
    return(new String[]{"",this.item_code,this.long_desc, this.gen_uom_code,this.sale_uom_code,completed_yn,this.application_id,this.facility_id,this.event_type,this.trx_no,this.trx_date,this.load_status,this.comm_status,xi_uom_code});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {
    return(this.changed);
  }
}
//end of class
