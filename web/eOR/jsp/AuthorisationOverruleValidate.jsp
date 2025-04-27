<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
	/*
	 --------------------------------------------------------------------------------------------------------------
	 Date       Edit History      Name        Description
	 --------------------------------------------------------------------------------------------------------------
	 ?             100           ?           	created
	 14/03/2014    IN041644		Nijitha S		Prescription Authorization of Drug Based on Rules
	 ---------------------------------------------------------------------------------------------------------------
	 */ 
%>
<%@ page
	import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*"
	contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement cstmt = null;
	ResultSet rs = null;
	Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
	hashObj = (Hashtable) hashObj.get("SEARCH");

	String patient_id = (String) hashObj.get("patient_id") == null ? ""
			: (String) hashObj.get("patient_id");
	String order_catalog_code = (String) hashObj
			.get("order_catalog_code") == null ? "" : (String) hashObj
			.get("order_catalog_code");
	String order_date_time = (String) hashObj.get("order_date_time") == null ? ""
			: (String) hashObj.get("order_date_time");
	String ordering_practitioner = (String) hashObj.get("ordering_practitioner") == null ? ""
			: (String) hashObj.get("ordering_practitioner");

	String overruleAuthor ="";
	try{
		
		con = ConnectionManager.getConnection(request);
		cstmt = con
				.prepareStatement("select or_order_auth_overrule(?,?,?,?) can_authorise  from dual");

		cstmt.setString(1, patient_id);
		cstmt.setString(2, order_catalog_code); 
		cstmt.setString(3, ordering_practitioner);
		cstmt.setString(4, order_date_time);
		//cstmt.registerOutParameter(5, Types.VARCHAR );
		rs = cstmt.executeQuery();
		while(rs.next())
		{
			overruleAuthor = rs.getString("can_authorise");
		}
		  if(rs!=null) rs.close();
		  if(cstmt!=null) cstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	out.println(overruleAuthor);
	
%>
