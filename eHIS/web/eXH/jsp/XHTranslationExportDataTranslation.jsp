<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,oracle.jdbc.driver.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle ="IeStyle.css";
//(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript" >																	 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
									  												    
</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'  >
<form >

<% 		
 Connection connection = null;	
 MessageManager mm=new MessageManager();
 Properties p;
 p = (Properties) session.getValue("jdbc");	
 String msg="";

 String message="";
 //CallableStatement ostmt = null;
 Statement stmt=null;
 Statement ostmt = null;
 Statement ehisstmt=null;
 ResultSet rs=null;
 ResultSet ehisrs=null;
  Statement colstmt=null;
 ResultSet colurs=null;
  Statement custmt=null;
 ResultSet curs=null;
 String status="0";
 String exceptions="";
 
 String facilityId = (String) session.getValue("facility_id");	
 String module_id=XHDBAdapter.checkNull(request.getParameter("module_id"));	
 String masterName=XHDBAdapter.checkNull(request.getParameter("master_name")); 
 String applicationID=XHDBAdapter.checkNull(request.getParameter("application"));
 String display=XHDBAdapter.checkNull(request.getParameter("display"));
 String searchText=XHDBAdapter.checkNull(request.getParameter("searchtext"));
 String mod_id= XHDBAdapter.checkNull(request.getParameter("mod_id")); 
 String func_id=XHDBAdapter.checkNull(request.getParameter("func_id"));
 String outbound_yn="X";		  
 String connStr_="";
 String driverStr_="";
 String username_="";
 String pswd_="";
 String searchpk2=XHDBAdapter.checkNull(request.getParameter("searchpk2")); 	 
 String searchpk3=XHDBAdapter.checkNull(request.getParameter("searchpk3"));
 String start_ends_contains=XHDBAdapter.checkNull(request.getParameter("start_ends_contains"));
 String master_table_id="";
 String inserting_table="";
 ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
			String  usr_added_by_id=(String)arrAudit.get(0);
	 	    String  usr_added_at_ws_no=(String)arrAudit.get(1);
 p = (Properties) session.getValue("jdbc");	
 ArrayList getcolum=new ArrayList();
 ArrayList columname=new ArrayList();
 ArrayList arrCol=new ArrayList();
 int result=0;
    try					  
    {
       if(connection==null) connection = ConnectionManager.getConnection();
		  /*
			 */

      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of XHTranslationExportDataTranslation.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    																	    
     try			 			    
     {	
		 String selectingEhisQuery="SELECT DISTINCT MASTER_TABLE_ID,TRANS_TABLE_ID FROM XH_MAPPING A where MASTER_TABLE_ID='"+masterName+"' ";
		 //System.out.println("selectingEhisQuery "+selectingEhisQuery);
		 ehisstmt=connection.createStatement();
		 ehisrs=ehisstmt.executeQuery(selectingEhisQuery);	
		 while(ehisrs.next())
		 {
			 master_table_id=ehisrs.getString(1);
			 inserting_table=ehisrs.getString(2);	   
		 }
		  if(ehisrs!=null)ehisrs.close();
		  if(ehisstmt!=null)ehisstmt.close();

			 String selectColumQuery="SELECT COLUMN_ID fROM XH_MAPPING  A where MASTER_TABLE_ID='"+masterName+"' ";
			 colstmt=connection.createStatement();
			 //System.out.println("selectColumQuery "+selectColumQuery);
			 colurs=colstmt.executeQuery(selectColumQuery);	
			 int c=0;
			 while(colurs.next())
			 {
				  columname.add(c,colurs.getString(1));
				   c++;
			 }
		  if(colurs!=null)colurs.close();
		  if(colstmt!=null)colstmt.close();
		 String selectQuery="select * from XH_INTERACTIVE_CONNECT_PARAM where PLUGIN_TYPE='"+masterName+"'";
		 stmt=connection.createStatement();
		 rs	= stmt.executeQuery(selectQuery);	
		 //System.out.println("selectQuery "+selectQuery);
		 while(rs.next())
		 {
			   connStr_=rs.getString("DB_CONNECT_STRING");
			   driverStr_=rs.getString("DATABASE_DRIVER");
			   username_=rs.getString("USER_NAME");
			   pswd_=rs.getString("PASSWORD");	   
 			   getcolum=getOtherResult(connStr_,driverStr_,username_,pswd_,masterName,columname);	  	  
		 }
			 if(rs!=null)rs.close();
			 if(stmt!=null)stmt.close();

		

		  for(int j=0;j<getcolum.size();j++)
		 {
				arrCol=(ArrayList)getcolum.get(j);

			  //System.out.println("arrCol.size() :"+arrCol.size());

				 for(int a=0;a<arrCol.size();a++)
			 {

					 
					String insertUpdatesqlQuery="";
					 String selectFindQuery="";
					 int count=0;
				  if(inserting_table.indexOf("DKEY")!=-1)
				 {
				    selectFindQuery="select count(*) from "+inserting_table+" where TABLE_ID='"+masterName+"' and APPLICATION_ID='"+applicationID+"' and PK1_VALUE='"+(String)arrCol.get(0)+"' and PK2_VALUE='"+(String)arrCol.get(1)+"' ";
				 }
				else if(inserting_table.indexOf("SKEY")!=-1)
				 {
					 selectFindQuery="select count(*) from "+inserting_table+" where TABLE_ID='"+masterName+"' and APPLICATION_ID='"+applicationID+"' and PK_VALUE='"+(String)arrCol.get(0)+"' ";
				 }			  
				 		

					/* String selectFindQuery="select count(*) from "+inserting_table+" where TABLE_ID='"+masterName+"' and APPLICATION_ID='"+applicationID+"' and PK_VALUE='"+(String)arrCol.get(0)+"' ";		 */
					 //System.out.println("selectFindQuery XHTranslationExportDataTranslation :"+selectFindQuery);

					 custmt=connection.createStatement(); 
					  curs=custmt.executeQuery(selectFindQuery);
					  if(curs.next())
					 {
						count=curs.getInt(1);
					 }
											   

				   if(inserting_table.indexOf("SKEY")!=-1 || inserting_table.indexOf("Skey")!=-1||inserting_table.indexOf("skey")!=-1)
				 {
					
					 if(count>0)
					 {
						 insertUpdatesqlQuery="Update "+inserting_table+" SET DESC2_VALUE='', EXT_PK_ID='' where TABLE_ID='"+masterName+"' and APPLICATION_ID='"+applicationID+"' and PK_VALUE='"+(String)arrCol.get(0)+"' ";	
					 }
					 else
					 {		   
						 insertUpdatesqlQuery="insert into "+inserting_table+"(TABLE_ID, APPLICATION_ID, PK_VALUE,EXT_PK_ID,DESC2_VALUE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values('"+masterName+"','"+applicationID+"','"+(String)arrCol.get(0)+"','','','"+usr_added_by_id+"',SYSDATE,'"+usr_added_at_ws_no+"','"+facilityId+"','"+usr_added_by_id+"',SYSDATE,'"+usr_added_at_ws_no+"','"+facilityId+"')";	
						//System.out.println("insertUpdatesqlQuery XHTranslationExportDataTranslation.jsp :"+insertUpdatesqlQuery);

					 } 
					  

				 }
				 else if(inserting_table.indexOf("DKEY")!=-1 || inserting_table.indexOf("Dkey")!=-1||inserting_table.indexOf("dkey")!=-1)
				 {

				    if(count>0)									   
					 {
						 insertUpdatesqlQuery="Update XH_OTH_APPL_DATA_DKEY SET DESC2_VALUE='', EXT_PK1_VALUE='', EXT_PK2_VALUE='' where TABLE_ID='"+masterName+"' and APPLICATION_ID='"+applicationID+"' and PK1_VALUE='"+(String)arrCol.get(0)+"' and PK2_VALUE='"+(String)arrCol.get(1)+"'  ";	
					 }
					 else
					 {		   
						 insertUpdatesqlQuery="insert into "+inserting_table+"(TABLE_ID, APPLICATION_ID, pk1_value, pk2_value,         ext_pk1_value, ext_pk2_value, desc2_value,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values('"+masterName+"','"+applicationID+"','"+(String)arrCol.get(0)+"','"+(String)arrCol.get(1)+"','','','','"+usr_added_by_id+"',SYSDATE,'"+usr_added_at_ws_no+"','"+facilityId+"','"+usr_added_by_id+"',SYSDATE,'"+usr_added_at_ws_no+"','"+facilityId+"')";			     
					 } 
					  		 						  
												   
				 }	
				
				

				     ostmt=connection.createStatement();
					 result	= ostmt.executeUpdate(insertUpdatesqlQuery);	 

			 }



		 }
			 //System.out.println("result :"+result); 	 
		if(result==1)
		{
			status="0";
		}												    
		else
		{
			status="1";	 
		}
		if("0".equals(status))											  
		{
			connection.commit();
			final java.util.Hashtable mesg = mm.getMessage("en", "XH1001", "XH") ;
			message = ((String) mesg.get("message"));
		}
		else
		{
			connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage("en", "XH1000", "XH") ;
			message = ((String) mesg.get("message")); 
		}

			  out.println("<body class='MESSAGE' BGCOLOR='#B2B6D7' >"); 
			  out.println(message);
			  out.println("</body>");												   
		 /*String insertsqlQuery="insert ";			     
		 ostmt=connection.createStatement();												   
		 rs	= ostmt.executeQuery(insertsqlQuery);*/


		//ostmt = connection.prepareCall("{ CALL xhdevapi.xh_manage_appl_trigger(?,?,?) }" ); 
		//ostmt.setString(1,module_id);
  	//	ostmt.setString(2,masterName);
	//	ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
	 //   ostmt.execute();														 							    
	//	status = ostmt.getString(3);
												   
		/*	if(ostmt!=null)
				{
					ostmt.close();
					ostmt=null;							  					  
				}		 				    
				RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/XHTranslationDisplayResult.jsp?message="+msg+"&module_id="+module_id+"&masterName="+masterName+"&application="+applicationID+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3);  reqDis.forward(request,response);	 			   
																	 	 	  				*/	   
      }													 		  				   
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in XHTranslationExportDataTranslation.jsp sqlexeception :"+exp);
	             
      }
	  finally
	 {
		if(ostmt!=null)
		ostmt.close();
		ConnectionManager.returnConnection(connection);
	 }
			  													    
	  %>

	<%!
		    public  ArrayList  getOtherResult(String connStr_,String driverStr_,String username_,String pswd_,String masterName,ArrayList columnname)
		   {	
		
			  	ArrayList returnOrginal=new ArrayList();
				
			try
			   {
					
			   	   Connection conn=null;
				Statement constmt=null;
				ResultSet rset=null;
			 
				/*Class.forName(driverStr_).newInstance();    
				conn = DriverManager.getConnection(connStr_, username_, pswd_);  */

				try
				{
					 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				 //  Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();    
				//   conn = DriverManager.getConnection("jdbc:oracle:thin:@indbgl-app03:1521:v3dv", "NAREN", "NAREN");
					 conn = DriverManager.getConnection(connStr_, username_.toUpperCase(), pswd_.toUpperCase());
				
				}
				catch(Exception e)
			   {
				System.out.println("(XHTranslationExportDataTranslation.jsp:Connection Exception-1) :"+e);
			   }
				constmt=conn.createStatement();
			    String  fetchQuery="SELECT ";
				  //   ResultSetMetaData rsmd=rs.getMetaData();
				  // int colCount=rsmd.getColumnCount();										   
				   for(int i=0;i<columnname.size();i++)
				   { 
						  if(i==(columnname.size()-1))
					   {
						  fetchQuery=fetchQuery+" "+(String)columnname.get(i)+" ";
					   }
					   else
					   {
						 fetchQuery=fetchQuery+""+(String)columnname.get(i)+",";
					   }
						


				   }
			   		fetchQuery=fetchQuery+" FROM "+masterName; 

					  //System.out.println("coming 197 fetchQuery "+fetchQuery);

				   rset	= constmt.executeQuery(fetchQuery);	 
					while(rset.next())
				   {
						  ArrayList returnRes=new ArrayList();
						for(int k=0;k<columnname.size();k++)
					   { 


						  returnRes.add(k,rset.getString((String)columnname.get(k)));
					   }
						returnOrginal.add(returnRes);

				   }
				   	rset.close();
					constmt.close();
					conn.close();
				  //System.out.println("returnOrginal :"+returnOrginal);
			   }
			   catch(Exception e)
			   {
				 System.out.println(" exception in XHTranslationExportDataTranslation.jsp :"+e);
			   }
			   finally
			   {
					
			   }

			  return returnOrginal;
		   }

	%>
	  </form>
	  </body>
	  </html>
										 

