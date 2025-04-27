<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/04/2014	IN048083			Karthi L										Option need to be provided for Select All /  De-Select All 
03/08/2017	IN062992		Dinesh T			7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
--------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%!int row_count=0;%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--  -->
<body STYLE="overflow-y:hidden" onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<form name='detailUpperForm' id='detailUpperForm' >
<%  try{
	int counter = 0; //ML-BRU-SCF-1288 - IN048083
	int row_disp=8;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
    String from= "", to ="", dispMode="" ;
    //String readOnly             = "" ;
	//String checked              = "checked" ;
	/* Mandatory checks start */
	
	String mode                 = request.getParameter( "mode" ) ;
	//String function_id          = request.getParameter( "function_id" ) ;
    dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
    String bean_id              = "Or_OrderCatalog" ;
	String bean_name            = "eOR.OrderCatalogBean";
	//String disabled             = "" ;

	OrderCatalogBean bean       = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	String order_catalog_code   =   bean.checkForNull(request.getParameter("order_catalog_code" ));
	//String long_desc            =	bean.checkForNull(request.getParameter("long_desc"));
	//String short_desc           =	bean.checkForNull(request.getParameter("short_desc"));
	String order_category       =	bean.checkForNull(request.getParameter("order_category"));
	String module_id            = 	bean.checkForNull(request.getParameter("module_id"));
	//String order_type_code      =   "";
	//String security_level       =	"";

	//int size                    =  0;

	/*****DEFAULT VALUES****/
	String eff_status               = "E" ; //For modify mode Only if enabled is disabled value is 'N'
	String applicable_yn_default	=  "Y";

	//Hashtable defVal		= new Hashtable();
	//Hashtable defVal_auth_level	= new Hashtable();

	//DATABASE REC
        String applicable_yn_updatable    = "Y";

	/****/

	/*******MODIFY MODE********/
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
	   applicable_yn_default         = "N";
	   //In modify mode if the eff status is no then all should be disabled
		HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
		if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
			applicable_yn_updatable	 =  "N" ;
		}
	}
	/***/

        bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

        if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
            return ;

        bean.setMode( mode ) ;
        bean.setFrequencyFrom("F");

        ArrayList  frequencyRecStr =  bean.getFrequencyRecStr();
		
%>


    <!-----------------------DATABASE RECORD-------------------------------- -->

<%
    if ( from == null || from=="null" || from.equals("null") ) {
		start = 1 ;

	} else {
		start = Integer.parseInt( from ) ;
    }

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

    if(dispMode == null || dispMode.equals("null"))dispMode="";
    if(dispMode.equals("")){
        
		//out.println("<script>alert('bean.frequencyRecStr.size()="+bean.frequencyRecStr.size()+"');</script>");
        if (bean.frequencyRecStr.size() == 0){
            bean.frequencyDefault(mode,order_category,order_catalog_code);
        }
        row_count = bean.frequencyRecStr.size();

        fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
    %>
    <script>
			//alert('in disp equals ""');
            if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON");
            alert(msg);
			//parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
    <%
    }else{

		//int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);


		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);

		}

		if(to_val > (row_count-1))
			to_val=(row_count-1);

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	// ML-BRU-SCF-1288 - IN048083 Start
	String select_all = "";
	int select_counter = fm_disp;
	for(int i=fm_disp; i<=to_disp; i++){
        HashMap frequency = (HashMap)bean.frequencyRecStr.get(i);
		String applicable_yn  = (String)frequency.get("applicable_yn"); 
		if(applicable_yn.equalsIgnoreCase("Y")) 
			select_counter ++ ;
		else 
			select_counter --;
	}
	if(row_count >0) {
		if(select_counter == (to_disp+1)) {
			select_all = "checked";
		}
		else {
			select_all = "unchecked";
		}
	}	
	// ML-BRU-SCF-1288 - IN048083 End
    /*Integer	noOfRecordsTemp = (Integer)frequency.get("noRec");
    int noOfRecords   = noOfRecordsTemp.intValue() ;
    int fm_disp		  = 1 ;
    int to_disp		  = noOfRecords ;*/
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr  width='10%'>
	<td class='WHITE'  align="right">
	<%

	//out.println(start);

	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<A class='gridlink' HREF='javascript:onClick=parent.parent.parent.checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%
	}

	if ( !( (start+row_disp) > (row_count - 1)) ){
	%>
		<A class='gridlink' HREF='javascript:onClick=parent.parent.parent.checkVal("Next");' text-decoration='none' > <fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%
	}

	%>
	</td>
	</tr>
	</table>

