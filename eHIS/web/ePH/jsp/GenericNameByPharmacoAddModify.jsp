<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/messages.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhMessages.js"></SCRIPT>	
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/GenericNameByATC.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>
 
<body onMouseDown="" onKeyDown="lockKey()">
<form name="frmGenericNameByPharmacoAddModify" id="frmGenericNameByPharmacoAddModify" id="Generic Name By Phar Add Modify" >
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	String resultByATC=request.getParameter( "resultByATC" ) ;
	String queryCriteria = request.getParameter("queryCriteria");
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
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		String called = request.getParameter("called");
	if (called==null)	
	called="";
	
		if (called.equals("pharma")){
		
%>
	
	<br>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" >
	<%
		String classvalue="";
		String codes=request.getParameter("atcclassification");
		if (codes != null)
		{
			
			StringTokenizer atclevelcodes=new StringTokenizer(codes,"|");
			int rows= atclevelcodes.countTokens()/6;
			if(rows > 0){
		%>
	
		<thead>
		<tr>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">S.No.</th>
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
			<td align="left" colspan="4" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.NewRecords.label" bundle="${ph_labels}"/></td>
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
				<td class="<%=classvalue%>" align="right" width="14%"><%=i%>&nbsp;
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

				<td class="<%=classvalue%>" onclick="event.cancelBubble = true ;" align="center">
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
	}
	else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))  && (resultByATC.equals("P") )){
		ArrayList arrList= bean.getAllValuesForModify(generic_id,locale);
		String enabledisable=request.getParameter("enabledisable");	
%>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="mainHeading">
	<thead>
		<tr>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">S.No.</th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="22%"><fmt:message key="ePH.PharmacologicalClass.label" bundle="${ph_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" 
			width="24%">Group Class [level I]</th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" 
			><fmt:message key="ePH.SubGroupClass[LevelII].label" bundle="${ph_labels}"/></th>
			<th style="border-left:none;border-top:none;border-bottom:none;font-size:xx-small" width="14%">&nbsp;</th>
		</tr>		
	   </thead>
	   </table>	

<%
	String[] record= (String[])arrList.get(0);
	
	if (arrList.size() > 0 && record[6] != null){
%>
	<table cellpadding=0 cellspacing=0 width="82%" border="1" align="center" id="mainData" style="border-top:none;border-bottom:none;">
			<tr>
				<td align="left" colspan="6" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.AssociatedRecords.label" bundle="${ph_labels}"/></td>
				<td align="center"  style="font-size:xx-small;" class="CAGROUP"><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>
			</tr>
	<%
		}
		String classvalue="";
//		String checkForDuplication="";
        StringBuffer checkForDuplication=new StringBuffer();
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
									
						
//			checkForDuplication += (arr[5] + " |"+arr[7]+" |"+arr[9]+" |");
            checkForDuplication=checkForDuplication.append(arr[5]).append(" |").append(arr[7]).append(" |").append(arr[9]).append(" |");

			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			int j=i+1;   
			if (arr[6] !="" ){
		
	%>
	   <tr>
			<td align="right" class="<%= classvalue%>" width="14%"><%= j %>&nbsp;</td>
			<input type="hidden" name="sr_no<%=j%>" id="sr_no<%=j%>" value="<%=arr[0]%>">
			<td onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>')" onmouseout="hideToolTip()" class="<%= classvalue%>" width="14%"><%= arr[5]%>&nbsp;
			<input type="hidden" name="atc_class_lev1_code<%=j%>" id="atc_class_lev1_code<%=j%>" value="<%=arr[5]%>">
			</td>
			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[7]%>&nbsp;
				<input type="hidden" name="atc_class_lev2_code<%=j%>" id="atc_class_lev2_code<%=j%>" value="<%=arr[7]%>">
			</td>
			<td class="<%= classvalue%>" onmouseover=" displayToolTip('<%=arr[6]%>','<%=arr[8]%>','<%=arr[10]%>')" onmouseout="hideToolTip()" width="14%"><%= arr[9]%>&nbsp;
				<input type="hidden" name="atc_class_lev3_code<%=j%>" id="atc_class_lev3_code<%=j%>" value="<%=arr[9]%>">
			</td>
			
			<td align="center" class="<%= classvalue%>" width="14%">
				<input type="checkbox" name="chkdelete<%=j%>" id="chkdelete<%=j%>" value="Y" <%=enabledisable%>>
			</td>
	   </tr>

	<%}
		}
	%>		
	</table>
	<input type="hidden" value="<%=checkForDuplication.toString()%>" name="associatedValues">

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
			<td align="left" colspan="6" style="font-size:xx-small " class="CAGROUP"><fmt:message key="ePH.NewRecords.label" bundle="${ph_labels}"/></td>
			<td align="center" colspan="1" style="font-size:xx-small " class="CAGROUP"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
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

			
			int j=i-1;

			if ( j % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
	   %>
		<tr>
			<td class="<%=classvalue%>" align="right" width="14%"><%=i%>&nbsp;
			</td>
			<td class="<%=classvalue%>" onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','','')" onmouseout="hideToolTip()" width="14%"> <%= level1 %>
				<input type="hidden" value="<%= level1 %>" name="NEWatc_class_lev1_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','','')" onmouseout="hideToolTip()" width="14%"><%= level2 %>&nbsp;
				<input type="hidden" value="<%= level2 %>" name="NEWatc_class_lev2_code<%=i%>">
			</td>		
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true " onmouseover="displayToolTip('<%=level1desc%>','<%=level2desc%>','<%=level3desc%>','','')" onmouseout="hideToolTip()" width="14%"><%= level3 %>&nbsp;
				<input type="hidden" value="<%= level3 %>" name="NEWatc_class_lev3_code<%=i%>">
			</td>		
					
			<td class="<%=classvalue%>" onclick="event.cancelBubble = true ;" align="center" width="14%">
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
	else{	
		String codes=request.getParameter("atcclassification");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		if (from == null)
			from = "";
		if (to == null)
			to = "";
		ArrayList arrList= bean.getAllValuesForPharmacoDisplay(codes,from,to);		
		if (arrList.size()>1)
		{
%>
	<table cellpadding=0 cellspacing=0 width="80%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(arrList.get(0));	
	%>
		</td></tr>
		</table>
	<table cellpadding=0 cellspacing=0 width="84%" border="1" align="center">	
	<thead >
		<tr>
			<th style="font-size:xx-small;width:50%">Generic Name</th>
		    <th style="font-size:xx-small;width:20%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></th>
			<th style="font-size:xx-small;width:10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
	</thead>
	<%
			for(int i=0;i<arrList.size()-1;i++)
			{
				String[] records= (String[])arrList.get(i+1);		
				String classvalue="";
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
			
	%>		
		<tr>
			<td style="font-size:xx-small" class="<%=classvalue%>"> <%= records[0] %>  </td>
			<td style="font-size:xx-small" class="<%=classvalue%>"> <%= records[1] %>  </td>
	<%
		if (records[2].equals("E")){
	%>
			<td  align="center" class="<%=classvalue%>"><img src='../../eCommon/images/enabled.gif'><input type="hidden" value="E"></img>
			</td>
	<%
		}
		else {
	%>
			<td align="center" class="<%=classvalue%>"><img src='../../eCommon/images/disabled.gif'><input type="hidden" value="D"></img>
			</td>
	<%
		}
	%>
		</tr>
	<%		
			}
		}
		else {
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);
	</script>
	<%
	   }
	}
	%>
	</table>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:100%; visibility:hidden;bgcolor:yellow;" >
		<table id="tooltiptable" cellpadding=0 cellspacing=0 style="border:1px solid black;" width="auto" height="100%" align="center">
			<tr><td id="t"></td></tr>
		</table>
	</div>	
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="atcclassification" id="atcclassification" value="">	
</form>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

