
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<Html>
<Head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/message.js"></script>
	-->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	
	
	<Script language="javascript" src="../../eOR/js/OrderablePerformingLocation.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</Head>
<%
//int row_disp=10,start = 0 ,end = 0 ;

	int  fm_disp=0, to_disp=0 ,noOfRecords=0,
	previousRecord=0, nextRecord =0;
	//String action="",detailPageMode="";

	//String  from= "", to ="" ;

	String bean_id = "orderablePerformingLocationBean";
	String bean_name = "eOR.OrderablePerformingLocationBean";

	OrderablePerformingLocationBean OrderableBean = (OrderablePerformingLocationBean)getBeanObject(bean_id,bean_name,request);
	//int j = 0 ;
	String classValue ="";

		request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String nextPrevFlag	= ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	previousRecord		= ChkDef.defaultInt(request.getParameter("previousRecord"));
	nextRecord			= ChkDef.defaultInt(request.getParameter("nextRecord"));

	String location_type	= request.getParameter("location_type");
	String location_code	= request.getParameter("location_code");
	String order_type		= request.getParameter("order_type");
	String act				= request.getParameter("action");
	String orderlocation="";
	String labchk="";
	String disablecheck="";
	//detailPageMode	= rquest.getParameter("detailPageMode");

	try {
		OrderableBean.handleAction(request);
		noOfRecords = OrderableBean.getRecordsNo();

		if(act.equalsIgnoreCase("IndexSelect")||act.equalsIgnoreCase("associated")){
			previousRecord = 0;
			nextRecord =  0 ;
		}
		//ArrayList recordSet		= null;
%>
<script>
	//alert('<%=noOfRecords%>');
	if('<%=noOfRecords%>' == 0 ){
		var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON");
//		alert(msg);
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
</script>
<Body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<Form name="OrderablePerformingLocationDetail" id="OrderablePerformingLocationDetail" Action='../../eOR/jsp/OrderablePerformingLocationDetail.jsp'>

		<Table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<TR>
		<td class='WHITE' align="right">
		<%
			if("next".equalsIgnoreCase(nextPrevFlag.trim())) {
				fm_disp	= nextRecord + 1;
				if(noOfRecords < 10)
					to_disp	=	noOfRecords;
				else
					to_disp	= fm_disp + 9;//put x-1 in place of 9 where x RecTODisplay
				if(to_disp > noOfRecords)
					to_disp   = noOfRecords;
				if(nextRecord-1> 0){%>
					<a class='gridlink' href="javascript:parent.parent.getNext('previous')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/><a>
				<%}if(nextRecord + 10 < noOfRecords ){//put x in place of 10 where x is RecTODisplay%>
					<a class='gridlink' href="javascript:parent.parent.getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><a>
			<%}%>
		<% }%>
		<%if("previous".equalsIgnoreCase(nextPrevFlag.trim())){
			fm_disp		= previousRecord   - 10;//put x in place of 10 where x is RecTODisplay
			to_disp	    = fm_disp + 9;//put x-1 place of 9 where x is RecTODisplay
			if( previousRecord - 10  > 1){//put x in place of 10 where x is RecTODisplay%>
					<a href="javascript:parent.parent.getNext('previous')"><fmt:message   key="Common.previous.label" bundle="${common_labels}"/><a>
			<%}if(previousRecord <= noOfRecords ){%>
					<a href="javascript:parent.parent.getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><a>
			<%}%>
		<%}%>
		</td>
		</TR>
		</Table>
		<Table class='grid' width='100%'  style="background-color: white; color: white;text-align:left;" >
					
			<th class='COLUMNHEADER' width='40%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' width='20%'><fmt:message key="eOR.ApptRequired.label" bundle="${or_labels}"/></th>
			<th class='COLUMNHEADER' width='20%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' width='20%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
			<%--if(OrderableBean.getDetailPageMode().equalsIgnoreCase("A")) {%>
			<TR>
				<TD class='gridData' ><B><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
				<TD class='gridData' ><Input type='checkbox' name='appt_reqd_yn<%=-1%>' id='appt_reqd_yn<%=-1%>' value='N' disabled></TD>
				<TD class='gridData' ><Input type='checkbox' name='include<%=-1%>' id='include<%=-1%>'  value='Y' checked onClick='deleteAll(this)'></TD>
			</TR>
			<%}--%>
			<%if(noOfRecords != 0){%>
			<%	if(!act.equalsIgnoreCase("IndexSelect"))
					OrderableBean.SortedArrayListAscc();
				HashMap recCurrent=null;
				String orderCatalog ="";
				String orderCatalogCode = "";
				String appt_reqd_yn   ="";
				String recorded_appt_reqd_yn   ="";
				String default_yn   ="N";
				
				String include ="";
				String valid   = "";
				String appt_status   = "";
				String appt_checked   = "";
				String DataBaseRecord ="";
				String cat_appt_reqd_yn ="";


				for(int i=fm_disp-1; i < to_disp; i++) {
					classValue =( (i%2)==0 )? "gridData" : "gridData";
					recCurrent  =(HashMap)OrderableBean.getRecord(i);
					//System.out.println("####jsp detail page,recCurrent="+recCurrent);
					appt_reqd_yn   =OrderableBean.checkForNull((String)recCurrent.get("appt_reqd_yn"));
					if(appt_reqd_yn.equals("")) appt_reqd_yn = "N";
					recCurrent = OrderableBean.Validaty(recCurrent);//gives dataBase Record	Original
						//System.out.println("####jsp detail page,recCurrent="+recCurrent);
					recorded_appt_reqd_yn   =OrderableBean.checkForNull((String)recCurrent.get("appt_reqd_yn"));
					cat_appt_reqd_yn   =OrderableBean.checkForNull((String)recCurrent.get("cat_appt_reqd_yn"));
					if(recorded_appt_reqd_yn.equals("")) recorded_appt_reqd_yn = "N";
					
					orderCatalog =(String)recCurrent.get("order_catalog_desc");
					orderCatalogCode = OrderableBean.checkForNull((String)recCurrent.get("order_catalog_code"));
					//appt_reqd_yn   =OrderableBean.checkForNull((String)recCurrent.get("appt_reqd_yn"));
					//if(appt_reqd_yn.equals("")) appt_reqd_yn = "N";
					default_yn   =OrderableBean.checkForNull((String)recCurrent.get("default_yn"));
					//out.println("<script>alert('kkkdefault_yn="+default_yn+"');</script>");
					
					//System.out.println("####jsp detail page,default_yn="+default_yn);
					if(OrderableBean.getDetailPageMode().equalsIgnoreCase("S"))
					{
						if(appt_reqd_yn.equalsIgnoreCase("N"))
						{
							appt_status = "disabled";
						}
						else
						{
							if(valid.equalsIgnoreCase("Y"))
							{
								appt_status = "disabled";
							}
							else
							{
								appt_status = "";
							}
						}
					}
					else
					{
						if(cat_appt_reqd_yn.equalsIgnoreCase("N"))
						{
							appt_status = "disabled";
						}
						else
						{
							appt_status = "";
						}
					}
					if((appt_reqd_yn.equalsIgnoreCase("Y"))&&(recorded_appt_reqd_yn.equalsIgnoreCase("N")))
					{
						appt_checked = "";
					}
					else if((appt_reqd_yn.equalsIgnoreCase("Y"))&&(recorded_appt_reqd_yn.equalsIgnoreCase("Y")))
					{
						appt_checked = "checked";
					}
					else if(appt_reqd_yn.equalsIgnoreCase("Y"))
					{
						appt_checked = "checked";
					}
					else
					{
						appt_checked = "";
					}
					if(default_yn.equals("")) default_yn = "N";

					include =OrderableBean.checkForNull((String)recCurrent.get("associate_yn"),"N");
					valid   = "";
					DataBaseRecord ="";
					if(OrderableBean.getDetailPageMode().equalsIgnoreCase("S")){
						valid = (String)recCurrent.get("valid");
					}else{
						valid = "";
						if(OrderableBean.getDetailPageMode().equalsIgnoreCase("A")) {
							if(((String)recCurrent.get("valid")).equalsIgnoreCase("Y"))
								DataBaseRecord = "<B>" ;
						}
					}
			
					//if((OrderableBean.getDetailPageMode().equalsIgnoreCase("A")) || (i!=0)) {
				//out.println("####DataBaseRecord="+DataBaseRecord);		
				
				if(location_type.equals("L"))
					{
					 orderlocation="LB";
					}
			labchk=OrderableBean.checkForNull(OrderableBean.getmoduleRL(orderCatalogCode,orderlocation,order_type,(String)session.getValue("facility_id")),"");
			if(labchk.equalsIgnoreCase("IBARL"))
					{
						disablecheck="disabled";
					}
				if((!orderCatalogCode.equals("*ALL")))  {//out.println("<script>alert('default_yn="+default_yn+"');</script>");
				%>
					
					<TR>
						<%--<Script>alert('<%=(String)recCurrent.get("appt_reqd_yn")%>,<%=valid%>,<%=include%>')</Script>--%>
							
						<TD class='<%=classValue%>' ><%=DataBaseRecord%><%=orderCatalog%></TD>
						<%if(OrderableBean.getDetailPageMode().equalsIgnoreCase("S")){%>
						<TD class='<%=classValue%>' ><Input type='checkbox' name='appt_reqd_yn<%=i%>' id='appt_reqd_yn<%=i%>' value='Y' <%=appt_status%> <%=appt_checked%> onClick=''></TD>
						<%}else{%><TD class='<%=classValue%>' ><Input type='checkbox' name='appt_reqd_yn<%=i%>' id='appt_reqd_yn<%=i%>' value='Y'  
						<%=appt_status%> <%=eHISFormatter.ChkBoxChecked("y",recorded_appt_reqd_yn)%> onClick=''></TD><%}%>
						<TD class='<%=classValue%>' <%=disablecheck%>><Input type='checkbox' name='default_yn<%=i%>' id='default_yn<%=i%>'  value='<%=default_yn%>'  <%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.ChkBoxChecked("Y",default_yn)%> onClick='chkdefault_yn(this);'></TD>
						<TD class='<%=classValue%>' <%=disablecheck%>><Input type='checkbox' name='include<%=i%>' id='include<%=i%>'  value='Y' <%=eHISFormatter.disabled("y",valid)%>  <%=eHISFormatter.ChkBoxChecked("y",include)%> onClick=''></TD>
					</TR>
				<%}%>
				
				<script>
				if('<%=noOfRecords%>' == 1 && '<%=orderCatalogCode%>' == '*ALL'){
					var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
					parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				}
				</script>
				<%}
				%>
			<%}%>
		</Table>
					
		<Input name='mode' id='mode' type='hidden' value='1'>
		<Input name='bean_id' id='bean_id' type='hidden' value='<%=bean_id%>'>
		<Input name='bean_name' id='bean_name' type='hidden' value='<%=bean_name%>'>
		<Input name='nextPrevFlag' id='nextPrevFlag' type='hidden' value='<%=nextPrevFlag%>'>
		<Input name='noOfRecords' id='noOfRecords' type='hidden' value='<%=noOfRecords%>'>
		<Input name='previousRecord' id='previousRecord' type='hidden' value='<%=fm_disp%>'>
		<Input name='nextRecord' id='nextRecord' type='hidden' value='<%=to_disp%>'>
		<Input name='location_type' id='location_type' type='hidden' value='<%=location_type%>'>
		<Input name='location_code' id='location_code' type='hidden' value='<%=location_code%>'>
		<Input name='order_type' id='order_type' type='hidden' value='<%=order_type%>'>
		<Input name='OrderCatalogIndex' id='OrderCatalogIndex' type='hidden' value=''>
		<Input name='function_id' id='function_id' type='hidden' value='<%=OrderableBean.getFunctionId()%>'>
		<Input name='detailPageMode' id='detailPageMode' type='hidden' value='<%=OrderableBean.getDetailPageMode()%>'>
		<Input name='action' id='action' type='hidden' value='<%=OrderableBean.getAction()%>'>
		<Input name='deleteall' id='deleteall' type='hidden' value='0'>
	</Form>

			
<%
		putObjectInBean(bean_id,OrderableBean,request);
 


}catch (Exception e) {
	e.printStackTrace();
}
%>
</Body>
</Html>

