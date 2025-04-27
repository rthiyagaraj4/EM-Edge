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
 * Class used to update Data Element cross reference Non Table values
 */
public class DataElementCrossRefNonTableValuesServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities  of Data Element cross reference Non Table values
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
       
	    String strNonTabData[][] = new String[10][5];
        String strNeededData[][] = null;
       
		CallableStatement oraclecallablestatement = null;
		Connection con = null;
		
      
	    String applicationid = "";
        String nontabelementid = "";
        String nontabmedicomcode = "";
        String nontabcrosscode = "";
        String nontabcrossdesc = "";
        String status = "0";
        String sStyle = "";

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
			out.println("Error in dopost method of dataelementcrossrefnontablevaluesservlet :"+exq.toString());
		    exq.printStackTrace(System.err); 
		 
        }


		applicationid = XHDBAdapter.checkNull(request.getParameter("applicationid"));
	    nontabelementid = XHDBAdapter.checkNull(request.getParameter("nontabelementid"));  
		MessageManager mm=new MessageManager();

		
		int iSize = 0;
		nontabmedicomcode = XHDBAdapter.checkNull(request.getParameter("nontabmedicomcode"));
		nontabcrosscode = XHDBAdapter.checkNull(request.getParameter("nontabcrosscode"));
		nontabcrossdesc = XHDBAdapter.checkNull(request.getParameter("nontabcrossdesc"));
		
        if ((nontabmedicomcode.equals(""))||nontabcrosscode.equals(""))
        {
               
			  // continue;
		} 
      
		strNonTabData[iSize][0] = applicationid;
		strNonTabData[iSize][1] = nontabelementid;
	    strNonTabData[iSize][2] = nontabmedicomcode;
		strNonTabData[iSize][3] = nontabcrosscode;
		strNonTabData[iSize][4] = nontabcrossdesc;
	    strNeededData = new String[10][5];
	      
		try{
			 con = ConnectionManager.getConnection();
			 ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
			 oraclecallablestatement = con.prepareCall("{call XHMAST.data_cross_ref_for_nontab(?,?,?,?,?,?,?,?,?)}");
            
			 String  usr_added_by_id=(String)arrAudit.get(0);
			 String  usr_added_at_ws_no=(String)arrAudit.get(1);
			 oraclecallablestatement.setString(1,applicationid);

//System.out.println("applicationid"+applicationid);

			 oraclecallablestatement.setString(2,nontabelementid);
//System.out.println("nontabelementid"+nontabelementid);
			 oraclecallablestatement.setString(3,nontabmedicomcode);
//System.out.println("nontabmedicomcode"+nontabmedicomcode);
		     oraclecallablestatement.setString(4,nontabcrosscode);
//System.out.println("nontabcrosscode"+nontabcrosscode);
		     oraclecallablestatement.setString(5,nontabcrossdesc);
//System.out.println("nontabcrossdesc"+nontabcrossdesc);
             
			 oraclecallablestatement.setString(6,usr_added_by_id);
			 oraclecallablestatement.setString(7,usr_added_at_ws_no);

			 oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		     oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
			 
             oraclecallablestatement.execute();

			 status = oraclecallablestatement.getString(8);
                 
			 if("0".equals(status))
			 {
                con.commit();
				request.setAttribute("mode","0");
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
	  		  mesg.clear();
             }
			 else
			 {
                request.setAttribute("mode","1"); 
                con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	            status = ((String) mesg.get("message"));
	            mesg.clear();
            
		     }
			//}
		 
			if(oraclecallablestatement!=null) oraclecallablestatement.close();
			ConnectionManager.returnConnection(con);

            request.setAttribute("applicationid",applicationid);
	        request.setAttribute("nontabelementid",nontabelementid);

			RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayDataElementResult.jsp?message="+status+"");
            reqDis.forward(request,response);
            
            arrAudit.clear();
		    
			}catch(Exception ex){
			  out.println("Error in calling db realted statements in dopost method of dataelementcrossrefnontablevaluesservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
	    	 
			}finally{
			try{
				
			}catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of dataelementcrossrefnontablevaluesservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}

	}// end of do post
}//end of class
}
