<!DOCTYPE html>
<%@page  import ="eOT.*, eOT.Common.*,eCommon.Common.*,java.util.ArrayList,java.util.Hashtable"  contentType="text/html;charset=UTF-8" %>
<%@page  import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList,java.util.StringTokenizer,java.net.URLEncoder" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
//	String func_mode	= request.getParameter("func_mode");
	
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		String strColumnDelimiter = ",";
		String userWhereClause = "";
		String SQL = "";
		String sqlWithColumnsOnly = "";
		String strWhereColumn = "";
		String strWhereColumnType = "";
		String sql_pass_back = "";
		String sql_order_by = "";
		String sql_proc=request.getParameter("sql");
		String search_criteria_dir=request.getParameter("search_criteria");
		String strData = "";
		String strLinkData = "";
		String strTempColumnType = "VARCHAR2";
		String strTempColumnName = "";
		StringBuffer loc_type_buff = new StringBuffer();
		int max_records = 14;
		int intTotalColumns = 0;
		int intGroupIndex = 0;
		int intGroupByIndex = 0;

		int j = 0;
		int i = 0;
		ArrayList ArrayListColumnNames = new ArrayList();
		ArrayList ArrayListColumnSizes = new ArrayList();
		ArrayList ArrayListColumnDescriptions = new ArrayList();
		ArrayList ArrayListColumnTypes = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 14:Integer.parseInt(request.getParameter("max_records"));
			String sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

			boolean calling_from_main =  true;
			if ( (from == null) && ( to == null) )
			{
				calling_from_main = true;
			}
			else
			{
				calling_from_main = false;
			}
			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;
			String search_criteria = request.getParameter("search_criteria");
			search_criteria = (search_criteria == null) ? "":search_criteria;
			String search_by_index = request.getParameter("search_by_index");
			search_by_index = (search_by_index == null) ? "0":search_by_index;
			int int_search_by_index = Integer.parseInt(	search_by_index);
			String search_text = request.getParameter("search_text");
			search_text = (search_text == null) ? "%":search_text;
			String search_by = 	request.getParameter("search_by");
			search_by = (search_by == null) ? "":search_by;
			String column_names = request.getParameter("column_names");
			column_names = (column_names == null) ? "":column_names;
			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;
			String column_types = request.getParameter("column_types");
			column_types = (column_types == null) ? "":column_types;
			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null) ? "":column_descriptions;
			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			i =0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnNames.add( " "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;
			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnSizes.add( strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnTypes.add( strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnDescriptions.add( strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;
			SQL = sql.toUpperCase();
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";
			if(calling_from_main == true)
			{
				sql = sql.replace('`','\'') ;
				intGroupIndex = SQL.lastIndexOf(" GROUP");
				if (intGroupIndex > 0)
				{
					intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
				}
				j = SQL.indexOf(" WHERE");
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					//sqlWhere = " ( " + sqlWhere +" ) and ";
					sqlWhere = sqlWhere +" and ";
					sql = sqlTemp + sqlWhere;
				}
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.indexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)ArrayListColumnNames.get(int_search_by_index);
					String strTempPreviousColumn = (String)ArrayListColumnNames.get(int_search_by_index-1);
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);
					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
				}
				else
				{
					String strTempColumn = (String) ArrayListColumnNames.get(int_search_by_index);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
				}
				strWhereColumn = strWhereColumn.trim();
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.indexOf(strTempSpace);
				if ((i>0) && (int_search_by_index == 0)){
					j = 0;
					j = strWhereColumn.indexOf(strTempQuote);
					if (j<0){
						j = strWhereColumn.indexOf(strTempComma);
						if (j<0){
							strWhereColumn = strWhereColumn.substring(i,intTempWhereColumnLen);
						}
					}
				}
				strWhereColumnType = (String) ArrayListColumnTypes.get(int_search_by_index);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2")){
					if(search_criteria.equals("S")){
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) ";
					}else if(search_criteria.equals("E")){
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}else if(search_criteria.equals("C")){
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
				}else{
					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				sql = sql + userWhereClause;
				sql = sql + " )";
				sql_pass_back = sql;
				sql_order_by = " order by "+(int_search_by_index+1);
				for (int l = 1;l<=intTotalColumns ; l++ ){
					if (l != (int_search_by_index+1)){
						sql_order_by = sql_order_by +"," +l;
					}
				}
			}else{
				sql_pass_back = request.getParameter("sql_pass_back");
				sql_order_by = request.getParameter("sql_order_by");
				sql = sql_pass_back;
			}
			sql = sql+ " "+sql_order_by;
			int intTempStart = start;
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search_text);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if (!(intTempStart<=0)){
					--intTempStart;
					continue;
				}
				++intFetchedRecords;
				for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace){
					strData = checkForNull(rs.getString(intTrace));
					strLinkData = strLinkData +strData+ "::";

					strTempColumnType = (String) ArrayListColumnTypes.get(intTrace-1);
					strTempColumnName = (String) ArrayListColumnNames.get(intTrace-1);
					strTempColumnName = strTempColumnName.trim();
				}
				if (intFetchedRecords >= max_records){
					break;
				}
			}
			if(intFetchedRecords==1){
				strLinkData=strLinkData+intFetchedRecords;
				out.println(strLinkData);	
			}

	}catch (Exception e) {
		System.err.println("Execpetion in OTGeneralSearchRecordResults.jsp: "+e);
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}finally{
		rs.close();
		pstmt.close();
        ConnectionManager.returnConnection(conn,request);
	}
%>
