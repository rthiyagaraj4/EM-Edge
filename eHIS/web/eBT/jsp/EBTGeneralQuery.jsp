<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>


<html>
<head>
<%	request.setCharacterEncoding("UTF-8");	%>
<title> <%= request.getParameter("title")%></title>
 <base target="_self">
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String locale = ((String)session.getAttribute("LOCALE"));%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eBL/js/BLAmount.js"></Script>
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

 </script>


</head>
<body>

<form name='form_query' id='form_query' method='post' action='EBTGeneralQuery.jsp'>
	<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String strColumnDelimiter = ",";
		int max_records = 15;		
		int intTotalColumns = 0;


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
			String column_names = request.getParameter("column_names");
			column_names = (column_names == null) ? "":column_names;
			String column_types = request.getParameter("column_types");
			column_types = (column_types == null) ? "":column_types;
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

			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null) ? "":column_descriptions;

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;
			

			StringTokenizer strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnSizes.add( i,strTokenizer.nextToken());
				++i;
			}
			

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnDescriptions.add( i,strTokenizer.nextToken());
				++i;
			}
		
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

			if (calling_from_main == true)
			{
				try
					{
						PreparedStatement prepareStatement = conn.prepareStatement(sql);
						prepareStatement.execute();
						ResultSetMetaData rmeta = prepareStatement.getMetaData();
						int intCount = rmeta.getColumnCount() ;
						intTotalColumns = intCount;
						String strTempColumnTypeName = "";
						i = 1;
						column_names = "";
						column_types = "";
						for (i=1;i<=intCount ;i++ )
						{
							column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
							vectorColumnNames.add(""+rmeta.getColumnName(i));
							strTempColumnTypeName = rmeta.getColumnTypeName(i);
							if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
							{
								strTempColumnTypeName = "VARCHAR2";
							}
							column_types = column_types + rmeta.getColumnTypeName(i) + strColumnDelimiter;
							vectorColumnTypes.add(""+rmeta.getColumnTypeName(i));
						}
							prepareStatement.close();
					}
					catch(Exception ex)
					{
							ConnectionManager.returnConnection(conn, request);
					}			
				}
				else
				{
						i =0;
						strTokenizer = null;
						strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
						while(strTokenizer.hasMoreTokens())
						{
							vectorColumnNames.add( i," "+strTokenizer.nextToken());
							++i;
						}
						intTotalColumns = i;
						strTokenizer = null;
						strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
						i = 0;
						while(strTokenizer.hasMoreTokens())
						{
							vectorColumnTypes.add(i, strTokenizer.nextToken());
							++i;
						}
						strTokenizer = null;
				}
			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strHtmlData = "";
				String strData = "";

				String strIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";

				String strTempColumnName = "";
				String strTempColumnType = "";
				int intTempStart = start;



				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");

				

				for (int l = 0;l<intTotalColumns ; l++ )
				{

					strTempColumnType = (String) vectorColumnTypes.get(l);
					//debug("strTempColumnType="+strTempColumnType);
					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";
					}

					vectorHtmlData.add("<th width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)vectorColumnDescriptions.get(l)+"</th>");
				}	
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = rs.getString(intTrace);


						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						//debug("strTempColumnName="+strTempColumnName);
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

						vectorHtmlData.add(strHtmlData);
					}
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
				ConnectionManager.returnConnection(conn, request);
				//debug(" sql Err = "+expSQL);
			}

			//debug("Final sql  = "+sql);
		%>
		<table align='center' width='100%'>
		<tr> 
		<td colspan='2' align='right'>
		<input type='button' name='close_butt' id='close_butt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'' class='fields' onClick='parent.window.close()'>
		</td>
		</tr>
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
			//debug("vectorHtmlData.size()="+vectorHtmlData.size() );

			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
			}
	%>


	
	
		
		<input type='hidden' name='from' id='from' value="<%=start%>">
		<input type='hidden' name='to' id='to' value="<%=end%>">
		<input type='hidden' name='column_names' id='column_names' value="<%=column_names%>">
		<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
		<input type='hidden' name='column_types' id='column_types' value="<%=column_types%>">
		<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
		<input type='hidden' name='sql' id='sql' value="<%=sql%>">
		<input type='hidden' name='max_records' id='max_records' value="<%=max_records%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<%
		}
		catch(Exception exp)
		{
		}

	
%>
		<script Language='JavaScript'> funCurrencyFormat(); </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</form>
</body>
</html>
	


