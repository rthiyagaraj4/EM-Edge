<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
	<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
		
	String progression_ref = request.getParameter("progression_ref")==null?"":request.getParameter("progression_ref");
	String note_group = request.getParameter("note_group")==null?"":request.getParameter("note_group");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");

	String outData ="";
	String note_group_desc = request.getParameter("note_group_desc")==null?"":request.getParameter("note_group_desc");
	String note_type_desc ="";
	String note_type ="";
	Boolean flag = true;
	%>
	<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form METHOD=POST ACTION="" name="progNotesView" id="progNotesView"  >

	<%	
	String level = request.getParameter("level")==null?"":request.getParameter("level");
	try
	{
		con = ConnectionManager.getConnection(request);

		if(level.equals("PN"))
		{
			String notesViewQry = " SELECT NOTE_TYPE,(select NOTE_GROUP_ID from ca_note_type a where a.NOTE_TYPE = b.NOTE_TYPE ) note_group, (select CA_GET_DESC.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type a  where a.NOTE_TYPE = b.NOTE_TYPE ) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE  B WHERE ACCESSION_NUM IN ( SELECT ACCESSION_NUM FROM CA_PAT_PROGRESSION_DTL WHERE PROGRESSION_REF = ? ) AND EVENT_STATUS !=9 order by note_group_desc, note_type_desc,EVENT_DATE_TIME " ;

			String pre_note_group = "";
		
			try
			{
				pstmt		=	con.prepareStatement(notesViewQry);

				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,progression_ref);
				
				rs	 =	pstmt.executeQuery();
				while(rs.next())
				{
					flag = false;
					note_group = rs.getString("note_group");
					note_group_desc = rs.getString("note_group_desc");
					if(!note_group.equals(pre_note_group))
					{
						if(!outData.equals(""))
						{
							outData = outData + "</TD></TR></TABLE>";
						}
						
						outData = outData+ "<BR><BR><table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'> ";
					}

					outData = outData + rs.getString("NOTE_CONTENT")+"<BR><hr style=' height: 3px; color:#707070 ' > <BR>";

					pre_note_group = note_group;
					
				}

				outData = outData + "</TD></TR></TABLE></BODY></HTML>";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(!flag)
					out.println(outData);
			
			}
			catch (Exception e) 
			{
				e.printStackTrace();			
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		}
		else if(level.equals("NG"))
	{
		String notesViewQry = " SELECT NOTE_TYPE,CA_GET_DESC.CA_NOTE_GROUP(?,?,2) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM IN   ( SELECT ACCESSION_NUM FROM CA_PAT_PROGRESSION_DTL WHERE PROGRESSION_REF = ?  ) AND NOTE_TYPE IN ( SELECT NOTE_TYPE FROM CA_NOTE_TYPE WHERE NOTE_GROUP_ID = ? ) AND EVENT_STATUS !=9 order by note_type_desc, EVENT_DATE_TIME" ;
		
		try
			{
				pstmt		=	con.prepareStatement(notesViewQry);

				pstmt.setString(1,note_group);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,progression_ref);
				pstmt.setString(5,note_group);

				rs	 =	pstmt.executeQuery();
				
				outData = "<table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'> ";
				//outData = "<tr><td>123"+note_group_desc+"</td></tr>";
				while(rs.next())
				{

					flag = false;
					note_type =  rs.getString("NOTE_TYPE");
					note_type_desc =  rs.getString("note_type_desc");
					note_group_desc =  rs.getString("note_group_desc");
					
					outData = outData + rs.getString("NOTE_CONTENT")+"<BR><hr style=' height: 3px; color:#707070 ' > <BR>";
								
				}

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				outData = outData + "</TD></TR></TABLE></BODY></HTML>";

				if(!flag)
					out.println(outData);		
			}
			catch (Exception e) 
			{
				e.printStackTrace();			
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}	
		}
		else if(level.equals("NT"))
	{
			String notesViewQry = " SELECT NOTE_TYPE,(select CA_GET_DESC.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type a  where a.NOTE_TYPE = b.NOTE_TYPE ) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE b WHERE ACCESSION_NUM = ? " ;
			
			try
				{
					pstmt		=	con.prepareStatement(notesViewQry);

					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,accession_num);
					
					rs	 =	pstmt.executeQuery();
					
					while(rs.next())
					{

						flag = false;
						note_type =  rs.getString("NOTE_TYPE");
						note_type_desc =  rs.getString("note_type_desc");
						note_group_desc =  rs.getString("note_group_desc");
						
						outData = "<BR><BR><HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'>";
						
						
						outData = outData + rs.getString("NOTE_CONTENT")+"<BR><BR>";
						
					
					}
						outData = outData + "</TD></TR></TABLE></BODY></HTML>";

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					if(!flag)
						out.println(outData);
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();			
				}
				finally
				{
					if(con != null) ConnectionManager.returnConnection(con,request);
				}	
			}
		}//end of try - main
		catch(Exception conexp)
		{
			System.out.println("Exception in creation of connection in ProgressNotesView.jsp ---"+conexp.toString());
			conexp.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}

		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");		
		}
	%>

	</form>
</body>
</html>

