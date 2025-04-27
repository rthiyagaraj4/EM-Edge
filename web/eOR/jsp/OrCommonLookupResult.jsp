
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*, eCommon.Common.*,java.lang.reflect.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<% 
    String callFrom        = CommonBean.checkForNull( request.getParameter( "callFrom" ) ) ;

	if( !callFrom.equals("0") ) {%>
<html>
<% request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
    <head>
        <title></title>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javaScript" src="../../eOR/js/OrCommonLookup.js" ></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
    }
%>

<%
try{    //Search Criteria's from Query Criteria page

	String locale=(String)session.getAttribute("LOCALE") ;
	locale 		 = (locale == null )?"en":locale.toLowerCase();
    String sqlData         		= CommonBean.checkForNull( request.getParameter( "sqlData" ) );
    String searchCriteria  		= CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    String linkFields      		= CommonBean.checkForNull( request.getParameter( "linkFields" ) ) ;
    String displayOrder    		= CommonBean.checkForNull( request.getParameter( "displayOrder" ) ) ;
    String title           		= CommonBean.checkForNull( request.getParameter( "title" ) ) ;
	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	
	String repositoryKey		= CommonBean.checkForNull( request.getParameter( "repositoryKey" ) );
    String repositoryFullPath	= CommonBean.checkForNull( request.getParameter( "repositoryFullPath" ) ) ;
	String parName				= CommonBean.checkForNull( request.getParameter( "parNameArray" ) ) ;
	String parValue				= CommonBean.checkForNull( request.getParameter( "parValueArray" ) ) ;

	String repositoryQuery 		= "";
	
	if(!"".equals(repositoryKey) && !"".equals(repositoryFullPath)){
		
		try{ 		
			Class c = Class.forName(repositoryFullPath);
			Method m = c.getDeclaredMethod("getValue", String.class);	
			m.setAccessible(true);		
			repositoryQuery = CommonBean.checkForNull((String)m.invoke(null, repositoryKey));	
			String[] parNameArray=parName.split(",");
			String[] parValueArray=parValue.split(",");
			
			for(int i=0;i<parNameArray.length;i++){
				if (repositoryQuery.indexOf(parNameArray[i]) >= 0){
					repositoryQuery = repositoryQuery.replaceAll(parNameArray[i],parValueArray[i]);
				} 
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}/* catch (InstantiationException e) {
			e.printStackTrace();
		} */catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!"".equals(repositoryQuery)){
			if((repositoryQuery.toUpperCase().indexOf("ORDER BY"))>-1)
				repositoryQuery=repositoryQuery.substring(0,repositoryQuery.toUpperCase().indexOf("ORDER BY"));
			sqlData=repositoryQuery+" "+sqlData;
		}
	}
	 Enumeration paramnames = request.getParameterNames() ;
	 
    /*while (paramnames.hasMoreElements()) {
        String paramName = (String)paramnames.nextElement();
        String paramValue = request.getParameter(paramName);
        out.println(paramName + " = " + paramValue + "<br>");
    }*/
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
	/*if(str.equals( "from" )){
	   out.println( "from = " + request.getParameter(str) + "<br>");
	}
	if(str.equals( "to" )){
	   out.println( "to = " + request.getParameter(str) + "<br>");
	}*/
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }
    boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;


    String classvalue           = "" ;
    HashMap sqlMap = new HashMap();
    //include all the common parameters.
    //out.println(sqlData) ;
    
    sqlMap.put( "sqlData", sqlData );

    //Function Parameters
    HashMap funcMap = new HashMap();

    //The fields are going to be display
    ArrayList displayFields = new ArrayList();

    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "code" );
        displayFields.add( "description" );
    } else {
        displayFields.add( "description" );
        displayFields.add( "code" );
    }


    //The fields are going to be in where condition * should match with the query
