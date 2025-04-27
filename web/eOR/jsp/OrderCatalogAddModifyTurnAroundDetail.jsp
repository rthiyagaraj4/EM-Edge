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
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language='javascript'   src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body STYLE="overflow-y:hidden;overflow-X:hidden" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='detailUpperForm' id='detailUpperForm' >

<%!
	/***UPDATABLE***********/
	String stat_turn_around_time_updatable		   ="Y";
    String urgent_turn_around_time_updatable	   ="Y";
    String routine_turn_around_time_updatable	   ="Y";
    String stat_turn_around_type_updatable         ="Y";
    String urgent_turn_around_type_updatable       ="Y";
    String routine_turn_around_type_updatable      ="Y";


	public void updatableIntialisation()	{
        stat_turn_around_time_updatable	       ="Y";
        urgent_turn_around_time_updatable      ="Y";
        routine_turn_around_time_updatable	   ="Y";
        stat_turn_around_type_updatable        ="Y";
        urgent_turn_around_type_updatable      ="Y";
        routine_turn_around_type_updatable     ="Y";
	}


%>



<%

try{

	/* Mandatory checks start */
	
	String mode			 = request.getParameter( "mode" ) ;
	//String function_id	 = request.getParameter( "function_id" ) ;
	String bean_id		 = "Or_OrderCatalog" ;
	String bean_name	 = "eOR.OrderCatalogBean";
	//String disabled		 = "" ;
	String eff_status	 = "Y" ;


	updatableIntialisation();


	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;

	bean.setMode( mode ) ;



	/*String order_catalog_code				=   bean.checkForNull(request.getParameter("order_catalog_code" ));
	String long_desc						=	bean.checkForNull(request.getParameter("long_desc"));
	String short_desc						=	bean.checkForNull(request.getParameter("short_desc"));
	String order_category					=	bean.checkForNull(request.getParameter("order_category"));*/
	String module_id						=	bean.checkForNull(request.getParameter("module_id"));
	/*String order_type_code					=   "";
	String security_level					=	"";*/

    ArrayList  turnAroundRecStr =  bean.getTurnAroundRecStr();
    //ArrayList  turnAroundRecStr = new ArrayList();


	//Stat
	//String stat_turn_around_time		 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"stat_turn_around_time","") ;
	//String stat_turn_around_type	 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"stat_turn_around_type","") ;

	//Urgent
  //  String urgent_turn_around_time		 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"urgent_turn_around_time","") ;
	//String urgent_turn_around_type	 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"urgent_turn_around_type","") ;

	//Routine
  //  String routine_turn_around_time		 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"routine_turn_around_time","") ;
	//String routine_turn_around_type	 =	bean.getdefaultArrListValue(turnAroundRecStr,0,"routine_turn_around_type","") ;

	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
		if(eff_status.equalsIgnoreCase("D")){
            stat_turn_around_time_updatable		        ="N";
            urgent_turn_around_time_updatable		    ="N";
            routine_turn_around_time_updatable			="N";
            stat_turn_around_type_updatable        ="N";
            urgent_turn_around_type_updatable      ="N";
            routine_turn_around_type_updatable     ="N";
		}
	}
	/***/

	// Code for Maximum Duration Type Options
	bean.setSettingsDurnStr();
	HashMap durn_type_str =	 bean.getSettingsDurnStr();
	Integer noOfRecDurnTemp = (Integer)durn_type_str.get("noRec");
	int noOfRecDurn   = noOfRecDurnTemp.intValue() ;

    StringBuffer optionsStat = new StringBuffer() ;
    StringBuffer optionsUrgent = new StringBuffer() ;
    StringBuffer optionsRoutine = new StringBuffer() ;

    if(noOfRecDurn != 0){
		for(int i=1 ; i <= noOfRecDurn; i++){
            optionsStat.append("<option value=\""+(String)durn_type_str.get("DURN_TYPE"+i) +  "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(turnAroundRecStr,0,"stat_turn_around_type",""),(String)durn_type_str.get("DURN_TYPE"+i))+">"+(String)durn_type_str.get("DURN_DESC"+i)+"</option>");
            optionsUrgent.append("<option value=\""+(String)durn_type_str.get("DURN_TYPE"+i) +  "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(turnAroundRecStr,0,"urgent_turn_around_type",""),(String)durn_type_str.get("DURN_TYPE"+i))+">"+(String)durn_type_str.get("DURN_DESC"+i)+"</option>");
            optionsRoutine.append("<option value=\""+(String)durn_type_str.get("DURN_TYPE"+i) +  "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(turnAroundRecStr,0,"routine_turn_around_type",""),(String)durn_type_str.get("DURN_TYPE"+i))+">"+(String)durn_type_str.get("DURN_DESC"+i)+"</option>");
		}
	}

	/**/

%>

<br>
<table align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>



<tr>
	 <td  class="label"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></td>

	 <td class="fields" colspan='1'><input type='text' name='stat_turn_around_time' id='stat_turn_around_time' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);" <%=eHISFormatter.chkReturn("y",stat_turn_around_time_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(turnAroundRecStr,0,"stat_turn_around_time","")%>" > <%--parent.parent.parent.chkEnteredMaxVal(this,'0');--%>
    <SELECT <%=eHISFormatter.chkReturn("y",stat_turn_around_type_updatable,"","disabled")%> NAME="stat_turn_around_type" onchange=''><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---</option><%=optionsStat.toString()%></SELECT>
    </td>
</tr>
		 <tr>

	 <td  class="label"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></td>
	 <td class="fields" colspan='1'><input type='text' name='urgent_turn_around_time' id='urgent_turn_around_time' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);" <%=eHISFormatter.chkReturn("y",urgent_turn_around_time_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(turnAroundRecStr,0,"urgent_turn_around_time","")%>" > <%--parent.parent.parent.chkEnteredMaxVal(this,'0');--%>
    <SELECT <%=eHISFormatter.chkReturn("y",urgent_turn_around_type_updatable,"","disabled")%> NAME="urgent_turn_around_type" onchange=''><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---</option><%=optionsUrgent.toString()%></SELECT>
    </td>
</tr>
		 <tr>

	 <td  class="label"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>

	 <td class="fields" colspan='1'><input type='text' name='routine_turn_around_time' id='routine_turn_around_time' size='3' maxlength='3'  class="NUMBER" onBlur="OrCheckPositiveNumber(this);" <%=eHISFormatter.chkReturn("y",routine_turn_around_time_updatable,"","disabled")%> value="<%=bean.getdefaultArrListValue(turnAroundRecStr,0,"routine_turn_around_time",	"")%>" > <%--parent.parent.parent.chkEnteredMaxVal(this,'0');--%>
    <SELECT <%=eHISFormatter.chkReturn("y",routine_turn_around_type_updatable,"","disabled")%> NAME="routine_turn_around_type" onchange=''><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---</option><%=optionsRoutine.toString()%></SELECT>
    </td>

</tr>




</table>




<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="T">

</form>
<%
		putObjectInBean(bean_id,bean,request);
 
}catch(Exception e){
System.out.println(e);
}%>
</body>
</html>




