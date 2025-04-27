
<%@ page import="java.util.Hashtable,java.util.HashMap,eOT.SetUpParamForFacilityBean,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try 
{
	String bean_id ="SetUpParamForFacilityBean";
    String bean_name = "eOT.SetUpParamForFacilityBean";
    SetUpParamForFacilityBean beanObj = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name ) ;

	HashMap hmap = new HashMap();

    Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String tab_id =(String)hash.get("tab_id");
	
	boolean main_other_1=false;
	boolean main_bill_1=false;
	boolean other_main_1=false;
	boolean other_bill_1=false;
	boolean bill_main_1=false;
	boolean bill_other_1=false;

	if( ("MainPage").equals(tab_id) )
	{
		hmap.putAll(hash);

		if(session.getAttribute("OtherDetails")!=null)
		{
			main_other_1=true;
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both12");
		}

		if(session.getAttribute("BillingSetup")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both13");
		}
		
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(main_other_1==true && main_bill_1==true)
		{
			hmap.put("tab_id","All");
		}
	}
	else if( ("OtherDetails").equals(tab_id) )
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			other_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both21");
		}

		if(session.getAttribute("BillingSetup")!=null)
		{
			other_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both21");
		}
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(other_main_1==true && other_bill_1==true)
			hmap.put("tab_id","All");
	}
	else if(("BillingSetup").equals(tab_id))
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			bill_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both13");

		}
		
		if(session.getAttribute("OtherDetails")!=null)
		{
			bill_other_1=true;
			hmap.putAll(hash);
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both23");
		}
		
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(bill_main_1==true && bill_other_1==true)
			hmap.put("tab_id","All");
	}
	//Rajesh V
	else if(("AdditionalDetails").equals(tab_id))
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			bill_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both13");

		}
		
		if(session.getAttribute("OtherDetails")!=null)
		{
			bill_other_1=true;
			hmap.putAll(hash);
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both23");
		}
		
		
		if(session.getAttribute("BillingSetup")!=null)
		{
			other_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both21");
		}
		
		if(bill_main_1==true && bill_other_1==true)
			hmap.put("tab_id","All");
	}
	//Rajesh V
	//Else Part closing

   
	beanObj.setAll(hmap);
    HashMap map = beanObj.validate() ;
    boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
    String validationMessage = (String) map.get( "message" ) ;
    
	if ( validated ) 
	{
		map = beanObj.apply();
        boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
        String message = (String) map.get( "message" ) ;
        String flag = (String) map.get( "flag" );
        String invalidCode = "" ;
        if(map.get("invalidCode") != null)
            invalidCode = (String) map.get( "invalidCode" ) ;
        out.println("assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ;
    } 
	else 
	{
        out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\", \"0\" ) ; ") ;
    }
	
	map=null;
	hmap=null;
	session.removeAttribute("MainPage");
	session.removeAttribute("OtherDetails");
	session.removeAttribute("BillingSetup");
}
catch (Exception e) 
{
	e.printStackTrace();
    //out.println("alert(\"Exception in Controller test: " +e+ "\")") ;
}
%>
