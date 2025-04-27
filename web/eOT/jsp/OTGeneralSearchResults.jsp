<!DOCTYPE html>
<%@ page import="eCommon.Common.CommonBean,eOT.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.OTBillingBean,java.util.ArrayList,java.util.StringTokenizer,java.net.URLEncoder,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	
	// this line is commented by marwan, since this wrapper is sanitizing the request parameters
	// in column_descriptions request parameter ir removes the script word from description, that's why i commented it
	// request= new XSSRequestWrapper(request);

	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@include file="../../eCommon/jsp/Common.jsp" %>      
<%@ include file="../../eOT/jsp/StringUtil.jsp"%> 
<%@ page import="java.util.*"%>
<%! 

int recSize=0;
int hits=0;
Cookie cookie1 = null;
Cookie cookie2 = null;
 String encode(String data)
 {	  
  String outDat = replace(data); 
	  byte byteData[] = outDat.getBytes();
		outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
 }
%>
<%!
	String replace(String data)
	{
		char strRep = '`';
		String strSpecial = "\f\n\r\t\'\"\\";
		char charArray[] = strSpecial.toCharArray();
		String strOutData = data;
		for (int i =0;i<charArray.length;i++)
		{
			strOutData = strOutData.replace(charArray[i],strRep);
		}
		return(strOutData);
	}

%>
<html>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<title> <%= request.getParameter("title")%></title>
 <base target="_self">

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script Language="JavaScript">
	function funCurrencyFormat()
	{
		try
		{
			var ids = document.getElementById("currency_id");
			if (ids.length ==	null)
			{
				currencyTableFormat(ids);
			}
			else
			{

				for(i=0;i<ids.length;i++)
				{
					currencyTableFormat(ids[i]);
				}
			}
		}
		catch(e)
		{
		}
	}
	function submitFormN()
	{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from + maxval;
		document.forms[0].to.value = to + maxval;
		document.forms[0].nextFlag.value = 'N'; //046704
		document.forms[0].submit();
	}
	function submitFormP()
	{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from - maxval;
		document.forms[0].to.value = to - maxval;
		document.forms[0].submit();
	}

		function closew(index)
		{
			var Dcode=eval("document.forms[0].hyper"+index+".value");
			//parent.window.returnValue = Dcode;
			//parent.window.close();	
			/*let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = Dcode;
    
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			dialogTag.close(); */
			const diagElement = parent.parent.document.getElementsByTagName("dialog");
			var i = 0; var j = 0;
			for (i = 0; i < diagElement.length; i++) {
				for (j = 0; j < diagElement[i].children.length; j++) {
					var element = diagElement[i].children[j];
					let dialogSrc = element.src;
					if (typeof dialogSrc !== "undefined")
					{ 
						if (dialogSrc.includes("OTGeneralSearchFrames.jsp"))
						{	  
							element.contentWindow.returnValue = Dcode;
							const dialogTag = diagElement[i];    
							dialogTag.close();
						}
					}    		
				} 
			}

		}

	   function callNoRecords(){
		var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');
		alert(msg);
	   }
 </script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name='form_query' id='form_query' method='post' action='OTGeneralSearchResults.jsp'>
	<%
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String strColumnDelimiter = ",";
		String userWhereClause = "";
		String SQL = "";
		String sqlWithColumnsOnly = "";
		//String sqlActualWithColumnsOnly = "";
		String strWhereColumn = "";
		String strWhereColumnType = "";
		//String sqlFifteenRecords = "";
		//String sqlGroupBy = "";//commented  v3
		String sql_pass_back = "";
		String sql_order_by = "";
		String sql_proc=request.getParameter("sql");
