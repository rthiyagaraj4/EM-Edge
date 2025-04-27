<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
17/06/2020 	  		       Ram kumar S											AAKH-CRF-0122
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.net.URLEncoder " %>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
    String callFrom = CommonBean.checkForNull(request.getParameter("callFrom" ));

if( !callFrom.equals("0") ) {%>
<html>
<head>
<title></title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eBL/js/cptResult.js"></script>
	<script language="Javascript" src="../../eBL/js/cptLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<%
    }
%>
<%
    
	String sqlData			= CommonBean.checkForNull(request.getParameter( "sqlData" ));
	System.err.println("CPT Query before "+sqlData);
	sqlData=sqlData.replace("a.pk_value( )","a.pk_value(+)");
	System.err.println("CPT Query after "+sqlData);
    String searchCriteria	= CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
   // String searchType		= CommonBean.checkForNull(request.getParameter( "searchType" ) ) ;
    String linkFields		= CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
    String displayOrder		= CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;
	String code_desc		= "CPT Code";
	String type_desc		= "Service Code";
	String desc_desc		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
    Enumeration paramnames	= request.getParameterNames();
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }

    boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

try{
    String classvalue = "" ;
    HashMap sqlMap = new HashMap();
    sqlMap.put( "sqlData", sqlData );
    HashMap funcMap = new HashMap();
    ArrayList displayFields = new ArrayList();

    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "CPTcode" );
        displayFields.add( "code" );
        displayFields.add( "description" );
    } else {
        displayFields.add( "CPTcode" );
        displayFields.add( "code" );
        displayFields.add( "description" );
    }
	
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
    for(; j<=count-1 ; i++,j+=2) {
        
		String fieldValue = request.getParameter( "f"+i ) ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;

		if(fieldValue != null)
        {
            if( fieldType.equals("String") )
                chkFields.add(fieldValue);
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
    
    funcMap.put( "displayFields", displayFields );
	System.err.println("displayFields "+displayFields);
    funcMap.put( "chkFields", chkFields );
	System.err.println("ChkFileds "+chkFields);
    funcMap.put( "searchCriteria", searchCriteria );
	System.err.println("searchCriteria "+searchCriteria);
    //funcMap.put( "searchType", searchType );

    ArrayList result = (ArrayList) CommonBean.getSearchQueryResultPage(pageContext,sqlMap, funcMap, request, true);
            System.err.println("Result size   "+result.size() + " ");
	for (int z = 0; z < result.size(); z++) 
            System.err.println("Result from View   "+result.get(z) + " ");
		
		
            System.err.println("Result from callFrom   "+callFrom + " ");
	if( !callFrom.equals("0") ) {

    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    %>
        <table cellpadding=0 cellspacing=0 width="100%" align="center">
        <tr>
        <td width="40%" class="white">&nbsp;</td>
		<td width="40%" class="white">&nbsp;</td>
        <td width="20%" class="white">&nbsp;
    <%
         out.println(result.get(1));
		 System.err.println("Result l_blng_serv_desc   "+result.get(1) + " ");
    %>
        </td>
		</tr>
        </table>

    <table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id="ResultTab">
    <% 
     
		 System.err.println("CODE_DESC displayOrder  "+displayOrder + " ");
	if( displayOrder.equals("CODE_DESC") ) { %>
            <th><%=code_desc%></th><th><%=type_desc%></th><th><%=desc_desc%></th>
    <%  } else { %>
            <th><%=desc_desc%></th><th><%=type_desc%></th><th><%=code_desc%></th>
    <%  }  
     
	%>
    <%
	ArrayList records=new ArrayList();
	
	for(int recCount=2; recCount<result.size(); recCount++) {

		if ( recCount % 2 == 0 )
			classvalue = "gridData" ;
		else
			classvalue = "gridData" ;
    %>
        <tr onClick="ModifyRes('<%=recCount%>');" >
    <%
        String link_columns = linkFields ;
		records = (ArrayList) result.get( recCount );
		String retval = "";
		 System.err.println("linkFields   "+linkFields + " ");
        for(int colCount=0; colCount<records.size(); colCount++){

			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
    %>
               <td class="<%=classvalue%>"  style="text-align: center;" onmouseover="changeCursor(this);" ><font class='HYPERLINK' ><%=(String)records.get( colCount )%></font></td>
    <%      }else{ %>
               <td class="<%=classvalue%>" style="text-align: center;" onclick="disableClick(event);" style='WORD-BREAK:BREAK-ALL;'><%=(String)records.get( colCount )%></td>
    <%
            }

			retval=retval+"~"+(String)records.get( colCount );	
			System.err.println("Values returning  "+retval);
			
        }
    %>		<input type="hidden" name ="hd_<%=recCount%>" value="<%=retval%>">

            </tr>
    <%
        }
    %>
        </table>
    <%
        if( ((String) result.get(0)).equals("1") ) {
    %>
        <script>
        </script> 
    <%
        }
        out.flush();
    }else{
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
    out.println(CommonBean.setForm ( request ,"cptLookupResult.jsp", searched) );
	
	}
	else
	{
			System.err.println("records 0  "+result.get(0));
        if( ((String) result.get(0)).equals("1") )
        {
            java.util.ArrayList records = (java.util.ArrayList) result.get( 2 );
			System.err.println("records returning  "+result.get(2));
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
} catch(Exception e) {
    out.print("Exception @ Result JSP :"+e.toString());
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

