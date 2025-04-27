<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
    <TITLE></TITLE>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language='javascript'   src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../js/OrderCatalog.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">

	A:active {
		COLOR: white;
	}

	A:visited {
		COLOR: white;
	}
	A:link {
		COLOR: white;
	}
 
	</STYLE>
</HEAD>
<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='detailUpperForm' id='detailUpperForm' scrolling='auto' >
<%
    int noOfRecords = 0;
    try{

    	/* Mandatory checks start */
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    	String mode			 = request.getParameter( "mode" ) ;
		//out.println("####in hrd jsp,mode="+mode);
    	//String function_id	 = request.getParameter( "function_id" ) ;
    	String bean_id		 = "Or_OrderCatalog" ;
    	String bean_name	 = "eOR.OrderCatalogBean";
    	//String disabled		 = "" ;
    	//String eff_status	 = "Y" ;

    	//String module_id       = "";
    	//String function_name   = "";
    	//String function_type   = "";
    	//String menu_id         = "";
    	//String access          = "";
    	//String tabFlag         = "";
    	//String order_category  = "";
    	//String order_type_code = "";
		String checkType="N";
		String pri_sec_tasks_type_DefValue="O";
		String OrderableChecked="checked";
		String InterventionChecked="";
		
		String sec_task_updatable		 = "Y";
		String eff_status = "E";
			
    	//updatableIntialisation();
    	//out.println("1");


    	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
		bean.setLanguageId(localeName);
    	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

    	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
    	return ;

    	bean.setMode( mode ) ;
		HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();
		if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){

			//In modify mode if the eff status is no then all should be disabled
			eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
			eff_status	= eff_status.trim();
			if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
				sec_task_updatable	 =  "N" ;
			}
		}

       // module_id        = bean.checkForNull(request.getParameter("module_id"));
        //function_name    = bean.checkForNull(request.getParameter("function_name"));
      //  function_type    = bean.checkForNull(request.getParameter("function_type"));
       // menu_id          = bean.checkForNull(request.getParameter("menu_id"));
      //  access           = bean.checkForNull(request.getParameter("access"));
       // tabFlag          = bean.checkForNull(request.getParameter("tabFlag"));
       // order_category   = bean.checkForNull(request.getParameter("order_category"));
     //   order_type_code  = bean.checkForNull(request.getParameter("order_type_code"));

        HashMap pat_class =	bean.getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
		//System.out.println("###pat_class="+pat_class);
        //out.println(""+((Integer)pat_class.get("noRec")).intValue());
        Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
        noOfRecords   = noOfRecordsTemp.intValue() ;

        
        ArrayList prepRecStr = bean.getPrepRecStr();
        HashMap prepRec = new HashMap();
        if (prepRecStr.size() > 0)
            prepRec = (HashMap)prepRecStr.get(0);
//System.out.println("#####in jsp,prepRecStr="+prepRecStr);
//System.out.println("#####in jsp,prepRec="+prepRec);
//System.out.println("####noOfRecords"+noOfRecords);

%>
<table border='0' cellpadding=3 cellspacing=0 width="100%" align="center" > <%-- id="prep_hdr_tab" --%>
   <%
	checkType=(String)bean.getType("CP");
		
	if(checkType.equals("Y"))
		{	
		
		if (prepRecStr.size()!=0)
	{
			int tot_recs=Integer.parseInt((String)prepRec.get("tot_recs"));
			for(int i=0;i<tot_recs;i++)
				{
					if (prepRec.containsKey("patient_class"+i))
					{
						pri_sec_tasks_type_DefValue=(String)prepRec.get("pri_sec_tasks_type"+i)==null?"O":(String)prepRec.get("pri_sec_tasks_type"+i);
						if (pri_sec_tasks_type_DefValue.equals("I"))
						{
							OrderableChecked="";
							InterventionChecked="checked";
						}
					}
				
				}
		/*pri_sec_tasks_type_DefValue=(String)prepRec.get("pri_sec_tasks_type0")==null?"O":(String)prepRec.get("pri_sec_tasks_type0");
		if (pri_sec_tasks_type_DefValue.equals("I"))
		{
			OrderableChecked="";
			InterventionChecked="checked";
		}*/
	}
	//out.println("##OrderableChecked="+OrderableChecked+", InterventionChecked="+InterventionChecked);
		%>

	<tr>
		<td class='labelleft' colspan='8' >
		<fmt:message key="Common.type.label" bundle="${common_labels}"/><input type="radio" name="Type" id="Type" value="O" onClick="changeType(this,'<%=noOfRecords%>')" <%=OrderableChecked%> <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/><input type="radio" name="Type" id="Type" value="I" onClick="changeType(this,'<%=noOfRecords%>')" <%=InterventionChecked%> <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><fmt:message key="Common.Intervention.label" bundle="${common_labels}"/></td>
	</tr>  
			
	<%	}//out.println("##pri_sec_tasks_type_DefValue="+pri_sec_tasks_type_DefValue);
		%>  
	<input type="hidden" name="pri_sec_tasks_type" id="pri_sec_tasks_type" value="<%=pri_sec_tasks_type_DefValue%>">
