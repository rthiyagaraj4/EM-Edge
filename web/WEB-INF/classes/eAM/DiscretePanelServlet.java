/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import com.ehis.eslp.ServiceLocator;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
//import oracle.sql.*;
import java.net.URLEncoder;
import webbeans.eCommon.*;
import eAM.DiscretePanel.*;

public class DiscretePanelServlet extends HttpServlet implements SingleThreadModel
{
	//PrintWriter out;
    Properties p;
	   
	String longdesc="";
	String shortdesc="";
	String service="";
	String result_type="";

	int numdigitsmax =0;
    int numdigitsmin=0;
    int numdigitsdec=0;

    String refrangetype="";
    String resulttemplateid="";
    String effstatus="";
	
	double numreflow;
    double numrefhigh;
    double numcritlow;
    double numcrithigh;
    double numdfltresult;
    String numuom="";

    String discr_msr_id="";
	String mode="";

    String facilityId="";
    String client_ip_address="";
    //String serviceURL="";
    //String objectName="";
    String addedById="";
    //String addedDate="";
    String modifiedById="";
    //String modifiedDate="";
    String addedFacilityId="";
    String modifiedFacilityId="";
    String addedAtWorkstation="";
    String modifiedAtWorkstation="";
	RecordSet associateDiagBean =new RecordSet();
	HttpSession httpsession; 
	//ArrayList a= new ArrayList();
	//SimpleDateFormat dateFormat;
	
	
  public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }   

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		
        httpsession = httpservletrequest.getSession(false);
			
			 associateDiagBean =(RecordSet)httpsession.getValue("associateDiagBean");
			
			//a= associateDiagBean.getRecordSetHandle();
	
			
			
			
        facilityId = (String)httpsession.getValue("facility_id");
		
        p = (Properties)httpsession.getValue("jdbc");
		
        client_ip_address = p.getProperty("client_ip_address");
       
        //serviceURL = (String)httpsession.getValue("serviceURL");
	
        modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        //modifiedDate = dateFormat.format(new Date());
    
        modifiedFacilityId = facilityId != null ? facilityId : "";
        modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		
        try
        {
            httpservletresponse.setContentType("text/html");
            //out = httpservletresponse.getWriter();
            mode = httpservletrequest.getParameter("mode") != null ? httpservletrequest.getParameter("mode") : "";
			
			 if(mode.trim().equalsIgnoreCase("insert"))
			{
            insertDiscretePanel(httpservletrequest, httpservletresponse);
			}
			 if(mode.trim().equalsIgnoreCase("update"))
			{
				 
				 updateDiscretePanel(httpservletrequest, httpservletresponse);
				
			}
        }
        catch(Exception exception)
        {
           exception.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        doPost(httpservletrequest, httpservletresponse);
    }
	private void insertDiscretePanel(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	{

	
        try
        {
		      
				discr_msr_id = httpservletrequest.getParameter("discr_panel_id") != null ? httpservletrequest.getParameter("discr_panel_id") : "";
				

				result_type = httpservletrequest.getParameter("result_type") != null ? httpservletrequest.getParameter("result_type") : "";

				shortdesc=httpservletrequest.getParameter("short_desc") != null ? httpservletrequest.getParameter("short_desc") : "";

				longdesc=httpservletrequest.getParameter("long_desc") != null ? httpservletrequest.getParameter("long_desc") : "";

				service=httpservletrequest.getParameter("service") != null ? httpservletrequest.getParameter("service") : "";

				mode=httpservletrequest.getParameter("mode") ;
				 numdigitsmax = 0;
				 numdigitsmin = 0;
				 numdigitsdec =0;
				refrangetype = "S";
				 resulttemplateid = "";
				effstatus = httpservletrequest.getParameter("eff_status") != null ? httpservletrequest.getParameter("eff_status") : "D";
				//mandatory = httpservletrequest.getParameter("mandatory") != null ? httpservletrequest.getParameter("mandatory") : "N";
				//mandatory = httpservletrequest.getParameter("mandatory");
				 numreflow = 0.0D;
				 numrefhigh = 0.0D;
				numcritlow = 0.0D;
				 numcrithigh = 0.0D;
				numdfltresult = 0.0D;
       
            addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
            //addedDate = dateFormat.format(new Date());
            addedFacilityId = facilityId != null ? facilityId : "";
            addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

			
			
            HashMap hashmap = new HashMap();
            hashmap.put("p", p);
            hashmap.put("discr_msr_id", discr_msr_id);
            hashmap.put("long_desc", longdesc);
			hashmap.put("short_desc", shortdesc);
			hashmap.put("service",service);
			hashmap.put("result_type",result_type);

			hashmap.put("numdigitsmax", new Integer(numdigitsmax));
            hashmap.put("numdigitsmin", new Integer(numdigitsmin));
            hashmap.put("numdigitsdec", new Integer(numdigitsdec));
            hashmap.put("refrangetype", refrangetype);
            hashmap.put("resulttemplateid", resulttemplateid);
            hashmap.put("effstatus", effstatus);
			//hashmap.put("mandatory", mandatory);
            hashmap.put("numreflow", new Double(numreflow));
            hashmap.put("numrefhigh", new Double(numrefhigh));
            hashmap.put("numcritlow", new Double(numcritlow));
            hashmap.put("numcrithigh", new Double(numcrithigh));
            hashmap.put("numdfltresult", new Double(numdfltresult));
            hashmap.put("numuom", numuom);
			hashmap.put("mode", mode);
           
            hashmap.put("added_by_id", addedById);
            hashmap.put("added_date", new Timestamp(System.currentTimeMillis()));
            hashmap.put("added_facility_id", addedFacilityId);
            hashmap.put("added_at_ws_no", addedAtWorkstation);
            hashmap.put("modified_by_id", modifiedById);
            hashmap.put("modified_date", new Timestamp(System.currentTimeMillis()));
            hashmap.put("modified_facility_id", modifiedFacilityId);
            hashmap.put("modified_at_ws_no", modifiedAtWorkstation);

			hashmap.put("Recordset",associateDiagBean );
          // associateDiagBean.clearAll();
	     //  httpsession.removeValue("associateDiagBean");
           boolean local_ejbs = false;
		 
           //if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
                local_ejbs = true;

            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscretePanel", eAM.DiscretePanel.DiscretePanelHome.class, local_ejbs);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
          
			aobj[0] = p;
			aobj[1] = hashmap;
			
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
			aclass[1] = hashmap.getClass();
			
            HashMap hashmap3 = (HashMap)obj1.getClass().getMethod("insertDiscrete", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
            boolean flag1 = ((Boolean)hashmap3.get("status")).booleanValue();
			
            String s = (String)hashmap3.get("error");
            hashmap.clear();
			hashmap3.clear();
            String s1 = "0";
			//String flag2="";
				
            if(flag1)
                s1 = "1";

				//httpsession.putValue("flag2", "Y");


            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s,"UTF-8" ) + "&err_value=" + s1);
        
		}
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

private void updateDiscretePanel(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
{
	try
	{
				discr_msr_id = httpservletrequest.getParameter("discr_panel_id1") != null ? httpservletrequest.getParameter("discr_panel_id1") : "";
				
				result_type = httpservletrequest.getParameter("result_type1") != null ? httpservletrequest.getParameter("result_type1") : "";

				shortdesc=httpservletrequest.getParameter("short_desc1") != null ? httpservletrequest.getParameter("short_desc1") : "";

				longdesc=httpservletrequest.getParameter("long_desc1") != null ? httpservletrequest.getParameter("long_desc1") : "";

				service=httpservletrequest.getParameter("service1") != null ? httpservletrequest.getParameter("service1") : "";

				mode=httpservletrequest.getParameter("mode") ;
               
				 numdigitsmax = 0;
				 numdigitsmin = 0;
				 numdigitsdec =0;
				refrangetype = "S";
				 resulttemplateid = "";
				effstatus = httpservletrequest.getParameter("eff_status") != null ? httpservletrequest.getParameter("eff_status") : "D";
				//mandatory = httpservletrequest.getParameter("mandatory") != null ? httpservletrequest.getParameter("mandatory") : "N";
				//mandatory = httpservletrequest.getParameter("mandatory");
				 numreflow = 0.0D;
				 numrefhigh = 0.0D;
				numcritlow = 0.0D;
				 numcrithigh = 0.0D;
				numdfltresult = 0.0D;
       
            addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
            //addedDate = dateFormat.format(new Date());
            addedFacilityId = facilityId != null ? facilityId : "";
            addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

						
			
            HashMap hashmap = new HashMap();
            hashmap.put("p", p);
            hashmap.put("discr_msr_id", discr_msr_id);
            hashmap.put("long_desc", longdesc);
			hashmap.put("short_desc", shortdesc);
			hashmap.put("service",service);
			hashmap.put("result_type",result_type);

			hashmap.put("numdigitsmax", new Integer(numdigitsmax));
            hashmap.put("numdigitsmin", new Integer(numdigitsmin));
            hashmap.put("numdigitsdec", new Integer(numdigitsdec));
            hashmap.put("refrangetype", refrangetype);
            hashmap.put("resulttemplateid", resulttemplateid);
            hashmap.put("effstatus", effstatus);
			//hashmap.put("mandatory", mandatory);
            hashmap.put("numreflow", new Double(numreflow));
            hashmap.put("numrefhigh", new Double(numrefhigh));
            hashmap.put("numcritlow", new Double(numcritlow));
            hashmap.put("numcrithigh", new Double(numcrithigh));
            hashmap.put("numdfltresult", new Double(numdfltresult));
            hashmap.put("numuom", numuom);
			hashmap.put("mode", mode);
           
            hashmap.put("added_by_id", addedById);
            hashmap.put("added_date", new Timestamp(System.currentTimeMillis()));
            hashmap.put("added_facility_id", addedFacilityId);
            hashmap.put("added_at_ws_no", addedAtWorkstation);
            hashmap.put("modified_by_id", modifiedById);
            hashmap.put("modified_date", new Timestamp(System.currentTimeMillis()));
            hashmap.put("modified_facility_id", modifiedFacilityId);
            hashmap.put("modified_at_ws_no", modifiedAtWorkstation);
			//a=associateDiagBean.getRecordSetHandle();
			
			
			hashmap.put("Recordset",associateDiagBean );
           // associateDiagBean.clearAll();
          //  httpsession.removeValue("associateDiagBean");
			boolean local_ejbs = false;
		 
           //if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
                local_ejbs = true;

            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscretePanel", eAM.DiscretePanel.DiscretePanelHome.class, local_ejbs);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
          
			aobj[0] = p;
			aobj[1] = hashmap;
			
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
			aclass[1] = hashmap.getClass();
			
            HashMap hashmap3 = (HashMap)obj1.getClass().getMethod("updateDiscrete", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
            boolean flag1 = ((Boolean)hashmap3.get("status")).booleanValue();
			
            String s = (String)hashmap3.get("error");
            String s1 = "0";
			hashmap.clear();
			hashmap3.clear();
            if(flag1)
                s1 = "1";

			//String flag2="";
		
				//httpsession.putValue("flag2", "Y");
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s,"UTF-8" ) + "&err_value=" + s1);
			}
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
	
}


}
