<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

    
    <%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}%>
    
   <%  
    String beanId = "EstimateDepositBean";
	String beanName = "eBL.BLEstimateDepositBean";
	BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request); 
	List<BLEstimateDepositBean> depositlist = new ArrayList<BLEstimateDepositBean>();  
	BLEstimateDepositBean bean=null;
	BLEstimateDepositBean depositbean_test =null;
	
	System.out.println(" After Bean read");
	String strlastrow=request.getParameter("lrow");
	int lrow;
	if(strlastrow==null || ("").equals(strlastrow))
	{
	   	lrow=0;
	}
		
	else
	lrow=Integer.parseInt(strlastrow);
	
	
	if(lrow==0){
		System.out.println("beean cleared");
		depositbean.setDepositList(null);
	}
	
	
	System.out.println("lrow="+lrow);
	
String strbase_qty=request.getParameter("base_qty");
int base_qty=0;
if(strbase_qty==null || ("").equals(strbase_qty))
{
	base_qty=0;
}
	
else
base_qty=Integer.parseInt(strbase_qty);
System.out.println("base_qty="+base_qty);

String strbase_rate=request.getParameter("base_rate");
int base_rate=0;
if(strbase_rate==null || ("").equals(strbase_rate))
{
	base_rate=0;
}
	
else
{
base_rate=Integer.parseInt(strbase_rate);
}
System.out.println("base_rate="+base_rate);

String day_type_code=request.getParameter("day_type_code");
System.out.println("day_type_code="+day_type_code);

String time_type_code=request.getParameter("time_type_code");
System.out.println("time_type_code="+time_type_code);
System.out.println("lrow="+lrow);
for(int i=1; i<=lrow; i++)
	{
						
		
	/*	System.out.println("code="+request.getParameter("service_code"+i));
		System.out.println("qty="+request.getParameter("qty"+i));
		System.out.println("charges="+request.getParameter("charges_"+i));
		System.out.println("Rc="+request.getParameter("Rc"+i));*/
		
			System.out.println("inside for"+i);

			String service_code=request.getParameter("service_code"+i);
					if(service_code.equals("undefined"))
					{
						
					}
					System.out.println("service_code"+service_code);
				if(!"".equals(service_code) && !"null".equals(service_code) && !"undefined".equals(service_code))
				{
				bean=new BLEstimateDepositBean();
				System.out.println("inside if");
				bean.setService_code(request.getParameter("service_code"+i));
				bean.setRate_charge(request.getParameter("Rc"+i));
				bean.setCharges(request.getParameter("charges_"+i));
				bean.setQty(request.getParameter("qty"+i));
				bean.setDatetime(request.getParameter("datetime"+i));
				bean.setLine(request.getParameter("line"+i));
				bean.setService_desc(request.getParameter("service_desc"+i));
				bean.setService_indicator(request.getParameter("service_indicator"+i));
				bean.setEsttotal(request.getParameter("esttotal"));
				bean.setDay_type(day_type_code);
				bean.setTime_type(time_type_code);
				bean.setBase_rate(Integer.toString(base_rate));
				bean.setBase_qty(Integer.toString(base_qty));	
				
				
				depositlist.add(bean);		
				}
				
				
			/*	System.out.println("i value =" +i);
				code =request.getParameter("service_code"+i);
				desc = request.getParameter("service_desc"+i); 
				strcharges=request.getParameter("charges_"+i);
				qty=request.getParameter("qty"+i);
				ratecharge=request.getParameter("Rc"+i);	
				System.out.println("code"+code);
				System.out.println("desc"+desc);
				System.out.println("charges="+strcharges);
				System.out.println("qty="+qty); 
				System.out.println("ratecharge="+ratecharge);*/
				
		
	}
	
	depositbean.setDepositList(depositlist);	
	putObjectInBean(beanId,depositbean,request);
	
	
	depositbean_test = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
	List<BLEstimateDepositBean> depositlist1 = depositbean_test.getDepositList();
	
 	//int size=depositlist1.size();
	
	
	System.out.println("Bean Add in ajax call page");
	for (Iterator iterator = depositlist1.iterator(); iterator.hasNext();)
	{

		System.out.println("inside for  in ajax call page");		
	depositbean = (BLEstimateDepositBean) iterator.next();
	System.out.println("service code="+depositbean.getService_code());
	System.out.println("charges="+depositbean.getCharges());
	System.out.println("qty="+depositbean.getQty());
	System.out.println("Rc="+depositbean.getRate_charge());
	System.out.println("base_qty="+depositbean.getBase_qty());
	System.out.println("base_rate="+depositbean.getBase_rate());
	System.out.println("day_type_code="+depositbean.getDay_type());
	System.out.println("time_type_code="+depositbean.getTime_type());
	
	}
	
	
    
    %>
    
