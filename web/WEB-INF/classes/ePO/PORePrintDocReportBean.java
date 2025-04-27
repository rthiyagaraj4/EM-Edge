/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePO;

import eCommon.Common.CommonAdapter;
import ePO.Common.PoTransaction;
import ePO.Common.PoRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class PORePrintDocReportBean extends PoTransaction
    implements Serializable
{
	//private String language;
    public ArrayList getTrnTypeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
//* pmd 21/02/2005
//*        Object obj = null;
        try
        {
            connection = getConnection();
            //preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRN_TYPE_SELECT_LIST2"));
            preparedstatement = connection.prepareStatement("SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL') ORDER BY 2");
          
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
          }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }
   
  /* public void setLanguageId(String language) {
		this.language = language;
	}
   public String getLanguageId() {
		return this.language;
	}
*/
    public String getReportType()
    {
        return getStaticListOptionTag("A,All;Z,Zero Stock;N,Non Zero;M,Item Below Minimum Level;R,Items Below Reorder Level;");
    }

    public String getNatureSelection()
    {
        return getStaticListOptionTag("A,Both;E,Enabled;D,Disabled");
    }

       
    public String getReportOrder()
    {
        return getStaticListOptionTag("I,Item Code;S,Short Description;");
    }
    public String getSpecialItem()
    {
        return getStaticListOptionTag("A,Both;Y,Special Item Only;N,Non Special Item Only;");
    }
/*
    public String getAutoclavable()
    {
        return getStaticListOptionTag("A,All Items;Y,Autoclavable Only ;N,Non Autoclavable;");
    }

    public String getReorderable()
    {
        return getStaticListOptionTag("A,All Items;Y,Reorderable Only ;N,Non Reorderable;");
    }
*/
    public String getStaticListOptionTag(String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        StringTokenizer stringtokenizer1;
        String s2;
        String s3;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ";"); stringtokenizer.hasMoreTokens(); stringbuffer.append("<option value=\"" + s2 + "\" " + s3 + ">" + stringtokenizer1.nextToken() + "</option>\n"))
        {
            stringtokenizer1 = new StringTokenizer(stringtokenizer.nextToken(), ",");
            s2 = stringtokenizer1.nextToken();
            s3 = s1.equalsIgnoreCase(s2) ? "selected" : "";
        }
        return stringbuffer.toString();
    }

    public String getStaticListOptionTag(String s)
    {
        return getStaticListOptionTag(s, "");
    }

	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_STORE_SELECT_LIST"),getLoginFacilityId()));
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ITEM_ANAL_CODE_SELECT_SINGLE")));
	}
	//21/06/12
	  public String getPurchaseUnitList() {
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginById());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PUR_UNIT_LIST"),sqlParam)); 
		
	   }
	
	public String getRequestToSupp() {					
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,"");
		
		}
	public String getRequestToSupp(String supp_code) {					
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,supp_code);
		
		}	
	

