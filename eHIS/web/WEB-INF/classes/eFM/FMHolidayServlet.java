package eFM;

import eFM.FMHoliday.*;
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


public class FMHolidayServlet extends HttpServlet{
	PrintWriter out = null;
    Properties p;
    String facilityId;
    String client_ip_address;
	String holidaydate;
	String reasonforholiday;
	ArrayList selectedHolidays=null;
public FMHolidayServlet()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }
 

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  out = response.getWriter();
      HttpSession session=request.getSession(false);
	  facilityId = (String)session.getValue("facility_id");
	  p = (Properties)session.getValue("jdbc");
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  String operation=request.getParameter("operation")==null?"":request.getParameter("operation");
	  System.err.println("operation===>"+operation);
	   client_ip_address = p.getProperty("client_ip_address");
	  if(operation.equals("insert")) insertFMHoliday(request,response);
	  if(operation.equals("modify")) modifyFMHoliday(request,response);
	  if(operation.equals("delete")) deleteFMHoliday(request,response);
	  if(operation.equals("multipledelete")) deleteMultipleFMHolidays(request,response);
  }
      public void doGet(HttpServletResponse response)
        throws ServletException, IOException
    {
        try
        {
            out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'\tsrc='../eCommon/jsp/commonToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'\tsrc='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { 
			 out.println(exception.toString());
			 exception.printStackTrace();
		}
    }
private void insertFMHoliday(HttpServletRequest request,HttpServletResponse response){ 
   try{
 
	  String nochkbox=request.getParameter("nochkbox")==null?"0":request.getParameter("nochkbox");
	  int chkBoxCount=Integer.parseInt(nochkbox);  System.err.println("chkBoxCount==>"+chkBoxCount);
	  
	  String mrdlocationcode="",holidayreasion="",holidaytoken="";
	  RecordSet  	holidaydatevalue  =null;
	  java.util.HashMap passObjects = new java.util.HashMap(); 
	  int totalCount=0; 
	  String totalHoliday="";
	  
	  String locale = p.getProperty("LOCALE");
	  java.util.Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_INSERTION", "FM");
	  String err = ((String) message.get("message"));
	  //String mapKey="hmapKey";
		  
	  HttpSession session=request.getSession(false);
	  holidaydatevalue=(webbeans.eCommon.RecordSet)session.getAttribute("holidaydatevalue");
	  for(int i=0; i<=chkBoxCount; i++){  
		 if(request.getParameter(("selected_"+i))!=null){	 
		  
		  // System.err.println("selected_value ==>"+"selected_"+i);
           mrdlocationcode=request.getParameter("Fslocationcode_"+(i));
		   holidayreasion=request.getParameter("holiday_reasion_"+(i));
           holidaydate=request.getParameter("holidaydate_"+(i));
           holidaytoken=mrdlocationcode+"|"+holidayreasion+"|"+holidaydate;		

                      		   
		    
		 if(!holidaydatevalue.containsObject(holidaytoken))		 
             holidaydatevalue.putObject(holidaytoken);	   
		   
		 
		 }   
       }
	   totalHoliday= ""+holidaydatevalue.getSize();
	   
	  
		    if(holidaydatevalue.getSize() >0){  
				for(int i=0;i<holidaydatevalue.getSize();i++){ 
					
					passObjects.put(("selected_"+i), (String)holidaydatevalue.getObject(i));						
				}
			}else{
			//out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num="+ URLEncoder.encode(err,"UTF-8") + "\"</script><body class='message'></html>");
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(err,"UTF-8") + "&err_value=0"  );
			}
	        passObjects.put("totalHolidayCount",new Integer(totalHoliday));	 
	   
	        boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMHoliday",FMHolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			java.util.HashMap results;
          	passObjects.put("client_ip_address",client_ip_address);	
            passObjects.put("facilityId",facilityId);				
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			results = (java.util.HashMap)(busObj.getClass().getMethod("insertFMHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue(); System.err.println("flag===>"+flag);
			String err1 = (String)results.get("error");  System.err.println("err1===>"+err1);
			
			 if(flag){
                String s4 = "1";				
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(err1,"UTF-8") + "&err_value=1"  );
              				
            }else{
			   response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(err1,"UTF-8") + "&err_value=0"  );
               // out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(err1,"UTF-8") + "\"</script><body class='message'></html>");
            }
			results.clear();
			passObjects.clear();
			message.clear();
			session.removeAttribute("holidaydatevalue");
			//	message1.clear();
        }catch(Exception exception){

			exception.printStackTrace();
        }
  
    }
	private void modifyFMHoliday(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
			String locale = p.getProperty("LOCALE");
           
            holidaydate = request.getParameter("holidaydate");
			String holiday_fs_locn_code=request.getParameter("holiday_fs_locn_code");			
            reasonforholiday = request.getParameter("reason_for_holiday");
			
			holidaydate=DateUtils.convertDate(holidaydate,"DMY",locale,"en");
			

          	java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("holidaydate",holidaydate); 
			passObjects.put("reasonforholiday",reasonforholiday);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("holiday_fs_locn_code",holiday_fs_locn_code);
					

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMHoliday",FMHolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateFMHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		    boolean flag = ((Boolean)results.get("status")).booleanValue();
			String updatingError = (String)results.get("error");  
						
			if(flag){
			   response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(updatingError,"UTF-8") + "&err_value=1"  );
			 // out.println("<script>alert(frames(1).document.forms(0).name)</script>");
            // out.println("<script>parent.parent.frames(1).onSuccess1();</script>");
            // out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(updatingError,"UTF-8") + "\"</script>");
			}else{
			   response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(updatingError,"UTF-8") + "&err_value=0"  );
			}
			
			results.clear();
			passObjects.clear();
        }
        catch(Exception updateExp)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + updateExp.toString());
            out.println("Values sent are : <br>");
            out.println(holidaydate + " " + reasonforholiday);
			updateExp.printStackTrace();
        }
    }
	
		private void deleteFMHoliday(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
			String locale = p.getProperty("LOCALE");
			String prevnextsub=request.getParameter("prevnextsubm")==null?"N":request.getParameter("prevnextsubm");
			String whereClause1=request.getParameter("whereClause1")==null?"":request.getParameter("whereClause1");
			//fmode=httpservletrequest.getParameter("fmode")==null?"":httpservletrequest.getParameter("fmode");
			String fs_locn_code=request.getParameter("fs_locn_code")==null?"":request.getParameter("fs_locn_code");
			String long_desc=request.getParameter("long_desc")==null?"":request.getParameter("long_desc");
			String holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");			
			String orderCols=request.getParameter("orderCols")==null?"":request.getParameter("orderCols");
			String operation=request.getParameter("operation")==null?"":request.getParameter("operation");
			
			
			
           
            holidaydate = request.getParameter("holidaydate");
			String holiday_fs_locn_code=request.getParameter("holiday_fs_locn_code");			
            reasonforholiday = request.getParameter("reason_for_holiday");
			
			holidaydate=DateUtils.convertDate(holidaydate,"DMY",locale,"en");
			

          	java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("holidaydate",holidaydate); 
			passObjects.put("reasonforholiday",reasonforholiday);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("holiday_fs_locn_code",holiday_fs_locn_code);
					

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMHoliday",FMHolidayManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteFMHoliday",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		    boolean flag = ((Boolean)results.get("status")).booleanValue();
		    String deltError = (String)results.get("error");  
			System.err.println("deltError===>"+deltError);
			if(flag){
			
			out.println("<script>parent.f_query_add_mod.prevnextsubmission('"+flag+"','"+fs_locn_code+"','"+long_desc+"','"+holiday_date+"','"+orderCols+"','"+prevnextsub+"','"+operation+"');</script>");
			
			//out.println("<script>alert('"+deltError+"');</script>");
			//out.println( "<script>alert(\" "+ deltError +" \");</script>" ) ; 
			//out.println("<script>alert(parent.frames(2).name)</script>");
			//response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(deltError,"UTF-8") + "&err_value=1"  );
			 // out.println("<script>alert(frames(1).document.forms(0).name)</script>");
            // out.println("<script>parent.parent.frames(1).onSuccess1();</script>");
            // out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(updatingError,"UTF-8") + "\"</script>");
			}else{
			 response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(deltError,"UTF-8") + "&err_value=0"  );
			}
			results.clear();
			passObjects.clear();
        }
        catch(Exception deleteExp)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + deleteExp.toString());
            out.println("Values sent are : <br>");
            out.println(holidaydate + " " + reasonforholiday);
			deleteExp.printStackTrace();
        }
    }
	
