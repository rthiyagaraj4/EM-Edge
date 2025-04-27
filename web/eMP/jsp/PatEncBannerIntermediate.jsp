<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String newLineNum = request.getParameter("newLineNum") == null ? "" : request.getParameter("newLineNum");
	String dispLine = request.getParameter("dispLine") == null ? "" : request.getParameter("dispLine");
	String dispOrder = request.getParameter("dispOrder") == null ? "" : request.getParameter("dispOrder");
	String maxOrderForLine1 = request.getParameter("maxOrderForLine1") == null ? "" : request.getParameter("maxOrderForLine1");
	String maxOrderForLine2 = request.getParameter("maxOrderForLine2") == null ? "" : request.getParameter("maxOrderForLine2");
	String concatMapValues = request.getParameter("concatMapValues") == null ? "" : request.getParameter("concatMapValues");
	String sentFromLineChange = request.getParameter("sentFromLineChange") == null ? "N" : request.getParameter("sentFromLineChange");
	String firstDispOrderVal = request.getParameter("firstDispOrderVal") == null ? "1" : request.getParameter("firstDispOrderVal");
	String bannerCateg = request.getParameter("bannerCateg") == null ? "P" : request.getParameter("bannerCateg");
	String bannerRef = request.getParameter("bannerRef") == null ? "U01" : request.getParameter("bannerRef");


	eMP.PatientBannerGroupLine patBannerGrpBean = null;

	patBannerGrpBean = (eMP.PatientBannerGroupLine)getObjectFromBean("patBannerGrpBean","eMP.PatientBannerGroupLine",session);

	if(sentFromLineChange.equals("Y"))
	{
		try
		{
			ArrayList list1 = patBannerGrpBean.returnList1();
			ArrayList list2 = patBannerGrpBean.returnList2();

			if(list1 == null) list1 = new ArrayList();
			if(list2 == null) list2 = new ArrayList();

			String arrayValues[] = concatMapValues.split("`");	
			StringTokenizer strTok = null;
			String listValues = "";
			String changedDispOrdVals = "";
			String LineNumDup = "";
			String defSelDup = "";
			String dispOrdDup = "";
			
			if(dispLine.equals("1"))
			{
				concatMapValues = newLineNum+"`"+arrayValues[1]+"`"+(Integer.parseInt(maxOrderForLine2)+1)+"`"+arrayValues[3]+"`"+arrayValues[4]+"`"+arrayValues[5]+"`"+arrayValues[6]+"`"+arrayValues[7]+"`"+arrayValues[8]+"`"+arrayValues[9]+"`"+arrayValues[10]+"`"+arrayValues[11]+"`"+arrayValues[12];
				list2.add(concatMapValues);

				list1.remove((Integer.parseInt(dispOrder) - 1));
				putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
				
				list1 = patBannerGrpBean.returnList1();
				int arrSize = list1.size();

				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list1.get(i);
					list1.remove(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}
					list1.add(i,changedDispOrdVals);
				}
			}
			else if(dispLine.equals("2"))
			{
				concatMapValues = newLineNum+"`"+arrayValues[1]+"`"+(Integer.parseInt(maxOrderForLine1)+1)+"`"+arrayValues[3]+"`"+arrayValues[4]+"`"+arrayValues[5]+"`"+arrayValues[6]+"`"+arrayValues[7]+"`"+arrayValues[8]+"`"+arrayValues[9]+"`"+arrayValues[10]+"`"+arrayValues[11]+"`"+arrayValues[12];
				list1.add(concatMapValues);
				list2.remove((Integer.parseInt(dispOrder) - 1));
				putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
				
				list2 = patBannerGrpBean.returnList2();

				if(list1 == null) list1 = new ArrayList();
				if(list2 == null) list2 = new ArrayList();

				int arrSize = list2.size();

				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list2.get(i);
					list2.remove(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}
					list2.add(i,changedDispOrdVals);
				}
			}
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
	}//end of try
	catch(Exception e)
	{
		
		e.printStackTrace(System.err);
	}
	%>		
		<script>
			parent.patEncBannerDetailsFrame.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?loadFirstTime=No&oldDispLine=<%=dispLine%>&bannerCateg=<%=bannerCateg%>&bannerRef=<%=bannerRef%>';
		</script>
