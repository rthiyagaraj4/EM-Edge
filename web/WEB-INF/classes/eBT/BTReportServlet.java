/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;
//import ecis.utils.OnlineReport;
//import ecis.utils.OnlineReports;

import java.sql.ResultSet;
import java.sql.Types;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eBT.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

public class BTReportServlet
{

public  synchronized void callReport(HttpServletRequest req, HttpServletResponse res,String facility_id,String pgm_date,String session_id,String languageId)
	{
		try{
				String module_id="BT";
				String report_id="BTRCOLRQ";
				String reportOutput  ="";

					
				ecis.utils.OnlineReport onlinereportParam = new ecis.utils.OnlineReport(facility_id, module_id, report_id);
	


				onlinereportParam.addParameter("p_facility_id",facility_id);
				//eBT.LogFile.log("QADebugger","Entering"+facility_id, this);


				onlinereportParam.addParameter("p_pgm_date",pgm_date);

				//eBT.LogFile.log("QADebugger","Entering"+pgm_date, this);
				onlinereportParam.addParameter("p_pgm_id",report_id);

				//eBT.LogFile.log("QADebugger","Entering"+session_id, this);
				onlinereportParam.addParameter("p_session_id",session_id);


				onlinereportParam.addParameter("p_language_id",languageId);
												
				ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports();

				onlineReports.add(onlinereportParam);


				//eBT.LogFile.log("QADebugger","Addthis process", this);

				//onlineReports.execute(req, res);

				reportOutput = onlineReports.execute(req, res);

				//eBT.LogFile.log("QADebugger","Execute this process", this);

				onlinereportParam = null;
				onlineReports = null;
		}catch(Exception ee)
			{
			System.err.println("eBT Report Servlet "+ee);
		}

		}

}
