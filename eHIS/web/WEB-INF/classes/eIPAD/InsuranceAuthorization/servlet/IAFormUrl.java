package eIPAD.InsuranceAuthorization.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.*;
import webbeans.eCommon.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class IAFormUrl
 */
public class IAFormUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IAFormUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String moduleId = request.getParameter("module_id");
		String reportId = request.getParameter("report_id");
		String facilityId = request.getParameter("facility_id");
		String ws_no = request.getParameter("ws_no");
		String report_option = "V";
		String reportServer	= (String) session.getValue( "report_server" ) ;
		String userid		= (String) session.getValue( "report_connect_string" ) ;
		String patient_id = request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id");
		String locale = request.getParameter("locale");
		String strLoggedUser = request.getParameter("login_user_id");
		String params = "SELF_SUBMIT=YES+REPORT_OPTION="+report_option+"+P_PATIENT_ID="+patient_id+"+P_ENCOUNTER_ID="+encounter_id
						+"+P_FACILITY_ID="+facilityId+"+USER_NAME="+strLoggedUser+"+LANGUAGE_ID=EN+P_REPORT_ID="+reportId
						+"+P_MODULE_ID="+moduleId+"+P_LANGUAGE_ID="+locale;
		Connection con=null;
		try{
		con = ConnectionManager.getConnection(request);
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
		cs.setString( 1,	moduleId ) ;
		cs.setString( 2,	reportId ) ;
		cs.setString( 3,	"" ) ;
		cs.setString( 4,	"" ) ;
		cs.setString( 5,	facilityId ) ;
		cs.setString( 6,	ws_no ) ;
		cs.setString( 7,	report_option ) ;
		cs.registerOutParameter( 8,  Types.VARCHAR ) ;
		cs.registerOutParameter( 9,  Types.VARCHAR ) ;
		cs.registerOutParameter( 10, Types.VARCHAR ) ;
		cs.registerOutParameter( 11, Types.VARCHAR ) ;
		cs.registerOutParameter( 12, Types.VARCHAR ) ;
		cs.registerOutParameter( 13, Types.VARCHAR ) ;
		cs.registerOutParameter( 14, Types.VARCHAR ) ;
		cs.registerOutParameter( 15, Types.VARCHAR ) ;
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;
		cs.execute() ;

		String report	= cs.getString( 8 ) ;
		String server	= cs.getString( 9 ) ;
		String app_server_ip = cs.getString( 16 ) ;
		String rep_server_key= cs.getString( 17 ) ;
		if (rep_server_key==null) rep_server_key="";
		InetAddress inetAddr=InetAddress.getByName(app_server_ip);
		String ipAddr = inetAddr.getHostAddress();
		System.out.println("ipAddr: " + ipAddr);
		reportServer = "http://" + app_server_ip + reportServer;
		String url = reportServer + "?server=" + server + "+report=" + report + 
					"+desformat=pdf+destype=cache+recursive_load=no";
		if(rep_server_key == "")
			url = url + "+userid=" + userid;
		else
			url = url + "+cmdkey=" + rep_server_key;
		url = url + "+" + params;
		System.out.println("Url: " + url);
		String json = new Gson().toJson(url);
		session.setAttribute("TabIASelectedReportURL", url);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		if(cs !=null)cs.close() ;
		}catch(Exception e){out.println(e);e.printStackTrace();}
		finally { 
			ConnectionManager.returnConnection(con,request);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
