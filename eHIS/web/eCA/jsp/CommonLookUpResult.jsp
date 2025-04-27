<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
09/05/2018    IN067580		Sharanraj	09/05/2018		Ramesh      		CA-GHL-CRF-0493/06-Record Clinical Note
09/05/2018    IN067570		Sharanraj	09/05/2018		Ramesh      		CA-GHL-CRF-0493/05-Record Clinical Note		
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.net.*,java.sql.ResultSet,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
<html>
	<head>
		<script src="../../eCA/js/CommonLookUp.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<table cellpadding='0' cellspacing='0' border='1' width='100%'  align=center>
	<%
		String std_comp_id = request.getParameter( "std_comp_id" )==null?"":request.getParameter( "std_comp_id" );
		String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );
		String search_criteria = request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" );
		String radBtnVal = (request.getParameter( "radBtnVal" )==null?"":request.getParameter( "radBtnVal" ));
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");

		String code = "";
		String desc = "";		
		String classvalue = "";
		String code_column = "";
		String desc_column = "";		
		String retVal[] = null;
		int rowCount = 0;
//		out.println(std_comp_id);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			con = ConnectionManager.getConnection(request);
			eCA.StandardCompRepository stdCompRepository = new eCA.StandardCompRepository();
			String sql_query = (String) stdCompRepository.getCAKeyValue(std_comp_id.trim());
			System.out.println("sql_query     :    "+sql_query);

			if(sql_query == null)
				sql_query = "";
			if(!sql_query.equals(""))
			{
			sql_query=sql_query.toUpperCase();
			//out.println("1----->"+sql_query);

			String sql_legend = "select code_column, CODE_LEGEND, DESC_LEGEND, desc_column from AM_STANDARD_COMP where STD_COMP_ID = ?";
			pstmt = con.prepareStatement(sql_legend);

			pstmt.setString(1,std_comp_id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
					code_column = rs.getString("code_column");
					desc_column = rs.getString("desc_column");	
			%>
				<tr>
					<th width='50%'>
						<%=rs.getString("CODE_LEGEND")%>
					</th>
					<th width='50%'>
						<%=rs.getString("DESC_LEGEND")%>
					</th>
				</tr>
			<%
			}
			rs.close();
			pstmt.close();
			if(!search_text.equals(""))
			{
				/* used to separte the query */
				String fromClause="";
				String whereClause="";
				String orderByClause="";
				String userWhereClause="";
				

				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						userWhereClause =userWhereClause + " upper(" + code_column + ") like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						userWhereClause =userWhereClause + " upper(" + code_column + ") like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						userWhereClause =userWhereClause + " upper(" + code_column + ") like upper('%" + search_text + "%')";
					}				
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						userWhereClause =userWhereClause + " upper(" + desc_column + ") like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						userWhereClause = userWhereClause + " upper(" + desc_column + ") like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						userWhereClause = userWhereClause + " upper(" + desc_column + ") like upper('%" + search_text + "%')";
					}				
				}

				int i=sql_query.lastIndexOf("WHERE");
				int j=sql_query.lastIndexOf("ORDER BY");
				if (i!=-1)
				{
					fromClause=sql_query.substring(0,i);
					if (j!=-1) 
					{
						whereClause=sql_query.substring(i,j);
						orderByClause=sql_query.substring(j,sql_query.length());
					}
					else
					{
						whereClause=sql_query.substring(i,sql_query.length());
					}
					/*out.println("fromClause :"+fromClause + ":");
					out.println("whereClause :"+whereClause + ":");
					out.println("orderByClause :"+orderByClause + ":");*/
				
					
					sql_query =fromClause+" "+whereClause+" AND "+userWhereClause+" "+orderByClause;
				}
				else if (j!=-1)
				{
						fromClause=sql_query.substring(0,j);
						orderByClause=sql_query.substring(j,sql_query.length());
						sql_query =fromClause+" WHERE "+userWhereClause+" "+orderByClause;
				}
				
			}
			
			//out.println(sql_query);
			//StringBuffer temp = new StringBuffer();

			if((sql_query.indexOf("$$") != -1)&&(sql_query.indexOf("##") != -1))
			{
					retVal = construct(sql_query);
					int setStringCount = 1;
					pstmt = con.prepareStatement(retVal[0]);
					for(int i=1;i<retVal.length;i++)
					{
						String param = retVal[i];
							if(param.equals("PATIENT_ID"))
							pstmt.setString(setStringCount++, patient_id);
						else if(param.equals("ENCOUNTER_ID"))
							pstmt.setString(setStringCount++, encounter_id);
						else if(param.equals("FACILITY_ID"))
							pstmt.setString(setStringCount++, facility_id);	
						else if(param.equals("SPECIALITY_CODE"))
							pstmt.setString(setStringCount++, speciality_code);	
						else if(param.equals("MAST_TYPE_REF"))
							pstmt.setString(setStringCount++, "");	
						else if(param.equals("LANGUAGE_ID"))
							pstmt.setString(setStringCount++,locale);	
					}
			}
			else
				pstmt = con.prepareStatement(sql_query);
			

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				classvalue="gridData";

				code = rs.getString(1);
				desc = rs.getString(2)==null?"":rs.getString(2);			
				//Added By Sridhar Reddy to Fix IN024604 replacing spl chars to avoid script Error
				desc = replaceSpecialChars(desc);

				out.println("<tr>");
				out.println("<td width='50%' class='"+classvalue+"'>");
				/*IN067570 starts*/
				if(std_comp_id.equals("ADM_NURSE_ID"))
					out.println("<a class= 'gridLink' href='#' onclick='retValue(\""+desc+"\",\""+code+"\")'> "+code+" </a> </td>");
				else
					out.println("<a class= 'gridLink' href='#' onclick='retValue(\""+code+"\",\""+desc+"\")'> "+code+" </a> </td>");
				/*IN067570 ends*/
				out.println("<td width='50%' class='"+classvalue+"'>"+desc+"</td>");
				out.println("</tr>");
				//out.println("<tr></td width='50%' class=\""+classvalue+"\">"+code+"---"+desc+"</td></tr>");
			
				//out.println("rowCount from jsp = "+rowCount);
				rowCount++;
			}
			rs.close();
			pstmt.close();
			}
			if(rowCount == 0)
			{
			%>
				<script>
					var errorMsg = alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
				</script>
			<%
			}
			//IN067538 start
			if(rowCount==1){
				if(search_text.equalsIgnoreCase(desc)){%>
					<script>
							retValue('<%=code%>','<%=desc%>')
					</script>
				<%}
			}
			//IN067538 end
		}
		catch(Exception e)
		{
			out.println("code = "+code+"--------desc = "+desc);
			//out.println("Exception in CommonLookupResult.jsp at line---"+rowCount+"--"+e.toString());//COMMON-ICN-0181

			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	%>
		</table>	
		<script>
			parent.lookup_head.document.CriteriaForm.Search.disabled = false;
		</script>
	</body>
</html>
<%!

/************************Added by Deepa on 6/25/2009 at 5:06 PM for IN01088 *******************/
private static String[] construct(String sqlQuery)
{
	StringBuffer temp = new StringBuffer(sqlQuery);
	String retVal[];
	int count = 0;
	if(temp.indexOf("$$") == temp.lastIndexOf("$$"))
		retVal = new String[2];
	else
	{
		int start_index = 0;
		while (true)
		{
			start_index = temp.indexOf("$$", start_index);
			if(start_index == -1)
				break;
			else
			{
				count++;
				start_index += 2;
			}
		}
		retVal = new String[count+1];
	}

	count = 1;
	while(temp.indexOf("$$") != -1)
	{
		int start_index = temp.indexOf("$$");
		int end_index = temp.indexOf("##");
		String paramValue = temp.substring(start_index+2, end_index);
		temp.replace(start_index, end_index+2, "?");

		retVal[count] = paramValue;
		count++;
	}
	retVal[0] = temp.toString();

	return retVal;
}
// Added by Sridhar Reddy to fix IN024604 on 16/11/2010
//Replacing special chars to avoid script error.
private String replaceSpecialChars(String input)
{
	if( !input.equals("") )
	{
		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");	
		if (input.indexOf("\"") != -1) input = input.replaceAll("\"","&quot;");	
		if (input.indexOf("'") != -1) input = input.replaceAll("'","&lsquo;");	
	}

	return input;
}
//End 
%>

