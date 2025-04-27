<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eST.*, eST.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>


<%-- Mandatory declarations end --%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
    <script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/DirectSalesPatient.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	
</head>
<!-- onKeyDown="return lockKey()" -->
<body onMouseDown="CodeArrest()" >
<form name='QueryForm' id='QueryForm'>

<%
	/* Mandatory checks start */
	String 	mode			=	"";
	//String	readOnly	    =	"";
	//String	checked		    =	"";
	String	bean_id			=	"";
	String	bean_name	    =	"";
	//String  codeReadOnly	=	"";
	String	classvalue	    =	"";
	//String  patient_id	    =	"";
	//String	eff_status	    =	""; 
	//String  patient_name    =   "";
	String  patient         =   "";
	String  enabled         =   "";
	//String  checkValue      =   "";
	String  Patient_Name    =   "";
    boolean searched	    =  (request.getParameter("searched") == null) ?false:true;
		

	mode					=	request.getParameter( "mode" );
	bean_id = "directSalesPatient" ;
	bean_name = "eST.DirectSalesPatientBean";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	DirectSalesPatientBean bean = (DirectSalesPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);

	try
	{
			//bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		/* Initialize Function specific end */
	}
		catch(Exception e)
	{
		out.println("Exception@1: "+e);
	}

	/* Mandatory checks end */

	    //ArrayList DirectSalesResult=new ArrayList();
//		HashMap DirectSalesMapResult=new HashMap();

/*	if(mode.equals("2"))
	{
        DirectSalesResult=bean.loadData();
	}*/
try{
        HashMap sqlMap = new HashMap();
		//sqlMap.put("sqlData", "SELECT  A.PATIENT_ID , A.EFF_STATUS,B.PATIENT_NAME FROM ST_DIR_SALE_PATIENT_PARAM A,MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID ORDER BY A.ADDED_DATE ");
		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_DIR_SALE_PATIENT_PARAM_QUERY_RESULT"));
		sqlMap.put("sqlData","SELECT  A.PATIENT_ID , A.EFF_STATUS,B.PATIENT_NAME FROM ST_DIR_SALE_PATIENT_PARAM A,MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID ORDER BY B.PATIENT_NAME");
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

			displayFields.add("patient_id");
			displayFields.add("patient_name");
			displayFields.add("eff_status");		

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		//chkFields.add(patient_id);
		

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request );
       //out.println("result" +result.get(0));
        if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		
		%>
			<table cellpadding=0 cellspacing=0 width="100%"  align="center">
			<tr>
				<td width="80%" class="white" nowrap>&nbsp;</td>
				<td width="20%" class="white" nowrap>&nbsp;
				<%
					out.println(result.get(1));
				%>
</td>
</tr>
</table>
   <table cellpadding=0 cellspacing=0 border="1" width="100%" align="center">
	
<!-- 		<th align="center"></th>
 -->    <th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	

<%


	//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
				
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
								
%>                        
						<tr  >
<%

						//String link_columns = "1";

						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							patient=(String)records.get( colCount );
							enabled=(String)records.get( 2 );
							Patient_Name=(String)records.get( 1 );
					
							
							if(colCount==0)
						    {
%>                            <td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'"  ><font class='HYPERLINK' onClick="parent.Modify('<%=patient%>','<%=Patient_Name%>','<%=enabled%>');"><%=(String)records.get( colCount )%></font></td> <!--Incident no-SRR20056-SCF-6911 .Code modified to display the patient name in Thai by Sakti Sankar Boxi on 18-02-2011  -->
								
<%
							}

							
                             if(colCount==1 )
						{
							
							%>
							<td class="<%=classvalue%>">  <%=(String)records.get( colCount )%>&nbsp;   </td>
							<%
						}	



                          if((colCount==2 ) )
						{		
							
							
						%>


                               
							   <td class="<%=classvalue%>"><input type="hidden" name="enabled1" id="enabled1" value="<%=enabled%>">
	<%
		if(enabled.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(enabled.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}
	%>
	</td>
							   
							 
                             
							
							<%
							
                                
                                      
						  
						}
						
					}
			%>
			</tr>
		<%
		}
		%>
			<input type="hidden" name="patient" id="patient" value="<%=patient%>">
		</table>
		<%
			out.flush();
	}
	 else{
		%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eST/jsp/DirectSalesPatientQueryResult", searched) );
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%
   out.flush();
%>


<script>
	FocusFirstElement();
</script>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>





