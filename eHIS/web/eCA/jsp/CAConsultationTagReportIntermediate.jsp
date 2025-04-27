<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
12/06/2024  50627    Twinkle Shah    12/06/2024		Ramesh Goli        ML-MMOH-CRF-2106
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
		String p_facility_id = (String) hashObj.get("p_facility_id") == null ? "": (String) hashObj.get("p_facility_id");
		String p_patient_id = (String) hashObj.get("p_patient_id") == null ? "": (String) hashObj.get("p_patient_id");
		String encounterType = (String) hashObj.get("encounterType") == null ? "": (String) hashObj.get("encounterType");
		String p_category_type = (String) hashObj.get("p_category_type") == null ? "": (String) hashObj.get("p_category_type");
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		 if("POPUP_ENCOUNTER".equals(action))
		 {
			String patientcls="";
			String encounterId="";
			StringBuffer dataQuery =new StringBuffer(); 
			dataQuery.append("SELECT A.PATIENT_CLASS,A.ENCOUNTER_ID ENCOUNTER_ID FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN('OP', 'EM') AND A.VISIT_STATUS NOT IN('01', '02', '99') ) ) AND A.FACILITY_ID = ? ");
			if("OP".equals(encounterType)){
				if("Y".equals(p_category_type))
				{
				dataQuery.append("AND 'Y'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) AND A.PATIENT_CLASS IN ('OP')");
				}
				else if("N".equals(p_category_type))
				{
				dataQuery.append(" AND ('N'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) OR 'E'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID)) AND A.PATIENT_CLASS IN ('OP')");
				}
				else
				{
				 dataQuery.append("AND A.PATIENT_CLASS IN ('OP')");	
				}
		    }
			
			else if("IP".equals(encounterType))
			{
				if("Y".equals(p_category_type))
				{
					dataQuery.append("AND 'Y'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) AND A.PATIENT_CLASS IN ('IP')");
				}
				else if("N".equals(p_category_type))
				{
					dataQuery.append(" AND ('N'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) OR 'E'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID)) AND A.PATIENT_CLASS IN ('IP')");
				}
				else
				{
			        dataQuery.append("AND A.PATIENT_CLASS IN ('IP')");
				}
		    }
			else if("EM".equals(encounterType)){
				if("Y".equals(p_category_type))
				{
				    dataQuery.append(" AND 'Y'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) AND A.PATIENT_CLASS IN ('EM')");
				}
				else if("N".equals(p_category_type))
				{
					dataQuery.append(" AND ('N'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) OR 'E'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID)) AND A.PATIENT_CLASS IN ('EM')");
				}
				else
				{
			        dataQuery.append("AND A.PATIENT_CLASS IN ('EM')");
				}
		    }
			else if("DC".equals(encounterType)){
				if("Y".equals(p_category_type))
				{
					dataQuery.append(" AND 'Y'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) AND A.PATIENT_CLASS IN ('DC')");
				}
				else if("N".equals(p_category_type))
				{
					dataQuery.append(" AND ('N'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) OR 'E'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID)) AND A.PATIENT_CLASS IN ('DC')");
				}
				else
				{
			    dataQuery.append("AND A.PATIENT_CLASS IN ('DC')");
				}
		    }

			if("Y".equals(p_category_type) && "".equals(encounterType))
			{
				dataQuery.append(" AND 'Y'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID)");
			}
			
			if("N".equals(p_category_type) && "".equals(encounterType)){
				dataQuery.append(" AND ('N'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID) OR 'E'=CA_GET_FPP_ENCOUNTER_YN(a.FACILITY_ID,a.PATIENT_CLASS,A.ENCOUNTER_ID))");
			}
			dataQuery.append("ORDER BY A.ADDED_DATE");
            pstmt = con.prepareStatement(dataQuery.toString());
			pstmt.setString(1,p_patient_id);
		    pstmt.setString(2,p_facility_id);
				out.println( "clearEncounterList();");
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
				patientcls =  rs.getString("PATIENT_CLASS");
				encounterId =  rs.getString("ENCOUNTER_ID");
				String selected = "false";							
				out.println( "addEncounterList(\"" + encounterId + "\",\"" + encounterId + "\") ; " ) ;			
          }
		 }
		 if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
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