<tr><td class="COLUMNHEADER" colspan='8' ><fmt:message key="eOR.PatientClassApplicability.label" bundle="${or_labels}"/>  </td><tr>

       <% if (noOfRecords > 0) {%>
        <tr>
			
            <%for (int i = 0; i < noOfRecords; i++) {
				
				String checked = "";
                String patient_class  = (String)pat_class.get("PATIENT_CLASS"+(i+1));
                String patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+(i+1));

                if (prepRec.containsKey("patient_class"+i))
                    checked = "checked";
            %>
            <td class='label'><%=patient_class_short_desc%><input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value='<%=patient_class%>'><input type='checkbox' name='patient_class_chk<%=i%>' id='patient_class_chk<%=i%>' value='<%=(checked.equals("checked")?"Y":"N")%>' onClick='checkValue(this)' <%=checked%> <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><input type="hidden" name='pri_sec_tasks_type<%=i%>' id='pri_sec_tasks_type<%=i%>' value="<%=pri_sec_tasks_type_DefValue%>"></td>

            <%
                if ((i+1)%4 == 0) out.println("</tr><tr>");
            }

            if (noOfRecords%4 != 0) {
                int tempCount = noOfRecords%4;
            %>
            <td colspan='<%=(4-tempCount)%>'></td> 
            <%}%>
            </tr>
        <%}
    %>
    <tr>
	<td colspan='4' align='left'>
	<tr>
		<td colspan='4' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1' id="rowTab">
				<tr>
					<td  name="SelectTab" id="SelectTab" class="clicked" width="15%" height="20" onClick='parent.parent.parent.parent.dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					<td  name="AssociateTab" id="AssociateTab" class="normal" width="15%" height="20" onClick='parent.parent.parent.parent.dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td>
				</tr>
			</table>
		</td>
	</tr>
	</td>
</tr>
<tr>
	<td colspan='4'  id='linkId'>
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>
</table>
<input type='hidden' name='tot_recs' id='tot_recs' value='<%=noOfRecords%>'>
<input type='hidden' name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
<input type="hidden" name="tabVal" id="tabVal" value="">	
<input type="hidden" name="tabType" id="tabType" value="P">
<input type="hidden" name="bean_id" id="bean_id" value='<%=bean_id%>'>
<input type="hidden" name="bean_name" id="bean_name" value='<%=bean_name%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

<!-- <input type="hidden" name="mode" id="mode" value='<%=mode%>'> -->


<%--<table border='0' cellpadding=0 cellspacing=0 width="100%" align="center" >
<tr><th colspan='8' align="left">&nbsp;&nbsp;Stage</th><tr>
<tr>
    <td class='label'>&nbsp;Order Stage</td><td class='label'><select name='order_stage' id='order_stage'><option value='O'>Order</option><option value='A'>Appointment</option></select></td>
    <td class='label'>&nbsp;Duration</td><td>&nbsp;<input type='text' name='duration' id='duration' value=''></td><td class='label'>&nbsp;Duration Type</td><td class='label'><select name='duration_type' id='duration_type'><option value='H'>Hours</option><option value='D's>Days</option></select></td>
</tr>
<tr>

</tr>
</table>--%>
<%  
	putObjectInBean(bean_id,bean,request);
	
} catch (Exception e) {
        System.out.println(e.getMessage());
    }
%>

</form>
</BODY>
</HTML>

