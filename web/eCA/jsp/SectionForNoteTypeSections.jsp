<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	//session.removeAttribute("noteBean");
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SectionForNoteTypeRecBean noteBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("noteBean","eCA.SectionForNoteTypeRecBean",session);
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedSectionsForType.label" bundle="${ca_labels}"/></title>
		<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			//String interValue = request.getParameter("interValue") == null ? "" : request.getParameter("interValue");
			//out.println("<script>alert('interValue="+interValue+"')</script>");
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			int cnt = 0;
			String chk="";
			String disable="disabled";
			int count=0;
			
		%>
		<!-- <modifeid by Arvind @06-12-2008> -->

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/SectionForNoteType.js'></script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeSectionsForm' id = 'secForNoteTypeSectionsForm' action='../../servlet/eCA.SectionForNoteTypeServlet' method='post' target='messageFrame'>
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADER' colspan='4' align="left"><fmt:message key="eCA.AttachedSections.label" bundle="${ca_labels}"/></td>					
				</tr>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></td>					
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
				<%
					if(!mode.equals("modify"))
					{
						Connection con = null;
						PreparedStatement pstmtNoteSections = null;
						ResultSet resNoteSections = null;
						
						String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

						String sec_heading_code = "";
						String sec_heading_desc = "";
						String note_seq_num = "";
						String chief_complaint_sec_type="";
						String chief_complaint_sec_yn = "";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;
						
						
						

						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec = "SELECT b.note_type_desc note_type_desc,c.content_type, a.sec_hdg_code sec_hdg_code, c.sec_hdg_desc || NVL2 (c.sec_hdr_meta_desc, ' - ' || c.sec_hdr_meta_desc, NULL) sec_hdg_desc, a.note_sec_seq_num note_seq_num, nvl(chief_complaint_sec_yn,'N') chief_complaint_sec_yn , content_type FROM ca_note_section a, ca_note_type b, ca_section_hdg c where a.note_type = b.NOTE_TYPE and a.sec_hdg_code = c.SEC_HDG_CODE and a.note_type = ? order by  a.note_sec_seq_num";
							pstmtNoteSections = con.prepareStatement(sqlNoteSec);
							pstmtNoteSections.setString(1,note_type);
							resNoteSections = pstmtNoteSections.executeQuery();
							classValue = "gridData";
							while(resNoteSections.next())
							{
								
								sec_heading_code = resNoteSections.getString("sec_hdg_code");
								sec_heading_desc = resNoteSections.getString("sec_hdg_desc");
								note_seq_num = resNoteSections.getString("note_seq_num");
								chief_complaint_sec_yn = resNoteSections.getString("chief_complaint_sec_yn");
								chief_complaint_sec_type=resNoteSections.getString("CONTENT_TYPE");

								//out.println("chief_complaint_sec_yn ---->" +chief_complaint_sec_yn);

								if(chief_complaint_sec_type.equals("T")||
									chief_complaint_sec_type.equals("S"))
								{
									
									disable="disabled";
									
								}
								else
									disable="";
								
								if(chief_complaint_sec_yn.equals("Y"))
								{
									
								  	chk="checked";
									count++;
									
									
								}
								else
								{
									chk="";	
								}

								/*if(cnt%2 == 0)
									classValue = "gridData";
								else
									classValue = "gridData";*/

								out.println("<tr align='left' id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+sec_heading_code+"' name = 'sec_heading_code"+cnt+"'> </td>");						
								out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td class='gridNumericData'   align='right'> <a class='gridLink'  href=\"javascript:changeColor('"+cnt+"','"+srlNo+"')\"> "+srlNo+" </a></td>");
								out.println("<td class='gridData'  > "+sec_heading_desc+" </td>");
								out.println("<td class='gridData'   align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
								
								out.println("<td class='gridData'   align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+sec_heading_code+"\",\""+sec_heading_desc+"\",\""+srlNo+"\",\""+cnt+"\")`> </td>");
								
								out.println("<td class='gridData'   align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick=\"removeRecord(this,'"+sec_heading_code+"','"+cnt+"')\"> </td>");
								out.println("</tr>");							
								//out.println("chief_complaint_sec_yn"+chief_complaint_sec_yn);
								mapValue = sec_heading_desc + "~" + srlNo + "~" + chief_complaint_sec_type+ "~" + chief_complaint_sec_yn;			
								noteBean.addRecords(sec_heading_code,mapValue);
								noteBean.addToList(cnt,sec_heading_code);
								cnt++;
								srlNo++;
							}
							
							out.println("<tr style='display:none' id='extraRow'><td align=\"right\" id='extraTD'><a class='gridLink'  href=\"javaScript:changeColor('"+cnt+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
							putObjectInBean("noteBean",noteBean,session);


							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();
						}
						catch(Exception e)
						{
						//	out.println("Exception in try of SectionForNoteTypeSections.jsp"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
						finally
						{
							if(con != null) ConnectionManager.returnConnection(con,request);
						}
				}	
			else if(mode.equals("modify"))
			{
				
				String keyVal = "";
				String mapVal = "";
				String chief_complaint = "";
				String heading_seq_num = "";
				String heading_desc = "";
				StringTokenizer strCodeToken = null;
				String chief_complaint_sect_yn="";
				//StringTokenizer strSeqToken = null;
				int i=0;
				int tempInt = i +1;

				int positionOne = Integer.parseInt(firstPosition);
				positionOne = positionOne - 1;
				int positionTwo = Integer.parseInt(secondPosition);				
				positionTwo = positionTwo - 1;
				int totalRows = Integer.parseInt(noOfRows);
				String codeList = "";
				


				try
				{	
					String check="";
					if(!flag_for_list.equals("false"))
					{
						
						if(totalRows < positionTwo)
							positionTwo = positionTwo -1;
						else
							positionTwo = positionTwo;

						int k = 0;
						ArrayList list = noteBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								noteBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							noteBean.removeElement(positionOne);
						}
						else
						{
							noteBean.removeElement(positionOne+1);
						}
						putObjectInBean("noteBean",noteBean,session);
					}
					
					
					HashMap recValues = noteBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = noteBean.retrieveArrayList();
					for(i=0; i<indexList.size(); i++)
					{
						tempInt = i +1;
						keyVal = (String)indexList.get(i);
						mapVal = (String)recValues.get(keyVal);
						strCodeToken = new StringTokenizer(mapVal,"~");
						while(strCodeToken.hasMoreTokens())
						{
							heading_desc = strCodeToken.nextToken();
							heading_seq_num = strCodeToken.nextToken();
							chief_complaint = strCodeToken.nextToken();
							chief_complaint_sect_yn=strCodeToken.nextToken();
							

							//if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
							if(chief_complaint.equals("Y")||chief_complaint.equals("S")||chief_complaint.equals("T"))
                            {
								//check="";
								
								disable="disabled";
							}
							else 
                            {
								//check="";
								disable="";
							}
							if(chief_complaint_sect_yn.equals("Y"))

							{
								if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
								{
							
							       check="";
								}
								else 
								{
								check="checked";
								count++;
										
								}
							}
							else
								check="";
							

							if(heading_seq_num.equals(" "))
								heading_seq_num = "";
							else
								heading_seq_num = heading_seq_num;

							/*if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";*/
							out.println("<tr align='left' id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='sec_heading_code"+i+"' id='sec_heading_code"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value='"+chief_complaint+"' name='chief_complaint_yn"+i+"' id='chief_complaint_yn"+i+"'  </td>");
							out.println("<td class='gridNumericData'   align='right'> <a class='gridLink'  href=\"javascript:changeColor('"+i+"','"+tempInt+"')\"> "+tempInt+" </a></td>");
							out.println("<td class='gridData'   > "+heading_desc+" </td>");
							out.println("<td class='gridData'   align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
				out.println("<td class='gridData'   align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick='addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\")'> </td>");
							
							out.println("<td class='gridData'   align='center'> <input type='checkbox' checked onclick=\"removeRecord(this,'"+keyVal+"','"+i+"')\"> </td>");
							out.println("</tr>");							
						}
					}
					tempInt++;
					out.println("<tr style='display:none' id='extraRow'><td align=\"right\"><a class='gridLink'  href=\"javaScript:changeColor('"+i+"','"+tempInt+"')\">"+tempInt+"</td><td></td><td></td></tr>");
					cnt = indexList.size();
				}
				catch(Exception e)
				{
				//	out.println("Exception in try of SectionForNoteTypeSections - mode : modify" +e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
			}

			%>
			</table>
			<input type='hidden' name='note_type' id='note_type' value=''>
			<input type='hidden' name='conc_string' id='conc_string' value=''>
			<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
			<input type='hidden' name='firstPos' id='firstPos' value=''>
			<input type='hidden' name='secPos' id='secPos' value=''>
			<input type='hidden' name='flag' id='flag' value="true">
			<input type='hidden' name='count' id='count' value=<%=count%>>
		</form>
		<script>
			parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = true;
		</script>
	</body>
</html>

