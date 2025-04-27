<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper"  %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/DispLocnTimeTable.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	
</head>
<body> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String facility_id          = (String)session.getValue( "facility_id" );
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	String FromHHMI="";
	String ToHHMI="";
	String bean_id	="DispLocnTimeTableBean";
	String bean_name	="ePH.DispLocnTimeTableBean";
	 DispLocnTimeTableBean bean = (DispLocnTimeTableBean)getBeanObject(bean_id,bean_name ,request);
	 String mode=request.getParameter("mode");
	 String disp_code=request.getParameter("disp_code");
	 ArrayList QueryResult=new ArrayList();
	 HashMap QueryResultMap=new HashMap();
	 if(mode!=null) {
		 if(!disp_code.equals("")) {
	         QueryResult=bean.getQueryResult(facility_id,disp_code);
		 }
	 }
	 String day_type_code,day_type_legend="";
	 String from_time_hh="";
	 String from_time_mm="";
	 String to_time_hh="";
	 String to_time_mm="";
	 String db_action="";
	 String classvalue			= "";
	 bean.setLanguageId(locale);
	 bean.setMode(mode);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<form name="DispLocnTimeDetailForm" id="DispLocnTimeDetailForm">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">

<tr>
 <td class= "COLUMNHEADER" colspan="3">Working Hours HH24:MI</td>
</tr>
<tr>
        <td class= "COLUMNHEADER" ><fmt:message key="ePH.DayType.label" bundle="${ph_labels}"/></td>
        <td class= "COLUMNHEADER" colspan="1"><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
        <td class= "COLUMNHEADER" colspan="1"><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
		
		
</tr>

<%
int c_ind=0;
for(int i=0;i<QueryResult.size();i++)
{
	c_ind++;
	 if ( c_ind % 2 == 0 )
			classvalue = "QRYODD" ;
			else
			classvalue = "QRYEVEN" ;
          QueryResultMap = (HashMap)QueryResult.get(i);
     	  day_type_code = CommonBean.checkForNull((String)QueryResultMap.get("day_type_code"));
		  day_type_legend = CommonBean.checkForNull((String)QueryResultMap.get("day_type_legend"));
		  from_time_hh = CommonBean.checkForNull((String)QueryResultMap.get("from_time_hh"));
		  from_time_mm = CommonBean.checkForNull((String)QueryResultMap.get("from_time_mm"));
		  to_time_hh = CommonBean.checkForNull((String)QueryResultMap.get("to_time_hh"));
		  to_time_mm = CommonBean.checkForNull((String)QueryResultMap.get("to_time_mm"));
		  db_action = (String)QueryResultMap.get("db_action");
		
	

	if((!from_time_hh.equals(""))&&(!from_time_mm.equals("")))		 
	{
	    if((from_time_hh.equals(to_time_hh))&&(from_time_mm.equals(to_time_mm)))
	    {
        FromHHMI="";
		
	    }else{
		FromHHMI=from_time_hh+":"+from_time_mm;		
        }
	}else if((from_time_hh.equals(""))&&(from_time_mm.equals("")))
		{
		FromHHMI="";
		}

   if((!to_time_hh.equals(""))&&(!to_time_mm.equals("")))		 
	{
	   if((to_time_hh.equals(from_time_hh))&&(to_time_mm.equals(from_time_mm)))
	    {
       
		ToHHMI="";
	    }
		else{
		 ToHHMI=to_time_hh+":"+to_time_mm;	
        }

	  
		  
	}else if((to_time_hh.equals(""))&&(to_time_mm.equals("")))
		{
		ToHHMI="";
		}
	
%>					
   <tr>
    <td class="<%=classvalue%>"NOWRAP ><font class="HYPERLINK" size='1'name="day_type_legend<%=i%>"><%=day_type_legend%> </font>
	<input type="hidden" name="day_type_code<%=i%>" id="day_type_code<%=i%>" value="<%=day_type_code%>">
   <td class="<%=classvalue%>"NOWRAP ><input type="text" maxlength="5" size="5" name="from_time_hh<%=i%>" id="from_time_hh<%=i%>" onblur="appedzero(this);validtime(this);FromTimeCheck(this,'<%=i%>');finalcompare(this,'<%=i%>')" onkeypress="return allowPositiveNumber()"  value="<%=FromHHMI%>" >
  
  </td>
  <td class="<%=classvalue%>"NOWRAP><input type="text" maxlength="5" size="5" name="to_time_hh<%=i%>" id="to_time_hh<%=i%>"   onblur="appedzero(this);validtime(this);ToTimeCheck(this,'<%=i%>');finalcompare11(this,'<%=i%>');" onkeypress="return allowPositiveNumber()"  value="<%=ToHHMI%>" >
   
   <input type="hidden" name="db_action<%=i%>" id="db_action<%=i%>" value="<%=db_action%>">
  </td>
   
 
 </td>
</tr>
<%}
%>
<input type="hidden" name="mode" id="mode" VALUE="<%=mode%>">
<input type="hidden" name="facility_id" id="facility_id" VALUE="<%=facility_id%>">
<input type="hidden" name="disp_code" id="disp_code" VALUE="<%=disp_code%>">
<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
<input type="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">

</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

