<%@page import="java.sql.*, java.io.*,java.util.*, eST.*, eST.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 


<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	StringBuffer sbErrorMessage = new StringBuffer();
	HashMap hmApply = new HashMap();
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");

	try 
	{
		Hashtable htXMLObj = (Hashtable) xmlObj.parseXMLString( request ) ;
System.err.println("==request"+request);	
System.err.println("==BEFORE htXMLObj"+htXMLObj);		
		htXMLObj = (Hashtable) htXMLObj.get( "SEARCH" ) ;
System.err.println("==AFTER htXMLObj"+htXMLObj);		
		eST.Common.StAdapter beanObj = null;
		String bean_id		= (String) htXMLObj.get( "bean_id" );
		String bean_name	= (String) htXMLObj.get( "bean_name" );
		//	String mode			= (String) htXMLObj.get( "mode" );	
		System.out.println("bean id = > "+bean_id+" bean_name = > "+bean_name);
		//Object beanObject = (eST.Common.StAdapter)mh.getBeanObject( bean_id,request,bean_name); 
		Object beanObject = (eST.Common.StAdapter)getBeanObject( bean_id,bean_name,request); 
		
		if (beanObject  instanceof eST.Common.StAdapter) 	
		{
			System.out.println("Instance of StAdapter");
			beanObj = (eST.Common.StAdapter) beanObject;
		}
		else 
		{
			return;
		}

		htXMLObj.remove( "bean_id" ) ;
		htXMLObj.remove( "bean_name" );
		ServletContext context = getServletConfig().getServletContext();
		
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
			beanObj.setLocalEJB(false);
		
		System.out.println("45,BeanObj = > "+beanObj.getClass().getName());
		beanObj.setMode((String) htXMLObj.get("mode"));
		System.out.println("htXMLObj = > "+htXMLObj);
		beanObj.setAll(htXMLObj);


		if (beanObject  instanceof eST.GoodsReceivedNoteBean) 	{
			((eST.GoodsReceivedNoteBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GoodsReceivedNoteBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.AdjustStockBean) 	{
			((eST.AdjustStockBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.AdjustStockBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.IssueBean) 	{
			((eST.IssueBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.IssueBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ManufacturingReceiptsBean) 	{
			((eST.ManufacturingReceiptsBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ManufacturingReceiptsBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.RequestBean) 	{
			((eST.RequestBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.RequestBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.IssueReturnBean) 	{
			((eST.IssueReturnBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.IssueReturnBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.GoodsReturnToVendorBean) 	{
			((eST.GoodsReturnToVendorBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GoodsReturnToVendorBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.SalesBean) 	{
			((eST.SalesBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.SalesBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.SalesReturnBean) 	{
			((eST.SalesReturnBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.SalesReturnBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.StockTransferBean) 	{
			((eST.StockTransferBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.StockTransferBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.GenerateRequestBean) 	{
			((eST.GenerateRequestBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GenerateRequestBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.AuthorizeAtIssueStoreBean) 	{
			((eST.AuthorizeAtIssueStoreBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.AuthorizeAtIssueStoreBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ReplacementGRNBean) 	{
			((eST.ReplacementGRNBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ReplacementGRNBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.CondemnExpiredBatchesHeaderBean) 	{
			((eST.CondemnExpiredBatchesHeaderBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.CondemnExpiredBatchesHeaderBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.StockItemConsumptionBean) 	{
			((eST.StockItemConsumptionBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.StockItemConsumptionBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ProductTransferBean) 	{
			((eST.ProductTransferBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ProductTransferBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

		System.out.println("BeanObj = > "+beanObj.getClass().getName());
		HashMap hmValidate = beanObj.validate() ;
		boolean validated = ((Boolean) hmValidate.get("result")).booleanValue() ;
		String validationMessage = (String) hmValidate.get("message");
		System.out.println("validated = > "+validated+" validationMessage = > "+validationMessage);
		if ( validated ) 
		{
			hmApply = beanObj.apply() ;
			System.out.println("hmApply = > "+hmApply);
			boolean result = ((Boolean) hmApply.get("result")).booleanValue() ;
			String message = (String) hmApply.get("message");

			String flag = beanObj.checkForNull((String) hmApply.get("flag"));
			String itemDesc = (String) hmApply.get("itemDesc");
			System.out.println("ItemDesc from Controller = > "+itemDesc);
			System.out.println("result--------in st controller---"+result);
			System.out.println("message--------in st controller---"+message);
			System.out.println("msgid--------in st controller---"+(String) hmApply.get("msgid"));

			/*if(((String)hmApply.get("msgid")).contains("NEGATIVE_STOCK"))
			{
				StringTokenizer strTok = new StringTokenizer((String) hmApply.get("msgid"),"!~");
				if(strTok.hasMoreTokens())	{
					strTok.nextToken();
					message = message + " "+strTok.nextToken();
				}

			}  */

			if(itemDesc!=null)
			message = message +" - "+itemDesc; 
			System.out.println("message from Controller after assigning = > "+message);
			System.out.println("flag--------in st controller---"+flag);
			String invalidCode = "" ;
			/*if(!flag.equals(""))
			{
			StringTokenizer st = new StringTokenizer(flag,":");
			String doc_no_desc = st.nextToken().trim();
			System.err.println("doc_no_desc--########"+doc_no_desc);
			String doc_no_value = st.nextToken();
			System.err.println("doc_no_value--########"+doc_no_value);
			//String doc_desc="Quantity";
			String doc_no_desc_th_eng=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST."+doc_no_desc+".label","st_labels");
			flag=doc_no_desc_th_eng+doc_no_value;
			}*/
			//System.err.println("flag--"+flag);

			if(hmApply.get( "invalidCode" ) != null) 
			{
				Object object = hmApply.get("invalidCode");
				if (object instanceof String) 
				{
					invalidCode = (String) hmApply.get( "invalidCode" ) ;
				}
				else if  (object instanceof java.util.ArrayList) 
				{
					java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
					for (int i=0;i<tempCode.size() -1;i++) 
					{
						invalidCode =invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
					}
					if ((tempCode.size() == 1) || (tempCode.size() > 1)) 
					{
						invalidCode =invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
					}
				}
				out.println(" assignResult('" + result + "', '" + beanObj.replaceNewLineChar(message) + "', '" + flag + "' , '" + invalidCode + "' ) ; ") ;
			} 
			else if(hmApply.get("msgid")!=null) 
			{
				//		String 	module_id="Common";
				//	out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\",\""+module_id+"\"), \""+flag+"\" ) ; ") ;
				message=beanObj.replaceNewLineChar(message);
				message= message.replaceAll("'","\"");
				if(message.contains("key"))
				message = message.substring(message.indexOf("key")+3);
				if(message.contains("<br>"))					
				message = message.substring(0,message.indexOf("<br>"));
				message=message+"<BR>";
				//out.println(" assignResult(" + result + ", '" + message + "', '" + flag + "' ) ; ") ;
				out.println(" assignResult('" + result + "', '" + message + "', '" + flag + "' ) ; ") ;
				//out.println("assignResult('" + result + "', , '"+flag+"' ) ; ") ;
			}
			else 
			{	
				message=beanObj.replaceNewLineChar(beanObj.checkForNull(message));
				message= message.replaceAll("'","\"");
				if(message.contains("key"))
				message = message.substring(message.indexOf("key")+3);
				if(message.contains("<br>"))					
				message = message.substring(0,message.indexOf("<br>"));
				out.println(" assignResult('" + result +"', '" + message + "','" + flag + "' ) ; ") ;
			}
			// added on Monday, December 22, 2003 by manish		
			if (result) 
			{
				beanObj.clear();
			}
		//ends
			}
			else if(hmValidate.get("msgid")!=null) 
			{
				String 	module_id="Common";
				out.println("assignResult('" + validated + "', getMessage('" + hmValidate.get("msgid").toString()+ "','"+module_id+"'), '"+beanObj.checkForNull((String)hmValidate.get("flag"))+"' ) ; ") ;
			}
			else 
			{
				out.println("assignResult('" + validated + "', '" + validationMessage + "', '"+beanObj.checkForNull((String)hmValidate.get("flag"))+"' ) ; ") ;
			}
	putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		sbErrorMessage.append(e.toString());
		out.println("alert(\" 61 :"+hmApply.toString()+"\");");
		out.println("alert(\" Exception@StController : "+e.toString()+"\");");
		out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
		out.println("assignResult(false, \"Exception@StController : "+e.toString()+"\", \"0\" ) ; ") ;
	}
%>
<%!
public String replaceNewLineChar(String message) 
{
	String changed = "";
	changed = message.replaceAll("\n","\\n/");
	changed = changed.replaceAll("\"","\\\"");
	changed = changed.replaceAll("'","\\\\'");	
	return changed;
}
/*   public String replaceNewLineChar(String message) {
StringBuffer sb= new StringBuffer();
try
{
String spChar[]={"\n","\""};
String chChar[]={"\\n","\\\""};

sb= new StringBuffer(message);
upper:  for(int i=0;i<sb.length();i++)
for(int j=0;j<spChar.length;j++)
{
if(spChar[j].equals(String.valueOf(sb.charAt(i))))
{
sb.deleteCharAt(i);
sb.insert(i,chChar[j].toCharArray());
continue upper;
}
}
}
catch(Exception e)
{
sb.append("Exception@replaceNewLineChar : "+e.toString());
}
return sb.toString();
}*/
%>

