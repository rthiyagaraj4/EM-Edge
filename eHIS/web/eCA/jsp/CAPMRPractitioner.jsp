<!DOCTYPE html>
<%@ page import="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	 <%
		eCA.PatientBannerGroupLine pmrForPracBean = null;

		pmrForPracBean = (eCA.PatientBannerGroupLine)getObjectFromBean("pmrForPracBean","eCA.PatientBannerGroupLine",session);
		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String locale = (String) p.getProperty("LOCALE") == null ? "en" : (String) p.getProperty("LOCALE");
		StringBuffer sql = new StringBuffer("select practitioner_id pract_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') practitioner_name from AM_PRACT_FOR_FACILITY where FACILITY_ID = ? and EFF_STATUS ='E' ");
		String sqlSel = "select PRACTITIONER_ID from CA_PMR_FOR_PRACTITIONER where NOTE_TYPE_ID = ? and FACILITY_ID = ? ";
		String NoteTypeID = request.getParameter("NoteTypeID") == null ? "" : request.getParameter("NoteTypeID");
		String fnName = request.getParameter("fnName") == null ? "" : request.getParameter("fnName");
		String clearBean = request.getParameter("clearBean") == null ? "N" : request.getParameter("clearBean");
		String from = request.getParameter("from");
	    String to = request.getParameter("to");
		String practID = "";
		
		//shaiju
			
		String searchBy = request.getParameter("searchBy") == null ? "D" : request.getParameter("searchBy");
		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
		String searchCriteria = request.getParameter("searchCriteria") == null ? "" : request.getParameter("searchCriteria");

		if(searchCriteria.equals("S")) //if search value is equal to 'Starts with'
		{
			if(!searchText.equals("%"))
				searchText = searchText  + "%";
		}
		else if(searchCriteria.equals("E")) //if search value is equal to 'Ends with'
		{
			if(!searchText.equals("%"))
				searchText = "%" + searchText;
		}
		else //if search value is equal to 'Contains'
		{
			if(!searchText.equals("%"))
				searchText = "%" + searchText + "%" ;
		}
		if(searchBy.equals("D"))
		{
			sql.append(" and UPPER(AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1')) like upper(?) order by practitioner_name  ");
		}
		else
		{
			sql.append( " and UPPER(practitioner_id) like upper(?) order by pract_id ");
		}
			
		//shaiju




	    int start = 0 ;
		int end = 0 ;
		int i=1;

		if (from == null)
			start = 1 ;
		else
			start = Integer.parseInt(from);
		if (to == null )
			end = 14 ;
		else
			end = Integer.parseInt(to) ;
		
		int maxRecord = 0;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;		
		
		if (clearBean.equals("Y"))
			pmrForPracBean.clearBean();
 
			ArrayList practList = pmrForPracBean.returnList1();
			


		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement(sqlSel);
			ps.setString(1,NoteTypeID);
			ps.setString(2,facilityId);

			res = ps.executeQuery();
			//pmrForPracBean.clearBean();
			while(res.next())
			{
				practID = res.getString("PRACTITIONER_ID") == null ? "" : res.getString("PRACTITIONER_ID");
				if(!(practList.contains(practID)))
					pmrForPracBean.addRecordstoLine1(practID);
			}
			putObjectInBean("pmrForPracBean",pmrForPracBean,session);
			if(res != null) res.close();
			if(ps != null) ps.close();

			ps = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,locale);
			ps.setString(2,facilityId);
			if(searchBy.equals("D"))
			{
				ps.setString(3,locale);
				ps.setString(4,searchText);
			}
			else
			{
				ps.setString(3,searchText);
			}
			
			res = ps.executeQuery();
			while(res.next())
			{
				maxRecord++;
			}
		%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCA/js/CAPatMedReport.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='pmrPractForm' id='pmrPractForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td class='white' width='100%'></td> 
					<td  width='25%' nowrap>
					<%
					if ( !(start <= 1) )
						out.println("<A class='gridLink' HREF='../../eCA/jsp/CAPMRPractitioner.jsp?from="+(start-14)+"&to="+(end-14)+"&searchBy="+searchBy+"&searchText="+URLEncoder.encode(searchText)+"&searchCriteria="+URLEncoder.encode(searchCriteria)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
						
					if ( !( (start+14) > maxRecord ) )
						out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CAPMRPractitioner.jsp?from="+(start+14)+"&to="+(end+14)+"&searchBy="+searchBy+"&searchText="+URLEncoder.encode(searchText)+"&searchCriteria="+URLEncoder.encode(searchCriteria)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

					%>
					</td>
				</tr>
			</table>
			<table  align='center' class='grid' width='100%'>
				<tr>
					<th align="left"><fmt:message key='Common.practitionerid.label' bundle='${common_labels}'/></th>
					<th align="left"><fmt:message key='Common.practitionername.label' bundle='${common_labels}'/></th>
					<th align="left"><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></th>
				</tr>
				<%					
					String practId = "";
					String practName = "";
					String classValue = "QRYEVEN";
					String chkUnchkSel = "";
					//int cnt = 0;
					
					try
					{
						ArrayList list = pmrForPracBean.returnList1();
						out.println("<input type='hidden' name='cntSelected' id='cntSelected' value='"+list.size()+"'>");
						out.println("<input type='hidden' name='cntSelected1' id='cntSelected1' value='"+list.size()+"'>");
						res.beforeFirst();

						

						if (start != 1)
							 for(int j=1; j<start; i++,j++)
							  res.next();
						while(res.next() && i <= end)
						{
							/*if(i % 2 == 0) classValue = "QRYEVEN";
							else classValue = "QRYODD";*/

                            classValue = "gridData";
							practId = res.getString(1) == null ? "" : res.getString(1);
							practName = res.getString(2) == null ? "" : res.getString(2);

							if(list.contains(practId)) chkUnchkSel = " checked ";
							else chkUnchkSel = "";

							out.println("<tr>");
							out.println("<td class='"+classValue+"'>"+practId);
							out.println("<td class='"+classValue+"'>"+practName);
							out.println("<td class='"+classValue+"'><input type='checkbox' onclick='addIDToBean(this,\""+practId+"\",\"pmrForPracBean\",\"pmrPractForm\")' "+chkUnchkSel+">");
							out.println("</tr>");
							i++;
						}
						if(res != null) res.close();
						if(ps != null) ps.close();
					}
					catch(Exception e)
					{
						
					//	out.println("Exception at try of CAPMRPractitioner.jsp -"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
					finally
					{
						if(res != null) res.close();
						if(ps != null) ps.close();
						if(con != null) ConnectionManager.returnConnection(con,request);
					}
		}//end of try
		catch(Exception ee)
		{

			//out.println("Exception at try-main of CAPMRPractitioner.jsp -"+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	%>
			</table>
			<input type='hidden' name='fnName' id='fnName' value='<%=fnName%>'>
			<input type='hidden' name='NoteTypeID' id='NoteTypeID' value='<%=NoteTypeID%>'>			
			<input type='hidden' name='pmrBeanID' id='pmrBeanID' value='pmrForPracBean'>			
		</form>
	</body>
</html>

