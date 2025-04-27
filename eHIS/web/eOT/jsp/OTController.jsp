
<%//@ page  import="java.sql.*, java.util.*, java.io.*, eOT.Common.*" contentType="text/html;charset=" %>
<%@page  import="java.util.Hashtable,java.util.HashMap,eOT.Common.*,javax.servlet.http.HttpServletRequest,javax.xml.parsers.DocumentBuilder,javax.xml.parsers.DocumentBuilder,javax.xml.parsers.DocumentBuilderFactory,eCommon.XSSRequestWrapper,org.w3c.dom.*,org.xml.sax.InputSource" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
/*
	Developed by 	:	Bhavani Shankar 
	Created on 		:	20/02/2005
	Module			:	OT
	Function		:	OTController.jsp
*/

try {
    //Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
	Hashtable hash = (Hashtable)parseXMLString1( request ) ; 
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	//System.err.println("hash====="+hash);
	String bean_id = (String) hash.get( "bean_id");
    String bean_name = (String) hash.get( "bean_name");
    System.out.println(" ************* OTController JSP bean_name : "+bean_name+" bean_id : "+bean_id);
    OTAdapter beanObj = (OTAdapter)mh.getBeanObject( bean_id, request, bean_name ) ;
    System.out.println("beanObj value in 32 :"+beanObj);
    hash.remove( "bean_id" );
    hash.remove( "bean_name" );
	beanObj.setAll(hash);
    HashMap map = beanObj.validate() ;
	//out.println("alert(\"map" + map + "\");"); 
    boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
    String validationMessage = (String) map.get( "message" ) ;
    System.out.println(" ************* OTController JSP validationMessage : "+validationMessage);
	//out.println("alert(\"validated value" + validated + "\");"); 
    if ( validated ) {
		map = beanObj.apply();
		//out.println("alert(\"" + map + "\");") ;
        boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
      //String  result = ((String) map.get( "result" ));
        String message = (String) map.get( "message" ) ;

        String flag = (String) map.get( "flag" );

        String invalidCode = "" ;
        if(map.get("invalidCode") != null)
            invalidCode = (String) map.get( "invalidCode" ) ;

        out.println("assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ;
    } else {
        out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\", \"0\" ) ; ") ;
    }
	map=null;
}catch (Exception e) {
	e.printStackTrace();
    //out.println("alert(\"Exception in Controller.jsp : " +e+ "\")") ;
}
%>
<%!
  public Hashtable parseXMLString1(HttpServletRequest httpservletrequest)
    {  
		//System.err.println("66===");
        Object obj = null;
        Hashtable hashtable = new Hashtable();
        try
        {
            java.io.BufferedReader bufferedreader = httpservletrequest.getReader();
            InputSource inputsource = new InputSource(bufferedreader);
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            Document document = documentbuilder.parse(inputsource);
            Element element = document.getDocumentElement();
            NodeList nodelist = element.getChildNodes();
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Element element1 = (Element)nodelist.item(i);
                NamedNodeMap namednodemap = element1.getAttributes();
                Hashtable hashtable1 = new Hashtable();
                for(int j = 0; j < namednodemap.getLength(); j++)
                {
                    Node node = namednodemap.item(j);
                    String s = node.getNodeValue();
                    s = s.replace('"', '\n');
				    //System.err.println("s==="+s);
                    hashtable1.put(node.getNodeName(), s);
                }

                hashtable.put(element1.getTagName(), hashtable1);
            }

        }
        catch(Exception exception)
        {
            hashtable.put("error", exception.toString());
        }
        return hashtable;
    }

%>
