<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" 
 %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String func_mode			= request.getParameter("func_mode");
    //String itemcode=""; 
	String	bean_trade_id					=	"";
	//String	select					=	"";
	String pres_base_uom="";
	String pres_base_uom_value="";
	String Drug_code="";
	String Drug_code_value="";
	String local="";
	String mode="";
	String eqvl_value="";
	boolean dup_found						=	false;
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	pres_base_uom		        = (String) hash.get( "pres_base_uom" );
	//String packSize		        = (String) hash.get( "packSize" );
	String stock_uom		    = (String) hash.get( "stock_uom" );
	pres_base_uom_value		    = (String) hash.get( "pres_base_uom_value" );
	Drug_code		            = (String) hash.get( "Drug_code" );
	Drug_code_value		        = (String) hash.get( "Drug_code_value" );
	local		            = (String) hash.get( "local" );
	String vaY		            = (String) hash.get( "vaY" )==null?"E":(String) hash.get( "vaY" );
    String code="";
    String desc="";
    MedicalItemBean bean		= (MedicalItemBean)getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	if(pres_base_uom!= null)
	{
    out.println("DispensingUnitclear()");   
    out.println("DispensingUnitAssign()");   
	ArrayList DispensingUnitlist=new ArrayList(); 
    HashMap DispensingUnitValues=new HashMap();
	DispensingUnitlist=bean.getDispensingUnitrelated(pres_base_uom,locale);
	for(int i=0; i<DispensingUnitlist.size(); i++)
	 	{
			DispensingUnitValues = (HashMap)DispensingUnitlist.get(i);
			code = (String)DispensingUnitValues.get("code");
			desc = (String)DispensingUnitValues.get("desc");
			out.println("DispensingUnit(\"" +code+ "\",\"" +desc+ "\"); ");
		}
	}
if(func_mode!= null && func_mode.equals("searchManufacturer"))
		{
		String tradeId				= (String) hash.get( "code" );
		out.println("setManufacturerName('"+bean.getManufacturerName(tradeId)+"');");
	   }
if(func_mode!= null && func_mode.equals("trade_tab"))
	{
		//String trade_code				= (String) hash.get("code");
		String trade_id				= (String) hash.get("trade_id");
		String trade_name				= (String) hash.get("trade_name");
		String manufacturer_id				= (String) hash.get("manufacturer_id");
		String manufacturer_name				= (String) hash.get("manufacturer_name");
		Drug_code_value				= (String) hash.get("Drug_code_value");
		mode				= (String) hash.get("mode");
		ArrayList TradeList=new ArrayList(); 
		ArrayList TradeListQuery=new ArrayList(); 
        HashMap Tradevalues=new HashMap();
        HashMap trade_record=new HashMap();
		TradeList=bean.getTradeNamesAll();
		TradeListQuery=bean.getTradeResult();
		if(TradeList.size()!=0)
        {
			TradeList=bean.getTradeNamesAll();
		    for(int k=0; k<TradeList.size(); k++)
			{
				Tradevalues			=	(HashMap) TradeList.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
			if(bean_trade_id.equals(trade_id))
				{
					dup_found	=	true;
					out.println("DuplicateNotAllowed();");
					break;
			    }
		    }
    	}
if(!mode.equals("1"))
  { 
    if(TradeListQuery.size()!=0)
      {
			
		 TradeListQuery=bean.getTradeResult();
		 for(int k=0; k<TradeListQuery.size(); k++)	
			 {
				Tradevalues			=	(HashMap) TradeListQuery.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
				if(bean_trade_id.equals(trade_id))
					{
					dup_found	=	true;
					out.println("DuplicateNotAllowed();");
					break;
			        }
		     }
       }
     else if(TradeList.size()==0)
	 {
		/***Check Duplicate Record***/
		for(int k=0; k<TradeList.size(); k++)
			{
				Tradevalues			=	(HashMap) TradeList.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
				if(bean_trade_id.equals(trade_id))
					{
						dup_found	=	true;
						out.println("DuplicateNotAllowed();");
						break;
	    	        }
	       }
        }
    }
	if(!dup_found)
		{
			trade_record	=	new HashMap();
			trade_record.put("trade_id",trade_id);
			trade_record.put("trade_name",trade_name);
			trade_record.put("manufacturer_id",manufacturer_id);
			trade_record.put("manufacturer_name",manufacturer_name);
			trade_record.put("select",vaY);
			trade_record.put("mode",mode);
			bean.setTradeNamesAll(trade_record);
			out.println("Duplicate('"+Drug_code_value+"');");
		}
	}

if(func_mode!= null && func_mode.equals("Trade_check"))
	{
	vaY		        = (String) hash.get( "vaY" );
	mode		        = (String) hash.get( "mode" );
	String trade_id_check		        = (String) hash.get( "trade_id" );
	ArrayList TradeList=new ArrayList(); 
	ArrayList TradeListQuery=new ArrayList(); 
	TradeList=bean.getTradeNamesAll();
	TradeListQuery=bean.getTradeResult();
    HashMap Tradevalues=new HashMap();
	if(mode.equals("2"))
	 {
		/***Check Duplicate Record***/
		for(int k=0; k<TradeListQuery.size(); k++)
			{
			  Tradevalues			=	(HashMap) TradeListQuery.get(k);
			  bean_trade_id	=	(String)Tradevalues.get("trade_id");
			  if(bean_trade_id.equals(trade_id_check))
				 {
				   Tradevalues.put("select",vaY);
					 break;
				  }
			}
      }
	  else if(mode.equals("1"))
	  {
		for(int k=0; k<TradeList.size(); k++)
			{
			  Tradevalues			=	(HashMap) TradeList.get(k);
			  bean_trade_id	=	(String)Tradevalues.get("trade_id");
			  if(bean_trade_id.equals(trade_id_check))
				  {
					Tradevalues.put("select",vaY);
					break;
				  }
		   }
       }
   }
if(func_mode!= null && func_mode.equals("packSize"))
    {
	  eqvl_value=bean.getEqvlValue(pres_base_uom_value,stock_uom);
	  if(eqvl_value.equals(""))
	   {
        eqvl_value="";
	   }
	   bean.setEqvlvalue(eqvl_value);
	   out.println("assignPackSize('"+eqvl_value+"');");
   }
if(func_mode!= null && func_mode.equals("toolBar"))  
	{
	   //out.println("alert(\"toolBarString:"+request+"\")" ) ;
       String toolBarString = request.getQueryString() ;
	   session.removeValue("queryString") ;
       session.putValue( "queryString", toolBarString ) ;
	   //out.println("alert(\"After:"+session.getValue("queryString")+"\")") ;
    }
if(func_mode!= null && func_mode.equals("drug_code_check"))
  {
	int value=bean.getDrug_Code(Drug_code);
    if(value!=0)
	{
     out.println("DrugCodeCheck();");
	}
  }
%>


<%
putObjectInBean(bean_id,bean,request);
%>