//    public String module_id;


	 public ArrayList getResult(String trn_type,String doc_type_code, String fr_st_code, String dt_from,String dt_to,String doc_no,String pur_unit,String supp_code)   throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList record = new ArrayList();
		ArrayList result	=	new ArrayList();
        try
        {
            connection = getConnection();

			System.out.println("trn_type bnean====>" +trn_type);

			if(trn_type.equals("POREQN")) {

            preparedstatement = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_REQ_PRINT_LIST"));

			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,pur_unit);			
			preparedstatement.setString(5,fr_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,trn_type);
			preparedstatement.setString(9,getLanguageId());
			resultset = preparedstatement.executeQuery();

				while(resultset!=null && resultset.next()) {
					record	=	new ArrayList();

					String	p_doc_type_code	=resultset.getString("REQ_CODE");
					String	p_doc_type_desc	=resultset.getString("SHORT_DESC");
					String	p_doc_no		=resultset.getString("REQ_NO");
					String	p_doc_date		=resultset.getString("REQ_DATE");
					String	p_doc_ref		=resultset.getString("REQ_REF");
					String	p_store_code	=resultset.getString("REQ_STORE_CODE");
					String	p_store_desc	=resultset.getString("store_desc");
					String	pur_unit_code	=resultset.getString("PUR_UNIT_CODE");
					String	pur_unit_desc	=resultset.getString("pur_desc");
					

					record.add(p_doc_type_code);
					record.add(p_doc_type_desc);
					record.add(p_doc_no);
					record.add(p_doc_date);
					record.add(p_doc_ref);
					record.add(p_store_code);
					record.add(p_store_desc);
					record.add(pur_unit_code);
					record.add(pur_unit_desc);				

					result.add(record);
				}
			} 
			else if(trn_type.equals("PORDER")) {

           preparedstatement = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_ORDER_PRINT_LIST"));

			 preparedstatement.setString(1,login_facility_id);
			 preparedstatement.setString(2,doc_type_code);
			 preparedstatement.setString(3,doc_no);
			 preparedstatement.setString(4,pur_unit);
			 preparedstatement.setString(5,supp_code);
			 preparedstatement.setString(6,dt_from);
			 preparedstatement.setString(7,dt_to);
			 preparedstatement.setString(8,getLanguageId());
			 preparedstatement.setString(9,trn_type);

			resultset = preparedstatement.executeQuery();

				while(resultset!=null && resultset.next()) {
					record	=	new ArrayList();

					String	p_doc_type_code	=resultset.getString("PO_MASTER_CODE");
					String	p_doc_type_desc	=resultset.getString("short_desc");
					String	p_doc_no		=resultset.getString("PO_NO");
					String	p_doc_date		=resultset.getString("PO_DATE");
					String	p_doc_ref		=resultset.getString("PO_REF");
					String	pur_unit_code	=resultset.getString("PUR_UNIT_CODE");
					String	pur_unit_desc	=resultset.getString("pur_desc");
					String	suppl_code	=resultset.getString("SUPP_CODE");
				    String	supp_desc	=resultset.getString("supp_desc");				

					record.add(p_doc_type_code);
					record.add(p_doc_type_desc);
					record.add(p_doc_no);
					record.add(p_doc_date);
					record.add(p_doc_ref);
					record.add(pur_unit_code);
					record.add(pur_unit_desc);
					record.add(suppl_code);
					record.add(supp_desc);
					
					result.add(record);
				
				}
			}  
			else if(trn_type.equals("DLVORD")) {

           preparedstatement = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_DELV_ORDER_PRINT_LIST"));

			 preparedstatement.setString(1,getLanguageId());
			 preparedstatement.setString(2,doc_type_code);
			 preparedstatement.setString(3,doc_no);
			 preparedstatement.setString(4,supp_code);
			 preparedstatement.setString(5,dt_from);
			 preparedstatement.setString(6,dt_to);			 
			 preparedstatement.setString(7,trn_type);

			resultset = preparedstatement.executeQuery();

				while(resultset!=null && resultset.next()) {
					record	=	new ArrayList();

					String	p_doc_type_code	=resultset.getString("PO_MASTER_CODE");
					String	p_doc_type_desc	=resultset.getString("SHORT_DESC");
					String	p_doc_no		=resultset.getString("DO_NO");
					String	p_doc_date		=resultset.getString("DO_DATE");
					String	p_doc_ref		=resultset.getString("DO_REF");					
					String	suppl_code		=resultset.getString("SUPP_CODE");
				    String	supp_desc		=resultset.getString("SUPP_DESC");				

					record.add(p_doc_type_code);
					record.add(p_doc_type_desc);
					record.add(p_doc_no);
					record.add(p_doc_date);
					record.add(p_doc_ref);
					record.add(suppl_code);
					record.add(supp_desc);
					
					result.add(record);
				
				}
			 }
			}
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return result;
    }

}
