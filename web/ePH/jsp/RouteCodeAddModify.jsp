<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
      <%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
   <!--Coded added for CRF -0034 -->
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../ePH/js/prototype.js"></SCRIPT> 
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../ePH/js/colorPicker.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../ePH/js/yahoo.color.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../ePH/js/scriptaculous.js"></SCRIPT>
	<!--Coded Ended Here CRF -0034 -->

    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
    
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/RouteCode.js"></SCRIPT>
    
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
	 <!--Coded added for CRF -0034 -->
	<style type="text/css">
		 #colorpicker { position: absolute; width: 145px; height: 145px; overflow: hidden; background: #F9F9F9;
						border: 2px #C0C0C0 outset;z-index: 1000;}
		 #colorpicker-hue-container {position: absolute;top: 4px; left: 120px; width: 18px; height: 110px; }
		 #colorpicker-hue-bg-img { width: 100%;height: 100%;}
         #colorpicker-hue-slider { position: absolute;top: 0;left: 0; width: 100%;height: 100%;}
         #colorpicker-hue-thumb { position: absolute;top: 0;left: 0;width: 18px;height: 18px;z-index: 1009; cursor: default;}
         #colorpicker-bar {text-align: right;padding-right: 10px;}
         #colorpicker-close {cursor: pointer;color: blue;font-size: 10px;font-family: Tahoma, Helvetica, Sans-Serif;
							  font-weight: bold;}
		 #colorpicker-div {position: absolute; top: 8px;left: 8px; width: 100px;height: 100px; border: 1px solid #666;}
		 #colorpicker-bg,
		 #colorpicker-bg-overlay {position: absolute;top: 0;left: 0;width: 100%;height: 100%;z-index: 1001;overflow: hidden;}
		 #colorpicker-selector {position: absolute;top: 0px;left: 0px;width: 11px;height: 11px; z-index: 1009;margin-top: -6px;
								 margin-left: -6px;cursor: default;}
		 #colorpicker-selector img {position: absolute;left: 0;top: 0;}
         #colorpicker-footer { position: absolute; top: 114px;left: 10px; width: 127px;}
		 #colorpicker-value { float: left;}
		 #colorpicker-value,
		 #colorpicker-value-input {font-size: 9px !important;font-family: Helvetica, Verdana, Sans-Serif;height: 15px;background: #FFFFFF;}
         #colorpicker-value-input {width: 40px;}
		 #colorpicker-okbutton {float: right;padding: 0 10px;background: #3366FF;font-size: 10px;font-family: Tahoma, Helvetica, 							Sans-Serif; border: 1px solid #666666;color: #ffffff;}
	 </style>
	 	<!--Coded Ended Here CRF -0034 -->

    <SCRIPT>
//    function lockKey() {
//        if(event.keyCode == 93)
//            alert("Welcome to eHIS");
//    } dt:18/9/09
    </SCRIPT>
</HEAD>


