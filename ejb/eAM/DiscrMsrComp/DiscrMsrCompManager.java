/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History     Name           Rev.Date		  Rev.Name		Description
-------------------------------------------------------------------------------------------------------
07/08/2019	IN070957		Ramya Maddena	07/08/2019   Ramesh G
07/01/2025  68801		Gunasekar R	    23/01/2025 	 Twinkle Shah    ML-MMOH-CRF-0579
-------------------------------------------------------------------------------------------------------
*/
package eAM.DiscrMsrComp;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="DiscrMsrComp"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DiscrMsrComp"
*	local-jndi-name="DiscrMsrComp"
*	impl-class-name="eAM.DiscrMsrComp.DiscrMsrCompManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.DiscrMsrComp.DiscrMsrCompLocal"
*	remote-class="eAM.DiscrMsrComp.DiscrMsrCompRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.DiscrMsrComp.DiscrMsrCompLocalHome"
*	remote-class="eAM.DiscrMsrComp.DiscrMsrCompHome"
*	generate= "local,remote"
*
*
*/


public class DiscrMsrCompManager implements SessionBean
{	
	Connection con ;
	PreparedStatement pstmt ;
	Properties	p ;
	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED		= "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED		= "RECORD_MODIFIED" ;	
	String    comp_id				= "";               
	String    long_desc				= "";             
	String    short_desc			= "";            
	String    comp_type				= "";             
	String    min_num_value			= "";         
	String    max_num_value			= "";
	String	  fieldUnit				= "";
	String    dflt_value			= "";            
	String    include_for_anal_yn	= "";   
	String    eff_status			= "";
	String    confidential			= "";
	String	  alpha_info_values		= "";
	String    xml_definition		= "";			                         
	String    list_item_text		= "";        
	String    default_yn			= "";            
	String	  mode					= "";	
	String modified_by_id			= "";
	String modified_facility_id		= "";
	String modified_at_ws_no		= "";
	String histype = "";
	java.sql.Timestamp modified_date = null;			                         
	String added_by_id				="";
	String added_facility_id		="";
	String added_at_ws_no			="";
	java.sql.Timestamp added_date	=null;
	StringBuffer sb					=null;
	java.util.HashMap results	    =null;                      
	java.util.HashMap hashtable	=null;
	//oracle.sql.CLOB			clob_txt_result_val			=	null; //commented and the following line added as part of weblogic migration
	Clob clob_txt_result_val			=	null;
	java.io.Writer			txt_result_val_writer		=	null;
	//java.io.BufferedWriter	bf_txt_result_val_writer	=	null; //commented and the following line added as part of weblogic migration
	java.io.Writer	bf_txt_result_val_writer	=	null;
	boolean result					= false ;

  /***********************added fields************************/
    String ref_ranges="";
	String maxdgt="";
    String mindgt="";
    String decimaldgt="";
    String ref_low="";
    String ref_high="";
    String critical_low="";
    String critical_high="";
	String numeric_details_values="";
       
    String service="";
    String freetext="";
	String appl_to_all_catg_yn ="";
 	String ass_score_yn ="";
    String nu_pre_yn ="";
    String link_yn="";
    String std_ref="";
    String Rec_vital="";
  	String Rec_chart="";
    String Res_rep="";
    String Note_temp="";   
   String discTypeInd=""; 
   String note_templ_char_allowed=""; //68801

  /***********************added fields************************/ 
 
