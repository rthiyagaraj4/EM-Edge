<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210125             7339  	       	MOHE-CRF-0050		           Mohana Priya K
-->

<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,org.json.simple.JSONObject,org.json.simple.JSONArray,java.io.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		LinkedHashMap<String,String> displayServicesValues = new LinkedHashMap<String,String>();
		String fromServItmCode=request.getParameter("fromServItmCode")==null?"":request.getParameter("fromServItmCode");
		String toServItmCode=request.getParameter("toServItmCode")==null?"":request.getParameter("toServItmCode");
		String sqlStr = "";			
		String shrtDescOpt=request.getParameter("shrtDescOpt")==null?"":request.getParameter("shrtDescOpt");
		String searchTxt=request.getParameter("searchTxt")==null?"":request.getParameter("searchTxt");
		String locale=request.getParameter("locale")==null?"":request.getParameter("locale");
		String serv_item_ind=request.getParameter("serv_item_ind")==null?"":request.getParameter("serv_item_ind");
		String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		
		
		sqlStr="SELECT BLNG_SERV_CODE code,SHORT_DESC description FROM   BL_BLNG_SERV_LANG_VW WHERE  BLNG_SERV_CODE BETWEEN nvl('"+fromServItmCode+"', '!!!!!!!!!!') "+
				"AND    nvl('"+toServItmCode+"', '~~~~~~~~~~')  "+
				"AND    SHORT_DESC LIKE DECODE('"+shrtDescOpt+"', 'S', '"+searchTxt+"'||'%','E', '%'||'"+searchTxt+"','C', '%'||'"+searchTxt+"'||'%','N', '%') ESCAPE '^'   "+
				"AND 	 UPPER(LANGUAGE_ID)=UPPER('"+locale+"')  "+
				"AND    '"+serv_item_ind+"'='S'  "+
				"AND    BLNG_SERV_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where  facility_id='"+facility_id+"' and serv_item_ind='"+serv_item_ind+"')  "+
				"UNION  "+
				"SELECT ITEM_CODE code,SHORT_DESC description "+
				"FROM   MM_ITEM_LANG_VW  "+
				"WHERE  ITEM_CODE BETWEEN nvl('"+fromServItmCode+"', '!!!!!!!!!!')  "+
				"AND    nvl('"+toServItmCode+"', '~~~~~~~~~~')  "+
				"AND    SHORT_DESC LIKE DECODE('"+shrtDescOpt+"', 'S', '"+searchTxt+"'||'%','E', '%'||'"+searchTxt+"','C', '%'||'"+searchTxt+"'||'%','N', '%') ESCAPE '^'   "+
				"AND 	  UPPER(LANGUAGE_ID)=UPPER('"+locale+"')  "+
				"AND    '"+serv_item_ind+"'='I'  "+
				"AND    ITEM_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where  facility_id='"+facility_id+"' and serv_item_ind='"+serv_item_ind+"')"+
						" order by code desc";

		pstmt=con.prepareStatement(sqlStr);
		rs= pstmt.executeQuery();
		JSONArray jsonArr = new JSONArray();
		System.err.println("After Execute Query  ");
		//ResultSetMetaData rsmd = rs.getMetaData();
		if(rs != null){
			while(rs.next()){ 
				JSONObject objservices = new JSONObject();	
				objservices.put("code", rs.getString(1));
				objservices.put("description", rs.getString(2));
				jsonArr.add(objservices);
			}
		}
		System.err.println("JSON jsonArr-->"+jsonArr);
		// set the response content-type
		response.setContentType("application/json");
		PrintWriter out1 = response.getWriter();

		// writing the json-array to the output stream
		out1.print(jsonArr);
		out1.flush();
		}
		catch(Exception e)
		{
			System.err.println("Exception in Catch"+e);
			out.println("Exception @ bldisplayserv "+e);
			e.printStackTrace();
		}finally{
			System.err.println("Inside Finally");
			if(rs==null) {
				System.err.println("Result Set is Empty");
			}
			if(rs!=null) {
				 System.err.println("Result Set Not Empty");
				rs.close();
			}
			if(pstmt!=null) 
				pstmt.close();			
			ConnectionManager.returnConnection(con);
		}
	%>
	<%! 
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	%>