//		String search_criteria_dir=request.getParameter("search_criteria");
		
		
		int ctr=0;
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
		ArrayList ArrayListHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		String sql = "";
		//Added Against ML-MMOH-CRF-1939-US2...starts
		String facility_id		= (String)session.getValue("facility_id") ;
		String title2 = CommonBean.checkForNull(request.getParameter("title2"));
		String Fpp_yn = CommonBean.checkForNull(request.getParameter("Fpp_yn"));
		String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
		String tab_name = CommonBean.checkForNull(request.getParameter("tab_name"));
		String FPPPatient_yn = "";
		String Include_Fpp_yn = "";
		boolean isIncludeFpp = false;
		boolean bill_flag = false;
		Integer count =0;
		ArrayList fppList = new ArrayList();
		String fpp_order_yn = "N";
		String fpp_category = "";
		String oper_code = "";
		String bean_id = "OTCommonBean";
		String bean_name = "eOT.OTCommonBean";
		OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
		
		String ot_bean_id = "OTBillingBean";
		String ot_bean_name= "eOT.OTBillingBean";
		OTBillingBean billing_bean = (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;
		//Added Against ML-MMOH-CRF-1939-US2...ends
		try
		{	
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 14:Integer.parseInt(request.getParameter("max_records"));
			
			//Added Against ML-MMOH-CRF-1939-US2...starts
			
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
			isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
			System.err.println("isIncludeFpp --->"+isIncludeFpp);
			
			count = bean.getFppIcon();
			bill_flag = bean.getBillFlag(facility_id);

			//Added Against ML-MMOH-CRF-1939-US2...ends
			
			sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String nextFlag = request.getParameter("nextFlag") == null ? "" : request.getParameter("nextFlag");//046704
	
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
			String addOprn = request.getParameter("addOprn");

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
			
			//sqlFifteenRecords = " and rownum between "+from+" and  " +to +"";

			if(calling_from_main == true)
			{
				sql = sql.replace('`','\'') ;

				intGroupIndex = SQL.lastIndexOf(" GROUP");
				
				//sqlGroupBy = " ";
				if (intGroupIndex > 0)
				{
					intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
					//debug("intGroupByIndex="+intGroupByIndex);
					if (intGroupByIndex >0)
					{
						//sqlGroupBy = sql.substring(intGroupIndex);
						//sql = sql.substring(0,intGroupIndex);
						
					}
				}
				//debug("sqlGroupBy="+sqlGroupBy);
				//debug("sql="+sql);
				j = SQL.lastIndexOf(" WHERE");
				//debug("SQL="+SQL);
		
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{		
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					sqlWhere = " ( " + sqlWhere +" ) and ";
					sql = sqlTemp + sqlWhere;
				}
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.lastIndexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				//sqlActualWithColumnsOnly = sql.substring(i+7,j);
				//debug("sqlWithColumnsOnly="+sqlWithColumnsOnly);
				//debug("int_search_by_index ="+int_search_by_index );
				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)ArrayListColumnNames.get(int_search_by_index);
					//debug("strTempSelectedColumn="+strTempSelectedColumn);
					String strTempPreviousColumn = (String)ArrayListColumnNames.get(int_search_by_index-1);
					//debug("strTempPreviousColumn ="+strTempPreviousColumn );
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);

					//debug("intTempSelectedIndex = "+intTempSelectedIndex);

					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					//debug("intTempPreviousIndex = "+intTempPreviousIndex);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					//debug("intCommaIndex = "+intCommaIndex);

					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
					//debug("strWhereColumn = "+strWhereColumn);
					
					//hard coded for speciality
					if(addOprn != null && addOprn.equals("Y"))
					{
						strWhereColumn = "SPECIALITY_CODE";
					}
				}
				else
				{
					String strTempColumn = (String) ArrayListColumnNames.get(int_search_by_index);
					//debug("strTempColumn = "+strTempColumn);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					//debug("intTempIndex = "+intTempIndex);
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				strWhereColumn = strWhereColumn.trim();
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.lastIndexOf(strTempSpace);
				if ((i>0) && (int_search_by_index == 0))
				{
					j = 0;
					j = strWhereColumn.indexOf(strTempQuote);
					if (j<0)
					{
						j = strWhereColumn.indexOf(strTempComma);
						if (j<0)
						{
							strWhereColumn = strWhereColumn.substring(i,intTempWhereColumnLen);
						}
							
					}
					

				}
				strWhereColumnType = (String) ArrayListColumnTypes.get(int_search_by_index);
				//debug("strWhereColumnType = "+strWhereColumnType);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2"))
				{
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) ";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
				}else{

					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				
				userWhereClause = userWhereClause + " ) ";
				//Added for CRF 012 
				if(addOprn != null && addOprn.equals("Y"))
				{
					String description = "";
					if(search_criteria.equals("S"))
					{
						description = request.getParameter("description") + "%";
					}
					else if(search_criteria.equals("E"))
					{
						description = "%" + request.getParameter("description");
					}
					else if(search_criteria.equals("C"))
					{
						description = "%" + request.getParameter("description") + "%";
					}
					
					userWhereClause += " AND ( upper(OPER.SHORT_DESC) like upper('" +  description + "') )";//Modified Against ML-MMOH-CRF-1939-US2
				}
				//Added for CRF 012 
				sql = sql + userWhereClause;
				sql_pass_back = sql;
				sql_order_by = " order by "+(int_search_by_index+1);
				for (int l = 1;l<=intTotalColumns ; l++ )
				{
					if (l != (int_search_by_index+1))
					{
						sql_order_by = sql_order_by +"," +l;
					}
				}
			
			}
			else
			{
				sql_pass_back = request.getParameter("sql_pass_back");
				sql_order_by = request.getParameter("sql_order_by");
				sql = sql_pass_back;
			}
			sql = sql+ " "+sql_order_by;

			//sqlFifteenRecords;
		%>
		<%
			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td nowrap class='gridData'";
				String odd = "<td nowrap class='gridData'";
				String strStartLink = "<a href=javascript:closew('";
				String strEndLink = "')>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				//String strSpecialData = "";
				//String strNumberFormat = "";

				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strIDCurrency = " id='currency_id' ";
				//String strSpecialIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";
				//String strSpecialAlign = "align = 'right'>";
				
				//int intArrayListTrace = 0;
				int intTempStart = start;
				//int intTempEnd = end;
				pstmt = conn.prepareStatement(sql);
				
				//Added Against ML-MMOH-CRF-1939-US2...starts
				if(isIncludeFpp && bill_flag && count==1 && Include_Fpp_yn.equals("Y") && title2.equals("Operation") && !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon")) ){

				pstmt.setString( 1 , Fpp_yn );
				pstmt.setString(2,search_text);
				}else{
				//Added Against ML-MMOH-CRF-1939-US2...ends
				
				pstmt.setString(1,search_text);	
				
				}//Added Against ML-MMOH-CRF-1939-US2...
				rs = pstmt.executeQuery();
				
				ArrayListHtmlData.add("<table class='grid' border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");

				//strNumberFormat = "";
				for (int l = 0;l<intTotalColumns ; l++ )
				{
					strTempColumnType = (String) ArrayListColumnTypes.get(l);

					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}
						ArrayListHtmlData.add("<th nowrap width='"+(String)ArrayListColumnSizes.get(l)+"'  "+ strAlign +"  >"+(String)ArrayListColumnDescriptions.get(l)+"</th>");
				}	
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					ArrayListHtmlData.add(row);					
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = checkForNull(rs.getString(intTrace));
						strLinkData = strLinkData +strData+ "::" ;
						strTempColumnType = (String) ArrayListColumnTypes.get(intTrace-1);
						strTempColumnName = (String) ArrayListColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						if (strTempColumnName.indexOf("_$$")>0)
						{
							strIDCurrency = "  id='currency_id'  ";
						}
						else
						{
							strIDCurrency = "";
						}
						if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
						{
							strAlign = "align='left'>";
						}
						else
						{
							strAlign = "align='right'>";
						}


						if (intFetchedRecords%2 == 0)
						{	
							strHtmlData =""+ evn + strIDCurrency + strAlign +strStartLink+intFetchedRecords+strEndLink+strData+"</td>";
						}
						else
						{
							strHtmlData =""+odd + strIDCurrency + strAlign +strStartLink+intFetchedRecords+strEndLink+strData+"</td>";
						}						
						
							ArrayListHtmlData.add(strHtmlData);						

					}
					out.println("<input type='hidden' name='hyper"+intFetchedRecords+"' id='hyper"+intFetchedRecords+"' value=\""+strLinkData+"\">");
					strLinkData = "";
					ArrayListHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
				}
				ArrayListHtmlData.add("</table>");
				//046704
