
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


	//	int errFlag				= 0;
	//	String exceptions		= "";
		try {
		con1	= ConnectionManager.getConnection(request);
		String func_mode			= request.getParameter("func_mode");
			
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;

		if(func_mode!= null && func_mode.equals("evntlist")) {
			String base_param1		 = (String) hash.get( "base_unit1" );
			String base_param2		 = (String) hash.get( "base_unit2" );
//					System.out.println("AdmOrEvntLst base_param1 : "+base_param1);
//					System.out.println("AdmOrEvntLst base_param2 : "+base_param2);
//			String prtcl_link_id		 = (String) hash.get( "base_unit" );
//			String process_id		 = (String) hash.get( "base_unit" );
			String sql1 = "";
				
          if(base_param1.equals("XHGNCRTR") ){

				//				sql1 = "SELECT DISTINCT A.application_id,a.facility_id,A.event_type,f.communication_type,c.interface_module_id,d.application_name, e.interface_desc,f.event_name,g.facility_name FROM xh_data_group_detail A,xh_protocol_link B,xh_protocol c,xh_application d,xh_interface e,xh_event_type f,sm_facility_param g WHERE A.data_group_id=B.data_group_id(+) AND b.protocol_id=c.protocol_id(+)	 AND A.application_id=D.application_id(+) AND c.interface_module_id= e.interface_module_id(+)	 AND A.event_type=f.event_type(+) AND a.facility_id=g.facility_id(+) AND c.interface_module_id=NVL('"+base_param2+"',c.interface_module_id) AND (f.communication_type='O' OR f.communication_type='*')  ORDER BY  a.event_type";

				sql1 = "SELECT DISTINCT '','',A.event_type,f.communication_type,c.interface_module_id,'', e.interface_desc,f.event_name,'' FROM xh_data_group_detail A,xh_protocol_link B,xh_protocol c,xh_application d,xh_interface e,xh_event_type f,sm_facility_param g WHERE A.data_group_id=B.data_group_id(+) AND b.protocol_id=c.protocol_id(+)	 AND A.application_id=D.application_id(+) AND c.interface_module_id= e.interface_module_id(+)	 AND A.event_type=f.event_type(+) AND a.facility_id=g.facility_id(+) AND c.interface_module_id=NVL('"+base_param2+"',c.interface_module_id) AND (f.communication_type='O' OR f.communication_type='*')  ORDER BY  a.event_type";
		   }


 /*        if(process_id.equals("XHGNCRTR") ||  process_id.equals("XHGENMESSAGEBUILDER" ) ){ 
				sql1 = "SELECT event_type  FROM xh_event_type WHERE communication_type in('O','*')  AND interface_yn='Y' ORDER BY 1 ";

		 }
		 else if( process_id.equals("XHGENMESSAGELOADER") ){
			 	sql1 = "SELECT event_type,event_name FROM xh_event_type WHERE communication_type in('I','*') AND event_type!='A19'  AND interface_yn='Y' ORDER BY 1 ";
		 } */
		
		else{
//			 sql1 = "SELECT distinct A.application_id,a.facility_id,A.event_type,c.protcol_mode,c.interface_module_id,d.application_name, e.interface_desc,f.event_name,g.facility_name FROM xh_data_group_detail A,xh_protocol_link B,xh_protocol c,xh_application d,xh_interface e,xh_event_type f,sm_facility_param g WHERE A.data_group_id=B.data_group_id(+) AND b.protocol_id=c.protocol_id(+)	 AND A.application_id=D.application_id(+) AND c.interface_module_id= e.interface_module_id(+)	 AND A.event_type=f.event_type(+) AND a.facility_id=g.facility_id(+) AND B.protocol_link_id=NVL('"+base_param2+"',B.protocol_link_id) ORDER BY  a.event_type";
 			 
			 // Commented for MOHE-SCF-0009
			 //sql1 = "SELECT distinct A.application_id,a.facility_id,A.event_type,c.protcol_mode,c.interface_module_id,d.application_name, e.interface_desc,f.event_name,g.facility_name FROM xh_data_group_detail A,xh_protocol_link B,xh_protocol c,xh_application d,xh_interface e,xh_event_type f,sm_facility_param g WHERE A.data_group_id=B.data_group_id(+) AND b.protocol_id=c.protocol_id(+)	 AND A.application_id=D.application_id(+) AND c.interface_module_id= e.interface_module_id(+)	 AND A.event_type=f.event_type(+) AND a.facility_id=g.facility_id(+) AND B.protocol_link_id in ('"+base_param2+"') ORDER BY  a.event_type";

			// Added for MOHE-SCF-0009 
			sql1 = "SELECT distinct A.application_id,'',A.event_type,c.protcol_mode,c.interface_module_id,d.application_name, e.interface_desc,f.event_name,'' FROM xh_data_group_detail A,xh_protocol_link B,xh_protocol c,xh_application d,xh_interface e,xh_event_type f,sm_facility_param g WHERE A.data_group_id=B.data_group_id(+) AND b.protocol_id=c.protocol_id(+)	 AND A.application_id=D.application_id(+) AND c.interface_module_id= e.interface_module_id(+)	 AND A.event_type=f.event_type(+) AND a.facility_id=g.facility_id(+) AND B.protocol_link_id in ('"+base_param2+"') ORDER BY  a.event_type";
		}
		
		try{	 
		System.out.println("sql1 63: "+sql1);
//			con1	= ConnectionManager.getConnection(request);
			stmt1	= con1.createStatement();
			rst1	= stmt1.executeQuery(sql1);
			int rwCnt = 0;
			
			while(rst1.next()){
				if(rwCnt==0){
					appl_id = XHDBAdapter.checkNull(rst1.getString(1));						
					fac_id = XHDBAdapter.checkNull(rst1.getString(2));
				//	comm_type =XHDBAdapter.checkNull(rst1.getString(4)); 
			         if(base_param1.equals("XHGNCRTR") ){
						mod_id = "";
						mod_name = "";
					 }
					 else{
						mod_id = XHDBAdapter.checkNull(rst1.getString(5));
						mod_name = XHDBAdapter.checkNull(rst1.getString(7));
					 }
   				    evntList.append(XHDBAdapter.checkNull(rst1.getString(3)));

     			appl_name = XHDBAdapter.checkNull(rst1.getString(6)); 
	//				evnt_name = XHDBAdapter.checkNull(rst1.getString(8));
				fac_name = XHDBAdapter.checkNull(rst1.getString(9));			
				}																	  
				else{
					evntList.append(",");
			 		evntList.append(rst1.getString(3));
				}
				rwCnt++;
			}
	}catch(Exception e){
			System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
	}finally{
		
		//	out.println("setEvntList('"+evntList+"')");

		//out.println("setEvntList('"+evntList+"','"+mod_id+"','"+mod_name+"')");

			  out.println("setEvntList('"+evntList+"','"+mod_id+"','"+mod_name+"','"+appl_id+"','"+appl_name+"','"+fac_id+"','"+fac_name+"')");	//out.println("setEvntList('"+appl_id+"','"+fac_id+"','"+evntList+"','"+comm_type+"','"+mod_id+"','"+appl_name+"','"+mod_name+"','"+evnt_name+"','"+fac_name+"')");

			if(rst1!=null)rst1.close();
			if(stmt1!=null)stmt1.close();			
//			ConnectionManager.returnConnection(con1);
	}
			
} // end of  evntlist

if(func_mode!= null && func_mode.equals("getCommMode")) {
			String proc_id		 = (String) hash.get( "base_unit" );
			String comm_mode = "";
			 String sql1 = "SELECT COMMUNICATION_MODE  FROM XH_PROC_ID WHERE  PROC_ID='"+proc_id+"'";

			System.out.println("(AdminOracleJobEvntList.jsp) sqlQuery 116: "+sql1);
			try{	
//				con1	= ConnectionManager.getConnection(request);
				stmt1	= con1.createStatement(); 
				rst1	= stmt1.executeQuery(sql1);
//				int rwCnt = 0;
				
				while(rst1.next()){
						comm_mode = XHDBAdapter.checkNull(rst1.getString(1));
							//System.out.println("AdmOrEvntLst comm_mode : "+comm_mode);
					}
			}catch(Exception e){
					System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
			}finally{
	//				System.out.println("comm_mode  : "+comm_mode);
						out.println("setCommMode('"+comm_mode+"')");
					if(rst1!=null)rst1.close();
					if(stmt1!=null)stmt1.close();			
	//				ConnectionManager.returnConnection(con1);
			}
		} // END OF getCommMode

	 if(func_mode!= null && func_mode.equals("getCommunicationMode")) {
			String proc_id		 = (String) hash.get( "base_unit" );
			String comm_mode = "";
			 String sql1 = "select a.PROTCOL_MODE from xh_protocol a,XH_PROTOCOL_LINK b where a.PROTOCOL_ID=b.PROTOCOL_ID and b.PROTOCOL_LINK_ID='"+proc_id+"'";

			System.out.println("(AdminOracleJobEvntList.jsp) sqlModeQuery 143: "+sql1);
			try{	
//				con1	= ConnectionManager.getConnection(request);
				stmt1	= con1.createStatement(); 
				rst1	= stmt1.executeQuery(sql1);
//				int rwCnt = 0;
				
				while(rst1.next()){
						comm_mode = XHDBAdapter.checkNull(rst1.getString(1));
							//System.out.println("AdmOrEvntLst comm_mode : "+comm_mode);
					}
			}catch(Exception e){
					System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
			}finally{
	//				System.out.println("comm_mode  : "+comm_mode);
						out.println("setCommunicationMode('"+comm_mode+"')");
					if(rst1!=null)rst1.close();
					if(stmt1!=null)stmt1.close();			
	//				ConnectionManager.returnConnection(con1);
			}
		} // END OF getCommMode

		

		}
		catch(Exception e){
					System.err.println("Err2 Msg in AdminOracleJobProcessAction.jsp : "+e);
		}finally{
					ConnectionManager.returnConnection(con1);
		}

%> 
