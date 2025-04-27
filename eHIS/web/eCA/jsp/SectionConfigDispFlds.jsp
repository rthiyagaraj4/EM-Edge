<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.SectionConfigDispFldBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String qryMode = request.getParameter("qryMode")==null?"":request.getParameter("qryMode");
	String sec_hdg_code = request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String resCategory = request.getParameter("resCategory")==null?"":request.getParameter("resCategory");
	String pos1 = request.getParameter("pos1")==null?"":request.getParameter("pos1");
	String pos2 = request.getParameter("pos2")==null?"":request.getParameter("pos2");
	String strSql = request.getParameter("strSql")==null?"":request.getParameter("strSql");
	String resSubCategory = request.getParameter("resSubCategory")==null?"":request.getParameter("resSubCategory");
	String pageReload = request.getParameter("pageReload")==null?"":request.getParameter("pageReload");
	String pageReload1 = request.getParameter("pageReload1")==null?"":request.getParameter("pageReload1");
	String subCategory = "";
	String disabled = "disabled";
	LinkedList<String> orderSeq = null;
	LinkedList<String> orderSeqStr = null;

	String checked_A ="";
	String checked_NA ="checked";
	String display ="display:none";


	if(pageReload.equals("pageReload")||pageReload1.equals("pageReload"))
	{
		checked_A="checked";
		checked_NA="";
		display="display";
		disabled ="";

	}
	/*if(pageReload1.equals("pageReload"))
	{
		disabled ="";
		checked_A="checked";
		checked_NA="";
		display="display";
	} */

			
	int first, second;

	if(pos1 != null && pos2 != null)
	{
		first = Integer.parseInt(pos1);
		second = Integer.parseInt(pos2);
	}
	else
	{
		first  = 0;
		second = 0;
	}
	Connection con=null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
