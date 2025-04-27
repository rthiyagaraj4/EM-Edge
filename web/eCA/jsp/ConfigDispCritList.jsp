<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.SectionConfigDispFldBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

	String resCategory = request.getParameter("resCategory")==null?"":request.getParameter("resCategory");
	String resSubCategory = request.getParameter("resSubCategory")==null?"":request.getParameter("resSubCategory");
	String configStrSql = request.getParameter("configStrSql")==null?"":request.getParameter("configStrSql");
	String pos1 = request.getParameter("pos1")==null?"":request.getParameter("pos1");
	String pos2 = request.getParameter("pos2")==null?"":request.getParameter("pos2");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String pageReload = request.getParameter("pageReload")==null?"":request.getParameter("pageReload");
	
	int index1, index2;
	
	if(pos1 != null && pos2 != null)
	{
		index1 = Integer.parseInt(pos1);
		index2 = Integer.parseInt(pos2);
	}
	else
	{
		index2  = 0;
		index1 = 0;
	}
	eCA.SectionConfigDispFldBean confBean = (eCA.SectionConfigDispFldBean)session.getAttribute("ConfigDispFldBean");
	if(confBean != null)
	{	
		if(configStrSql != null && !configStrSql.equals(""))
		{
			confBean.setSectionConfig(configStrSql, resCategory, resSubCategory, index1, index2);
		}
		else
		{
			confBean.setSectionConfig(resCategory, index1, index2);
		}
		LinkedList<String> dispCol = confBean.getDispColumn();
		LinkedList<String> filedRef = confBean.getFieldReffColumn();
		Map<String, ArrayList<String>> keyData = confBean.getSelectedData();
		Map<String, String> mandatory =	confBean.getMandatoryYN();
		LinkedList<String> orderSeq = (LinkedList<String>)session.getAttribute("OrderSeq");

		if(orderSeq == null)
		{
			mode = "insert";
		}
		else
		{
			mode = "modify";
		}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />



<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/ConfigDispCrit.js'></script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formConfigDispFlds" id="formConfigDispFlds">
<br>
<div style="display: flex; justify-content: center;">
<table class="grid" width='85%' align='center' id='tblResultLinked' style='visibility:visible' >
	<tr>
		<th class='columnheader' width='20%'><fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/></th>
		
		<th class='columnheader' width='60%'><fmt:message key="eCA.DisplayFields.label" bundle="${ca_labels}"/></th>
		
		<th class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
		<%
			int count = 1;

			for(int i = 0; i < dispCol.size(); i++)
			{
				out.println("<tr id = 'numRows"+count+"'>");
				out.println("<td  width='20%' class='gridNumericData'><a id='gridLnk"+i+"' class='gridLink' href='javascript:changeColor("+dispCol.lastIndexOf(dispCol.get(i))+",\""+resCategory+"\",\""+count+"\");'>"+count+"</a></td>");
				out.println("<td  width='60%' class='gridData'>"+dispCol.get(i)+"</td> </td>");
				String check = mandatory.get(filedRef.get(i));

				if(mode.equals("modify"))
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");
					}
					else if(pageReload != null && pageReload.equals("reload"))
					{
						if(keyData.containsKey(filedRef.get(i))){
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						}
						else
						{
							out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");						
						}
					}
					else if(orderSeq.contains(filedRef.get(i)))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						%>
							<script>
								parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
							</script>
						  <%
					}
					else
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");	
					}

				}
				else
				{
					if(check.equals("Y"))
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked disabled></td></tr>");
					}
					else if(pageReload != null && pageReload.equals("reload"))
					{
						if(keyData.containsKey(filedRef.get(i)))
						{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");
						}
						else
						{
							out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")'></td></tr>");						
						}
					}
					else
					{
						out.println("<td width='20%' class='gridData'><input type='checkbox' name='chkSectionFlds"+count+"' id='chkSectionFlds"+count+"' onclick='addSelected(this,escape(\""+filedRef.get(i)+"\"),\""+count+"\")' checked></td></tr>");	
						%>
							<script>
								parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?key=<%=filedRef.get(i)%>&mode=ADD&fieldCount="+<%=count%>;
							</script>
						  <%
					}
				}
				count++;
			}
	}
	%>
	
</table>
</div>
	<input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='resCategoryKey' id='resCategoryKey' value='<%=resCategory%>'>
</form>
</body>

