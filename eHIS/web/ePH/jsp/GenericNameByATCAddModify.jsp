<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
     request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhMessages.js"></SCRIPT> -->	
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/GenericNameByATC.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>
 
<body onMouseDown="" onKeyDown="lockKey()">
<form name="frmGenericNameByATCAddModify" id="frmGenericNameByATCAddModify" id="Generic Name By ATC Add Modify" >
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	String resultByATC=request.getParameter( "resultByATC" ) ;
	String queryCriteria = request.getParameter("queryCriteria");
	String classvalue="";
	int count =0;		
	if (resultByATC==null || resultByATC.equals(" "))
	{
			resultByATC="N";
	}
	if (queryCriteria==null )
	{
			queryCriteria="N";
	}

	/* Initialize Function specific end */

	String generic_id= request.getParameter( "generic_id" ) ;
	if (mode==null)
		mode="";
	/* Initialize Function specific start */
	GenericNameByATCBean bean = (GenericNameByATCBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		String called = request.getParameter("called");
	if (called==null)
		{
	called="";
		}
	
		if (called.equals("pharma")){
		
%>
	
	<br>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" >
	<%
		//String classvalue="";
		String codes=request.getParameter("atcclassification");
		if (codes != null)
		{
			
			StringTokenizer atclevelcodes=new StringTokenizer(codes,"|");
			int rows= atclevelcodes.countTokens()/6;
			if(rows > 0){
				
		%>
	
		<thead>
		<tr>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="22%"><fmt:message key="ePH.PharmacologicalClass.label" bundle="${ph_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" 
			width="24%">Group Class [level I]</th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" 
			><fmt:message key="ePH.SubGroupClass[LevelII].label" bundle="${ph_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">&nbsp;</th>
		</tr>		
	   </thead>
	   </table>
		<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="newRecordsTable" style="border-top:none;border-bottom:none;">
		<tr>
			<td  colspan="4" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.NewRecords.label" bundle="${ph_labels}"/></td>
			<td nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;" width="14%" class="CAGROUP"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
				
	   <%
			}
			for (int i=1;i<=rows ;i++)
			{
				String level1= atclevelcodes.nextToken();
				String level1desc=atclevelcodes.nextToken();

				String level2= atclevelcodes.nextToken();
				String level2desc=atclevelcodes.nextToken();

				String level3= atclevelcodes.nextToken();
				String level3desc=atclevelcodes.nextToken();

								
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
	   %>
		   <tr>
				<td class="<%=classvalue%>"  width="14%"><%=i%>&nbsp;
				<input type="hidden" value="<%= i %>" name="sl_no<%=i%>" ></td>		
				</td>
				<td class="<%=classvalue%>" onmouseover="displayToolTipPhar('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>')" onmouseout="hideToolTip()" width="22%"> <%= level1 %>
				<input type="hidden" value="<%= level1 %>" name="atc_class_lev1_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTipPhar('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>')" onmouseout="hideToolTip()" width="24%">
					<%= level2 %>&nbsp;
				<input type="hidden" value="<%= level2 %>" name="atc_class_lev2_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTipPhar('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>')" onmouseout="hideToolTip()" width="26%">
					<%= level3 %>&nbsp;
				<input type="hidden" value="<%= level3 %>" name="atc_class_lev3_code<%=i%>"></td>						

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true ;" >
					<input type="checkbox" value="Y" checked name="select<%= i %>" id="select<%= i %>" width="14%">
				</td>
		   </tr>
	   <%
			}
		 }
	   %>
		   
	</table>	
<%
	}
	   else{
  %>
	<br>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" >
	<%
		//String classvalue="";
		String codes=request.getParameter("atcclassification");
		if (codes != null)
		{
			StringTokenizer atclevelcodes=new StringTokenizer(codes,"|");
			int rows= atclevelcodes.countTokens()/10;
			if(rows > 0){
		%>
	
		<thead>
		<tr>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" ><fmt:message key="ePH.Anatomical.label" bundle="${ph_labels}"/></th>
			<th colspan="2" style="font-size:xx-small" ><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/> </th>
			<th colspan="2" style="font-size:xx-small" ><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/> </th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">&nbsp;</th>
		</tr>
		<tr>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;" > &nbsp;</th>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;"> <fmt:message key="Common.Class.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.SubClass.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.SubClass.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;">&nbsp;</th>
		</tr>
	   </thead>
	   </table>
		<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="newRecordsTable" style="border-top:none;border-bottom:none;">
		<tr>
			<td  colspan="6" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.NewRecords.label" bundle="${ph_labels}"/></td>
			<td nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;" width="14%" class="CAGROUP"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
				
	   <%
			}
			for (int i=1;i<=rows ;i++)
			{
				String level1= atclevelcodes.nextToken();
				String level1desc=atclevelcodes.nextToken();

				String level2= atclevelcodes.nextToken();
				String level2desc=atclevelcodes.nextToken();

				String level3= atclevelcodes.nextToken();
				String level3desc=atclevelcodes.nextToken();

				String level4= atclevelcodes.nextToken();
				String level4desc=atclevelcodes.nextToken();

				String level5= atclevelcodes.nextToken();
				String level5desc=atclevelcodes.nextToken();
				
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
	   %>
		   <tr>
				<td class="<%=classvalue%>"  width="14%"><%=i%>&nbsp;
				<input type="hidden" value="<%= i %>" name="sl_no<%=i%>" ></td>		
				</td>
				<td class="<%=classvalue%>" onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%"> <%= level1 %>
				<input type="hidden" value="<%= level1 %>" name="atc_class_lev1_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%">
					<%= level2 %>&nbsp;
				<input type="hidden" value="<%= level2 %>" name="atc_class_lev2_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%">
					<%= level3 %>&nbsp;
				<input type="hidden" value="<%= level3 %>" name="atc_class_lev3_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%">
					<%= level4 %>&nbsp;
				<input type="hidden" value="<%= level4 %>" name="atc_class_lev4_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%">
				<%= level5 %>&nbsp;
				<input type="hidden" value="<%= level5 %>" name="atc_class_lev5_code<%=i%>"></td>		

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true ;" >
					<input type="checkbox" value="Y" checked name="select<%= i %>" id="select<%= i %>" width="14%">
				</td>
		   </tr>
	   <%
			}
		 }
	   %>
	</table>	
<%
	   }
	   %>
		   <input type="hidden" name="called" id="called" value="<%=called%>">
		   <%
	}
	else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))  && (resultByATC.equals("N") )){
		ArrayList arrList= bean.getAllValuesForModify(generic_id,locale);
		String enabledisable=request.getParameter("enabledisable");	
		bean.setCallFrom("byGenericName");
%>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="mainHeading">
	<thead>
		<tr>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small"><fmt:message key="ePH.Anatomical.label" bundle="${ph_labels}"/></th>
			<th colspan="2" style="font-size:xx-small"><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/> </th>
			<th colspan="2" style="font-size:xx-small"><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/> </th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">&nbsp;</th>
		</tr>
		<tr>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;" > &nbsp;</th>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;"> <fmt:message key="Common.Class.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.SubClass.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-bottom:none;" width="14%"><fmt:message key="Common.SubClass.label" bundle="${common_labels}"/></th>
			<th nowrap style="font-size:xx-small;border-left:none;border-top:none;border-bottom:none;">&nbsp;</th>
		</tr>	
	   </thead>
	   </table>	

<%
	String[] record= (String[])arrList.get(0);
	
	if (arrList.size() > 0 && record[6] != null){
%>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="mainData" style="border-top:none;border-bottom:none;">
			<tr>
				<td  colspan="6" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.AssociatedRecords.label" bundle="${ph_labels}"/></td>
				<td  style="font-size:xx-small;" class="CAGROUP"><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>
			</tr>
	<%
		}
		//String classvalue="";
		String checkForDuplication="";
		for (int i=0;i<arrList.size();i++)	
		{
			String[] arr = new String[15];
			arr= (String[])arrList.get(i);

			
				if (arr[6]==null)
				{
					arr[6]="";
				}
				if (arr[7]==null)
				{
					arr[7]="";
				}
				if (arr[9]==null)
				{
					arr[9]="";
				}
				if (arr[11]==null)
				{
					arr[11]="";
				}
				if (arr[13]==null)
				{
					arr[13]="";
				}
						
						
			checkForDuplication += (arr[5] + " |"+arr[7]+" |"+arr[9]+" |"+arr[11]+" |"+arr[13]+" |");


			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			int j=i+1;   // this is declared to maintain the uniform names... 

			if (arr[6] !="" ){
		
	%>
	   <tr>
			<td  class="<%= classvalue%>" width="14%"><%= j %>&nbsp;</td>
			<input type="hidden" name="sr_no<%=j%>" id="sr_no<%=j%>" value="<%=arr[0]%>">
			<td onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>','<%=arr[12]%>','<%=arr[14]%>')" onmouseout="hideToolTip()" class="<%= classvalue%>" width="14%"><%= arr[5]%>&nbsp;
			<input type="hidden" name="atc_class_lev1_code<%=j%>" id="atc_class_lev1_code<%=j%>" value="<%=arr[5]%>">
			</td>
			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>','<%=arr[12]%>','<%=arr[14]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[7]%>&nbsp;
				<input type="hidden" name="atc_class_lev2_code<%=j%>" id="atc_class_lev2_code<%=j%>" value="<%=arr[7]%>">
			</td>
			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>','<%=arr[12]%>','<%=arr[14]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[9]%>&nbsp;
				<input type="hidden" name="atc_class_lev3_code<%=j%>" id="atc_class_lev3_code<%=j%>" value="<%=arr[9]%>">
			</td>

			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>','<%=arr[12]%>','<%=arr[14]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[11]%>&nbsp;
				<input type="hidden" name="atc_class_lev4_code<%=j%>" id="atc_class_lev4_code<%=j%>" value="<%=arr[11]%>">
			</td>
			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>','<%=arr[12]%>','<%=arr[14]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[13]%>&nbsp;
				<input type="hidden" name="atc_class_lev5_code<%=j%>" id="atc_class_lev5_code<%=j%>" value="<%=arr[13]%>">
			</td>
			<td  class="<%= classvalue%>" width="14%">
				<input type="checkbox" name="chkdelete<%=j%>" id="chkdelete<%=j%>" value="Y" <%=enabledisable%>>
			</td>
	   </tr>

	<%}
		}
	%>		
	</table>
	<input type="hidden" value="<%=checkForDuplication%>" name="associatedValues">

<%  
	String codes=request.getParameter("atcclassification");
	StringTokenizer atclevelcodes=null;
	int rows=0;
	if (codes != null){
		atclevelcodes=new StringTokenizer(codes,"|");
		rows= atclevelcodes.countTokens()/10;
	}	
	if (rows >0 ) {
%>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="NewRecordsWhileModify" style="border-top:none;border-bottom:none;">	
		<tr>
			<td  colspan="6" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.NewRecords.label" bundle="${ph_labels}"/></td>
			<td  colspan="1" style="font-size:xx-small " class="CAGROUP"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>

		<%
		for (int i=1;i<=rows ;i++)
		{
			String level1= atclevelcodes.nextToken();
			String level1desc=atclevelcodes.nextToken();
	
			String level2= atclevelcodes.nextToken();
			String level2desc=atclevelcodes.nextToken();

			String level3= atclevelcodes.nextToken();
			String level3desc=atclevelcodes.nextToken();

			String level4= atclevelcodes.nextToken();
			String level4desc=atclevelcodes.nextToken();

			String level5= atclevelcodes.nextToken();
			String level5desc=atclevelcodes.nextToken();

			int j=i-1;

			if ( j % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
	   %>
		<tr>
			<td class="<%=classvalue%>"  width="14%"><%=i%>&nbsp;
			</td>
			<td class="<%=classvalue%>" onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%"> <%= level1 %>
				<input type="hidden" value="<%= level1 %>" name="NEWatc_class_lev1_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%"><%= level2 %>&nbsp;
				<input type="hidden" value="<%= level2 %>" name="NEWatc_class_lev2_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%"><%= level3 %>&nbsp;
				<input type="hidden" value="<%= level3 %>" name="NEWatc_class_lev3_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%" ><%= level4 %>&nbsp;
				<input type="hidden" value="<%= level4 %>" name="NEWatc_class_lev4_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','<%=level4desc%>','<%=level5desc%>')" onmouseout="hideToolTip()" width="14%"><%= level5 %>&nbsp;
				<input type="hidden" value="<%= level5 %>" name="NEWatc_class_lev5_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true ;"  width="14%">
					<input type="checkbox" value="Y" checked name="select<%= i %>" id="select<%= i %>" >
			</td>
		  </tr>
	   <%
			}
		%>
	</table>
<%
		}	
	}
	else{	/**
 * @Name - Krishna Kiran 
 * @Date - 18/12/2009
 * @Inc# - IN017314
 * @Desc - Allows to Update the Effective status in the query mode when search by ATC Classification is selected and     also changed the function parameters of a getAllValuesForDisplay() in the bean.
 */
		String codes=request.getParameter("atcclassification");
	//	String from=request.getParameter("from");
	//	String to=request.getParameter("to");
		String checked ="";
		String effStatus="";
		//String classvalue="";
		
			
		ArrayList arrList= bean.getAllValuesForDisplay(codes,locale) == null ? new ArrayList() :  bean.getAllValuesForDisplay(codes,locale) ;	
		bean.setATCUpdatedValues(arrList);
		bean.setCallFrom("UpdateByATCClassification");
		//out.println(arrList.size()+"=="+arrList);
		if (arrList.size()>0){
%>
        
		<table cellpadding=0 cellspacing=0 width="84%" border="1" align="center">	
		<thead >
		<tr>
			<th style="font-size:xx-small;width:50%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
		    <th style="font-size:xx-small;width:20%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></th>
			<th style="font-size:xx-small;width:10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
	</thead>
<%		for (int i=0;i<arrList.size();i+=15){ // array list one row painting size is 15
			if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>			
		<tr>
			<td style="font-size:xx-small" class="<%=classvalue%>"> <%= arrList.get(i+2) %>  </td>
			<td style="font-size:xx-small" class="<%=classvalue%>"> <%=  arrList.get(i+3) %>  </td>
<%
	if (arrList.get(i+4).toString().equals("E")){
		 checked = "checked";
		 effStatus ="E";
    }else{
	      checked = "";
		 effStatus ="D";
	}

%>
		<td   class="<%=classvalue%>"><input type="checkbox" name='atc_eff_status_<%=count%>' id='atc_eff_status_<%=count%>' value="<%=effStatus%>"  <%=checked%> onclick = "callEnableDisable(this,'<%=i+4%>')">	</td></tr>
		<input type= 'hidden' name='h_atc_eff_status_<%=count%>' id='h_atc_eff_status_<%=count%>' value="<%=effStatus%>" />
	    
		
<%			 count++;}//for


		
	
		}//size>0	
	}//else

//updated code ends here for the incident IN017314
	%>
	</table>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:100%; visibility:hidden;bgcolor:yellow;" >
		<table id="tooltiptable" cellpadding=0 cellspacing=0 style="border:1px solid black;" width="auto" height="100%" >
			<tr><td id="t"></td></tr>
		</table>
	</div>	
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="atcclassification" id="atcclassification" value="">
	<%if(bean.getCallFrom().equals("UpdateByATCClassification") && bean.getMode().equals("2")){%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>"> 
		<input type="hidden" name="rows_count" id="rows_count" value="<%=count%>">
	<%}%>
	<input type="hidden" name="call_from" id="call_from" value="<%=bean.getCallFrom()%>">

		
</form>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