<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
    /* Mandatory checks start */
    String mode				= request.getParameter( "mode" ) ;
    String bean_id			= "RouteCodeBean" ;
    String bean_name		= "ePH.RouteCodeBean";
    String readOnly			= "" ;
    int     totalRecords    =   0;
    String checked			="checked";

    if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    RouteCodeBean bean = (RouteCodeBean)getBeanObject( bean_id,bean_name,request) ;
    bean.clear() ;
    bean.setMode( mode ) ;
	bean.setLanguageId(locale);
    totalRecords    =   Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
    /* Initialize Function specific end */
	//Check if external product link is allowed
	 String exProductLink="N";
	 ArrayList externalRoutes	=	new ArrayList();

	 //added for audit log
	String audit_log_visible	="visibility:hidden";
	String table_id				="PH_ROUTE";
    String pkey_value           ="";

	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean	= (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
log_bean.setLanguageId(locale);
	 
 %>

<form name="formRouteCode" id="formRouteCode" onload="reset();">

<%
        if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) {
%>

    <BR><BR><BR><BR><BR><BR>

<table cellpadding=0 cellspacing=0 border=1 width='90%'  align='center'>

<tr>
        <th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
    	<!--Coded added Here CRF -0034 -->
        <th ><fmt:message key="ePH.routecolor.label" bundle="${ph_labels}"/></th> 
			<!--Code added Here CRF -0034  End-->
        <th  STYLE='display:none'><fmt:message key="Common.LocalLanguageDescription.label" bundle="${common_labels}"/></th>
		<%if (exProductLink.equals("Y"))
		{%>
		<th   nowrap><fmt:message key="ePH.ExternalProductRoute.label" bundle="${ph_labels}"/></th>
		<%}%>
        <th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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

    <td  class='<%=classValue%>'>
      <input type=text name='route_code<%=count%>' id='route_code<%=count%>' onBlur="toUpper(this);RouteCodeCheck(this);"  size="6" maxlength="4" value=""  <%=readOnly%>>
    </td>

    <td  class='<%=classValue%>'>
    <input type="text" name='route_desc<%=count%>' id='route_desc<%=count%>' size="25" maxlength="20" value="" onKeyUp ="formRouteCode.myDesc<%=count%>.value=formRouteCode.route_desc<%=count%>.value"  <%=readOnly%> onBlur="resetColorCode(this);">
    </td>

	<td  class='<%=classValue%>'  STYLE='display:none'>
    <input type="text" name='route_local<%=count%>' id='route_local<%=count%>' size="25" maxlength="20" value=""  <%=readOnly%> onBlur="resetColorCode(this);">
    </td>

	<%if (exProductLink.equals("Y"))
	{%>
    <td  class='<%=classValue%>'>
		<input type="hidden" name="ext_route_desc<%=count%>" id="ext_route_desc<%=count%>">
		<select name="ext_route_code<%=count%>" id="ext_route_code<%=count%>"  onChange="formRouteCode.ext_route_desc<%=count%>.value=this[this.selectedIndex].text" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       </option> 
		 <% 
		for (int i=0;i<externalRoutes.size();i+=2)
		{	
			 %>
	 			<option  value="<%=externalRoutes.get(i)%>"><%=externalRoutes.get(i+1)%></option>	
		<% }%>
	</select>
    </td>
	<%}else
	{
			//store dummy variables for ext_route_Desc and ext_route_code so that the recordset contains the data
			%>
	
	<input type="hidden" name="ext_route_desc<%=count%>"  id="ext_route_desc<%=count%>">
	<input type="hidden"  name="ext_route_code<%=count%>"  id="ext_route_code<%=count%>"  >
			
<%	}%>
	<td class='<%=classValue%>' >
	<input type="text" name='myDesc<%=count%>' id='myDesc<%=count%>' size="25" maxlength="20" value="" readonly  onBlur="resetColorCode(this);" >
 	<input type="hidden" name="route_color<%=count%>" id="route_color<%=count%>" value="">
   	<input type="text" readonly class="routecolor" style="width: 20px;height: 20px;" name="routeColor<%=count%>" id="routeColor<%=count%>"  id="routeColor<%=count%>" value="" <%=readOnly%>> 
      <script type="text/javascript" LANGUAGE="JavaScript" >
          new Control.ColorPicker("routeColor<%=count%>", { "swatch" : "routeColor<%=count%>" });
      </script>
	 </td>
    <td class='<%=classValue%>'>
    <input type="checkbox" name='eff_status<%=count%>' id='eff_status<%=count%>' value="E" checked  <%=readOnly%> >
    </td>


</tr >
<%
        }//for loop
%>

 </table>
<%
}

if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))
{
    bean.setRoute_Code( request.getParameter( "route_code" ).trim() ) ;
    bean.loadData();
	String extRoute=bean.getExternalRoute();
//Added for RUT-CRF-0034 -Start
	String routeColor = bean.getRoute_color()==null?"":bean.getRoute_color();
	String fontColor ="#OOOOOO";
	String backgroundColor ="#FFFFFF";
	 if(routeColor != "" && routeColor != null){
			if(routeColor.length()==12){
				fontColor =routeColor.substring(0, 6);
				backgroundColor= routeColor.substring(6, 12);
			}
	}
//Added for RUT-CRF-0034 -End
	if (extRoute==null)
	{
	extRoute="";
	}
	String LocalRoute=bean.getRoute_Local();
	if (LocalRoute==null)
	{
	LocalRoute="";
	}
    if((bean.getEffStatus()).equals("D"))
        readOnly = "readonly" ;

	/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>ROUTE_CODE
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(bean.getRoute_Code()); 
				pkey_value       ="";
				
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();

				}

	/*--------------------------------------ends here---------------------------------------*/

