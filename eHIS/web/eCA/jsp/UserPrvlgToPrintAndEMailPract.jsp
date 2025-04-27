<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	 <%
		eCA.PatientBannerGroupLine usrPrvlgBean = null;

		usrPrvlgBean = (eCA.PatientBannerGroupLine)getObjectFromBean("usrPrvlgBean","eCA.PatientBannerGroupLine",session);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String locale = (String) p.getProperty("LOCALE") == null ? "en" : (String) p.getProperty("LOCALE");
		StringBuffer sql =new StringBuffer("select practitioner_id pract_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') practitioner_name from AM_PRACT_FOR_FACILITY where FACILITY_ID = ? and EFF_STATUS ='E' /*and exists (select 1 from sm_resp_for_user ia, sm_appl_user ib, CA_NOTE_TYPE_FOR_RESP  IC  where IC.NOTE_TYPE=? AND IC.PRIVILEGE_TYPE in ('2','3','4','5') AND IA.resp_id=IC.resp_id and ib.func_role_id=AM_PRACT_FOR_FACILITY.practitioner_id and ia.appl_user_id=ib.appl_user_id))*/");
		String sqlSel = "select practitioner_id from CA_PMR_USER_PRIVILAGES where NOTE_TYPE_ID = ? and PRIVILAGE_ID = ? ";
		String from = request.getParameter("from");
	    String to = request.getParameter("to");
		String noteTypeId = request.getParameter("noteTypeId") == null ? "" : request.getParameter("noteTypeId");
		String prvlgId = request.getParameter("privilegeId") == null ? "" : request.getParameter("privilegeId");
		String practID = "";

		//shaiju
			
		String searchBy = request.getParameter("searchBy") == null ? "D" : request.getParameter("searchBy");
		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
		String searchTxt = searchText;
		String searchCriteria = request.getParameter("searchCriteria") == null ? "" : request.getParameter("searchCriteria");

		if(searchCriteria.equals("S")) //if search value is equal to 'Starts with'
		{
			if(!searchText.equals("%") )
				searchText = searchText  + "%";
		}
		else if(searchCriteria.equals("E")) //if search value is equal to 'Ends with'
		{
			if(!searchText.equals("%") )
				searchText = "%" + searchText;
		}
		else //if search value is equal to 'Contains'
		{
			if(!searchText.equals("%") )
				searchText = "%" + searchText + "%" ;
		}
		if(searchBy.equals("D"))
		{
			sql.append(" and UPPER(AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1')) like upper(?) order by practitioner_name  ");
		}
		else
		{
			sql.append( " and practitioner_id like upper(?) order by pract_id ");
		}
			
		//shaiju


	    int start = 0;
		int end = 0;
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
		ArrayList practList = usrPrvlgBean.returnList1();

		try
		{
			con = ConnectionManager.getConnection(request);

			ps = con.prepareStatement(sqlSel);
			ps.setString(1,noteTypeId);
			ps.setString(2,prvlgId);

			res = ps.executeQuery();
			while(res.next())
			{
				practID = res.getString("practitioner_id") == null ? "" : res.getString("practitioner_id");
				if(!(practList.contains(practID)))
					usrPrvlgBean.addRecordstoLine1(practID);
			}
			putObjectInBean("usrPrvlgBean",usrPrvlgBean,session);
			if(res != null) res.close();
			if(ps != null) ps.close();


			ps = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			ps.setString(1,locale);
			ps.setString(2,facilityId);
			//ps.setString(3,noteTypeId);
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
		<script src="../../eCA/js/UserPrvlgToPrintAndEMail.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='usrPrvlgPractForm' id='usrPrvlgPractForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td class='white' width='100%'></td> 
					<td  width='25%' nowrap>
					<%
					if ( !(start <= 1) )
						out.println("<A class='gridLink'  href='../../eCA/jsp/UserPrvlgToPrintAndEMailPract.jsp?from="+(start-14)+"&to="+(end-14)+"&privilegeId="+prvlgId+"&searchCriteria="+searchCriteria+"&searchBy="+searchBy+"&searchText="+searchTxt+"&noteTypeId="+noteTypeId+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
						out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/UserPrvlgToPrintAndEMailPract.jsp?from="+(start+14)+"&to="+(end+14)+"&searchBy="+searchBy+"&privilegeId="+prvlgId+"&searchCriteria="+searchCriteria+"&searchText="+searchTxt+"&noteTypeId="+noteTypeId+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					%>
					</td>
				</tr>
			</table>
			<table  class='grid' align='center' cellpadding=3 cellspacing=0 border=1 width='100%'>
				<tr>
					<th><fmt:message key='Common.practitionerid.label' bundle='${common_labels}'/></th>
					<th><fmt:message key='Common.practitionername.label' bundle='${common_labels}'/></th>
					<th><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></th>
				</tr>
				<%					
					String practId = "";
					String practName = "";
					String classValue = "gridData";
					String chkUnchkSel = "";
					//int cnt = 0;
					
					try
					{
						ArrayList list = usrPrvlgBean.returnList1();
						out.println("<input type='hidden' name='cntSelected' id='cntSelected' value='"+list.size()+"'>");
						out.println("<input type='hidden' name='cntSelected1' id='cntSelected1' value='"+list.size()+"'>");

						res.beforeFirst();

						if (start != 1)
							 for(int j=1; j<start; i++,j++)
							  res.next();
						while(res.next() && i <= end)
						{
							if(i % 2 == 0) classValue = "gridData";
							else classValue = "gridData";

							practId = res.getString(1) == null ? "" : res.getString(1);
							practName = res.getString(2) == null ? "" : res.getString(2);

							if(list.contains(practId)) chkUnchkSel = " checked ";
							else chkUnchkSel = "";

							out.println("<tr>");
							out.println("<td class='"+classValue+"'>"+practId);
							out.println("<td class='"+classValue+"'>"+practName);
							out.println("<td class='"+classValue+"'><input type='checkbox' onclick='addIDToBean(this,\""+practId+"\")' "+chkUnchkSel+">");
							out.println("</tr>");
							i++;
						}
						if(res != null) res.close();
						if(ps != null) ps.close();
					}
					catch(Exception e)
					{
						
						//out.println("Exception at try of UserPrvlgToPrintAndEMailPract.jsp -"+e.toString());//common-icn-0181
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
			
			//out.println("Exception at try-main of UserPrvlgToPrintAndEMailPract.jsp -"+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	%>
			</table>
			<input type='hidden' name='privilegeFor' id='privilegeFor' value='<%=prvlgId%>'>
			<input type='hidden' name='patMedicalReport' id='patMedicalReport' value='<%=noteTypeId%>'>
		</form>
	</body>
</html>