	/****************************** CALL BACK Functions  ****************************************/
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {
	context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertTemplateComponent(Properties properties,HashMap ht) 
	{ 
		results			= new java.util.HashMap() ;
		hashtable		= ht;
		p				= properties  ;
		sb				= new StringBuffer();
		extractValues(); //get all the values from the hashTable	
		String locale="";
		locale= p.getProperty("LOCALE");
		ht.clear();
		try 
		{
			con					= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);					
			if(checkDuplicate()==false) //chk duplicate
				return results;			
			String sql = "INSERT INTO AM_DISCR_MSR(DISCR_MSR_ID,LONG_DESC,SHORT_DESC,SERVICE_CODE,RESULT_TYPE,ACTIVITY_TYPE,NUM_DIGITS_MAX,NUM_DIGITS_MIN,NUM_DIGITS_DEC,REF_RANGE_TYPE,SECURITY_LEVEL,EFF_STATUS,APPL_TO_ALL_CATG_YN,INCLUDE_FOR_ANAL_YN,ASSOCIATE_SCORE_YN,NUMERIC_PREFIX_YN,STD_COMP_ID,MIN_VALUE,MAX_VALUE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,LINK_TO_STD_VALUE_YN, VS_APPL_YN, RS_APPL_YN, CH_APPL_YN, TM_APPL_YN,HIST_REC_TYPE,RESULT_TEMPLATE_ID, CONFIDENTIAL_YN,DISCR_TYPE_ID,note_templ_char_allowed)VALUES(?,?,?,?,?,'',?,?,?,?,'',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Added note_templ_char_allowed for 68801
			
			pstmt = con.prepareStatement(sql);   
			pstmt.setString(1 ,comp_id);    
			pstmt.setString(2 ,long_desc);  
			pstmt.setString(3 ,short_desc); 
			pstmt.setString(4 ,service); 
			pstmt.setString(5 ,comp_type);  
			pstmt.setString(6 ,maxdgt);         
			pstmt.setString(7 ,mindgt);         
			pstmt.setString(8,decimaldgt);  
			pstmt.setString(9,ref_ranges);
      		pstmt.setString(10,eff_status);
			pstmt.setString(11,appl_to_all_catg_yn);
			pstmt.setString(12,include_for_anal_yn);   
			pstmt.setString(13,ass_score_yn); 
			pstmt.setString(14,nu_pre_yn);
			pstmt.setString(15,std_ref);
						
            if(comp_type.equals("I")) 
			{
			pstmt.setString(16,min_num_value);
			pstmt.setString(17,max_num_value);
			}
			else
			{
			pstmt.setString(16,min_num_value);
			pstmt.setString(17,max_num_value);   
	    	}
    		pstmt.setString(18,added_by_id);           
			pstmt.setTimestamp(19,added_date);            
			pstmt.setString(20,added_at_ws_no);        
			pstmt.setString(21,added_facility_id);     
			pstmt.setString(22,modified_by_id);        
			pstmt.setTimestamp(23,modified_date);         
			pstmt.setString(24,modified_at_ws_no);     
			pstmt.setString(25,modified_facility_id);
			
			pstmt.setString(26,link_yn);
            pstmt.setString(27, Rec_vital); 
			pstmt.setString(28, Res_rep); 
			pstmt.setString(29, Rec_chart);  
			pstmt.setString(30, Note_temp); 
			pstmt.setString(31, histype); 
			pstmt.setString(32, freetext); 
			pstmt.setString(33, confidential); 
			pstmt.setString(34, discTypeInd);
			pstmt.setString(35, note_templ_char_allowed); //68801
			
			int res = pstmt.executeUpdate() ;
       			
            boolean res2 = false;
			if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("A") || comp_type.equals("S") )
				res2 = insertMultipleNumericDetail();
			else
		        res2 = true;
			if(pstmt!=null) pstmt.close();
				 
			if ( res != 0 && res2 != false ) 
			{
				result = true ;
			}
			else
			{
				result = false;
			}
			if(result==true && comp_type.equalsIgnoreCase("L") || comp_type.equalsIgnoreCase("M")) //only executed when the component Type is list Box
			{
				if(!insertList())
				{
				 return results;
				}
			}
			else if(result==true && (comp_type.equalsIgnoreCase("P") || comp_type.equalsIgnoreCase("R") ||comp_type.equalsIgnoreCase("X") ))//only executed when the component Type is Paragraph or a grid component
			{
				if(!insertParagraphDefinition())
				{
				 return results;
				}
			}
			if(result)
			{
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
				con.rollback();		
				results.put( "status", new Boolean(result) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
		}
		catch(Exception fe)
		{
			fe.printStackTrace(System.err);
			sb.append("Exception in TemplateComponentManager Watch Point No.100->" + fe);
			results.put( "inception",sb.toString() ) ;
			results.put( "status", new Boolean(false) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
		}
		finally	
		{
			try 
			{
				if (con != null) 
					ConnectionManager.returnConnection(con,p);
				if(pstmt!=null) 
					pstmt.close();
			}
			catch (Exception ee) 
			{
				ee.printStackTrace(System.err);
				sb.append("Exception in TemplateComponentManager Watch Point No.101->" + ee);
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
			}
		}
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/


	public java.util.HashMap modifyTemplateComponent(Properties properties,HashMap ht) 
	{
		
		String locale="";
		locale= (String) properties.getProperty("LOCALE");
		String sql = "" ;
		results = new java.util.HashMap() ;
		sb = new StringBuffer( "" ) ;
		hashtable		= ht;
		p				= properties  ;		 
		extractValues();//get all the values from the hashTable

		ht.clear();
		try 
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);			
			if(mode.equalsIgnoreCase("beforeUpdateEff_status"))//Working Fine
			{
			 sql  = "update AM_DISCR_MSR  set  EFF_STATUS = ?,  MODIFIED_BY_ID = ?,MODIFIED_DATE = ?,  MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID =? , CONFIDENTIAL_YN = ?,DISCR_TYPE_ID= ? where DISCR_MSR_ID = ? ";
     		 pstmt = con.prepareStatement(sql);   
	     	 pstmt.setString(1 ,eff_status);
		     pstmt.setString(2,modified_by_id);      
			 pstmt.setTimestamp(3,modified_date);       
			 pstmt.setString(4,modified_at_ws_no);   
			 pstmt.setString(5,modified_facility_id);
			 pstmt.setString(6,confidential);
			 pstmt.setString(7,discTypeInd);
			 pstmt.setString(8,comp_id);
			 int res = pstmt.executeUpdate() ;
			 if(pstmt!=null) pstmt.close();
			 if ( res != 0 )
				 result = true ;
			 else
				 result = false;

			}//end of if condition Which only enables the status
			else
			{
				sql= "update  AM_DISCR_MSR  set  LONG_DESC = ?,SHORT_DESC = ?,RESULT_TYPE = ?,SERVICE_CODE = ?,NUM_DIGITS_MAX = ?, NUM_DIGITS_MIN = ?, NUM_DIGITS_DEC = ?,      EFF_STATUS = ?,REF_RANGE_TYPE = ?,APPL_TO_ALL_CATG_YN = ?,INCLUDE_FOR_ANAL_YN = ?, ASSOCIATE_SCORE_YN = ?,LINK_TO_STD_VALUE_YN = ?,NUMERIC_PREFIX_YN = ?, STD_COMP_ID = ?,MIN_VALUE = ?,  MAX_VALUE = ?,MODIFIED_BY_ID = ?,MODIFIED_DATE = ?,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID =?,VS_APPL_YN=?, RS_APPL_YN=?, CH_APPL_YN=?, TM_APPL_YN=?,HIST_REC_TYPE = ?,RESULT_TEMPLATE_ID=? , CONFIDENTIAL_YN = ?,DISCR_TYPE_ID=?, note_templ_char_allowed = ? where  DISCR_MSR_ID =  ? ";   //Added note_templ_char_allowed for 68801
				pstmt = con.prepareStatement(sql);   
			
		    
			pstmt.setString(1 ,long_desc);
			pstmt.setString(2 ,short_desc);
			pstmt.setString(3 ,comp_type);
			pstmt.setString(4 ,service); 
			pstmt.setString(5 ,maxdgt);
			pstmt.setString(6 ,mindgt);  
			pstmt.setString(7,decimaldgt); 
			pstmt.setString(8,eff_status);
			pstmt.setString(9,ref_ranges);
			pstmt.setString(10,appl_to_all_catg_yn);
			pstmt.setString(11,include_for_anal_yn); 
			pstmt.setString(12,ass_score_yn); 
			pstmt.setString(13,link_yn);
			pstmt.setString(14,nu_pre_yn);
			pstmt.setString(15,std_ref); 		
			
		
            if(comp_type.equals("I")) 
			{
			pstmt.setString(16,min_num_value);
			pstmt.setString(17,max_num_value);

			}
			else
			{
				pstmt.setString(16,min_num_value);
				pstmt.setString(17,max_num_value);   
         	}
			pstmt.setString(18,modified_by_id);   
			pstmt.setTimestamp(19,modified_date);
			pstmt.setString(20,modified_at_ws_no);  
			pstmt.setString(21,modified_facility_id);
			pstmt.setString(22, Rec_vital); 
			pstmt.setString(23, Res_rep); 
			pstmt.setString(24, Rec_chart);  
			pstmt.setString(25, Note_temp);
			pstmt.setString(26, histype);
			pstmt.setString(27, freetext);
			pstmt.setString(28,confidential);
			pstmt.setString(29,discTypeInd);
			pstmt.setString(30,note_templ_char_allowed); //68801
			pstmt.setString(31,comp_id);
			int res1 = pstmt.executeUpdate();

            boolean res2;
			if(comp_type.equals("I") || comp_type.equals("N" ) || comp_type.equals("A") || comp_type.equals("S" )  )
            res2 = updateMultipleNumericDetail();
			else
            res2 = true;

				if(pstmt!=null) pstmt.close();
				if ( res1 != 0 && res2 != false)
					result = true ;
				else
					result = false;

				if(comp_type.trim().equalsIgnoreCase("L") || comp_type.trim().equalsIgnoreCase("M"))//if the component is List Box than				
				{
					sql = "Delete from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID='" + comp_id +  "'" ;
					results.put("sql",sql);
					pstmt = con.prepareStatement(sql);   
					 pstmt.executeUpdate();
					if(pstmt!=null) pstmt.close();
					result = true;
					if(result) //if the deletion is successfull than we are going to insert all values we get for the list
					{
						if(!insertList())
						{   //Function call to insert the list values
							
							return results;	
						}
					}
				}//end of if block for the full updation inertion  of the list values
				if(comp_type.trim().equalsIgnoreCase("P") || comp_type.trim().equalsIgnoreCase("R") || comp_type.trim().equalsIgnoreCase("X"))//if the component is Paragraph than				
				{
					sql = "Delete from AM_DISCR_COMP_DEFINITION where DISCR_MSR_ID='" + comp_id +  "'" ;
					results.put("sql",sql);
					
					pstmt = con.prepareStatement(sql);
					 pstmt.executeUpdate();
                    
					if(pstmt!=null) pstmt.close();
					
					result = true;
					if(result) //if the deletion is successfull than we are going to insert all values we get for the list
					{
						if(!insertParagraphDefinition()) 
							return results;		
					}			
				}
			}//end of else Block (if effective status enabled before UPdate)


			if(result)
			{
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale,RECORD_MODIFIED,"SM") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
				con.rollback();		


				results.put( "status", new Boolean(result) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
		}
		catch(Exception fe)
		{
			fe.printStackTrace(System.err);
			sb.append("Exception in TemplateComponentManager Watch Point No.102->" + fe);
			results.put("status", new Boolean(false) ) ;
			results.put("error", sb.toString() ) ;
			return results ;
		}
		finally	
		{
			try 
			{
				if (con != null) 
					ConnectionManager.returnConnection(con,p);
				
			}
			catch (Exception ee) 
			{
				ee.printStackTrace(System.err);
				sb.append("Exception in TemplateComponentManager Watch Point No.103->" + ee);
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;			   
			}
		}	
	} //End of Modify Function
	/****************************** Function to Extract Value  FROM THE HASH TABLE****************************************/
	public void extractValues() // to extract values from the has table
	{
		try
		{
			/****************** added fields **********************************/
			    service = (String)hashtable.get("service");
			    histype = (String)hashtable.get("histype");
			    freetext = (String)hashtable.get("freetext");
                
				ref_ranges = (String)hashtable.get("ref_ranges");
                maxdgt = (String)hashtable.get("maxdgt");
                mindgt = (String)hashtable.get("mindgt");
                decimaldgt = (String)hashtable.get("decimaldgt");

                ref_low = (String)hashtable.get("ref_low");
                ref_high = (String)hashtable.get("ref_high");
                critical_low = (String)hashtable.get("critical_low");
                critical_high = (String)hashtable.get("critical_high"); 
				numeric_details_values = (String)hashtable.get("numeric_details_values");

				//eff_status_yn = (String)hashtable.get("eff_status_yn");
                ass_score_yn =  (String)hashtable.get("ass_score_yn");
                nu_pre_yn = (String)hashtable.get("nu_pre_yn");
                link_yn = (String)hashtable.get("link_yn");
                std_ref = (String)hashtable.get("std_ref");
 
				
				appl_to_all_catg_yn= (String)hashtable.get("appl_to_all_catg_yn");
				Rec_vital= (String)hashtable.get("Rec_vital");
				Rec_chart = (String)hashtable.get("Rec_chart");
				Res_rep = (String)hashtable.get("Res_rep");
				Note_temp = (String)hashtable.get("Note_temp");			
				String locale="";
				locale= p.getProperty("LOCALE");
			/****************** added fields **********************************/
			modified_by_id			    =(String)hashtable.get("modified_by_id");
			modified_facility_id		=(String)hashtable.get("modified_facility_id");
			modified_at_ws_no		    =(String)hashtable.get("modified_at_ws_no");
			modified_date				=(java.sql.Timestamp)hashtable.get("modified_date");					
			added_by_id				    = (String)hashtable.get("added_by_id");
			added_facility_id		    = (String)hashtable.get("added_facility_id");
			added_at_ws_no			    = (String)hashtable.get("added_at_ws_no");
			added_date					= (java.sql.Timestamp)hashtable.get("added_date");
			mode						=((String)hashtable.get("mode")==null)?"":(String)hashtable.get("mode");
			comp_id						=((String)hashtable.get("comp_id")==null)?"":(String)hashtable.get("comp_id");
			long_desc					=((String)hashtable.get("long_desc")==null)?"":(String)hashtable.get("long_desc");
			short_desc					=((String)hashtable.get("short_desc")==null)?"":(String)hashtable.get("short_desc");
			comp_type					=((String)hashtable.get("comp_type")==null)?"":(String)hashtable.get("comp_type");
			min_num_value				=((String)hashtable.get("min_num_value")==null || (String)hashtable.get("min_num_value")=="" )?"":(String)hashtable.get("min_num_value");
			max_num_value				=((String)hashtable.get("max_num_value")==null || (String)hashtable.get("max_num_value")=="" )?"":(String)hashtable.get("max_num_value");

			fieldUnit = ((String)hashtable.get("field_unit")==null)?"":(String)hashtable.get("field_unit"); 
			dflt_value					=((String)hashtable.get("dflt_value")==null)?"":(String)hashtable.get("dflt_value");
			include_for_anal_yn			=((String)hashtable.get("include_for_anal_yn")==null)?"":(String)hashtable.get("include_for_anal_yn");

			confidential					=((String)hashtable.get("confidential_yn")==null)?"":(String)hashtable.get("confidential_yn");		
			eff_status					=((String)hashtable.get("eff_status")==null)?"":(String)hashtable.get("eff_status");		
			alpha_info_values			= ((String)hashtable.get("alpha_info_values")==null)?"":(String)hashtable.get("alpha_info_values");
			  discTypeInd             = ((String)hashtable.get("discTypeInd")==null)?"":(String)hashtable.get("discTypeInd");
			if(comp_type.equals("P") || comp_type.equals("R") || comp_type.equals("X"))
				xml_definition = ((String)hashtable.get("xml_definition")==null)?"":(String)hashtable.get("xml_definition");
			
			note_templ_char_allowed = ((String)hashtable.get("note_templ_char_allowed")==null)?"":(String)hashtable.get("note_templ_char_allowed"); //68801

		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			sb.append("Exception in TemplateComponentManager Watch Point No.104->" + e);
		}
	}//End of exctract method
	/****************************** Function to Check  Duplicate  ****************************************/
	public boolean checkDuplicate() //checks for the duplicates in the table
	{
		try 
		{	
			String locale="";
			locale= p.getProperty("LOCALE");	
			final String duplicateSql = "select count(*) from AM_DISCR_MSR where DISCR_MSR_ID =?" ;
			pstmt = con.prepareStatement(duplicateSql) ;
			pstmt.setString(1,comp_id ) ;
			ResultSet rs = pstmt.executeQuery() ;
			int count  = 0;
			if(rs.next())
			count = rs.getInt(1) ;
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
					
			if (count > 0)
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				sb.append( (String) message.get("message") ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				message.clear();
				return false ;
			}
			else
			{
				return true ;
			}
		}
		catch ( Exception e ) 
		{
			e.printStackTrace(System.err);
			//insertable = false ;
			sb.append("Exception in TemplateComponentManager Watch Point No.105->" +  e + "<br>" ) ;
			results.put( "status", new Boolean(false) ) ;
			results.put( "error", sb.toString() ) ;
			e.printStackTrace() ;
			return false ;
		}
	} // end  of the method
	/****************************** Function to insert values in the list ****************************************/
	public boolean insertList() //Function to insert the records using Batch Update(used for both modify & insert)
	{	
		try
		{
			java.util.StringTokenizer st = new java.util.StringTokenizer(alpha_info_values,"`");          
			
			results.put("alpha_info_values:--",alpha_info_values);
			String sql="INSERT INTO AM_DISCR_MSR_REF_RNG_LIST(DISCR_MSR_ID,REF_RANGE_SEQ,REF_RNG_DESC,SORT_ORDER,DFLT_YN,RESULT_VALUE, NUMERIC_VALUE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
           
		   default_yn	= "";            
			String    result_val    = "";
			String    numeric_val   = ""; 
			String    refrangeseqno = "";

			int sortord = 0;
			pstmt = con.prepareStatement(sql);   
			while (st.hasMoreTokens())
			{
				String	  temp = st.nextToken();
				
				java.util.StringTokenizer st1 = new java.util.StringTokenizer(temp,"~");

				while(st1.hasMoreTokens())
				{
					default_yn="";
					numeric_val="";
					refrangeseqno=st1.nextToken();
					list_item_text			= st1.nextToken();
					result_val              = st1.nextToken();
					default_yn				= st1.nextToken(); 
					if(st1.hasMoreElements()) 
                    numeric_val             = st1.nextToken();		
			
                    sortord++;
				}
				pstmt.setString(1,comp_id); 
				pstmt.setInt(2,Integer.parseInt(refrangeseqno.trim())); 
		     	pstmt.setString(3,list_item_text);
				pstmt.setInt(4,sortord);  
				pstmt.setString(5,default_yn); 
				pstmt.setString(6,result_val); 
				pstmt.setString(7,numeric_val); 
				pstmt.setString(8,added_by_id);         
				pstmt.setString(9,added_at_ws_no);      
				pstmt.setString(10,added_facility_id);   
				pstmt.setString(11,modified_by_id);      
				pstmt.setString(12,modified_at_ws_no);   
				pstmt.setString(13,modified_facility_id);	
				pstmt.addBatch();
			}
			int [] updatedCounts = pstmt.executeBatch();
			if(pstmt !=null) 
				pstmt.close();
			if ( updatedCounts.length == -3 ) 
			{
				result = false;
			}
			return true ;				
		} //end of try block
	    catch ( Exception e )
		{
			result = false;
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				return false ;
			}
			sb.append("Exception in TemplateComponentManager Watch Point No.106->" +  e + " in insert <br>" ) ;
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			e.printStackTrace(System.err) ;
			return false;
		}
	}//end of the insert function for the list
	//Malaysia Enhancement date 11/3/2003
	//for inserting paragraph Definition
	public boolean insertParagraphDefinition() 
	{		
		//oracle.sql.CLOB			clob_txt_result_val1			=	null;//Commented and included as part of weblogic migration
		Clob clob_txt_result_val1			=	null;
		//java.io.Writer			txt_result_val_writer1		=	null;//Commented and included as part of weblogic migration
		//java.io.BufferedWriter	bf_txt_result_val_writer1	=	null;//Commented and included as part of weblogic migration
		java.io.Writer	bf_txt_result_val_writer1	=	null;

		try
		{
			
			String sql	= " INSERT INTO AM_DISCR_COMP_DEFINITION(DISCR_MSR_ID, DISCR_MSR_DEF,DISCR_MSR_XML_DEF) values (? ,empty_clob(),empty_clob())" ; 				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1 ,comp_id);             
			pstmt.addBatch();
			int [] updatedCounts = pstmt.executeBatch();
			if ( updatedCounts.length == -3 ) 
				result = false;			
			if(pstmt !=null) 
				pstmt.close();
			if(result)
			{
				PreparedStatement pstmt1=null;
				ResultSet rs1=null;
				try
				{
					String query_clob_object = "select DISCR_MSR_DEF,DISCR_MSR_XML_DEF from AM_DISCR_COMP_DEFINITION where DISCR_MSR_ID = ?  for update ";													
					pstmt1 = con.prepareStatement(query_clob_object);
					pstmt1.setString	(1,	comp_id	);
					rs1 = pstmt1.executeQuery();
					if(rs1.next())
					{
						//clob_txt_result_val			=	(oracle.sql.CLOB) rs1.getObject("DISCR_MSR_DEF");
					//	clob_txt_result_val1		=	(oracle.sql.CLOB) rs1.getObject("DISCR_MSR_XML_DEF");

						clob_txt_result_val			=	rs1.getClob("DISCR_MSR_DEF");
						clob_txt_result_val1		=	rs1.getClob("DISCR_MSR_XML_DEF");
						//txt_result_val_writer		=	((oracle.sql.CLOB)	clob_txt_result_val).getCharacterOutputStream();
						//txt_result_val_writer1		=	((oracle.sql.CLOB)	clob_txt_result_val1).getCharacterOutputStream();
														
						bf_txt_result_val_writer		=	clob_txt_result_val.setCharacterStream(0);
						bf_txt_result_val_writer1		=	clob_txt_result_val1.setCharacterStream(0);
						//bf_txt_result_val_writer	=	new java.io.BufferedWriter(txt_result_val_writer);
						//bf_txt_result_val_writer1	=	new java.io.BufferedWriter(txt_result_val_writer1);

						bf_txt_result_val_writer.write(alpha_info_values,0,alpha_info_values.length());
						bf_txt_result_val_writer1.write(xml_definition,0,xml_definition.length());

						bf_txt_result_val_writer.flush();
						bf_txt_result_val_writer.close();
						bf_txt_result_val_writer1.flush();
						bf_txt_result_val_writer1.close();
					}
					if(rs1!=null) rs1.close();
					if(pstmt1!=null) pstmt1.close();
						
				}
				catch(Exception e)
				{
					e.printStackTrace(System.err);
					result = false;
					return false;
				}
				finally
				{
					try
					{
						
					}
					catch(Exception e)
					{
						e.printStackTrace(System.err);
						e.printStackTrace();
					}
				}
			}
			return true ;
			
		} //end of try block
		catch ( Exception e )
		{
			result = false;
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				return false ;
			}		
			sb.append( "Exception in TemplateComponentManager Watch Point No.107->" + e + " in insert <br>" ) ;
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			e.printStackTrace(System.err);
			return false;
		}
	}//end of the insert Function For the Paragraph	
 