<table class='grid' width='100%'>
  <tr>
    <td class="COLUMNHEADER" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
    <td class="COLUMNHEADER" width='15%' ><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/><input type=checkbox  name='check_all' id='check_all' value='Y' onClick='parent.parent.parent.clickAll(this)'  <%=eHISFormatter.chkReturn("y",applicable_yn_updatable,"","disabled")  %> <%= select_all %>></td> <!--  ML-BRU-SCF-1288 - IN048083 Start -->
	<%
	//IN062992, starts
	if(bean.isSiteSpecificYN() && "PH".equals(order_category))
	{
	%>
	<td class="COLUMNHEADER" width='15%' ><fmt:message key="eOR.OncoRegimenFreq.label" bundle="${or_labels}"/></td>
	<%
	}
	//IN062992, ends
	%>
  </tr>

    <%String classValue = "gridData";%>

<%--<Script>alert('<%=row_count%>')</Script>--%>
    <!-- no of Records shown -->
    <INPUT TYPE="hidden" name="noOfRecords" id="noOfRecords" value="<%=row_count%>">

<%  try {
        //if(noOfRecords != 0){
        //    for(int i=fm_disp ; i <= to_disp; i++){
			//out.println("<script>alert('frequencyRecStr="+frequencyRecStr+"');</script>");
        for(int i=fm_disp; i<=to_disp; i++){
            HashMap frequency = (HashMap)bean.frequencyRecStr.get(i);
			//out.println("<script>alert('frequency="+frequency+"');</script>");
			
			
		String frequency_code  = (String)frequency.get("frequency_code");
		String frequency_short_desc  = (String)frequency.get("frequency_desc");
		String l_freq_nature = (String)(frequency.get("freq_nature")==null?"":frequency.get("freq_nature"));//IN062992
		%>
		<%--<script>alert('<%=(String)frequency.get("frequency_code")%>,<%=i%>')</script>--%>
		<%classValue			=( (i%2)==0 )? "gridData" : "gridData";

		if(eff_status.trim().equalsIgnoreCase("D"))
                    applicable_yn_updatable = "N" ;
%>

<tr>
   <!-- Patient Class -->
   <td  class='<%=classValue%>'><%=frequency_short_desc%></td>
   <INPUT TYPE="hidden" name="frequency_code<%=i%>" id="frequency_code<%=i%>" value="<%=frequency_code%>">
   <INPUT TYPE="hidden" name="frequency_desc<%=i%>" id="frequency_desc<%=i%>" value="<%=frequency_short_desc%>">
   <INPUT TYPE="hidden" name="freq_nature<%=i%>" id="freq_nature<%=i%>" value="<%=l_freq_nature%>"><!--IN062992-->
   <!-- Frequency Applicable -->
   <td  class='<%=classValue%>'><INPUT TYPE="checkbox" 
   <%=eHISFormatter.chkReturn("y",applicable_yn_updatable,"","disabled")%> <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(frequencyRecStr,i,"applicable_yn",applicable_yn_default))%> NAME="applicable_yn<%=i%>" value='Y' onClick='parent.parent.parent.unCheckAll("<%=i%>");'> <!--  ML-BRU-SCF-1288 - IN048083 -->
   </td>
   <%
		//IN062992, starts	   
		if(bean.isSiteSpecificYN() && "PH".equals(order_category))
		{
%>
<%
			if("Y".equals(l_freq_nature))
			{	
%>
			<td class='<%=classValue%>'><fmt:message key="eOR.Applicable.label" bundle="${or_labels}"/></td>
<%
			}
			else 
			{
%>
				<td class='<%=classValue%>'><fmt:message key="eOR.NotApplicable.label" bundle="${or_labels}"/></td>
<%
			}
		}
		//IN062992, ends
	%>
</tr>
			
		  <% counter++; }//Loop for all the DBRecords for Patient Class- added counter++ for ML-BRU-SCF-1288 - IN048083

        //}//Loop if noOfRecords > 0
    }catch (Exception e) {System.out.println(e.getMessage());}%>


</table>

<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value=<%=to%>>
<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="F">
<input type="hidden" name ="total_records" value = "<%=counter%>">   <!--  ML-BRU-SCF-1288 - IN048083 -->
<input type="hidden" name ="order_category" value = "<%=order_category%>">   <!--IN062992-->

</form>
<%
	putObjectInBean(bean_id,bean,request);
		}catch(Exception e){
//out.println("here:" + e);//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
}%>
</body>
</html>

