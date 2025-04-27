
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.io.*, eSS.Common.*, eSS.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
		StringBuffer sbErrorMessage			=		 new StringBuffer();
		HashMap hmApply						=		 new HashMap();
try {
		Hashtable htXMLObj					=		(Hashtable) xmlObj.parseXMLString( request ) ;
		htXMLObj							=		(Hashtable) htXMLObj.get( "SEARCH" ) ;

		eSS.Common.SsAdapter beanObj		=		null;
		String bean_id						=		(String) htXMLObj.get( "bean_id" );
		String bean_name					=		(String) htXMLObj.get( "bean_name" );
		Object beanObject = null ;
		
		// System.out.println("MAP: " + htXMLObj.toString());
		
		// Added by marwan to solve the null session value in AutoclavingBean validate
		// Since checkedboxes are saved in session so the first if to handle it
		if("eSS.AutoclavingBean".equals(bean_name)){
			AutoclavingBean ACBean = (AutoclavingBean)getBeanObject( bean_id, bean_name, request ) ;
			if("updateAutoClave".equals((String) htXMLObj.get("function"))){
				ArrayList alAutoclavingList = (ArrayList)session.getAttribute("alAutoclavingList");
				HashMap hmAutoclavingRecord=new HashMap();
			    for(int i=0;i<alAutoclavingList.size();i++)
				{
					hmAutoclavingRecord	=	(HashMap)alAutoclavingList.get(i);
					if(((String) htXMLObj.get("tray_no")).equals(hmAutoclavingRecord.get("tray_no")))
					{
						hmAutoclavingRecord.put("SELECTED", (String) htXMLObj.get("val"));
					}
				}
				return ;
			} else {
				ACBean.setLanguageId((String) session.getAttribute("LOCALE"));
				ACBean.setLoginFacilityId((String) session.getAttribute("facility_id"));
				ACBean.setLoginById((String) session.getAttribute("login_user")) ;		
				ACBean.setSession(session);
			}
			beanObject = (eSS.Common.SsAdapter)ACBean;
		} else {
			beanObject					=		(eSS.Common.SsAdapter)getBeanObject( bean_id, bean_name, request ) ;		
		}
		if (beanObject  instanceof eSS.Common.SsAdapter) 	{
			beanObj							=		(eSS.Common.SsAdapter) beanObject;
		}
		else {
			return;
		}
		htXMLObj.remove( "bean_id" ) ;
		htXMLObj.remove( "bean_name" );

		beanObj.setMode((String) htXMLObj.get("mode"));

		beanObj.setAll(htXMLObj) ;

		HashMap hmValidate					=		beanObj.validate() ;

		boolean validated					=		((Boolean) hmValidate.get("result")).booleanValue() ;
		String validationMessage			=		(String) hmValidate.get("message");

		if (beanObject  instanceof eSS.PackingBean) 	{
			((eSS.PackingBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eSS.PackingBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

	if ( validated ) {
		hmApply								=		beanObj.apply() ;

		boolean result						=		((Boolean) hmApply.get("result")).booleanValue() ;

		String message						=		(String) hmApply.get("message");
		String flag							=		beanObj.checkForNull((String) hmApply.get("flag"));
		String invalidCode					=		"" ;

		if(hmApply.get( "invalidCode" ) != null) {
			Object object					=		hmApply.get("invalidCode");
			if (object instanceof String) {
				invalidCode					=		(String) hmApply.get( "invalidCode" ) ;
			}
			else if  (object instanceof java.util.ArrayList) {
				java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
				for (int i=0;i<tempCode.size() -1;i++) {
					invalidCode				 =	invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
				}
				if ((tempCode.size() == 1) || (tempCode.size() > 1)) {
					invalidCode				=	invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
				}
			}
			out.println(" assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\" ) ; ") ;
		} 
		else if(message != null){
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		else if(hmApply.get("msgid")!=null) {
			out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\",'SS'), \""+flag+"\" ) ; ") ;
		}
		else {
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(hmValidate.get("msgid")!=null) {
		out.println("assignResult(" + validated + ", getMessage(\"" + hmValidate.get("msgid").toString()+ "\",'SS'), \"\" ) ; ") ;
	}
	else {
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"\" ) ; ") ;
	}
 putObjectInBean(bean_id,beanObject,request);
}
catch (Exception e) {
	e.printStackTrace();
	sbErrorMessage.append(e.toString());
	//out.println("alert(\" 61 :"+hmApply.toString()+"\");");
	//out.println("alert(\" Exception@SsController : "+e.toString()+"\");");
	//out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
	out.println("assignResult(false, \"Exception@SsController : "+e.toString()+"\", \"0\" ) ; ") ;
}
%>

<%!
   public String replaceNewLineChar(String message) {

	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]	=	{"\n","\""};
        String chChar[]	=	{"\\n","\\\""};

        sb				=	new StringBuffer(message);
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
    }
%>
