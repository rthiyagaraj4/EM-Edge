/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
22/11/2022  37930               SREENADH                             RAMESH         ML-MMOH-SCF-2178
--------------------------------------------------------------------------------------------------------------
*/ 

package eCA;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import eCA.Common.CaAdapter;
public class MultiLocForPractitionerBean extends CaAdapter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Connection con;
    private PreparedStatement pstmt; 
    private PreparedStatement pstmt1; 
    private PreparedStatement pstmt2; 
    private PreparedStatement pstmt3; 
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;
    public ArrayList<ArrayList<String>> getMultiLocForPrctitionerData(String facility_id, String practitionerId, String locationType, String searchBy, String searchText,String locale){
    	ArrayList<ArrayList<String>>  resultArryList=new ArrayList<ArrayList<String>>();
    	int result = getMultiLocForPrctitionerDetails(facility_id,practitionerId,locationType,searchBy,searchText,locale);
    	if(result==1){
    		//String dataQuery = "SELECT   a.locn_short_desc, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, a.locn_code,locn_type, a.practitioner_id, a.locn_type_desc, srl_no,'Y' checkedRec FROM ca_locn_for_pract_vw  a WHERE practitioner_id = ? AND locn_type = ? AND facility_id = ? ORDER BY locn_type, locn_short_desc";
    		//String dataQuery ="";
			StringBuffer dataQuery =new StringBuffer(); //37930
    		if("C".equals(locationType)){
    			//dataQuery = "select a.practitioner_id, a.srl_no, b.facility_id,b.clinic_type locn_type,'CLINIC' locn_type_desc, b.clinic_code locn_code, b.short_desc locn_short_desc,b.long_desc locn_long_desc, to_char(NVL(a.eff_from_date,SYSDATE),'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date , decode (a.practitioner_id,NULL,'N','Y') checkedRec FROM ca_pract_by_locn a, op_clinic b where b.clinic_code = a.locn_code(+) AND  b.clinic_type = 'C' and b.clinic_type =a.locn_type (+) AND b.facility_id = a.facility_id(+) AND a.practitioner_id (+) = ? AND b.facility_id = ? ORDER BY locn_type, locn_short_desc";
				
				//37930 start
				dataQuery.append("select a.practitioner_id, a.srl_no, b.facility_id,b.clinic_type locn_type,'CLINIC' locn_type_desc, b.clinic_code locn_code, b.short_desc locn_short_desc,b.long_desc locn_long_desc, to_char(NVL(a.eff_from_date,SYSDATE),'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date , decode (a.practitioner_id,NULL,'N','Y') checkedRec FROM ca_pract_by_locn a, op_clinic b where b.clinic_code = a.locn_code(+) AND  b.clinic_type = 'C' and b.clinic_type =a.locn_type (+) AND b.facility_id = a.facility_id(+) AND a.practitioner_id (+) = ? AND b.facility_id = ?");
				
				if(!searchText.equals("") && searchBy.equals("locationID")){
    				dataQuery.append(" AND b.clinic_code like '"+searchText+"%'");
    			}else if(!searchText.equals("") && searchBy.equals("locationDesc")){
    				dataQuery.append(" AND b.short_desc like '"+searchText+"%'");
    			}
    			dataQuery.append(" ORDER BY locn_type, locn_short_desc");
				//37930 end
				
    		}else{    			
    			//dataQuery = "SELECT   a.practitioner_id, a.srl_no, a.facility_id, b.locn_type locn_type, 'NURSING UNIT' locn_type_desc, b.nursing_unit_code locn_code, b.short_desc locn_short_desc, b.long_desc locn_long_desc, to_char(NVL(a.eff_from_date,SYSDATE),'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date, DECODE (a.practitioner_id, NULL, 'N', 'Y') checkedRec FROM ca_pract_by_locn a, ip_nursing_unit b WHERE b.nursing_unit_code = a.locn_code(+) AND b.locn_type = 'N' AND b.facility_id = a.facility_id(+) AND a.practitioner_id(+) = ? AND b.facility_id = ? ORDER BY locn_type, locn_short_desc";
				
				//37930 start
				dataQuery.append("SELECT a.practitioner_id, a.srl_no, a.facility_id, b.locn_type locn_type, 'NURSING UNIT' locn_type_desc, b.nursing_unit_code locn_code, b.short_desc locn_short_desc, b.long_desc locn_long_desc, to_char(NVL(a.eff_from_date,SYSDATE),'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date, DECODE (a.practitioner_id, NULL, 'N', 'Y') checkedRec FROM ca_pract_by_locn a, ip_nursing_unit b WHERE b.nursing_unit_code = a.locn_code(+) AND b.locn_type = 'N' AND b.facility_id = a.facility_id(+) AND a.practitioner_id(+) = ? AND b.facility_id = ?");
				
				if(!searchText.equals("") && searchBy.equals("locationID")){
    				dataQuery.append(" AND b.nursing_unit_code like '"+searchText+"%'");
    			}else if(!searchText.equals("") && searchBy.equals("locationDesc")){
    				dataQuery.append(" AND b.short_desc like '"+searchText+"%'");
    			}
    			dataQuery.append(" ORDER BY locn_type, locn_short_desc");
	   		}
			System.out.println("dataQuery:::"+dataQuery);
			//37930 end
    		try{
    			con		= getConnection();
    	    	pstmt = con.prepareStatement(dataQuery.toString());
    	    	pstmt.setString(1, practitionerId);
    	    	pstmt.setString(2, facility_id);
    	    	rs = pstmt.executeQuery();
    	    	
    	    	if(rs!=null ){
    	    		while(rs.next()){ 
    	    			ArrayList<String>  resultArry = new ArrayList<String>();
    	    			resultArry.add(rs.getString("locn_code")==null?"":(String)rs.getString("locn_code"));
    	    			resultArry.add(rs.getString("locn_short_desc")==null?"":(String)rs.getString("locn_short_desc"));
    	    			resultArry.add(rs.getString("locn_type_desc")==null?"":(String)rs.getString("locn_type_desc"));
    	    			resultArry.add(rs.getString("eff_from_date")==null?"":(String)rs.getString("eff_from_date"));
    	    			resultArry.add(rs.getString("eff_to_date")==null?"":(String)rs.getString("eff_to_date"));
    	    			resultArry.add(rs.getString("checkedRec")==null?"":(String)rs.getString("checkedRec"));
    	    			resultArryList.add(resultArry);
    	    		}
    	    	}
    	    	if(rs!=null)
    	    		rs.close();	
    	    	if(pstmt!=null)
    	    		pstmt.close();	
    	    	if(con!=null)
    				con.close();	
    		}catch(Exception e){        		
        		try {
    				con.rollback();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        		e.printStackTrace();
        	}
    	}
    	return resultArryList;
    	
    }
    public int getMultiLocForPrctitionerDetails(String facility_id, String practitionerId, String locationType, String searchBy, String searchText,String locale){
    	
    	boolean  process=true;
    	int reulst=1;
    	System.out.println("MultiLocForPractitionerBean======facility_id=========>"+facility_id+"<=============");
    	System.out.println("MultiLocForPractitionerBean======practitionerId=========>"+practitionerId+"<=============");
    	System.out.println("MultiLocForPractitionerBean======locationType=========>"+locationType+"<=============");
    	System.out.println("MultiLocForPractitionerBean======searchBy=========>"+searchBy+"<=============");
    	System.out.println("MultiLocForPractitionerBean======searchText=========>"+searchText+"<=============");
    	int[] cArr=null;
    	int[] nArr=null;
    	String query01 =  " SELECT to_char(Eff_from_Date,'dd/mm/yyyy') EFF_FROM_DATE,to_char(Eff_to_Date,'dd/mm/yyyy') EFF_TO_DATE, ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_FACILITY_ID   FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?  AND FACILITY_ID=? AND LOCN_TYPE=? AND LOCN_CODE=?";
    	
    	try{
    		con		= getConnection();
	    	pstmt = con.prepareStatement(query01);
	    	pstmt.setString(1, practitionerId);
	    	pstmt.setString(2, facility_id);
	    	pstmt.setString(3, "Z");
	    	pstmt.setString(4, "*ALLZ");    	
			rs = pstmt.executeQuery();
			System.out.println("------------------------->37");
			if(rs!=null && rs.next()){
				String effFromDate=rs.getString("EFF_FROM_DATE")==null?"":(String)rs.getString("EFF_FROM_DATE");
				String effToDate=rs.getString("EFF_TO_DATE")==null?"":(String)rs.getString("EFF_TO_DATE");
				String addedById=rs.getString("ADDED_BY_ID")==null?"":(String)rs.getString("ADDED_BY_ID");
				String addedByWsNo=rs.getString("ADDED_AT_WS_NO")==null?"":(String)rs.getString("ADDED_AT_WS_NO");
				String addFacility=rs.getString("ADDED_FACILITY_ID")==null?"":(String)rs.getString("ADDED_FACILITY_ID");
				
				System.out.println("---------------104---------->"+effFromDate);
				System.out.println("---------------105---------->"+effToDate);
				
				effFromDate		=		com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");
				effToDate			=		com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");
				
				System.out.println("---------------110---------->"+effFromDate);
				System.out.println("---------------111---------->"+effToDate);
				
				process = false;				
				pstmt1  = con.prepareStatement(" DELETE FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?  AND FACILITY_ID=? AND LOCN_TYPE=? AND LOCN_CODE=? ");
				pstmt1.setString(1, practitionerId);
		    	pstmt1.setString(2, facility_id);
		    	pstmt1.setString(3, "Z"); 
		    	pstmt1.setString(4, "*ALLZ");  
				int countDelRec = pstmt1.executeUpdate();
				if(countDelRec>0){
					
					int rCount=1;
					pstmt2  = con.prepareStatement(" SELECT NVL(MAX(SRL_NO),0)+1 RCOUNT FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?");
					pstmt2.setString(1, practitionerId);
					rs2 = pstmt2.executeQuery();
					if(rs2!=null && rs2.next()){
						rCount=rs2.getInt("RCOUNT");
					}
					
					if(rs2!=null)
			    		rs2.close();			    	
			    	if(pstmt2!=null)
			    		pstmt2.close();
			    	
					// Clinic
					pstmt2 = con.prepareStatement("SELECT CLINIC_CODE FROM OP_CLINIC WHERE FACILITY_ID=?");
			    	pstmt2.setString(1, facility_id);
			    	rs2 = pstmt2.executeQuery();
			    	if(rs2!=null){
			    		pstmt3 = con.prepareStatement("INSERT INTO CA_PRACT_BY_LOCN(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?)");
			    		
			    		while(rs2.next()){
			    			pstmt3.setString(1, practitionerId);
			    			pstmt3.setInt(2, rCount);
			    			pstmt3.setString(3, facility_id);
			    			pstmt3.setString(4, "C");
			    			pstmt3.setString(5, rs2.getString("CLINIC_CODE"));
			    			pstmt3.setString(6,effFromDate);
			    			pstmt3.setString(7, effToDate);
			    			pstmt3.setString(8, addedById);
			    			pstmt3.setString(9, addedByWsNo);
			    			pstmt3.setString(10, addFacility);
			    			pstmt3.setString(11, addedById);
			    			pstmt3.setString(12, addedByWsNo);
			    			pstmt3.setString(13, addFacility);
			    			pstmt3.addBatch();
			    			rCount++;
			    		}
			    		if(rCount>1)
			    			cArr=pstmt3.executeBatch();
			    	}
			    	
			    	if(rs2!=null)
			    		rs2.close();			    	
			    	if(pstmt2!=null)
			    		pstmt2.close();
			    	if(pstmt3!=null)
			    		pstmt3.close();
			    	// Nursing Unit
			    	pstmt2 = con.prepareStatement("SELECT NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE FACILITY_ID=?");
			    	pstmt2.setString(1, facility_id);
			    	rs2 = pstmt2.executeQuery();
			    	if(rs2!=null){
			    		pstmt3 = con.prepareStatement("INSERT INTO CA_PRACT_BY_LOCN(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?)");
			    		
			    		while(rs2.next()){
			    			pstmt3.setString(1, practitionerId);
			    			pstmt3.setInt(2, rCount);
			    			pstmt3.setString(3, facility_id);
			    			pstmt3.setString(4, "W");
			    			pstmt3.setString(5, rs2.getString("NURSING_UNIT_CODE"));
			    			pstmt3.setString(6,effFromDate);
			    			pstmt3.setString(7, effToDate);
			    			pstmt3.setString(8, addedById);
			    			pstmt3.setString(9, addedByWsNo);
			    			pstmt3.setString(10, addFacility);
			    			pstmt3.setString(11, addedById);
			    			pstmt3.setString(12, addedByWsNo);
			    			pstmt3.setString(13, addFacility);
			    			pstmt3.addBatch();
			    			rCount++;
			    		}
			    		if(rCount>1)
			    			nArr=pstmt3.executeBatch();
			    	}
			    	
			    	if(rs2!=null)
			    		rs2.close();			    	
			    	if(pstmt2!=null)
			    		pstmt2.close();
			    	if(pstmt3!=null)
			    		pstmt3.close();
				}					
				if(pstmt1!=null)
		    		pstmt1.close();	
			}
			
			if(rs!=null)
	    		rs.close();			    	
	    	if(pstmt!=null)
	    		pstmt.close();
	    	System.out.println("------------------------->128");
			if(process  && "C".equals(locationType)){				
				//x,*ALLC
				pstmt = con.prepareStatement(query01);
				pstmt.setString(1, practitionerId);
		    	pstmt.setString(2, facility_id);
		    	pstmt.setString(3, "X");
		    	pstmt.setString(4, "*ALLC");    	
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					String effFromDate=rs.getString("EFF_FROM_DATE")==null?"":(String)rs.getString("EFF_FROM_DATE");
					String effToDate=rs.getString("EFF_TO_DATE")==null?"":(String)rs.getString("EFF_TO_DATE");
					String addedById=rs.getString("ADDED_BY_ID")==null?"":(String)rs.getString("ADDED_BY_ID");
					String addedByWsNo=rs.getString("ADDED_AT_WS_NO")==null?"":(String)rs.getString("ADDED_AT_WS_NO");
					String addFacility=rs.getString("ADDED_FACILITY_ID")==null?"":(String)rs.getString("ADDED_FACILITY_ID");
					
					System.out.println("---------------228--------->"+effFromDate);
					System.out.println("---------------229---------->"+effToDate);
				
				
					effFromDate		=		com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");
					effToDate			=		com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");
					
					System.out.println("---------------235--------->"+effFromDate);
					System.out.println("---------------236---------->"+effToDate);
				
				
					process = false;				
					pstmt1  = con.prepareStatement(" DELETE FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?  AND FACILITY_ID=? AND LOCN_TYPE=? AND LOCN_CODE=? ");
					pstmt1.setString(1, practitionerId);
			    	pstmt1.setString(2, facility_id);
			    	pstmt1.setString(3, "X");
			    	pstmt1.setString(4, "*ALLC");  
					int countDelRec = pstmt1.executeUpdate();
					
					if(pstmt1!=null)
						pstmt1.close();
					
					
					if(countDelRec>0){
						// Clinic
						
						int cCount=1;
						pstmt2  = con.prepareStatement(" SELECT NVL(MAX(SRL_NO),0)+1 RCOUNT FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?");
						pstmt2.setString(1, practitionerId);
						System.out.println("--------------practitionerId------------->"+practitionerId);
						rs2 = pstmt2.executeQuery();
						if(rs2!=null && rs2.next()){
							System.out.println("--------------230------------->"+rs2.getInt("RCOUNT"));
							cCount=rs2.getInt("RCOUNT");
							System.out.println("--------------232------------->"+cCount);
							
						}
						
						if(rs2!=null)
				    		rs2.close();			    	
				    	if(pstmt2!=null)
				    		pstmt2.close();
				    	
						pstmt2 = con.prepareStatement("SELECT CLINIC_CODE FROM OP_CLINIC WHERE FACILITY_ID=? ");
				    	pstmt2.setString(1, facility_id);
				    	rs2 = pstmt2.executeQuery();
				    	if(rs2!=null){
				    		pstmt3 = con.prepareStatement("INSERT INTO CA_PRACT_BY_LOCN(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?)");
				    		
				    		while(rs2.next()){
				    			System.out.println("--------------244------------->"+cCount);
				    			pstmt3.setString(1, practitionerId);
				    			pstmt3.setInt(2, cCount);
				    			pstmt3.setString(3, facility_id);
				    			pstmt3.setString(4, "C");
				    			pstmt3.setString(5, rs2.getString("CLINIC_CODE"));
				    			pstmt3.setString(6,effFromDate);
				    			pstmt3.setString(7, effToDate);
				    			pstmt3.setString(8, addedById);
				    			pstmt3.setString(9, addedByWsNo);
				    			pstmt3.setString(10, addFacility);
				    			pstmt3.setString(11, addedById);
				    			pstmt3.setString(12, addedByWsNo);
				    			pstmt3.setString(13, addFacility);
				    			pstmt3.addBatch();
				    			cCount++;
				    		}
				    		if(cCount>1)
				    			cArr=pstmt3.executeBatch();
				    	}
				    	
				    	if(rs2!=null)
				    		rs2.close();			    	
				    	if(pstmt2!=null)
				    		pstmt2.close();
				    	if(pstmt3!=null)
				    		pstmt3.close();
					}
					if(pstmt1!=null)
			    		pstmt1.close();
					
				}
				if(rs!=null)
		    		rs.close();			    	
		    	if(pstmt!=null)
		    		pstmt.close();
			}
			
	    	System.out.println("------------------------->192");
			if(process  && "W".equals(locationType)){
				System.out.println("------------------------->194");
				//Y, *ALLW
				pstmt = con.prepareStatement(query01);
				pstmt.setString(1, practitionerId);
		    	pstmt.setString(2, facility_id);
		    	pstmt.setString(3, "Y");
		    	pstmt.setString(4, "*ALLW");    	
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					String effFromDate=rs.getString("EFF_FROM_DATE")==null?"":(String)rs.getString("EFF_FROM_DATE");
					String effToDate=rs.getString("EFF_TO_DATE")==null?"":(String)rs.getString("EFF_TO_DATE");
					String addedById=rs.getString("ADDED_BY_ID")==null?"":(String)rs.getString("ADDED_BY_ID");
					String addedByWsNo=rs.getString("ADDED_AT_WS_NO")==null?"":(String)rs.getString("ADDED_AT_WS_NO");
					String addFacility=rs.getString("ADDED_FACILITY_ID")==null?"":(String)rs.getString("ADDED_FACILITY_ID");
					
				System.out.println("---------------333---------->"+effFromDate);
				System.out.println("---------------334---------->"+effToDate);					
					
					effFromDate		=		com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");
					effToDate			=		com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");
					
				System.out.println("---------------339---------->"+effFromDate);
				System.out.println("---------------340---------->"+effToDate);
				
					process = false;				
					pstmt1  = con.prepareStatement(" DELETE FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?  AND FACILITY_ID=? AND LOCN_TYPE=? AND LOCN_CODE=? ");
					pstmt1.setString(1, practitionerId);
			    	pstmt1.setString(2, facility_id);
			    	pstmt1.setString(3, "Y");
			    	pstmt1.setString(4, "*ALLW");  
					int countDelRec = pstmt1.executeUpdate();
					if(countDelRec>0){
						// Nursing Unit
						
						int nCount=1;
						pstmt2  = con.prepareStatement(" SELECT NVL(MAX(SRL_NO),0)+1 RCOUNT FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?");
						pstmt2.setString(1, practitionerId);
						rs2 = pstmt2.executeQuery();
						if(rs2!=null && rs2.next()){
							nCount=rs2.getInt("RCOUNT");
						}
						
						if(rs2!=null)
				    		rs2.close();			    	
				    	if(pstmt2!=null)
				    		pstmt2.close();
				    	
						pstmt2 = con.prepareStatement("SELECT NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE FACILITY_ID=? ");
				    	pstmt2.setString(1, facility_id);
				    	rs2 = pstmt2.executeQuery();
				    	if(rs2!=null){
				    		pstmt3 = con.prepareStatement("INSERT INTO CA_PRACT_BY_LOCN(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
				    		
				    		while(rs2.next()){
				    			pstmt3.setString(1, practitionerId);
				    			pstmt3.setInt(2, nCount);
				    			pstmt3.setString(3, facility_id);
				    			pstmt3.setString(4, "W");
				    			pstmt3.setString(5, rs2.getString("NURSING_UNIT_CODE"));
				    			pstmt3.setString(6, effFromDate);
				    			pstmt3.setString(7, effToDate);
				    			pstmt3.setString(8, addedById);
				    			pstmt3.setString(9, addedByWsNo);
				    			pstmt3.setString(10, addFacility);
				    			pstmt3.setString(11, addedById);
				    			pstmt3.setString(12, addedByWsNo);
				    			pstmt3.setString(13, addFacility);				    			
				    			pstmt3.addBatch();
				    			nCount++;
				    		}

			    			
				    		if(nCount>1){
				    			 nArr = pstmt3.executeBatch();
				    		}
				    		
				    	}
				    	
				    	if(rs2!=null)
				    		rs2.close();			    	
				    	if(pstmt2!=null)
				    		pstmt2.close();
				    	if(pstmt3!=null)
				    		pstmt3.close();
					}
					if(pstmt1!=null)
			    		pstmt1.close();
					
				}
				if(rs!=null)
		    		rs.close();			    	
		    	if(pstmt!=null)
		    		pstmt.close();
			}
			
			if(cArr!=null || nArr!=null){
				con.commit();
			}
			if(con!=null)
				con.close();	
			
    	}catch(Exception e){
    		reulst=0;
    		try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		e.printStackTrace();
    	}
    	return reulst;
    } 

}
