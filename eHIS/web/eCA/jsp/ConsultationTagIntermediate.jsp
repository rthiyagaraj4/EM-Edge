<%
/*  
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
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
		String tagPractitonerId = (String) hashObj.get("tagPractitonerId") == null ? "": (String) hashObj.get("tagPractitonerId");
		String facility_id = (String) hashObj.get("facility_id") == null ? "": (String) hashObj.get("facility_id");
		String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
		String language_id = (String) hashObj.get("language_id") == null ? "": (String) hashObj.get("language_id");

		 String bean_id					= "ConsultationTaggingBean" ;
		 String bean_name				= "eCA.ConsultationTaggingBean";
		 ConsultationTaggingBean bean	= (ConsultationTaggingBean)getBeanObject( bean_id, bean_name , request) ;
	     ArrayList<ArrayList<String>> searchData=new ArrayList<ArrayList<String>>();
		 
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
		 else if("CHK_PAT_APPLI_CONSUL_TAG".equals(action))
		 {
			int pat_count=0;
			String appli_pat_consultag_dcyn="";
			String appli_pat_consultag_emyn="";
			String appli_pat_consultag_ipyn="";
			String appli_pat_consultag_opn="";
			pstmt = con.prepareStatement("SELECT APPLI_PAT_CONSULTAG_DCYN, APPLI_PAT_CONSULTAG_EMYN, APPLI_PAT_CONSULTAG_IPYN, APPLI_PAT_CONSULTAG_OPYN from CA_PARAM_BY_FACILITY where FACILITY_ID=?" ) ;
			pstmt.setString(1, facility_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			appli_pat_consultag_dcyn = rs.getString("APPLI_PAT_CONSULTAG_DCYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_DCYN");
			appli_pat_consultag_emyn = rs.getString("APPLI_PAT_CONSULTAG_EMYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_EMYN");
			appli_pat_consultag_ipyn = rs.getString("APPLI_PAT_CONSULTAG_IPYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_IPYN");
			appli_pat_consultag_opn = rs.getString("APPLI_PAT_CONSULTAG_OPYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_OPYN");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(appli_pat_consultag_dcyn.equals("N") && appli_pat_consultag_emyn.equals("N") && appli_pat_consultag_ipyn.equals("N") && appli_pat_consultag_opn.equals("N"))
					out.println("N");
				else if (appli_pat_consultag_dcyn.equals("Y") || appli_pat_consultag_emyn.equals("Y") || appli_pat_consultag_ipyn.equals("Y") || appli_pat_consultag_opn.equals("Y"))
					out.println("Y"); 
		 }
		 
		 else if("CHK_PRACT_ALRDY_TAG_YN".equals(action))
		 { 
			int pat_count=0;
			int tagPractitionerYN=0;
			String appli_pat_consultag_emyn="";
			String appli_pat_consultag_ipyn="";
			String appli_pat_consultag_opn="";
		    pstmt = con.prepareStatement("SELECT COUNT(*) TAG_PRACTITIONER_ID FROM CA_CONSULTATION_TAGGING WHERE TAG_PRACTITIONER_ID=? AND FACILITY_ID =? AND PATIENT_ID =? AND ENCOUNTER_ID =?");
			pstmt.setString(1, tagPractitonerId);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, encounter_id);
			rs = pstmt.executeQuery() ;
			if( rs != null){
			if( rs.next()){
		    tagPractitionerYN = rs.getInt("TAG_PRACTITIONER_ID");
			}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(tagPractitionerYN > 0)
			out.println("N");
			else
			out.println("Y"); 
		 }
		 else if("CHK_PAT_ACTIVE_ENCOUNT_YN".equals(action))
		 { 
			searchData=bean.getPatRecordConsultationTagging(patient_id,facility_id,language_id);			
			out.println(searchData.size()); 
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