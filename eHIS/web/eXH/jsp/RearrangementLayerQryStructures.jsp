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
										   
		String SysDefStructure  = "";
		String UserDefStructure = "";

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		
		String func_mode			= request.getParameter("func_mode");
			//System.out.println("RearrangementLayerQryStructures : "+func_mode);
		
		if(func_mode!= null && func_mode.equals("qryStructures")) {
			String appl_name	 = (String) hash.get( "appl_name" );
			String event_type		 = (String) hash.get( "event_type" );
			//System.out.println("RearrangementLayerQryStructures appl_name: "+appl_name);
			//System.out.println("RearrangementLayerQryStructures event_type: "+event_type);
		
		
		
		try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
		//	exceptions=exceptions+"1"+"*"+exp.toString();        
		}
		try{		              			
              callableStatement=connection.prepareCall("{ call XHGENERIC.xh_get_sysdef_structure(?,?,?,?)}");
              callableStatement.setString(1,appl_name);
              callableStatement.setString(2,event_type);
              callableStatement.registerOutParameter(3,Types.CLOB);
              callableStatement.registerOutParameter(4,Types.CLOB);				
              callableStatement.execute();
              SysDefStructure	=	callableStatement.getString(3);
              UserDefStructure	=	callableStatement.getString(4);
				  //System.out.println("SysDefStr : "+SysDefStructure);
				  //System.out.println("UserDefStr : "+UserDefStructure);
		}
	
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				//System.out.println(" RearrangementLayerQryStructures errFlag : "+errFlag);
				String sdt = java.net.URLEncoder.encode(SysDefStructure);
				String udt = java.net.URLEncoder.encode(UserDefStructure);
out.println("parent.setSystUsrDefStr('"+sdt+"','"+udt+"')");
		}
		} // end of if
		
		//}

	}
	catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
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

		}
	}



%>
