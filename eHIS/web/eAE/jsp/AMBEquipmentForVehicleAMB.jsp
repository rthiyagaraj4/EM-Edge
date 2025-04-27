<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*"%>
<%
	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>Attached Resources For Vehicle</title>
		<%
			String sStyle				= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String facilityId=(String)session.getValue("facility_id");
			String mode					= request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag_for_list		= request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows				= request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition		= request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition		= request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			String strResource	=	"N";
			String chief_complaint_sec_type = "F";
			int cnt = 0;
			String chk="";
			String disable="";
			//boolean flag=true;
			int count=0;
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/messages.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eAE/js/AMBResEquForVehicle.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeSectionsForm' action='../../servlet/eAE.AMBEquipmentForVehicleServlet' method='post' target='messageFrame'>
			<table cellpadding='0' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<th align='center' colspan='4'><fmt:message key="eAE.AttachedEquipments.label" bundle="${ae_labels}"/></th>					
				</tr>
				<tr id='trcoll'>
					<th align='center' width = '60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>					
					<th align='center' width ='40%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
				</tr>
				<%
					if(!mode.equals("modify"))
					{
						Connection con						= null;
						PreparedStatement pstmtNoteSections = null;
						ResultSet resNoteSections			= null;
						
						String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

						String sec_heading_code = "";
						String sec_heading_desc = "";
						String chief_complaint_sec_yn = "N";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;

						try
						{
							con = ConnectionManager.getConnection(request);
							
							sqlNoteSec = "SELECT a.AMB_EQUIPMENT_CODE AMB_EQUIPMENT_CODE, B.long_desc FROM AE_AMB_VEHICLE_EQUIP a,  AM_RESOURCE B where a.AMB_EQUIPMENT_CODE = B.RESOURCE_ID and a.facility_id = b.facility_id  and a.AMB_VEHICLE_ID = ? and a.facility_id = '"+facilityId+"' and B.EFF_STATUS='E'";

							pstmtNoteSections = con.prepareStatement(sqlNoteSec);

							pstmtNoteSections.setString(1,note_type);
							resNoteSections = pstmtNoteSections.executeQuery();

							while(resNoteSections.next())
							{
								
								sec_heading_code = resNoteSections.getString("AMB_EQUIPMENT_CODE");
								sec_heading_desc = resNoteSections.getString("long_desc");
							
								chk	=	"";	

								if(cnt%2 == 0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";

								out.println("<tr id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+sec_heading_code+"' name = 'sec_heading_code"+cnt+"'> </td>");						
								out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td class='"+classValue+"'> "+sec_heading_desc+" </td>");
								out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
//								out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+sec_heading_code+"\",\""+sec_heading_desc+"\",\""+srlNo+"\",\""+cnt+"\")`> </td>");
								out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick=\"removeRecord(this,'"+sec_heading_code+"','"+cnt+"')\"> </td>");
								out.println("</tr>");							
								mapValue = sec_heading_desc + "~" + srlNo + "~" + chief_complaint_sec_type+ "~" + chief_complaint_sec_yn+"~"+strResource;
								resequBean.addRecords(sec_heading_code,mapValue);
								resequBean.addToList(cnt,sec_heading_code);
								cnt++;
								srlNo++;
							}
							
							out.println("<tr style='display:none' id='extraRow'><td align=\"center\" id='extraTD'><a href=\"javaScript:changeColor('"+cnt+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
							putObjectInBean("resequBean",resequBean,session);


							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();
						}
						catch(Exception e)
						{
							//out.println("Exception "+e.toString());
							e.printStackTrace(System.err);
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
						ArrayList list = resequBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								resequBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							resequBean.removeElement(positionOne);
						}
						else
						{
							resequBean.removeElement(positionOne+1);
						}

						putObjectInBean("resequBean",resequBean,session);
					}
					
					HashMap recValues = resequBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = resequBean.retrieveArrayList();

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
							strResource		=	strCodeToken.nextToken();
							
//							if(chief_complaint.equals("Y")||chief_complaint.equals("T")||chief_complaint.equals("S"))//**
  //                          {
								//check="";
								
//								disable="disabled";
//							}
//							else 
  //                          {
								//check="";
								disable="";
	//						}
							if(chief_complaint_sect_yn.equals("Y"))
							{
								if(chief_complaint.equals("Y")||chief_complaint.equals("T")||chief_complaint.equals("S"))//**
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

							if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							out.println("<tr id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='sec_heading_code"+i+"' id='sec_heading_code"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value='"+chief_complaint+"' name='chief_complaint_yn"+i+"' id='chief_complaint_yn"+i+"' </td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
//							out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\")`> </td>");
							out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' checked onclick=\"removeRecord(this,'"+keyVal+"','"+i+"')\"> </td>");
							out.println("</tr>");							
						}
					}

					tempInt++;
					out.println("<tr style='display:none' id='extraRow'><td align=\"center\"><a href=\"javaScript:changeColor('"+i+"','"+tempInt+"')\">"+tempInt+"</td><td></td><td></td></tr>");
					cnt = indexList.size();
				}
				catch(Exception e)
				{
					//out.println("Exception " +e.toString());
					e.printStackTrace(System.err);
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
			<input type='hidden' name='amb_equ_type' id='amb_equ_type' value='EQ'>
		</form>
		<script>
			parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = true;
		</script>
	</body>
</html>

