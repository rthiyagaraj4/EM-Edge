<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!-- Created by Uma on 9/9/2009 for  SRR20056-SCF-3386 IN013057--> 
<%@page import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%!int row_count=0;%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/CatalogsBySection.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function doit(check,textbox)
	{
		if(!(check.checked))
		{
			textbox.value="";
		}
	}
	</script>
</head>
<%
	int  fm_disp=0, to_disp=0 ,noOfRecords=0,previousRecord=0, nextRecord =0;
	String bean_id = "catalogsBySection" ;
	String bean_name = "eOR.CatalogsBySection";
	CatalogsBySection CatalogBean = (CatalogsBySection)getBeanObject( bean_id,  bean_name, request ) ;
	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	String classValue ="";
	String nextPrevFlag	= ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	previousRecord		= ChkDef.defaultInt(request.getParameter("previousRecord"));
	nextRecord			= ChkDef.defaultInt(request.getParameter("nextRecord"));
	String order_category		  = request.getParameter("order_category");
	String tick_sheet_id		  = request.getParameter("tick_sheet_id");
	String section_code			  = request.getParameter("section_code");
	//String act					  =	request.getParameter("action");
	String dispMode					  =	request.getParameter("dispMode");
	String tabVal					  =	request.getParameter("tabVal");
	//String search_text					  =	request.getParameter("search_text")==null?"":request.getParameter("search_text");
	row_count					  =	Integer.parseInt(request.getParameter("row_count")==null?"0":request.getParameter("row_count"));
	String fpp_yn					  =	request.getParameter("fpp_yn");//IN072524 
	String order_catalog_code = "";
	String tblrow_id = "";
	//String order_type_list_code = "";
	//String order_type_sel = "";
	//String order_type_list_desc = "";
	String valid = "";
	String associate_yn = "";
	//String status = "";
	//String tick_sheet_seq_num = "";
	String order_catalog_desc = "";
	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	boolean stats = false;
	String update_val = "";
	String seq_num = "";
	String catalog_code = "";
	String ord_type_code = "";
	//String sel = "";
	String checkValue = ""; 
	String disabled = "";
	int row_disp=7;
	int start = 0 ;
	int end = 0 ;
	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="S";

	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(dispMode.equals(""))
	{
		CatalogBean.fetchDBRecords(request);
		if(tabVal.equals("S"))
		{
			MultiRecordSet		= (eOR.Common.MultiRecordBean)CatalogBean.getRecordSet(request);			
			row_count			=	MultiRecordSet.getSize("SELECT");
		}
		else if(tabVal.equals("A"))
		{
			MultiRecordSet		= (eOR.Common.MultiRecordBean)CatalogBean.getBean();
			row_count			=  MultiRecordSet.getSize("DB");

		}
	
	fm_disp	=	0;
	to_disp	=	(row_disp-1);
	if(to_disp > (row_count-1))
	to_disp=(row_count-1);

	from = ""+(start - 1);
	to   = ""+(end - 1);
	%>
	<script>
		if('<%=row_count%>' <= 0)
		{
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}
	else
	{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next"))
		{

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if(dispMode.equals("Previous"))
		{

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}

		if(to_val > (row_count-1))
			to_val=(row_count-1);

		MultiRecordSet	 =(eOR.Common.MultiRecordBean)CatalogBean.getBean();

		for(int j=from_val; j<=to_val; j++)
		{
			update_val = request.getParameter("include"+j);
			seq_num = request.getParameter("tick_sheet_seq_num"+j);
			catalog_code = request.getParameter("catalog_code"+j).trim();
			
			ord_type_code = request.getParameter("order_type_code"+j).trim();
			if(update_val == null || update_val.equals("null"))
			{
				update_val = "N";
			}
			if(tabVal.equals("S"))
			{
				CatalogBean.setBeanItemValue(j,seq_num,update_val,catalog_code,ord_type_code);
			}
			else if(tabVal.equals("A"))
			{
				CatalogBean.setDBBeanItemValue(j,seq_num,update_val,catalog_code,ord_type_code);
			}
		}
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);		
	}

	try
 {
	
	%>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()"  onLoad="parent.parent.setDetailPageMode('s')"  STYLE="overflow-y:hidden">
<form name="CatalogsBySectionDetail" id="CatalogsBySectionDetail"  action='../../eOR/jsp/CatalogsBySectionDetail.jsp'>
<!----------      Next Previous Logic     ------------------------>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='WHITE' align="right">
 <%
	if ( (!(fm_disp <= 1)) && (fm_disp < row_count))
	{
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%
	}

	if ( !( (fm_disp+row_disp) >= row_count ) )
	{
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%
	}

	%>
	
	 </td>
	</tr>
</table>
<!----------------END OF THE PREVOIUS NEXT  ---------------------------->
<table class='grid' width='100%'>
	<th class='columnheader' width='35%' style="text-align:left;"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width='35%'  style="text-align:left;"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width='15%'  style="text-align:left;"><fmt:message key="eOR.SeqNum.label" bundle="${or_labels}"/></th>
	<th class='columnheader' width='15%'  style="text-align:left;"><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
<%
	if(tabVal.equals("S"))
	{
			ArrayList allRecords=null;
			HashMap tempHash=null;
			HashMap split=null;
			//String[] record = null;
			for(int i=fm_disp; i<=to_disp; i++)
			{

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
				order_catalog_code	= (String)	htListRecord.get("order_catalog_code");
				order_catalog_desc		= (String)	htListRecord.get("order_catalog_desc");
				section_code		=	(String)	htListRecord.get("section_code");
				//String code = "";
				//String performing_locn = "";
				//String catalog_desc = "";

				String orderCatalog =(String)htListRecord.get("order_catalog_desc");
				ArrayList val  =(ArrayList)htListRecord.get("order_type_list_code") ;
				ArrayList desc =(ArrayList)htListRecord.get("order_type_list_desc") ;
				String select  =(String)htListRecord.get("order_type_sel");
				String seqNo   =(String)htListRecord.get("tick_sheet_seq_num");
				//String include =(String)htListRecord.get("associate_yn");
				String temp_order_catalog_code = "";

				
				valid   = "";
				String DataBaseRecord ="";
				if(tabVal.equals("S"))
				{
					valid		   =(String)htListRecord.get("valid");
				}
				else
				{
					valid		   ="";
					if(tabVal.equals("S"))
						if(((String)htListRecord.get("valid")).equalsIgnoreCase("Y"))
						DataBaseRecord = "<B>" ;
				}
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				int intLocn = -1;
					try 
					{
						allRecords = new ArrayList();
						allRecords = MultiRecordSet.getAllDBRecords();
						
						tempHash = new HashMap();
						java.util.HashMap hash = new java.util.HashMap();
						tempHash.put("order_catalog_code",order_catalog_code);
						if(allRecords!=null)
						{
							for(int z=0; z<allRecords.size();z++)
							{
								hash =(java.util.HashMap)MultiRecordSet.getObject(z);
								temp_order_catalog_code = (String)hash.get("order_catalog_code");
								if(temp_order_catalog_code.equals(order_catalog_code))
								{
									intLocn = z;
									break;
								}
							}
						}
						
						if(intLocn!=-1)
						{
							split			= (HashMap)allRecords.get(intLocn);
							if(temp_order_catalog_code.equals(order_catalog_code))
							{
								stats = true;
								seqNo			= (String) split.get("tick_sheet_seq_num");
								valid			= (String) split.get("valid");
							}
							else
							{
								stats = false;
							}
						}
						else
						{
							stats = false;
						}
					} 
					catch (Exception e) 
					{
						
					}
					

				
				
				if(valid.equals("Y"))
				{
					checkValue="checked";
             	  	disabled="disabled";
					
				}
				else
				{
					if(associate_yn.equals("Y"))
					{
						checkValue="checked";
						disabled="";
					}
					else
					{
						if((stats)&&(associate_yn.equals("N")))
						{
							checkValue="checked";
							disabled="";
						}
						else
						{
							if(associate_yn.equals("A"))
							{
								
								checkValue="";
								disabled="disabled";
							}
							else
							{
								checkValue="";
								disabled="";
							}
						}
					}
				}


				tblrow_id	=	"tblrow_id"+i;

				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>'><%=orderCatalog%><input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=order_catalog_code%>"></td>
				<td class='<%=classValue%>'><select name='ord_type_code<%=i%>' id='ord_type_code<%=i%>' <%=eHISFormatter.disabled("y",valid)%>>	<%=eHISFormatter.populateList(val,desc,select)%></select><input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value="<%=val.get(0)%>"></td>
				<td class='<%=classValue%>'><input type='text' name='tick_sheet_seq_num<%=i%>' id='tick_sheet_seq_num<%=i%>'  onKeyPress="return ChkNumberInput(this,event,'0');" onblur='checkDecimal(this)' size=4 maxlength=4 <%=eHISFormatter.disabled("y",valid)%>  value='<%=seqNo%>' style="text-align:right"></td>
				<td class='<%=classValue%>'><input type='checkbox' name='include<%=i%>' id='include<%=i%>' value='Y'    <%out.println(checkValue);%><%out.println(disabled);%> onClick='doit(this,tick_sheet_seq_num<%=i%>)'></td>
				</tr>
				<%
				}
			}
			else if(tabVal.equals("A"))
			{
				//String[] record = null;
				for(int i=fm_disp; i<=to_disp; i++)
				{
					classValue			=	( (i%2)==0 )? "gridData" : "gridData";
					htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					order_catalog_code	= (String)	htListRecord.get("order_catalog_code");
					order_catalog_desc		= (String)	htListRecord.get("order_catalog_desc");
					section_code		=	(String)	htListRecord.get("section_code");
					//String code = "";
					//String performing_locn = "";
					//String catalog_desc = "";

					String orderCatalog =(String)htListRecord.get("order_catalog_desc");
					ArrayList val  =(ArrayList)htListRecord.get("order_type_list_code") ;
					ArrayList desc =(ArrayList)htListRecord.get("order_type_list_desc") ;
					String select  =(String)htListRecord.get("order_type_sel");
					String seqNo   =(String)htListRecord.get("tick_sheet_seq_num");
					//String include =(String)htListRecord.get("associate_yn");


				tblrow_id	=	"tblrow_id"+i;

				if(valid.equals("N"))
				{
					if(associate_yn.equals("Y"))
						checkValue="checked";
					else
						checkValue="";
				}
				else
				{
					if(associate_yn.equals("D"))
						checkValue="";
					else
						checkValue="checked";
				}

				%>
				<tr id='<%=tblrow_id%>'>
				<%
				if(valid.equals("Y"))
				{%>
					<td class='<%=classValue%>'><b><%=((orderCatalog.equals(""))?"&nbsp;":orderCatalog)%></b><input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=order_catalog_code%>"></td>
				<%
				}
				else
				{
				%>
						<td class='<%=classValue%>'><%=((orderCatalog.equals(""))?"&nbsp;":orderCatalog)%><input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=order_catalog_code%>"></td>
				<%
				}
				%>
				<td class='<%=classValue%>'><select name='ord_type_code<%=i%>' id='ord_type_code<%=i%>' <%=eHISFormatter.disabled("y",valid)%>>	<%=eHISFormatter.populateList(val,desc,select)%></select><input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value=""></td>
				<td class='<%=classValue%>'><input type='text' name='tick_sheet_seq_num<%=i%>' id='tick_sheet_seq_num<%=i%>'  onKeyPress="return ChkNumberInput(this,event,'0');" onblur='checkDecimal(this)' size=4 maxlength=4 <%=eHISFormatter.disabled("y",valid)%>  value='<%=seqNo%>' style="text-align:right"></td>
				<td class='<%=classValue%>'><input type='checkbox' name='include<%=i%>' id='include<%=i%>' value='Y'    <%=checkValue%> onClick='doit(this,tick_sheet_seq_num<%=i%>)'></td>

				</tr>
				<%
				}
			}
 }catch(Exception e)
{
	System.out.println("Exception@2: "+e);
}
%>
<table>
<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type='hidden' name='nextPrevFlag' id='nextPrevFlag' value='<%=nextPrevFlag%>' >
<input type="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">
<input type='hidden' name='previousRecord' id='previousRecord' value='<%=fm_disp%>' >
<input type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>' >
<input type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>' >
<input type='hidden' name='nextRecord' id='nextRecord' value='<%=to_disp%>' >
<input class='fields' type="hidden" name="from" id="from" value="<%=from%>">
<input class='fields' type="hidden" name="to" id="to" value=<%=to%>>
<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>' >
<input type='hidden' name='tick_sheet_id' id='tick_sheet_id' value='<%=tick_sheet_id%>' >
<input type='hidden' name='section_code' id='section_code' value='<%=section_code%>' >
<input type='hidden' name='OrderCatalogIndex' id='OrderCatalogIndex' value='' >
<input type="hidden" name="function_id" id="function_id" value="<%=CatalogBean.getFunctionId()%>">
<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=CatalogBean.getDetailPageMode()%>' >
<input type='hidden' name='action' id='action' value='<%=CatalogBean.getAction()%>' >
<input class='fields' type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>
<input class='fields' type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%>>
<input class='fields' type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<input class='fields' type='hidden' name='fpp_yn' id='fpp_yn' value="<%=fpp_yn%>"><!-- IN072524 -->
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,CatalogBean,request); 
%>