<%
	}//end of if sentFromLineChange
	else if(sentFromLineChange.equals("N"))
	{
		ArrayList list = new ArrayList();
		if(dispLine.equals("1"))
			list = patBannerGrpBean.returnList1();
		else if(dispLine.equals("2"))
			list = patBannerGrpBean.returnList2();


		int arrSize = list.size();
		StringTokenizer strTok = null;
		String listValues = "";
		String changedDispOrdVals = "";
		String LineNumDup = "";
		String defSelDup = "";
		String dispOrdDup = "";
		try
		{
			if(Integer.parseInt(firstDispOrderVal) < Integer.parseInt(dispOrder))
			{
				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) < Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+dispOrdDup+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) == Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrder)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) > Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}

					}//end of while

					if(i < (Integer.parseInt(dispOrder)-2))
					{
						list.remove(i);
						if(Integer.parseInt(dispOrdDup) != Integer.parseInt(firstDispOrderVal))
						{
							list.add(i,changedDispOrdVals);
						}
						else
						{
							list.add((Integer.parseInt(dispOrder)-2),changedDispOrdVals);
							i--;
						}
					}
				}//end of for
			}//end of if
			else
			{
				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) < Integer.parseInt(dispOrder) || (Integer.parseInt(dispOrdDup) > Integer.parseInt(firstDispOrderVal)))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+dispOrdDup+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if((Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder)) && (Integer.parseInt(dispOrdDup) < Integer.parseInt(firstDispOrderVal)))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup) +1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) == Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrder))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}//end of while
					list.remove(i);
					if(Integer.parseInt(dispOrdDup) != Integer.parseInt(firstDispOrderVal))
					{
						list.add(i,changedDispOrdVals);
					}
					else
					{
						list.add((Integer.parseInt(dispOrder)-1),changedDispOrdVals);
					}
				}//end of for
			}//end of else
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
		}//end of catch

		putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
	%>
		<script>
			parent.patEncBannerDetailsFrame.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?loadFirstTime=No&bannerRef=<%=bannerRef%>&bannerCateg=<%=bannerCateg%>';
		</script>
	<%
	}//end of else sentFromLineChange
	else if(sentFromLineChange.equals("fromTextObj"))
	{
		String objValue = request.getParameter("objValue") == null ? "" : request.getParameter("objValue");
		if(objValue.equals("")){
			objValue = " ";
		}else{
			objValue=java.net.URLDecoder.decode(objValue,"UTF-8");
		}
		String objType = request.getParameter("objType") == null ? "" : request.getParameter("objType");
		String concatVals = "";

		try
		{
			ArrayList list = new ArrayList();
			if(dispLine.equals("1"))
				list = patBannerGrpBean.returnList1();
			else if(dispLine.equals("2"))
				list = patBannerGrpBean.returnList2();

			String listValues = (String) list.get((Integer.parseInt(dispOrder)-1));

			list.remove((Integer.parseInt(dispOrder)-1));

			String arrayVals[] = listValues.split("`");

			if(objType.equals("dispLenTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+objValue+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("numSpacesTxt"))
			{
				if(objValue.equals(" ")) objValue = "0";
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+objValue+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("dispTextTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+objValue+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("toolTipTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+objValue+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			list.add((Integer.parseInt(dispOrder)-1),concatVals);
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
		}//end of try
		catch(Exception ee)
		{
			
			ee.printStackTrace(System.err);
		}//end of catch
	}//end of if sentFromLineChange = fromTextObj
	else if(sentFromLineChange.equals("sel"))
	{
		String selValue = request.getParameter("selValue") == null ? "N" : request.getParameter("selValue");
		ArrayList list = new ArrayList();
		try
		{
			if(dispLine.equals("1"))
				list = patBannerGrpBean.returnList1();
			else if(dispLine.equals("2"))
				list = patBannerGrpBean.returnList2();

			String listValues = (String) list.get((Integer.parseInt(dispOrder)-1));
			list.remove((Integer.parseInt(dispOrder)-1));
			String arrayVals[] = listValues.split("`");

			String concatVals = arrayVals[0]+"`"+selValue+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];

			list.add((Integer.parseInt(dispOrder)-1),concatVals);
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
		}//end of try
		catch(Exception e)
		{
			
			e.printStackTrace(System.err);
		}
	}//end of if sentFromLineChange = sel
%>
