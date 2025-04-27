<!DOCTYPE html>
<%@page import="java.util.*, ePO.*, ePO.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%
request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
//locale ="en";
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
StringBuffer sbErrorMessage = new StringBuffer();
HashMap hmApply = new HashMap();
String message ="";
try {
	Hashtable htXMLObj = (Hashtable) xmlObj.parseXMLString( request ) ;
    htXMLObj = (Hashtable) htXMLObj.get( "SEARCH" ) ;

	ePO.Common.PoAdapter beanObj = null;
	String bean_id = (String) htXMLObj.get( "bean_id" );
	String bean_name = (String) htXMLObj.get( "bean_name" );
	//out.println("alert(\"bean_name: " +bean_name+"\");" );
	//out.println("alert(\"XMLObj: " +htXMLObj+"\");" );
	Object beanObject = (ePO.Common.PoAdapter)getBeanObject( bean_id,bean_name,request); 
	if (beanObject  instanceof ePO.Common.PoAdapter) 	{
		beanObj = (ePO.Common.PoAdapter) beanObject;
	}
	else {
		return;
	}
	htXMLObj.remove( "bean_id" ) ;
	htXMLObj.remove( "bean_name" );
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		beanObj.setLocalEJB(false);

	beanObj.setMode((String) htXMLObj.get("mode"));
	System.out.println("htXMLObj = > "+htXMLObj);
	beanObj.setAll(htXMLObj) ;

	if (beanObject  instanceof ePO.STPORequestBean) 	{
			((ePO.STPORequestBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((ePO.STPORequestBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

		if (beanObject  instanceof ePO.PurchaseOrderBean) 	{
			((ePO.PurchaseOrderBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((ePO.PurchaseOrderBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

	HashMap hmValidate = beanObj.validate() ;

	boolean validated = ((Boolean) hmValidate.get("result")).booleanValue() ;
	//out.println("alert(\"hmvalidated  "+validated +"\");");
	String validationMessage = (String) hmValidate.get("message");

	if ( validated ) {
		hmApply = beanObj.apply() ;


		boolean result = ((Boolean) hmApply.get("result")).booleanValue() ;


		message = (String) hmApply.get("message");
		String flag = beanObj.checkForNull((String) hmApply.get("flag"));
		String invalidCode = "" ;
		
		if(hmApply.get( "invalidCode" ) != null) {
			Object object = hmApply.get("invalidCode");
			if (object instanceof String) {
				invalidCode = (String) hmApply.get( "invalidCode" ) ;
			}
			else if  (object instanceof java.util.ArrayList) {
				java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
				for (int i=0;i<tempCode.size() -1;i++) {
					invalidCode =invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
				}
				if ((tempCode.size() == 1) || (tempCode.size() > 1)) {
					invalidCode =invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
				}
			}
			out.println(" assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\" ) ; ") ;
		} 
		else if(hmApply.get("msgid")!=null) {//out.println("alert(\"message2"+message+"\");");

		message=message+"<BR>";
			//out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\"), \""+flag+"\" ) ; ") ;
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		else {
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(hmValidate.get("msgid")!=null) {
		//System.err.println("message----in hmvalidate---->"+message);
			String 	module_id="PO";
			//System.err.println("module_id----in hmvalidate---->"+module_id);
		out.println("alert(\"message4"+message+"\");");
		out.println("assignResult(" + validated + ", getMessage(\"" + hmValidate.get("msgid").toString()+ "\",\""+module_id+"\"), \"\" ) ; ") ;
	}
	else {
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"\" ) ; ") ;
	}
	putObjectInBean(bean_id,beanObj,request);

}
catch (Exception e) {
	e.printStackTrace();
	sbErrorMessage.append(e.toString());
	out.println("alert(\" 61 :"+hmApply.toString()+"\");");
	out.println("alert(\" Exception@MmController : "+e.toString()+"\");");
	out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
	out.println("assignResult(false, \"Exception@SsController : "+e.toString()+"\", \"0\" ) ; ") ;
}
%>

<%!
/*
Modified on 5/9/2006 as per TSG request
public String replaceNewLineChar(String message) {
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
    } */


	public String replaceNewLineChar(String message) {
		
		String changed = "";

        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\");	
        return changed;
}
%>
