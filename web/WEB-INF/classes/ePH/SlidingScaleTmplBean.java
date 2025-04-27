/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import java.sql.Date;
import javax.servlet.* ;
import javax.servlet.http.*;
import javax.naming.* ;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class SlidingScaleTmplBean extends PhAdapter implements Serializable 
{
    //For sliding scale temp Details 
        private  String  template_id;
        private String   templateDesc;
        private String   rangeUOM_desc;
        private String   adminUnitUOM_desc;
        private String   eff_statusTemp;
        private ArrayList   alDtlRecords = new ArrayList();
		
    //For sliding scale temp   range details
    /*private int srlNo;
    private int dispSeqNo;
    private double  rangeFrom;
    private double rangeTo;
    private double adminUnit;
	private String informPractitioner;
	private String remarks;
    private String effStatusRnge;*/

    public SlidingScaleTmplBean() 
    {
        
        try 
        {
            doCommon();
        }
        
        catch(Exception e) { e.printStackTrace();}
    }
    /* Over-ridden Adapter methods start here */
    public void clear() 
    {
        super.clear() ;
        alDtlRecords=new ArrayList();
    }

    private void doCommon() throws Exception 
    {
    }
    /* Over-ridden Adapter methods end here */
    public HashMap validate() throws Exception 
    {
         
        HashMap map=new HashMap();
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map;
    }

    /*start of all Setter and getter pairs*/
    //All setter and getter pairs
    public String getTemplate_id() {
        return template_id;
    }
    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
    public String getTemplateDesc() {
        return templateDesc;
    }
    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    public String getEff_statusTemp() {
        return eff_statusTemp;
    }


    public void setEff_statusTemp(String eff_statusTemp) {
        this.eff_statusTemp = eff_statusTemp;
    }
    public String getRangeUOM_desc() {
        return rangeUOM_desc;
    }
    public void setRangeUOM_desc(String rangeUOM_desc) {
        this.rangeUOM_desc = rangeUOM_desc;
    }
    public String getAdminUnitUOM_desc() {
        return adminUnitUOM_desc;
    }
        public void setAdminUnitUOM_desc(String adminUnitUOM_desc) {
        this.adminUnitUOM_desc = adminUnitUOM_desc;
     }
    public ArrayList getAlDtlRecords() {
        return alDtlRecords;
    }
    public void setAlDtlRecords(ArrayList alDtlRecords) {
        this.alDtlRecords = alDtlRecords;
    }

   
    //To get the array of range details
    public ArrayList getDtlRecords(){
        return alDtlRecords;
    }
    //End of all Setter and getter pairs
    //To store the range details in bean  temporarily before apply.
        public void updateDtlRecord(int index,HashMap hmDtlRecord){
           if (index==-1) {
            index   =   alDtlRecords.size()-1;
            alDtlRecords.add(hmDtlRecord);
            
        }else{
            alDtlRecords.set(index,hmDtlRecord);    
        }
        
    }
    
    public void loadData(String template_id) throws Exception {
           // HashMap hmRecord = new HashMap();
           /* String sqlQuery="SELECT SRL_NO,DISP_SEQ_NO,RANGE_FROM,RANGE_TO,ADMIN_UNITS,INFORM_TO_PRACT,REMARKS,EFF_STATUS " +
                    " FROM PH_SLIDING_SCALE_TMPL_DTL  WHERE  TEMPLATE_ID   like upper(?) ";*/
			String sqlQuery=PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_DTL_SELECT");
            try {
            ArrayList alRecords =   fetchRecords(sqlQuery,template_id.trim());
             setAlDtlRecords(alRecords);
            
            } 
            catch (Exception e) {
                   e.printStackTrace();
                   System.out.println("Exception while loading data ---->   "+e.toString());
            }
        
    }
    //TO get all range details list from DB for a particular template
    public ArrayList fetchRecords(String sqlQuery, String template_id) {
        
        HashMap hmRecord;
        ArrayList alRecords         =   new  ArrayList();
        Connection connection       =   null ;
        PreparedStatement pstmt     =   null ;
        ResultSet resultSet         =   null ;
		String informPractitioner   =   "";
		String remarks				=   "";
		
        try{

            connection          = getConnection() ;
            pstmt               = connection.prepareStatement(sqlQuery);
                //PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT23") ) ;
            pstmt.setString(1,template_id.trim());

           
            resultSet   = pstmt.executeQuery(); 
            while( resultSet != null && resultSet.next() ) {
                hmRecord = new HashMap();
                hmRecord.put("from_uom", resultSet.getString("RANGE_FROM"));
                hmRecord.put("to_uom",resultSet.getString("RANGE_TO"));
                hmRecord.put("admin_units",resultSet.getString("ADMIN_UNITS"));
                informPractitioner   =   resultSet.getString("INFORM_TO_PRACT");
				hmRecord.put("informPractitioner",informPractitioner==null?"N":informPractitioner);
				remarks              =   resultSet.getString("REMARKS");
				hmRecord.put("remarks",remarks==null?"":remarks);
                hmRecord.put("eff_status",resultSet.getString("EFF_STATUS"));
               // System.out.println("Record which are fetched:---->"+hmRecord.toString());
                alRecords.add(hmRecord);
            }
        
        }catch(Exception e){
            System.err.println("Exception in Displaying Range Details :"+e);
            
        }
        finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es){
                es.printStackTrace() ;
            }
        }
   
       
        return alRecords;
    }
	//For Checking Range details
    //For checking freeze transaction
	public boolean isFreezedTransaction(ArrayList arrayList, String stKeyField,int exceptionalIndex) {
		boolean result = false;
		int j = arrayList.size();
		HashMap rangemap = new HashMap();
		float checkTouom;
		rangemap = (HashMap) arrayList.get(j - 1);
		if(exceptionalIndex == -1){
		checkTouom = Float.parseFloat((String) rangemap.get(stKeyField));
		if (checkTouom == 0 ) {
			result = true;
		} else {
			result = false;
		}
		}
        
		return result;
	}
	//For check with previous to range
	public boolean isFromrangeGraterThenToRane(ArrayList arrayList, String stKeyField, String stValue, int exceptionalIndex){
		boolean result = false;
		int j = arrayList.size();
		HashMap rangemap = new HashMap();
		float checkTorange;
		float insertFromRange;
		rangemap = (HashMap) arrayList.get(j - 1);
		if(exceptionalIndex == -1){
		checkTorange = Float.parseFloat((String) rangemap.get(stKeyField));
		insertFromRange=Float.parseFloat((String)stValue);
		if (checkTorange > insertFromRange && checkTorange >0 && exceptionalIndex==-1) {
			result = true;
		} else {
			result = false;
		}
		//System.out.println("---checkTorange:"+checkTorange+"---insertFromRange:"+insertFromRange+"----------result--------"+result);
		}
        
		return result;
	}
	//***************for checking duplicate Admin  Value  in arraylist***************
	public boolean isDuplicateAdminValueInArrayList(ArrayList arrayList, String stKeyField, String stValue, int exceptionalIndex){

     return  (stValue.trim()).equals(String.valueOf(0))==true?false:isDuplicateInArrayList(arrayList,stKeyField,stValue,exceptionalIndex);
		
	}
	//***************for checking Assending or decending order ofAdmin  Value  in arraylist***************
	
       public String possibleOutComeForAdminValueInArrayList(ArrayList arrayList, String stKeyField, String stValue, int exceptionalIndex){
        //System.out.println("possibleOutComeForAdminValueInArrayList"); 

		try
		{
			
			float firstVal = 0;
			float secondVal = 0;
			float prevVal = 0;
			float nextVal = 0;
			int looptill = 0;
			int i = 0;
			float admin_unit = 0;
			String chkCase = "";
			int listTotal = arrayList.size();
			boolean hadFirst = true;
			float curValue = (Float.valueOf(stValue)).floatValue();

			//System.err.println("Stage starts..(curValue)-->"+curValue);
			//System.err.println("Stage starts..(exceptionalIndex)-->"+exceptionalIndex);

			if (listTotal <2 ) return "Success";
			//System.err.println("Stage 1..(listTotal)-->"+listTotal);

			if(exceptionalIndex == -1) 
				looptill = listTotal;
			else
				looptill = exceptionalIndex;

			for(i=0;i<looptill;i++){
				admin_unit = (Float.valueOf(((HashMap)arrayList.get(i)).get("admin_units").toString())).floatValue();
				
				if(admin_unit == 0.0) continue;

				if(firstVal == 0.0) {
					firstVal = admin_unit;
					continue;
				}
				if(secondVal == 0.0) {
					secondVal = admin_unit;
					break;
				}
			}
		
			//System.err.println("Stage 2..(firstVal)-->"+firstVal);
			//System.err.println("Stage 3..(secondVal)-->"+secondVal);

			if (exceptionalIndex == -1 && (firstVal == 0.0 || secondVal == 0.0)) return "Success";
			//System.err.println("Stage 4..");

			if ( firstVal != 0.0 && secondVal != 0.0 ) {
				if ( firstVal > secondVal ) 
					chkCase = "D";
				else
					chkCase = "A";
				//System.err.println("Stage 5..(chkCase)-->"+chkCase);

				for(i=looptill-1 ;i>= 0; i--){
					admin_unit = (Float.valueOf(((HashMap)arrayList.get(i)).get("admin_units").toString())).floatValue();
					if (admin_unit != 0 ) {
						prevVal = admin_unit; 
						break;
					}
				}

				//System.err.println("Stage 6..(prevVal)-->"+prevVal);

				if (chkCase.equals("D") && (Float.valueOf(stValue)).floatValue() > prevVal  ) {
					//System.err.println("Stage 7..DecendingOrderEcception");
					return "DecendingOrderEcception";
				}
				if (chkCase.equals("A") && (Float.valueOf(stValue)).floatValue() < prevVal  ) {
					//System.err.println("Stage 8..AscendingOrderEcception");
					return "AscendingOrderEcception";
				}
				//System.err.println("Stage 9..");
				
				for(i=looptill;i<listTotal;i++){
					if(exceptionalIndex != -1 && i == exceptionalIndex) continue;
					admin_unit = (Float.valueOf(((HashMap)arrayList.get(i)).get("admin_units").toString())).floatValue();
					
					if(admin_unit == 0.0) continue;

					if(nextVal == 0.0) {
						nextVal = admin_unit;
						break;
					}
				}
				//System.err.println("Stage 9.1..(nextVal)-->"+nextVal);

				if( nextVal != 0 && chkCase.equals("D") && !(curValue < secondVal && curValue > nextVal)) {
					//System.err.println("Stage 9.2..DecendingOrderEcception");
					return "DecendingOrderEcception";
				}
				if( nextVal != 0 && chkCase.equals("A") && !(curValue > secondVal && curValue < nextVal)) {
					//System.err.println("Stage 9.3..AscendingOrderEcception");
					return "AscendingOrderEcception";
				}

				//System.err.println("Stage 9.4..(OK)");
				return "Success";
			} 

			//System.err.println("Stage 10..");
			for(i=looptill;i<listTotal;i++){
				if(exceptionalIndex != -1 && i == exceptionalIndex) continue;

				admin_unit = (Float.valueOf(((HashMap)arrayList.get(i)).get("admin_units").toString())).floatValue();
				
				if(admin_unit == 0.0) continue;

				if(firstVal == 0.0) {
					firstVal = admin_unit;
					hadFirst = false;
					continue;
				}
				if(secondVal == 0.0) {
					secondVal = admin_unit;
					break;
				}
			}

			//System.err.println("Stage 11..(firstVal)-->"+firstVal);
			//System.err.println("Stage 12..(secondVal)-->"+secondVal);

			if (firstVal == 0.0 || secondVal == 0.0) return "Success";

			if ( firstVal != 0.0 && secondVal != 0.0 ) {
				if ( firstVal > secondVal ) 
					chkCase = "D";
				else
					chkCase = "A";

				//System.err.println("Stage 14..(chkCase)-->"+chkCase);

				if(hadFirst && chkCase.equals("A") && !(curValue > firstVal && curValue < secondVal)) {
					//System.err.println("Stage 15..AscendingOrderEcception");
					return "AscendingOrderEcception";
				}
				if(!hadFirst && chkCase.equals("A") && curValue > firstVal) {
					//System.err.println("Stage 16..AscendingOrderEcception");
					return "AscendingOrderEcception";
				}

				if(hadFirst && chkCase.equals("D") && !(curValue < firstVal && curValue > secondVal)) {
					//System.err.println("Stage 17..DecendingOrderEcception");
					return "DecendingOrderEcception";
				}
				if(!hadFirst && chkCase.equals("D") && curValue < firstVal) {
					//System.err.println("Stage 18..DecendingOrderEcception");
					return "DecendingOrderEcception";
				}
			}

			//System.out.println("possibleOutComeForAdminValueInArrayList:at the end");
			return "Success";
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
			return "DecendingOrderEcception";
		}



	}








	
    //copy from STAdapter ***************for checking duplicate element in arraylist***************
    public boolean isDuplicateInArrayList(ArrayList arrayList, String stKeyField, String stValue, int exceptionalIndex){
        String stKeyFields[]={stKeyField};
        String stValues[]={stValue};
        return isDuplicateInArrayList(arrayList, stKeyFields, stValues, exceptionalIndex);
    }   
    
        public boolean isDuplicateInArrayList(ArrayList arrayList, String []stKeyFields, String []stValues, int exceptionalIndex){
        boolean result    =    false;
        int     j         =    0;
        
        for (int i=0;i<arrayList.size()&& (!result);i++) {
            if (exceptionalIndex == i) continue;
            result=true;
            for (j=0; j<stKeyFields.length ; j++ ) {
                if (! ((HashMap)arrayList.get(i)).get(stKeyFields[j]).toString().equals(stValues[j])) {
                    result=false;
                    break;
                }
            }

        }
        
        return result;
    }
    //For checking whether the range is already exist or not
    public boolean isDuplicateSequence1(ArrayList arrayList,
            String[] stKeyFields, String[] stValues, int exceptionalIndex) {
        boolean result=false;
        boolean pass=false;
        HashMap rangemap =new HashMap();
        float fromUOM=Float.parseFloat((String)stValues[0]);
        float  toUom=Float.parseFloat((String)stValues[1]);
        try{
        if(arrayList.size() > 0){
                 float checkFromuom;
                 float checkTouom;
                 
                 for (int i=0;i<arrayList.size() ;i++) {
					 pass=false;
                     if(i == exceptionalIndex) {
                        pass=true;
                        continue;
                     }
                        rangemap= (HashMap)arrayList.get(i);
                        checkFromuom=Float.parseFloat((String) rangemap.get(stKeyFields[0]));
                        checkTouom=Float.parseFloat((String) rangemap.get(stKeyFields[1]));
                       
					if(toUom==0  ){  
						if((checkFromuom <= fromUOM ) &&  (fromUOM <= checkTouom) ){
                        pass=false;
						 break;
                    }else{
                        pass=true;
                       
                    }
					}else if(((fromUOM < checkFromuom) &&(toUom < checkFromuom)) ||
                            ((fromUOM > checkTouom) &&(toUom > checkTouom))){
                        pass=true;
                    }else{
                        pass=false;
                        break;
                    }
                    
               
                 }
                 if(pass){
                     
                     result=false; 
                 }else{
                       
                     result=true; 
                 }
             
            
        }else{
            
            result=false;
        }
        }catch(Exception ex){
             System.out.println("Exception  "+ex.toString());
        }

        return result;
    }
	    public boolean isDuplicateSequence(ArrayList arrayList,
            String[] stKeyFields, String[] stValues, int exceptionalIndex) {
      
        HashMap rangemap =new HashMap();
        float fromUOM=Float.parseFloat((String)stValues[0]);
        float  toUom=Float.parseFloat((String)stValues[1]);
        try{
        	int length=arrayList.size();
            if(arrayList.size() > 0){
                 float checkFromuom;
                 float checkTouom;
                 
                
                     if( exceptionalIndex==-1 || exceptionalIndex==length){//Adding at last
                    	 rangemap= (HashMap)arrayList.get(length-1);
                         checkFromuom=Float.parseFloat((String) rangemap.get(stKeyFields[0]));
                         checkTouom=Float.parseFloat((String) rangemap.get(stKeyFields[1]));
                        	 if(fromUOM<=checkTouom)
                        		 return true;  
                     }
                     if(exceptionalIndex >-1){//For modification
                    	 float checkFromuom1;
                         float checkTouom1;
						 if(exceptionalIndex==0 && length==1){
							 return false;
						 }else{
                          if(exceptionalIndex==0 ){
							checkTouom=-1;
							checkFromuom=-1;
						    }else{
                            rangemap= (HashMap)arrayList.get(exceptionalIndex-1);
                            checkFromuom=Float.parseFloat((String) rangemap.get(stKeyFields[0]));
                            checkTouom=Float.parseFloat((String) rangemap.get(stKeyFields[1]));
						  }
                           if(exceptionalIndex==length-1){
							   if(fromUOM<=checkTouom){
                        	   return true;
                            }
						   }else{
                           rangemap= (HashMap)arrayList.get(exceptionalIndex+1);
                           checkFromuom1=Float.parseFloat((String) rangemap.get(stKeyFields[0]));
                           checkTouom1=Float.parseFloat((String) rangemap.get(stKeyFields[1]));
						   if(exceptionalIndex==0){
								if(toUom >=checkFromuom1){
                        	   return true;
                            }
						   }else{
                          if(fromUOM<=checkTouom || toUom >=checkFromuom1){
                        	 return true;
                            }
						   }
						 }
						 }
                     }	
            }
        }catch (Exception e) {// TODO: handle exception

			//return true;
		}
    
        return false;
    }

    //SetAll method
    public void setAll( Hashtable recordSet ) {
         
        this.mode=(String)recordSet.get("mode");
         setTemplate_id((String) recordSet.get("template_id"));
         setTemplateDesc((String) recordSet.get("templateDesc"));
         setRangeUOM_desc((String) recordSet.get("rangeUOM_desc"));
         setAdminUnitUOM_desc((String) recordSet.get("adminUnitUOM_desc"));
         if(((String)recordSet.get("eff_statusTemp")).equals(""))
                setEff_statusTemp("E");
            else
                setEff_statusTemp((String)recordSet.get("eff_statusTemp"));
    }


    
 //All transation methods
   public HashMap insert() {
        
          HashMap map = new HashMap() ; 
          map.put("result", new Boolean(false));
          
        HashMap hmTableData = new HashMap();
        ArrayList alHdrData = new ArrayList();
        ArrayList LanguageData = new ArrayList();

        ArrayList alDtlData = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        HashMap hmSQLMap = new HashMap();

        try {
            alHdrData.add((String) getTemplate_id().trim());
            alHdrData.add((String) getTemplateDesc().trim());
            alHdrData.add((String) getRangeUOM_desc().trim());
            alHdrData.add((String) getAdminUnitUOM_desc().trim());
            alHdrData.add((String) getEff_statusTemp().trim());
            
            LanguageData.add(getLanguageId());
            alHdrData.add(login_by_id.trim());
            alHdrData.add(login_at_ws_no.trim());
            alHdrData.add(login_facility_id.trim());
            alHdrData.add(login_by_id.trim());
            alHdrData.add(login_at_ws_no.trim());
            alHdrData.add(login_facility_id.trim());
            arraylist1.add(alHdrData);
            

            for (int i = 0, j = 0; i < alDtlRecords.size(); i++) {
                HashMap hashmap2 = (HashMap) alDtlRecords.get(i);
                alDtlData = new ArrayList();
                if (((String) hashmap2.get("eff_status")).equals("E")) {
                    alDtlData.add((String) getTemplate_id());
                    alDtlData.add(new Integer(++j)); // (String)hashmap2.get("seq_no")
                    alDtlData.add(new Integer((i+1)));
                    alDtlData.add((String) hashmap2.get("from_uom"));
                   
                    alDtlData.add((String) hashmap2.get("to_uom")); 
                    alDtlData.add((String) hashmap2.get("admin_units"));
					alDtlData.add((String) hashmap2.get("informPractitioner"));
					alDtlData.add((String) hashmap2.get("remarks"));
                    alDtlData.add((String) hashmap2.get("eff_status"));
                    
                    /*
                     * hashmapDtl.put("from_uom", from_uom);
                     * hashmapDtl.put("to_uom",to_uom );
                     * hashmapDtl.put("admin_units",admin_units);
                     * hashmapDtl.put("eff_status",eff_status);
                     */
                    alDtlData.add(login_by_id.trim());
                    alDtlData.add(login_at_ws_no.trim());
                    alDtlData.add(login_facility_id.trim());
                    alDtlData.add(login_by_id.trim());
                    alDtlData.add(login_at_ws_no.trim());
                    alDtlData.add(login_facility_id.trim());
                    
                    arraylist2.add(alDtlData);
                }

            }

            //hmSQLMap.put("hdrInsertSQL","INSERT INTO PH_SLIDING_SCALE_TMPL (TEMPLATE_ID, TEMPLATE_DESC, RANGE_UOM_CODE,ADMIN_UNITS_UOM_CODE, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) ");
			hmSQLMap.put("hdrInsertSQL",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_INSERT"));
            
           // hmSQLMap.put("dtlInsertSQL","INSERT INTO PH_SLIDING_SCALE_TMPL_DTL (TEMPLATE_ID, SRL_NO, DISP_SEQ_NO, RANGE_FROM, RANGE_TO,ADMIN_UNITS,INFORM_TO_PRACT,REMARKS, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) ");
			hmSQLMap.put("dtlInsertSQL",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_DTL_INSERT"));
            
            hmTableData.put("properties", getProperties());
            hmTableData.put("HdrInsertData", arraylist1);
            hmTableData.put("DtlInsertData", arraylist2);
            hmTableData.put("LanguageData", LanguageData);
            //System.out.println("hmTableData@@==>" + hmTableData);
        } catch (Exception e) {
            System.err.println("insert method  exception==>" + e.toString());
        }
      try{
         map =slidingTemplateMethodCall(hmTableData, hmSQLMap);
      }catch (Exception e) {
          System.err.println("calling EJB  exception==>" + e.toString());
      }
      
     return map ;
    }

    public HashMap modify() {
        
          HashMap map = new HashMap() ; 
		  map.put("result", new Boolean(false));

        HashMap   hmTableData		=		new HashMap();
        ArrayList alHdrData			=		new ArrayList();
        ArrayList LanguageData		=		new ArrayList();

        ArrayList alDtlData			=		new ArrayList();
        //ArrayList alUpdDtlData		=		new ArrayList();
        ArrayList alUpdHdrData      =       new ArrayList();
        ArrayList alInsDtlData		=		new ArrayList();
        ArrayList alDeleteData		=	    new ArrayList();
        HashMap hmSQLMap		    =       new HashMap();
        
        try {
            alHdrData.add((String) getTemplateDesc().trim());
            alHdrData.add((String) getEff_statusTemp().trim());
            alHdrData.add(login_by_id.trim());
            alHdrData.add(login_at_ws_no.trim());
            alHdrData.add(login_facility_id.trim());
            alHdrData.add((String) getTemplate_id().trim());
            
            LanguageData.add(getLanguageId());

            alUpdHdrData.add(alHdrData);
            

            for (int i = 0, j = 0; i < alDtlRecords.size(); i++) {
                HashMap hashmap2 = (HashMap) alDtlRecords.get(i);
                if (((String) hashmap2.get("eff_status")).equals("E")) {
                    alDtlData = new ArrayList();
                    alDtlData.add((String) getTemplate_id());
                    alDtlData.add(new Integer(++j)); // (String)hashmap2.get("seq_no")
                    alDtlData.add(new Integer( (i + 1)));
                    alDtlData.add((String) hashmap2.get("from_uom"));
          
                    alDtlData.add((String) hashmap2.get("to_uom"));
                    alDtlData.add((String) hashmap2.get("admin_units"));
					alDtlData.add((String) hashmap2.get("informPractitioner"));
					alDtlData.add((String) hashmap2.get("remarks"));
                    alDtlData.add((String) hashmap2.get("eff_status"));
                    /*
                     * hashmapDtl.put("from_uom", from_uom);
                     * hashmapDtl.put("to_uom",to_uom );
                     * hashmapDtl.put("admin_units",admin_units);
                     * hashmapDtl.put("eff_status",eff_status);
                     */
                    alDtlData.add(login_by_id.trim());
                    alDtlData.add(login_at_ws_no.trim());
                    alDtlData.add(login_facility_id.trim());
                    alDtlData.add(login_by_id.trim());
                    alDtlData.add(login_at_ws_no.trim());
                    alDtlData.add(login_facility_id.trim());
                    
                    alInsDtlData.add(alDtlData);
                    
                } 
            }
                //for deleting Existig records from details.
                    alDtlData = new ArrayList();
                    alDtlData.add((String) getTemplate_id());
                    
                    alDeleteData.add(alDtlData);

           /* hmSQLMap.put("hdrUpdateSQL","UPDATE PH_SLIDING_SCALE_TMPL SET TEMPLATE_DESC = ?,  EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE TEMPLATE_ID = ? "); // getStRepositoryValue("SQL_ST_KIT_TEMPLATE_UPDATE"));
            hmSQLMap.put("dtlInsertSQL","INSERT INTO PH_SLIDING_SCALE_TMPL_DTL (TEMPLATE_ID, SRL_NO, DISP_SEQ_NO, RANGE_FROM, RANGE_TO,ADMIN_UNITS,INFORM_TO_PRACT,REMARKS, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) "); // getStRepositoryValue("SQL_ST_KIT_TEMPLATE_DTL_INSERT"));
            hmSQLMap.put("dtlDeleteSQL","DELETE  FROM  PH_SLIDING_SCALE_TMPL_DTL WHERE TEMPLATE_ID=?"); */

			hmSQLMap.put("hdrUpdateSQL",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_UPDATE"));
            hmSQLMap.put("dtlInsertSQL",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_DTL_INSERT"));
            hmSQLMap.put("dtlDeleteSQL",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_DTL_DELETE")); 

            hmTableData.put("properties", getProperties());
            hmTableData.put("HdrUpdateData", alUpdHdrData);
            hmTableData.put("DtlInsertData", alInsDtlData);
            hmTableData.put("DtlDeleteData", alDeleteData);
            hmTableData.put("LanguageData", LanguageData);

            //System.out.println("hmTableData@@==>" + hmTableData);
        } catch (Exception e) {
            System.err.println("modify  method  exception==>" + e.getMessage());

            e.printStackTrace();
        }
        try{
         map =slidingTemplateMethodCall(hmTableData, hmSQLMap);
      }catch(Exception e){
          System.err.println("calling EJB  exception==>" + e.toString());
      }
     
     return map ;
    }
    public HashMap slidingTemplateMethodCall(HashMap hashmap,
            HashMap hashmapQuery) {
        HashMap hashmapResult = new HashMap();
        hashmapResult.put("result", new Boolean(false));
        hashmapResult.put("msgid",new String());
        hashmapResult.put("message",new String());
        
        try {
            //Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class, getLocalEJB());
            //Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);

            Object argArray[] = new Object[2];
            argArray[0] = hashmap;
            argArray[1] = hashmapQuery;

            Class[] paramArray = new Class[2];
            paramArray[0] = hashmap.getClass();
            paramArray[1] = hashmapQuery.getClass();
            
         //For insertion
            if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
                        
              hashmapResult=insertSlidingScaleDetails(hashmap,hashmapQuery);


            } else {
                if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
                    hashmapResult=modifySlidingScaleDetails(hashmap,hashmapQuery);
                }

            }
            
            if (((Boolean) hashmapResult.get("result")).booleanValue()) {
                
                hashmapResult.put("message", getMessage(getLanguageId(),(String) hashmapResult.get("msgid"), "PH"));

            } else if (hashmapResult.get("msgid") != null) {
                 if( ((String)hashmapResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
                        hashmapResult.put("message", getMessage(getLanguageId(),(String) hashmapResult.get("msgid"), "Common"));
                  else
                      hashmapResult.put("message", getMessage(getLanguageId(),(String) hashmapResult.get("msgid"), "PH"));
                hashmapResult.put("flag", "0");
            } else {
                hashmapResult.put("message",replaceNewLineChar((String) hashmapResult.get("message")));
                hashmapResult.put("flag", "0");
            }

        } catch (Exception e) {
            System.err.println("Error Calling EJB : " + e);
            hashmapResult.put("message", e.getMessage());
            e.printStackTrace();
        }
        
        return hashmapResult;
    }
    public HashMap insertSlidingScaleDetails(HashMap hashmap, HashMap hashmapQuery){
		//For Latter use of EJB
       // HashMap hashmapHDrdata = new HashMap();
       // HashMap hashmapHDrquery = new HashMap();
	   // HashMap hashmapDtldata = new HashMap();
       // HashMap hashmapDtlquery = new HashMap();
        HashMap hashmapResult = new HashMap();
        HashMap hmReturn=new HashMap();
       
       
        ArrayList alData = new ArrayList();
        Properties properties = null;
       
        hashmapResult.put("result", new Boolean(false));
        hashmapResult.put("msgid",new String());
        hashmapResult.put("message",new String());
        hmReturn.put("RESULT",new Boolean(false));
        Connection connection                   =       null ;
        PreparedStatement preparedStatement     =       null ;
      
        
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection();
            //connection.setAutoCommit(false);
            try{
            ArrayList arraylistHdrData = (ArrayList)hashmap.get("HdrInsertData");
          
            
            if(arraylistHdrData.size()>0){
                String HdrQuery = (String)hashmapQuery.get("hdrInsertSQL");
                
                preparedStatement=connection.prepareStatement(HdrQuery);
                for(int index=0;index<arraylistHdrData.size();index++) {
                    alData  =   (ArrayList)arraylistHdrData.get(index);
                    
                    preparedStatement=setData(preparedStatement,alData);
                    //preparedStatement.addBatch();
                
                int iResult     =   preparedStatement.executeUpdate();
                
                 if(iResult >0)
                hmReturn.put("RESULT",new Boolean(true));
                 }
				 closeStatement( preparedStatement ) ;
        
            }
            
            try{
            ArrayList arraylistDtlData = (ArrayList)hashmap.get("DtlInsertData");
            
        
            if(arraylistDtlData.size()>0){
                String DtlQuery = (String)hashmapQuery.get("dtlInsertSQL");
              
                preparedStatement=connection.prepareStatement(DtlQuery);
                for(int index=0;index<arraylistDtlData.size();index++) {
                    alData  =   (ArrayList)arraylistDtlData.get(index);
                    
                    preparedStatement=setData(preparedStatement,alData);
                    //preparedStatement.addBatch();
                    
                int iResult     =   preparedStatement.executeUpdate();
				
                 if(iResult >0)
                hmReturn.put("RESULT1",new Boolean(true));
                 }  
            }else{
                if(arraylistDtlData.size()== 0)
                    hmReturn.put("RESULT1",new Boolean(true));
                
            }
            }catch(Exception  exception1){
                System.out.println("Exception while inserting to Range table: "+exception1.toString());
                hashmapResult.put("result", new Boolean(false));
                hashmapResult.put("msgid", exception1.getMessage());
                hashmapResult.put("message", exception1.toString());
            }
            }catch (Exception exception2) {
                System.out.println("Exception while inserting to Sliding table: "+exception2.toString());
                hashmapResult.put("result", new Boolean(false));
                hashmapResult.put("msgid", "CODE_ALREADY_EXISTS");
                hashmapResult.put("message", "CODE_ALREADY_EXISTS");
            }

            connection.commit();
        }
        catch(Exception exception3)
        {

            try
            {
                connection.rollback();
                exception3.printStackTrace();
            }
            catch(Exception exception4)
            {
                exception4.printStackTrace();
            }
            hashmapResult.put("result", new Boolean(false));
           
        }
        finally
        {
            try
            {
				closeStatement( preparedStatement ) ;
                closeConnection(connection);
            }
            catch(Exception exception5)
            {
                exception5.printStackTrace();
            }
        }
        if( (hmReturn.get("RESULT")).equals(new Boolean(true)) && (hmReturn.get("RESULT1")).equals(new Boolean(true)))
        {
            hashmapResult.put("result", new Boolean(true));
            hashmapResult.put("msgid","RECORD_INSERTED");
            hashmapResult.put("message", "RECORD_INSERTED");
        }

           
        return hashmapResult;
    
    }//End of insert
    public HashMap modifySlidingScaleDetails(HashMap hashmap, HashMap hashmapQuery){
		//For Latter use of EJB
       // HashMap hashmapHDrUpdData = new HashMap();
        //HashMap hashmapHDrUpdDataQ = new HashMap();
       // HashMap hashmapDtlUpdData = new HashMap();
        //HashMap hashmapDtlUpdDataQ = new HashMap();
		// HashMap hashmapDtlDeletedata = new HashMap();
        //HashMap hashmapDtlDeletedataQ = new HashMap();
     
        HashMap hashmapResult = new HashMap();
        HashMap hmReturn=new HashMap();
       
       
        ArrayList arrHDrUpdData = new ArrayList();
        //ArrayList arrDtlUpdData = new ArrayList();
        ArrayList arrDtlInsertData = new ArrayList();
        ArrayList arrDtlDeleteData = new ArrayList();
        ArrayList alData = new ArrayList();

        String hdrUpdateSQL=(String)hashmapQuery.get("hdrUpdateSQL");
        String dtlDeleteSQL=(String)hashmapQuery.get("dtlDeleteSQL");
        String dtlInsertSQL=(String)hashmapQuery.get("dtlInsertSQL");
        

        
        Properties properties = null;
      //  Object obj = null;
         hashmapResult.put("result", new Boolean(false));
         hmReturn.put("RESULT", new Boolean(false));
         Connection connection                  =       null ;
        PreparedStatement preparedStatement     =       null ;
        
        
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection();
            connection.setAutoCommit(false);
        
            
            //For updating The Sliding scale table
            try{
            arrHDrUpdData = (ArrayList)hashmap.get("HdrUpdateData");
            
            if(arrHDrUpdData.size()>0){
                
                
                preparedStatement=connection.prepareStatement(hdrUpdateSQL);
                for(int index=0;index<arrHDrUpdData.size();index++) {
                    alData  =   (ArrayList)arrHDrUpdData.get(index);
                    preparedStatement=setData(preparedStatement,alData);
                    //preparedStatement.addBatch();
                    
                
                int iResult     =   preparedStatement.executeUpdate();
                
                 if(iResult >0)
                hmReturn.put("RESULT1",new Boolean(true));
                 }
				closeStatement( preparedStatement ) ;
                
            }
            
      //Insertion is there for range details
             try {
            arrDtlInsertData = (ArrayList)hashmap.get("DtlInsertData");
            
            
            if(arrDtlInsertData.size()>0){
				//For deleting record's from range details table.If status in Disable.
            try{
            arrDtlDeleteData = (ArrayList)hashmap.get("DtlDeleteData");
            if(arrDtlDeleteData.size()>0 ){
        
                preparedStatement=connection.prepareStatement(dtlDeleteSQL);
                for(int index=0;index<arrDtlDeleteData.size();index++) {
                    alData  =   (ArrayList)arrDtlDeleteData.get(index);
                    
                    preparedStatement=setData(preparedStatement,alData);
                    
                }
                int iResult     =   preparedStatement.executeUpdate();
                
                 if(iResult >0){
                     hmReturn.put("RESULT2",new Boolean(true)); 
                 }
				 closeStatement( preparedStatement ) ;
            }else {
                hmReturn.put("RESULT2",new Boolean(true));  
            }
            }catch(Exception  exception){
                System.out.println("Exception while Deleting  to Range table: "+exception.toString());
            }
                
                
                preparedStatement=connection.prepareStatement(dtlInsertSQL);
                for(int index=0;index<arrDtlInsertData.size();index++) {
                    alData  =   (ArrayList)arrDtlInsertData.get(index);
                    
                    preparedStatement=setData(preparedStatement,alData);
                    //preparedStatement.addBatch();
                    
                int iResult     =   preparedStatement.executeUpdate();
                
                 if(iResult > 0)
                hmReturn.put("RESULT2",new Boolean(true));
                    }
					closeStatement( preparedStatement ) ;
                
            }else{
                //NO INSERTION FOUND
                if(arrDtlInsertData.size()== 0)
                    hmReturn.put("RESULT2",new Boolean(false));
            }
        }catch(Exception  exception1){
            System.out.println("Exception while Inserting   to Range table: "+exception1.toString());
            hashmapResult.put("result", new Boolean(false));
           
            hashmapResult.put("message", exception1.toString());
        }
            }catch(Exception  exception2){
                System.out.println("Exception while Updating  to Sliding  table: "+exception2.toString());
                hashmapResult.put("result", new Boolean(false));
               
                hashmapResult.put("message", exception2.toString());
                
            }

            connection.commit();
        }
        catch(Exception exception3)
        {
            try
            {
                connection.rollback();
                exception3.printStackTrace();
            }
            catch(Exception exception4)
            {
                exception4.printStackTrace();
            }
            hashmapResult.put("result", new Boolean(false));
            
            hashmapResult.put("message", exception3.toString());
        }
        finally
        {
            try
            { 
				closeStatement( preparedStatement ) ;
                closeConnection(connection);
            }
            catch(Exception exception5)
            {
                exception5.printStackTrace();
            }
        }
        if( (hmReturn.get("RESULT1")).equals(new Boolean(true)) && (hmReturn.get("RESULT2")).equals(new Boolean(true)))
        {
             hashmapResult.put("result", new Boolean(true));
             hashmapResult.put("msgid","RECORD_MODIFIED");
             hashmapResult.put("message", "RECORD_MODIFIED");
        }
		if( (hmReturn.get("RESULT1")).equals(new Boolean(true)) && (hmReturn.get("RESULT2")).equals(new Boolean(false))){
			 hashmapResult.put("result", new Boolean(false));
             hashmapResult.put("msgid","ATLEAST_ONE_RECORD_ENTERED_IN_RANGE_DETAILS");
             hashmapResult.put("message", "ATLEAST_ONE_RECORD_ENTERED_IN_RANGE_DETAILS");
		}
     
        return hashmapResult;
    
    }//modification

} //END OF CLASS
