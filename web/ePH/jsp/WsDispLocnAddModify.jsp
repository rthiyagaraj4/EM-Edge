<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
    <% 
	request.setCharacterEncoding("UTF-8");
  //Added by Himanshu for MMS-ME-SCF-0097 Starts 
  	request= new XSSRequestWrapper(request); 
  	response.addHeader("X-XSS-Protection", "1; mode=block"); 
  	response.addHeader("X-Content-Type-Options", "nosniff"); 
  	//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
 <!--   <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
    <script language="JavaScript" src="../js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../js/WsDispLocn.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
    String bean_id		= "WsDispLocnBean" ;
    String bean_name	= "ePH.WsDispLocnBean";
    String readOnly		= "" ;
	int     totalRecords    =   0;

	if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    WsDispLocnBean bean = (WsDispLocnBean)
getBeanObject(bean_id,bean_name ,request)
 ;
	bean.setLanguageId(locale);
    bean.clear() ;
    bean.setMode( mode ) ;
    totalRecords    =   Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
	HashMap intialValues = new HashMap();

	if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
		intialValues = (HashMap) bean.loadIntialValues();
	}
	else{
		intialValues = (HashMap) bean.loadIntialValues();

	}
	ArrayList DISP_LOCN_CODE		= (ArrayList) intialValues.get("DISP_LOCN_CODE");
	ArrayList SHORT_DESC	= (ArrayList) intialValues.get("SHORT_DESC");

	%>
<form name="Dispense_Location" id="Dispense_Location" >

				   <%
					   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
						String WS_NO=request.getParameter("WS_NO");
						String DISP_CODE=request.getParameter("DISP_LOCN_CODE");
						String DISP_DESC=request.getParameter("DISP_LOCN_DESC");
						String Wsno		= (String)bean.getWSNO(WS_NO.trim(),DISP_CODE.trim());

				 
						%>

						<br><br><br><br><br><br><br><br><br><br><br><br>
						<table cellpadding=0 cellspacing=0 width="60%"  align="center" border="0" id="patient_table">
						<tr><td class="label" colspan="2">&nbsp;</td></tr>
						<tr>
						   <td class="label" width="35%" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
						<input type="text" value="<%=DISP_DESC%>" name="DISP_LOCN_DESC" disabled size="30">
						<input type="hidden" value="<%=DISP_CODE%>" name="DIS_CODE" disabled size="30">
						</td>
        			 	</tr>

        			 	<tr>
						 <td class="label" width="35%" ><fmt:message key="ePH.WorkstationNo.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
						<input type="text" value="<%=Wsno%>" name="WS_NO" disabled size="30">
						</td>
						</tr>
						</table>
					<%
					   }
					if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
					   %>
					   <br><br><br><br><br>
					      <table cellpadding=0 cellspacing=0 width="55%"  align="center" border="0" id="patient_table">
					           <tr><td class="label" colspan="2">&nbsp;</td></tr>
					   		<tr>
					   		           <td class="label" width="35%" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		           <td>&nbsp;
					   <select name="DISP_LOCN_CODE" id="DISP_LOCN_CODE"  >
		                   <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>

						<%
						for(int i=0;DISP_LOCN_CODE.size()>i;i++){

						  %>
							<option value="<%=DISP_LOCN_CODE.get(i)%>"><%=SHORT_DESC.get(i)%></option>
						  <%
						  }
						  %>
		                </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>

						</td>
         </tr>

   </table>
   <br>
   <table cellpadding=0 cellspacing=0 border=1 width='43%'  align='center' >

   <tr>
           <th width="30%"><fmt:message key="ePH.WorkstationNo.label" bundle="${ph_labels}"/></th>
           <th width="5%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>

   </tr>
   <%
   String  classValue = "";
   for(int count=0 ; count<totalRecords ; count++)
   {
       if ( count % 2 == 0 )
           classValue = "QRYEVEN" ;
       else
           classValue = "QRYODD" ;
       %>
   <tr >

       <td class='<%=classValue%>'>&nbsp;&nbsp;

         <input type=text name='WS_NO<%=count%>' id='WS_NO<%=count%>' onBlur="check(this.value, '<%=count%>')" onKeyPress="return CheckSpecChars1(event)" 	size="30" maxlength="25" value=""  <%=readOnly%>>
       </td>

       <td class='<%=classValue%>'>
       <input type="checkbox" name='eff_status<%=count%>' id='eff_status<%=count%>' value="E"  <%=readOnly%> >
       </td>
   </tr >

   <%
           }//for loop
   %>

 </table>
<%
					     }
						%>



   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
 <input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">

 </form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

