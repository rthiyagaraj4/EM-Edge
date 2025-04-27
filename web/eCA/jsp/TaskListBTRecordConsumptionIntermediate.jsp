<%--	
	Created On	: 8/3/2010
	Created By	: Archana Dhal
	Purpose     : IN022960

--%>

<%@ page import="java.util.*,java.sql.*,java.sql.Types,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 <%
		request.setCharacterEncoding("UTF-8");	
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
        String locale = (String) property.getProperty("LOCALE");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String patient_id =hash.get("patient_id")==null?"":(String) hash.get("patient_id");
		String order_facility_id =hash.get("order_facility_id")==null?"":(String) hash.get("order_facility_id");
		String specimen_no =hash.get("specimen_no")==null?"":(String) hash.get("specimen_no");
		String product_code =hash.get("product_code")==null?"":(String) hash.get("product_code");		
		String unit_no =hash.get("unit_no")==null?"":(String) hash.get("unit_no");		
		String product_desc =hash.get("product_desc")==null?"":(String) hash.get("product_desc");		
		String blood_group =hash.get("blood_group")==null?"":(String) hash.get("blood_group");	
		String rhesus_code =hash.get("rhesus_code")==null?"":(String) hash.get("rhesus_code");
		String strStat="",strErr="",strTotal="";
		
		
		Connection con = null; 
		String strxMatchResult	=	"N";
		PreparedStatement pst	=	null;
		PreparedStatement pstmt	=	null;
		ResultSet rsParam		=	null,resultSet = null;
		String query;
		String message_txt="";
		int flag=0;
		if (locale.equals("US")==true || locale.equals("en")==true || locale.equals("GB")==true || locale.length()==0)
		{
		  flag=0;
	      query =	"SELECT message_id||'-'||NVL(message_text,message_text_sysdef) MSG_TXT	FROM SM_MESSAGE WHERE UPPER(message_ref) = UPPER(?)";
		}
	   else
		{
		  flag=1;
	      query =	"SELECT 	M.message_id||'-'||NVL(D.message_text,D.message_text_sysdef) MSG_TXT FROM 	SM_MESSAGE	M, SM_MESSAGE_DESC D WHERE 	UPPER(D.message_ref) = UPPER(?) 	AND D.language_id = ? AND UPPER(M.message_ref) = UPPER(D.message_ref)";
		}

		try 
		{						
			try
			{
				con=ConnectionManager.getConnection();
     			pst		=	con.prepareStatement("SELECT nvl(XMATCH_RESULT_BEFORE_TRANS_YN,'N') From BT_Param");
				rsParam =	pst.executeQuery();

				if(rsParam != null && rsParam.next())
				{
					strxMatchResult	=	rsParam.getString(1);
				}

			}
			catch(Exception e)
            {
	          e.printStackTrace();	
            }
			finally
			{
				if(rsParam != null) rsParam.close();
				if(pst != null) pst.close();
			}
		
			CallableStatement callableStatement=null;		
				
			if(strxMatchResult.equals("Y") )
			{
			    callableStatement=con.prepareCall("{ call BT_TRANSFUSE_COMMIT.BT_TRANSFUSE_UNIT_CHECK(?,?,?,?,?,?,?)}");

				callableStatement.setString(1,order_facility_id);
				callableStatement.setString(2,patient_id);
				callableStatement.setString(3,specimen_no);
				callableStatement.setString(4,unit_no);
				callableStatement.setString(5,product_code);

				callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);				

				callableStatement.execute();
	
		        strStat = callableStatement.getString(6);
			    strErr  = callableStatement.getString(7);

			    if(strStat==null||strStat.equalsIgnoreCase("null"))		  strStat=" ";
				
			    if(strErr==null||strErr.equalsIgnoreCase("null"))		  strErr=" ";
									
		        callableStatement.close();
				pstmt=con.prepareStatement(query);

	            pstmt.setString(1, strErr);
	            if(flag == 1) 	pstmt.setString(2,locale);

	            resultSet	= pstmt.executeQuery();
				while(resultSet!= null && resultSet.next())
				{	
				  message_txt=resultSet.getString( "MSG_TXT" );						
				}

	            message_txt =(message_txt==null?"":message_txt);
	            
				if(strStat!=null ) 
				{
				   out.println( "validateBT(\""+strStat+"\",\"" +message_txt+" \") ; " ) ;
				}
			}
			/* Added by Uma on 11/30/2010 for IN025273*/
			else
			{
				 out.println( "validateBT(\""+strStat+"\",\"" +message_txt+" \") ; " ) ;
			}
			/*Ends here*/
		}
		catch(Exception e)
        {
	        e.printStackTrace();	
        }
		finally
		{
			try
			{
				if(resultSet!=null) resultSet.close();
				if(pstmt !=null) pstmt.close();
				ConnectionManager.returnConnection(con, request);
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
		}
 %>

