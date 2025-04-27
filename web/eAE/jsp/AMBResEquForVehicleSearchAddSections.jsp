<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page language="java" import ="java.net.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);
%>
<html>
	<head>
		<title>Attached Sections For Note Type</title>
		<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String facilityId 	= (String) session.getValue( "facility_id" ) ;
			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			String strResType = request.getParameter("amb_res_type") == null ? "" : request.getParameter("amb_res_type");
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
			String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			//String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
		//	String endString =  request.getParameter("end") == null ? "9" : request.getParameter("end");
			String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");
			String strSelected	=	"";
			String strResource	=	"";
			String strPosition	=	"";
			String strPosDisplay	=	"";
			String strBeanKey		=	"";
			int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));
	
			if(tempRowIds.indexOf("^") != -1)
			{
				for(int y=0;y<tempRowIds.length();y++)
					tempRowIds = tempRowIds.replace('^','+');
			}

			if(!tempRowIds.equals(""))
				tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);

			

			int tempSeq = 0;
			int count = 0;
			int tempCount = 0;
			//Mahesh start
			String from = request.getParameter( "from" );
			String to = request.getParameter( "to" );
			int maxRecord=0;
			int start = 0;
			int end = 0;
	 int h=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 9;
	 else
		end = Integer.parseInt( to ) ;
		//End
	
			if(mode.equals("modify"))
				searchText = "";
		%> 

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/messages.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/tableheaderscroll.js" language="javascript"></script>
		<script language='javascript' src='../../eAE/js/AMBResEquForVehicle.js'></script>
		<script>
		function fnOnLoad(){
			if(document.getElementById("dat1")!=null){
				fxheaderInit('dat1',190);
			}
		}
		
		</script>
	</head>
	<body onscroll='scrollTitle()' onload="fnOnLoad();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeSearchSectionsForm'>
			<table cellpadding='5' cellspacing='0' border='0' width='100%' align='center'>
				<tr id='trcoll'>
					<th align='center' colspan='3'><fmt:message key="eAE.AvailableStaff.label" bundle="${ae_labels}"/></th>
				</tr>
				<tr id='trcoll'>
					<td class = 'label' align='right' width ='35%'><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>&nbsp;
					<select name ='amb_res_type' >
					<option value = ''>---Select----</option>
					<%
							if(strResType.equals("P") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					%>
					<option value = 'P' <%=strSelected%>>Practitioner</option>
					<%
							if(strResType.equals("E") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					%>

					<option value = 'E' <%=strSelected%>>External Practitioner</option>
					<%
							if(strResType.equals("O") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					%>
					<option value = 'O' <%=strSelected%>>Other Staff</option>
					</select></td>
					<td class = 'label' align='right' width='65%'><fmt:message key="eAE.StaffStartsWith.label" bundle="${ae_labels}"/>&nbsp; <input type='text' name='searchText' id='searchText' value='<%=searchText%>'></td>
					<td width='35%'><input type='button' name='searchBtn' id='searchBtn' class='button' value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='loadSections()'></td>
				</tr>				
			</table>
			<!--<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td align='right'><a style='visibility:hidden' id='prevRecs' href="javascript:loadPrevNextRecs('prev')">Prev</a>&nbsp;&nbsp;<a id='nextRecs' href="javascript:loadPrevNextRecs('next')">Next</a></td>
				</tr>
			</table>-->
			<!--<table cellpadding='0' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<th align='center' width = '35%'>Description</th>
					<th align='center' width = '15%'>Position</th>
					<th align='center' width = '20%'>Type</th>
					<th align='center' width = '10%'>Select</th>
				</tr>-->
				<%
					Connection con = null;
					PreparedStatement pstmtNoteSections = null;
					ResultSet resNoteSections = null;
					PreparedStatement pstmtChk = null;
					ResultSet resChk = null;

					String sec_heading_code = "";
					String sec_heading_desc = "";
					String content_type = "";
					String chief_comp = "";
					StringBuffer sqlNoteSec = new StringBuffer();
					String classValue = "";
					String exist_yn = "";
					String chkSelBox = "";
					String rowID = "";

					int cnt = 0;

					if(!mode.equals("modify"))
					{
						ArrayList keySectionForChk = resequBean.retrieveRecords();
						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec.append("SELECT A.PRACTITIONER_id || '~' || A.PRACT_SOURCE ROWIDEN , A.PRACTITIONER_ID  ,A.PRACTITIONER_NAME  , A.PRACT_SOURCE  ,NVL((    SELECT      'Y'     FROM      AE_AMB_VEHICLE_RESOURCE B    WHERE B.AMB_VEHICLE_ID=? and b.facility_id = '"+facilityId+"' AND B.AMB_RESOURCE_ID =A.PRACTITIONER_ID   AND B.AMB_RESOURCE_TYPE = A.PRACT_SOURCE    AND ROWNUM=1   )  ,'N' ) exist_yn,DECODE(A.PRACT_SOURCE,'P','Practitioner','E','External Practitioner','O','Other Staff') RESTYPE,NVL(A.POSITION_DESC,'AA') POSITION_DESC FROM AM_PRACT_FOR_AMB_VW  A WHERE 1=1 ");
							
							if(!searchText.equals(""))
							{
								sqlNoteSec.append(" and upper(PRACTITIONER_NAME) like upper(?)");
							}

							if(!tempRowIds.equals(""))
							{
								sqlNoteSec.append(" and A.PRACTITIONER_id ||'~'|| A.PRACT_SOURCE in ("+tempRowIds+") ");
							}

							if(!strResType.equals("") )
							{
								sqlNoteSec.append(" AND A.PRACT_SOURCE = ? ");
							}

							sqlNoteSec.append(" ORDER BY PRACTITIONER_NAME ");

							pstmtNoteSections = con.prepareStatement(sqlNoteSec.toString());
							
							int nCntA	=	0;
							pstmtNoteSections.setString(++nCntA,note_type);

							if(!searchText.equals(""))
							{
								pstmtNoteSections.setString(++nCntA,searchText+"%");
							}

							if(!strResType.equals("") )
							{
								pstmtNoteSections.setString(++nCntA,strResType);
							}
							resNoteSections = pstmtNoteSections.executeQuery();
							//Mahesh start
							if ( start != 1 )
							 for( int j=1; j<start; h++,j++ )
							  {
								resNoteSections.next() ;
							  }	
							 //End 
							while (resNoteSections!=null && h<=end && resNoteSections.next()) 
							//while(resNoteSections.next())
								{
								if(maxRecord == 0)
									{
								%>
							<P>
							<table align='right' >
							<tr>
							<%if ( !(start <= 1) ){%>
							<td align ='left' id='prev' ><A href="#"  onclick="loadPrevNextRecs('prev')"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")%></A>&nbsp;&nbsp;<td><%}%>
							<td align ='right' id='next' style='visibility:hidden'>
							<A href="#" onclick="loadPrevNextRecs('next')"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")%></A>
							</td>
							</tr>
							</table>
							<br><br>
							</P>
		
		<table id="dat1" border="1" width="100%" style="border-spacing:0px ;border-collapse: collapse;" >
				<tr >
					<th ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th ><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
					</tr>
				
<%
							}
								rowID				= resNoteSections.getString("ROWIDEN");
								sec_heading_code	= resNoteSections.getString("PRACTITIONER_ID");
								sec_heading_desc	= resNoteSections.getString("PRACTITIONER_NAME");
								content_type		= resNoteSections.getString("PRACT_SOURCE");
								exist_yn			= resNoteSections.getString("exist_yn");
								strResource			= resNoteSections.getString("RESTYPE");
								strPosition			= resNoteSections.getString("POSITION_DESC");

								if(strPosition == null || strPosition.equals("AA") )
								{
									strPosition = "AA";
									strPosDisplay  = "&nbsp;";
								}
								else
									strPosDisplay	=	strPosition;

								if(exist_yn.equals("Y"))
									chkSelBox = " checked ";
								else
									chkSelBox = "";

								if(content_type.equals("F") || content_type.equals("R"))
								{
									chief_comp = "N";
								}
								else
								{
									
									chief_comp = "Y";
								}

								//chief_comp = "N";

								if(keySectionForChk != null)
								{
									for(int n=0;n<keySectionForChk.size();n++)
									{
										if(((String) keySectionForChk.get(n)).equals(rowID))
										{
											chkSelBox = " checked ";
											tempSeq = n;											
											n = keySectionForChk.size();
										}
										else
											chkSelBox = "";										
									}
								}

								if(loadFirst.equals("Yes"))
								{
								%>
									<script>
										parent.parent.rowIDSectionForNoteType[<%=cnt%>] = '<%=rowID%>';
									</script>
								<%
								}

								if(maxRecord < 9)
								{
						
									if(cnt%2 == 0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";
									out.println("<tr>");
									out.println("<td class='"+classValue+"' width = '36%'> "+sec_heading_desc+" </td>");
									out.println("<td class='"+classValue+"' width = '15%'> "+strPosDisplay+" </td>");
									out.println("<td class='"+classValue+"' width = '20%'> "+strResource+" </td>");
									out.println("<td class='"+classValue+"' style='text-align:center;' width = '10%' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' "+chkSelBox+" onclick=`loadSectionsPage(this,\""+rowID+"\",\""+sec_heading_desc+"\",\""+chief_comp+"\",\""+tempSeq+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
									out.println("</tr>");
								}

								cnt++;
								h++;//Mahesh
								maxRecord++;//Mahesh
								resequBean.addFrameRecords(rowID,sec_heading_desc);						
							}
							count = cnt;
							if(loadFirst.equals("Yes"))
							{
								tempCount = cnt;
							}
							else
							{
								tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
							}
							putObjectInBean("resequBean",resequBean,session);
							
							//Mahesh starts
							if ( maxRecord < 9 || (!resNoteSections.next()) )
								{
								%>
									<script >
									if (document.getElementById("next"))
									document.getElementById("next").innerHTML="";

									</script>
								<% 
								}
								else
								{%>
									<script >
									if (document.getElementById("next"))
								document.getElementById("next").style.visibility='visible';
									</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



								<%
								}
							//End	
							if(cnt == 0)
							{
								%>
								<script>
									//document.getElementById("nextRecs").style.visibility = 'hidden';
									//document.getElementById("prevRecs").style.visibility = 'hidden';
								</script>
								<%
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
								out.println("<script>document.forms[0].searchText.value = '';</script>");
							}
							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();

							if(pstmtChk != null) pstmtChk.close();
							if(resChk != null) resChk.close();
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
						String keyValSec = "";
						String heading_desc = "";
						String chk_sel = "";
						String codeList = "";

						int k = 0;
						int i = 0;
						ArrayList list = resequBean.retrieveArrayList();
						
						try
						{
							ArrayList keys = resequBean.retrieveHashRecords();
							ArrayList keySection = resequBean.retrieveRecords();
							//out.println("keySection --"+keySection+"--");
							HashMap recValues = resequBean.getHashRecordValues();
							for(i=0; i<keys.size(); i++)
							{
								keyVal = (String)keys.get(i);
								heading_desc = (String)recValues.get(keyVal);

								for(int j=0; j<keySection.size(); j++)
								{
									keyValSec = (String)keySection.get(j);

									if(keyVal.equals(keyValSec))
									{
										chk_sel = " checked ";
										for(k=0;k<list.size();k++)
										{
											codeList = (String) list.get(k);
											if(codeList.equals(keyVal))
											{
												tempSeq = k;
												k = list.size();
											}
										}
										 j = keySection.size();
									}
									else
										chk_sel = "";
								}

								if(i < 9)
								{
									if(i%2 ==0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";

									out.println("<tr>");
									out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
									out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox'   "+chk_sel+" onclick=`loadSectionsPage(this,\""+keyVal+"\",\""+heading_desc+"\",\""+tempSeq+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
									out.println("</tr>");
								}
							}
							count = i;
						}
						catch(Exception e)
						{
							//out.println("Exception  "+e.toString());
							e.printStackTrace(System.err);
						}
					}
				%>
			
				</table>
				
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='searchTextHidden' id='searchTextHidden' value='<%=searchText%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
			<input type='hidden' name='note_type' id='note_type' value='<%=note_type%>'>
			<input type='hidden' name='totalCount' id='totalCount' value='<%=tempCount%>'>
			<input type='hidden' name='countForNext' id='countForNext' value='<%=countForNext%>'>
		</form>
		<%
		if(!mode.equals("modify") && flag.equals("0") && !flagTemp.equals("temp"))
		{
		%>
		<script>
			parent.sectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleAMB.jsp?note_type=<%=note_type%>';
		</script>
		<%
		}
		%>
		<script>
			/*var tempVar = <%=tempCount%> / 12;
			if(<%=start%> == 0)
				document.getElementById("prevRecs").style.visibility = 'hidden';
			else
				document.getElementById("prevRecs").style.visibility = 'visible';
		
			if(<%=count%> < 12 || <%=countForNext%> == tempVar)
				document.getElementById("nextRecs").style.visibility = 'hidden';
			else
				document.getElementById("nextRecs").style.visibility = 'visible';*/
		</script>
	</body>
</html>

