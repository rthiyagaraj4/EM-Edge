<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							

--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%
Connection con=null;
con=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		String facilityID = (String) hashObj.get("facilityID") == null ? "": (String) hashObj.get("facilityID");
		String lmpDateStr = (String) hashObj.get("lmp_date") == null ? "": (String) hashObj.get("lmp_date");
		String scanGestWeeksStr = (String) hashObj.get("scanGestationWeeks") == null ? "": (String) hashObj.get("scanGestationWeeks");
		String scanGestDaysStr = (String) hashObj.get("scanGestationDays") == null ? "": (String) hashObj.get("scanGestationDays");
		String or_bean_id 						= "@CAMenstrualHistDtlTransBean";
		String or_bean_name 					= "eCA.CAMenstrualHistDtlTransBean";
		CAMenstrualHistDtlTransBean bean		= (CAMenstrualHistDtlTransBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		
		 int[] ageDetails = bean.getMenstrualAgeDetails(facilityID);
		  int minAge = ageDetails[0];
		  int maxAge = ageDetails[1];

		 if("CHK_PAT_VALID_YN".equals(action)){
			 int pat_count=0;
			 pstmt = con.prepareStatement( "SELECT COUNT(*) TOTAL_COUNT FROM MP_PATIENT WHERE PATIENT_ID =? " ) ;
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					pat_count =  rs.getInt("TOTAL_COUNT");
				    out.print(pat_count);
				}
    		}
		 else if("CHK_PATIENT_RANGE".equals(action))
		 {
			int pat_count=0;
			String gender="";
			String age="";
			Integer patientAge 	= 0;

			pstmt = con.prepareStatement("SELECT SEX,GET_AGE(DATE_OF_BIRTH) AGE FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			gender = rs.getString("SEX")==null?"":(String)rs.getString("SEX");
			age = rs.getString("AGE")==null?"":(String)rs.getString("AGE");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				
				if (age != null && age.length() > 1) {
					if(age.indexOf('Y')!=-1)
						patientAge = Integer.parseInt(age.substring(0, age.indexOf('Y')));

			    }
				
				
				if(gender.equals("F") && (patientAge < minAge || patientAge > maxAge))
					out.println("N");
				else
					out.println("Y"); 
		 }
		 else if("CHK_PATIENT_GENDER".equals(action))
		 {
			int pat_count=0;
			String gender="";
			pstmt = con.prepareStatement("SELECT SEX FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			gender = rs.getString("SEX")==null?"":(String)rs.getString("SEX");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
							
				if(!gender.equals("F"))
					out.println("N");
				else
					out.println("Y"); 
		 }
		 else if ("CHK_PATIENT_AVAILABLE".equals(action)) {
			 String result = "";
			    ArrayList patientDetails = bean.getPatientAvaliable(patient_id, facilityID);
			    if (patientDetails.size() > 0) {
			        for (int i = 0; i < patientDetails.size(); i++) {
			            String[] record = (String[]) patientDetails.get(i);
			            patient_id = CommonBean.checkForNull(record[0]);
			            String encounter_id = CommonBean.checkForNull(record[1]);
			            String episode_id = CommonBean.checkForNull(record[2]);
			            result = patient_id + "," + encounter_id + "," + episode_id;
			        }
			    }
			    out.print(result);
			}else if ("CHK_LMP_DATE".equals(action) && lmpDateStr != null) {
			 String[] eddDetails = bean.getEddOfLmpDate(lmpDateStr);
	            
	            String edd = eddDetails[0];        // Estimated Delivery Date
	            String gestWeeks = eddDetails[1];  // Gestation weeks
	            String remDays = eddDetails[2];    // Remaining days

	            // Prepare and print the XML result
	            StringBuilder result = new StringBuilder();
	            result.append("<result>");
	            result.append("<edd>").append(edd).append("</edd>");
	            result.append("<gestationWeeks>").append(gestWeeks).append("</gestationWeeks>");
	            result.append("<gestationDays>").append(remDays).append("</gestationDays>");
	            result.append("</result>");

	            // Output result to JSP
	            out.print(result.toString());
	            System.out.println("Result XML: " + result.toString());
    	}
		 else if ("CHK_UNSURE_PRE_DATE".equals(action) && scanGestWeeksStr != null && scanGestDaysStr != null) {
			    // Convert input parameters to integers
			    int scanGestWeeks = Integer.parseInt(scanGestWeeksStr);
			    int scanGestDays = Integer.parseInt(scanGestDaysStr);

			    // Call the calculateUnsurePreDate method and get the results
			    String[] unsurePreDateDetails = bean.calculateUnsurePreDate(scanGestWeeks, scanGestDays);

			    String lmpDate = unsurePreDateDetails[0];       // Last Menstrual Period (LMP) Date
			    String reddDate = unsurePreDateDetails[1];      // Expected Delivery Date (REDD)
			    String pogWeeks = unsurePreDateDetails[2];      // Gestation in weeks
			    String pogDays = unsurePreDateDetails[3];       // Remaining days of gestation

			    // Prepare and print the XML result
			    StringBuilder result = new StringBuilder();
			    result.append("<result>");
			    result.append("<lmpDate>").append(lmpDate).append("</lmpDate>");
			    result.append("<reddDate>").append(reddDate).append("</reddDate>");
			    result.append("<gestationWeeks>").append(pogWeeks).append("</gestationWeeks>");
			    result.append("<gestationDays>").append(pogDays).append("</gestationDays>");
			    result.append("</result>");

			    // Output the result to JSP
			    out.print(result.toString());
			    System.out.println("Result XML: " + result.toString());
			}

		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
finally
{
    if(rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(con != null) 
		try {
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
}
%>