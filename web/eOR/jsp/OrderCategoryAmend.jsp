<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?           created
14/11/2011    IN028981    Dinesh T    Added labels for KDAH-CRF-41
03/01/2012	  IN028417	  Menaka V	  The registered lab samples can be discontinued from CA-OR even though
									  the discontinuation reasons are not defined for lab module.
20/01/2012	IN029143	  Menaka V	  <JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in
									  EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.									  
-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
04/07/2017		IN061903			Krishna Gowtham J.		05/07/2017				Ramesh G.		ML-MMOH-CRF-0555
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrderCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- IN029143 Starts-->
 <script>
 function changevaluelist(cat_size,name)
	{
		var temp=name.name;
		if(name.value=='ML')
		{
			var i=0;
			for(i=0;i<cat_size.value;i++)	
			{
				document.order_category.elements["secure_PIN"+i].value='ML';
			}
			
		}
		else if(name.value=='MO')
		{
			var i=0;
			for(i=0;i<cat_size.value;i++)	
			{
				document.order_category.elements["secure_PIN"+i].value='MO';
			}
			
		}
		else
		{
			
			for(var i=0;i<cat_size.value;i++)	
			{
				var loc_="secure_PIN"+i;
				
				if(temp!=loc_)
				{
					if(document.order_category.elements["secure_PIN"+i].value!='AL'&&document.order_category.elements["secure_PIN"+i].value!='AO')
					{
						document.order_category.elements["secure_PIN"+i].value="NA";
					}
				
				}
			}
		}
	
	}
 
 </script>
 <!-- IN029143 Ends-->
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	     = request.getParameter( "mode" ) ;
	String bean_id   = "order_category" ;
	String bean_name = "eOR.OrderCategoryBean";	
	OrderCategoryBean bean = (OrderCategoryBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	ArrayList Category_Data = new ArrayList();
%>
<form name="order_category" id="order_category" method="post" target="messageFrame">
<table  class='grid' width="100%">
	<tr>
		<td class="COLUMNHEADER" width="10%" style="text-align:center;">
			<fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
		</td>
		<!--<th>Clinical Comments Mandatory </th>-->
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.GenExternalApplicationAccessionNum.label" bundle="${or_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.ClinicalCommentMandatory.label" bundle="${or_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%">
			<fmt:message key="eOR.AllowMultiPatientResulting.label" bundle="${or_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.ResultTypeDisplayControl.label" bundle="${or_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.CompletionRemarksMandatory.label" bundle="${or_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.PromptforBookApptonOrder.label" bundle="${or_labels}"/>
		</td>
		<!--<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.ChkPendingOrders.label" bundle="${or_labels}"/>
		</td>--><!--IN028981-->
		<td class="COLUMNHEADER" width="15%" style="text-align:center;"><fmt:message key="eOR.Hold/Discontinue.label" bundle="${or_labels}"/></td><!-- IN028417-->
		<!--IN061903 start--><td class="COLUMNHEADER" width="15%" style="text-align:center;"><fmt:message key="eOR.NotDoneReasonMand.label" bundle="${or_labels}"/></td><!--IN061903 ends-->
		<td class="COLUMNHEADER" width="15%" style="text-align:center;"><fmt:message key="eOR.SecurePINPlaceOrder.label" bundle="${or_labels}"/></td><!-- IN029143-->
	</tr>
	<%
		int ilRow=0;
		String slClassValue = "";
		String checked1 = "",checked2 = "",checked3 = "",checked4="",checked5="",checked6 = "",checked8 = "";//IN028417;
		String checked9 ="";//IN061903
		//String checked7="";//IN028763
		Category_Data = bean.getOrderCategory();
		String[] record=null;
		String result_disabled="";
		String chkPend = "Y";
		String disableChkPend="";//IN028981
		String notDoneDisabled = "";//IN061903
%>
<input name ='category_size' type='hidden' value='<%=Category_Data.size()%>'>
<%
		for(int i=0; i<Category_Data.size(); i++)
		{
			record = (String [])Category_Data.get(i);	
			if(record[1].equals("null")||record[1].equals(" ")||record[1]==null)record[1]="";
			if(record[2].equals("null")||record[2].equals(" ")||record[2]==null)record[2]="";
			if(record[3].equals("null")||record[3].equals(" ")||record[3]==null)record[3]="N";
			if(record[4].equals("null")||record[4].equals(" ")||record[4]==null)record[4]="N";
			if(record[5].equals("null")||record[5].equals(" ")||record[5]==null)record[5]="N";
			if(record[6].equals("null")||record[6].equals(" ")||record[6]==null)record[6]="N";
			/*Added by Uma on 2/1/2010 for 804*/
			if(record[7].equals("null")||record[7].equals(" ")||record[7]==null)record[7]="N";
			/*Ends Here*/
			/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
			if(record[8].equals("null")||record[8].equals(" ")||record[8]==null)record[8]="N";
			/*Ends Here*/
			//if(record[9].equals("null")||record[9].equals(" ")||record[9]==null)record[9]="N";//IN028981//IN028763
			if(record[9].equals("null")||record[9].equals(" ")||record[9]==null)record[9]="N";//IN028417
			if(record[10].equals("null")||record[10].equals(" ")||record[10]==null)record[10]="NA";//IN029143 
			if(record[11].equals("null")||record[11].equals(" ")||record[11]==null)record[11]="N";//IN061903 
			
			if(ilRow % 2 == 0)
			{
				slClassValue = "gridData";
			}
			else   
			{
				slClassValue = "gridData";
			}

			if(record[3].equals("Y"))
				checked1 = " checked ";
			if(record[4].equals("Y"))
				checked2 = " checked ";
			if(record[5].equals("Y"))
				checked3 = " checked ";
			if(record[6].equals("Y"))
				checked4 = " checked ";
			/*Added by Uma on 2/1/2010 for 804*/
			if(record[7].equals("Y"))
				checked5 = " checked ";
			/*Ends Here*/
			/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
			if(record[8].equals("Y"))
				checked6 = " checked ";
			/*Ends Here*/
			if(record[0].equals("CN")||record[0].equals("CS"))
			{
				result_disabled="disabled";
			}
			else
			{
				result_disabled="";
			}

			/*if(record[9].equals("Y")) 
				checked7="checked";*/ //IN028981
				if(record[9].equals("Y"))//IN028417
					checked8 = " checked ";//IN028417
			//IN061903 start
			if(record[11].equals("Y"))
			{
				checked9 = " checked ";
			}
			else
			{
				checked9 = "";
			}
				
			if("TR".equals(record[0]) || "PC".equals(record[0])){
				notDoneDisabled = "";
			} else{
				notDoneDisabled = "disabled";
			}
			//IN061903 ends

			//IN028981,starts
			if(chkPend.equals("N"))	
			{
				disableChkPend = "disabled";
			}
			else
			{
				disableChkPend = "";
			}
			//IN028981,ends

		%>
		<tr>
			<td  class='<%= slClassValue %>' style="padding-left:10px;"><%=record[0]%> 			
				<input type=hidden name=order_cat<%=i%> value=<%=record[0]%>>				
			</td>				
			<td class='<%= slClassValue %>' nowrap>
				<input type=text name=long_desc<%=i%> value="<%=record[1]%>" maxlength=30 size=20 onBlur="makeValidString(this);"><%if(i==0){%><img src="../../eCommon/images/mandatory.gif" ></img><%}%><!--Size modified for IN061903-->
			</td>
			<td class='<%= slClassValue %>' nowrap>
				<input type=text name=short_desc<%=i%> value="<%=record[2]%>" maxlength=15 onBlur="makeValidString(this);"><%if(i==0){%><img src="../../eCommon/images/mandatory.gif" ></img><%}%>
			</td>
			<td class='<%= slClassValue %>' style="text-align:center;">
				<input type=checkbox name=chk2_<%=i%> value = <%=record[4]%> <%=checked2%> onClick='changeValue(this)'>
			</td>
			<td  class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk1_<%=i%> value = <%=record[3]%> <%=checked1%> onClick='changeValue(this)'>
			</td>
			<td align=center class='<%= slClassValue %>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=checkbox name=chk3_<%=i%> value = <%=record[5]%> <%=checked3%><%=result_disabled%> onClick='changeValue(this)'>
			</td>
			<td class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk4_<%=i%> value = <%=record[6]%> <%=checked4%><%=result_disabled%>  onClick='changeValue(this)'>
			</td>			
			<td class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk5_<%=i%> value = <%=record[7]%> <%=checked5%>  <%=result_disabled%> onClick='changeValue(this)'>
			</td>
			<td class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk6_<%=i%> value = <%=record[8]%> <%=checked6%> onClick='changeValue(this)'>
			</td>
			
			<td class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk8_<%=i%> value = <%=record[9]%> <%=checked8%> onClick='changeValue(this)'></td><!--IN028417-->
			<!--IN061903-->
			<td class='<%= slClassValue %>'  style="text-align:center;">
				<input type=checkbox name=chk9_<%=i%> value = <%=record[11]%> <%=checked9%> onClick='changeValue(this)' <%=notDoneDisabled%> ></td>
			<!--IN061903-->
			<!--IN029143  Starts -->
			<td class='fields'  style="text-align:center;">
				<Select name='secure_PIN<%=i%>' id='secure_PIN<%=i%>'
				 onChange='changevaluelist(category_size,secure_PIN<%=i%>)' size="1">
				<Option id='opt'value='NA' <%if((record[10].trim()).equals("NA")) out.println(" selected ");%>>Not Applicable</Option>
				<Option value='AL' <%if((record[10].trim()).equals("AL")) out.println(" selected ");%>>Logged in Practitioner's PIN</Option>
				<Option value='ML' <%if((record[10].trim()).equals("ML")) out.println(" selected ");%>>Logged in Practitioner's PIN - Prompt once for all categories</Option>
				<Option value='AO' <%if((record[10].trim()).equals("AO")) out.println(" selected ");%>>Ordering Practitioner's PIN</Option>
				<Option value='MO' <%if((record[10].trim()).equals("MO")) out.println(" selected ");%>>Ordering Practitioner's PIN - Prompt once for all categories</Option>
				</Select>
			</td> 
			<!--IN029143 Ends -->
		</tr>
		<%	
			ilRow++;
			checked1 = "";
			checked2 = "";
			checked3 = "";
			checked4 = "";
			/*Added by Uma on 2/1/2010 for 804*/
			checked5 = "";
			/*Ends Here*/
			/*Added by Channaveer B on 22/11/2010 for SCF-24737*/
			checked6 = "";
			//checked7 = "";//IN028981
			checked8 = "";//IN028417
			/*Ends Here*/			
		}
		%>
</table>

<input type="hidden" name="totalRecords" id="totalRecords" value="<%=Category_Data.size()%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="Order_Category">
<%
	Category_Data=null;
%>
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

