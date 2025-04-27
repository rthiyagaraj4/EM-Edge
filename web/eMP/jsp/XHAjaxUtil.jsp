
<%@ page import="java.sql.*,java.util.*,java.io.*,java.io.FilePermission,java.security.AccessController,eMP.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=ISO-8859-1" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<%
	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;

	try 										   
	{				
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		String filePath = (String)hash.get("filePath");
		
			if(filePath != null)
			{
				//System.out.println("File path in ajaxutil.jsp:::..."+filePath);
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
							/*fileDirectory.mkdirs();
							File file1 = new File(filePath+"\\"+System.currentTimeMillis()+".txt");

							if (file1.createNewFile()){
								System.out.println("File is created!!!");
                                file1.delete();
								fileDirectory.delete();
								out.println("Y");
							  }else{
								//System.out.println("File already exists.");
							  } */

							  System.out.println("Directory doesn't exist!!!!!!!"+filePath);
						}
						else{
                          
                           File file1 = new File(filePath+"\\"+System.currentTimeMillis()+".txt"); 
						   if (file1.createNewFile())
						   {
								//System.out.println("File is created!");
                                file1.delete();
								out.println("Y");
						   }
						   else{
						   System.out.println("Directory is existing but access is denied!!!!!!"+filePath);
						   }
						}
                } catch ( Exception e )	{
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

	catch (Exception e) 
	{
		e.printStackTrace() ;
	}
%>