public boolean insertMultipleNumericDetail()
{
	boolean flag = true;
	int j1= 0;
	
	try
	{
		String s19 = " insert into AM_DISCR_MSR_REF_RNG_NUM(DISCR_MSR_ID , REF_RANGE_SEQ , PATIENT_SEX , GESTATON_AGE_YN , START_AGE , START_AGE_UNITS , END_AGE , END_AGE_UNITS , START_AGE_DAYS , END_AGE_DAYS , NUM_REF_LOW , NUM_REF_HIGH , NUM_CRIT_LOW , NUM_CRIT_HIGH , NUM_DFLT_RESULT , NUM_UOM , ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID  )  values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) ";

		if(ref_ranges.equals("M"))
		{
			String s9 = numeric_details_values ;  
			StringTokenizer stringtokenizer1 = new StringTokenizer(s9, "`");
			do
			{
				if(!stringtokenizer1.hasMoreTokens())
					break;
				String s21 = stringtokenizer1.nextToken();
				String s23 = "";
				String s25 = "";
				String s27 = "";
				String s29 = "";
				String s31 = "";
				String s32 = "";
				String s33 = "";
				String s34 = "";
				String s35 = "";
				String s36 = "";
				String s37 = "";
				String s38 = "";
				if(!s21.equals(""))
				{
					for(StringTokenizer stringtokenizer3 = new StringTokenizer(s21, "~"); stringtokenizer3.hasMoreTokens(); stringtokenizer3.nextToken())
					{
					
						s23 = stringtokenizer3.nextToken().substring(0, 1);
						s25 = stringtokenizer3.nextToken();
						s27 = stringtokenizer3.nextToken().substring(0, 1);
						s29 = stringtokenizer3.nextToken();
						s31 = stringtokenizer3.nextToken().substring(0, 1);
						s32 = stringtokenizer3.nextToken();
						s33 = stringtokenizer3.nextToken();
						s34 = stringtokenizer3.nextToken();
						s35 = stringtokenizer3.nextToken();
						s36 = stringtokenizer3.nextToken();
						s37 = stringtokenizer3.nextToken();
						s38 = stringtokenizer3.nextToken();
					}
					//if(s38.equals(" "))s38 = "0";//commented for IN070957

					int i2 = 0;
					int j2 = 0;
		
					if(s27.equals("M"))
						i2 = Integer.parseInt(s25) * 30 + 1;
					else if(s27.equals("Y"))
						i2 = Integer.parseInt(s25) * 365 + 1;
					else
						i2 = Integer.parseInt(s25);

					if(s31.equals("M"))
						j2 = Integer.parseInt(s29) * 30 - 1;
					else if(s31.equals("Y"))
						j2 = Integer.parseInt(s29) * 365 - 1;
					else
						j2 = Integer.parseInt(s29);
					pstmt = con.prepareStatement(s19);
					pstmt.setString(1, comp_id);
					pstmt.setInt(2, Integer.parseInt(s32));
					pstmt.setString(3, s23);
					pstmt.setString(4, "N");
					pstmt.setInt(5, Integer.parseInt(s25));
					pstmt.setString(6, s27);
					pstmt.setInt(7, Integer.parseInt(s29));
					pstmt.setString(8, s31);
					pstmt.setInt(9, i2);
					pstmt.setInt(10, j2);
					pstmt.setDouble(11, Double.parseDouble(s33));
					pstmt.setDouble(12, Double.parseDouble(s34));
					pstmt.setDouble(13, Double.parseDouble(s35));
					pstmt.setDouble(14, Double.parseDouble(s36));
					//pstmt.setDouble(15, Double.parseDouble(s38));//commented for IN070957 
					pstmt.setString(15, (s38.trim()));// added for IN070957
					pstmt.setString(16, s37);
					pstmt.setString(17, added_by_id);
					pstmt.setString(18, added_at_ws_no);
					pstmt.setString(19, added_facility_id);
					pstmt.setString(20, added_by_id);
					pstmt.setString(21, modified_at_ws_no);
					pstmt.setString(22, modified_facility_id);
					int k2 = pstmt.executeUpdate();
					if(pstmt !=null) pstmt.close();
					if(k2 == 0) 
						flag = false;
					j1++;
				}
			} while(true);
			return flag;
		}
		else
		{
			j1 =1;
		
			pstmt = con.prepareStatement(s19);
			pstmt.setString(1, comp_id);
			pstmt.setInt(2, j1);
			pstmt.setString(3, "A");
			pstmt.setString(4, "N");
			pstmt.setInt(5, 0);
			pstmt.setString(6, "D");
			pstmt.setInt(7, 150);
			pstmt.setString(8, "Y");
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 54750);
			pstmt.setString(11, ref_low);
			pstmt.setString(12, ref_high);
			pstmt.setString(13, critical_low);
			pstmt.setString(14, critical_high);
			pstmt.setString(15, dflt_value);
			pstmt.setString(16, fieldUnit);
			pstmt.setString(17, added_by_id);
			pstmt.setString(18, added_at_ws_no);
			pstmt.setString(19, added_facility_id);
			pstmt.setString(20, added_by_id);
			pstmt.setString(21, modified_at_ws_no);
			pstmt.setString(22, modified_facility_id);

			int k2 = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(k2 == 0) flag = false;
			return flag; 
		}
	}catch ( Exception e )
	{
		flag = false;
		try
		{
			con.rollback();
		}catch(Exception e1)
		{
			return false ;
		}		
	
		sb.append("Exception in TemplateComponentManager Watch Point No.124->" + e + " in insert <br>");
		results.put( "status", new Boolean(result));
		results.put( "error", sb.toString());
		e.printStackTrace(System.err);
		return false;
	}
}

