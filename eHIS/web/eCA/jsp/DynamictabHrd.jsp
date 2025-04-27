<!DOCTYPE html>
<%@page language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
		<head>
		<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		%>
		<%
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
	%>

				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
				<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
				<script language="javascript" src="../../eCA/js/ChartHistoryTemplate.js"></script> 					
				<script language="javascript" src="../../eCommon/js/common.js"></script>
				<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
				 
			<%
					String check="CHECKED";
					String summarydesc=request.getParameter("summarydesc")==null?"":request.getParameter("summarydesc");
					String summaryid=request.getParameter("summaryid")==null?"":request.getParameter("summaryid");
					String rows=request.getParameter("rows")==null?"":request.getParameter("rows");
					String cols=request.getParameter("cols")==null?"":request.getParameter("cols");
					String updatemode=request.getParameter("updatemode")==null?"":request.getParameter("updatemode");
					String enadis=request.getParameter("enadis")==null?"":request.getParameter("enadis");
					if (enadis.equals("E"))	check="CHECKED";
					if (enadis.equals("D"))	check=" ";
			%>

				<script language="javascript" >


						function setValue(){
								if (document.forms[0].enadis.checked==true){
										document.forms[0].enadis.value='E';
										if(parent.frames[1].location.href.indexOf(".jsp")!=-1){
												parent.frames[1].document.forms[0].enadis.value='E';
										}
								}else{
										document.forms[0].enadis.value='D';
										if(parent.frames[1].location.href.indexOf(".jsp")!=-1){
												parent.frames[1].document.forms[0].enadis.value='D';
										}
								}
								if('<%=updatemode%>'=='Y')				
										document.forms[0].summarydesc.focus();
								else
										document.forms[0].summaryid.focus();
						}

						
		/*function checktext(){
			var summ =document.forms[0].summaryid.value;
			if(!(summ=null || summ='' ){
			document.forms[0].search.disabled=true;
			}

		}*/

				
				</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</head>

			<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'onLoad="setValue();">  

		
			<%		
					String readonly="";
						if (updatemode.equals("Y")) 	{
							 readonly="readOnly";   	

						}else{
							readonly="";
						}
			%>

			<form name ='HeaderForm' ><br>
				
				<table  width='80%' border='0' cellspacing='0' cellpadding='3'  align='center' height='70%'>
				<tr>
						<td class="label" width='20%'><fmt:message key="eCA.SummaryID.label" bundle="${ca_labels}"/></td>
						<td colspan=2 width='70%' class="fields">
							<input type="text" name="summaryid" id="summaryid" value="<%=summaryid%>" size="30" maxlength=15  onkeypress="return CheckSpecChar(event)" onBlur='changeCase(this);getSummaryDetail(this);'><input type=hidden name=summarydupid value=""><input type="button" value="?" class="button" onClick='getSummaryDetail(this);' name='search' id='search' ><img src='../../eCommon/images/mandatory.gif'  name='mand2' style="visibility:visible"></img>
						</td>
				</tr>
				<tr>
						<td class="label" ><fmt:message key="eCA.SummaryDesc.label" bundle="${ca_labels}"/></td>
						<td colspan=2 class="fields" ><input type="text" name="summarydesc" id="summarydesc" value="<%=summarydesc%>"   <%=readonly%>  onchange="Assignsumdesc(this);" size="50"  maxlength=50 onkeypress="return CheckSpecChar(event)" ><img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
				<tr>
				 		<td class="label"><fmt:message key="eCA.NoofRows.label" bundle="${ca_labels}"/></td> <td  class="fields" ><input type="text" name="rows" id="rows" value="<%=rows%>"  <%=readonly%> maxlength="2" size="3"  onKeyPress='return acceptValidNum(this,event,3,0);'  onBlur='checkValue(this);'><img src='../../eCommon/images/mandatory.gif'></img> <td class="label"><fmt:message key="eCA.NoofColumns.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="cols" id="cols" value="<%=cols%>" <%=readonly%> maxlength="2" size="3"  onKeyPress='return acceptValidNum(this,event,3,0);' onBlur='checkValue(this);'><img src='../../eCommon/images/mandatory.gif' ></img>
						</td>
				</tr>
				<tr>
						<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> <td  class="fields" ><input type="checkbox" name="enadis" id="enadis" value="D" <%=check%> onclick='setValue();' >
						</td>
						<td  align='right'> <input type ='button' name='Details' id='Details' value='<fmt:message key="Common.Define.label" bundle="${common_labels}"/>' class='button' onClick = "showNext();" ></td>
				</tr>
		</table>
			<!-- added by kishore kumar n on 08/12/2009  -->
			<%if(!imgUrl.equals("")){ %>
				 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
				<!--ends here -->	
		<input type=hidden name=updatemode value=""> 
		 
		</form>
	</body>
</html>

<% if (updatemode.equals("Y")){ %>
			<script language=javascript>
			showNext();
			</script>
<% } %>