//    out.println( "alert(\""+sqlData+"\")" );
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
    for(; j<=count-1 ; i++,j+=2) {
        String fieldValue = request.getParameter( "f"+i )  ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;

//        out.println( "alert(\""+fieldValue + ":" + fieldType+"\")" );

        if(fieldValue != null)
        {
            if( fieldType.equals("String") )
                chkFields.add( fieldValue );
            else if ( fieldType.equals("Integer") )
                chkFields.add( new Integer( Integer.parseInt(fieldValue) ) );
            else if ( fieldType.equals("Long") )
                chkFields.add( new Long( Long.parseLong(fieldValue) ) );
            else if ( fieldType.equals("Float") )
                chkFields.add( new Float( Float.parseFloat(fieldValue) ) );
            else if ( fieldType.equals("Double") )
                chkFields.add( new Double( Double.parseDouble(fieldValue) ) );
        }

    }

    
    // Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );

    //Calling the Result from Common Adaptor as a arraylist.

    /*
    Enumeration<String> attributeNames = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
    while (attributeNames.hasMoreElements()) {
        String attributeName = attributeNames.nextElement();
        Object attributeValue = pageContext.getAttribute(attributeName);
        System.out.println(attributeName + ": " + attributeValue);
    }*/
    
    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request, true);
    

if( !callFrom.equals("0") ) {
    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    %>
        <table cellpadding=0 cellspacing=0 width="100%" align="center">
        <tr>
        <td width="80%" class="white">&nbsp;</td>
        <td width="20%" class="white">&nbsp;
    <%
        // For display the previous/next link
         out.println(result.get(1));
    %>
        </td></tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id="ResultTab">
    <% 
     
	if( displayOrder.equals("CODE_DESC") ) { %>
            <th><%=code_desc%></th><th><%=desc_desc%></th>
    <%  } else { %>
            <th><%=desc_desc%></th><th><%=code_desc%></th>
    <%  }  
     
	%>
    <%
        //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
		
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "gridData" ;
            else
                classvalue = "gridData" ;
			
    %>
          <!--   <tr onClick="Modify(this);" > -->
            <tr onClick="Modify('<%=recCount%>');" >
    <%

            //String link_columns = "1,2";
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

			String retval="";

            for(int colCount=0; colCount<records.size(); colCount++){

 //           out.println((String) result.get(0)) ;

                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
    %>
                    <td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'" ><font class='HYPERLINK' ><%=(String)records.get( colCount )%></font></td>
    <%          }else{ %>
                    <td class="<%=classvalue%>" onclick="disableClick(event);" style='WORD-BREAK:BREAK-ALL;'><%=(String)records.get( colCount )%></td>
    <%
                }
			retval=retval+"~"+(String)records.get( colCount );
						
            }
    %>		<input type="hidden" name ="hd_<%=recCount%>" id="hd_<%=recCount%>" value="<%=retval%>">

            </tr>
    <%
        }
    %>
        </table>
    <%
        if( ((String) result.get(0)).equals("1") ) {
    %>
        <script> 
            //parent.lookup_cancel.close.click();

              //var argArray = window.dialogArguments ; commented as b'coz while click on next and if there is only one record it is defaulting,but it should not default.IN010406
              //if ( argArray[5] != "" )
                 //document.getElementById("ResultTab").rows[1].click() ;
        </script> 
    <%
        }
        out.flush();
    } else{
    %>
        <script>

                if(!parent.lookup_head.chkBothCriteria )
                {
                    if(parent.lookup_head.fromCalledPage)
                    {
                        parent.lookup_head.chkBothCriteria = true;
                        parent.lookup_head.document. CriteriaForm .elements[1].click()
                        parent.lookup_head.document. CriteriaForm .Search.click()
                    }
                    else
                    {
                        alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
                    }
                }
                else
                {
                    alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
                }



       </script>
    <%
    }
        out.println(CommonBean.setForm ( request ,"OrCommonLookupResult.jsp", searched) );
   }
   else
   {
        if( ((String) result.get(0)).equals("1") )
        {
            java.util.ArrayList records = (java.util.ArrayList) result.get( 2 );
    %>
            firstCodeVal = "<%=records.get(1)%>" ;
            firstDescVal = "<%=records.get(0)%>" ;
    <%
        }
   }
   sqlMap.clear();
   funcMap.clear();
   displayFields.clear();
   chkFields.clear();
   result.clear();
   //records.clear();
} catch(Exception e) {
    System.err.println("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}

if( !callFrom.equals("0") ) {
%>
    <script>
		if( parent.lookup_head.document. CriteriaForm .Search != null )
			if( parent.lookup_head.document. CriteriaForm .Search.disabled )
				parent.lookup_head.document. CriteriaForm .Search.disabled = false;
	</script>
	</body>
    </html>
<% } %>

