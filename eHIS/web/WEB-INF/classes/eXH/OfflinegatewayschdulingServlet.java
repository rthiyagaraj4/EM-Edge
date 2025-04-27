/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import javax.servlet.http.*;
import javax.servlet.*;
/**
 *  Class used to update the  communication settings for application setup
 *
 */
public class OfflinegatewayschdulingServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for  communication settings for application
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;
		HttpSession session = request.getSession(false);
		Properties p;		
  		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");

        req.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
       
	    String strNonTabData[][] = new String[10][9];
        String strNeededData[][] = null;
       
		CallableStatement oraclecallablestatement = null;
		Connection con = null;
		ArrayList arrAudit=new ArrayList();
		String Protocol_link="";
	    String type = "";
        String month = "";
        String day = "";
        String datenumber = "";
        String from_sleep_time = "";
		String to_sleep_time = "";
		String mode = "";
        String rowid = "";
        String status = "0";
        String sStyle = "";
		String Resultvalue="";

       try
        {
           out.println("<head>");
           sStyle =
           (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
           out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
           out.println("</head>");
           out.println("<body class='MESSAGE'>");      
        }
        catch(Exception exq)
        {
			out.println("Error in dopost method of Offline schduling ParametersServlet :"+exq.toString());
		    exq.printStackTrace(System.err); 
		 
        }

        mode= XHDBAdapter.checkNull(request.getParameter("mode"));

        Protocol_link=XHDBAdapter.checkNull(request.getParameter("Protocol_Link_id"));

		type = XHDBAdapter.checkNull(request.getParameter("type"));
	    month = XHDBAdapter.checkNull(request.getParameter("month"));  
		MessageManager mm=new MessageManager();
		    int iSize = 0;
			day = XHDBAdapter.checkNull(request.getParameter("day"));
			datenumber = XHDBAdapter.checkNull(request.getParameter("datenumber"));
			from_sleep_time = XHDBAdapter.checkNull(request.getParameter("from_sleep_time"));
			to_sleep_time = XHDBAdapter.checkNull(request.getParameter("to_sleep_time"));
			rowid = XHDBAdapter.checkNull(request.getParameter("rowid"));
			//arrAudit = AuditInfo.getArrayAuditInfo(session);
            strNonTabData[iSize][0] = mode;
            strNonTabData[iSize][1] =Protocol_link;
			strNonTabData[iSize][2] = type;
		    strNonTabData[iSize][3] = month;
	        strNonTabData[iSize][4] = day;
		    strNonTabData[iSize][5] = datenumber;
			strNonTabData[iSize][6] = from_sleep_time;
			strNonTabData[iSize][7] = to_sleep_time;
			strNonTabData[iSize][8] = rowid;
	       
	     	strNeededData = new String[10][9];
		//	  System.out.println("mode"+mode+"Protocol_link"+Protocol_link+"type"+type+"month"+month+"day"+day+"datenumber"+datenumber+"from_sleep_time"+from_sleep_time+"to_sleep_time"+to_sleep_time+"rowid"+rowid);
    
		try{
			con = ConnectionManager.getConnection();
			arrAudit = AuditInfo.getArrayAuditInfo(session);
			oraclecallablestatement = con.prepareCall("{call Xg_prc.xh_gateway_sleep_param(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            /*String  usr_added_by_id=(String)arrAudit.get(0);
		    String  usr_added_at_ws_no=(String)arrAudit.get(1);
		    String  usr_facility_by_id=(String)arrAudit.get(2);*/
			String usr_added_by_id=(String)session.getAttribute("login_user");
			String usr_facility_by_id = (String) session.getAttribute("facility_id") ;
		    String usr_added_at_ws_no = (String)p.getProperty("client_ip_address");
            oraclecallablestatement.setString(1,mode);
            oraclecallablestatement.setString(2,Protocol_link);
  		    oraclecallablestatement.setString(3,type);
			oraclecallablestatement.setString(4,month);
			oraclecallablestatement.setString(5,day);
		    oraclecallablestatement.setString(6,datenumber);
			oraclecallablestatement.setString(7,from_sleep_time);
		    oraclecallablestatement.setString(8,to_sleep_time);
			oraclecallablestatement.setString(9,rowid);
			oraclecallablestatement.setString(10,"Y");
			oraclecallablestatement.setString(11,usr_added_by_id);
			oraclecallablestatement.setString(12,usr_added_at_ws_no);
			oraclecallablestatement.setString(13,usr_facility_by_id);

			oraclecallablestatement.registerOutParameter(14,java.sql.Types.VARCHAR);
		    oraclecallablestatement.registerOutParameter(15,java.sql.Types.VARCHAR);
			oraclecallablestatement.execute();
		    status = oraclecallablestatement.getString(14);
			Resultvalue = oraclecallablestatement.getString(15);
	//		System.out.println("Status"+status+"Resultvalue"+Resultvalue);
			 if("0".equals(status))
			 {
                con.commit();

				if(mode.equals("D"))
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1034", "XH") ;
	  		    status = ((String) mesg.get("message"));
				 }
				 else
				 {
				 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
			
				 }
             }
			 else
			 {
                con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	            status = ((String) mesg.get("message"));
            
		     }
			if(oraclecallablestatement!=null) oraclecallablestatement.close();
			ConnectionManager.returnConnection(con);
			RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplaySleepParameterResult1.jsp?message="+status+"");
            reqDis.forward(request,response);
		    
			}catch(Exception ex){
			  out.println("Error in calling db related statements in dopost method of OfflinegatewayschdulingServlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
	    	 
			}finally{
			try{
				
			}catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of OfflinegatewayschdulingServlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}

	}// end of do post
}//end of class
}
