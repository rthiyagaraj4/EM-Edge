<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 
Connection connection	= null;
CallableStatement callableStatement=null;	
try {		
	//	Statement statement		= null;
	//	ResultSet resultSet		= null;
		int errFlag				= 0;	 		 
		String exceptions		= "";
	//	String SysDefStructure  = "";
	//	String UserDefStructure = "";			    
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    	hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String func_mode			= request.getParameter("func_mode");
		//System.out.println("RearrangementLayerQryStructuresUserDefStructure : "+func_mode);
		if(func_mode!= null && func_mode.equals("qryStructures")) {
		String usrDef_Val	 = (String) hash.get( "UsrDefStrVal" );
		//System.out.println("RearrangementLayerQryStructures UserDefStructure: "+usrDef_Val);
			try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
		//	exceptions=exceptions+"1"+"*"+exp.toString();        
		}
		try{		    			
     callableStatement=connection.prepareCall("{ call xh_update_user_def_structure(?)}");
     callableStatement.setString(1,usrDef_Val);
     callableStatement.execute();
        	}
			catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				//System.out.println(" RearrangementLayerQryStructures errFlag UserDefStructure : "+errFlag);

			out.println("parent.reset()");
//				String sdt = java.net.URLEncoder.encode(SysDefStructure);
//				String udt = java.net.URLEncoder.encode(UserDefStructure);
//out.println("parent.setSystUsrDefStr('"+sdt.toString().trim()+"','"+udt.toString().trim()+"')");
		}
		} // end of if
		
		//}

	}
	catch (Exception e) {
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			ConnectionManager.returnConnection(connection);
			if(callableStatement != null) callableStatement.close();
		}
		catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }
	}



%>
