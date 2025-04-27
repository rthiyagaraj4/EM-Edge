<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/FormularyMast.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page

		String formulary_code		= request.getParameter( "formulary_code" )==null?"": request.getParameter( "formulary_code" );
		String formulary_desc		= request.getParameter( "formulary_desc" )==null?"":request.getParameter( "formulary_desc" ) ;
		String formulary_type		= request.getParameter( "formulary_type" )==null?"":request.getParameter( "formulary_type" ) ;
		
		String blg_grp_code		= request.getParameter( "blg_grp_code" )==null?"":request.getParameter( "blg_grp_code" ) ;
		
		String nature		= request.getParameter( "nature" )==null?"":request.getParameter( "nature" ) ;
		
		String facility_id=(String) session.getValue( "facility_id" );
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

		try{
			String classvalue			= "";
			String sql= "";	
			String billing_type="";
//			String formulary_desc="";
			String enable_status="";
			String	bean_id_1					=	"FormularyBillingGroupBean" ;
			String	bean_name_1					=	"ePH.FormularyBillingGroupBean";
			FormularyBillingGroupBean bean_1			= (FormularyBillingGroupBean)getBeanObject( bean_id_1, bean_name_1,request);
			
			String str_append="";
			if(!blg_grp_code.trim().equals(""))
				str_append =" AND a.BLNG_GRP_ID=?";
			HashMap sqlMap = new HashMap();

			sql="SELECT FORMULARY_CODE, FORMULARY_DESC, BLNG_GRP_TYPE, a.BLNG_GRP_ID,EFF_STATUS, (select b.short_desc from bl_blng_grp b,BL_BLNG_GRP_FACILITY c where a.BLNG_GRP_ID=b.BLNG_GRP_ID and a.BLNG_GRP_ID=c.BLNG_GRP_ID and b.BLNG_GRP_ID=c.BLNG_GRP_ID and a.FACILITY_ID =c.FACILITY_ID ) short_desc FROM  PH_FORMULARY_BLNG_GRP a WHERE  FORMULARY_CODE LIKE UPPER(?) AND UPPER(FORMULARY_DESC) LIKE UPPER(?) AND a.BLNG_GRP_TYPE LIKE UPPER(?)  "+str_append+" AND a.FACILITY_ID='"+facility_id+"'  AND UPPER(a.EFF_STATUS) LIKE UPPER(?)";
			sqlMap.put( "sqlData",sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add("FORMULARY_CODE");
			displayFields.add("FORMULARY_DESC");
			displayFields.add("BLNG_GRP_TYPE");
			displayFields.add("BLNG_GRP_ID");
			displayFields.add("EFF_STATUS");
			displayFields.add("short_desc");

    //The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			if(formulary_type.equals("X"))
				formulary_type = "";

			if(nature.equals("B"))
				nature = "";
		//added for GHL-SCF-1533		
		String formulary_code_value = formulary_code.trim()+ "%";
		String formulary_desc_value =  formulary_desc.trim() + "%";
		String formulary_type_value = formulary_type.trim() +"%";
		String nature_value = nature.trim() +"%";
		String blg_grp_code_value = blg_grp_code.trim();
		ArrayList result = bean_1.getFormularyQueryResult(formulary_code_value,formulary_desc_value,formulary_type_value,blg_grp_code_value,nature_value,facility_id);
		
		
		
		/*	chkFields.add(formulary_code.trim()+ "%" );
			chkFields.add(formulary_desc.trim() + "%" );
			chkFields.add(formulary_type.trim() +"%");
			if(!blg_grp_code.trim().equals(""))
			chkFields.add(blg_grp_code.trim());
			chkFields.add(nature.trim() +"%");
			System.err.println("chkFields=====>"+chkFields+"==displayFields===>"+displayFields);
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields ); */

					//Calling the Result from Common Adaptor as a arraylist.
			//ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request); // commented for GHL-SCF-1533


			if(result!=null && result.size()>0 ){ 
%>

				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<tr >
						<th rowspan='2'><fmt:message key="ePH.FormularyCode.label" bundle="${ph_labels}"/></th>
						<th rowspan='2'><fmt:message key="ePH.FormularyDescription.label" bundle="${ph_labels}"/></th>
						<th rowspan='2'>   <fmt:message key="ePH.FormularyType.label" bundle="${ph_labels}"/></th>
				
					<th rowspan='2'> <fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></th>
					<th rowspan='2'> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				
					</tr>
					<tr>
<%
						//Retriving the records from result arraylist
						ArrayList records=new ArrayList();
						ArrayList records1=null;
						ArrayList arr = new ArrayList();
						String billing_grp_id = "";
						String blng_grp_id    = "";
						int count =0;
						HashMap hm = new HashMap();
						String blg_grp_desc = "";
						String formulary_desc_encode="";
						int rowCount = 0; //GHL-SCF-1533
						for(int recCount=0; recCount<result.size(); recCount++) {

 						records1=(ArrayList) result.get( recCount );

						for(int i=0; i<records1.size(); i=i+6){
						formulary_code =(String) records1.get(i);
						blng_grp_id =(String) records1.get(i+3);
						blg_grp_desc = (String) records1.get(i+5);
						if(blg_grp_desc==null)
							blg_grp_desc = "";
						 if(hm!=null && hm.size()>0){
							if(hm.containsKey(formulary_code)){
								if(!blg_grp_desc.equals(""))
								 hm.put(formulary_code,(String)hm.get(formulary_code)+","+blg_grp_desc) ;
							}else{
								if(!blg_grp_desc.equals(""))
								hm.put(formulary_code,blg_grp_desc);
							}
						 }else{
							 if(!blg_grp_desc.equals(""))
							hm.put(formulary_code,blg_grp_desc);
						 }
						}
					}


						loop:
						for(int recCount=0; recCount<result.size(); recCount++) {
							count++;
/*							if ( rowCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ; */
%>
						<tr>
<%
						records=(ArrayList) result.get( recCount );
						
						for(int colCount=0; colCount<records.size(); colCount++){
							formulary_code =(String) records.get(colCount++);
							formulary_desc =(String)records.get(colCount++);
							billing_type =(String) records.get(colCount++);

							if(count==1)
								billing_grp_id= (String) records.get(colCount++);
							else 
								billing_grp_id= billing_grp_id +"," +(String) records.get(colCount++);
							
							enable_status =(String)records.get(colCount++);

							if(arr.contains(formulary_code)){
								continue loop;
							
							}
							rowCount++;
							
						}
						if(!arr.contains(formulary_code))
							arr.add(formulary_code);
						 formulary_desc_encode = java.net.URLEncoder.encode(formulary_desc);
 %>
					<td class='<%=classvalue%>'>&nbsp;<a href="#" onclick="getFormularyDetails('<%=formulary_code%>','<%=formulary_desc_encode%>','<%=billing_type%>','<%=enable_status%>')"><%=formulary_code%></a>
					</td>
					<td class='<%=classvalue%>'>&nbsp;<%=formulary_desc%>
					</td>
					<%if (billing_type.equals("C")){%>
					<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.Cash.label" bundle="${common_labels}"/>
					</td>
					<%}else{%>
				<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.Credit.label" bundle="${common_labels}"/>
					<%}%>			
					<td class='<%=classvalue%>'>&nbsp;<%=(String)hm.get(formulary_code)==null?"":(String)hm.get(formulary_code)%>
					</td>
					<td class='<%=classvalue%>'>
					<%if(enable_status.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else{%><img src="../../eCommon/images/disabled.gif"></img> <%}%>
					</td>


				</tr>
<%
			}
%>
			
<%
		
		}
		else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
<%
		}
		//out.println(CommonBean.setForm ( request ,"../../ePH/jsp/FormularyQueryResult.jsp", searched) );
	putObjectInBean(bean_id_1,bean_1,request);
	} catch(Exception e) {
		e.printStackTrace();
		out.print("Exception @ Result JSP :"+e.toString());
	
	}

%>
</table>
	</body>
</html>