try
{
	eCA.SectionConfigDispFldBean sectionBean = (eCA.SectionConfigDispFldBean)session.getAttribute("SectionConfigDispFldBean");
	if(sectionBean == null)
	{
		sectionBean	= new eCA.SectionConfigDispFldBean();
		session.setAttribute("SectionConfigDispFldBean", sectionBean);
	}
	
	con = ConnectionManager.getConnection(request);
	
	
	if(qryMode != null && qryMode.equals("modify"))
	{
		String qryString = "SELECT FIELD_REF, RESULT_SUB_CATEGORY, ORDER_SEQ_NUM FROM CA_LINK_CATEG_SEC_DEF WHERE SEC_HDG_CODE=? AND RESULT_CATEGORY =? ORDER BY 3";
		try 
		{
			pst = con.prepareStatement(qryString);
			pst.setString(1, sec_hdg_code);
			pst.setString(2, resCategory);
			rs = pst.executeQuery();
			orderSeq = new LinkedList<String>();
			orderSeqStr = new LinkedList<String>();
			while(rs.next())
			{
				orderSeq.add(rs.getString(1));
				orderSeqStr.add(rs.getString(1));
				resSubCategory = rs.getString(2);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				rs.close();
			}
			if(pst != null)
			{
				pst.close();
			}
		}

		if(resCategory.equals("FEVT"))
		{
			try 
			{
				String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'RFRL','Referral','APPT','Appointments','FORD','Future Orders') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY=? AND RESULT_SUB_CATEGORY = ?";
				
				pst = con.prepareStatement(query);
				pst.setString(1, resCategory);
				pst.setString(2, resSubCategory);
				rs = pst.executeQuery();
				while(rs.next())
				{
					resSubCategory = rs.getString(1);
					subCategory = rs.getString(2);
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in SectionConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			finally
			{
				if(rs != null)
				{
					rs.close();
				}
				if(pst != null)
				{
					pst.close();
				}
			}


			String strQry = "SELECT  RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=?";

			sectionBean.setSectionConfig(strQry, resCategory, resSubCategory, first, second);
		}
		
		else if(resCategory.equals("MHD")) 	//Added for ML-MMOH-CRF-1759 Start
		{
			try 
			{
				String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'LMP','Last Menstrual Period (LMP)','USOD','Unsure of Date (USOD)') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY=? AND RESULT_SUB_CATEGORY = ?";
				pst = con.prepareStatement(query);
				pst.setString(1, resCategory);
				pst.setString(2, resSubCategory);
				rs = pst.executeQuery();
				while(rs.next())
				{
					resSubCategory = rs.getString(1);
					subCategory = rs.getString(2);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs != null)
				{
					rs.close();
				}
				if(pst != null)
				{
					pst.close();
				}
			}


			String strQry = "SELECT  RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=?";

			sectionBean.setSectionConfig(strQry, resCategory, resSubCategory, first, second);
		}//Added for ML-MMOH-CRF-1759 End
		
		
		else
		{
			sectionBean.setSectionConfig(resCategory, first, second);
		}
		if(orderSeq !=null && orderSeq.size() > 0)
		{
			sectionBean.setFieldOrder(orderSeq);
		}

		//added by Shaiju
		
		if(orderSeq.size()>0||pageReload.equals("pageReload"))
		{
			checked_A="checked";
			checked_NA="";
			display="display";

		}
		else
		{
			display="display:none";
		}

	}
	else if(strSql != null && !strSql.equals("") && resCategory.equals("FEVT"))
	{
		sectionBean.setSectionConfig(strSql, resCategory, resSubCategory, first, second);
	}
	else if(strSql != null && !strSql.equals("") && resCategory.equals("MHD"))//Added for ML-MMOH-CRF-1759 Start
	{
		sectionBean.setSectionConfig(strSql, resCategory, resSubCategory, first, second);
	}//Added for ML-MMOH-CRF-1759 End
	else if(!resCategory.equals("FEVT") ||  !resCategory.equals("MHD"))//Added resCategory.equals("MHD") for ML-MMOH-CRF-1759
	{
		sectionBean.setSectionConfig(resCategory, first, second);
	}
	LinkedList<String> dispCol = sectionBean.getDispColumn();
	LinkedList<String> filedRef = sectionBean.getFieldReffColumn();
	Map<String, ArrayList<String>> keyData = sectionBean.getSelectedData();
	Map<String, String> mandatory =	sectionBean.getMandatoryYN();
%>
<!-- Added by Arvind @ 08-12-08 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/Section.js'></script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formSectionConfigDispFlds" id="formSectionConfigDispFlds">
<table border=1 cellspacing=0 cellpadding=3 width='75%' align=center id='tbl' style="display" >
	<tr>
		<th class='columnheader'width='20%'  align="left" colspan='3'><fmt:message key="eCA.ConfigureDisplayFields.label" bundle="${ca_labels}"/>
		<input type='radio' id='radioApplicable' name='readioAppl' id='readioAppl' value='A' <%=checked_A%> onclick='checkApplicable(this);'/><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
		<input type='radio' id='radioApplicable' name='readioAppl' id='readioAppl' value='NA'<%=checked_NA%> onclick='checkApplicable(this);'/><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></th> 
	</tr>
		<%			
			

			if(resCategory.equalsIgnoreCase("FEVT"))
			{
				if(qryMode.equals("modify") && resSubCategory != null && !resSubCategory.equals(""))
				{
				%>
					<tr>
				<td  class=label colspan='3'> <fmt:message key="eCA.FutureEventType.label" bundle="${ca_labels}"/>&nbsp;&nbsp;
				<select id='listResultLinked' onchange='getSelected(this,"<%=resCategory%>");' <%=disabled%>>
				<option  value = '<%=resSubCategory%>' selected><%=subCategory%></option>
			 <%
				}
				else
				{
		 %>
			<tr>
				<td  class=label colspan='3'> <fmt:message key="eCA.FutureEventType.label" bundle="${ca_labels}"/>&nbsp;&nbsp;
				<select id='listResultLinked' onchange='getSelected(this,"<%=resCategory%>");' onmousewheel='return false;' <%=disabled%>>
				<option  selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		 <%

				try
				{
					String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'RFRL','Referral','APPT','Appointments','FORD','Future Orders') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY=?";
				
					pst = con.prepareStatement(query);
					pst.setString(1, resCategory);
					rs = pst.executeQuery();
					while(rs.next())
					{
						if(resSubCategory.equals(rs.getString(1)))
						{
							out.println("<option value ="+rs.getString(1)+" selected>"+rs.getString(2)+"</option>");					
						}
						else
						{
							out.println("<option value ="+rs.getString(1)+">"+rs.getString(2)+"</option>");						
						}

					}
				
				}
				catch(Exception e)
				{
					//out.println("Exception in SectionConfigDispFlds.jsp "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
				finally
				{
					if(rs != null)
					{
						rs.close();
					}
					if(pst != null)
					{
						pst.close();
					}
				}
			}
		%>
		</tr>
	<%
		if((resSubCategory != null && !resSubCategory.equals("")))
		{
	%>
	<tr style="text-align: left;">
		<th class='columnheader'width='12%'><fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/></th>
		<th class='columnheader' width='40%'><fmt:message key="eCA.DisplayFields.label" bundle="${ca_labels}"/></th>
		<th class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<%
		}
	%>
	</table>
<!--<table border=1 cellspacing=0 cellpadding=3 width='75%' align=center id='tblDisplayHrd' style="display" >-->
<table  class='grid' width='75%' align=center id='tblDisplayHrd' style="<%=display%>" >
	<tr>
		<%	
			int count = 1;
			if(resSubCategory != null && !resSubCategory.equals(""))
			{
				String tdClass = "gridData";
				
				if(dispCol != null && dispCol.size() > 0)
				for(int i = 0; i < dispCol.size(); i++)
				{
					/*if(count%2 ==0)
					{
						tdClass = "QRYEVEN";
					}
					else
					{
						tdClass = "QRYODD";
					}*/
					out.println("<tr id = 'numRows"+count+"'>");
					out.println("<td class='gridNumericData' width='12%'><a class='gridLink'  href='javascript:changeColor("+dispCol.lastIndexOf(dispCol.get(i))+",\""+resSubCategory+"\",\""+count+"\");'>"+count+"</a></td>");
					out.println("<td class='"+tdClass+"' width='40%'>"+dispCol.get(i)+"</td>");
				String check = mandatory.get(filedRef.get(i));
				if(qryMode.equals("modify"))
				{
					if(check.equals("Y"))
					{
						out.println("<td width='40%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");	
						%>
						<script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script>
					  <%
					}
					else if(orderSeqStr.contains(filedRef.get(i)))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
					%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>    <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
					<%
					}
					else
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");		
					
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");		
						}
					}
				}
				else
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");		
					}
					else if(pageReload.equals("pageReload"))
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
						}
							
				
					}
					else
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
						%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>     <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
						<%
					}
				}
					count++;
				}
		  }
		%>
		</select>
		</td>
	</tr>
	<%
		}

		else if(resCategory.equalsIgnoreCase("MHD"))//Added for ML-MMOH-CRF-1759 Start
			{
				if(qryMode.equals("modify") && resSubCategory != null && !resSubCategory.equals(""))
				{
				%>
					<tr>
				<td  class=label colspan='3'> <fmt:message key="Common.EventType.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				<select id='mhdListResultLinked' onchange='getSelected(this,"<%=resCategory%>");' <%=disabled%>>
				<option  value = '<%=resSubCategory%>' selected><%=subCategory%></option>
			 <%
				}
				else
				{
		 %>
			<tr>
				<td  class=label colspan='3'> <fmt:message key="Common.EventType.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				<select id='mhdListResultLinked' onchange='getSelected(this,"<%=resCategory%>");' onmousewheel='return false;' <%=disabled%>>
				<option  selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		 <%

				try
				{
					String query = "SELECT DISTINCT RESULT_SUB_CATEGORY ,DECODE(RESULT_SUB_CATEGORY,'LMP','Last Menstrual Period (LMP)','USOD','Unsure of Date (USOD)') res_sub_cat_desc FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY=? ORDER BY 1";
					pst = con.prepareStatement(query);
					pst.setString(1, resCategory);
					rs = pst.executeQuery();
					while(rs.next())
					{
						if(resSubCategory.equals(rs.getString(1)))
						{
							out.println("<option value ="+rs.getString(1)+" selected>"+rs.getString(2)+"</option>");					
						}
						else
						{
							out.println("<option value ="+rs.getString(1)+">"+rs.getString(2)+"</option>");						
						}

					}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(rs != null)
					{
						rs.close();
					}
					if(pst != null)
					{
						pst.close();
					}
				}
			}
		%>
		</tr>
	<%
		if((resSubCategory != null && !resSubCategory.equals("")))
		{
	%>
	<tr>
		<td class='columnheader'width='12%'><fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/></td>
		<td class='columnheader' width='40%'><fmt:message key="eCA.DisplayFields.label" bundle="${ca_labels}"/></td>
		<td class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>
	<%
		}
	%>
	</table>
<table  class='grid' width='75%' align=center id='tblDisplayHrd' style="<%=display%>" >
	<tr>
		<%	
			int count = 1;
			if(resSubCategory != null && !resSubCategory.equals(""))
			{
				String tdClass = "gridData";
				
				if(dispCol != null && dispCol.size() > 0)
				for(int i = 0; i < dispCol.size(); i++)
				{
					out.println("<tr id = 'numRows"+count+"'>");
					out.println("<td class='gridNumericData' width='12%'><a class='gridLink'  href='javascript:changeColor("+dispCol.lastIndexOf(dispCol.get(i))+",\""+resSubCategory+"\",\""+count+"\");'>"+count+"</a></td>");
					out.println("<td class='"+tdClass+"' width='40%'>"+dispCol.get(i)+"</td>");
				String check = mandatory.get(filedRef.get(i));
				if(qryMode.equals("modify"))
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");	
						%>
						<script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script>
					  <%
					}
					else if(orderSeqStr.contains(filedRef.get(i)))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
					%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>     <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
					<%
					}
					else
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");		
					
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");		
						}
					}
				}
				else
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");		
					}
					else if(pageReload.equals("pageReload"))
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
						}
							
				
					}
					else
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
						%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>   <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
						<%
					}
				}
					count++;
				}
		  }
		%>
		</select>
		</td>
	</tr>
	<%
		} //Added for ML-MMOH-CRF-1759 End
		
		else
		{
	%>
		<tr style="text-align: left;">
			<th class='columnheader'width='12%'><fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/></th>
			<th class='columnheader' width='40%'><fmt:message key="eCA.DisplayFields.label" bundle="${ca_labels}"/></th>
			<th class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
	</table>
<div style="display: flex; justify-content: center;">	
<table class='grid' width='75%' align=center id='tblDisplayGrd' style="<%=display%>" >

	<%
			String tdClass = "";
			int count = 1;

			if(dispCol != null && dispCol.size() > 0)
			for(int i = 0; i < dispCol.size(); i++)
			{
				if(count%2 ==0)
				{
					tdClass = "gridData";
				}
				else
				{
					tdClass = "gridData";
				}
				out.println("<tr  id = 'numRows"+count+"'>");
				out.println("<td  width='12%' class='gridNumericData'><a class='gridLink'   href='javascript:changeColor("+dispCol.lastIndexOf(dispCol.get(i))+",\""+resCategory+"\",\""+count+"\");'>"+count+"</a></td>");
				out.println("<td  width='40%' class='"+tdClass+"'>"+dispCol.get(i)+"</td>");
				String check = mandatory.get(filedRef.get(i));
				if(qryMode.equals("modify"))
				{
					if(check.equals("Y"))
					{
						out.println("<td  width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");	
						%>
						<script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script>
					  <%
					}
					else if(orderSeqStr.contains(filedRef.get(i)))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
					%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>   <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
					<%
					}
					else if(pageReload.equals("pageReload"))
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
						}
					}
					else if(orderSeqStr.size() == 0)
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");		
						%>
						<script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script>
						<%
					}
					else
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
					}
				}
				else 
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");		
					}
					else if(pageReload.equals("pageReload"))
					{
						if(keyData.containsKey((filedRef.get(i))))
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						}
						else
						{
							out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
						}
							
				
					}
					else
					{
						out.println("<td width='20%' class='"+tdClass+"'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");		
						sectionBean.addSelected(filedRef.get(i), Integer.toString(count)); //Added for 76312 - CA-Common-CA Code Setup-Section
						%>
						<%-- <script>
							parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
						</script> --%>    <!-- Commended for 76312 - CA-Common-CA Code Setup-Section  -->
					<%
					}
				}
				count++;
			}
		}
	%>
</table>
	<input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='qryMode' id='qryMode' value='<%=qryMode%>'>
	<input type='hidden' name='resCategoryKey' id='resCategoryKey' value='<%=resCategory%>'>
</form>
</body>
<%}
catch(Exception e)
{
	//out.println("Exception in SectionConfigDispFlds.jsp -- insert--"+e.toString());//COMMON-ICN-0181
	
	e.printStackTrace();
}
finally
{
	if(con != null)
	{
		ConnectionManager.returnConnection(con,request);
	}
}
%>

