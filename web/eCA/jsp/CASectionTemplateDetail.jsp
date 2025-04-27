<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
15/04/2014	IN048161		Chowminya			Special character is not allowed in the prompt field of the section template	
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
29/06/2016	IN059630		Krishna	Gowtham								   		GHL-CRF-0401	
31/03/2017	IN061907		Krishna Gowtham J	26/04/2017			Ramesh G		ML-MMOH-CRF-0559		
08/05/2017	IN064034		Dinesh T										ML-MMOH-CRF-0557_UT3
---------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>
</title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script language="Javascript" src="../../eCA/js/CASectionTemplateMessage.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}

</style>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='CASectionTemplateDetailForm' id='CASectionTemplateDetailForm' method='post' action='../../servlet/eCA.CASectionTemplateServlet'>
<%
String operation=request.getParameter("operation");
String chked="";
String value="";
String rdonly="";
String disflag="";
String comp_rslt_disp_next_checked = "";/*IN059630_GHL-CRF-0401*/
String auto_fill_yn_checked	="";//IN061907 
//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//String locale = (String) p.getProperty("LOCALE");

if(operation == null) 
{
	operation="insert";
	chked = "";
	value="N";
}

String item_type			=	""	,			title_id					=	"";
String comp_id				=	""	,			prompt_id				=	"";
String row_pos_no		=	""	,			column_pos_no		=	"";
String no_of_col_span	=	""	,			prompt_display_loc	=	"";
String srl_no				=	""	,			comp_type				=	"";
String chk_title			=	"disabled",	make_readonly			=	"";
String chk_component	=	"",				title_text				=	"";
String prompt_text		=	"";


String image_title				="visibility:hidden";
String image_component	="visibility:visible";
String chk_link_hist_def	 	="";
String dis_def_hist			="";

String dis_item_type			=	"";
String sectionCode				=	request.getParameter("section");
if(sectionCode==null) sectionCode="";

String template_type="";
String link_to_std_value_yn		= "";
String dflt_from_hist_appl_yn	= "";
String old_hist_time_frame_unit = "";
String old_hist_time_frame_val	= "";
String event_code				= "";
String event_code_type			= "";
String hint_text				= "";

String acceptOption ="";
String list_selection ="";
String list_presentation ="";
String hint_id ="";
String num_prefix_required_yn ="";
String age_group_code="",hist_rec_type="", age_group_desc ="";
String disableResultCatagory ="disabled";
String formula_result_type = "";
String formula_includes_date_yn	=	"";
String formula_result_unit	=	"";
String includeyn	=	"";
String includeynvisibility= "";
StringBuffer formula_definition = new StringBuffer();

String readonly="";
String chkstr="";

String disappagegroup="";
String readonlyagegroup="";
String mak_readonly = "";
String distitle = "disabled";
String disPromp = "";
String disHint = "";
String comp_desc ="";
String text_allign_yn="N"; /*IN059630_GHL-CRF-0401*/
String auto_result_yn="N";//IN061907 


Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
PreparedStatement AgeGrpstmt = null;
ResultSet AgeGrprs = null;

try
{
	con = ConnectionManager.getConnection(request);
}
catch(Exception e)
{
	out.println(e);
}