public boolean updateMultipleNumericDetail()
	{

	 boolean flag = true;
	 int j1= 0;
	 
try
		{
  
 

  if(ref_ranges.equals("M"))
			{

	        String sql="SELECT count(*) FROM AM_DISCR_MSR_REF_RNG_NUM WHERE DISCR_MSR_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,comp_id);
			ResultSet rs = pstmt.executeQuery() ;
			int countrec  = 0;
			if(rs.next())
			countrec = rs.getInt(1) ;

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			if(countrec > 0)
				{

  String squery="DELETE FROM AM_DISCR_MSR_REF_RNG_NUM WHERE DISCR_MSR_ID='"+comp_id+"' ";
  pstmt = con.prepareStatement(squery);
  pstmt.executeUpdate();
  if(pstmt!=null)pstmt.close();

  String s20 = " insert into AM_DISCR_MSR_REF_RNG_NUM(DISCR_MSR_ID , REF_RANGE_SEQ , PATIENT_SEX , GESTATON_AGE_YN , START_AGE , START_AGE_UNITS , END_AGE , END_AGE_UNITS , START_AGE_DAYS , END_AGE_DAYS , NUM_REF_LOW , NUM_REF_HIGH , NUM_CRIT_LOW , NUM_CRIT_HIGH , NUM_DFLT_RESULT , NUM_UOM , ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID  )  values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) ";

  String s9 = numeric_details_values ;  
  StringTokenizer stringtokenizer1 = new StringTokenizer(s9, "`");
                            do
                            {
                                if(!stringtokenizer1.hasMoreTokens())
                                    break;
                                String s21 = stringtokenizer1.nextToken();
                                String s23 = "";
                                String s25 = "";
                                String s27 = "";
                                String s29 = "";
                                String s31 = "";
                                String s32 = "";
                                String s33 = "";
                                String s34 = "";
                                String s35 = "";
                                String s36 = "";
                                String s37 = "";
                                String s38 = "";
                                if(!s21.equals(""))
                                {
                                    for(StringTokenizer stringtokenizer3 = new StringTokenizer(s21, "~"); stringtokenizer3.hasMoreTokens(); stringtokenizer3.nextToken())
                                    {
                                        s23 = stringtokenizer3.nextToken().substring(0, 1);
                                        s25 = stringtokenizer3.nextToken();
                                        s27 = stringtokenizer3.nextToken().substring(0, 1);
                                        s29 = stringtokenizer3.nextToken();
                                        s31 = stringtokenizer3.nextToken().substring(0, 1);
                                        s32 = stringtokenizer3.nextToken();
                                        s33 = stringtokenizer3.nextToken();
                                        s34 = stringtokenizer3.nextToken();
                                        s35 = stringtokenizer3.nextToken();
                                        s36 = stringtokenizer3.nextToken();
                                        s37 = stringtokenizer3.nextToken();
                                        s38 = stringtokenizer3.nextToken();
                                    }
									//if(s38.equals(" "))s38 = "0";// commented for IN070957
                                    int i2 = 0;
                                    int j2 = 0;
                                    if(s27.equals("M"))
                                        i2 = Integer.parseInt(s25) * 30 + 1;
                                    else
                                    if(s27.equals("Y"))
                                        i2 = Integer.parseInt(s25) * 365 + 1;
                                    else
                                        i2 = Integer.parseInt(s25);
                                    if(s31.equals("M"))
                                        j2 = Integer.parseInt(s29) * 30 - 1;
                                    else
                                    if(s31.equals("Y"))
                                        j2 = Integer.parseInt(s29) * 365 - 1;
                                    else
                                        j2 = Integer.parseInt(s29);

                                    pstmt = con.prepareStatement(s20);
                                                                  
                                   
                                    pstmt.setString(1, comp_id);
                                    pstmt.setInt(2, Integer.parseInt(s32));
                                    pstmt.setString(3, s23);
                                    pstmt.setString(4, "N");
                                    pstmt.setInt(5, Integer.parseInt(s25));
                                    pstmt.setString(6, s27);
                                    pstmt.setInt(7, Integer.parseInt(s29));
                                    pstmt.setString(8, s31);
                                    pstmt.setInt(9, i2);
                                    pstmt.setInt(10, j2);
                                    pstmt.setDouble(11, Double.parseDouble(s33));
                                    pstmt.setDouble(12, Double.parseDouble(s34));
                                    pstmt.setDouble(13, Double.parseDouble(s35));
                                    pstmt.setDouble(14, Double.parseDouble(s36));
                                    //pstmt.setDouble(15, Double.parseDouble(s38));// commented for IN070957
									pstmt.setString(15,(s38.trim()));//added for IN070957
                                    pstmt.setString(16, s37);
                                    pstmt.setString(17, added_by_id);
                                    pstmt.setString(18, added_at_ws_no);
                                    pstmt.setString(19, added_facility_id);
                                    pstmt.setString(20, added_by_id);
                                    pstmt.setString(21, modified_at_ws_no);
                                    pstmt.setString(22, modified_facility_id);
                                    int k2 = pstmt.executeUpdate();
									 if(pstmt!=null)pstmt.close();
                                    if(k2 == 0)
                                        flag = false;
                                    j1++;
                                }
                            } while(true);

				

			}
			else
			{
				flag = insertMultipleNumericDetail();
			}

			}
			else
			{
            String sql="SELECT count(*) FROM AM_DISCR_MSR_REF_RNG_NUM WHERE DISCR_MSR_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,comp_id);
			ResultSet rs = pstmt.executeQuery() ;
			int countrec  = 0;
			if(rs.next())
			countrec = rs.getInt(1) ;
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
					
			if (countrec > 0)
			{


            String s19 = " update AM_DISCR_MSR_REF_RNG_NUM set PATIENT_SEX = ?, GESTATON_AGE_YN = ? , START_AGE = ? , START_AGE_UNITS = ? , END_AGE = ? , END_AGE_UNITS = ? , START_AGE_DAYS = ?,END_AGE_DAYS=?,NUM_REF_LOW = ?,NUM_REF_HIGH = ?, NUM_CRIT_LOW = ?,NUM_CRIT_HIGH = ?, NUM_DFLT_RESULT = ? , NUM_UOM = ? ,MODIFIED_BY_ID = ? ,MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE DISCR_MSR_ID = ? AND  REF_RANGE_SEQ = ?";
           
             j1 =1;
			 pstmt = con.prepareStatement(s19);
             
             
             pstmt.setString(1, "A");
			 pstmt.setString(2, "N");
             pstmt.setInt(3, 0);
             pstmt.setString(4, "D");
             pstmt.setInt(5, 150);
             pstmt.setString(6, "Y");
             pstmt.setInt(7, 0);
             pstmt.setInt(8, 54750);
             pstmt.setString(9, ref_low);
			 pstmt.setString(10, ref_high);
             pstmt.setString(11, critical_low);
             pstmt.setString(12, critical_high);
             pstmt.setString(13, dflt_value);
             pstmt.setString(14, fieldUnit);
             pstmt.setString(15, added_by_id);
             pstmt.setString(16, modified_at_ws_no);
             pstmt.setString(17, modified_facility_id);
			 pstmt.setString(18, comp_id);
			 pstmt.setInt(19, j1);
			int k2 = pstmt.executeUpdate();
				
			if(pstmt!=null)pstmt.close();
			  if(k2 == 0)
              flag = false;     
			}
			else
				{
                flag=insertMultipleNumericDetail();
				}
			
		}
		}
		catch ( Exception e )
		{
			flag = false;
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				return false ;
			}		
			sb.append( "Exception in TemplateComponentManager Watch Point No.124->" + e + " in insert <br>" ) ;
			results.put( "status", new Boolean(result));
			results.put( "error", sb.toString() ) ;
			e.printStackTrace(System.err);
			return false;
		}
		return flag;
	}//end of function
}//End of Class
