<%
/*
Sr No        Version            Incident          SCF/CRF             		Developer Name
1			 V240221		 	 56225 			NMC-JD-CRF-0102.9-US001		Kranthi Kumar
*/
%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.sql.*,java.net.*,java.util.*,java.lang.String,java.util.ArrayList,eXH.XHDBAdapter,eXH.*" %>
<!DOCTYPE html>
<html>
<head>

</head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<body>
<% 
    String l_response_ref_id = request.getParameter("response_ref_id");
    String l_operating_facility_id = request.getParameter("operating_facility_id");
    String l_patient_id = request.getParameter("patient_id");
    String l_episode_type = request.getParameter("episode_type");
    String l_episode_id = request.getParameter("episode_id");
    String l_visit_id = request.getParameter("visit_id");
    boolean REQUEST_DATE = false,BENEFIT_NAME = false,BENEFIT_DESC = false,CATEGORY_CODE = false,
    		CATEGORY_DESC = false,NETWORK_CODE = false,NETWORK_DESC = false,UNIT_CODE = false,
    		UNIT_DESC = false,TERM_CODE = false,TERM_DESC = false,BENEFIT_ALLOWED = false,
    		BENEFIT_USED = false;
    String patientId = "", response_ref_id = "", request_date = "", seq_no = "", line_no = "", benefit_name = "", benefit_desc = "",
        category_code = "", category_desc = "", network_code = "", network_desc = "", unit_code = "", unit_desc = "", term_code = "",
        term_desc = "", benefit_allowed = "", benefit_used = "";
    
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Connection dbConn = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    try {
        dbConn = ConnectionManager.getConnection();
        System.out.println("l_response_ref_id ::: " + l_response_ref_id +" l_patient_id ::: "+l_patient_id);
        if (l_response_ref_id != null && l_response_ref_id != "" && !l_response_ref_id.equals("null")) {
        	 System.out.println("first screen");
            String query = "SELECT * FROM bl_table_of_benefit WHERE PATIENT_ID = ? AND RESPONSE_REF_ID = ?";
            pstmt = dbConn.prepareStatement(query);
            pstmt.setString(1, l_patient_id);
            pstmt.setString(2, l_response_ref_id);
            rs = pstmt.executeQuery();
        } else {
            System.out.println(" second screen");
            String query1 = "SELECT A.OPERATING_FACILITY_ID, A.EPISODE_TYPE, A.EPISODE_ID, A.VISIT_ID,A.PATIENT_ID, A.ACCT_SEQ_NO, A.INT_ELGIBILITY_CODE " +
                " FROM BL_ENCOUNTER_PAYER_PRIORITY A " +
                "WHERE A.OPERATING_FACILITY_ID = ? " +
                " AND A.PATIENT_ID = ? " +
                " AND A.EPISODE_TYPE = ?" +
                " AND A.EPISODE_ID = ?" +
                " AND A.VISIT_ID = ?" +
                " AND A.INT_ELGIBILITY_CODE IS NOT NULL " +
                " AND ACCT_SEQ_NO IN ( " +
                "      SELECT MAX (ACCT_SEQ_NO) " +
                "   FROM BL_ENCOUNTER_PAYER_PRIORITY B " +
                "  WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID " +
                "   AND A.PATIENT_ID = B.PATIENT_ID " +
                "   AND A.EPISODE_TYPE = B.EPISODE_TYPE " +
                "   AND A.EPISODE_ID = B.EPISODE_ID " +
                "  AND A.VISIT_ID = B.VISIT_ID " +
                " AND INT_ELGIBILITY_CODE IS NOT NULL)";
            pstmt1 = dbConn.prepareStatement(query1);
            pstmt1.setString(1, l_operating_facility_id);
            pstmt1.setString(2, l_patient_id);
            pstmt1.setString(3, l_episode_type);
            pstmt1.setString(4, l_episode_id);
            pstmt1.setString(5, l_visit_id);
            rs1 = pstmt1.executeQuery();
            String int_elgibility_code = "";
            String patient_id = "";
            while (rs1.next()) {
                int_elgibility_code = rs1.getString("INT_ELGIBILITY_CODE");
                patient_id = rs1.getString("PATIENT_ID");
            }
            if (int_elgibility_code != "" && patient_id != "") {
            	System.out.println(int_elgibility_code+"  "+patient_id);
                String query2 = "SELECT * FROM bl_table_of_benefit WHERE PATIENT_ID = ? AND RESPONSE_REF_ID = ?";
                pstmt = dbConn.prepareStatement(query2);
                System.out.println("Executing second query...");
                pstmt.setString(1, patient_id);
                pstmt.setString(2, int_elgibility_code);
                rs = pstmt.executeQuery();
               

            }
        }
      
        if (rs != null && rs.isBeforeFirst()) {
        	 System.out.println("ResultSet is not empty.");
			%>

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=left >
<tr>
<td class='label' colspan="13">Table Of Benefits (TOB)</td>
</tr>
<%
            while (rs.next()) {
            	
            	//patientId = rs.getString("PATIENT_ID");
				//response_ref_id = rs.getString("RESPONSE_REF_ID");
				request_date = rs.getString("REQUEST_DATE");
				//seq_no = rs.getString("SEQUENCE_NO");
				//line_no = rs.getString("LINE_NO");
				benefit_name = rs.getString("BENEFIT_NAME");
				benefit_desc = rs.getString("BENEFIT_DESC");
				category_code = rs.getString("CATEGORY_CODE");
				category_desc = rs.getString("CATEGORY_DESC");
				network_code = rs.getString("NETWORK_CODE");
				network_desc = rs.getString("NETWORK_DESC");
				unit_code = rs.getString("UNIT_CODE");
				unit_desc = rs.getString("UNIT_DESC");
				term_code = rs.getString("TERM_CODE");
				term_desc = rs.getString("TERM_DESC");
				benefit_allowed = rs.getString("BENEFIT_ALLOWED");
				benefit_used = rs.getString("BENEFIT_USED");
            	
				HashMap<String,String> obj = new HashMap<String,String>();
				obj.put("REQUEST_DATE",request_date);
				obj.put("BENEFIT_NAME",benefit_name);
				obj.put("BENEFIT_DESC",benefit_desc);
				obj.put("CATEGORY_CODE",category_code);
				obj.put("CATEGORY_DESC",category_desc);
				obj.put("NETWORK_CODE",network_code);
				obj.put("NETWORK_DESC",network_desc);
				obj.put("UNIT_CODE",unit_code);
				obj.put("UNIT_DESC",unit_desc);
				obj.put("TERM_CODE",term_code);
				obj.put("TERM_DESC",term_desc);
				obj.put("BENEFIT_ALLOWED",benefit_allowed);
				obj.put("BENEFIT_USED",benefit_used);
				list.add(obj);
				if(request_date!=null)REQUEST_DATE=true;
				if(benefit_name!=null)BENEFIT_NAME=true;
				if(benefit_desc!=null)BENEFIT_DESC=true;
				if(category_code!=null)CATEGORY_CODE=true;
				if(category_desc!=null)CATEGORY_DESC=true;
				if(network_code!=null)NETWORK_CODE=true;
				if(network_desc!=null)NETWORK_DESC=true;
				if(unit_code!=null)UNIT_CODE=true;
				if(unit_desc!=null)UNIT_DESC=true;
				if(term_code!=null)TERM_CODE=true;
				if(term_desc!=null)TERM_DESC=true;
				if(benefit_allowed!=null)BENEFIT_ALLOWED=true;
				if(benefit_used!=null)BENEFIT_USED=true;
            }
			if(list.size()>0){
            %><tr><%
            
            if (BENEFIT_NAME) {
				%><td class='COLUMNHEADER'  width='25%'>BENEFIT NAME</td><%
			}
			if (BENEFIT_DESC) {
				%><td  class='COLUMNHEADER' width='25%'>BENEFIT DESC</td><%
			}
            if (TERM_CODE) {
				%><td class='COLUMNHEADER'  width='25%'>TERM CODE</td><%
			}
            if (BENEFIT_ALLOWED) {
				%><td class='COLUMNHEADER'  width='25%'>BENEFIT ALLOWED</td><%
			}
			if (BENEFIT_USED) {
				%><td class='COLUMNHEADER'  width='25%'>BENEFIT USED</td><%
			}
			
			if (CATEGORY_CODE) {
				%><td class='COLUMNHEADER'  width='25%'>CATEGORY CODE</td><%
			}
			if (CATEGORY_DESC) {
				%><td class='COLUMNHEADER'  width='25%'>CATEGORY DESC</td><%
			}
			if (NETWORK_CODE) {
				%><td class='COLUMNHEADER'  width='25%'>NETWORK CODE</td><%
			}
			if (NETWORK_DESC) {
				%><td class='COLUMNHEADER'  width='25%'>NETWORK DESC</td><%
			}
			if (UNIT_CODE) {
				%><td class='COLUMNHEADER'  width='25%'>UNIT CODE</td><%
			}
			if (UNIT_DESC) {
				%><td class='COLUMNHEADER'  width='25%'>UNIT DESC</td><%
			}
			
			if (TERM_DESC) {
				%><td class='COLUMNHEADER'  width='25%'>TERM DESC</td><%
			}
			
			if (REQUEST_DATE) {
				%><td class='COLUMNHEADER'  width='25%'>REQUEST DATE</td><%
			}
			%></tr><%
			for(HashMap map: list){
				%><tr><%
				if (map.get("BENEFIT_NAME") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("BENEFIT_NAME") %></font></td><%
				}else if(BENEFIT_NAME){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("BENEFIT_DESC") != null) {
					%><td align="left" ><font size=1 >&nbsp;<%= map.get("BENEFIT_DESC") %></font></td><%
				}else if(BENEFIT_DESC){
					%><td align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("TERM_CODE") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("TERM_CODE") %></font></td><%
				}else if(TERM_CODE){
					%><td  align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("BENEFIT_ALLOWED") != null) {
					%><td  class="COLUMN" align="left" ><font size=1 >&nbsp;<%= map.get("BENEFIT_ALLOWED") %></font></td><%
				}else if(BENEFIT_ALLOWED){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("BENEFIT_USED") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("BENEFIT_USED") %></font></td><%
				}else if(BENEFIT_USED){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				
				if (map.get("CATEGORY_CODE") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("CATEGORY_CODE") %></font></td><%
				}else if(CATEGORY_CODE){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("CATEGORY_DESC") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("CATEGORY_DESC") %></font></td><%
				}else if(CATEGORY_DESC){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("NETWORK_CODE") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("NETWORK_CODE") %></font></td><%
				}else if(NETWORK_CODE){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("NETWORK_DESC") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("NETWORK_DESC") %></font></td><%
				}else if(NETWORK_DESC){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("UNIT_CODE") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("UNIT_CODE") %></font></td><%
				}else if(UNIT_CODE){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				if (map.get("UNIT_DESC") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("UNIT_DESC") %></font></td><%
				}else if(UNIT_DESC){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				
				if (map.get("TERM_DESC") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("TERM_DESC") %></font></td><%
				}else if(TERM_DESC){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				
				if (map.get("REQUEST_DATE") != null) {
					%><td  align="left" ><font size=1 >&nbsp;<%= map.get("REQUEST_DATE") %></font></td><%
				}else if(REQUEST_DATE){
					%><td nowrap align="left" ><font size=1 >&nbsp;</font></td><%
				}
				%></tr>
<%}} %>
</table>

<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try { if (rs != null) rs.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { /* Ignored */ }
        try { if (dbConn != null) dbConn.close(); } catch (Exception e) { /* Ignored */ }
        try { if (rs1 != null) rs1.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt1 != null) pstmt1.close(); } catch (Exception e) { /* Ignored */ }
        try { if (rs2 != null) rs2.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt2 != null) pstmt2.close(); } catch (Exception e) { /* Ignored */ }
    }
%>
</body>
</html>
