<!DOCTYPE html>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eDS/js/DSparameterAcrossFacility.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
	// modified by N Munisekhar on 20-May-2013 against [IN39866]
		function apply() {
			var formObj = parent.content.f_query_add_mod.document.forms[0];
			var flag =checkNull();
		    if(flag==true){
			formObj.method='post';
			formObj.action="../../servlet/eDS.DSparameterAcrossFacilityServlet";
			formObj.submit();
			}
		}

		function checkNull(){
		  var error="";
		  var flag;
			var formObj = parent.content.f_query_add_mod.document.forms[0];
			deptCode=formObj.querySelector("#deptCode").value;
			var Department_label=getLabel("eOT.dsparameteracrossfacility.deptcode","OT");
			uomCode=formObj.querySelector("#uomCode").value;
			var uomCode_label=getLabel("eOT.dsparameteracrossfacility.energy","OT");
			if(deptCode == ""){
			flag =false;
			error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",Department_label)+"<br>";
			}
			if(uomCode == ""){
			  flag =false;
			  error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",uomCode_label)+"<br>";
				}
			messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			if(flag==false) return false; else return true;
		}
		//End  of [IN39866]
		function onSuccess()
		{
	         f_query_add_mod.location.reload();
		}

		function reset() {
		  var formObj = parent.content.f_query_add_mod.DSparameterAcrossTheFacilityForm;
		  var mode=formObj.mode.value;
		  formObj.reset();
		  formObj.mode.value=mode;
	 	}
	</script>
</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDS/jsp/DSparameterAcrossFacility.jsp' frameborder=0 noresize style='height:83vh;width:100vw'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="no" style="height:9vh;width:100vw"></iframe>
</html>

