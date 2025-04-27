/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import eOA.Holiday.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.RecordSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0165

public class HolidayServlet extends HttpServlet
{
    public HolidayServlet()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        HttpSession httpsession = httpservletrequest.getSession(false);
        facilityId = (String)httpsession.getValue("facility_id");
		p = (Properties)httpsession.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		httpservletrequest = new XSSRequestWrapper(httpservletrequest);
		httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
		httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
        try
        {
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function_name");
			


            if(s.equals("insert"))
			{
                insertHoliday(httpservletrequest, httpservletresponse);
			}
            if(s.equals("modify"))
			{
                modifyHoliday(httpservletrequest, httpservletresponse);
			}
            if(s.equals("delete"))
			{
                deleteHoliday(httpservletrequest, httpservletresponse);
			}
			if(s.equals("insertlocntype"))
			{
                insertlocntypeHoliday(httpservletrequest, httpservletresponse);
			}


        }
        catch(Exception exception)
        {
            //out.println(exception.toString());
			exception.printStackTrace();
        }
    }

    public void doGet(HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
            httpservletresponse.setContentType("text/html;charset=UTF-8");
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'\tsrc='../eCommon/jsp/commonToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'\tsrc='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { 
			// out.println(exception.toString());
			 exception.printStackTrace();
		}
    }

    private void modifyHoliday(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
			String locale = p.getProperty("LOCALE");
           
            holidaydate = httpservletrequest.getParameter("holiday");
			careLocnTypeInd=httpservletrequest.getParameter("locationType");
			clinics=httpservletrequest.getParameter("b_clinic");
            reasonforholiday = httpservletrequest.getParameter("reason_for_holiday");
			
			holidaydate=DateUtils.convertDate(holidaydate,"DMY",locale,"en");
			

          	java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("holidaydate",holidaydate);
			passObjects.put("reasonforholiday",reasonforholiday);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("careLocnTypeInd",careLocnTypeInd);
			passObjects.put("clinics",clinics);
		

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Holiday",HolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		    String s = (String)results.get("error");
            out.println("<script>parent.frames[1].onSuccess1();</script>");
            out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
			results.clear();
			passObjects.clear();
        }
        catch(Exception exception)
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            //out.println("Values sent are : <br>");
            //out.println(holidaydate + " " + reasonforholiday);
			exception.printStackTrace();
        }
    }

    private void insertHoliday(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse){ 
		try{
			RecordSet  	holidayvaldate  =null;
			//RecordSet  	holidayvaldate_reason  =null;
			HttpSession httpsession = httpservletrequest.getSession(false);
			String	from					=	"",	  to	=	"";
			String removeCode = "";
			String clinic_code="";
			String locale = p.getProperty("LOCALE");
			String fromDate="";
			String toDate="";
			String reason_for_holiday="";		
			from							=   (httpservletrequest.getParameter("from")  ==null)? "0" : httpservletrequest.getParameter("from");
			to								=   (httpservletrequest.getParameter("to")    ==null)	? "0" : httpservletrequest.getParameter("to");
			careLocnTypeInd=httpservletrequest.getParameter("locationType");
			clinic_code=checkForNull(httpservletrequest.getParameter("b_clinic"));
			fromDate=checkForNull(httpservletrequest.getParameter("holiday"));
			toDate=checkForNull(httpservletrequest.getParameter("holiday_end"));
			reason_for_holiday=checkForNull(httpservletrequest.getParameter("reason_for_holiday"));
			java.util.HashMap passObjects = new java.util.HashMap();
			String checkedOnes="";
			String checkedOnes1="";
			String reason_val="";
			String finalval="";
			String slCount_reason	 ="";
			//	String s2 ="APP-OA0058 No records selected";
			java.util.Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_INSERTION", "OA");
			String err = ((String) message.get("message"));
			if(!clinic_code.equals("*A")){
				holidayvaldate				=	(webbeans.eCommon.RecordSet)httpsession.getAttribute("holidayvaldate");
				//holidayvaldate_reason =	(webbeans.eCommon.RecordSet)httpsession.getAttribute("holidayvaldate_reason");
				if(from != null && to != null){
					from							=	from.trim();
					to								=	to.trim();
					for(int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++){
						if(httpservletrequest.getParameter(("select_yn"+i)) != null){
							checkedOnes = httpservletrequest.getParameter(("select_yn"+i));
							checkedOnes1 = httpservletrequest.getParameter("val"+(i));
							reason_val=httpservletrequest.getParameter("reason_for_holiday"+(i));
							finalval=checkedOnes1+"|"+reason_val;
							if(!(holidayvaldate.containsObject(finalval))){
								holidayvaldate.putObject(finalval);
								//holidayvaldate_reason.putObject(finalval);
							}
						}
						removeCode = checkForNull(httpservletrequest.getParameter("removeCode"+(i)));
						String str="";
						if(removeCode.equals("Y")){
							String Code = httpservletrequest.getParameter("Code"+(i));
							for(int index=0;index<holidayvaldate.getSize();index++){
								str=(String)(holidayvaldate.getObject(index));
								if(str.contains(Code)){
									holidayvaldate.removeObject(index);
								}
							}
							/*if((holidayvaldate.containsObject(Code)))
							{
							   int removeCodeIndex = holidayvaldate.indexOfObject(Code);
								holidayvaldate.removeObject(removeCodeIndex);
								//holidayvaldate_reason.removeObject(removeCodeIndex);
							}*/
						}
					}
				}
				slCount_reason	 =	""+holidayvaldate.getSize();	
				if(holidayvaldate.getSize() >0){
					for(int i=0;i<holidayvaldate.getSize();i++){
						passObjects.put(("select_yn"+i), (String)holidayvaldate.getObject(i));
						passObjects.put(("chk_val"+i), (String)holidayvaldate.getObject(i));
					}
				}else{
					out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num="+ URLEncoder.encode(err,"UTF-8") + "\"</script><body class='message'></html>");
				}
				passObjects.put("totCount", new Integer(slCount_reason) );
			}
          	boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Holiday",HolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			java.util.HashMap results;
          	passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("careLocnTypeInd",careLocnTypeInd);
			passObjects.put("facilityId",facilityId);
			passObjects.put("clinic_code", clinic_code );
			passObjects.put("fromDate",fromDate);
			passObjects.put("toDate",toDate);
			passObjects.put("reason_for_holiday",reason_for_holiday);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			results = (java.util.HashMap)(busObj.getClass().getMethod("insertHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue();
			String err1 = (String)results.get("error");
			//err1="APP-OA0001 Operation Completed Successfully";
			//java.util.Hashtable message1 = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
	    	//err1 = ((String) message1.get("message1"));

	        if(flag){
                String s4 = "1";
                out.println("<html><script>parent.frames[1].onSuccesslocn();location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(err1,"UTF-8") + "&err_value=" + s4 + "\"</script><body class='message'></html>");
            }else{
                out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(err1,"UTF-8") + "\"</script><body class='message'></html>");
            }
			results.clear();
			passObjects.clear();
			message.clear();
			//	message1.clear();
        }catch(Exception exception){

			exception.printStackTrace();
        }
    }

