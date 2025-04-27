<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="eBL.Common.*" %>
<%@ page import="eCommon.XSSRequestWrapper" %>
<%@ page import="webbeans.eCommon.ConnectionManager" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.io.UnsupportedEncodingException"%>

<%
    request.setCharacterEncoding("UTF-8");
    request = new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");

    String searchBy = request.getParameter("searchBy");
    String searchCriteria = request.getParameter("search_criteria");
    String searchText = request.getParameter("search_text");
    String type = request.getParameter("type");

    System.out.println("type: " + type);
    System.out.println("searchBy: " + searchBy);
    System.out.println("searchCriteria: " + searchCriteria);
    System.out.println("searchText: " + searchText);

    String locale = (String) session.getAttribute("LOCALE");
    if (locale == null || locale.trim().equals("")) {
        locale = "en"; // Default value
    }
    
	
	String facilityDecodedValue ="";
	String facilityRawValue = (String) session.getValue("facility_id");
	try {
		 facilityDecodedValue = URLDecoder.decode(facilityRawValue, "UTF-8");
		System.out.println("facilityDecodedValue: " + facilityDecodedValue);
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	String facility = facilityDecodedValue.replaceAll("<[^>]*>", "").trim();
	System.err.println("facility value: " + facility);

	

    System.out.println("locale value = " + locale);

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    Gson gson = new Gson();

    try {
        conn = ConnectionManager.getConnection(request);

        String searchPattern = "";
        if (searchText != null && !searchText.trim().equals("")) {
            searchText = searchText.trim();

            if ("starts_with".equalsIgnoreCase(searchCriteria)) {
                searchPattern = searchText + "%";
            } else if ("ends_with".equalsIgnoreCase(searchCriteria)) {
                searchPattern = "%" + searchText;
            } else if ("contains".equalsIgnoreCase(searchCriteria)) {
                searchPattern = "%" + searchText + "%";
            } else {
                System.out.println("Invalid search criteria: " + searchCriteria);
            }
        }

        System.out.println("searchPattern: " + searchPattern);

        String sql = "";

        if ("fromBillingGroup".equalsIgnoreCase(type) || "toBillingGroup".equalsIgnoreCase(type)) {
            System.out.println("from billing group else");
            System.out.println("billing group searchBy: " + searchBy);

           
            System.out.println("searchPattern after ignore: " + searchPattern);

            // Base SQL query
            sql = "SELECT blng_grp_id AS code, short_desc AS description " +
                  "FROM BL_BLNG_GRP_lang_vw WHERE language_id = ? " +
                  "AND NVL(status, 'X') <> 'S' ";

            System.out.println("billing group searchPattern: " + searchPattern);

            // Modify SQL query based on searchBy
            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside class code");
                sql += "AND UPPER(blng_grp_id) LIKE UPPER(?) ";
            } else if (("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                System.out.println("inside group desc");
                sql += "AND UPPER(short_desc) LIKE UPPER(?) ";
            }

            if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            System.out.println("sql billing group: " + sql);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locale);
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(2, searchPattern);
            }
        } else if ("fromBillingService".equalsIgnoreCase(type) || "toBillingService".equalsIgnoreCase(type) ) {
            System.out.println("from billing service else");
            System.out.println("billing service searchBy: " + searchBy);

           

            // Base SQL query
            sql = "SELECT blng_serv_code AS code, short_desc AS description " +
                  "FROM bl_blng_serv_lang_vw WHERE language_id = ? ";

            System.out.println("billing service searchPattern: " + searchPattern);

            // Modify SQL query based on searchBy
            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside service code");
                sql += "AND UPPER(blng_serv_code) LIKE UPPER(?) ";
            } else if ( ("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                System.out.println("inside service desc");
                sql += "AND UPPER(short_desc) LIKE UPPER(?) ";
            }
			
			if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            // Ensure the ORDER BY clause is at the end of the query
            //sql += "ORDER BY 1"; // Order by the first column 'description'

            System.err.println("sql billing service: " + sql);

            // Prepare the statement and set parameters
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locale);
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(2, searchPattern); // Ensure this is correct and matches the SQL placeholders
            }
        } else if ("fromDrugBillingService".equalsIgnoreCase(type) || "toDrugBillingService".equalsIgnoreCase(type)
			|| "fromConsumableBillingService".equalsIgnoreCase(type) || "toConsumableBillingService".equalsIgnoreCase(type)) {
            System.out.println("from billing service else");
            System.out.println("billing service searchBy: " + searchBy);           

            // Base SQL query
            sql = "select a.item_code code,short_desc description from bl_st_item a,mm_item_lang_vw b where nvl(status,'z') <> 'C' and a.item_code=b.item_code and language_id=? and operating_facility_id=? ";

            System.out.println("billing service searchPattern: " + searchPattern);

            // Modify SQL query based on searchBy
            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside service code");
                sql += " AND UPPER(a.item_code) LIKE UPPER(?) ";
            } else if ( ("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                System.out.println("inside service desc");
                sql += " AND UPPER(short_desc) LIKE UPPER(?) ";
            }
			
			if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            // Ensure the ORDER BY clause is at the end of the query
            //sql += " ORDER BY 1"; // Order by the first column 'description'

            System.err.println("sql billing service: " + sql);

            // Prepare the statement and set parameters
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locale);
			 pstmt.setString(2, facility);
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(3, searchPattern); // Ensure this is correct and matches the SQL placeholders
            }
        } else if ("fromBillingClass".equalsIgnoreCase(type) || "toBillingClass".equalsIgnoreCase(type)) {
            System.out.println("from billing else");
            System.out.println("billing searchBy: " + searchBy);            

            sql = "SELECT code, description from (SELECT '**' AS code, 'ALL' AS description FROM dual UNION ALL " +
                  "SELECT blng_class_code AS code, short_desc AS description " +
                  "FROM bl_blng_class_lang_vw WHERE language_id = ? ) ";

            System.out.println("billing searchPattern: " + searchPattern);

            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside class code");
                sql += "where UPPER(code) LIKE UPPER(?) ";
            } else if (("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                System.out.println("inside class desc");
                sql += "where UPPER(description) LIKE UPPER(?) ";
            }

            if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            System.out.println("sql billing class: " + sql);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locale);
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(2, searchPattern);
            }
        } else if ("fromAmendedby".equalsIgnoreCase(type) || "toAmendedby".equalsIgnoreCase(type)
			|| "fromDrugAmendedby".equalsIgnoreCase(type) || "toDrugAmendedby".equalsIgnoreCase(type)
			|| "fromConsumableCreatedAmendedby".equalsIgnoreCase(type) || "toConsumableCreatedAmendedby".equalsIgnoreCase(type)) {
            System.out.println("searchBy: " + searchBy);
            

            // Prepare base SQL query for "fromAmendedby" or "toAmendedby"
            sql = "SELECT user_id AS code, username AS description " +
                  "FROM sy_user " +
                  "WHERE facility_id = ? " +
                  "AND user_id IN (SELECT user_id FROM bl_user WHERE NVL(status, 'N') != 'S') " +
                  "AND NVL(status, 'N') != 'S'";

            System.out.println("searchPattern fromAmendedby : " + searchPattern);

            // Append condition based on searchBy
            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside user id");
                sql += " AND UPPER(user_id) LIKE UPPER(?)";
            } else if (("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                System.out.println("inside username");
                sql += " AND UPPER(username) LIKE UPPER(?)";
            }

            // Always order by description
           if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            System.out.println("sql: " + sql);

            // Prepare the statement and set parameters
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, facility); // Set the facility_id parameter

            // Set searchPattern parameter if applicable
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(2, searchPattern); // Set the search pattern for the LIKE clause
            }
        } else if ("fromCustomerCode".equalsIgnoreCase(type) || "toCustomerCode".equalsIgnoreCase(type)) {
            System.out.println("searchBy: " + searchBy);            

            sql = "SELECT cust_code AS code , short_name AS description " +
                  "FROM ar_customer_lang_vw WHERE language_id = ? ";

            if ("selectCode".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase("")) {
                System.out.println("inside class code");
                sql += " AND UPPER(cust_code) LIKE UPPER(?)";
            } else if (("selectdesc".equalsIgnoreCase(searchBy) && !searchPattern.equalsIgnoreCase(""))) {
                sql += " AND UPPER(short_name) LIKE UPPER(?)";
            }

            if ("selectCode".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 1";
            } else if ("selectdesc".equalsIgnoreCase(searchBy)) {
				sql += "ORDER BY 2";
            }

            System.out.println("sql: " + sql);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locale);
            if (!searchPattern.equalsIgnoreCase("")) {
                pstmt.setString(2, searchPattern);
            }
        } else {
            System.err.println("Invalid type parameter: " + type);
        }

        rs = pstmt.executeQuery();

        List resultList = new ArrayList();

        while (rs.next()) {
            Map resultMap = new HashMap();
            resultMap.put("code", rs.getString("code"));
            resultMap.put("description", rs.getString("description"));
            resultList.add(resultMap);
        }

        String jsonResponse = gson.toJson(resultList);
        response.setContentType("application/json;charset=UTF-8");
        out.print(jsonResponse);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
    }
%>