private void deleteMultipleFMHolidays(HttpServletRequest request,HttpServletResponse response){ 
   try{ 
	
	       //	mode=httpservletrequest.getParameter("fromWhere")==null?"":httpservletrequest.getParameter("fromWhere");
			String prevnextsub=request.getParameter("prevnextsubm")==null?"N":request.getParameter("prevnextsubm");
			String whereClause1=request.getParameter("whereClause1")==null?"":request.getParameter("whereClause1");
			//fmode=httpservletrequest.getParameter("fmode")==null?"":httpservletrequest.getParameter("fmode");
			String fs_locn_code=request.getParameter("fs_locn_code")==null?"":request.getParameter("fs_locn_code");
			String long_desc=request.getParameter("long_desc")==null?"":request.getParameter("long_desc");
			String holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");			
			String orderCols=request.getParameter("orderCols")==null?"":request.getParameter("orderCols");
			String operation=request.getParameter("operation")==null?"":request.getParameter("operation");
	
	
				HttpSession session = request.getSession(false);
				selectedHolidays=new ArrayList();				
				String currSelectedValues=request.getParameter("selectedValues");
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
				holidaydate = request.getParameter("holiday_date");
				java.util.HashMap passObjects = new java.util.HashMap(); 
				passObjects.put("facilityId",facilityId);
				passObjects.put("selectedHolidays",selectedHolidays);
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMHoliday",FMHolidayManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = passObjects;
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = passObjects.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteMultipleFMHolidays",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean flag = ((Boolean)results.get("status")).booleanValue();
				String Error = (String)results.get("error");
				
				
				if(flag){
					
				out.println("<script>parent.f_query_add_mod.prevnextsubmission('"+flag+"','"+fs_locn_code+"','"+long_desc+"','"+holiday_date+"','"+orderCols+"','"+prevnextsub+"','"+operation+"');</script>");
				
				//response.sendRedirect("../eFM/jsp/HolidayForMrdQueryResult.jsp?flag="+flag+"&fs_locn_code="+fs_locn_code+"&long_desc="+long_desc+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&prevnextsub="+prevnextsub);
				
				
					//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "&err_value=1\"</script>");
				} else
				{
					//s = (String)results.get("error");
				   // out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
				   // out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(Error,"UTF-8") + "\"</script>");
					 response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(Error,"UTF-8") + "&err_value=0"  );
				}
				//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(s,"UTF-8") + "\"</script>");
				passObjects.clear();
				results.clear();
				session.removeAttribute("selVals");
				session.removeAttribute("selVals1");
			}//count if		
			
        }catch(Exception exception){

			exception.printStackTrace();
        }
  
    }
	
	
	
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	

      
 }




