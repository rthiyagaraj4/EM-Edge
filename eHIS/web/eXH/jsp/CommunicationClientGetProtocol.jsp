
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.XMLStringParser" contentType="text/html;charset=ISO-8859-1" %>
 
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 

		Connection con1	= null;
		Statement stmt1		= null;
		ResultSet rst1		= null;
	    StringBuffer evntList   = new StringBuffer();				    
		String appl_id = "";																					    
		String fac_id = ""; 
		//String comm_type = "";
		String mod_id = "";
		String appl_name = "";
		//String evnt_name = "";
		String mod_name = "";
		String fac_name = "";
		String ProtocolID="";


	//	int errFlag				= 0;
	//	String exceptions		= "";																				   
		try {
		con1	= ConnectionManager.getConnection(request);
		String func_mode			= request.getParameter("func_mode");
			
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
																	 
		if(func_mode!= null && func_mode.equals("getProtocol")) {
			String base_param1		 = (String) hash.get( "base_unit1" );
			String base_param2		 = (String) hash.get( "base_unit2" );
			String base_param3		 = (String) hash.get( "base_unit3" );
//					System.out.println("AdmOrEvntLst base_param1 : "+base_param1);
//					System.out.println("AdmOrEvntLst base_param2 : "+base_param2);
//			String prtcl_link_id		 = (String) hash.get( "base_unit" );
//			String process_id		 = (String) hash.get( "base_unit" );
			String sql1 = "";
				
          																						 


 /*        if(process_id.equals("XHGNCRTR") ||  process_id.equals("XHGENMESSAGEBUILDER" ) ){ 
				sql1 = "SELECT event_type  FROM xh_event_type WHERE communication_type in('O','*')  AND interface_yn='Y' ORDER BY 1 ";

		 }
		 else if( process_id.equals("XHGENMESSAGELOADER") ){
			 	sql1 = "SELECT event_type,event_name FROM xh_event_type WHERE communication_type in('I','*') AND event_type!='A19'  AND interface_yn='Y' ORDER BY 1 ";
		 } */
	
			 sql1 = "SELECT  PROTOCOL_ID From XH_PROTOCOL_LINK where APPLICATION_ID='"+base_param2+"' and PROTOCOL_LINK_ID='"+base_param1+"'   ";
		
		
		try{	 
		//System.out.println(" (CommunicationClientGetProtocol.jsp:sqlProtocolQuery) : "+sql1);
//			con1	= ConnectionManager.getConnection(request);
			stmt1	= con1.createStatement();
			rst1	= stmt1.executeQuery(sql1);
			int rwCnt = 0;
			
			while(rst1.next()){
			ProtocolID=rst1.getString(1);	
			}
	}catch(Exception e){
			System.err.println("Err Msg in CommunicationClientGetProtocol.jsp : "+e);
	}finally{
		
		//	out.println("setEvntList('"+evntList+"')");

		//out.println("setEvntList('"+evntList+"','"+mod_id+"','"+mod_name+"')");

			  out.println("setProtocolId('"+ProtocolID+"','"+base_param3+"')");	  		  	//out.println("setEvntList('"+appl_id+"','"+fac_id+"','"+evntList+"','"+comm_type+"','"+mod_id+"','"+appl_name+"','"+mod_name+"','"+evnt_name+"','"+fac_name+"')");

			if(rst1!=null)rst1.close();
			if(stmt1!=null)stmt1.close();			
//			ConnectionManager.returnConnection(con1);
	}
			
} // end of  evntlist

 // END OF getCommMode

	 

		

		}
		catch(Exception e){
					System.err.println("Err2 Msg in AdminOracleJobProcessAction.jsp : "+e);
		}finally{
					ConnectionManager.returnConnection(con1);
		}

%> 
