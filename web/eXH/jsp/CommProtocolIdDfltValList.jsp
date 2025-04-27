<!DOCTYPE html>
   
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=ISO-8859-1"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<% 

		Connection con1		= null;
		Statement stmt1		= null;
		Statement stmt2		= null;
        Statement stmt3		= null;
        ResultSet rst3			= null;
		ResultSet rst1			= null;
		ResultSet rst2			= null;
		String appl_id			= ""; 
		String appl_name		= "";
		String stnd_code		= "";
		String stnd_desc		= "";
		String protocol_id		=	"";
		String func_mode		= request.getParameter("func_mode");
			//System.out.println("AdminOracleJobEvntList func_mode : "+func_mode);
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
       try{
		 if(con1==null)   {
               con1	= ConnectionManager.getConnection(request);
		 }  			

		if(func_mode!= null && func_mode.equals("DefltValList")) {
			int i=0;
			String data_group_id		 = (String) hash.get( "base_unit" );
			String comm_mode1		 = (String) hash.get( "comm_mode" );			
				//System.out.println("CommProtocolIdDfltValList data_group_id : "+data_group_id);
			String sql3="SELECT count(*) FROM xh_data_group_detail WHERE data_group_id='"+data_group_id+"' ";
			try
			{
				stmt3	= con1.createStatement();
				rst3	= stmt3.executeQuery(sql3);
			   while(rst3.next()){
					i=rst3.getInt(1);
				}
				if(i>0){					
					String sql1 = "SELECT a.application_id,b.application_name,a.standard_code,c.standard_desc FROM xh_data_group a, xh_application b,xh_standard c WHERE a.application_id=b.application_id(+) AND 	     a.standard_code=c.standard_code(+) AND data_group_id='"+data_group_id+"'";

				try{	
					stmt2	= con1.createStatement();
					rst2	= stmt2.executeQuery(sql1);			
					while(rst2.next()){
							appl_id    = rst2.getString(1);
						//System.out.println("AdmOrEvntLst appl_id : "+appl_id);
							appl_name  = rst2.getString(2);
						//System.out.println("AdmOrEvntLst appl_name : "+appl_name);
							stnd_code  = rst2.getString(3);
							stnd_desc  = rst2.getString(4);	
		//					prfl_id	   = rst1.getString(5);	
		//					prfl_desc  = rst1.getString(6);	
					}
				}catch(Exception e){
						System.err.println("Err Msg in CommProtocolIdDfltValList.jsp : "+e);
				}finally{
					out.println("setDefltVals('"+appl_id+"','"+appl_name+"','"+stnd_code+"','"+stnd_desc+"','"+comm_mode1+"')");

						if(hash!=null)hash.clear();
						if(rst2!=null)rst2.close();
						if(stmt2!=null)stmt2.close();			
						//ConnectionManager.returnConnection(con1);
				}		
				} // end of i>0
				else{
					String YN="N";
					out.println("setYN('"+YN+"')");
				}
			}
			catch(Exception e){
					System.err.println("Err Msg in CommProtocolIdDfltValList.jsp : "+e);
			}finally{
				//	out.println("setDefltVals('"+appl_id+"','"+appl_name+"','"+stnd_code+"','"+stnd_desc+"')");
				//if(hash!=null)hash.clear();
				if(rst3!=null)rst3.close();
				if(stmt3!=null)stmt3.close();			
				//ConnectionManager.returnConnection(con1);
			}	 	 	 	
		} // end of DefltValList

		else if(func_mode!= null && func_mode.equals("DefltValCheckList")) {
			String protocol		 = (String) hash.get( "base_unit" );
            stmt1	= con1.createStatement();		

 	 	 String sql1 = "SELECT PROTCOL_MODE FROM XH_PROTOCOL where PROTOCOL_ID='"+protocol+"'";
     		try{		
			stmt1	= con1.createStatement();
			rst1	= stmt1.executeQuery(sql1);			
				while(rst1.next()){
						protocol_id    = rst1.getString(1);
				}
			}catch(Exception e){
					System.err.println("Err Msg in CommProtocolIdDfltValList.jsp : "+e);
			}	
			finally{
						out.println("setDefltCheckVals('"+protocol_id+"')");
			}
		} // end of DefltValCheckList

	}
	 catch(Exception e){
		   System.out.println("(CommProtocolIdDfltValList.jsp:Error) :"+e);
	 }
	finally{
			if(hash!=null)hash.clear();
			if(rst1!=null)rst1.close();
			if(stmt1!=null)stmt1.close();			
			ConnectionManager.returnConnection(con1);
	}		



%>
