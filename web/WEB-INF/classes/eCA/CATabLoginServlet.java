package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
public class CATabLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CATabLoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String login_user= (String)session.getAttribute("login_user");
		String facility_id= (String)session.getAttribute("facility_id");
		boolean isPracSiteSpecific = false;
		response.setContentType("text/html");
		Connection con = null;
		try{
		con = ConnectionManager.getConnection(request);
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CA_TAB_INSU_LOGIN");
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
		if(isPracSiteSpecific){
			if(login_user == null || login_user.trim().equals("")){
				authenticateUser(request,response,session);
			}
			else if(facility_id == null || facility_id.trim().equals("")){
				selectRespFacility(request,response,session);
			}
			else if(login_user != null && !login_user.trim().equals("") && facility_id != null && !facility_id.trim().equals("")){
				selectRespFacility1(request,response,session);
			}
			else{
				authenticateUser(request,response,session);
			}
		}else{
			out.println("<html>");
		    out.println("<head>");
		    out.println("<title></title>");
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Access Denied');");
		    out.println("</script>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("</body>");
		    out.println("</html>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void authenticateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException{
		RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/eCA/jsp/CATabLogin.jsp");
		rd.forward(request, response);
	}
	private void selectRespFacility(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException, IOException{
		//setting  product version and description in session
		Connection conn = null;
		try{
			conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.CUSTOMER_ID CUSTOMER_ID from sm_installation a,sm_site_param b";
			try{
				pstmt = conn.prepareStatement(sql); 
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()){
					session.setAttribute("CUSTOMER_ID", rs.getString("CUSTOMER_ID")==null?"":rs.getString("CUSTOMER_ID"));
					session.setAttribute("version_no",rs.getString("VERSION_NO")==null?"":rs.getString("VERSION_NO"));
					session.setAttribute("product_description",rs.getString("PRODUCT_DESCRIPTION")==null?"":rs.getString("PRODUCT_DESCRIPTION"));
					session.setAttribute("product_name",rs.getString("PRODUCT_NAME")==null?"":rs.getString("PRODUCT_NAME"));
				}
			}
			catch(SQLException e){
				System.out.println("Login: SQL Exception occured while getting product details" +e.toString());
				e.printStackTrace();
			}
			finally{
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
				 ConnectionManager.returnConnection(conn, request);
			}
		}
		catch(Exception e){
			System.out.println("Login: Exception occured while creating connection" +e.toString());
			e.printStackTrace();
		}
		finally{
			if(conn!=null) ConnectionManager.returnConnection(conn, request);
		}
		//Building facility and responsibility list
		String RespFacilityString = request.getParameter("RespFaciList");
		String[] RespFacilityArray;
		String[] RespCountArray = null;
		String[] FacilityCountArray = null;
		String[] RespArray = null;
		String[] FacilityArray = null;
		
		ArrayList<String> RespIdArray = new ArrayList<String>();
		ArrayList<String> RespNameArray = new ArrayList<String>();
		ArrayList<String> FacilityIDArray = new ArrayList<String>();
		ArrayList<String> FacilityNameArray = new ArrayList<String>();
		int RespCount = 0;
		int FacilityCount = 0;
		RequestDispatcher rd;
		if(RespFacilityString!=null && !RespFacilityString.equals("")){
			RespFacilityArray = RespFacilityString.split("==");
			if(RespFacilityArray!=null && RespFacilityArray.length>=2){
				RespCountArray = RespFacilityArray[0].split("\\$\\$");
				FacilityCountArray = RespFacilityArray[1].split("\\$\\$");
			}
				
			if(RespCountArray!=null && RespCountArray.length>=2){
				RespCount = Integer.parseInt(RespCountArray[0]);
				RespArray = RespCountArray[1].split("\\^\\^");
			}
			if(FacilityCountArray!=null && FacilityCountArray.length>=2){
				FacilityCount = Integer.parseInt(FacilityCountArray[0]);
				FacilityArray = FacilityCountArray[1].split("\\^\\^");
			}
			
			if(RespArray!= null){
				for(int i=0; i<RespArray.length; i++){
					String eachRespName_ID[] = RespArray[i].split("~");
					RespIdArray.add(i, eachRespName_ID[0]);
					RespNameArray.add(i, eachRespName_ID[1]);
					
				}
			}
			if(FacilityArray!= null){
				for(int i=0; i<FacilityArray.length; i++){
					String eachFacilityName_ID[] = FacilityArray[i].split("~");
					FacilityIDArray.add(i, eachFacilityName_ID[0]);
					FacilityNameArray.add(i, eachFacilityName_ID[1]);
				}
			}
		}
		
		if(RespCount > 0 && FacilityCount > 0){
			
			if(RespCount == 1 && FacilityCount == 1){
				
				session.setAttribute("responsibility_id", RespIdArray.get(0));
				session.setAttribute("responsibility_name", RespNameArray.get(0));
				session.setAttribute("facility_id", FacilityIDArray.get(0));
				session.setAttribute("facility_name", FacilityNameArray.get(0));
				rd = session.getServletContext().getRequestDispatcher("/eCA/jsp/CATabCommonFrame.jsp");
				rd.forward(request, response);	
			}
			else{
				request.setAttribute("LoginRespIdArray", RespIdArray);
				request.setAttribute("LoginRespNameArray", RespNameArray);
				request.setAttribute("LoginRespCount", RespCount);
				request.setAttribute("LoginFacilityIdArray", FacilityIDArray);
				request.setAttribute("LoginFacilityNameArray", FacilityNameArray);
				request.setAttribute("LoginFacilityCount", FacilityCount);
			}
			Enumeration e = session.getAttributeNames();
			while ( e.hasMoreElements() )
			{
			String key = (String)e.nextElement();
			System.out.print( key + " = " + session.getAttribute( key ) + " <br>" );
			}
			rd = session.getServletContext().getRequestDispatcher("/eCA/jsp/CATabCommonFrame.jsp");
			rd.forward(request, response);	
		}
		else{
			rd = session.getServletContext().getRequestDispatcher("/eCA/jsp/CATabLogin.jsp");
			rd.forward(request, response);	
		}
	}
	private void selectRespFacility1(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException, IOException{
		System.out.println("I am in selectRespFacility1....");
		Connection conn = null;
		try{
			conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.CUSTOMER_ID CUSTOMER_ID from sm_installation a,sm_site_param b";
			try{
				pstmt = conn.prepareStatement(sql); 
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()){
					session.setAttribute("CUSTOMER_ID", rs.getString("CUSTOMER_ID")==null?"":rs.getString("CUSTOMER_ID"));
					session.setAttribute("version_no",rs.getString("VERSION_NO")==null?"":rs.getString("VERSION_NO"));
					session.setAttribute("product_description",rs.getString("PRODUCT_DESCRIPTION")==null?"":rs.getString("PRODUCT_DESCRIPTION"));
					session.setAttribute("product_name",rs.getString("PRODUCT_NAME")==null?"":rs.getString("PRODUCT_NAME"));
				}
			}
			catch(SQLException e){
				System.out.println("Login: SQL Exception occured while getting product details" +e.toString());
				e.printStackTrace();
			}
			finally{
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
				 ConnectionManager.returnConnection(conn, request);
			}
		}
		catch(Exception e){
			System.out.println("Login: Exception occured while creating connection" +e.toString());
			e.printStackTrace();
		}
		finally{
			if(conn!=null) ConnectionManager.returnConnection(conn, request);
		}		
		
		RequestDispatcher rd;
		//System.out.println("-------------->"+request.getParameter("responsibility_id"));
		//System.out.println("-------------->"+request.getParameter("responsibility_name"));
		//System.out.println("-------------->"+request.getParameter("facility_id"));
		//System.out.println("-------------->"+request.getParameter("facility_name"));
		session.setAttribute("responsibility_id", request.getParameter("responsibility_id"));
		session.setAttribute("responsibility_name", request.getParameter("responsibility_name"));
		session.setAttribute("facility_id", request.getParameter("facility_id"));
		session.setAttribute("facility_name", request.getParameter("facility_name"));
		rd = session.getServletContext().getRequestDispatcher("/eCA/jsp/CATabCommonFrame.jsp");
		rd.forward(request, response);
		
	}
}









