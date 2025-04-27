<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.XMLStringParser" contentType="text/html;charset=ISO-8859-1" %>
 
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 
		Connection con1	= null;
		Statement stmt1		= null;
		ResultSet rst1		= null;																		   
		try {
			con1	= ConnectionManager.getConnection(request);
			String func_mode			= request.getParameter("func_mode");
				
			Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
			hash						= (Hashtable)hash.get( "SEARCH" ) ;
																		 
			if(func_mode!= null && func_mode.equals("getSupplierName")) {

				String hisGRNnum		 = (String) hash.get( "iba_doc_num" );
				System.out.println("xiutil.jsp:::hisGRNnum..."+hisGRNnum);
				String supplierName = "";
                
				String sql1 = "SELECT supp_name FROM xi_trn_grn WHERE IBA_DOC_NUM='"+hisGRNnum+"'";
				System.out.println("xiutil.jsp:::sql..."+sql1);
			try{	 
					stmt1	= con1.createStatement();
					rst1	= stmt1.executeQuery(sql1);					
					while(rst1.next()){
					supplierName=rst1.getString(1);	
				}
				}catch(Exception e){
						System.err.println("Err Msg in xiutil.jsp : "+e);
				}finally{			
						out.println(supplierName);	  		  	
						if(rst1!=null)rst1.close();
						if(stmt1!=null)stmt1.close();			
				}
				
	        } 
		 
			}
			catch(Exception e){
						System.err.println("Err2 Msg in xiutil.jsp : "+e);
			}finally{
						ConnectionManager.returnConnection(con1);
			}
%> 
