/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?          		 created

--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import eCA.BallardScore.*;
import javax.rmi.*;

public class BallardScoreServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		java.util.Properties p;
		HttpSession session;
		String sStyle = "";

		out = response.getWriter();
		session = request.getSession(false);

		sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p = (java.util.Properties) session.getValue("jdbc") ;		

		String outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><head><script Language='JavaScript' src='../../eCA/js/CAMessages.js'><script Language='JavaScript' src='../eCA/js/BallardScore.js'></script></script></head><BODY CLASS='MESSAGE'>";
		String outPut2 = "</BODY></html>";
		out.println(outPut1);		
			insertRecords(request,response,out,p,session);
		out.println(outPut2);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	private void insertRecords(HttpServletRequest request,HttpServletResponse response, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		p = (java.util.Properties) session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");
		HashMap hashRecord = new HashMap();
		boolean bool = false;
		
		String patientId = "", encounterId="", facilityId="", practitionerId="", errorMsg="", error_value="";
		String neuromuscular = "", posture = "", squareWindow = "", armRecoil = "", poplitealAngle = "", scarfSign = "", heelToEar = "", Physical = "", skin = "", lanugo = "", plantarSurface = "", breast = "", eyeEar = "", genitalsMale = "", genitalsFemale = "", totalScore="";
		int count =0;
		
		practitionerId 	= (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
		facilityId 		= (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
		patientId 		= request.getParameter("patientId") == null ? "" : (String) request.getParameter("patientId");
		encounterId 	= request.getParameter("encounterId") == null ? "" : (String) request.getParameter("encounterId");
		
		neuromuscular	= request.getParameter("NE") == null ? "" : ((String) request.getParameter("NE")).trim();
		posture			= request.getParameter("PO") == null ? "" : ((String) request.getParameter("PO")).trim();
		squareWindow	= request.getParameter("SQ") == null ? "" : ((String) request.getParameter("SQ")).trim();
		armRecoil		= request.getParameter("AR") == null ? "" : ((String) request.getParameter("AR")).trim();
		poplitealAngle	= request.getParameter("PA") == null ? "" : ((String) request.getParameter("PA")).trim();
		scarfSign		= request.getParameter("SS") == null ? "" : ((String) request.getParameter("SS")).trim();
		heelToEar		= request.getParameter("HE") == null ? "" : ((String) request.getParameter("HE")).trim();
		Physical		= request.getParameter("PM") == null ? "" : ((String) request.getParameter("PM")).trim();
		skin			= request.getParameter("SK") == null ? "" : ((String) request.getParameter("SK")).trim();
		lanugo			= request.getParameter("LA") == null ? "" : ((String) request.getParameter("LA")).trim();
		plantarSurface	= request.getParameter("PS") == null ? "" : ((String) request.getParameter("PS")).trim();
		breast			= request.getParameter("BR") == null ? "" : ((String) request.getParameter("BR")).trim();
		eyeEar			= request.getParameter("EE") == null ? "" : ((String) request.getParameter("EE")).trim();
		genitalsMale	= request.getParameter("GM") == null ? "" : ((String) request.getParameter("GM")).trim();
		genitalsFemale	= request.getParameter("GF") == null ? "" : ((String) request.getParameter("GF")).trim();
		totalScore		= request.getParameter("TT") == null ? "" : ((String) request.getParameter("TT")).trim();
		
		hashRecord.put("practitionerId",practitionerId);		
		hashRecord.put("facilityId",facilityId);
		hashRecord.put("patientId",patientId);
		hashRecord.put("encounterId",encounterId);
		
		if(!"".equals(neuromuscular)){
			hashRecord.put("BCode"+count,"NE");
			hashRecord.put("BValue"+count,Integer.valueOf(neuromuscular));
			count++;
		}		
		if(!"".equals(posture)){
			hashRecord.put("BCode"+count,"PO");
			hashRecord.put("BValue"+count,Integer.valueOf(posture));
			count++;
		}
		if(!"".equals(squareWindow)){
			hashRecord.put("BCode"+count,"SQ");
			hashRecord.put("BValue"+count,Integer.valueOf(squareWindow));
			count++;
		}
		if(!"".equals(armRecoil)){
			hashRecord.put("BCode"+count,"AR");
			hashRecord.put("BValue"+count,Integer.valueOf(armRecoil));
			count++;
		}
		if(!"".equals(poplitealAngle)){
			hashRecord.put("BCode"+count,"PA");
			hashRecord.put("BValue"+count,Integer.valueOf(poplitealAngle));
			count++;
		}
		if(!"".equals(scarfSign)){
			hashRecord.put("BCode"+count,"SS");
			hashRecord.put("BValue"+count,Integer.valueOf(scarfSign));
			count++;
		}
		if(!"".equals(heelToEar)){
			hashRecord.put("BCode"+count,"HE");
			hashRecord.put("BValue"+count,Integer.valueOf(heelToEar));
			count++;
		}
		if(!"".equals(Physical)){
			hashRecord.put("BCode"+count,"PM");
			hashRecord.put("BValue"+count,Integer.valueOf(Physical));
			count++;
		}
		if(!"".equals(skin)){
			hashRecord.put("BCode"+count,"SK");
			hashRecord.put("BValue"+count,Integer.valueOf(skin));
			count++;
		}
		if(!"".equals(lanugo)){
			hashRecord.put("BCode"+count,"LA");
			hashRecord.put("BValue"+count,Integer.valueOf(lanugo));
			count++;
		}
		if(!"".equals(plantarSurface)){
			hashRecord.put("BCode"+count,"PS");
			hashRecord.put("BValue"+count,Integer.valueOf(plantarSurface));
			count++;
		}
		if(!"".equals(breast)){
			hashRecord.put("BCode"+count,"BR");
			hashRecord.put("BValue"+count,Integer.valueOf(breast));
			count++;
		}
		if(!"".equals(eyeEar)){
			hashRecord.put("BCode"+count,"EE");
			hashRecord.put("BValue"+count,Integer.valueOf(eyeEar));
			count++;
		}
		if(!"".equals(genitalsMale)){
			hashRecord.put("BCode"+count,"GM");
			hashRecord.put("BValue"+count,Integer.valueOf(genitalsMale));
			count++;
		}
		if(!"".equals(genitalsFemale)){
			hashRecord.put("BCode"+count,"GF");
			hashRecord.put("BValue"+count,Integer.valueOf(genitalsFemale));
			count++;
		}
		if(!"".equals(totalScore)){
			hashRecord.put("BCode"+count,"TT");
			hashRecord.put("BValue"+count,Integer.valueOf(totalScore));
			count++;
		}		
		hashRecord.put("count",Integer.valueOf(count));
		
		try
		{
			
			
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BallardScore",BallardScoreManager.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[3];

			argArray[0] = p;
			argArray[1] = hashRecord;
			argArray[2] = locale;

			Class paramArray[] = new Class[3];

			paramArray[0] = p.getClass();
			paramArray[1] = hashRecord.getClass();;
			paramArray[2] = locale.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertBallardScore",paramArray)).invoke(busObj,argArray);


			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			bool = ((Boolean)results.get("results")).booleanValue();
			
			if(bool){
				errorMsg= getMessage(locale, "RECORD_INSERTED","CA");
				error_value = "1" ;				
				response.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
				
			}
			
		}
		catch(Exception e)
		{		
			e.printStackTrace();
			//out.println("Exception in try of BallardScoreServlet.java-->" +e.toString());//common-icn-0181
		}
		hashRecord.clear();
	}
	
}
