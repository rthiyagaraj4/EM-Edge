<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,org.json.simple.parser.JSONParser,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

  <%
        request.setCharacterEncoding("UTF-8");
  		Connection con = null;
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	
	
	<script type="text/javascript" src="../../eIP/html/JQuery/ColorCoding/farbtastic.js"></script>
	<link rel="stylesheet" href="../../eIP/html/JQuery/ColorCoding/farbtastic.css" type="text/css" />
	<script language='javascript' src='../../eMR/js/HAADcolorcodeSetup.js'></script>

	<style type="text/css">			
		/*	.colorpickerDiv{
				float:left;
				border:0px solid black;
			}
			.colorPickTextId{
				margin-left:10%;
				width:100%;
			}
			.TextId{
				width:100%;				
			}
			.colorPickId{
				top:80%;
				margin-left:10%;
				margin-top:10%;
				margin-top:10%;
			}*/
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				font-family:Arial, Helvetica, sans-serif;
					font-size:12px;
			}
			.header
			{
				height:30px;
				background-color:#83aab4;
				font-weight:600;
				color:#fff;
				padding-left:10px;
			}
			.row1
			{
				background-color:#fff;
				height:30px;
				border-bottom:1px solid #dcdfe5;
			}
			.row2
			{
				background-color:#fff;
				height:30px;
				border-bottom:1px solid #f4f4f5;
			}
			.text
			{
				font-size:12px;
				font-weight:400;
				color:#484848;
				padding-left:10px;
			}
			.child
			{
				width:100%; height:150px; overflow:auto;
				border:1px solid #f4f4f5;
			}
			.box
			{
				width:100%; height:500px; overflow:auto;

			}
			.childheader
			{
				height:30px;
				background-color:#f4f4f5;
				font-size:12px;
				font-weight:700;
				color:#484848;
				padding-left:10px;
			}
		</style>
		<script type="text/javascript">
			$(document).ready(function () {
				$('#colorpicker').farbtastic('#color');
				$('.colorcode').click(function (event){
					var $target = $(event.target); // the element that fired the original click event
					$('#color').val($(this).css('backgroundColor'));
					$('#color').focus();
					$('#color').trigger('keyup');
					$("input[id=selectedElem]").val($(this).attr('id'));
					event.stopPropagation();
				});
				
			});
			
		
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{

	con = ConnectionManager.getConnection(request);
	
	String diag_code					= "";
	String diag_desc					= "";


	String diseaseHDRList				= eMR.MRHaadcolorConfigBean.getHaadDiseaseCodeandDesc(con);
	JSONObject jsonObject				= (JSONObject) new JSONParser().parse(diseaseHDRList);
	JSONArray diseaseHDRListArray 		= (JSONArray)jsonObject.get("diseaseHDRList");
	
	
	String termSetList					= eMR.MRHaadcolorConfigBean.getTermSetList(con);
	jsonObject							= (JSONObject) new JSONParser().parse(termSetList);
	JSONArray termSetListArray 			= (JSONArray)jsonObject.get("termSetList");
	JSONArray diagCodeSchemeArray 		= (JSONArray)jsonObject.get("diagCodeScheme");
	
	if(diagCodeSchemeArray.size() > 1){
		JSONObject diagCodeSchemeObj	= (JSONObject)diagCodeSchemeArray.get(0);
		diag_code						= (String) diagCodeSchemeObj.get("scheme_desc");
		diag_desc						= (String) diagCodeSchemeObj.get("diag_code_scheme");
	}%>

	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
		<form name='HaadColorCodeForm' id='HaadColorCodeForm' method='post' target="messageFrame" action='../../servlet/eMR.HAADcolorcodeServlet'>
		<div style="width:97%;">
		<div class="ui-layout-center" style="width:74%; float:left;margin-left:20px;">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="left" valign="top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						  <tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #83aab4">
									 <tr>
										<td width="20%" align="left" valign="middle" class="header"><fmt:message key="eMR.Disease.label" bundle="${mr_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
										<td width="63%" align="left" valign="middle" class="header"><fmt:message key="eMR.Disease.label" bundle="${mr_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
										<td width="13%" align="left" valign="middle" class="header"><fmt:message key="Common.Color.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
										<td width="4%" align="left" valign="middle" class="header">&nbsp;</td>
									</tr>
								</table>
							</td>
						  </tr>
						  <tr>
							<td align="left" valign="top">
								<div class="box">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #83aab4">
									<%for(int i = 0 ; i < diseaseHDRListArray.size() ; i++) {	

										JSONObject diseaseHDRListObj	= (JSONObject)diseaseHDRListArray.get(i);

										String DISEASE_ID				= (String) diseaseHDRListObj.get("DISEASE_ID");
										String DISEASE_NAME				= (String) diseaseHDRListObj.get("DISEASE_NAME");
										String COLOR_CODE				= (String) diseaseHDRListObj.get("COLOR_CODE");
										String className				= "rowA";
										if(i%2==0)
											className					= "rowA";
										else
											className					= "rowB";

										String diseaseDtlsList			= eMR.MRHaadcolorConfigBean.getHaadDiseaseDtls(con,DISEASE_ID,locale);
										JSONObject jsonObject1			= (JSONObject) new JSONParser().parse(diseaseDtlsList);
										JSONArray diseaseDtlsListArray 	= (JSONArray)jsonObject1.get("diseaseDtlsList");
										
										%>
										<tr >
											<td align="left" valign="middle" class="text row1"><%=DISEASE_ID%></td>
											<td align="left" valign="middle"  class="text row1"><%=DISEASE_NAME%></td>
											<td align="center" valign="middle" class="row1"><div id="<%=DISEASE_ID%>" name="<%=DISEASE_ID%>" class='colorcode' style="background-color:<%=COLOR_CODE %>; height:30px;width:30px;border: 1px solid;cursor:pointer;"></div></td>
											<input type='hidden' id="<%=DISEASE_ID%>BgColor" name="<%=DISEASE_ID%>BgColor" value="<%=COLOR_CODE %>" >
											<td align="center" valign="middle" class="row1">
												<img src="../../eOA/patientportal/Edit.png" width="24" height="24" style="cursor:pointer;" id='edit_<%=DISEASE_ID%>' onclick="fnShowTermCode('<%=DISEASE_ID%>'); "/>
												<img src="../../eOA/patientportal/Save.png" width="24" height="24" id='save_<%=DISEASE_ID%>' style="display:none;cursor:pointer;" onclick="fnSave('<%=DISEASE_ID%>');"/ />
											</td>
										</tr>
										<tr id="tr_<%=DISEASE_ID%>" style='display:none;'>
											<td align="left" valign="top">&nbsp;</td>
											<td colspan="3" align="left" valign="top">
												<table width="99%" border="0" cellspacing="2" cellpadding="0">
													<tr>
														<td>
															<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #f4f4f5;">
																<tr>
																	<td width="18%" align="left" valign="middle" class="childheader"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
																	<td width="77%" align="left" valign="middle" class="childheader"><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
																	<td width="5%" align="left" valign="middle" class="childheader">&nbsp;</td>
																</tr>
																<tr>
																	<td width="18%" align="left" valign="middle" class="row2">
																		<select name="termSet_<%=DISEASE_ID%>" id="termSet_<%=DISEASE_ID%>" id="termSet_<%=DISEASE_ID%>">
																			<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
																			
																			<%for(int j = 0 ; j < termSetListArray.size() ; j++){
																				JSONObject termSetListObj = (JSONObject)termSetListArray.get(j);
																				String term_set_id	= (String) termSetListObj.get("term_set_id");
																				String term_set_desc = (String) termSetListObj.get("term_set_desc");%>
																				
																				<option value="<%=term_set_id%>"><%=term_set_desc%></option>
																			<%}%>
																		</select>
																	</td>
																	<td width="77%" align="left" valign="middle" class="row2">
																		<input type='text' name='termCode_<%=DISEASE_ID%>' id='termCode_<%=DISEASE_ID%>' id='termCode_<%=DISEASE_ID%>' value="" size='15' maxlength='15' readonly ><input type='button' class='button' value='?' name='termCodeBtn_<%=DISEASE_ID%>' id='termCodeBtn_<%=DISEASE_ID%>' id='termCodeBtn_<%=DISEASE_ID%>' onClick="call_Diagnosis(termCode_<%=DISEASE_ID%>,this,'<%=DISEASE_ID%>');">
																	</td>
																	<td width="5%" align="left" valign="middle" class="row2">
																		<input type='button' class='button' value='Add' name='addBtn_<%=DISEASE_ID%>' id='addBtn_<%=DISEASE_ID%>' id='addBtn_<%=DISEASE_ID%>' onClick="fnAdd('<%=DISEASE_ID%>');">
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td>
															<div class="child">
																<table width="100%" border="0" cellspacing="0" cellpadding="0" id="tableList_<%=DISEASE_ID%>">
																	<tbody>
																	<%if(diseaseDtlsListArray.size() > 0){
																		for(int k=0; k < diseaseDtlsListArray.size();k++){
																			JSONObject diseaseDtlsListObj	= (JSONObject)diseaseDtlsListArray.get(k);
																			String dtlsTermSetId			= (String) diseaseDtlsListObj.get("TERM_SET_ID");
																			String dtlsTermCode				= (String) diseaseDtlsListObj.get("TERM_CODE");
																			String dtlsTermSetDesc			= (String) diseaseDtlsListObj.get("TERM_SET_DESC");
																			String dtlsTermCodeForTr		= dtlsTermCode.replace(".", "-");
																			String trId						= DISEASE_ID+'_'+dtlsTermSetId+'_'+dtlsTermCodeForTr;
																			String haadId					= dtlsTermSetId+"$$$"+dtlsTermCode+"###"+DISEASE_ID;
																			%>
																			<script>
																				parent.haadTermsetLists.push("<%=haadId%>");
																			</script>
																			<tr  id="<%=trId%>">
																				  <td width="18%" align="left" valign="middle" class="row2"><%=dtlsTermSetDesc%></td>
																				  <td width="77%" align="left" valign="middle" class="row2"><%=dtlsTermCode%></td>
																				  <td width="5%" align="left" valign="middle" class="row2"><img src="../../eOA/patientportal/Close.png" width="24" height="24"  style="cursor:pointer;" onclick="fnRemoveTr('<%=trId%>','<%=haadId%>');" /></td>
																			</tr>
																		<%}
																		}%>
																	</tbody>
																</table>
															</div>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<%}%>
									</table>
								</td>
							</tr>
						</table>
					</div>
					</td>
					<!--<td width="22%" align="center" valign="top">
					</td>-->
				</tr>
			</table>
		</div>
		<div style="float:right" >
			<div id='colorPickTextId' class='colorPickTextId'>
				<input type="hidden" id="color" name="color" id="color" value="#123456" /><br>
			</div>
			<div id='colorPickId' class='colorPickId' style="margin-top:1px; margin-left:40px; width:100%">
				<div id="colorpicker"></div>
			</div>
		</div>
	</div>
		
			<input type='hidden' id='selectedElem' name='selectedElem' id='selectedElem' value=''>
			<input type='hidden' id='IDANDCOLORCONCAT' name='IDANDCOLORCONCAT' id='IDANDCOLORCONCAT' value=''>
			<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>"></input>
			<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>"></input>

			<%}catch(Exception e){
					e.printStackTrace();
				}finally{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}%>
		</form>
	</body>		
</html>