//				if(intFetchedRecords==1)
//					out.println("assignCodeDesc(\"" + strLinkData + "\");") ;
			}
			catch(Exception expSQL)
			{
				expSQL.printStackTrace();
				//out.println("Error="+expSQL);
			}

			try{
				
				pstmt = conn.prepareStatement(sql);
				
				//Added Against ML-MMOH-CRF-1939-US2...starts
				if(isIncludeFpp && bill_flag && count==1 && Include_Fpp_yn.equals("Y") && title2.equals("Operation") && !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon"))){
				pstmt.setString( 1 , Fpp_yn );
				pstmt.setString(2,search_text);
				}else{
				//Added Against ML-MMOH-CRF-1939-US2...ends
				
				pstmt.setString(1,search_text);	
				
				}//Added Against ML-MMOH-CRF-1939-US2
				rs = pstmt.executeQuery();
				while(rs.next()){
					ctr=ctr+1;
				}
			}
			catch(Exception expSQL)
			{
				expSQL.printStackTrace();
				//out.println("Error="+expSQL);
			}
			finally{
					ConnectionManager.returnConnection(conn, request);
									pstmt.close();
				}

		%>
		<table align='center' width='100%'>
		<tr>
		<td align='right' nowrap>
		<%
		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		if (intFetchedRecords >= max_records)
		{	
		recSize=intFetchedRecords+recSize;
		String recs = Integer.toString(recSize);
		String hits1 = Integer.toString(hits);
			cookie1 = new Cookie("recSize", recs);
			cookie2 = new Cookie("hits", hits1);
			cookie1.setMaxAge(24 * 60 * 60);
			cookie2.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie1); 
			response.addCookie(cookie2); 
			Cookie[] cookies = request.getCookies();
	 		for(int loopIndex = 0; loopIndex < cookies.length; loopIndex++) { 
				if (cookies[loopIndex].getName().equals("recSize")) {
					if(recs != "" || recs != null)
					recs = (String)cookies[loopIndex].getValue();
					recSize=Integer.parseInt(recs.trim());
					recSize=intFetchedRecords+recSize;
				break;
				}if (cookies[loopIndex].getName().equals("hits")) {
					hits1 = (String)cookies[loopIndex].getValue();
					hits=Integer.parseInt(hits1.trim());
					hits=hits+1;
				}
			}
			if(recSize != ctr  )
			{
				if(recSize%ctr == 0)
					out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
				else if(recSize%ctr != 0)
					out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");				
			}
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		%>
		</td>
		</tr>
		</table>


		<%
			if (intFetchedRecords == 0)
			{
				out.println("<script>callNoRecords()</script>");
			}else{
				for (int l=0;l<ArrayListHtmlData.size() ;++l){
					out.println((String)ArrayListHtmlData.get(l));
				}
			}

 			if(intFetchedRecords == 1 && nextFlag.trim().length() == 0)//046704
				out.println("<script>closew(1)</script>");
	
			try{
				conn.close();
			}
			catch(Exception er){er.printStackTrace();}
	%>

	
	
		
		<input type='hidden' name='from' id='from' value="<%=start%>">
		<input type='hidden' name='to' id='to' value="<%=end%>">
		<input type='hidden' name='search_criteria' id='search_criteria' value="<%=search_criteria%>">
		<input type='hidden' name='search_by_index' id='search_by_index' value="<%=search_by_index%>">
		<input type='hidden' name='search_text' id='search_text' value="<%=search_text%>">
		<input type='hidden' name='search_by' id='search_by' value="<%=search_by%>">
		<input type='hidden' name='column_names' id='column_names' value="<%=column_names%>">
		<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
		<input type='hidden' name='column_types' id='column_types' value="<%=column_types%>">
		<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
		<input type='hidden' name='sql_pass_back' id='sql_pass_back' value="<%=sql_pass_back%>">
		<input type='hidden' name='max_records' id='max_records' value="<%=max_records%>">
		<input type='hidden' name='sql_order_by' id='sql_order_by'  value="<%=sql_order_by%>">
		<input type='hidden' name='nextFlag' id='nextFlag'> <!-- 046704 -->

		<%
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			//System.err.println("OTGeneralSearchresults.jsp : " + exp);
		}
		finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(conn,request);
			}


%>
		<script Language='JavaScript'> funCurrencyFormat(); </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

