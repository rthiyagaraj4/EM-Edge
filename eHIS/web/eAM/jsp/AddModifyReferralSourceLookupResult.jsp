<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>

<%! 
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

<head>
<title> <%= request.getParameter("title")%></title>
 <base target="_self">
 <!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript">

	
	function submitFormN()
	{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from + maxval;
		document.forms[0].to.value = to + maxval;
		document.forms[0].submit();
	}
	function submitFormP(frm_to)
	{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from - maxval;
		document.forms[0].to.value = to - maxval;
		document.forms[0].submit();
	}

	function closew(row)
	  {
	  var row_val=row.value;
  		//while(row_val.indexOf("+")!=-1)
			//row_val=row_val.replace('+'," ");
  		//while(row_val.indexOf("`")!=-1)
			//row_val=row_val.replace('`',"'");

		parent.window.returnValue = row_val;
		//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = row_val;
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();   
		//return(Dcode);
	  }

	  function record_found_check()
	  {
		  var record_found_flag=document.forms[0].record_found_flag.value;
		  var total_rec_fetched = document.forms[0].intTotalFetchedRecords.value;
		  
		  if(record_found_flag=="N")
		  {

			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));	
			parent.frames[1].location.href='../../eCommon/html/blank.html';


		  }
		  else
		  {
			  if(total_rec_fetched == 1)
			  {
				 document.getElementById('resulted_row').click();
			  }
		  }
	  }
 

 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onLoad="record_found_check()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name='form_query' id='form_query' method='post' action='AddModifyReferralSourceLookupResult.jsp'>
	<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String locale			= (String)session.getAttribute("LOCALE");		

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
		String select_leg = common_labels.getString("Common.defaultSelect.label");

		String strColumnDelimiter = ",";
		String userWhereClause = "";		
		String strWhereColumn = "";		
		String sql_pass_back = "";
		String sql_order_by = "";
		String show_hide = "";

		String record_found_flag="N";
		String target = request.getParameter("target");
		if(target == null) target="";

		String col_show_hide = request.getParameter("col_show_hide");
		if(col_show_hide == null) col_show_hide="";

		ArrayList col_show_hide_lst = new ArrayList();


		String facilityid = request.getParameter( "facilityid");
		String ref_type = request.getParameter( "ref_type");
		


		try
		{
			for(int i=0;i<col_show_hide.length();i++)
			{
				String temp_str = col_show_hide.substring(i,i+1);
				col_show_hide_lst.add(i,temp_str);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		int max_records = 13;		
		int intTotalColumns = 0;				
		
		int i = 0;
		//Vector vectorColumnNames = new Vector();
		ArrayList arrListColumnNames = new ArrayList();
//		Vector vectorColumnSizes = new Vector();
		ArrayList arrListColumnSizes = new ArrayList();
//		Vector vectorColumnDescriptions = new Vector();
		ArrayList arrListColumnDescriptions = new ArrayList();
//		Vector vectorColumnTypes = new Vector();
		ArrayList arrListColumnTypes = new ArrayList();
//		Vector vectorHtmlData = new Vector();
		ArrayList arrListHtmlData  = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;int intTotalFetchedRecords=0;
		try
		{
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 13:Integer.parseInt(request.getParameter("max_records"));

			String sql = request.getParameter("sql");



			//sql = (sql == null) ? "":sql;
			//sql=sql.replaceAll("@&","%");

			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
//Added on 6/25/2008*****
			String strTotalFetchedRecords = request.getParameter("intTotalFetchedRecords");

			if(strTotalFetchedRecords == null) strTotalFetchedRecords="0";
			intTotalFetchedRecords = Integer.parseInt(strTotalFetchedRecords);
//Added on 6/25/2008*****
	
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
			search_criteria = (search_criteria == null || search_criteria.equals("")) ? "":search_criteria;
			String search_by_index = request.getParameter("search_by_index");
			search_by_index = (search_by_index == null || search_by_index.equals("")) ? "0":search_by_index;
			int int_search_by_index = Integer.parseInt(search_by_index);
			String search_text = request.getParameter("search_text");
			search_text = (search_text == null || search_text.equals("") ) ? "%":search_text;
			String search_by = 	request.getParameter("search_by");
			search_by = (search_by == null || search_by.equals("")) ? "":search_by;
			String column_names = request.getParameter("column_names");
			column_names = (column_names == null || column_names.equals("")) ? "":column_names;
			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null || column_sizes.equals("")) ? "":column_sizes;
			String column_types = request.getParameter("column_types");
			column_types = (column_types == null || column_types.equals("")) ? "":column_types;
			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null || column_descriptions.equals("")) ? "":column_descriptions;
			
			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			i =0;

			while(strTokenizer.hasMoreTokens())
			{
				//vectorColumnNames.insertElementAt( " "+strTokenizer.nextToken(),i);
				arrListColumnNames.add(i," "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;


			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnSizes.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnSizes.add(i,strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnTypes.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnTypes.add(i,strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnDescriptions.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnDescriptions.add(i,strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;
			//SQL = sql.toUpperCase();
		

			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";
			
			//sqlFifteenRecords = " and rownum between "+from+" and  " +to +"";
			if(calling_from_main == true)
			{
				

				if(ref_type.equals("X")){
					if(search_by.equals("0")){
						strWhereColumn="a.REFERRAL_CODE";
					}else if (search_by.equals("1")){
						strWhereColumn="a.short_desc";
					}else if (search_by.equals("2")){
						strWhereColumn="a.LONG_DESC";
					}else if (search_by.equals("3")){
						//strWhereColumn="a.contact_name";
						strWhereColumn="a.long_name";
						
					}
				}else{
					if(search_by.equals("0")){
						strWhereColumn="a.facility_id";
					}else if (search_by.equals("1")){
						strWhereColumn ="a.FACILITY_NAME";
					}
				}



				

				

				if(search_criteria.equals("S") )	{
					
					search_text = search_text + "%";

					//userWhereClause = " and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL ";
					
					//userWhereClause = " and ( upper( "+strWhereColumn + ") like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";

				}else if(search_criteria.equals("E")){
					search_text = "%" + search_text;
			//userWhereClause = "and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";

				}else if(search_criteria.equals("C")){
					search_text = "%" + search_text + "%";
					//userWhereClause = "and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";
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
		%>

		<%
			try
			{
			
				String row = "<tr style='background-color:;' >";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strStartLink = "<a name='resulted_row' href=javascript:closew(";
				String strEndLink = ")>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				String strSpecialData = "";
				//String strNumberFormat = "";

				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strAlign = "align = 'right'";
				String strSpecialAlign = "align = 'right'>";
				
				int intVectorTrace = 0;
				int intTempStart = start;
				//int intTempEnd = end;
				
				pstmt = conn.prepareStatement(sql);



				if(ref_type.equals("L")){
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,search_text);
					
				}else if (ref_type.equals("X")){
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,search_text);
					
				}else if (ref_type.equals("E")){
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,search_text);
					
				}
				
				
				rs = pstmt.executeQuery();
				
				arrListHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");

				for (int l = 0;l<intTotalColumns ; l++ )
				{
					strTempColumnType = (String) arrListColumnTypes.get(l);
/* Newly added by Manivel N for hidding the columns which are not necessary for display */		
					String temp_var1 =(String) col_show_hide_lst.get(l);

					if(temp_var1.equals("Y"))
					{
						show_hide = "display";
					}
					else
					{
						show_hide = "display:none";
					}
/* ****************** */
					if (strTempColumnType.equalsIgnoreCase("VARCHAR2") || strTempColumnType.equalsIgnoreCase("DATE"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}

					if (l == int_search_by_index)
					{
						//strSpecialData = "<th width='"+(String)vectorColumnSizes.get(l)+"'  "+strAlign +" 				>"+(String)vectorColumnDescriptions.get(l)+"</th>";
						strSpecialData = "<th style='"+show_hide+"' width='"+(String)arrListColumnSizes.get(l)+"'  "+strAlign +" >"+(String)arrListColumnDescriptions.get(l)+"</th>";	

						 //strTokenizer.nextToken(),i);

					}
					else
					{
//						vectorHtmlData.add("<th width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)vectorColumnDescriptions.get(l)+"</th>");

						arrListHtmlData.add("<th style='"+show_hide+"' width='"+(String)arrListColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)arrListColumnDescriptions.get(l)+"</th>");
					}
				}	
//				vectorHtmlData.insertElementAt(strSpecialData,1);
				arrListHtmlData.add(1,strSpecialData);
				
				
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
//Added on 6/25/2008 ****
					++intTotalFetchedRecords;
//Added on 6/25/2008 ****
//					vectorHtmlData.add(row);					
					arrListHtmlData.add(row);
//					intVectorTrace = vectorHtmlData.size();
					intVectorTrace = arrListHtmlData.size();	

					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
//						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnType = (String) arrListColumnTypes.get(intTrace-1);
						
						//strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName=(String)arrListColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						//if (strTempColumnName.indexOf("_$$")>0)
						//{
							//strIDCurrency = "  id='currency_id'  ";
						//}
						//else
						//{
							//strIDCurrency = "";
						//}
						if (strTempColumnType.equalsIgnoreCase("VARCHAR2") || strTempColumnType.equalsIgnoreCase("DATE"))
						{
							strAlign = "align='left'>";
						}
						else
						{
							strAlign = "align='right'>";
						}
						
						strData = rs.getString(intTrace);
						
						if(strData != null)
						{
							strData = rs.getString(intTrace);
							if(strData.equals("")){
								strLinkData = strLinkData + "^~^" ; 
							}else{
								strLinkData = strLinkData + strData+ "^~^" ; 
							}
							
						}
						else
						{
							strLinkData = strLinkData + ""+ "^~^" ;
						}
						if(strData == null) strData="&nbsp;";

						String temp_var1 =(String) col_show_hide_lst.get(intTrace-1);

						if(temp_var1.equals("Y"))
						{
							show_hide = "display";
						}
						else
						{
							show_hide = "display:none";
						}
/* ************ */
						if (intFetchedRecords%2 == 0)
						{
							if(strData.equals("")){
								strHtmlData =  evn +" style='"+show_hide+"' "+ strAlign + "&nbsp;</td>";
							}else{
								strHtmlData =  evn +" style='"+show_hide+"' "+ strAlign + strData+"</td>";
							}

							
						}
						else
						{

							if(strData.equals("")){
								strHtmlData = odd +" style='"+show_hide+"' "+ strAlign + "&nbsp;</td>";
							}else{
								strHtmlData = odd +" style='"+show_hide+"' "+ strAlign + strData+"</td>";
							}
							
						}

						if (intTrace == (int_search_by_index+1))
						{
							strSpecialData = strData;
							strSpecialAlign = strAlign;
							//strSpecialIDCurrency = strIDCurrency;
						}
						else
						{
//							vectorHtmlData.add(strHtmlData);
							arrListHtmlData.add(strHtmlData);
						}
					}
					
					if (intFetchedRecords%2 == 0)
					{
						if(strSpecialData.equals("&nbsp;")){
							strSpecialData = "-"+select_leg+"-";
							//strSpecialData = "";
						}
						strHtmlData = evn + strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+
						strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					else
					{
						if(strSpecialData.equals("&nbsp;")){
							strSpecialData = "-"+select_leg+"-";
							//strSpecialData = "&nbsp;";
						}
						strHtmlData = odd+strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					strLinkData = "";
//					vectorHtmlData.insertElementAt(strHtmlData,intVectorTrace);
					arrListHtmlData.add(intVectorTrace,strHtmlData);
					
//					vectorHtmlData.add("</tr>");
					arrListHtmlData.add("</tr>");
					if (intFetchedRecords > max_records)
					{
						break;
					}
					
					record_found_flag="Y";	
				}
			
				
//				vectorHtmlData.add("</table>");
				arrListHtmlData.add("</table>");
				if (rs != null) rs.close();
				pstmt.close();
				// commented in Bangalore on 13/10/2005
				//ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
				//out.println("Error2="+expSQL);
				//debug(" sql Err = "+expSQL);
				expSQL.printStackTrace();
			}
			finally{ // Added in Bangalore on 13/10/2005

				if(pstmt != null) 	pstmt.close(); 	
				if(conn!=null) {
					ConnectionManager.returnConnection(conn, request);
				}
			}

			//debug("Final sql  = "+sql);
		%>
		<table align='center' width='100%'>
		<tr>
		<td align='right'>
		<%
		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);
		if (intFetchedRecords>max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
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
			//vectorHtmlData
			for (int l=0;l<arrListHtmlData.size() ;++l)
			{
				out.println((String)arrListHtmlData.get(l));
			}
			try
			{
				//conn.close(); //Commented for checkstyle
				if(conn!=null) ConnectionManager.returnConnection(conn, request); //Added for checkstyle for COMMON-ICN-0056
			}
			catch(Exception er)
			{
				er.printStackTrace();
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
		<input type='hidden' name='record_found_flag' id='record_found_flag' value="<%=record_found_flag%>">
		<input type='hidden' name='intFetchedRecords' id='intFetchedRecords' value="<%=intFetchedRecords%>">
		<input type='hidden' name='col_show_hide' id='col_show_hide' value="<%=col_show_hide%>">
		<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
		<input type='hidden' name='ref_type' id='ref_type' value="<%=ref_type%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">

<!-- //Added on 6/25/2008 ****-->
		<input type='hidden' name='intTotalFetchedRecords' id='intTotalFetchedRecords' value="<%=intTotalFetchedRecords%>">		
<!-- //Added on 6/25/2008 ****-->
		<%
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{		
			if(pstmt != null) 	
				{
					pstmt.close(); 	
				}
			if(conn!=null)
				{
					ConnectionManager.returnConnection(conn, request);
				}
		}


%>



</form>

</body>
</html>
	


