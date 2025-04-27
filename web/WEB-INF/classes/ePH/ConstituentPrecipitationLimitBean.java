/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;

public class ConstituentPrecipitationLimitBean extends PhAdapter implements Serializable {


	protected String user_name		= "";
	protected String password		= "";
	

	

	private Hashtable recordSet		= new Hashtable();

	public ConstituentPrecipitationLimitBean() 
	{
		//Constructor
		try 
		{
			doCommon() ;
		}
		catch(Exception e) {System.err.println(e);
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception 
	{
	}

	public void clear() 
	{
		super.clear() ;
		//this.disp_locn_code	= "";
		//this.encounter_id	= "";
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */


	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}
	
	
//public void setToStoreCode(String ToStoreCode){
//		this.ToStoreCode = ToStoreCode;
//	}
//	public String getToStoreCode(){
//		return 	ToStoreCode;
//	}

	

public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		this.recordSet = recordSet;

	

	}


	public ArrayList getConstituentGenericName()
	{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    ArrayList result=new ArrayList();


	 
	  
        try {
            connection = getConnection() ;
		

			pstmt= connection.prepareStatement("Select CONST_GENERIC_CODE,CONST_GENERIC_NAME from PH_TPN_CONST_GENERIC_NAME where CONST_GROUP_CODE ='EL'") ;
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("CONST_GENERIC_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_NAME"));
			}
		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}


//To get the molecule name for the selected constituent generic name 
 	public ArrayList getConstituentMoleculeName(String Gen_Name_Limit)
	{
		Connection connection	= null;
        PreparedStatement pstmt_mol	= null;
        PreparedStatement pstmt_const_uom	= null;
        ResultSet resultSet_mol		= null;
        ResultSet resultSet_const_uom		= null;
     
	    ArrayList result=new ArrayList();

	 
	  
        try {
            connection = getConnection() ;
			
	
			pstmt_mol= connection.prepareStatement("SELECT MOLECULE_CODE,DESCRIPTION FROM PH_TPN_ELECT_MOL_FORMULA WHERE AN_ION = ? or CAT_ION = ?") ;
			
			
			
			pstmt_mol.setString(1,Gen_Name_Limit.trim());
			pstmt_mol.setString(2,Gen_Name_Limit.trim());

		    resultSet_mol = pstmt_mol.executeQuery() ;
            while ( resultSet_mol.next() ) {
				result.add(resultSet_mol.getString("MOLECULE_CODE"));
				result.add(resultSet_mol.getString("DESCRIPTION"));
			}


		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet_mol ) ;
				closeResultSet( resultSet_const_uom ) ;
				closeStatement( pstmt_mol ) ;
				closeStatement( pstmt_const_uom ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}
	
//	public ArrayList getUOM(String Gen_Name_Limit)
	public ArrayList getUOM()
	{
		Connection connection	= null;
        
        PreparedStatement pstmt_const_uom	= null;
       
        ResultSet resultSet_const_uom		= null;
     
	    ArrayList result=new ArrayList();

	 
	  
        try {
            connection = getConnection() ;
			
			
			pstmt_const_uom= connection.prepareStatement("SELECT UOM_CODE, SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE IN('MEQT','MMOL') AND EFF_STATUS='E' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC") ;
			//pstmt_const_uom.setString(1,Gen_Name_Limit.trim());
			pstmt_const_uom.setString(1,getLanguageId());

		    resultSet_const_uom = pstmt_const_uom.executeQuery() ;
            while ( resultSet_const_uom.next() ) {
				result.add(resultSet_const_uom.getString("UOM_CODE"));
				result.add(resultSet_const_uom.getString("SHORT_DESC"));
			}
			

		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
			
				closeResultSet( resultSet_const_uom ) ;
			
				closeStatement( pstmt_const_uom ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}


	public ArrayList getConstituentGroupName()
	{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    ArrayList result=new ArrayList();


	 
	  
        try {
            connection = getConnection() ;
		

			pstmt= connection.prepareStatement("select CONST_GROUP_CODE,CONST_GROUP_NAME from PH_TPN_CONSTITUENT_GROUP where EFF_STATUS='E' AND CONST_GROUP_CODE = 'EL'") ;
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("CONST_GROUP_CODE"));
				result.add(resultSet.getString("CONST_GROUP_NAME"));
			}
		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}


	public ArrayList getConstituentPrecipitationLimitDetails(String seq_no)
	{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    ArrayList result=new ArrayList();


	 
	  
        try {
            connection = getConnection() ;
		

			//pstmt= connection.prepareStatement("SELECT (SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_frm_code) CONSTR_GENERIC_FRM_NAME,(SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_to_code) CONSTR_GENERIC_TO_NAME,MOLECULE_FRM_CODE, MOLECULE_TO_CODE, SRL_NO, CONST_FRM_MMOL_VALUE_PERL, CONST_TO_MMOL_VALUE_PERL, CONST_FRM_MG_VALUE_PERDL, CONST_TO_MG_VALUE_PERDL, CONST_PREC_IND, CONST_PREC_MESSAGE,EFF_STATUS FROM PH_TPN_CONS_PREC_MOL a WHERE constr_generic_frm_code = ?   AND constr_generic_to_code = ?   AND molecule_frm_code = ?   AND molecule_to_code = ?   AND srl_no = ?") ;
			pstmt= connection.prepareStatement("SELECT (SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_frm_code) CONSTR_GENERIC_FRM_NAME,(SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_to_code) CONSTR_GENERIC_TO_NAME,(SELECT DESCRIPTION FROM PH_TPN_ELECT_MOL_FORMULA WHERE MOLECULE_CODE = a.MOLECULE_FRM_CODE) MOLECULE_FRM_DESC,(SELECT DESCRIPTION FROM PH_TPN_ELECT_MOL_FORMULA WHERE MOLECULE_CODE = a.MOLECULE_TO_CODE) MOLECULE_TO_DESC, SRL_NO, CONST1_RANGE_FRM, CONST1_RANGE_TO, CONST2_RANGE_FRM, CONST2_RANGE_TO, CONST_PREC_IND, CONST_PREC_MESSAGE,EFF_STATUS,CONSTR_GENERIC_FRM_CODE,CONSTR_GENERIC_TO_CODE,CONST_GENERIC_UOM,CONST_GENERIC_PER_VOL FROM PH_TPN_CONS_PREC_MOL a WHERE srl_no = ?") ;

			//pstmt.setString(1,const_from_code.trim());
			//pstmt.setString(2,const_to_code.trim());
			//pstmt.setString(3,mol_from_code.trim());
			//pstmt.setString(4,mol_to_code.trim());
			pstmt.setInt(1,Integer.parseInt(seq_no));
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("CONSTR_GENERIC_FRM_NAME"));
				result.add(resultSet.getString("MOLECULE_FRM_DESC"));
				result.add(resultSet.getString("CONSTR_GENERIC_TO_NAME"));
				result.add(resultSet.getString("MOLECULE_TO_DESC"));
				result.add(resultSet.getString("CONST1_RANGE_FRM"));
				result.add(resultSet.getString("CONST1_RANGE_TO"));
				result.add(resultSet.getString("CONST2_RANGE_FRM"));
				result.add(resultSet.getString("CONST2_RANGE_TO"));
				result.add(resultSet.getString("CONST_PREC_IND"));
				result.add(resultSet.getString("CONST_PREC_MESSAGE"));
				result.add(resultSet.getString("EFF_STATUS"));
				result.add(resultSet.getString("CONSTR_GENERIC_FRM_CODE"));
				result.add(resultSet.getString("CONSTR_GENERIC_TO_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_UOM"));
				result.add(resultSet.getInt("CONST_GENERIC_PER_VOL"));
				//result.add(resultSet.getString("CONST_FRM_MG_VALUE_PERDL"));
			}
		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}



	public HashMap insert(){
	

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
	 	
		Connection connection				  = null;
		PreparedStatement pstmt             = null ;
		PreparedStatement pstmt1             = null ;

		ResultSet resultSet1				      = null ;

		
		
				
        String Gen_Name_Limit_From				= "";		
        String Gen_Name_Limit_To				= "";		
        String Mol_Name_From					= "";		
        String Mol_Name_To						= "";		
        float Con_ConCen_From_Min					= 0;		
        float Con_ConCen_From_Max					= 0;		
        float Con_ConCen_To_Min					= 0;		
        float Con_ConCen_To_Max					= 0;		
        String precipitation_indicator			= "";		
        String precipitation_alert_msg			= "";		
        String precipitation_alert_msg_YN			= "";		
        String const_generic_uom			= "";		
        String const_generic_uom_conv			= "";		
       		
		int seq_no = 0;
		int const_generic_uom_per_vol = 0;
	
	
		int total_count = Integer.parseInt((String)recordSet.get("cnt"));
		
	
		try{
					
		connection				= getConnection() ;
	//	pstmt					= connection.prepareStatement("INSERT INTO PH_TPN_CONS_PREC_MOL (constr_generic_frm_code, constr_generic_to_code,molecule_frm_code, molecule_to_code, srl_no,const_frm_mmol_value_perl, const_to_mmol_value_perl, const_frm_mg_value_perdl, const_to_mg_value_perdl, const_prec_ind, const_prec_message, added_by_id, added_date,  added_at_ws_no, added_facility_id, modified_by_id,  modified_date, modified_at_ws_no, modified_facility_id ) VALUES (?, ?,?,?,?,?, ?,?, ?,?,?,?,TO_DATE (sysdate, 'MM/DD/YYYY HH:MI:SS AM'),?, ?, ?,TO_DATE (sysdate, 'MM/DD/YYYY HH:MI:SS AM'),?, ?)");
		pstmt					= connection.prepareStatement("INSERT INTO PH_TPN_CONS_PREC_MOL (constr_generic_frm_code, constr_generic_to_code,molecule_frm_code, molecule_to_code, srl_no,CONST1_RANGE_FRM, CONST1_RANGE_TO, CONST2_RANGE_FRM, CONST2_RANGE_TO, const_prec_ind, const_prec_message, added_by_id, added_date,  added_at_ws_no, added_facility_id, modified_by_id,  modified_date, modified_at_ws_no, modified_facility_id,EFF_STATUS,CONST_GENERIC_UOM,const_generic_per_vol) VALUES (?, ?,?, ?, ?,?, ?,?, ?,?,?,?,SYSDATE,?, ?, ?,SYSDATE,?, ?,?,?,?)");
		
	

		for (int i=0;i<=total_count ;i++ )
		{
	
		
		 Gen_Name_Limit_From			= ((String)recordSet.get("Gen_Name_Limit_From_"+i)==null ?  "":(String)recordSet.get("Gen_Name_Limit_From_"+i));	
		 if(!(Gen_Name_Limit_From.equals("")))
			{
			pstmt1					= connection.prepareStatement("select PH_TPN_CONS_PREC_MOL_SEQ.NEXTVAL  SEQ_NO from dual");
			
			resultSet1				= pstmt1.executeQuery();
			
			if(resultSet1!=null && resultSet1.next()){
                  seq_no		=Integer.parseInt(resultSet1.getString("SEQ_NO"));
			}
			closeResultSet( resultSet1 ) ;//common-icn-0029
			closeStatement( pstmt1 ) ;//common-icn-0029
			

			 Gen_Name_Limit_To			= ((String)recordSet.get("Gen_Name_Limit_To_"+i)==null ?  "":(String)recordSet.get("Gen_Name_Limit_To_"+i));	
			 Mol_Name_From			= ((String)recordSet.get("Mol_Name_From_"+i)==null ?  "":(String)recordSet.get("Mol_Name_From_"+i));	
			 Mol_Name_To			= ((String)recordSet.get("Mol_Name_To_"+i)==null ?  "":(String)recordSet.get("Mol_Name_To_"+i));	
			 Con_ConCen_From_Min			= Float.parseFloat(((String)recordSet.get("Con_ConCen_From_Min_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_From_Min_"+i)));	
			// Con_ConCen_From_Min			= 10;	
			Con_ConCen_From_Max			= Float.parseFloat(((String)recordSet.get("Con_ConCen_From_Max_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_From_Max_"+i)));		
			//Con_ConCen_From_Max			= 15;		
			Con_ConCen_To_Min			= Float.parseFloat(((String)recordSet.get("Con_ConCen_To_Min_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_To_Min_"+i)));		
			//Con_ConCen_To_Min			= 14;		
			Con_ConCen_To_Max			= Float.parseFloat(((String)recordSet.get("Con_ConCen_To_Max_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_To_Max_"+i)));		
			 //Con_ConCen_To_Max			= 33;		
			precipitation_indicator			=((String)recordSet.get("precipitation_indicator_"+i)==null ?  "":(String)recordSet.get("precipitation_indicator_"+i));		
			precipitation_alert_msg			=((String)recordSet.get("precipitation_alert_msg_"+i)==null ?  "-":(String)recordSet.get("precipitation_alert_msg_"+i));
			precipitation_alert_msg = precipitation_alert_msg.replace('"','`');
			precipitation_alert_msg_YN			=((String)recordSet.get("Con_Alert_YN_"+i)==null ?  "E":(String)recordSet.get("Con_Alert_YN_"+i));
			
			if(precipitation_alert_msg_YN.trim().equals(""))
			precipitation_alert_msg_YN="D";

			const_generic_uom			=((String)recordSet.get("Con_ConCen_From_UOM_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_From_UOM_"+i));
			const_generic_uom_conv			=((String)recordSet.get("Con_ConCen_From_UOM_Conv_"+i)==null ?  "":(String)recordSet.get("Con_ConCen_From_UOM_Conv_"+i)).trim();
			

				if(const_generic_uom_conv.equals("Per decilitre"))
				{
				const_generic_uom_per_vol = 100;
				}
				else
				{
				const_generic_uom_per_vol =1000;
				}

		
	/*	
System.out.println("Gen_Name_Limit_From-->"+Gen_Name_Limit_From);
System.out.println("Gen_Name_Limit_To-->"+Gen_Name_Limit_To);
System.out.println("Mol_Name_From-->"+Mol_Name_From);
System.out.println("Mol_Name_To-->"+Mol_Name_To);
System.out.println("Con_ConCen_From_Min-->"+Con_ConCen_From_Min);
System.out.println("Con_ConCen_From_Max-->"+Con_ConCen_From_Max);
System.out.println("Con_ConCen_To_Min-->"+Con_ConCen_To_Min);
System.out.println("Con_ConCen_To_Max-->"+Con_ConCen_To_Max);
System.out.println("precipitation_indicator-->"+precipitation_indicator);
System.out.println("precipitation_alert_msg-->"+precipitation_alert_msg);
System.out.println("login_by_id-->"+login_by_id);
System.out.println("login_at_ws_no-->"+login_at_ws_no);
System.out.println("login_facility_id-->"+login_facility_id);

		*/

			pstmt.setString(1,Gen_Name_Limit_From.trim());
			pstmt.setString(2,Gen_Name_Limit_To.trim());
			pstmt.setString(3,Mol_Name_From.trim());
			pstmt.setString(4,Mol_Name_To.trim());
			pstmt.setFloat(5,seq_no);
			pstmt.setFloat(6,Con_ConCen_From_Min);
			pstmt.setFloat(7,Con_ConCen_From_Max);
			pstmt.setFloat(8,Con_ConCen_To_Min);
			pstmt.setFloat(9,Con_ConCen_To_Max);
			pstmt.setString(10,precipitation_indicator.trim());
			pstmt.setString(11,precipitation_alert_msg.trim());
			pstmt.setString(12,login_by_id.trim());
			pstmt.setString(13,login_at_ws_no.trim());
			pstmt.setString(14,login_facility_id.trim());
			pstmt.setString(15,login_by_id.trim());
			pstmt.setString(16,login_at_ws_no.trim());
			pstmt.setString(17,login_facility_id.trim());
			pstmt.setString(18,precipitation_alert_msg_YN.trim());
			pstmt.setString(19,const_generic_uom.trim());
			pstmt.setInt(20,const_generic_uom_per_vol);
			pstmt.addBatch();
			}
			
			
			
		}//for
		
		int[] rowsInserted			= pstmt.executeBatch();
		
				 for (int i=0; i<rowsInserted.length; i++) {
				
							if (rowsInserted[i] < 0 && rowsInserted[i] != -2 ) {
										connection.rollback();
									}
							else  {
										map.put( "result", new Boolean( true ) ) ;	
								
										map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
								
									}
			 }
				  
			    		connection.commit();
				
						
		}//try
		catch(Exception e){
			map.put( "result", new Boolean( false ) ) ; 
			map.put( "message", getMessage(getLanguageId(),"ALL_MANDATORY_FIELDS","COMMON")) ;
			map.put("flag","0");
			e.printStackTrace() ;
			try{
				connection.rollback();
			}catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}//catch
		finally{
				 try{
							closeStatement( pstmt ) ;
							closeStatement( pstmt1 ) ;
							closeResultSet( resultSet1 ) ;
						
						 closeConnection( connection );
					 }
				 catch(Exception ex){

							 ex.printStackTrace() ;
					}
				
			
			}//finally

        // System.err.println("map---------->"+map);
//        
		return map;
	}


 public HashMap modify() 
	{
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
		Connection connection	= null;
        PreparedStatement pstmt	= null;
      
	 
		String precipitation_alert_msg_YN="";
		
		int seq_no=0;
		

	  
        try {
            connection = getConnection() ;
		
		//mol_from_code			=((String)recordSet.get("mol_from_code")==null ?  "":(String)recordSet.get("mol_from_code"));
		//const_to_code			=((String)recordSet.get("const_to_code")==null ?  "":(String)recordSet.get("const_to_code"));
		//mol_to_code			=((String)recordSet.get("mol_to_code")==null ?  "":(String)recordSet.get("mol_to_code"));
		//const_from_code			=((String)recordSet.get("const_from_code")==null ?  "":(String)recordSet.get("const_from_code"));
		seq_no			=Integer.parseInt(((String)recordSet.get("seq_no")==null ?  "":(String)recordSet.get("seq_no")));
		//int seq_no			=Integer.parseInt(recordSet.get("seq_no"));

		precipitation_alert_msg_YN			=((String)recordSet.get("Con_Alert_YN")==null ?  "D":(String)recordSet.get("Con_Alert_YN"));
		if(precipitation_alert_msg_YN.trim().equals(""))
			precipitation_alert_msg_YN="D";





			pstmt= connection.prepareStatement("UPDATE PH_TPN_CONS_PREC_MOL SET EFF_STATUS =? WHERE SRL_NO=?") ;
			pstmt.setString(1,precipitation_alert_msg_YN.trim());
			//pstmt.setString(2,const_from_code.trim());
			//pstmt.setString(3,const_to_code.trim());
			//pstmt.setString(4,mol_from_code.trim());
			//pstmt.setString(5,mol_to_code.trim());
			pstmt.setInt(2,seq_no);



		    int cnt = pstmt.executeUpdate() ;
     

		   if (cnt>0)
		   {
			   map.put( "result", new Boolean( true ) ) ;	
								
										map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
								
		   }else
			{
			   connection.rollback();
			}
		   connection.commit();
		}
		catch ( Exception e ) {
		
			map.put( "result", new Boolean( false ) ) ; 
			map.put( "message", "exp : insert method :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
			try{
				connection.rollback();
			}catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}
		finally {
			try {
				
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return map;
	}



	public ArrayList getConstituentRange(String Gen_Name_Limit_From,String Gen_Name_Limit_To,String chkFlag)
	{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    ArrayList result=new ArrayList();



	 
	  
        try {
            connection = getConnection() ;
		
			if(chkFlag.equals("F"))
			{
			pstmt= connection.prepareStatement("SELECT CONST1_RANGE_FRM Min,CONST1_RANGE_TO Max,CONST_GENERIC_UOM FROM PH_TPN_CONS_PREC_MOL a, PH_TPN_CONSTITUENT_GROUP b WHERE upper(b.CONST_GROUP_CODE) LIKE upper('EL') and upper(a.constr_generic_frm_code) like upper(?) AND upper(a.constr_generic_to_code) like upper(?)") ;
			}else
			{
			pstmt= connection.prepareStatement("SELECT CONST2_RANGE_FRM Min, CONST2_RANGE_TO Max,CONST_GENERIC_UOM FROM PH_TPN_CONS_PREC_MOL a, PH_TPN_CONSTITUENT_GROUP b WHERE upper(b.CONST_GROUP_CODE) LIKE upper('EL') and upper(a.constr_generic_frm_code) like upper(?) AND upper(a.constr_generic_to_code) like upper(?)") ;
			}		

			pstmt.setString(1,Gen_Name_Limit_From.trim());
			pstmt.setString(2,Gen_Name_Limit_To.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("Min"));
				result.add(resultSet.getString("Max"));
				result.add(resultSet.getString("CONST_GENERIC_UOM"));
			}
			
		}
		catch ( Exception e ) {
			result.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { System.err.println(es);}
		}
		return result;
	}



public boolean getRangeOverlapValidate(ArrayList range_list,float from,float to,String uom){



		String temp_from="";
		String temp_to="";
		String temp_uom="";
		
		float list_from;
		float list_to;
		boolean t_range = false;
		  
	
        for(int i=0;i<range_list.size();i+=3){
		boolean range_flag[] = {false,false,false,false};
		temp_from=(String)range_list.get(i);
		temp_to =(String)range_list.get(i+1);
		temp_uom =(String)range_list.get(i+2);
		
		list_from=Float.parseFloat(temp_from);
		list_to=Float.parseFloat(temp_to);


				range_flag[0] = getChk_range(list_from,list_to,from,temp_uom,uom);
				range_flag[1] = getChk_range(list_from,list_to,to,temp_uom,uom);
				range_flag[2] = getChk_range(from,to,list_from,temp_uom,uom);
				range_flag[3] = getChk_range(from,to,list_to,temp_uom,uom);


				if(range_flag[0]==true||range_flag[1] ==true ||range_flag[2]== true||range_flag[3]==true)
					{
					t_range =  true;
					break;
				}
			

		}

	return t_range;
  
	}

	public boolean getChk_range(float list_from,float list_to,float no,String oldUom,String newUom){

		if(no >= list_from && no <= list_to && oldUom.equals(newUom))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

/*====================================================================================================================*/


}

