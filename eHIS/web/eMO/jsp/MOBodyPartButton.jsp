<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <title><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></title>
  <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	request.setCharacterEncoding("UTF-8");
  String butt1=request.getParameter("butt1")==null?"":request.getParameter("butt1");
  String viewdata=request.getParameter("viewdata")==null?"":request.getParameter("viewdata");
 String or_installyn=request.getParameter("or_installyn")==null?"N":request.getParameter("or_installyn");
 if(!viewdata.equals("viewdata"))
{
  %>
     <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	 <Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script src='../../eCommon/js/common.js' language='javascript'></script>
	 <script src='../../eMO/js/MORegisterAttn.js' language='javascript'></script>
     <script src='../../eMO/js/MOManageDeceased.js' language='javascript'></script>    
	
		 <form>
		 <table  width='100%'cellpadding='0' cellspacing='0' align='center' border='0' height='100%'>
		 <tr>
		 <td  class='fields' width='2%'>
			<td  class='fields' width='78%'>
			<%if(or_installyn.equals("Y")){%>
			<input type="button" name="placeOrder" id="placeOrder" class="BUTTON" style="visibility:hidden" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PlaceOrder.label","common_labels")%>" onclick="placeOrderSpecimen()"><%}%>&nbsp;</td>
			<td  class='fields' width='20%'>

            <% String regclaim=request.getParameter("regclaim")==null?"":request.getParameter("regclaim");
		    
			if(butt1.equals("butt1"))
			{%>
			<input type="button" name="record" id="record" class="BUTTON" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="startEndCancelPostmortem()">
			<input type="button" name="Close" id="Close" class=BUTTON  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="window.close();"></td>
			<%}else
			if(!regclaim.equals(""))
			{%>
				<input type="button" name="Close" id="Close" class=BUTTON value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="RecordClaimant()"></td>
			<%}else{%>
		<input type="button" name="Close" id="Close" class=BUTTON value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="RecordBodyParts()"></td>
			</tr>
				<%}}%>	
				
		</form>

