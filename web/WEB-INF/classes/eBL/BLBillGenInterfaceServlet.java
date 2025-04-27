package eBL;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.JsonObject;

import java.util.*;
import javax.naming.*;
import javax.rmi.*;

//import org.json.JSONObject;

import java.net.*;
import webbeans.eCommon.*;
import eBL.*;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.ehis.persist.PersistenceHelper;
import com.ehis.eslp.ServiceLocator;

import webbeans.eCommon.ConnectionManager;
import java.lang.*;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
/**
 * Servlet implementation class BLBillGenInterfaceServlet
 */
public class BLBillGenInterfaceServlet extends HttpServlet {
	
	
	
	java.util.Properties p;
	HttpSession session;
	//PrintWriter out;
	
	
	//private static final long serialVersionUID = 1L; //commented checkstyle
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLBillGenInterfaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out=response.getWriter();
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		
		
		System.err.println("reached servlet");
		try
		{
		//HashMap sendData = new HashMap();//commented checkstyle
	
		BLBillGenInterfaceBean bean = new BLBillGenInterfaceBean();
		BLBillGenInterfaceBean loopBean =null;
		List<BLBillGenInterfaceBean> listAdd = new ArrayList<BLBillGenInterfaceBean>(); 
		
		
		String index=request.getParameter("indx");	
		String facilityId=request.getParameter("facility_id");
		String userId=request.getParameter("user_id");
		String locale=request.getParameter("locale");
		String episodeType=request.getParameter("episode_type");
		System.out.println("episode type "+episodeType);
		
		
		String clientIpAddress = p.getProperty("client_ip_address");
		if(clientIpAddress == null) clientIpAddress="";
		
		System.out.println(" index / facility id / userId / locale /clientIpAddress" +index +"/" +facilityId +"/" +userId+ "/" +locale +"/" + clientIpAddress);
		
		int lrow;
		
		if(index.equals("undefined") || index==null ||"".equals(index) )
		{
			lrow=0;
		}
		
		lrow=Integer.parseInt(index);
		
		System.out.println("lrow " +lrow);
		
		
		for(int i=1;i<=lrow;i++)
		{

			String pKeyId=request.getParameter("primarykey_id"+i);
			
			if(!"".equals("pKeyId") && !"null".equals("pKeyId") && !"undefined".equals("pKeyId") && pKeyId!=null)
			{
				loopBean = new BLBillGenInterfaceBean();
				loopBean.setFacilityId(facilityId);
				loopBean.setUserId(userId);
				loopBean.setLocale(locale);
				loopBean.setWorkStationNo(clientIpAddress);
				loopBean.setEpisodeType(episodeType);
				loopBean.setPatientId(request.getParameter("pat_id"+i));
				loopBean.setEpisodeId(request.getParameter("epiid"+i));
				loopBean.setVisitId(request.getParameter("vis_id"+i));		
				loopBean.setPrimaryKeyModuleId(request.getParameter("primarykey_id"+i));
			System.out.println("primary key module id in servlet  "+loopBean.getPrimaryKeyModuleId());
			loopBean.setPrimaryKeyMain(request.getParameter("primarykey_main"+i));
			System.out.println("primaryn key main in servlet  "+loopBean.getPrimaryKeyMain());
			loopBean.setSecondaryKeyModuleId(request.getParameter("seckeymoduleid"+i));
			System.out.println("sec key id in servlet" +loopBean.getSecondaryKeyModuleId());
			loopBean.setSecondaryKeyMain(request.getParameter("seckeymain"+i));
			System.out.println("secondary main in servlet "+loopBean.getSecondaryKeyMain());
			loopBean.setSecondaryKeyLine(request.getParameter("seckeylineno"+i));
			System.out.println("secline no in servlet "+loopBean.getSecondaryKeyLine());			
			listAdd.add(loopBean);
		}
		}
	
		
		
		
		bean.setRequestList(listAdd);
		
		String errr="";
		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
		{
			local_ejbs = true;
		}
		Object home = ServiceLocator.getInstance().getHome("java:comp/env/BillGeneration",eBL.BillGeneration.BillGenerationHome.class, local_ejbs);
		Object busObj = (home.getClass().getMethod("create")).invoke(home);
	
		
		Object argArray[]=new Object[1];
		argArray[0]=bean;
		
		System.out.println("bean  "+bean);
		
		Class [] paramArray	   = new Class[1];
		paramArray[0] = bean.getClass();
		
		System.out.println("after paramArray");
		List<String> errorList=(List<String>)(busObj.getClass().getMethod("processInterfaceRecords",paramArray)).invoke(busObj, argArray);
		
		errorList.size();
		System.out.println("error List size is "+errorList.size());

		
		JsonObject obj = new JsonObject();
		if(errorList.isEmpty())
		{
			obj.addProperty("Success","Y");
			out.println(obj);
		}
		else
		{
			for(Iterator iterator=errorList.iterator();iterator.hasNext();)
			{
				errr+=(String)iterator.next();	
				errr+="\n";
			
			}
		
		System.out.println("Error ="+errr);
		obj.addProperty("Success", "N");
		out.println(obj);
		
		}

/*		BillReceiptBC receiptBC = new BillReceiptBC();
		
			//listAdd =receiptBC.processRecords(bean);
			//List<String> error=receiptBC.processRecords(bean);
				
		
		List<String> errrList=receiptBC.processRecords(bean);
		errrList.size();
		System.out.println("error List size is "+errrList.size());
		
		JsonObject obj = new JsonObject();
		String error1="";
		 if(errrList.isEmpty())
		 {
			 obj.addProperty("Success", "Y");
			 out.println(obj);
		 
		 }
	
		 else
		 {
			 obj.addProperty("Success", "N");
			 
			 for(Iterator iterator=errrList.iterator(); iterator.hasNext();)
			 {
				error1+=(String) iterator.next();
				error1+="\n";
			 }
			// System.out.println("error " + error);
			 obj.addProperty("error", error1);
			 out.println(obj);
		 }
*/	
		}catch(Exception e)
		{
			System.out.println("Exception in  BLBillGenInterfaceServlet"+e);
			e.printStackTrace();
		}
	}

}
