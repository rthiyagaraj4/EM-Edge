<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210129            7339  	       	MOHE-CRF-0050		           Mohana Priya K
-->

<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,org.json.simple.JSONObject,org.json.simple.JSONArray,java.io.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt	= null;
	ResultSet rs = null;
	CallableStatement cstmt = null;

	try
	{
		//con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		java.util.Properties p=null;
		p = (java.util.Properties) session.getValue( "jdbc" );
		String WS_NO  = p.getProperty("client_ip_address");
		System.err.println("Parmas passed from Ajax   "+request.getQueryString());
		String facility_id=request.getParameter("facility_id") == null ? "" :request.getParameter("facility_id") ;
		String selectall=request.getParameter("selectall") == null ? "N" :request.getParameter("selectall");
		String servGpCode=request.getParameter("servGpCode") == null ? "N" :request.getParameter("servGpCode");
		String p_serv_ind=request.getParameter("p_serv_ind") == null ? "" :request.getParameter("p_serv_ind");
		String user=request.getParameter("user") == null ? "" :request.getParameter("user");
		String sqlStr="";
		String param1=request.getParameter("servCodeDesc") == null ? "" :request.getParameter("servCodeDesc");
		System.err.println("selectall-"+selectall+" facility_id-"+facility_id+" servGpCode-"+servGpCode+" p_serv_ind-"+p_serv_ind+" user-"+user);
		System.err.println("param1->"+param1);
		System.err.println("select-->"+request.getParameter("selectall"));
		
		String[] arrOfStr = param1.split("@");		
		for(int i=0;i<arrOfStr.length;i++){
			con = ConnectionManager.getConnection(request);
			
			String[] str=arrOfStr[i].split("~");
				String p_serv_item=str[0];
				
		 		cstmt=con.prepareCall("{ call bl_daily_cash_delv_rep. proc_associt_service (?,?,?,?,?,?,?,?,?,?)}");	
				cstmt.setString(1,selectall);
				cstmt.setString(2,facility_id);
				cstmt.setString(3,servGpCode);
				cstmt.setString(4,p_serv_item);
				cstmt.setString(5,p_serv_ind);
				cstmt.setString(6,user);
				cstmt.setString(7,WS_NO);		
				
				System.err.println("1, selectall id-"+selectall);
				System.err.println("2, facility_id-"+facility_id);
				System.err.println("3, servGpCode-"+servGpCode);
				System.err.println("4, p_serv_item-"+p_serv_item);
				System.err.println("5, p_serv_ind-"+p_serv_ind);
				System.err.println("6, user-"+user);
				System.err.println("7, WS_NO-"+WS_NO);
				System.err.println("next params "+i);
				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.execute();
				str[0]="";
				con.close();
		}
				String messageId=cstmt.getString(9);
				String messageText=cstmt.getString(10);
	
				System.err.println("messageText  "+messageText);
				
				String returnValue= "";
				if(messageId != null || messageText != null){
					if(messageId != null && messageText != null){
						returnValue = "::"+messageText+"~"+messageId+"~";
					}else if(messageId != null &&  messageText == null){
						returnValue = "~"+messageId+"~";
					}else{
						returnValue = "::"+messageText+"~";
					}
				}
				else{
					returnValue ="";
				} 
				//String returnValue ="";
				System.err.println("returnValue  "+returnValue);
				out.println(returnValue); 
				}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from Blassocssrvices.jsp "+e);
					//con.rollback();
				}finally{
					//con.close();
				}
	%>
	<%! 
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>
