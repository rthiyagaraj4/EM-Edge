<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.lang.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	String notesHtmlData = ""; 
	StringBuffer notesHtmlDataBfr = new StringBuffer();

	String labTestDesc = "";
	String notesSql = "", labTestSql = "";
	String whereCond = "";

	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;//common-icn-0180

	int indexOfTilde = 0;	

	String divID = "", queryColumn="", columnName = "", columnData = "", tableName="";
	String resultUOM="", resultStr = "";
	
	int resultNum = 0;
	
	boolean notesContentFlag = false;

	String[] columnArray = null;
	String[] dataArray = null;
	

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	divID = request.getParameter("divID")==null?"":request.getParameter("divID");
	queryColumn = request.getParameter("queryColumn")==null?"":request.getParameter("queryColumn");
	columnName = request.getParameter("columnName")==null?"":request.getParameter("columnName");
	columnData = request.getParameter("columnData")==null?"":request.getParameter("columnData");
	tableName = request.getParameter("dataTable")==null?"":request.getParameter("dataTable");
	
	indexOfTilde = columnName.indexOf('~');
	columnData = columnData.replace('>', '#');
	whereCond = columnName + " = \'"+ columnData +"\'";	
	
	if (indexOfTilde>0){
		whereCond = "";
		columnArray = columnName.split("~");
		dataArray = columnData.split("~");
		if (columnArray.length > 0){
			for (int i=0;i<columnArray.length;i++){
				if (i<columnArray.length-1){
					whereCond = whereCond + columnArray[i] + " = \'"+ dataArray[i] +"\' and ";	
				}
				else
				{
					whereCond = whereCond + columnArray[i] + " = \'"+ dataArray[i] +"\'";	
				}
			}			
		}
	}

	try
	{
		con		= ConnectionManager.getConnection(request);

		// To get the Notes Information
		notesSql="select "+queryColumn+" note_content FROM " + tableName + " where "+whereCond;
		stmt=con.createStatement();

		rs=stmt.executeQuery(notesSql);
		
		notesHtmlData = "";
		
		notesContentFlag = false;
		
		int posHtml = 0;
		
		if (rs!=null){
			if(rs.next())
			{
				notesHtmlData = rs.getString("note_content")==null?"":rs.getString("note_content");				
				notesContentFlag = true;
				
				if (notesHtmlData.length() > 0){
					posHtml = notesHtmlData.toLowerCase().indexOf("<html><body>");
					if (posHtml < 0){
						notesHtmlDataBfr.append("<HTML><BODY><PRE>");
						notesHtmlDataBfr.append(notesHtmlData);
						notesHtmlDataBfr.append("</PRE></BODY></HTML>");
						notesHtmlData = "";
						notesHtmlData = notesHtmlDataBfr.toString();	
					}					
				}				
			}
			else
			{
				notesContentFlag = false;
			}			
		}
		
		if (!notesContentFlag)
		{
			resultNum = 0;
			resultUOM = "";
			resultStr = "";
			
			notesSql=" select result_num, result_num_uom, result_str from cr_encounter_detail where " +whereCond;
			stmt=con.createStatement();
			rs=stmt.executeQuery(notesSql);
			notesHtmlData = "";
			
			if (rs!=null){
				if(rs.next())
				{
					resultNum = rs.getInt("result_num");
					resultUOM = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
					resultStr = rs.getString("result_str")==null?"":rs.getString("result_str");
					
					if (resultNum > 0)
					{
						notesHtmlData = resultNum + " " + resultUOM;
					}
					notesHtmlData = notesHtmlData + resultStr;
					notesContentFlag = false;
				}
			}
			
		}
		
		if (dataArray[0].equalsIgnoreCase("lbin"))
		{
		
			/* labTestSql = " select short_desc from cr_event_hist_rec_vw where hist_rec_type = '"+dataArray[0]+"' " + 
						 " and event_code_type = '"+dataArray[1]+"' and language_id = '"+locale+"' and event_code = '"+dataArray[3]+"' "; *///common-icn-0180
			
			labTestSql = " select short_desc from cr_event_hist_rec_vw where hist_rec_type = ? " + 
					 " and event_code_type = ? and language_id = ? and event_code = ? ";//common-icn-0180
						 
						 //common-icn-0180 starts
			//stmt=con.createStatement();//common-icn-0180
			pstmt=con.prepareStatement(labTestSql);
			pstmt.setString(1, dataArray[0]);
			pstmt.setString(2, dataArray[1]);
			pstmt.setString(3, locale);
			pstmt.setString(4, dataArray[3]);
			//rs=stmt.executeQuery(labTestSql);//common-icn-0180
			rs=pstmt.executeQuery();
			//common-icn-0180 ends
			labTestDesc = "";
			
			if (rs!=null)
			{
				if(rs.next())
				{
					labTestDesc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				}
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		if(pstmt!=null)pstmt.close();//common-icn-0180	
		
%>	
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<div id="<%=divID%>"></div>      

<script>

$(document).ready(function() {	
	setTimeout(function() {
		parent.printPage();
	}, 1000);
});

</script>
<div>
<%
	if (dataArray.length > 0)
	{									
%>
	<table class="breakTable" align="center" border="0" cellpadding="0" cellspacing="0" style="width: 900px">
		<thead> 
		<tr class="breakTrNotes">
			<th>
				<table class="breakTable" align="center" border="0" cellpadding="0" cellspacing="0" style="width: 900px">
					<tbody>
						<tr class="breakTrNotes">	
								<td style="border-bottom:1px solid green;  text-align: left" valign="bottom">										
					 		
								<span style="font-size: 10pt; font-weight: bold;"><span style="font-family: verdana, geneva, sans-serif">
										<%= labTestDesc %>											
								</span></span>
							</td>
						</tr>
					</tbody>
				</table>
			</th>
		</tr>	
		</thead> 
		 		
			<tbody>
			<tr class="breakTrNotes">
				<td valign="center">
				<%=notesHtmlData%>
				</td>
			</tr>
			</tbody>	
	</table>
	<%
		} 
	%>		
</div>

<%
	}
	catch(Exception e){
		//out.println("Exception: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}	
%>