private void insertlocntypeHoliday(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse){ 
		try
        {
			
			RecordSet  	holidayval  =null;
			HttpSession httpsession = httpservletrequest.getSession(false);
			String	from					=	"",	  to	=	"";
			String removeCode = "";
			String locale = p.getProperty("LOCALE");
			String clinic_code="";
			String fromDate="";
			String toDate="";
			from							=   (httpservletrequest.getParameter("from")  ==null)? "0" : httpservletrequest.getParameter("from");
			to								=   (httpservletrequest.getParameter("to")    ==null)	? "0" : httpservletrequest.getParameter("to");

			
			careLocnTypeInd=httpservletrequest.getParameter("location_type");
			clinic_code=checkForNull(httpservletrequest.getParameter("b_clinic"));

			fromDate=checkForNull(httpservletrequest.getParameter("holiday"));
			toDate=checkForNull(httpservletrequest.getParameter("holiday_end"));
			String reason_for_holiday=checkForNull(httpservletrequest.getParameter("reason_for_holiday"));
			String checkedOnes="";
			String checkedOnes1="";
			if(toDate.equals("")){
				toDate=fromDate;
			}
		
			//String s2 ="APP-OA0058 No records selected";
			java.util.Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_INSERTION", "OA");
			String err = ((String) message.get("message"));
			java.util.HashMap passObjects = new java.util.HashMap();
			if(!clinic_code.equals("*A")){
			holidayval				=	(webbeans.eCommon.RecordSet)httpsession.getAttribute("holidayval");
			
			

			

			if(from != null && to != null)
			{
				from							=	from.trim();
				to								=	to.trim();
				for(int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
				
					if(httpservletrequest.getParameter(("select_yn"+i)) != null)
					{
						checkedOnes = httpservletrequest.getParameter(("select_yn"+i));
						checkedOnes1 = httpservletrequest.getParameter("val"+(i));

					

						if(!(holidayval.containsObject(checkedOnes1)))
						{
						   holidayval.putObject(checkedOnes1);
							
						}
						
					}
				
					removeCode = checkForNull(httpservletrequest.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
					{
						String Code = httpservletrequest.getParameter("Code"+(i));
						if((holidayval.containsObject(Code)))
						{
							   int removeCodeIndex = holidayval.indexOfObject(Code);
								holidayval.removeObject(removeCodeIndex);
						}
					}
				}
			}
			
			String slCount		 =	""+holidayval.getSize();	

			
			if(holidayval.getSize() >0)
			{
			for(int i=0;i<holidayval.getSize();i++)
			{
				//String chk_val= (String)holidayval.getObject(i);
				passObjects.put(("select_yn"+i), (String)holidayval.getObject(i));
				passObjects.put("chk_val"+i,(String)holidayval.getObject(i));

			}
			}else
			{
					out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num="+ URLEncoder.encode(err,"UTF-8") + "\"</script><body class='message'></html>");
			}

			passObjects.put("totCount", new Integer(slCount) );
			}else{
			careLocnTypeInd=checkForNull(httpservletrequest.getParameter("locationType"));
			}
          	boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Holiday",HolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			java.util.HashMap results;
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("careLocnTypeInd",careLocnTypeInd);
			passObjects.put("reason_for_holiday",reason_for_holiday);
			passObjects.put("clinic_code", clinic_code );
			passObjects.put("fromDate",fromDate);
			passObjects.put("toDate",toDate);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			results = (java.util.HashMap)(busObj.getClass().getMethod("insertlocntypeHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			 boolean flag = ((Boolean)results.get("status")).booleanValue();

           String err1 = (String)results.get("error");
			//err1="APP-OA0001 Operation Completed Successfully";
            if(flag)
            {
                String s4 = "1";
                out.println("<html><script>parent.frames[1].onSuccesslocn();location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(err1,"UTF-8") + "&err_value=" + s4 + "\"</script><body class='message'></html>");
            } else
            {
                out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(err1,"UTF-8") + "\"</script><body class='message'></html>");
            }
			
			results.clear();
			passObjects.clear();
		//	message1.clear();
		}catch(Exception e){

			e.printStackTrace();
		}finally{
		}
	}
    private void deleteHoliday(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {	String mode="";

        try{		
			String locale = p.getProperty("LOCALE");
			String prevnextsub="";
			String whereClause1="";
			String fmode="";
			String clinic_code="";
			String clinic_desc="";
			String holiday_date="";
			String locn_type="";
			String orderCols="";
			mode=httpservletrequest.getParameter("fromWhere")==null?"":httpservletrequest.getParameter("fromWhere");
			prevnextsub=httpservletrequest.getParameter("prevnextsubm")==null?"N":httpservletrequest.getParameter("prevnextsubm");
			whereClause1=httpservletrequest.getParameter("whereClause1")==null?"":httpservletrequest.getParameter("whereClause1");
			fmode=httpservletrequest.getParameter("fmode")==null?"":httpservletrequest.getParameter("fmode");
			clinic_code=httpservletrequest.getParameter("clinic_code")==null?"":httpservletrequest.getParameter("clinic_code");
			clinic_desc=httpservletrequest.getParameter("clinic_desc")==null?"":httpservletrequest.getParameter("clinic_desc");
			holiday_date=httpservletrequest.getParameter("holiday_date")==null?"":httpservletrequest.getParameter("holiday_date");
			locn_type=httpservletrequest.getParameter("locn_type")==null?"":httpservletrequest.getParameter("locn_type");
			orderCols=httpservletrequest.getParameter("orderCols")==null?"":httpservletrequest.getParameter("orderCols");
			if (!mode.equals("multipleDelete")){
            holidaydate = httpservletrequest.getParameter("holiday_date");
			holidaydate=DateUtils.convertDate(holidaydate,"DMY",locale,"en");
			careLocnTypeInd=httpservletrequest.getParameter("locationType");
			clinics=httpservletrequest.getParameter("b_clinic");
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("holidaydate",holidaydate);
			passObjects.put("facilityId",facilityId);
			passObjects.put("careLocnTypeInd",careLocnTypeInd);
			passObjects.put("clinics",clinics);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Holiday",HolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;				
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s = (String)results.get("error");
            if(flag){
                //out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "&err_value=1\"</script>");
				//out.println("<script>parent.f_query_add_mod.location.href='../eCommon/html/blank.html'</script>");
				//out.println("<script>parent.f_query_add_mod1.location.href='../eCommon/html/blank.html'</script>");
                //out.println("<script>alert('"+s+"')</script>");
				out.println("<script>parent.f_query_add_mod.prevnextsubmission('"+flag+"','"+clinic_code+"','"+clinic_desc+"','"+holiday_date+"','"+locn_type+"','"+orderCols+"','"+prevnextsub+"');</script>");
				//out.println("<script>parent.f_query_add_mod.location.href='"+url+"';</script>");				
            } else {
                s = (String)results.get("error");
                out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
            }
			passObjects.clear();
			results.clear();
            //out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
			}else if (mode.equals("multipleDelete")){
				HttpSession session = httpservletrequest.getSession(false);
				selectedHolidays=new ArrayList();
				//String final_val= (String) session.getValue("sel_val2");
				String currSelectedValues=httpservletrequest.getParameter("selectedValues");
				int currPage=0;		
				selectedHolidays.add(currPage,currSelectedValues);
				int count=0;
				for(int i=0;i< selectedHolidays.size();i++){
					String temp=(String)selectedHolidays.get(i);
					if (temp.equals("")) count++;
					}
				if (selectedHolidays.size()==count){
				String	tempS="No Records are selected For Delete";
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(tempS,"UTF-8") + "\"</script>");
			}else{
				holidaydate = httpservletrequest.getParameter("holiday_date");
				java.util.HashMap passObjects = new java.util.HashMap(); 
				passObjects.put("facilityId",facilityId);
				passObjects.put("selectedHolidays",selectedHolidays);
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Holiday",HolidayManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = passObjects;
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = passObjects.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteMultipleHolidays",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean flag = ((Boolean)results.get("status")).booleanValue();
				String s = (String)results.get("error");
				if(flag){
					//out.println("<script>parent.f_query_add_mod.location.href='../eCommon/html/blank.html'</script>");
					//out.println("<script>parent.f_query_add_mod1.location.href='../eCommon/html/blank.html'</script>");
					//out.println("<script>alert('"+s+"')</script>");
					out.println("<script>parent.f_query_add_mod.prevnextsubmission('"+flag+"','"+clinic_code+"','"+clinic_desc+"','"+holiday_date+"','"+locn_type+"','"+orderCols+"','"+prevnextsub+"');</script>");
					//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "&err_value=1\"</script>");
				} else
				{
					s = (String)results.get("error");
				   // out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
					
				}
				//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
				passObjects.clear();
				results.clear();
				session.removeAttribute("selVals");
				session.removeAttribute("selVals1");
			}//count if		
		}//elsif		
	}catch(Exception exception){ 
		//out.println(exception.getMessage());
		//out.println(exception.toString());
		exception.printStackTrace();
    }
}
public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
    PrintWriter out;
    Properties p;
    String facilityId;
    String client_ip_address;
    String holidaydate;
    String holiday_end;
    String reasonforholiday;
	String careLocnTypeInd="";
    String clinics="";
	ArrayList selectedHolidays=null;
	//HttpSession session;


}
