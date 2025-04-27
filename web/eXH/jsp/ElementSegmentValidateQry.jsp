<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>

<%-- Mandatory declarations end --%> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%

		Connection connection	= null;
		Statement statement		= null;
		ResultSet resultSet		= null;

try {


		int errFlag				= 0;
		String exceptions		= "";

		String func_mode			= request.getParameter("func_mode");
			//System.out.println("ElementSegmentValidateQryN : "+func_mode);
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_name			= (String) hash.get( "bean_name" );
			//System.out.println("ElmntSgmntValidQry bean_name : "+bean_name);
		ElementSegmentConfBean beanObj		= (ElementSegmentConfBean)ElementSegmentConfBean.getBean(bean_name,request,session);

		//System.out.println("ElementSegmentValidateQry beanObj: "+beanObj);

		if(func_mode!= null && func_mode.equals("setTables")) {
			String mod_name		 = (String) hash.get( "base_unit" );
			//System.out.println("ElementSegmentValidateQry mod_name: "+mod_name);
			ArrayList tblNames	 = beanObj.getTables(mod_name);
	
			out.println("clearTables()");
			for(int i=0; i<tblNames.size(); i+=1) {
				String desc	=	(String)tblNames.get(i);
				out.println("addTable('"+desc+"','"+desc+"')");
			}
		}

		if(func_mode!= null && func_mode.equals("getStndCode")) {
			String stnd_code  = "";
			String stnd_desc = ""; 
			String conf_name		 = (String) hash.get( "conf_name" );
				//System.out.println("ElementSegmentValidateQryN conf_name: "+conf_name);
			ArrayList stndRslt = (ArrayList)beanObj.getStndCode(conf_name);
			if(stndRslt.size()>0){
				stnd_code = (String)stndRslt.get(0);
				stnd_desc = (String)stndRslt.get(1);
			}

			out.println("addStndCode('"+stnd_code+"','"+stnd_desc+"')");
		}


		if(func_mode!= null && func_mode.equals("setCols")) {
			String tbl_name		 = (String) hash.get( "base_unit" );
			HashMap colRslt	 = beanObj.getCols(tbl_name);

			ArrayList colNames	=	(ArrayList)colRslt.get("colNames");
			ArrayList colTypes	=	(ArrayList)colRslt.get("colTypes");
			
			out.println("clearCols()");
			for(int i=0,j=0; i<colNames.size(); i+=1,j+=1) {
				String desc	=	(String)colNames.get(i);
				String type =	(String)colTypes.get(j);
				out.println("addColumn('"+type+"','"+desc+"')");
			}
		}


		if(func_mode!= null && func_mode.equals("validateQry")) {
			String qResult		 = (String) hash.get( "qResult" );
			String qryText		 = (String) hash.get( "qryText" );
			String SysdefS		 = (String) hash.get( "SystDefStructure" );

	//		System.out.println("ElementSegmentValidateQryN qResult: "+qResult);
	//		System.out.println("ElementSegmentValidateQryN qryText: "+qryText);	
	//		System.out.println("ElementSegmentValidateQryN SysdefS: "+SysdefS);
			
		try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
		}

		try{		
		    statement = connection.createStatement();
			resultSet = statement.executeQuery(qResult);  
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				//System.out.println(" ElementSegmentValidateQry errFlag : "+errFlag);
				exceptions = java.net.URLEncoder.encode(exceptions);
				qryText = java.net.URLEncoder.encode(qryText);
				SysdefS = java.net.URLEncoder.encode(SysdefS);
				out.println("parent.setErrorTxt('"+exceptions+"','"+errFlag+"','"+qryText+"','"+SysdefS+"')");
		}
		} // end of if
		

	}
	catch (Exception e) {
		e.printStackTrace() ;
	}
		finally{
			try{
			     if(resultSet!=null) resultSet.close();
				 if(statement!=null) statement.close();
			}catch(Exception es){
				es.printStackTrace() ;
			}
				if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}
		}



%>
