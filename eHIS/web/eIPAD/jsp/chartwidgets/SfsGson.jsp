<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@page import="eIPAD.chartsummary.common.healthobject.*"%>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
List<SfsJson> oSfsList = new ArrayList<SfsJson>();
int nCount = 0;
int nId = 0;
int nListCount = 0;
if(request.getParameter("RC") != null && !request.getParameter("RC").equals(""))
{
	nId = Integer.parseInt(request.getParameter("RC"));
}
if(request.getParameter("json") != null && !request.getParameter("json").equals(""))
{
	String reactionDetails = request.getParameter("json");
	JsonElement oJsonElement = new JsonParser().parse(reactionDetails);
	if(oJsonElement != null)
	{
		JsonArray oJsonArray = oJsonElement.getAsJsonArray();
		if(oJsonArray != null)
		{
			Iterator iterator = oJsonArray.iterator();
			
			while(iterator.hasNext()){
				JsonElement json2 = (JsonElement)iterator.next();
				Gson gson2 = new Gson();
				SfsJson oSfsJson =  gson2.fromJson(json2, SfsJson.class);
				if(oSfsJson != null)
				{
					oSfsList.add(oSfsJson);
				}
				  
				  
			}
		}
		
	}

	
}
nListCount = oSfsList.size();
if(nListCount > 0)
{
	for(nCount =0;nCount<nListCount;nCount ++)
	{
		SfsJson oSfsJson = oSfsList.get(nCount);
		%>
		

<div data-role="none" class="reactionItemsContainer"
	id="ReactionContainer<%=nId%>" >
	<!-- reaction first row -->
	<table class="tbReactionItemsContainer" cellspacing="0" cellpadding="0"
		border="0" data-role="none">
		<tr class="normalTr">
			<td class="reactionTd" valign="middle">
				<div data-role="none" style="height: auto"
					id="dvReactionParent<%=nId%>">
					<div data-role="none" class="reactionItems">
						<!-- reaction items -->
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0" data-role="none">
								<tr class="normalTr">
									<td class="removeReactionSmallTd" valign="middle" align="right">
										<div class="allergyRowFonts">Reaction Description</div>
									</td>
									<td class="removeReactionTd" valign="middle" align="left">
										<span data-role="none" class="spanReactionContent"><%=oSfsJson.desc %></span>
									</td>
								</tr>
							</table>
						</div>
						<div class="rowDivider"></div>
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0" data-role="none">
								<tr class="normalTr">
									<td class="removeReactionSmallTd" valign="middle" align="right">
										<div class="allergyRowFonts"
											id="ReactionDateTime<%=nId%>_Label"><%=csResBundle.getString("allergy.date") %> <font style="color: red">*</font>
										</div>
									</td>
									<td class="removeReactionTd" valign="middle" align="left">
										<!-- Error Message Container for reac date -->
										<div class="formValWarningTheme formValError"
											id="ReactionDateTime<%=nId%>_Warning"
											style="top: 55px; left: 32.5%; display: none; width: auto;">
											<div class="formValErrorMsgTheme"
												id="ReactionDateTime<%=nId%>_WarningMsg"></div>
										</div> <input id="ReactionDateTime<%=nId%>" data-count="<%=nId%>"
										data-type="DateTime"
										style="position: relative; width: 240px; margin-left: 10px"
										data-role="none" onchange="validate(this)"
										data-errmsg1="Reaction Date/Time cannot be greater than Current Date/Time"
										data-errmsg2="Reaction Date cannot be less than Active since Date"
										data-mandatory="true" /> <input type="hidden"
										id="hdnReactionDateTime<%=nId%>"
										name="hdnReactionDateTime<%=nId%>" /> 
										<script>
										 $(document).ready(function() {
							              // create DateTimePicker from input HTML element
										     //var today2 = new Date();
							                 $("#ReactionDateTime<%=nId%>").kendoDateTimePicker({
												 interval: 5,
												 value: today,
												 change : function(e)
												 {
													 var react_date_calobj = $("#ReactionDateTime<%=nId%>").data("kendoDateTimePicker");
												 	 $("#hdnReactionDateTime<%=nId%>").val(DMYHMToString(react_date_calobj.value()));
												 }
											 });
										  });
										</script>
									</td>
								</tr>
							</table>
						</div>
						<div class="rowDivider"></div>
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="removeReactionSmallTd" valign="middle" align="right">
										<div class="allergyRowFonts"><%=csResBundle.getString("allergy.severity") %></div>
									</td>
									<td class="removeReactionTd" valign="middle" align="left">
										<div class="divRangeContainer" data-role="none">
											<div id="nDvParent<%=nId%>" class="parent" data-role="none">
												<div id="scaleDv<%=nId%>" class="scale scaleTheme"
													data-role="none">
													<div data-role="none" class="Round roundTheme" id="Round<%=nId%>" data-count="<%=nId%>"></div>
													<div data-role="none" class="scaleHover scaleHoverTheme"
														id="scaleHover<%=nId%>"></div>

													<div data-role="none"
														class="scaleSeparator1 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,<%=nId%>,true,false,'0%','U','01')"></div>
													<div data-role="none"
														class="scaleSeparator2 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,<%=nId%>,true,false,'33%','M','02')"></div>
													<div data-role="none"
														class="scaleSeparator3 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,<%=nId%>,true,false,'66%','O','03')"></div>

													<div data-role="none"
														class="scaleSeparator4 scaleSeparatorTheme1"
														onclick="sliderControlClick(event,this,<%=nId%>,true,false,'98%','S','04')"></div>
												</div>
												<div style="position: relative; width: 100%; height: 20px">
													<div data-map = "<%=nId%>"  data-left = "0%"  style="position: absolute; left: 0.5%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,<%=nId%>,true,false,'0%','U','01')"><%=csResBundle.getString("allergy.unknown") %></div>
													<div data-map = "<%=nId%>"  data-left = "33%"  style="position: absolute; left: 31%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,<%=nId%>,true,false,'33%','M','02')"><%=csResBundle.getString("allergy.mild") %></div>
													<div data-map = "<%=nId%>"  data-left = "66%"  style="position: absolute; left: 63%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,<%=nId%>,true,false,'66%','O','03')"><%=csResBundle.getString("allergy.moderate") %></div>
													<div data-map = "<%=nId%>"  data-left = "98%"  style="position: absolute; right: 1%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,<%=nId%>,true,false,'98%','S','04')"><%=csResBundle.getString("allergy.severe") %></div>
												</div>
											</div>
											<script>
								  				$(document).ready(function() {
								  					$("#Round<%=nId%>").sliderControl(); 
												});
						  					</script>
											<input type="hidden" id="hdnScale<%=nId%>"
												name="hdnScale<%=nId%>" value="U" />
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="rowDivider"></div>
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="removeReactionSmallTd" valign="middle" align="right">
										<div class="allergyRowFonts">Site Of Reaction</div>
									</td>
									<td class="removeReactionTd" valign="middle" align="left">
										<div class="divEvent divEventTheme">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%">
												<tr style="width: 100%; height: 100%">
													<td style="width: 100%; height: 100%" valign="middle">
														<input type="text" data-role="none" class="txtContent"
														id="txtSite<%=nId%>" name="txtSite<%=nId%>" />
													</td>

													
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>

					</div>
					<!-- reaction items end -->
				</div> <!-- reaction parent -->
			</td>
			<td class="reactionSmallTd" valign="top" align="right">
				<div data-role="none" class="removeReaction removeReactionTheme"
					data-containerID="ReactionContainer<%=nId%>"
					onclick="showRemoveReactionBubble(this)" data-Id = "<%=nId%>"></div>
					
			</td>
		
		</tr>
	</table>
	<input type="hidden" name="reactionCode<%=nId%>" id="reactionCode<%=nId%>"
		id="reactionCode<%=nId%>" value="<%=oSfsJson.code%>" />
	<input type="hidden" name="reactionDesc<%=nId%>" id="reactionDesc<%=nId%>"
		id="reactionDesc<%=nId%>" value="<%=oSfsJson.desc%>" />
		
</div>
<% 
		nId++;
	}
}
%>

