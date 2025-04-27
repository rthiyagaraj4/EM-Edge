/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import webbeans.eCommon.ConnectionManager; 
import webbeans.eCommon.*;
import javax.servlet.*;

public class AmendNewinterfaceItemServlet extends HttpServlet
{
	/**
	* Do post method which implements the functionalities  of  Amend New Item Arrivals
	* @param  HttpServletRequest request
	* @param  HttpServletResponse response
	*/

	public void doPost (HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
	{
		int result=0;
		HttpSession session = req.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String query="";
		//req.setCharacterEncoding("UTF-8");
		//res.setContentType("text/html;charset=UTF-8");

		PrintWriter out=res.getWriter();

		Statement s=null;
		Statement st=null;
		Statement suom=null;
		Statement ssale=null;
		
		Connection con = null;
		MessageManager mm=new MessageManager();
		String status="";
		String sStyle = "";
		String query1="";
		int gencount=0;
		int salecount=0;
		int result1=0;

		try
		{     
			out.println("<head>");
			sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("</head>");
			out.println("<body class='MESSAGE'>");      

			con = ConnectionManager.getConnection(req); 

			XIItemcodeElementControllerBean xhBean=XIItemcodeElementControllerBean.getBean(XIItemcodeElementControllerBean.strBeanName,req,session);
			xhBean.action(req,con);

			String strData[][]= xhBean.getDatabaseData();
			s=con.createStatement(); 
			suom=con.createStatement(); 
			ssale=con.createStatement(); 
			st=con.createStatement(); 

			for(int i=0;i<strData.length;i++)  
			{
				if(strData[i][5].toString().trim().equals("Y"))
				{
					ResultSet rs = null;
					ResultSet rssale = null;
					try
					{
						rs=st.executeQuery("select count(*) from XI_UOM where UOM_CODE='"+strData[i][3].toString().trim()+"' ");
						if(rs.next())
						{
							gencount=rs.getInt(1);
						}

						
						if(gencount==0)
						{
							query1="insert into XI_UOM (APPLICATION_ID, FACILITY_ID, EVENT_TYPE, TRX_NO, TRX_DATE, LOAD_STATUS, COMM_STATUS, UOM_CODE,XI_UOM_CODE) values('"+strData[i][6].toString().trim()+"','"+strData[i][7].toString().trim()+"','"+strData[i][8].toString().trim()+"','"+strData[i][9].toString().trim()+"',TO_date('"+strData[i][10].toString().trim()+"','DD/MM/YYYY HH24:MI:SS'),'"+strData[i][11].toString().trim()+"','"+strData[i][12].toString().trim()+"','"+strData[i][3].toString().trim()+"','"+strData[i][13].toString().trim()+"') ";
							result=suom.executeUpdate(query1);
							con.commit();
						}

						rssale=ssale.executeQuery("select count(*) from XI_UOM where UOM_CODE='"+strData[i][4].toString().trim()+"' ");

						if(rssale.next())
						{
							salecount=rssale.getInt(1);
						}

						
						if(salecount==0)
						{
							query1="insert into XI_UOM (APPLICATION_ID, FACILITY_ID, EVENT_TYPE, TRX_NO, TRX_DATE, LOAD_STATUS, COMM_STATUS, UOM_CODE,XI_UOM_CODE) values('"+strData[i][6].toString().trim()+"','"+strData[i][7].toString().trim()+"','"+strData[i][8].toString().trim()+"','"+strData[i][9].toString().trim()+"',TO_date('"+strData[i][10].toString().trim()+"','DD/MM/YYYY HH24:MI:SS'),'"+strData[i][11].toString().trim()+"','"+strData[i][12].toString().trim()+"','"+strData[i][4].toString().trim()+"','"+strData[i][13].toString().trim()+"') ";
							result1=suom.executeUpdate(query1);
							con.commit();
						}

						query="UPDATE XI_ITEM SET GEN_UOM_CODE='"+strData[i][3].toString().trim()+"',SALE_UOM_CODE='"+strData[i][4].toString().trim()+"',COMPLETED_YN='"+strData[i][5].toString().trim()+"' WHERE  ITEM_CODE='"+strData[i][1].toString().trim()+"' ";
		//				System.out.println("update query :"+query);

						result=s.executeUpdate(query);
		//				System.out.println("result :"+result);
					}
					catch(Exception exp)
					{
						System.out.println("(AmendNewinterfaceItemServlet:RetrieveData) Exception: "+exp.getMessage());
						exp.printStackTrace(System.err);
					}
					finally
					{
						if(rssale != null) rssale.close();
						if(rs != null) rs.close();
					}
				}
				else
				{
				}
				if(("1").equals(result+""))
				{
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				//	final java.util.Hashtable mesg = mm.getMessage(con, "XI1001") ;
					status = ((String) mesg.get("message"));
					mesg.clear();
				}
				else
				{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				//	final java.util.Hashtable mesg = mm.getMessage(con, "XI1000") ;
					status = ((String) mesg.get("message"));
					mesg.clear();
				}

			}

			/* out.println("");
			out.println(status);
			out.println("");
			out.println("</body>");  */

			//String status=message_text2;
			RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXI/jsp/DisplayReviewResult.jsp?message="+status+"");
			reqDis.forward(req,res);	

			
		} // end of try
		catch(Exception exception){
			System.out.println("Error in dopost method od AmendNewinterfaceItemServlet:"+exception.toString());
			exception.printStackTrace(System.err); 		
		}
		finally{
		try
		{
			if(s != null) s.close();
			if(suom != null) suom.close();
			if(ssale != null) ssale.close();
			if(st != null) st.close();
			//if(rssale != null) rssale.close();
			//if(rs != null) rs.close();	 
			ConnectionManager.returnConnection(con);

		}catch(Exception ex){
			System.out.println("Eroor in closing dbconnection dopost method of AmendNewinterfaceItemServlet :"+ex.toString());
			ex.printStackTrace(System.err); 
		} 
		}
	}// end of do post
}//end of class
