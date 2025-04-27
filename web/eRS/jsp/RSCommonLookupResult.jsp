<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%
   String callFrom        = CommonBean.checkForNull( request.getParameter( "callFrom" ) ) ;

if(!callFrom.equals("0") ) 
{
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
<script src="../js/RSCommon.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
    }
%>
<%
    //Search Criteria's from Query Criteria page
    String sqlData        = CommonBean.checkForNull(request.getParameter("sqlData"));
    String searchCriteria = CommonBean.checkForNull(request.getParameter("sc"));
    String linkFields     = CommonBean.checkForNull(request.getParameter("linkFields"));
    String displayOrder   = CommonBean.checkForNull(request.getParameter("displayOrder")) ;
    String title          = CommonBean.checkForNull(request.getParameter("title")) ;

    Enumeration paramnames = request.getParameterNames() ;
    int count = 0;
    while( paramnames.hasMoreElements())
	{
        String str = (String)paramnames.nextElement() ;
        if( str.equals("from") || str.equals("to") || str.equals("searched") || str.equals( "sc") || str.equals("linkFields") || str.equals("displayOrder") || str.equals("callFrom") )
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
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;

	for(; j<=count-1 ; i++,j+=2) 
	{
        String fieldValue = request.getParameter( "f"+i ) ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;

        if(fieldValue != null)
        {
            if(fieldType.equals("String"))
                chkFields.add( fieldValue);
            else if (fieldType.equals("Integer"))
                chkFields.add( new Integer(Integer.parseInt(fieldValue)));
            else if (fieldType.equals("Long"))
                chkFields.add( new Long( Long.parseLong(fieldValue)));
            else if (fieldType.equals("Float") )
                chkFields.add( new Float( Float.parseFloat(fieldValue)));
            else if (fieldType.equals("Double"))
                chkFields.add(new Double( Double.parseDouble(fieldValue)));
        }
    }


    // Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );

    //Calling the Result from Common Adaptor as a arraylist.

    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,true);
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
            <%if (title.equals("Practitioner")) {%>
            <th  width='2%'>&nbsp;</th>
            <%}%>
            <th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
    <%  } else { %>
            <%if (title.equals("Practitioner")) {%>
            <th  width='2%'>&nbsp;</th>
            <%}%>
            <th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
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
            <tr>
    <%

            //String link_columns = "1,2";
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );
            if (title.equals("Practitioner")) {
                if( displayOrder.equals("CODE_DESC") ) {%>
            <td class="<%=classvalue%>" width='2%'><a href="javascript:showPractWindow('<%=(String)records.get(0)%>')">+</a></td>
            <%  } else {%>
                    <td class="<%=classvalue%>" width='2%'><a href="javascript:showPractWindow('<%=(String)records.get(1)%>')">+</a></td>
            <%  }
            }
            for(int colCount=0; colCount<records.size(); colCount++){

            if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
    %>
                    <td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="RSModify('<%=recCount%>');" id='code<%=recCount%>'><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
    <%          }else{ %>
                    <td class="<%=classvalue%>" onclick="disableClick(event);" id='desc<%=recCount%>'><%=(String)records.get( colCount )%></td>
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
        out.println(CommonBean.setForm ( request ,"RSCommonLookupResult.jsp", searched) );
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
    out.print("Exception @ Result JSP :"+e.toString());
}

if( !callFrom.equals("0") ) {
%>
    <script>
		if( parent.lookup_head.document.CriteriaForm.Search != null )
			if( parent.lookup_head.document.CriteriaForm.Search.disabled )
				parent.lookup_head.document.CriteriaForm.Search.disabled = false;
	</script>
	</body>
    </html>
<% } %>