%>

    <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
    <TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="70%" ALIGN="center" BORDER="0">
    <TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR>
    <TR>
        <TD  CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
        <TD >&nbsp;&nbsp;<INPUT TYPE="text" name="route_code" id="route_code" VALUE="<%=bean.getRoute_Code()%>" SIZE="4" MAXLENGTH="4" readOnly >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
        <TD> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>  
    </TR>
    <TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR>
    <TR>
        <TD CLASS="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
        <TD COLSPAN="2">&nbsp;&nbsp;<INPUT TYPE="text" name="route_desc" id="route_desc" VALUE="<%=bean.getRoute_Desc()%>" SIZE="22" onKeyUp ="formRouteCode.myDesc.value=formRouteCode.route_desc.value" MAXLENGTH="20" <%= readOnly %>  > <!--onKeyUP event added for CR 0034 -->
            <img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
    </TR>

	<TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR>

	 <% if(routeColor.length()==12){%>
	<TR>
        <TD CLASS="label"><fmt:message key="ePH.routecolor.label" bundle="${ph_labels}"/></TD>
        <TD COLSPAN="2">&nbsp;
		<INPUT TYPE="text" VALUE="<%=bean.getRoute_Desc()%>" readonly id="myDesc" name="myDesc" style="color:<%=fontColor%>;background-color:<%=backgroundColor%>;"  SIZE="22" MAXLENGTH="20" <%= readOnly %>>
		<input type="hidden" name="route_color" id="route_color" value="<%=routeColor%>">
		<INPUT TYPE="text" name="routeColor" id="routeColor" class="routecolor" id="routeColor" VALUE="<%=fontColor%>" style="width: 20px;height: 20px;" SIZE="22" readOnly  >
        <script type="text/javascript" LANGUAGE="JavaScript">
            new Control.ColorPicker("routeColor", { "swatch" : "routeColor" });
       </script></TD>
    </TR>
	<% } else {%>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.routecolor.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="2">&nbsp;
		<INPUT TYPE="text" VALUE="<%=bean.getRoute_Desc()%>" readonly id="myDesc" name="myDesc" SIZE="22" MAXLENGTH="20">
		<input type="hidden" name="route_color" id="route_color" value="">
		<INPUT TYPE="text" name="routeColor" id="routeColor" class="routecolor" readOnly id="routeColor" VALUE="" style="width: 20px;height: 20px;" SIZE="22"  >
		<script type="text/javascript" LANGUAGE="JavaScript">
		new Control.ColorPicker("routeColor", { "swatch" : "routeColor" });
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</TD>
      </TR>
	<% } %>
<!-- Code added for CR 0034  End-->
  <!--  <TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR> -->
   <TR STYLE='display:none'>
        <TD CLASS="label" STYLE='display:none'><fmt:message key="Common.LocalLanguageDescription.label" bundle="${common_labels}"/></TD>
        <TD COLSPAN="2" STYLE='display:none'><INPUT TYPE="text" name="route_local" id="route_local" VALUE="<%=LocalRoute%>" SIZE="22" MAXLENGTH="20" <%= readOnly %>  >
           </TD>
    </TR>

    <TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR> 
  
	<%if (exProductLink.equals("Y"))
	{%>
   <TR>
        <TD class="label"><fmt:message key="ePH.ExternalProductRoute.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="2">
			&nbsp;
	<input type="hidden" name="ext_route_desc" id="ext_route_desc" id="ext_route_desc">
	         <select name="ext_route_code" id="ext_route_code" onChange="formRouteCode.ext_route_desc.value=this[this.selectedIndex].text">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       </option> 
			 <% 
		
				for (int i=0;i<externalRoutes.size();i+=2)
				{	
						 if (extRoute.equals(externalRoutes.get(i))) {
			 %>
	 			<option selected value="<%=externalRoutes.get(i)%>"><%=externalRoutes.get(i+1)%></option>	
			
				 <% } else {%>
			 			<option  value="<%=externalRoutes.get(i)%>"><%=externalRoutes.get(i+1)%></option>	
				<% } }%>

			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
        </TD>
    </TR>
		<TR>
        <TD COLSPAN="3">&nbsp;</TD>
	<%} else
	{
			//store dummy variables for ext_route_Desc and ext_route_code so that the recordset contains the data
			%>
		<input type="hidden" name="ext_route_desc" id="ext_route_desc">
		<input type="hidden"  name="ext_route_code" id="ext_route_code" >
			
<%	}%>

    </TR>
	   <TR>
        <TD class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
            <% if((bean.getEffStatus()).equals("E")) {%>
        <TD  COLSPAN="2">&nbsp;&nbsp;<input type="checkBox" name="eff_status" id="eff_status" value="E" checked>
            <% } else { %>
        <TD  COLSPAN="2">&nbsp;&nbsp;<input type="checkBox" name="eff_status" id="eff_status" value="E">
            <%  }   %>
        </TD>
    </TR>
    <TR>
        <TD COLSPAN="3">&nbsp;</TD>
    </TR>
<%
    }//if modify brace
%>
    </TABLE>



    <INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
    <INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
    <INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
    <input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
    <input type="hidden" name="exProductLink" id="exProductLink" value="<%= exProductLink %>">


</form>
<% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ))
{
%>
<script>
    document.formRouteCode.route_code0.focus() ;
</script>
<%
}
if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))
if(checked.equals("checked"))
{
%>

<script>
    document.formRouteCode.route_desc.focus() ;
</script>
<%
}
%>

</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

