<!DOCTYPE html>
<%@ page import = "java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String bannerCateg = request.getParameter("bannerCateg") == null ? "P" : request.getParameter("bannerCateg");
		String bannerRef = request.getParameter("bannerRef") == null ? "U01" : request.getParameter("bannerRef");
		String loadFirstTime = request.getParameter("loadFirstTime") == null ? "No" : request.getParameter("loadFirstTime");

		eCA.PatientBannerGroupLine patBannerGrpBean = null;

		patBannerGrpBean = (eCA.PatientBannerGroupLine)getObjectFromBean("patBannerGrpBean","eCA.PatientBannerGroupLine",session);
		if(loadFirstTime.equals("Yes"))
			patBannerGrpBean.clearBean();
    %>

	<%
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		String elementRef = "";
		String dispLine = "";
		String prevDispLine = "";
		String toolTip = "";
		String dispText = "";
		String elementDesc = "";
		String configYN = "N";
		String maxLength = "";
		String dispOrder = "";
		String dispLength = "";
		String defaultSelYN = "N";
		String defSel = "";
		String configYes = "";
		String configNo = "";
		String elementRefDef = "";
		String configReadOnly = "";
		String onblurFunc = "";
		String elmtRefForBean = "";
		String iconYN = "N";
		String imageName = "";
		String numOfSpaces = "0";
		String cntDtlRecs = "0";
		String maxOrderForLine1 = "0";
		String maxOrderForLine2 = "0";
		int i = 1;
		int cntLine1 = 0;
		int cntLine2 = 0;


		String sqlStr = "select a.ELMT_REF element_ref, a.display_length display_len, a.line_ref display_line, 	a.disp_ord display_order, a.tool_tip_text tool_tip,	a.prefix_label_text display_text, a.NUM_OF_SPACES no_of_spaces, b.ELMT_DESC element_desc, b.MAX_LENGTH 	max_length,b. DISP_LENGTH_CONFIG_YN config, b.DFLT_DISP_LENGTH default_disp_length, b.DFLT_LINE_REF 	default_disp_line,b.DFLT_DISP_ORD default_disp_order, 	b.DFLT_TOOL_TIP_TEXT 	default_tool_tip, b.DFLT_SEL_YN def_sel_yn, b.PREFIX_LABEL_TYPE prefix_label_type,b.ELMT_REF element_ref_def, b.ICON_BASED_YN icon_yn, b.IMAGE_NAME img_name from mp_pat_banner_dtl a, mp_pat_banner_elmt b	where a.BANNER_REF(+) = ? and a.BANNER_CATEG(+) = ? and a.ELMT_REF (+) = b.ELMT_REF and b.APPL_CATEG IN (?,'B') ORDER BY decode(b.ELMT_REF,'PAT_PHOTO',1,2),NVL2(a.line_ref,a.line_ref,b.dflt_line_ref), a.disp_ord, b.DFLT_DISP_ORD";

		String sqlCountDtl = "select count(*) from mp_pat_banner_dtl where BANNER_REF = ? and BANNER_CATEG in (?,'B')";
		
		try
		{
			con = ConnectionManager.getConnection(request);
			
			ps = con.prepareStatement(sqlCountDtl);
			ps.setString(1,bannerRef);
			ps.setString(2,bannerCateg);

			res = ps.executeQuery();
			while(res.next())
			{
				cntDtlRecs = res.getString(1) == null ? "0" : res.getString(1);
			}

			if(res != null) res.close();
			if(ps != null) ps.close();
		%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script src='../../eCA/js/PatEncBanner.js' language='javascript'></script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<form name='patEncBannerDtlForm' id='patEncBannerDtlForm'>
			<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
				<tr>
					<td align='right' width='80%'><input type='button' class='button' name='defaultBannerView' id='defaultBannerView' onclick="loadDefault()" value="<fmt:message key='eCA.ViewDefaultBanner.label' bundle='${ca_labels}'/>"></td>
					<td align='right'><input type='button' class='button' name='Preview' id='Preview' onclick="buildHTMLForPreviewBanner()" value="<fmt:message key='eCA.PreviewBanner.label' bundle='${ca_labels}'/>"></td>
				<tr>
			</table>

			<table  align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>
				<tr>
					<th colspan='5'><fmt:message key='eCA.Values.label' bundle='${ca_labels}'/>					
					</th>
					<th colspan='3'><fmt:message key='eCA.Legend.label' bundle='${ca_labels}'/>					
					</th>
				</tr>
				<tr>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="Common.defaultSelect.label" bundle='${common_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.DisplayOrder.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.FieldName.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.ActualLength.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.DisplayLenght.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.SpaceBeforeText.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.DisplayText.label" bundle='${ca_labels}'/></td>
					<td class='CAFLOWSHEETLEVEL1'><fmt:message key="eCA.ToolTipText.label" bundle='${ca_labels}'/></td>
				</tr>
				<%
					if(loadFirstTime.equals("Yes"))
					{
						ps = con.prepareStatement(sqlStr);
						ps.setString(1,bannerRef);
						ps.setString(2,bannerCateg);
						ps.setString(3,bannerCateg);
						res = ps.executeQuery();

						while(res.next())
						{
							elementRef = res.getString("element_ref") == null ? "" : res.getString("element_ref");

							if(Integer.parseInt(cntDtlRecs) == 0)
								defaultSelYN = res.getString("def_sel_yn") == null ? "N" : res.getString("def_sel_yn");
							
							if(!elementRef.equals(""))
							{
								dispLength = res.getString("display_len") == null ? "0" : res.getString("display_len");
								dispLine = res.getString("display_line") == null ? "" : res.getString("display_line");
								//dispOrder = res.getString("display_order") == null ? "0" : res.getString("display_order");
								toolTip = res.getString("tool_tip") == null ? "" : res.getString("tool_tip");
								dispText = res.getString("display_text") == null ? "" : res.getString("display_text");
								if(Integer.parseInt(cntDtlRecs) > 0)
									defaultSelYN = "Y";									
							}
							else
							{
								dispLength = res.getString("default_disp_length") == null ? "0" : res.getString("default_disp_length");
								dispLine = res.getString("default_disp_line") == null ? "" : res.getString("default_disp_line");
								//dispOrder = res.getString("default_disp_order") == null ? "0" : res.getString("default_disp_order");
								toolTip = res.getString("default_tool_tip") == null ? "" : res.getString("default_tool_tip");
								dispText = res.getString("display_text") == null ? "" : res.getString("display_text");
								if(Integer.parseInt(cntDtlRecs) > 0)
									defaultSelYN = "N";
							}
							elementDesc = res.getString("element_desc") == null ? "" : res.getString("element_desc");
							maxLength = res.getString("max_length") == null ? "0" : res.getString("max_length");
							configYN = res.getString("config") == null ? "N" : res.getString("config");
							elementRefDef = res.getString("element_ref_def") == null ? "" : res.getString("element_ref_def");
							iconYN = res.getString("icon_yn") == null ? "N" : res.getString("icon_yn");
							numOfSpaces = res.getString("no_of_spaces") == null ? "0" : res.getString("no_of_spaces");
							imageName = res.getString("img_name") == null ? "abc.gif" : res.getString("img_name");

							if(!prevDispLine.equals(dispLine))
							{
								i = 1;
							}

							dispOrder = Integer.toString(i);

							if(elementRef.equals("")) elmtRefForBean = elementRefDef;
							else if(!elementRef.equals("")) elmtRefForBean = elementRef;
							
							if(defaultSelYN.equals("Y"))
								defSel = "checked";
							else 
								defSel = " ";

							if(configYN.equals("Y"))
							{
								//toolTip = elementDesc;
								//dispText = elementDesc;
								configReadOnly = "";
								onblurFunc = "onblur = \"addToBean(this,'"+dispLine+"','"+dispOrder+"')\" ";
							}
							else
							{
								configYes = "";
								configNo = "selected";
								configReadOnly = " readOnly ";
								onblurFunc = "";
							}
							
							if(!prevDispLine.equals(dispLine))
							{
								if(!prevDispLine.equals(""))
								{
									out.println("<tr style='display:none' id='hiddenTRForLine1'>");
									out.println("<td>&nbsp;</td>");
									out.println("<td><a href=\"javascript:changeDispOrder('"+prevDispLine+"')\">"+(Integer.parseInt(maxOrderForLine1)+1)+"</a></td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("</tr>");
								}
								out.println("<tr>");
								out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+dispLine+" </td>");
								out.println("</tr>");								
							}
							else
							{
								if(dispLine.equals("1")) maxOrderForLine1 = dispOrder;
								if(dispLine.equals("2")) maxOrderForLine2 = dispOrder;
							}

							out.println("<tr id='id"+dispLine+"ForTr"+dispOrder+"'>");
							out.println("<td><input type='checkbox' name='defSelect"+i+"' id='defSelect"+i+"' id='def"+dispLine+"Sel"+dispOrder+"' "+defSel+" onclick='chkUnchkSel(\""+dispLine+"\",\""+dispOrder+"\",this)'></td>");
							if(dispOrder.equals("1") && dispLine.equals("1"))
								out.println("<td id='disp"+dispLine+"Order"+dispOrder+"'>"+dispOrder+"</td>");
							else
							out.println("<td id='disp"+dispLine+"Order"+dispOrder+"'><a href=\"javascript:changeColor('"+dispLine+"','"+dispOrder+"')\" >"+dispOrder+"</a></td>");

							if(dispOrder.equals("1") && dispLine.equals("1"))
								out.println("<td id='element"+dispLine+"Desc"+dispOrder+"'>"+elementDesc+"</td>");
							else
								out.println("<td onclick='javascript:showPopupForLines(\""+dispLine+"\",\""+dispOrder+"\",this)' id='element"+dispLine+"Desc"+dispOrder+"'><a href='javascript:'>"+elementDesc+"</a></td>");
							if(iconYN.equals("N"))
							{
								out.println("<td id='max"+dispLine+"Length"+dispOrder+"'>"+maxLength+"</td>");
								out.println("<td><input type='text' maxlength='3' size='2' id='disp"+dispLine+"Length"+dispOrder+"' value='"+dispLength+"' "+configReadOnly+" "+onblurFunc+" onkeypress=\"return allowNumbers(event)\"></td>");
							}
							else if(iconYN.equals("Y"))
							{
								out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
								maxLength = " ";
								dispLength = " ";
							}
							out.println("<td><input type='text' size='4' maxLength='2' id='num"+dispLine+"Spaces"+dispOrder+"' "+onblurFunc+" value='"+numOfSpaces+"' onblur = \"addToBean(this,'"+dispLine+"','"+dispOrder+"')\" onkeypress=\"return allowNumbers(event)\"></td>");
							out.println("<td><input type='text' value='"+dispText+"' name='dispText"+i+"' id='dispText"+i+"' id='disp"+dispLine+"Text"+dispOrder+"' "+onblurFunc+" "+configReadOnly+"></td>");
							out.println("<td><input type='text' value='"+toolTip+"' name='toolTip"+i+"' id='toolTip"+i+"' id='toolTip"+dispLine+"Text"+dispOrder+"' "+onblurFunc+" "+configReadOnly+"></td>");
							out.println("</tr>");
							out.println("<input type='hidden' name='dispOrder"+i+"' id='dispOrder"+i+"' value='"+dispOrder+"'>");
							out.println("<input type='hidden' name='dispLength"+i+"' id='dispLength"+i+"' value='"+dispLength+"'>");
							out.println("<input type='hidden' name='config"+dispLine+"Val"+dispOrder+"' id='config"+dispLine+"Val"+dispOrder+"' value='"+configYN+"'>");
							out.println("<input type='hidden' name='elmt"+dispLine+"Ref"+dispOrder+"' id='elmt"+dispLine+"Ref"+dispOrder+"' value='"+elmtRefForBean+"'>");
							out.println("<input type='hidden' name='icon"+dispLine+"YN"+dispOrder+"' id='icon"+dispLine+"YN"+dispOrder+"' value='"+iconYN+"'>");
							out.println("<input type='hidden' name='image"+dispLine+"Name"+dispOrder+"' id='image"+dispLine+"Name"+dispOrder+"' value='"+imageName+"'>");
							i++;
							prevDispLine = dispLine;
							
							if(toolTip.equals("")) toolTip = " ";
							if(dispText.equals("")) dispText = " ";
							if(dispLine.equals("1"))
							{
								patBannerGrpBean.addRecordstoLine1(dispLine+"`"+defSel+"`"+dispOrder+"`"+elementDesc+"`"+maxLength+"`"+dispLength+"`"+numOfSpaces+"`"+dispText+"`"+toolTip+"`"+configYN+"`"+elmtRefForBean+"`"+iconYN+"`"+imageName);
								cntLine1++;
							}
							else if(dispLine.equals("2"))
							{
								patBannerGrpBean.addRecordstoLine2(dispLine+"`"+defSel+"`"+dispOrder+"`"+elementDesc+"`"+maxLength+"`"+dispLength+"`"+numOfSpaces+"`"+dispText+"`"+toolTip+"`"+configYN+"`"+elmtRefForBean+"`"+iconYN+"`"+imageName);
								cntLine2++;
							}							
						}//end of while
						putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);

						out.println("<tr style='display:none' id='hiddenTRForLine2'>");
						out.println("<td>&nbsp;</td>");
						out.println("<td><a href=\"javascript:changeDispOrder('"+dispLine+"')\">"+(Integer.parseInt(maxOrderForLine2)+1)+"</a></td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("</tr>");
					}//end of if loadFirstTime					
					else
					{
						String displayLineNum = "";
						String defaultSelect = "";
						String displayOrderNum = "";
						String elementDescription = "";
						String actualLength = "";
						String displayLength = "";
						String displayText = "";
						String toolTipText = "";
						String arrValues = "";
						String configValue = "";
						prevDispLine = "";

						try
						{						
							ArrayList list1 = patBannerGrpBean.returnList1();
							ArrayList list2 = patBannerGrpBean.returnList2();

							StringTokenizer strTok = null;

							for(int j=0;j<list1.size();j++)
							{
								arrValues = (String) list1.get(j);
								strTok = new StringTokenizer(arrValues,"`");
								while(strTok.hasMoreTokens())
								{
									displayLineNum = (String)strTok.nextToken();
									defaultSelect = (String)strTok.nextToken();
									displayOrderNum = (String)strTok.nextToken();
									elementDescription = (String)strTok.nextToken();
									actualLength = (String)strTok.nextToken(); 
									displayLength = (String)strTok.nextToken();
									numOfSpaces = (String)strTok.nextToken();
									displayText = (String)strTok.nextToken();
									toolTipText = (String)strTok.nextToken();
									configValue = (String)strTok.nextToken();
									elmtRefForBean = (String)strTok.nextToken();
									iconYN = (String)strTok.nextToken();
									imageName = (String)strTok.nextToken();

									if(configValue.equals("Y"))
									{
										configReadOnly = "";
										onblurFunc = "onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\" ";
									}
									else if(configValue.equals("N"))
									{
										configReadOnly = " readOnly ";
										onblurFunc = "";
									}

									if(!prevDispLine.equals(displayLineNum))
									{
										out.println("<tr>");
										out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+displayLineNum+" </td>");
										out.println("</tr>");
									}
									else
									{
										if(displayLineNum.equals("1")) maxOrderForLine1 = displayOrderNum;
										if(displayLineNum.equals("2")) maxOrderForLine2 = displayOrderNum;
									}


									if(defaultSelect.equals("Y") || defaultSelect.equals("checked")) defSel = "checked";
									else defSel = "";

									out.println("<tr  id='id"+displayLineNum+"ForTr"+displayOrderNum+"'>");
									out.println("<td><input type='checkbox' id='def"+displayLineNum+"Sel"+displayOrderNum+"' "+defSel+" onclick='chkUnchkSel(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)'></td>");
									if(displayOrderNum.equals("1"))
										out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'>"+displayOrderNum+"</td>");
									else
										out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'><a href=\"javascript:changeColor('"+displayLineNum+"','"+displayOrderNum+"')\" >"+displayOrderNum+"</a></td>");
									if(displayOrderNum.equals("1"))
										out.println("<td id='element"+displayLineNum+"Desc"+displayOrderNum+"'>"+elementDescription+"</td>");
									else
										out.println("<td onclick='javascript:showPopupForLines(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)' id='element"+displayLineNum+"Desc"+displayOrderNum+"'><a href='javascript:'>"+elementDescription+"</a></td>");
									if(iconYN.equals("N"))
									{
										out.println("<td id='max"+displayLineNum+"Length"+displayOrderNum+"'>"+actualLength+"</td>");
										out.println("<td><input type='text' maxlength='3' size='2' id='disp"+displayLineNum+"Length"+displayOrderNum+"' value='"+displayLength+"' "+configReadOnly+" "+onblurFunc+" "+configReadOnly+" onkeypress=\"return allowNumbers(event)\"></td>");
									}
									else
									{
										out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
										actualLength = " ";
										displayLength = " ";
									}
									out.println("<td><input type='text' size='4' maxLength='2' id='num"+displayLineNum+"Spaces"+displayOrderNum+"' value='"+numOfSpaces+"' "+onblurFunc+" onkeypress=\"return allowNumbers(event)\" onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\"></td>");
									out.println("<td><input type='text' value='"+displayText+"' id='disp"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("<td><input type='text' value='"+toolTipText+"' id='toolTip"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("</tr>");
									out.println("<input type='hidden' name='config"+displayLineNum+"Val"+displayOrderNum+"' id='config"+displayLineNum+"Val"+displayOrderNum+"' value='"+configValue+"'>");
									out.println("<input type='hidden' name='elmt"+displayLineNum+"Ref"+displayOrderNum+"' id='elmt"+displayLineNum+"Ref"+displayOrderNum+"' value='"+elmtRefForBean+"'>");
									out.println("<input type='hidden' name='icon"+displayLineNum+"YN"+displayOrderNum+"' id='icon"+displayLineNum+"YN"+displayOrderNum+"' value='"+iconYN+"'>");
									out.println("<input type='hidden' name='image"+displayLineNum+"Name"+displayOrderNum+"' id='image"+displayLineNum+"Name"+displayOrderNum+"' value='"+imageName+"'>");
								}//end of while
								prevDispLine = displayLineNum;
								cntLine1++;
							}//end of for
							out.println("<tr style='display:none' id='hiddenTRForLine1'>");
							out.println("<td>&nbsp;</td>");
							out.println("<td><a href=\"javascript:changeDispOrder('"+displayLineNum+"')\">"+(Integer.parseInt(maxOrderForLine1)+1)+"</a></td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("</tr>");

							for(int j=0;j<list2.size();j++)
							{
								arrValues = (String) list2.get(j);
								strTok = new StringTokenizer(arrValues,"`");
								while(strTok.hasMoreTokens())
								{
									displayLineNum = (String)strTok.nextToken();
									defaultSelect = (String)strTok.nextToken();
									displayOrderNum = (String)strTok.nextToken();
									elementDescription = (String)strTok.nextToken();
									actualLength = (String)strTok.nextToken(); 
									displayLength = (String)strTok.nextToken();
									numOfSpaces = (String)strTok.nextToken();
									displayText = (String)strTok.nextToken();
									toolTipText = (String)strTok.nextToken();
									configValue = (String)strTok.nextToken();
									elmtRefForBean = (String)strTok.nextToken();
									iconYN = (String)strTok.nextToken();
									imageName = (String)strTok.nextToken();

									if(configValue.equals("Y"))
									{
										configReadOnly = "";
										onblurFunc = "onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\" ";
									}
									else if(configValue.equals("N"))
									{
										configReadOnly = " readOnly ";
										onblurFunc = "";
									}


									if(!prevDispLine.equals(displayLineNum))
									{
										out.println("<tr>");
										out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+displayLineNum+" </td>");
										out.println("</tr>");
									}
									else
									{
										if(displayLineNum.equals("1")) maxOrderForLine1 = displayOrderNum;
										if(displayLineNum.equals("2")) maxOrderForLine2 = displayOrderNum;
									}

									if(defaultSelect.equals("Y") || defaultSelect.equals("checked")) defSel = "checked";
									else defSel = "";

									out.println("<tr id='id"+displayLineNum+"ForTr"+displayOrderNum+"'>");
									out.println("<td><input type='checkbox' id='def"+displayLineNum+"Sel"+displayOrderNum+"' "+defSel+" onclick='chkUnchkSel(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)'></td>");
									out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'><a href=\"javascript:changeColor('"+displayLineNum+"','"+displayOrderNum+"')\" >"+displayOrderNum+"</a></td>");
									out.println("<td onclick='javascript:showPopupForLines(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)' id='element"+displayLineNum+"Desc"+displayOrderNum+"'><a href='javascript:'>"+elementDescription+"</a></td>");
									if(iconYN.equals("N"))
									{
										out.println("<td id='max"+displayLineNum+"Length"+displayOrderNum+"'>"+actualLength+"</td>");
										out.println("<td><input type='text' maxlength='3' size='2' id='disp"+displayLineNum+"Length"+displayOrderNum+"' value='"+displayLength+"' "+configReadOnly+" "+onblurFunc+" "+configReadOnly+" onkeypress=\"return allowNumbers(event)\"></td>");
									}
									else
									{
										out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
										actualLength = " ";
										displayLength = " ";
									}
									out.println("<td><input type='text' size='4' maxLength='2' id='num"+displayLineNum+"Spaces"+displayOrderNum+"' value='"+numOfSpaces+"' "+onblurFunc+" onkeypress=\"return allowNumbers(event)\" onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\"></td>");
									out.println("<td><input type='text' value='"+displayText+"' id='disp"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("<td><input type='text' value='"+toolTipText+"' id='toolTip"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("</tr>");
									out.println("<input type='hidden' name='config"+displayLineNum+"Val"+displayOrderNum+"' id='config"+displayLineNum+"Val"+displayOrderNum+"' value='"+configValue+"'>");
									out.println("<input type='hidden' name='elmt"+displayLineNum+"Ref"+displayOrderNum+"' id='elmt"+displayLineNum+"Ref"+displayOrderNum+"' value='"+elmtRefForBean+"'>");
									out.println("<input type='hidden' name='icon"+displayLineNum+"YN"+displayOrderNum+"' id='icon"+displayLineNum+"YN"+displayOrderNum+"' value='"+iconYN+"'>");
									out.println("<input type='hidden' name='image"+displayLineNum+"Name"+displayOrderNum+"' id='image"+displayLineNum+"Name"+displayOrderNum+"' value='"+imageName+"'>");
								}//end of while
								prevDispLine = displayLineNum;
								cntLine2++;
							}
							out.println("<tr style='display:none' id='hiddenTRForLine2'>");
							out.println("<td>&nbsp;</td>");
							out.println("<td><a href=\"javascript:changeDispOrder('"+displayLineNum+"')\">"+(Integer.parseInt(maxOrderForLine2)+1)+"</a></td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("</tr>");
						}//end of try
						catch(Exception ee)
						{
							//out.println("Exception in bean part of PatEncBannerDetails.jsp --"+ee.toString());//common-icn-0181
							ee.printStackTrace();
						}
					}//end of if loadFirstTime
				}//end of try
				catch(Exception e)
				{
					e.printStackTrace();
					
					//out.println("Exception in try of PatEncBannerDetails.jsp --"+e.toString());//common-icn-0181
				}//end of catch
				finally
				{
					if(res != null) res.close();
					if(ps != null) ps.close();
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
				
			%>
		</table>
		<input type='hidden' name='numOfRecs' id='numOfRecs' value='<%=i%>'>
		<input type='hidden' name='bannerCateg' id='bannerCateg' value='<%=bannerCateg%>'>
		<input type='hidden' name='bannerRef' id='bannerRef' value='<%=bannerRef%>'>
		<input type='hidden' name='bannerContent' id='bannerContent' value=''>
		<input type='hidden' name='maxOrderForLine1' id='maxOrderForLine1' value='<%=maxOrderForLine1%>'>
		<input type='hidden' name='maxOrderForLine2' id='maxOrderForLine2' value='<%=maxOrderForLine2%>'>
		<input type='hidden' name='firstClick' id='firstClick' value=''>
		<input type='hidden' name='firstDispOrderVal' id='firstDispOrderVal' value=''>
		<input type='hidden' name='cntLine1' id='cntLine1' value='<%=cntLine1%>'>
		<input type='hidden' name='cntLine2' id='cntLine2' value='<%=cntLine2%>'>
		<input type='hidden' name='htmlContent' id='htmlContent' value=''>
		<div id='linkLine' style='position:absolute; visibility:hidden;overflow:overflow'></div>
	</form>
</html>