if(operation.equals("modify"))
{
	
	//***********************************************
	//clearing off the Linking fields association bean
	if(session.getAttribute("templateBean")!=null)
		session.removeAttribute("templateBean");
	//***********************************************
	rdonly="readOnly";
	disflag="disabled";
	item_type=request.getParameter("item_type");
	if(item_type==null) item_type="";

	if(item_type.equals("Title"))
	{
			chk_title="";
			chk_component="disabled";
			image_title="visibility:visible";
			image_component="visibility:hidden";
			distitle = "";

			
	}

	title_id			=	(request.getParameter("title_id")==null)		? ""	:request.getParameter("title_id");
	comp_id				=	(request.getParameter("comp_id")==null)			? ""	:request.getParameter("comp_id");
	hint_id				=	(request.getParameter("hint_id")==null)			? ""	:request.getParameter("hint_id");	
	prompt_id			=	(request.getParameter("prompt_id")==null)		? ""	:request.getParameter("prompt_id");	
	row_pos_no			=	(request.getParameter("row_pos_no")==null)		? ""	:request.getParameter("row_pos_no");
	column_pos_no		=	(request.getParameter("column_pos_no")==null)	? ""	:request.getParameter("column_pos_no");;
	no_of_col_span		=	request.getParameter("no_of_col_span");
	if(no_of_col_span==null) no_of_col_span="";
	prompt_display_loc=request.getParameter("prompt_display_loc");
	if(prompt_display_loc==null) prompt_display_loc="";
	srl_no=request.getParameter("srl_no");
	if(srl_no==null) srl_no="";
	comp_type=request.getParameter("comp_type");
	if(comp_type==null) comp_type="";

	age_group_code = request.getParameter("age_group_code");
	if(age_group_code==null) age_group_code="";
	hist_rec_type = request.getParameter("hist_rec_type");
	if(hist_rec_type==null) hist_rec_type="";
	acceptOption				=	(request.getParameter("acceptOption")==null)	?""	:	request.getParameter("acceptOption");
	list_selection				=	(request.getParameter("list_selection")==null)	?""	:	request.getParameter("list_selection");
	list_presentation			=	(request.getParameter("list_presentation")==null)	?""	:	request.getParameter("list_presentation");
	num_prefix_required_yn	=	(request.getParameter("num_prefix_required_yn")==null)	?""	:	request.getParameter("num_prefix_required_yn");
	

	formula_result_type		=	(request.getParameter("formula_result_type")==null)	?""	:	request.getParameter("formula_result_type");	
	formula_includes_date_yn		=	(request.getParameter("formula_includes_date_yn")==null)	?""	:	request.getParameter("formula_includes_date_yn");
	formula_result_unit				=	(request.getParameter("formula_result_unit")==null)	?""	:	request.getParameter("formula_result_unit");	
	includeyn				=	(request.getParameter("includeyn")==null)?"":	request.getParameter("includeyn");	
	link_to_std_value_yn = request.getParameter("link_to_std_value_yn")==null?"":request.getParameter("link_to_std_value_yn");
	dflt_from_hist_appl_yn = request.getParameter("dflt_from_hist_appl_yn")==null?"N":request.getParameter("dflt_from_hist_appl_yn");
	old_hist_time_frame_unit = request.getParameter("old_hist_time_frame_unit")==null?"":request.getParameter("old_hist_time_frame_unit");
	old_hist_time_frame_val = request.getParameter("old_hist_time_frame_val")==null?"":request.getParameter("old_hist_time_frame_val");
	event_code = request.getParameter("event_code") == null ? "" :request.getParameter("event_code");
	event_code_type = request.getParameter("event_code_type") == null ? "" :request.getParameter("event_code_type");
	comp_desc = request.getParameter("comp_desc") == null ? "" :request.getParameter("comp_desc");
	text_allign_yn = request.getParameter("text_allign_yn") == null ? "N" :request.getParameter("text_allign_yn"); /*IN059630_GHL-CRF-0401*/
	auto_result_yn	=	request.getParameter("auto_result_yn") == null ? "N" :request.getParameter("auto_result_yn");//IN061907 
	/*IN059630_GHL-CRF-0401_Start*/
	
			if(text_allign_yn.equals("Y"))
			{
				comp_rslt_disp_next_checked = "Checked";
			}
	/*IN059630_GHL-CRF-0401_End*/
	//IN061907 start
			if(auto_result_yn.equals("Y"))
			{
				auto_fill_yn_checked = "Checked";
			}
	//IN061907 ends
	/*******************************************************************/
	try
	{
		if(!item_type.equals("Title"))
		{
			String sql_prompt = "SELECT LABEL_DESC FROM CA_TEMPLATE_LABEL WHERE LABEL_ID = ?";
		
			AgeGrpstmt = con.prepareStatement(sql_prompt);
			AgeGrpstmt.setString(1,prompt_id);
			AgeGrprs = AgeGrpstmt.executeQuery();

			if(AgeGrprs.next())
				//prompt_text = AgeGrprs.getString("LABEL_DESC");//IN064034
				prompt_text = AgeGrprs.getString("LABEL_DESC")==null?"":AgeGrprs.getString("LABEL_DESC");//IN064034

			if( AgeGrprs != null) AgeGrprs.close();
			if( AgeGrpstmt != null) AgeGrpstmt.close();

			sql_prompt = "SELECT LABEL_DESC FROM CA_TEMPLATE_LABEL WHERE LABEL_ID = ?";
					
			AgeGrpstmt = con.prepareStatement(sql_prompt);
			AgeGrpstmt.setString(1,hint_id);
			AgeGrprs = AgeGrpstmt.executeQuery();

			if(AgeGrprs.next())
				//hint_text = AgeGrprs.getString("LABEL_DESC");//IN064034
				hint_text = AgeGrprs.getString("LABEL_DESC")==null?"":AgeGrprs.getString("LABEL_DESC");//IN064034

			if( AgeGrprs != null) AgeGrprs.close();
			if( AgeGrpstmt != null) AgeGrpstmt.close();
		}
		else
		{
			String sql_prompt = "SELECT LABEL_DESC FROM CA_TEMPLATE_LABEL WHERE LABEL_ID = ?";
		
			AgeGrpstmt = con.prepareStatement(sql_prompt);
			AgeGrpstmt.setString(1,title_id);
			AgeGrprs = AgeGrpstmt.executeQuery();

			if(AgeGrprs.next())
				//title_text = AgeGrprs.getString("LABEL_DESC");//IN064034
				title_text = AgeGrprs.getString("LABEL_DESC")==null?"":AgeGrprs.getString("LABEL_DESC");//IN064034

			if( AgeGrprs != null) AgeGrprs.close();
			if( AgeGrpstmt != null) AgeGrpstmt.close();
		}
	}
	catch (Exception e3)
	{
		out.println(e3);
	}

	/*******************************************************************/
	/********** age group desc ***************/
	if(!age_group_code.equals(""))
	{
		String AgeGrpsql="SELECT SHORT_DESC FROM AM_AGE_GROUP where AGE_GROUP_CODE = ? ";
		AgeGrpstmt = con.prepareStatement(AgeGrpsql);
		AgeGrpstmt.setString(1,age_group_code);
		AgeGrprs = AgeGrpstmt.executeQuery();

		while(AgeGrprs.next())
			age_group_desc = AgeGrprs.getString("SHORT_DESC");
	}
		

	/*************************************/

	dis_item_type="disabled";
	if(comp_type.equals("F"))
	{
		make_readonly="readOnly";
		disableResultCatagory = "";
	}
	if(dflt_from_hist_appl_yn.equals("Y")){
		
		chk_link_hist_def ="checked";
		dis_def_hist = "disabled";
	}

	if(comp_type.equals("A"))
	{
		try
		{
			String sql = "select DEP_DEFINITION from ca_section_template where SEC_HDG_CODE=? and SRL_NO=? and COMP_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sectionCode);
			pstmt.setString(2,srl_no);
			pstmt.setString(3,comp_id);
			rs=pstmt.executeQuery();
			Clob formula_def_clb = null;
			if(rs.next())
			{
				formula_def_clb = rs.getClob(1);

				if(formula_def_clb!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(formula_def_clb.getCharacterStream());
					String line = "";
					while((line = r.readLine())!=null)
						formula_definition.append(line);
				}			
			}

		}
		catch(Exception e)
		{
			out.println(e);
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}


	}
}

