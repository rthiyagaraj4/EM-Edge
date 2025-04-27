<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,java.io.FilePermission,java.security.AccessController,eMP.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=ISO-8859-1" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<%
	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;
	PreparedStatement pstmt_select  = null;

	try 										   
	{				
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		String filePath = (String)hash.get("filePath");
		String utilType = (String)hash.get("utilType");

		if("CheckDocumentConfiguration".equals(utilType))
		{
			if(connection==null) connection = ConnectionManager.getConnection();  
		   
			String facility_id = (String)session.getValue("facility_id");
			String sDocType = (String)hash.get("DocType");
			StringBuffer select_sql = new StringBuffer("");

			
			System.out.println(" Ajax Util :::  facilityId: "+facility_id+" ::: doc_type: "+sDocType);

			select_sql.append(" select a.FACILITY_ID,b.FACILITY_ID, b.DOC_TYPE");
			select_sql.append(" from sm_patient_doc_param a, sm_patient_doc_dtl b ");
			select_sql.append(" where A.FACILITY_ID = ? AND b.doc_type = ? AND a.facility_id = b.facility_id ");				

			pstmt_select = connection.prepareStatement(select_sql.toString());
			pstmt_select.setString(1, facility_id);
			pstmt_select.setString(2, sDocType);
			resultSet = pstmt_select.executeQuery();

			if(resultSet!=null && resultSet.next())
			{
				out.println("Y");
			}
			else
			{
				out.println("N");
			}

		}
		else
		{
			if(filePath != null)
			{
				try {
					File fileDirectory = new File(filePath);
					/*if(f.canWrite()) {
						System.out.println("File can be written from the server to the given path!!!!!!!"+filePath);
						out.println("Y");
						} else {
						System.out.println("File cannot be written from the server to the given path!!!!!!!"+filePath);
						out.println("N");
					}*/
					//AccessController.checkPermission(new FilePermission("//cscappche608/Documents/*", "read,write"));

					if (!fileDirectory.exists())
					{

					  System.out.println("Directory doesn't exist!!!!!!!"+filePath);
					}
					else
					{

						File file1 = new File(filePath+"\\"+System.currentTimeMillis()+".txt"); 
						if (file1.createNewFile())
						{
							//System.out.println("File is created!");
							file1.delete();
							out.println("Y");
						}
						else
						{
							System.out.println("Directory is existing but access is denied!!!!!!"+filePath);
						}
					}
				} 
				catch ( Exception e )	
				{
					System.out.println("File cannot be written from the server to the given path!!!!!!!"+filePath);
					out.println(e.getMessage());
					e.printStackTrace() ;				
				} 
			}
			else
			{
				out.println("File path is empty!!!!!");
			}
		}

	}
	catch (Exception e) 
	{
		e.printStackTrace() ;
	}
	finally {
		try {
			if (pstmt_select != null)
				pstmt_select.close();

			if (connection != null)
				ConnectionManager.returnConnection(connection, request);

			if(resultSet != null)
				resultSet.close();

			if(statement != null)
				statement.close();

		} 
		catch (Exception ee) 
		{
			System.out.println("DocumentScanAjaxUtil.jsp::::Exception in finally Block Closing Resources::: "+ ee.toString());
			ee.printStackTrace();
		}
	}
%>
