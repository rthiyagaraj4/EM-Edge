<!DOCTYPE html>
<%@page import="eCA.*,java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%! int row_count = 0; %>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;	
	//String locale = (String) p.getProperty("LOCALE");
%>

	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../js/DefaultTranscriberSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int row_disp = 12;
	int start = 0 ;
	int end = 0 ;
	int fm_disp = 0, to_disp = 0;

	String bean_id = "CATranscriberSetupBean" ;
	String bean_name = "eCA.CATranscriberSetupBean";
	String tblrow_id = "", checkValue = "";
	String disabled = "", classValue  = "", valid = "";
	String associate_yn = "", index = ""; 

	HashMap htListRecord = new HashMap();
	String from = "", to = "" ;
	String catalog_desc = "", dispMode = "", tabVal = "";
	String group_by = "",  code = "";
	String transcriber_id = "";
	String associate_yn1 = "";
	
	boolean stats = false;
	String update_val = "";
	String display_hdr = "";

	eCA.CAMultiRecordBean MultiRecordSet = new eCA.CAMultiRecordBean();
	
	tabVal			=	request.getParameter("tabVal") == null ? "" : request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") == null ? "" : request.getParameter("dispMode");
	group_by		=	request.getParameter("group_by") == null ? "" : request.getParameter("group_by");
	index			=	request.getParameter("index") == null ? "" : request.getParameter("index");
	transcriber_id	=	request.getParameter("transcriber_id") == null ? "" : request.getParameter("transcriber_id");

	from			=	request.getParameter("from");
	to				=	request.getParameter("to");

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;
	else
		end = Integer.parseInt( to ) ;

	CATranscriberSetupBean bean = (CATranscriberSetupBean)getObjectFromBean( bean_id,bean_name, session ) ;
	
	if(group_by.equals("PC"))
	{
		bean.clearDBRec();
	}
		
	if(dispMode.equals(""))
	{
		bean.fetchDBRecords(group_by,transcriber_id);
		
		if(tabVal.equals("S"))
		{
			MultiRecordSet		= (eCA.CAMultiRecordBean)bean.getRecordSet(index,group_by);	
			row_count			= MultiRecordSet.getSize("SELECT");
		}
		else if(tabVal.equals("A")){
			MultiRecordSet		= (eCA.CAMultiRecordBean)bean.getBean();
			row_count			= MultiRecordSet.getSize("DB");
		}

		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
			to_disp = (row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
%>

		<script>
			if('<%=row_count%>' <= 0)
			{
				var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');	
				parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
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
		}
		else if(dispMode.equals("Previous"))
		{
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		MultiRecordSet	 =(eCA.CAMultiRecordBean)bean.getBean();
	
		for(int j=from_val; j<=to_val; j++)
		{
			update_val = request.getParameter("select_yn"+j);
			associate_yn1 = request.getParameter("associate_yn"+j);
			
			if(update_val == null || update_val.equals("null"))
			{
				update_val = "N";
			}
			if(tabVal.equals("S"))
			{
				if(!associate_yn1.equals("A"))
					MultiRecordSet.setBeanValue(j,update_val);
			}
			else if(tabVal.equals("A"))
			{
				MultiRecordSet.setDBBeanValue(j,update_val);
			}
		}
			
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	if (group_by.equals("SP"))
		display_hdr = "Common.speciality.label";		
	else if (group_by.equals("PR"))
		display_hdr = "Common.practitioner.label";
	else if (group_by.equals("PC"))
		display_hdr = "Common.patientclass.label";

%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
<form name="formDefaultTransSetupDtl" id="formDefaultTransSetupDtl">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
<%
	
	if ( (!(start <= 1)) && (start < row_count))
	{
%>
		<A class="gridLink" HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%	
	}
	if ( !( (start+row_disp)+1 > row_count ) )
	{
%>
		<A class="gridLink" HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
	}
%>
	</td>
	</tr>
	</table> 
	
	<table class='grid' border='1' cellpadding='3' cellspacing='0' width='100%' align='center' style="text-align:left;">
	<th class='columnheader' width='75%'><fmt:message key="<%=display_hdr%>" bundle="${common_labels}"/></th>
	<th class='columnheader' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
	try
	{
		if(tabVal.equals("S"))
		{		
			for(int i=fm_disp; i<=to_disp; i++)
			{
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
										
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("description");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");

				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				stats  				=	MultiRecordSet.containsObject(code);
				
				if(stats)
				{
					valid = MultiRecordSet.getValidKey(code);
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
						if((stats)&&(associate_yn.equals("N")) )
						{
							checkValue="checked";
							disabled="";
						}
						else if(associate_yn.equals("A"))
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

				tblrow_id	=	"tblrow_id"+i;
%>
			
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' onclick='validate(this,<%=i%>)' <%=checkValue%><%if(!group_by.equals("PC")){%> <%=disabled%><%}else{
				if(!valid.equals("Y")&&associate_yn.equals("A"))%><%=disabled%><%}%>></td>
				<input type='hidden' name='associate_yn<%=i%>' id='associate_yn<%=i%>' value='<%=associate_yn%>'>
				</tr>
				<!--else if(group_by.equals("PC")&&associate_yn.equals("A")){%><%=disabled%> -->
<%
			}
		}
		else if(tabVal.equals("A"))
		{
			disabled="disabled";
			for(int i=fm_disp; i<=to_disp; i++)
			{
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("description");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
			
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
				{
%>
					<td class='<%=classValue%>'><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b></td>
<%
				}
				else
				{
%>
					<td class='<%=classValue%>'><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
<%
				}
%>	
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>
				</tr>
<%
			}
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
%>
	</table>
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>
	<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">
	</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