/********************************/

if((sectionCode !=null)&& (!sectionCode.equals(""))){
	try
		{
			String sql = "select template_type from ca_section_hdg where SEC_HDG_CODE=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sectionCode);
			rs=pstmt.executeQuery();
//			Clob formula_def_clb = null;
			if(rs.next())
			{
				template_type = rs.getString(1);
				if (template_type == null) template_type="";

			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
}
//out.println("<script>alert('@@ template_type="+template_type+"');</script>");
/********************************/
%>
<table  width='100%' cellspacing='5' cellpadding='3'  border=1 bordercolor=blue>
<tr>
<td>
		<table  width='100%' cellpadding='3' align='center'  style="border: 1.5px solid blue; border-collapse: collapse;">
			<tr>
				<td class=label width='25%'  ><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><select name='item_type' id='item_type' onChange='callMandatory(this)' <%=dis_item_type%>>
						<option value='C'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></option>
						<%  if(item_type.equals("Title")) {  %>
								   <option value='T' selected><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></option>							   
						<%	}else{ %>
								  <option value='T'><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></option>
						<%	} %>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			
		
				<td class=label width='25%' ><fmt:message key="Common.TitleText.label" bundle="${common_labels}"/></td>
				<td class ='fields' width='25%'><input type="text" name="title_text" id="title_text" size="15" maxlength="200" value="<%=title_text%>" readOnly onkeypress="return CheckForSpecCharsNoCaps(event)" <%=chk_title%>><input type="button" value="?" name="title_diag" id="title_diag" class="button" onClick="callTitleText()"  <%=distitle%>><img src='../../eCommon/images/mandatory.gif' align='center' name='mand1' style="<%=image_title%>"></img>
				<input type='hidden' name="title_text_code" id="title_text_code" value='<%=title_id%>' >
				</td>
			</tr>
			<tr>
				<td class="label" width='25%' >
					<fmt:message key="Common.AcceptOption.label" bundle="${common_labels}"/>
				</td>
				<td class ='fields' width='25%'>
					<select name="acceptOption" id="acceptOption" >
					
					
					
					<%if(!item_type.equals("Title")){%>
						<option value="O" <%=acceptOption.equals("O")?"selected":""%>><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option>
						<option value="R" <%=acceptOption.equals("R")?"selected":""%>><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
						
							
						<%}


					

						else{
							
							readonly="readOnly";
						   // }
						%>

                            
                    		<option value="D" <%=acceptOption.equals("D")?"selected":""%>  <%=readonly%>><fmt:message key="Common.DisplayOnly.label" bundle="${common_labels}"/></option>
							<%
							  }
							%>


<% 
if(item_type.equals("Component/Embedded Component")|| item_type.equals("Component/Formula") || item_type.equals( "Component/Grid Component") ||  item_type.equals("Component/Matrix Component") ||  item_type.equals( "Component/Summary Component")){%>
						
<script>
var i=0;
		var len=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.acceptOption.options.length;
		var lBox=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.acceptOption; 
		lBox.remove(lBox.options[0]);
	 
		 while(i<= len){
			 lBox.remove(lBox.options[i]);
			 i+=1;
		}
//alert(parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.acceptOption.options.length);
</script>
						<option value="O" <%=acceptOption.equals("O")?"selected":""%>><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option>
						<option value="D" <%=acceptOption.equals("D")?"selected":""%>><fmt:message key="Common.DisplayOnly.label" bundle="${common_labels}"/></option>
						
							
						<%}%>

					</select>
				</td>
			
			
			<%
			
			if(operation.equals("modify") && item_type.equals("Title"))
			{
            includeynvisibility = "display:none";
			
			}
			if(operation.equals("modify"))
             {
				  
				 if(includeyn.equals("Y"))
                 {
					 chked="checked";
					 value="Y";
				 }
				 else
				 {
					 chked="";
					 value="N";

				 }
			 }
			 /*else
			 {
            if(chked.equals("checked"))
			value="Y";
			else
			value="N";
			 }*/
			%>
			<td id='wid' class='label' width='25%' style="<%=includeynvisibility%>"><fmt:message key="Common.IncludeforAnalysis.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%' style="<%=includeynvisibility%>"><input type="checkbox" name="includeyn" id="includeyn" value="<%=value%>" onClick='setIncludeyn(this)' <%=chked%> ></td>
			</tr>
		</table>
</td>
</tr>
<tr>
 <%

			
			if(item_type.equals("Title"))
				{
            disappagegroup="disabled";
			readonlyagegroup="readOnly";
			mak_readonly = "readOnly";
			disPromp = "disabled";
			disHint = "disabled";
				}
			%>
<td>

		<table   width='100%' cellpadding='3' align='center' style="border: 1.5px solid blue; border-collapse: collapse;">
			<tr>
				<td  class=label width='25%'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' >
				<input type="hidden" name="template_type" id="template_type" value="<%=template_type%>">
					<input type="text" name="component" id="component" size="10" maxlength="20" value="<%=comp_id%>" <%if(!operation.equals("modify")){%>onblur='callComponent()'<%}%> <%=chk_component%> <%=rdonly%>><input type="button" value="?" class="button" onClick="callComponent()" name='search' id='search' <%=chk_component%> <%=disflag%>><img src='../../eCommon/images/mandatory.gif'  name='mand2' style="<%=image_component%>"></img>
					<input type='hidden' name='comp_desc' id='comp_desc' value = '<%=comp_desc%>'>
				</td>
			
			<td  class=label width='25%'><fmt:message key="Common.Prompt.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>

				<input type="text" name="component_promptdiag" id="component_promptdiag" size="15" maxlength="30" 
				 OnKeyPress ="return CheckForPromptSpecChars(event)" readonly  value = '<%=prompt_text%>'><input type="button" value="?"  class="button" onClick="callDialogPrompt()"  name='component_promptdiag_srch' id='component_promptdiag_srch'  <%=disPromp%>><img src='../../eCommon/images/mandatory.gif'  name='mandatory' style="<%=image_component%>"></img>
				<input type='hidden' name='component_prompt' id='component_prompt' value='<%=prompt_id%>'>
			</td>
			</tr>
           
			<tr>
				<td  class='label' width='25%'><fmt:message key="Common.ApplicableAgeGroup.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type="text" name="age_group_code_desc" id="age_group_code_desc" size="10" value="<%=age_group_desc%>" 
				onBlur='callAgeGroups(this)' onChange="ClearAgeGroup(this)" <%=readonlyagegroup%>><input type="hidden" name="age_group_code" id="age_group_code" size="10" value="<%=age_group_code%>"><input type="button" value="?" class="button" onClick="callAgeGroups(this)" name='searchCondition' id='searchCondition' <%=disappagegroup%>>
				</td>
			
				<td class='label' width='25%'><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
			<!--IN061907 start-->	
				<!--<td class='fields' width='25%'><select name='hist_rec_type' id='hist_rec_type' <%=disableResultCatagory%> >-->
					<td class='fields' width='25%'><table  cellpadding="0" width="100%"><tr><td class='label' style="padding-left:0" width="40%"><select name='hist_rec_type' id='hist_rec_type' onChange="callDiagnosis(this)"<%=disableResultCatagory%> >
			<!--IN061907 ends-->
						<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
						<%	
								String short_desc="",hist_rec_type_val="",selected_val="";
								String diag_hist_rec_type_yn="";//IN061907
								try{
									String sql = "select hist_rec_type, short_desc from cr_hist_rec_type where hist_rec_type NOT IN ('CLNT') order by 2";
									pstmt = con.prepareStatement(sql);
									rs=pstmt.executeQuery();
									while(rs.next())	{
											hist_rec_type_val	= rs.getString("hist_rec_type");
											short_desc		= rs.getString("short_desc");
											if(hist_rec_type_val == null)hist_rec_type_val="";
											if(short_desc == null)short_desc="";
											if(hist_rec_type_val.equals(hist_rec_type)){
													selected_val = "selected";
													//IN061907 start
													if(hist_rec_type_val.equals("DIAG"))
													{
														diag_hist_rec_type_yn="YES";
													}
													//IN061907 ends
											}
										out.println("<option value=\""+hist_rec_type_val+"\" "+selected_val+" >"+short_desc+"</option>");
										selected_val="";
								}
							}catch(Exception e)	{
											out.println("from hist rec type Query"+e);
							}finally	{
								if(rs!=null)rs.close();
								if(AgeGrprs!=null)AgeGrprs.close();
								if(pstmt!=null)pstmt.close();
								if(con!=null)	ConnectionManager.returnConnection(con,request);
						}
									
					%>
					</select>
					<!--IN061907 starts-->
					</td>
					<td class='label' width="60%" id="result_auto_fill" Style='display:none' nowrap>
						<fmt:message key="eCA.AutoFillActiveDiagnosis.label" bundle="${ca_labels}"/>&nbsp;
						<input type="checkbox"  name="auto_fill_yn" id="auto_fill_yn" value="" onClick='enableAutoResult(this)' <%=auto_fill_yn_checked%>>
						
					</td></tr></table>	
						<script>
							callOnLoadDiagResult();
						</script>
					<!--IN061907 ends-->
				</td>
			</tr>
		
			<tr>
					<td class='label' width='25%'><fmt:message key="Common.RowPosition.label" bundle="${common_labels}"/></td>	
					<td class='fields' width='25%'><input type="text" name="row_position" id="row_position" maxlength="2" size="2" value="<%=row_pos_no%>" onKeyPress="return allowValidNumber2(this,event,2,0)" onblur="return checkForMinus(this)"><img src='../../eCommon/images/mandatory.gif'></img></td>
			
					<td class='label' width='25%'><fmt:message key="Common.ColumnPosition.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type="text" name="column_position" id="column_position" maxlength="1" size="1" value="<%=column_pos_no%>" onKeyPress="return allowValidNumber2(this,event,1,0)" onblur="chkValue(this)" <%=make_readonly%>><img src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>

			<tr>
					<td class='label' width='25%'><fmt:message key="Common.ColumnSpan.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type="text" name="column_span" id="column_span" maxlength="1" size="1" value="<%=no_of_col_span%>" onblur="chkValue(this)" onKeyPress="return allowValidNumber2(this,event,1,0)" <%=make_readonly%>><img src='../../eCommon/images/mandatory.gif'align='center' ></img></td>
					<td class='label' width='25%'><fmt:message key="Common.LabelPosition.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><select name='disp_position' id='disp_position'>
							  <option value='L'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
							 <%	 //if(prompt_display_loc.equals("Top"))	 {	 %>	
									  <!-- <option value='T' selected>Top</option> -->
							<% //} else {	%>
									  <!-- <option value='T'>Top</option> -->
							<%	/*}*/ if(prompt_display_loc.equals("Center"))	 { %>
									 <option value='C' selected><fmt:message key="Common.Center.label" bundle="${common_labels}"/></option>	
							 <%	 } else if(item_type.equals("Title"))  { %>
									<option value='C'><fmt:message key="Common.Center.label" bundle="${common_labels}"/></option>
							<%  }%>
						</select>
					</td>
			</tr>
			<tr>
				<td class="label" width="25%"><fmt:message key="eCA.HintMessage.label" bundle="${ca_labels}"/></td>
				<td class='fields' width='25%'>
					<textarea name="hintMessagediag" readonly rows="2" maxlength="100" cols="35" onkeyPress="return CheckForSpecCharsNoCaps(event);"  <%=mak_readonly%>  onchange='chopText(this,100)' 		onkeyup='chopText(this,100)'><%=hint_text%></textarea><input type="button" value="?"  align='center' class="button" onClick="callDialogHint()" name='hintMessagediag_srch' id='hintMessagediag_srch' <%=disHint%> > <!-- removed decode for hint_text -- IN048161 -->
					<input type='hidden' name="hintMessage" id="hintMessage" value='<%=hint_id%>' >
				</td>	
				<!--IN059630_GHL-CRF-0401_Start-->
				<td id="comp_rslt_disp_next_line_id"  class="label" width="25%" style="<%=((comp_type.equals("H"))||comp_type.equals("F")) ?"":"display:none"%>">
					<fmt:message key="eCA.textAlignment.label" bundle="${ca_labels}"/>
				</td>
				<td id="comp_disp_next_yn_id" class='fields' width='25%' style="<%=((comp_type.equals("H"))||comp_type.equals("F")) ?"":"display:none"%>">
					<input type="checkbox" name="comp_disp_next_yn" id="comp_disp_next_yn" value="" onClick='enableResultDispNextLine(this)' <%=comp_rslt_disp_next_checked%>>
				</td>
				
				<!--IN059630_GHL-CRF-0401_End-->
			</tr>
		</table>
</td>
</tr>
<tr  id="tablist" >
	<td >
	
		<table width='100%' cellpadding='3' align='center' style="border: 1.5px solid blue; border-collapse: collapse;">
			<tr style="<%=((comp_type.equals("I")) || (comp_type.equals("N")) || (comp_type.equals("H"))) ?"":"display:none"%>" id="histDefYNTR">
				<td class='label' width='50%'><fmt:message key="eCA.DefaultFromHistory.label" bundle="${ca_labels}"/></td>
				<td class='fields' width='50%'><input type='checkbox' name='hist_def_yn' id='hist_def_yn' value='Y' onclick='enableHistBtn(this)' <%=chk_link_hist_def%>><input type='hidden' name='dflt_from_hist_appl_yn' id='dflt_from_hist_appl_yn' value="<%=dflt_from_hist_appl_yn%>" ></td>
			</tr>
			<tr style="<%=!comp_type.equals("L")?"display:none":""%>" id="presentationCriteriaTR">
				<td class=label ><fmt:message key="Common.Presentation.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name="presentationSelect" id="presentationSelect" onchange="changeSelectionSelect(this);">
						<option value="S" <%=list_presentation.equals("S")?"selected":""%>><fmt:message key="Common.single.label" bundle="${common_labels}"/></option>
						<option value="M" <%=list_presentation.equals("M")?"selected":""%>><fmt:message key="Common.multiple.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class='label'><fmt:message key="Common.Selection.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name="selectionSelect" id="selectionSelect" <%=list_presentation.equals("S")?"disabled":""%>>
						<option value="S" <%=list_selection.equals("S")?"selected":""%>><fmt:message key="Common.single.label" bundle="${common_labels}"/></option>
						<option value="M" <%=list_selection.equals("M")?"selected":""%>><fmt:message key="Common.multiple.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				</tr>
				<tr style="<%=!(comp_type.equals("I") || comp_type.equals("N"))?"display:none":""%>" id="numericPrefixTR">
				<td class='label' >
					<fmt:message key="Common.NumericPrefixRequired.label" bundle="${common_labels}"/>
				</td>
				<td class='fields'>
					<input type="checkbox" name="prefixRequired" id="prefixRequired" <%=num_prefix_required_yn.equals("Y")?"checked":""%>>
				</td>
			</tr>			
			<tr style="<%=!comp_type.equals("A")?"display:none":""%>" id="formulaResultTypeTR">
				<td class='label' width='25%'><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
					<select name="formulaResultType" id="formulaResultType" onchange="changeFormulaType(this);">
						<option value="N" <%=formula_result_type.equals("N")?"selected":""%>><fmt:message key="Common.Numeric.label" bundle="${common_labels}"/></option>
						<option value="D" <%=formula_result_type.equals("D")?"selected":""%>> <fmt:message key="Common.date.label" bundle="${common_labels}"/></option>						
					</select>
				</td>
			</tr>
			<tr style="<%=!comp_type.equals("A")?"display:none":""%>" id="formulaTypeTR">
				<td class='label' width='25%'><fmt:message key="eCA.IncludesDate.label" bundle="${ca_labels}"/></td>
				<td class='fields' width='25%'>
				<%
				if(formula_result_type.equals("D") && formula_includes_date_yn.equals("Y"))
				chkstr="checked disabled";
				else if(formula_result_type.equals("N") && formula_includes_date_yn.equals("Y"))
                chkstr="checked";
				else
				chkstr="";
				%>
				<input type="checkbox" name="includeDates" id="includeDates" onclick="formulaDateCheck(this);" <%=chkstr%>>
				</td>
			</tr>
			
			<tr style="<%=(formula_result_type.equals("N") && formula_includes_date_yn.equals("Y"))?"":"display:none"%>" id="formulaResultUnitTR">
				<td class='label' width='25%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
				
					<select name="formulaResultUnits" id="formulaResultUnits">
					    <option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="Hours" <%=formula_result_unit.equals("Hours")?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
						<option value="Minutes"<%=formula_result_unit.equals("Minutes")?"selected":""%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
						<option value="Days" <%=formula_result_unit.equals("Days")?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value="Weeks" <%=formula_result_unit.equals("Weeks")?"selected":""%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
						<option value="Months" <%=formula_result_unit.equals("Months")?"selected":""%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value="Years" <%=formula_result_unit.equals("Years")?"selected":""%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
					<p id="mand" style="display:none"><img src='../../eCommon/images/mandatory.gif' ></img></p>
				</td>
			</tr>			
		</table>
	</td>
	</tr>
</table>

<input type='hidden' name='section' id='section' value="">
<input type='hidden' name='hitem_type' id='hitem_type' value="">
<input type='hidden' name='srl_no' id='srl_no' value="<%=srl_no%>">
<input type='hidden' name='operation' id='operation' value="<%=operation%>">
<input type='hidden' name='prev_row_pos_no' id='prev_row_pos_no' value="<%=row_pos_no%>">
<input type='hidden' name='prev_column_pos_no' id='prev_column_pos_no' value="<%=column_pos_no%>">
<input type='hidden' name='prev_no_of_col_span' id='prev_no_of_col_span' value="<%=no_of_col_span%>">
<input type='hidden' name='component_type' id='component_type'  value="<%=comp_type%>">
<input type='hidden' name='formula_definition' id='formula_definition' value="<%=formula_definition.toString()%>">
<input type='hidden' name='includeDates_hiddenfield' id='includeDates_hiddenfield' value="<%=formula_includes_date_yn.equals("")?"N":formula_includes_date_yn%>">
<input type='hidden' name='old_hist_time_frame_val' id='old_hist_time_frame_val' value='<%=old_hist_time_frame_val%>' >
<input type='hidden' name='old_hist_time_frame_unit' id='old_hist_time_frame_unit' value='<%=old_hist_time_frame_unit%>' >
<input type='hidden' name='hist_rec_type_hidden' id='hist_rec_type_hidden' value='<%=hist_rec_type%>' >
<input type='hidden' name='event_code' id='event_code' value='<%=event_code%>' >
<input type='hidden' name='event_code_type' id='event_code_type' value='<%=event_code_type%>' >
<input type='hidden' name='component_id' id='component_id' value='<%=comp_id%>' >
<input type='hidden' name='section_code' id='section_code' value='<%=sectionCode%>'>
<input type="hidden" name="textAllignYN" id="textAllignYN" value="<%=text_allign_yn%>"/> <!-- //IN059630 -->
<input type="hidden" name="autoResultYN" id="autoResultYN" value="<%=auto_result_yn%>"/> <!-- IN061907 -->
<%
if(formula_includes_date_yn.equals("") && operation.equals("modify"))
out.println("<script>formulaDateCheck(document.getElementById('includeDates'),'P')</script>");
%>

<input type='hidden' name='listcheck' id='listcheck' value="">
</form>
<%
out.println("<script>changeSelectionSelect(document.getElementById('presentationSelect'))</script>");
%>
</body>
</html>


