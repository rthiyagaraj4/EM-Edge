<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>



<%	request.setCharacterEncoding("UTF-8");	%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%! 
 String encode(String data,String loc)
 {
	  
	  String outDat = replace(data,loc); 
	  byte byteData[] = outDat.getBytes();
		
   	if(loc.equals("en")==true)
	 {
		outDat = "";
	   for (int i=0; i<byteData.length; i++)
	  {
	
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
	 }

		return(outDat);
 }

%>

<%!
	String replace(String data,String loc)
	{
		char strRep = '`';
		String strSpecial = "";

		// 48569 Sandeep K Gujje 14-APR-2014 // Commented and added strSpecial without any space
		strSpecial = "\f\n\r\t\'\"\\";
		/*
		   	if(loc.equals("en")==true)
					strSpecial = "\f\n\r\t\'\"\\";
			else 	
				strSpecial = " \f\n\r\t\'\"\\";
		*/

		char charArray[] = strSpecial.toCharArray();
		String strOutData = data;
		for (int i =0;i<charArray.length;i++)
		{
			strOutData = strOutData.replace(charArray[i],strRep);
		}

		// 48569 Sandeep K Gujje 14-APR-2014
		strOutData = strOutData.replace(' ', '~');

		return(strOutData);
	}

%>

<html>
<head>
<title> <%= request.getParameter("title")%></title>
 <base target="_self">
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% String locale = ((String)session.getAttribute("LOCALE"));%>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eBL/js/BLAmount.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script Language="JavaScript">
	function funCurrencyFormat()
	{
		try
		{
			var ids = document.getElementById('currency_id');
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

	// 48569 Sandeep K Gujje 14-APR-2014
	function ReplaceAll(Source,stringToFind,stringToReplace)
	{
		var temp = Source;
		var index = temp.indexOf(stringToFind);
		while(index != -1)
		{
			temp = temp.replace(stringToFind,stringToReplace);
			index = temp.indexOf(stringToFind);
		}
		return temp;
	}


	function closew(Dcode)
	  {
  		while(Dcode.indexOf("+")!=-1)
			Dcode=Dcode.replace('+'," ");
	
		// 48569 Sandeep K Gujje 14-APR-2014
		Dcode=ReplaceAll(Dcode,'~',' '); 

		parent.window.returnValue = Dcode;
		parent.window.close();	
		//return(Dcode);
	  }
 </script>


</head>
<body>


<form name='form_query' id='form_query' method='post' action='EBTLookupBody.jsp'>
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
		//String sqlGroupBy = "";
		String sql_pass_back = "";
		String sql_order_by = "";

		int max_records = 15;		
		int intTotalColumns = 0;
		//int intGroupIndex = 0;
		//int intGroupByIndex = 0;

		int j = 0;
		int i = 0;
		ArrayList vectorColumnNames = new ArrayList();
		ArrayList vectorColumnSizes = new ArrayList();
		ArrayList vectorColumnDescriptions = new ArrayList();
		ArrayList vectorColumnTypes = new ArrayList();
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{

			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 15:Integer.parseInt(request.getParameter("max_records"));

			String sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;

			//eBT.LogFile.log("BTDebugger","sql value"+sql,this);

			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;


//			eQA.LogFile.log("dhana",sql,this);		

	
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

			try{
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnNames.add(i, " "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;
			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnSizes.add(i, strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnTypes.add(i, strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnDescriptions.add(i, strTokenizer.nextToken());
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

				//intGroupIndex = SQL.lastIndexOf(" GROUP");
				
				//sqlGroupBy = " ";
				/*
				if (intGroupIndex > 0)
				{
					//intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
					//debug("intGroupByIndex="+intGroupByIndex);
					//if (intGroupByIndex >0)
					//{
						//sqlGroupBy = sql.substring(intGroupIndex);
						//sql = sql.substring(0,intGroupIndex);
						
					//}
				}
				*/
				//debug("sqlGroupBy="+sqlGroupBy);
				//debug("sql="+sql);
				j = SQL.indexOf(" WHERE");
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
				j = SQL.indexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				//sqlActualWithColumnsOnly = sql.substring(i+7,j);
				
			
		
				//debug("sqlWithColumnsOnly="+sqlWithColumnsOnly);
				//debug("int_search_by_index ="+int_search_by_index );
	

				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)vectorColumnNames.get(int_search_by_index);
					//debug("strTempSelectedColumn="+strTempSelectedColumn);
					String strTempPreviousColumn = (String)vectorColumnNames.get(int_search_by_index-1);
					//debug("strTempPreviousColumn ="+strTempPreviousColumn );
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);

					//debug("intTempSelectedIndex = "+intTempSelectedIndex);

					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					//debug("intTempPreviousIndex = "+intTempPreviousIndex);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					//debug("intCommaIndex = "+intCommaIndex);

					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				else
				{
					String strTempColumn = (String) vectorColumnNames.get(int_search_by_index);
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
				i = strWhereColumn.indexOf(strTempSpace);
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

				strWhereColumnType = (String) vectorColumnTypes.get(int_search_by_index);
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
				}
				else
				{
					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				sql = sql + userWhereClause;
				sql = sql + " )";
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
		//eBT.LogFile.log("BTDebugger","SQL debug1"+sql,this);
		}catch(Exception ee)
		{
			sql = request.getParameter("sql");	
			search_text="";
			//eBT.LogFile.log("BTDebugger","Exception "+ee,this);

		}




		%>
		<%
			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strStartLink = "<a href=javascript:closew('";
				String strEndLink = "')>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				String strSpecialData = "";


				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strIDCurrency = " id='currency_id' ";
				String strSpecialIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";
				String strSpecialAlign = "align = 'right'>";
				
				int intArrayListTrace = 0;
				int intTempStart = start;
				

				//eBT.LogFile.log("BTDebugger","SQL debug"+sql,this);

				pstmt = conn.prepareStatement(sql);
			if(search_text.length()!=0)
				pstmt.setString(1,search_text);
				rs = pstmt.executeQuery();
				
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");

				

				for (int l = 0;l<intTotalColumns ; l++ )
				{

					strTempColumnType = (String) vectorColumnTypes.get(l);

					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}

					if (l == int_search_by_index)
					{
						strSpecialData = "<td class='COLUMNHEADER' width='"+(String)vectorColumnSizes.get(l)+"'  "+strAlign +" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+(String)(String)vectorColumnDescriptions.get(l),"bt_labels")+"</td>";

					}
					else
					{
						vectorHtmlData.add("<td class='COLUMNHEADER' width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+(String)(String)vectorColumnDescriptions.get(l),"bt_labels")+"</td>");
					}

				}	
				vectorHtmlData.add(1,strSpecialData);
			
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					intArrayListTrace = vectorHtmlData.size();
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = rs.getString(intTrace);

						strLinkData = strLinkData + strData+ "::" ;

						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
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
							strHtmlData =  evn + strIDCurrency + strAlign + strData+"</td>";
						}
						else
						{
							strHtmlData = odd + strIDCurrency + strAlign + strData+"</td>";
						}

						if (intTrace == (int_search_by_index+1))
						{
							strSpecialData = strData;
							strSpecialAlign = strAlign;
							strSpecialIDCurrency = strIDCurrency;
						}
						else
						{
							vectorHtmlData.add(strHtmlData);
						}

					}
					//if(locale.equals("en")==true)
						   strLinkData=encode(strLinkData,locale);

					if (intFetchedRecords%2 == 0)
					{
							
						strHtmlData = evn + strSpecialIDCurrency + 
						strSpecialAlign+strStartLink+strLinkData+
						strEndLink+strSpecialData+"</a></td>";
					}
					else
					{
						strHtmlData = odd+strSpecialIDCurrency+strSpecialAlign+strStartLink+strLinkData+strEndLink+strSpecialData+"</a></td>";
					}
					strLinkData = "";
					vectorHtmlData.add(intArrayListTrace,strHtmlData);
					vectorHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				}
				vectorHtmlData.add("</table>");
				rs.close();
				pstmt.close();
				ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
				out.println("Error="+expSQL);
				//debug(" sql Err = "+expSQL);
			}

			//debug("Final sql  = "+sql);
		%>
		<table align='center' width='100%'>
		<tr>
		<td align='right'>
		<%
		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);
		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
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
			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
			}
	//  DhanasekarV Modified for  IN024221  05/10/2010  - ?Query caused no data to be retrieved?. Not like other practitioner search screen
			if (intFetchedRecords == 0)
			{
			out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

");
			}
    //  End  IN024221
			try
			{
				conn.close();
			}
			catch(Exception er)
			{
			}
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
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<%
		}
		catch(Exception exp)
		{
			//debug("Error = "+exp);
		}

		finally
		{
			ConnectionManager.returnConnection(conn,request);
		}
%>

</form>
</body>
</html>
	


