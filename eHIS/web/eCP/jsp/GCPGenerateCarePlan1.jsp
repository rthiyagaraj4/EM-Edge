<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String callFrom        = CommonBean.checkForNull( request.getParameter( "callFrom" ) ) ;

if( !callFrom.equals("0") ) {%>
<html>
    <head> 
        <title></title>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>        
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
       <!--  <script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script> -->
    <script language="Javascript" src="../../eCP/js/GCPGeneratePlanMenu.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
    }
%>

<%
    //Search Criteria's from Query Criteria page
//	String sqlData = "SELECT FREQ_CODE,FREQ_DESC,REPEAT_DURN_TYPE,REPEAT_VALUE FROM AM_FREQUENCY WHERE EFF_STATUS = 'E' ORDER BY 2 ";
    String sqlData         = CommonBean.checkForNull( request.getParameter( "sqlData" ) );
    String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    //String linkFields      = CommonBean.checkForNull( request.getParameter( "linkFields" ) ) ;
    String displayOrder    = CommonBean.checkForNull( request.getParameter( "displayOrder" ) ) ;
	//String cod=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	//String desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
//out.println("<script>alert('displayOrder::"+displayOrder+"')</script>");    
    Enumeration paramnames = request.getParameterNames() ;
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }
    boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;

try{
    String classvalue           = "" ;
    HashMap sqlMap = new HashMap();
    //include all the common parameters.
    sqlMap.put( "sqlData", sqlData );
    
    //Function Parameters
    HashMap funcMap = new HashMap();

    //The fields are going to be display
    ArrayList displayFields = new ArrayList();
/*	displayFields.add("FREQ_CODE");
	displayFields.add("FREQ_DESC");
	displayFields.add("REPEAT_DURN_TYPE");
	displayFields.add("REPEAT_VALUE");*/
    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "code" );
        displayFields.add( "description" );
		displayFields.add("REPEAT_DURN_TYPE");
		//displayFields.add("REPEAT_VALUE");
    } else {
        displayFields.add( "description" );
        displayFields.add( "code" );
		displayFields.add("REPEAT_DURN_TYPE");
		//displayFields.add("REPEAT_VALUE");
    }


    //The fields are going to be in where condition * should match with the query
//    out.println( "alert(\""+sqlData+"\")" );
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
//    out.println( "here 2.1 " );
    for(; j<=count-1 ; i++,j+=2) {
       String fieldValue = request.getParameter( "f"+i ) ;
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

    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext, sqlMap, funcMap, request, true);
//    out.println (result)  ;

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
    <%  if( displayOrder.equals("CODE_DESC") ) { %>
           <th><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.FrequencyDescription.label" bundle="${common_labels}"/></th><!-- <th>Duration Unit</th><th >Repeat Value</th> -->
    <% } else { %>
           <th><fmt:message key="Common.FrequencyDescription.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th> 
    <% }   %>
    <%
        //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "QRYEVEN" ;
            else
                classvalue = "QRYODD" ;
    %>
            <tr onClick="Modify(this);" >
    <%

				String link_columns = "1";
         //   String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

            for(int colCount=0; colCount<records.size(); colCount++){

 //           out.println((String) result.get(0)) ;

                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
    %>
                    <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )==null?"&nbsp;":(String)records.get( colCount )%></font></td>
    <%          }else{ 
					if(colCount==2 ){%>
					 <td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none">
					<INPUT TYPE="hidden" value=<%=(String)records.get( colCount)==null?"&nbsp;":(String)records.get( colCount )%>></td>
				<%
					continue ;
					}//if(colCount==3 ){%>
					<!--  <td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none">
					<INPUT TYPE="hidden" value=<%=(String)records.get( colCount)==null?"&nbsp;":(String)records.get( colCount )%>></td> -->
				<%
					//continue ;
				//	}		
		
	%>
                    <td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( colCount )==null?"&nbsp;":(String)records.get( colCount )%></td>
    <%				
                }
            }
    %>
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

              var argArray = window.dialogArguments ;
              if ( argArray[5] != "" )
                 document.getElementById("ResultTab").rows[1].click() ;
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
                        alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
                    }
                }
                else
                {
                    alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
                }
                
		         
                    
       </script>
    <%
    }
        out.println(CommonBean.setForm ( request ,"GCPGenerateCarePlan1.jsp", searched) );
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
} catch(Exception e) {
  //  out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
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

