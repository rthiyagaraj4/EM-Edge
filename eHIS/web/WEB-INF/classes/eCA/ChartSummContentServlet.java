/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
01/03/2013	IN035924	  Karthi L	 	CA View chart summary “RESULT WIDGET” should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)

-----------------------------------------------------------------------------------------------
*/

package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class ChartSummContentServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

        PrintWriter out					= res.getWriter();
		Connection conn					= null;
		PreparedStatement uptd_pstmt	= null;
		
		java.util.Properties p;
		HttpSession httpsession	= req.getSession(false);
		p	= (Properties)httpsession.getValue("jdbc");
		
		String locale = (String) p.getProperty("LOCALE");

		boolean bUpdFlag = true;
		
		try
		{
			int i=0,rows_uptd = 0;
			String rowCnt = req.getParameter("rowCnt");
			String cont_id = "",cont_desc = " ";
			String disp_scope_ind = ""; // added for CHL-CRF -018 IN035924
			String no_enc_disp = "";  // added for CHL - CRF -018 IN035924
			int enc_counter = 0; // added for CHL-CRF -018 IN035924
			if(rowCnt == null)
				rowCnt="0";

			StringBuffer update_qry = new StringBuffer();
			
			if(update_qry.length() > 0) 
				update_qry.delete(0,update_qry.length());

			update_qry.append(" update ca_chart_summ_content set"); 
		//	update_qry.append(" content_userdef_desc = ? where"); // commented for BRU-CRF - 018 IN035924
			update_qry.append(" content_userdef_desc = ? ,display_scope_ind = ? , no_enc_display = ? where"); // modified for BRU-CRF - 018 IN035924
			update_qry.append(" content_id = ?" );
			
			int rowCount = Integer.parseInt(rowCnt);
			
			conn = ConnectionManager.getConnection(req);
			uptd_pstmt = conn.prepareStatement(update_qry.toString());
			
			for(i = 1;i <= rowCount;i++)
			{
				cont_desc	= req.getParameter("content_userdef_desc_txt"+i);
				cont_id		= req.getParameter("content_id"+i);
				disp_scope_ind = req.getParameter("scope_to_choose"+i); // added for BRU-CRF - 018 - Start IN035924
				no_enc_disp = req.getParameter("scope_of_data"+i);
				
				if (no_enc_disp != null && !(no_enc_disp.equals("null")) && !(no_enc_disp.equals("")))
				{
					enc_counter = Integer.parseInt(no_enc_disp ); 
				}
				
				if(disp_scope_ind == null || disp_scope_ind.equals("null") || disp_scope_ind.equals("")) 
				{
					disp_scope_ind="D";
					enc_counter = 0;
				}
				
				if( disp_scope_ind.equals("D"))
				{	
						enc_counter = 0;
				}
				// added for BRU-CRF - 018 - End IN035924
				
				if(cont_id == null || cont_id.equals("null"))
					cont_id="";
				
				if(cont_desc == null || cont_desc.equals("null"))
					cont_desc="";
				
				uptd_pstmt.setString(1, cont_desc.trim());
				uptd_pstmt.setString(2, disp_scope_ind);
				uptd_pstmt.setInt(3, enc_counter);
				uptd_pstmt.setString(4, cont_id.trim());
				
				rows_uptd = uptd_pstmt.executeUpdate();
				
				if (rows_uptd < 0)
				{
					if(bUpdFlag)
						bUpdFlag = false;
				}
			}
			
			String error_value	= "0" ;
			String error		= "";
			if (bUpdFlag)
			{
				conn.commit();
				error_value			= "1" ;
				error				=  getMessage(locale, "RECORD_INSERTED", "CA") ;
			}
			else
			{
				conn.rollback();
				error				=  getMessage(locale, "TRANSACTION_FAILED", "CA") ;
			}
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			if(uptd_pstmt!=null) uptd_pstmt.close();
		}
		catch(Exception euptd)
		{
			//out.println("Exception @ Update :"+euptd);//common-icn-0181
			euptd.printStackTrace();
		}
		finally
		{
			if(conn!=null) ConnectionManager.returnConnection(conn, req);
		}
	}
	
	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
}
