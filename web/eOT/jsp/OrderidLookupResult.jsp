<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="eOT.SlateBean,java.util.Properties,java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>

<html>
    <head>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<%
    String callFrom        = CommonBean.checkForNull( request.getParameter( "callFrom" ) ) ;	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	if( !callFrom.equals("0") ) {
%>

        <title></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
        <script language="Javascript" src="../../eOT/js/Booking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>
<body>
<%
    }
%>

<%
    //Search Criteria's from Query Criteria page
	String facility_id	= (String) session.getAttribute("facility_id");
    String sqlData         = CommonBean.checkForNull( request.getParameter( "sqlData" ) );
    String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    String linkFields      = CommonBean.checkForNull( request.getParameter( "linkFields" ) ) ;
    String displayOrder    = CommonBean.checkForNull( request.getParameter( "displayOrder" ) ) ;
    
    java.util.Enumeration paramnames = request.getParameterNames() ;
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
//    out.println( "here 2.1 " );
    for(; j<=count-1 ; i++,j+=2) {
        String fieldValue = request.getParameter( "f"+i ) ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;
        
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
	
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean   bean  = (SlateBean)mh.getBeanObject(bean_id, request, bean_name);

    ArrayList result = (ArrayList) bean.getQueryResultPagproceduree(sqlMap, funcMap, request, true);

if( !callFrom.equals("0") ) {
    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    %>
        <table cellpadding=3  cellspacing=0 width="100%" align="center">
        <tr>
        <td width="80%" class="white">&nbsp;</td>
        <td width="20%" class="white">&nbsp;
    <%
        // For display the previous/next link

         out.println(result.get(1));
    %>
        </td></tr>
        </table>

        <table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" id="ResultTab">
    <%  if(displayOrder.equals("CODE_DESC") ) { %>
            <td class="ColumnHeader"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
			<td class="ColumnHeader"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
    <%  } else { %>
            <td class="ColumnHeader"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
			<td class="ColumnHeader"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
    <%  }   %>
    <%
        //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "QRYEVEN" ;
            else
                classvalue = "QRYODD" ;
    %>
            <tr onClick="Modifyorder(this);" >
    <%

            //String link_columns = "1,2";
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

            for(int colCount=0; colCount<records.size(); colCount++){

 //           out.println((String) result.get(0)) ;
				
                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
    %>				
                    <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
    <%          }else{ %>
                    <td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( colCount )%></td>
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
        out.println(CommonBean.setForm ( request ,"OrderidLookupResult.jsp", searched) );
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
	e.printStackTrace();
    //out.print("Exception @ Result JSP :"+e.toString());
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

