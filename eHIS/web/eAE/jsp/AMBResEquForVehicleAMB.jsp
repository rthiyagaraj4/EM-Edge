<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);
%>
<html>
	<head>
		<title>Attached Resources For Vehicle</title>
		<%
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//	out.println("request==>"+request.getQueryString());
		    String facilityId 	= (String) session.getValue( "facility_id" ) ;
			String mode					= request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag_for_list		= request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows				= request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition		= request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition		= request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			String strResource			= request.getParameter("currResource") == null ? "" : request.getParameter("currResource");
			String strPosition			= request.getParameter("posDesc") == null ? "" : request.getParameter("posDesc");
			String strPosDisplay		=	"";
			String strResType			=	"";
			String rowID				=	"";

			if(strPosition.equals("") || strPosition.equals("AA") )
			{
				strPosition		= "AA";
				strPosDisplay	=	"&nbsp;";
			}
			else
				strPosDisplay	=	strPosition;
				
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeSectionsForm' action='../../servlet/eAE.AMBEquipmentForVehicleServlet' method='post' target='messageFrame'>
			<table cellpadding='0' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<th align='center' colspan='5'><fmt:message key="eAE.AssociatedStaff.label" bundle="${ae_labels}"/></th>							
				</tr>
				<tr id='trcoll'>
					<th align='center' width = '30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>		
					<th align='center' width = '20%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>	
					<th align='center' width ='15%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>					
					<th align='center' width ='15%'><fmt:message key="eAE.DisplayContact.label" bundle="${ae_labels}"/></th>
					<th align='center' width ='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>		
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
						String chief_complaint_sec_yn = "";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;

						try
						{
							con = ConnectionManager.getConnection(request);
							
							sqlNoteSec = "SELECT b.AMB_VEHICLE_NAME note_type_desc,c.PRACT_SOURCE, a.AMB_RESOURCE_ID AMB_RESOURCE_ID, c.PRACTITIONER_NAME PRACTITIONER_NAME, CONTACT_DISPLY_YN,DECODE(A.AMB_RESOURCE_TYPE,'P','Practitioner','E','External Practitioner','O','Other Staff') RESTYPE,NVL(C.POSITION_DESC,'AA') POSITION_dESC,A.AMB_RESOURCE_ID || '~' || c.PRACT_SOURCE ROWIDEN  FROM AE_AMB_VEHICLE_RESOURCE a, AE_AMB_VEHICLE b, AM_PRACT_FOR_AMB_VW c where a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID AND a.facility_id = b.facility_id and a.AMB_RESOURCE_ID = c.PRACTITIONER_ID and a.AMB_RESOURCE_TYPE = c.PRACT_SOURCE and a.AMB_VEHICLE_ID = ? and b.facility_id = '"+facilityId+"'  ";

							System.err.println("AMBResEquForVehicleAMB.jsp sqlNoteSec===>"+sqlNoteSec);
							System.err.println("AMBResEquForVehicleAMB.jsp note_type===>"+note_type);
							
							pstmtNoteSections = con.prepareStatement(sqlNoteSec);

							pstmtNoteSections.setString(1,note_type);
							resNoteSections = pstmtNoteSections.executeQuery();
					
							while(resNoteSections.next())
							{
								rowID			  =	resNoteSections.getString("ROWIDEN");
								sec_heading_code = resNoteSections.getString("AMB_RESOURCE_ID");
								sec_heading_desc = resNoteSections.getString("PRACTITIONER_NAME");

								chief_complaint_sec_yn = resNoteSections.getString("CONTACT_DISPLY_YN");
								strResource		=	resNoteSections.getString("RESTYPE");
								strPosition		=	resNoteSections.getString("POSITION_DESC");
								strResType		= resNoteSections.getString("PRACT_SOURCE");
								if(strPosition == null || strPosition.equals("AA") )
									strPosDisplay  = "&nbsp;";
								else
									strPosDisplay  = strPosition;

								if(chief_complaint_sec_yn.equals("Y"))
								{
								  	chk="checked";
									count++;
								}
								else
									chk="";	

								if(cnt%2 == 0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";

								out.println("<tr id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+sec_heading_code+"' name = 'sec_heading_code"+cnt+"'> </td>");						
								out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strResource+"' name='resource"+cnt+"' id='resource"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strPosition+"' name='position"+cnt+"' id='position"+cnt+"'> </td>");
								out.println("<td style='display:none'> <input type='hidden' value = '"+strResType+"' name='resType"+cnt+"' id='resType"+cnt+"'> </td>");
//								out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+cnt+"','"+srlNo+"')\"> "+srlNo+" </a></td>");
								out.println("<td class='"+classValue+"'> "+sec_heading_desc+" </td>");
								out.println("<td class='"+classValue+"'> "+strPosDisplay+" </td>");
								out.println("<td class='"+classValue+"'> "+strResource+" </td>");
								out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
								out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+rowID+"\",\""+sec_heading_desc+"\",\""+srlNo+"\",\""+cnt+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
								out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick='removeRecord(this,\""+rowID+"\",\""+cnt+"\",\""+strResource+"\",\""+strPosition+"\")'> </td>");
								out.println("</tr>");							
								//out.println("chief_complaint_sec_yn"+chief_complaint_sec_yn);
								
								sec_heading_desc	= sec_heading_desc.replace("~","$$$");


								mapValue = sec_heading_desc + "~" + srlNo + "~" + chief_complaint_sec_type+ "~" + chief_complaint_sec_yn+"~"+strResource +  "~"+strPosition;


								resequBean.addRecords(rowID,mapValue);
								resequBean.addToList(cnt,rowID);
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
				//StringTokenizer strCodeToken = null;
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
		
						StringTokenizer strCodeToken = new StringTokenizer(mapVal,"~");
						//out.println("239keyVal "+i+"==>"+keyVal);
						//out.println("240mapVal"+i+"==>"+mapVal);
						while(strCodeToken.hasMoreTokens())
						{
							//out.println("strCodeToken==>"+strCodeToken);
							
							heading_desc = strCodeToken.nextToken();
							heading_desc=heading_desc.replace("$$$","~");

							heading_seq_num = strCodeToken.nextToken();
							chief_complaint = strCodeToken.nextToken();
							chief_complaint_sect_yn=strCodeToken.nextToken();
							strResource		=	strCodeToken.nextToken();
							strPosition		=   strCodeToken.nextToken();
									
								if(strPosition == null || strPosition.equals("") || strPosition.equals("AA") )
									strPosDisplay  = "&nbsp;";
								else
									strPosDisplay  = strPosition;

							if(strResource.equals("Practitioner") )
								strResType	=	"P";
							else if(strResource.equals("External Practitioner") )
								strResType	=	"E";
							else
								strResType	=	"O";


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
							out.println("<td style='display:none'> <input type='hidden' value = '"+strResource+"' name='resource"+i+"' id='resource"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value = '"+strPosition+"' name='position"+i+"' id='position"+i+"'> </td>");
							out.println("<td style='display:none'> <input type='hidden' value = '"+strResType+"' name='resType"+i+"' id='resType"+i+"'> </td>");

//							out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+i+"','"+tempInt+"')\"> "+tempInt+" </a></td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' > "+strPosDisplay+" </td>");
							out.println("<td class='"+classValue+"'> "+strResource+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
							//out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=\"addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")\"> </td>");


							out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+" 						onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");

							//out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");

							out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox' checked onclick='removeRecord(this,\""+keyVal+"\",\""+i+"\",\""+strResource+"\",\""+strPosition+"\")'> </td>");
							out.println("</tr>");	
							

						check="";								
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
			<input type='hidden' name='amb_equ_type' id='amb_equ_type' value='RS'>
		</form>
		<script>
			parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = true;
		</script>
	</body>
</html>

