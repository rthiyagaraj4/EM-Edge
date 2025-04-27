<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ManufacturedItemsReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
 		
	</head>
	<%
		String bean_id = "ManufacturedItemsReportBean";
		String bean_name = "eST.ManufacturedItemsReportBean";
		ManufacturedItemsReportBean bean = (ManufacturedItemsReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		HashMap alstartdate	=	null;
		 
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		        alstartdate             =        bean.getDurationforStartDate();
     String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	     String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		 
  //Added by Rabbani #HSA-CRF-0168
    String ACC_ENTITY_ID = "ZZ";
    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
 
     String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
     String prep_extemp   =   bean.checkForNull((String)hmTemp.get("PREP_EXTEMP_LG"));
     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
     
     if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
    	 
    	 prep_prepack  = "Pre Packing";
         prep_standard = "Standard Formulary";
         prep_extemp   = "Extemporaneous";
         prep_others   =  "Others";
     }
	
	//ends
      
	%>
	<body onLoad="FocusFirstElement()">
		<form name="formmanufacturedItemsReportCriteria" id="formmanufacturedItemsReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		  <table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			   <tr>
			   <td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr></tr>
                <tr></tr>
				<tr></tr>
				<tr></tr>
                <tr></tr>
				<tr></tr>
			 <tr>
	         <td align="left" class="label" width='35%'><fmt:message key="eST.PreparationType.label"   bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <select name="P_PREP_TYPE" id="P_PREP_TYPE" onchange="">
			<OPTION VALUE=""  > <fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
			 <%if(!prep_prepack.equals("")){ %>
			<OPTION VALUE="P"  ><%=prep_prepack%></OPTION>
			 <% } if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S"  ><%=prep_standard%></OPTION>
			<% } if(!prep_extemp.equals("")) {%>
			<OPTION VALUE="E"  ><%=prep_extemp%></OPTION>
			<% } if(!prep_others.equals("")){ %>
			<OPTION VALUE="O"  ><%=prep_others%></OPTION>
			<%} %>
		    </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
			 </td>
            <td class="label" align="left" width="30%"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;<select name="p_report_by" id="p_report_by">
			<option value="DT"><fmt:message key="Common.details.label" bundle="${common_labels}"/></option>
			<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
			</select></td>
		    </tr>
            <tr></tr>
			<tr></tr>
			 <tr></tr>
			<tr></tr>
			 <tr> 
			 
	     
			 <td class=label ><fmt:message key="eST.FromDate.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name= "fm_date" id="fm_date" size=10 maxlength=10 class="DATE"  value="<%=currentdateminus%>" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_date');" ></img><%=bean.getImage("M")%></td>
            <td class=label ><fmt:message key="eST.ToDate.label" bundle="${st_labels}"/>
			   
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name="to_date" id="to_date" size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="CheckDate(this);checkDocDate(document.forms[0]);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" ></img></td>
			</tr>      
			<tr></tr>
			<tr></tr>
			 <tr></tr>
			 <tr></tr> 
			<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input maxLength=20 size=20 name="P_ITEM_CODE" id="P_ITEM_CODE" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(P_ITEM_CODE);" type="button" value="?"></td>
			 </tr>
			  </table>
			    <td> &nbsp;</td><td> &nbsp;</td><td> &nbsp;</td><td> &nbsp;</td> <td> &nbsp;</td> 	  
			 </tr>
			</table>
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="DT_FROM" id="DT_FROM" 					   value="">
			<input type="hidden" name="DT_TO" id="DT_TO" 						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"	>
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			</form>
			 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	</body>
</html>	

