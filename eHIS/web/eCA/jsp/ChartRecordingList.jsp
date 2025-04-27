<!DOCTYPE html>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	try{
		String encounterId = request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
		
		if(encounterId.equals("")) encounterId = "0";

		String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String defaultYN = request.getParameter("defaultYN")==null?"":request.getParameter("defaultYN");
		HashMap finalHash = (HashMap)session.getValue("finalHash"+encounterId);
		ArrayList dates = (ArrayList)session.getValue("dates"+encounterId);
		HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
		ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);
		ArrayList arrayResultType = (ArrayList)session.getValue("resultType"+encounterId);
		String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
		String detailYN = request.getParameter("detailYN")==null?"":request.getParameter("detailYN");
		String errorAuth = request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
		String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");

%>
<%if(dates.size()>0)
{%>
	<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCA/html/IeStyle.css"></link> -->
	<%
		if(function_from.equals("SECONDARY_TRIAGE"))
		{
	%>
		<script>
			//displayListForAE();	
		</script>
	<%
		}
	%>
		
		<%

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			int tabWidth = 0;
			int widPc = 0;
			if(dates.size() <= 5)
			{
				tabWidth = dates.size() * 100;//only for GUI purpose...no specific reason to set it to 100...
			}
			else
			{
				tabWidth = dates.size() * 80;
			}
			widPc = tabWidth/dates.size();
		//out.println("widPc"+widPc);
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<style>
		A:link
		{
			COLOR: yellow
		}
		A:visited
		{
			COLOR: yellow
		}
/*TH {
  FONT-FAMILY: VERDANA ;
  FONT-SIZE: 7PT ;
  COLOR:WHITE;
  BACKGROUND-COLOR: #808080;

}
TD.QRYEVEN {
	FONT-SIZE: 9PT ;
    BACKGROUND-COLOR: #F0F0F2;  
	BORDER-STYLE: THIN;
	BORDER-LEFT-COLOR: #E2E3F0;
	BORDER-RIGHT-COLOR: white;
	BORDER-TOP-COLOR: #E2E3F0;
	BORDER-BOTTOM-COLOR: white;
}

TD.QRYODD {
    BACKGROUND-COLOR:#F0F0F2;  
	FONT-SIZE: 9PT ;
	BORDER-STYLE: THIN;
	BORDER-COLOR:	#E2E3F0;
	BORDER-LEFT-COLOR: #E2E3F0;
	BORDER-RIGHT-COLOR: white;
	BORDER-TOP-COLOR: #E2E3F0;
	BORDER-BOTTOM-COLOR: white;

}*/
/*TD.QRYODD{
	BACKGROUND-COLOR: #F0F0F2;  
	FONT-SIZE: 7pt ;
	BORDER-STYLE: THIN;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;


    }

TD.QRYEVEN{
    FONT-SIZE: 7pt ;
    BACKGROUND-COLOR: #c3dfa8;  
	BORDER-STYLE: THIN;
	border-left-color: #E2E3F0;
	border-right-color: white;
	border-top-color: #E2E3F0;
	border-bottom-color: white;*/
	/*height: 25px;*/
	/*height: 26;*/

	
     /*}*/
/*TD.CAFOURTHLEVELCOLOR 
{
	BACKGROUND-COLOR: #637BBD ;
	COLOR:WHITE;
	BORDER-STYLE: SOLID;
	BORDER-COLOR:	WHITE;
    BORDER-RIGHT-COLOR: #637BBD;
	BORDER-TOP-COLOR: WHITE;
	BORDER-BOTTOM-COLOR: #637BBD;
	FONT-WEIGHT: BOLD ;

}
TD.CASUMMARY  
{
   	BACKGROUND-COLOR: #ADD8E6;
   	FONT-SIZE: 7pt ;
	COLOR: BLACK;
	BORDER-STYLE: SOLID;
	BORDER-COLOR:	WHITE;
	BORDER-LEFT-COLOR: WHITE;
	BORDER-RIGHT-COLOR: #ADD8E6;
	BORDER-TOP-COLOR: WHITE;
	BORDER-BOTTOM-COLOR: #ADD8E6;

}*/

TD.CACHARTQRYEVEN {
	FONT-SIZE: 7PT ;
    BORDER-STYLE: THIN;
}

TD.CACHARTFOURTHLEVELCOLOR 
{
	height: 12;
}

TD.CRITICAL{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#D2B48C;

}
TD.ABNORMAL{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#FFF8DC;
}
TD.HIGH{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#FFDAB9
}
TD.LOW{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#F0FFFF;
}
TD.CRITICALLOW{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#D8BFD8;
}
TD.CRITICALHIGH{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#F4A460;
}
TD.DELTAFAIL{
	FONT-SIZE: 7PT ;
	BORDER-STYLE: THIN;
	background-color:#FFE4E1;
}
</style>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollListFrame()'>
	<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<form name ="ChartLayoutListForm">

		<table cellspacing=0 cellpadding=3 border=1 id='titleTable' width='<%=tabWidth%>'>
		<tr id='divTitleTable'>
			<%
				StringTokenizer tokenizeSpace = null;
				String dt = "";
				String currDate="";
				String prevDate = "";
				String firstToken = "";
				String dummyDateString = "";
				StringTokenizer tokenizeColon = null;	
				int ii=0;
				int index=0;
				boolean flag = true;;
				int actualIndex = 0;
				//int wid =100;
				//int widPc = wid/dates.size();
				//int widPc = 100;
				if(dates!=null)
				{
					for(ii=0;ii<dates.size();ii++)
					{
						dt = (String)dates.get(ii);
						tokenizeSpace = new StringTokenizer(dt," ");
						currDate = tokenizeSpace.nextToken();
						if(!currDate.equals(prevDate)){
							
							out.println("<td class='columnHeader' width='"+widPc+"px' id='rowId"+index+"'>"+currDate+"</td>");
							prevDate =currDate;
							actualIndex = index;
							index++;
						}
						else
						{
							
	%>
		<script>
			var rowValue = "<%=actualIndex%>"
				var thRowId = document.getElementById('rowId'+rowValue)
			thRowId.colSpan += 1
					//alert("thRowId.colSpan = "+thRowId.colSpan);
					//alert("thRowId.colSpan = "+thRowId.colSpan);
			
		</script>
	<%				}
					}
					out.println("<input type='hidden' name='noOfHrRows' id='noOfHrRows' value='"+index+"'>");
				}
				String dummyString="";
				String currDate1="";
				String anchorObj = "";
				String anchorObjEnd = "";
				//int wid =100;
				//int widPc = wid/dates.size();
				//out.println("<script>alert('"+widPc+"');</script>");
				//int widPc = Integer.parseInt(width);
			out.println("</tr>");
			out.println("<tr id='divTitleTable1'>");
				if(dates!=null)
				{
					//out.println("<script>alert('"+dates.size()+"');</script>");
					for( ii=0;ii<dates.size();ii++)
					{
						dt = (String)dates.get(ii);
						dummyString=(String)arrayResultType.get(ii);
						//out.println("dummyString = "+dummyString);
						tokenizeSpace = new StringTokenizer(dt," ");
						currDate1 = tokenizeSpace.nextToken();
						currDate = tokenizeSpace.nextToken();
						if(!currDate.equals(prevDate)){
							dummyDateString = currDate1;
							currDate1= currDate1.replace('/','_');
							if(dummyString.equals("S"))currDate="Day Summary";
							if(currDate.equals("Day Summary"))
							{
								anchorObj = "";
								anchorObjEnd = "";								
							}
							else if(!currDate.equals("Day Summary") && errorAuth.equals("A"))
							{
								anchorObj = "<a href='javascript:callAmend(\""+dt+"\")'  title = 'Click here for Amend/Mark as error' >";
								anchorObjEnd = "</a>";
							}
							else
							{
								anchorObj = "";
								anchorObjEnd = "";							
							}
							out.println("<td class='columnHeader'  nowrap width='"+120+"px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+currDate+" "+anchorObjEnd+" </td>");
							prevDate =currDate;							
						}
						else
						{
							if(dummyString.equals("S"))currDate="DAY/SUM";
							out.println("<td class='columnHeader'  width='"+widPc+"px' id='thId"+currDate1+ii+"'>"+currDate+"</td>");
						}
					}
				}
			%>
		</tr>

		<INPUT TYPE="hidden" name="idCount" id="idCount" value='<%=ii%>'>
		<INPUT TYPE="hidden" name="summaryYN" id="summaryYN" value='<%=summaryYN%>'>
		<INPUT TYPE="hidden" name="detailYN" id="detailYN" value='<%=detailYN%>'>
		<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" value='<%=encounterId%>'>
		<INPUT TYPE="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
		<INPUT TYPE="hidden" name="defaultYN" id="defaultYN" value='<%=defaultYN%>'>
		<INPUT TYPE="hidden" name="patientId" id="patientId" value='<%=patientId%>'>
<!-- 		</table>
 -->		

<!-- 		<table border='1' width='100%' id='tb1' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
 -->			<%
				ArrayList cols = new ArrayList();
				ArrayList discrArray = new ArrayList();
				HashMap setOfValues = new HashMap();
				String printVal = "";
				String classValue ="CACHARTQRYEVEN";
				StringBuffer tempStringBuffer = null;
				String result_type = "";
				String discrMsrId = "";
				String tempString = "";
				String tempString1 = "";
				int indexJ = 0;
				String normalStr="",normalRangeColor = "",criticalStr = "";
				String currGroupId ="";
				 String eventDate = "";
				 String tooltip = "";
				String currEventDate="";
				int z =0 ;int indexK = 0;int k=0;

				for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++){
						flag = true;
						index = 0;
						currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
						discrArray	= (ArrayList)hashData.get(currGroupId); 
						out.println("<tr>");
						for(k=0;k<dates.size();k++)
						{
							out.println("<td width='"+widPc+"px' class='CACHARTFOURTHLEVELCOLOR' >&nbsp;</td>");
						}
						out.println("</tr>");
						for(indexK =0 ;indexK <discrArray.size();indexK++)
						{
							discrMsrId = (String)discrArray.get(indexK);
							out.println("<tr id='tdrowId"+indexJ+indexK+"'>");

							cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
							for(k=0,z=0;k<dates.size();k++)
							{
								if(cols != null){
								if(cols.size() > z)
									{
									setOfValues = (HashMap)cols.get(z);
									 eventDate = (String)dates.get(k);
								 	
									 currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
									if(currEventDate.equals(eventDate))
									{
										printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
										//out.println("printVal : " + printVal);
										normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
										normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));

										//out.println("normalRangeColor = "+normalRangeColor);
										//out.println("normalStr = "+normalStr);

										criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
										//out.println("criticalStr = "+criticalStr);
										if(!(normalStr.equals("")) || ! (criticalStr.equals("")))
										{

											tokenizeColon = new StringTokenizer(normalStr,":");
											firstToken = tokenizeColon.nextToken();
											firstToken = tokenizeColon.nextToken().trim();
											tokenizeSpace = new StringTokenizer(firstToken,"~");
										/*	if(tokenizeSpace.nextToken().trim().equals("0") && tokenizeSpace.nextToken().trim().equals("0") )
											{
												flag = false;
											}*/

										}
										result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
										if(result_type.equals("L")){
											if(!printVal.equals("")){
												if(printVal.indexOf("||") !=-1){
														tokenizeSpace =  new StringTokenizer(printVal,"||");
														tempString1 = tokenizeSpace.nextToken();

														tempString = tokenizeSpace.nextToken();
														
														if(tempString.length() > 9)
														{
															tempStringBuffer = new StringBuffer(tempString);
															index=0;
															
																tempStringBuffer = tempStringBuffer.replace(index,index+tempString.length()," <label title='"+tempString+"' class='LABELFORDISCRETE'>"+tempString.substring(0,5) +"..."+" </label> ");
																printVal = tempStringBuffer.toString();
																


														}
														 else
														{
															/*
															done by rajan on 17/01/2006
															index =0;
															tempStringBuffer = new StringBuffer(printVal);
															tempStringBuffer = tempStringBuffer.replace(index,index+"||".length(),"  ");
																printVal = tempStringBuffer.toString();*/
															/*if (tempString.equals ("X"))
																printVal="";
															else*/
																printVal=tempString;

														}	
														/*while((index = tempStringBuffer.toString().indexOf("|"))!=-1)
															{
																tempStringBuffer = tempStringBuffer.replace(index,index+"|".length(),"");
																
															}
														while((index = tempStringBuffer.toString().indexOf("X"))!=-1)
															{
																tempStringBuffer = tempStringBuffer.replace(index,index+"X".length(),"");
																
															}
															printVal = tempStringBuffer.toString();
															*/
														
												}

												printVal = tempString1 + " " + printVal;

											}		
										}
										if(flag==true){
											if(!printVal.equals(""))
											{
												if(!normalStr.equals("") || !criticalStr.equals(""))
												tooltip = normalStr+", "+criticalStr;
												else
												tooltip="";
											}
											else
											{
												tooltip="";
											}
										}
										if(!result_type.equals("S")){
										if(!normalRangeColor.equals(""))
										{
											classValue = normalRangeColor;
											//out.println("<script>alert('normalRangeColor :"+normalRangeColor+"')</script>");
										}
										else
										{
												if((indexK%2)==0)
													classValue	=	"CACHARTQRYEVEN";
												else
													classValue	=	"CACHARTQRYEVEN";
											}
										}
										else if(result_type.equals("S"))
										{

											classValue = "CASUMMARY";

										}

										out.println("<td width='"+widPc+"px' class='"+classValue+"' title='"+tooltip+"' >"+printVal+"</td>");
										
										z++;
										printVal="";
									}
									else
									{
										if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";	
										out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
									}
								}
								else
								{
									if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";
									out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
								}
							}
							else
							{
										if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";
								out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
							}
						}
						
						out.println("</tr>");
					}

			}
			%>

		</table>
	
		</form>
	</body>
	<script>
	if(parent.ChartRecordingDetailFrame != null)
	{
		parent.ChartRecordingDetailFrame.document.body.scroll="no";
		parent.ChartRecordingDetailFrame.document.body.onscroll= "";
	}
	</script>
	<script>//showButton();</script>
 	<script>alignHeight();</script> 
	<script>alignUnitsAndData();</script>
	
	</html>
<%}
	//finalHash.clear();
   // dates.clear();
	//hashData.clear();
    //arrayChartGrp.clear();
   // arrayResultType.clear();
	}
catch(Exception ee)
	{
	//out.println("Exception Here :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
	}%>	

