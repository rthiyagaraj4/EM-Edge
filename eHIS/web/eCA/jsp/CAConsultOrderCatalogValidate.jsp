<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String index_value	= (String)hash.get("INDEX_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	String called_from	= (String)hash.get("CALLED_FROM");
	String speciality_code	= (String)hash.get("SPECIALITY_CODE");
	String code="";
	String description="";
//	String class_name   = (String)hash.get("CLASS_NAME");
	String update_value	="";
	//boolean alteredRecord = false;
//	int count_code		= 0;

	CAConsultationBean bean				= (CAConsultationBean)getObjectFromBean( bean_id,bean_name, session ) ;
	eCA.CAMultiRecordBean multiRecSet	= (eCA.CAMultiRecordBean)bean.getBean();
	if(called_from.equalsIgnoreCase("create"))
	{
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	
	try{

		con =  ConnectionManager.getConnection(request);

		String catalogQuery = "select a.order_catalog_code code,b.short_desc description from CA_CONS_CATALOG_FOR_RESOURCE a,or_order_catalog b where a.order_catalog_code=b.order_catalog_code and a.resource_code=? and a.resource_type='S'" ;

		stmt = con.prepareStatement(catalogQuery);

		stmt.setString(1,speciality_code.trim());
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			code=rs.getString("code")==null?"":rs.getString("code").trim();
			description=rs.getString("description")==null?"":rs.getString("description").trim();
			out.println( "CatalogValues(\"" +code+" \",\"" +description+"\") ; " ) ;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}

	}
	else if(called_from.equalsIgnoreCase("practcreate"))
	{
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	
	try{

		con =  ConnectionManager.getConnection(request);

		String catalogQuery = "select a.order_catalog_code code,b.short_desc description from CA_CONS_CATALOG_FOR_RESOURCE a,or_order_catalog b where a.order_catalog_code=b.order_catalog_code and a.resource_code=? and a.resource_type='P'" ;

		stmt = con.prepareStatement(catalogQuery);

		stmt.setString(1,speciality_code.trim());
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			code=rs.getString("code")==null?"":rs.getString("code").trim();
			description=rs.getString("description")==null?"":rs.getString("description").trim();
			out.println( "practCatalogValues(\"" +code+" \",\"" +description+"\") ; " ) ;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}

	}
	else
	{
		int fm_value = Integer.parseInt(fm_val);
		int to_value = Integer.parseInt(to_val);

		StringTokenizer stoken = new StringTokenizer(index_value,"~");
	//	count_code		=	stoken.countTokens();

		for(int j=fm_value; j<=to_value; j++){
			update_value		=	stoken.nextToken();
			if(tab_value.equals("S"))
				multiRecSet.setBeanValue(j,update_value);  //alteredRecord		=	multiRecSet.setBeanValue(j,update_value);
			else if(tab_value.equals("A"))
				multiRecSet.setDBBeanValue(j,update_value); //alteredRecord		=	multiRecSet.setDBBeanValue(j,update_value);
		}
	}

	putObjectInBean(bean_id,bean,session);
	
	/*
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/

%>
