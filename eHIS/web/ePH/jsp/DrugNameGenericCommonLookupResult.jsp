<!DOCTYPE html>
<!-- /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History         Name        Rev.Date         Rev.By		            Description
--------------------------------------------------------------------------------------------------------
21/01/2021	 TFS-12204          Prabha      21/01/2021	  Manickavasagam J         MMS-DM-CRF-0177
03/02/2021		TFS-15266          Haribabu   03/02/2021     Manickavasagam J           NMC-JD-ICN-0017
--------------------------------------------------------------------------------------------------------
*/
-->
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.net.URLEncoder,eCommon.XSSRequestWrapper " %>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

	String locale			= (String)session.getAttribute("LOCALE");
    String callFrom        = CommonBean.checkForNull(request.getParameter( "callFrom" ) ) ;
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
        <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
        <script src="../../ePH/js/DrugNameCommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<%
    }
%>

<%
try{    //Search Criteria's from Query Criteria page
	String searchCriteria  = CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
	String linkFields      = CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
	String displayOrder    = CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;

	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	String ind_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericName/TradeName.label","ph_labels");
    Enumeration paramnames = request.getParameterNames() ;

	String params = request.getQueryString() ;

    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }
    boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;

    String classvalue           = "" ;
    HashMap sqlMap = new HashMap();
    //include all the common parameters.
    sqlMap.put( "sqlData", "SELECT  GENERIC_ID  code,  GENERIC_NAME  description, 'G' IND  FROM  PH_GENERIC_NAME_LANG_VW  PH_GENERIC_NAME    WHERE   UPPER(GENERIC_ID)  LIKE  UPPER(?)  AND  UPPER(GENERIC_NAME)  LIKE  UPPER(?) AND LANGUAGE_ID = '"+locale+"' AND EFF_STATUS ='E' UNION ALL SELECT DISTINCT A.TRADE_CODE code,B.LONG_NAME description, 'T' IND FROM PH_TRADE_NAME_FOR_DRUG A, AM_TRADE_NAME_LANG_VW b, ph_drug c WHERE UPPER(A.TRADE_CODE) LIKE UPPER(?) AND UPPER(B.LONG_NAME) LIKE UPPER(?) AND A.TRADE_CODE = B.TRADE_ID and a.drug_code=c.drug_code and c.drug_search_by='T' AND B.EFF_STATUS ='E' AND B.LANGUAGE_ID = '"+locale+"' ORDER BY 1" ); //Modified for NMC-JD-ICN-0017


    //Function Parameters
    HashMap funcMap = new HashMap();

    //The fields are going to be display
    ArrayList displayFields = new ArrayList();

    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "code" );
        displayFields.add( "description" );
        displayFields.add( "IND" );
    } else {
        displayFields.add( "description" );
        displayFields.add( "code" );
        displayFields.add( "IND" );
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
    chkFields.addAll(chkFields);
    
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );

    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request, true);

if( !callFrom.equals("0") ) {

    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    %>
        <table cellpadding=0 cellspacing=0 width="100%" align="center">
        <tr>
        <td width="80%" class="white">&nbsp;</td>
        <td width="20%" class="white">&nbsp;
    <%
         out.println(result.get(1));
	 %>
	
        </td></tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id="ResultTab">
    <% 
     
	if( displayOrder.equals("CODE_DESC") ) { %>
            <th><%=code_desc%></th><th><%=desc_desc%></th><th><%=ind_desc%></th>
    <%  } else { %>
            <th><%=desc_desc%></th><th><%=code_desc%></th><th><%=ind_desc%></th>
    <%  }  
     
	%>
    <%
        
        ArrayList records=new ArrayList();
			System.err.println("156==>result.size()==>"+result.size());

        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "gridData" ;
            else
                classvalue = "gridData" ;
			
    %>
         
            <tr onClick="ModifyNew('<%=recCount%>');" >
    <%
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

			String retval="";

            for(int colCount=0; colCount<records.size(); colCount++){

                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
    %>
                    <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK' ><%=(String)records.get( colCount )%></font></td>
    <%          }else{ %>
                    <td class="<%=classvalue%>" onclick="disableClick(event);" style='WORD-BREAK:BREAK-ALL;'><%=(String)records.get( colCount )%></td>
    <%
                }
			retval=retval+"~"+(String)records.get( colCount );
						
            }
    %>		<input type="hidden" name ="hd_<%=recCount%>" value="<%=retval%>">

            </tr>
    <%
        }
    %>
        </table>
    <%
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
        out.println(CommonBean.setForm ( request ,"DrugNameGenericCommonLookupResult.jsp", searched) );
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

