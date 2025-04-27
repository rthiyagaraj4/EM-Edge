<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/PrivilegeExceptionGrp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formPrivilegeExpGrpList" id="formPrivilegeExpGrpList">
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = "privilegeExceptiongrpbean" ;
	String bean_name = "eOR.PrivilegeExceptionGrpBean";
	//String status="E",key="",readOnly = "",status_db = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",  index="";
	String long_desc="", dispMode="", tabVal="";
	String display_label="",from= "", to ="";
	String exception_type ="", order_category	="", order_type_code="";		
	String  code="";
	String mode="", update_val = "", grp_exception_id="", grp_exception_name="";

	Vector recList = new Vector();

	HashMap select_All = new HashMap();
	boolean isAllPresent = false;

	int classValueCount = 0; // to display classValue alternatively in update mode for 2 for loops...
	//HashMap htRecord = null;

	mode= request.getParameter("mode");
	if(mode==null)mode="1";

	int row_disp=8;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
	//int dbRecordCount = 0;
	
	HashMap htListRecord= new HashMap();
	boolean stats = false, checkRecords = false;
	//boolean alteredRecord = false; alteredDBRecord = false;
	//eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	//eOR.Common.MultiRecordBean MultiRecordBeanNew		= new eOR.Common.MultiRecordBean();




	exception_type		= request.getParameter("exception_type");
	order_category		= request.getParameter("order_category");
	order_type_code		= request.getParameter("order_type_code");
	tabVal				= request.getParameter("tabVal");
	dispMode			= request.getParameter("dispMode") ;
	from				= request.getParameter("from") ;
	to					= request.getParameter("to") ;
	index				= request.getParameter("index");
	grp_exception_id	= request.getParameter("grp_exception_id");
	grp_exception_name	= request.getParameter("grp_exception_name");
		
	/*System.err.println("Index after getParameter   "  + index);	
	if( index == null)
		index = "OTH";
	System.err.println("Index after getParameter   "  + index);	*/

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;
	
	if(index == null || index.equals("null"))index="";	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="S";
	if(exception_type == null || exception_type.equals("null"))exception_type="";
	if(order_category == null || order_category.equals("null"))order_category="";
	if(order_type_code == null || order_type_code.equals("null"))order_type_code="";
	if(grp_exception_id == null || 	grp_exception_id.equals("null"))grp_exception_id="";
	if(grp_exception_name == null || grp_exception_name.equals("null"))	grp_exception_name="";


	if(exception_type.equals("OC")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		index = "A";
	}
	else if(exception_type.equals("OT")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels");
	}
	else if(exception_type.equals("OR")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orderable.label","common_labels");
	}
	

	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	PrivilegeExceptionGrpBean bean = (PrivilegeExceptionGrpBean)getBeanObject( bean_id,  bean_name, request ) ; /* Initialize Function specific end */
 


 	eOR.Common.MultiRecordBean MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();




	//bean.clear();
 	//MultiRecordSet.clearDBRec();	
	/*
	out.println("<script>alert(' index  :"+index+"');</script>");
	out.println("<script>alert(' order_type_code  :"+order_type_code+"');</script>");
	out.println("<script>alert(' order_category  :"+order_category+"');</script>");
	out.println("<script>alert(' tabVal  :"+tabVal+"');</script>");
	out.println("<script>alert(' dispMode  :"+dispMode+"');</script>");
	out.println("<script>alert(' grp_exception_id  :"+grp_exception_id+"');</script>");
	out.println("<script>alert(' grp_exception_name  :"+grp_exception_name+"');</script>");
	out.println("<script>alert(' exception_type  :"+exception_type+"');</script>");
	out.println("<script>alert(' mode  :"+mode+"');</script>");
	*/
		
	try{

		//out.println("<script>alert(' mode  :"+mode+"');</script>");
		if(mode.equals("1")){
			//checkRecords = bean.checkRecords(exception_type, grp_exception_id);
			checkRecords = bean.checkRecords(grp_exception_id);
		}
		
	if( !checkRecords){
		if(dispMode.equals("")){
			if(!exception_type.equals("OC")){
				//dbRecordCount		=
				bean.fetchDBRecords(exception_type.trim(),grp_exception_id.trim());
				//System.err.println("Rec Count if   " + dbRecordCount);
			}else{
				if(mode.equals("2")){
				//dbRecordCount		= 
					bean.fetchDBRecords(exception_type.trim(), grp_exception_id.trim());
					//System.err.println("Rec Count  else  " + dbRecordCount);
				}
			}
	//Added by Subhash on 15th April////
	//Start
	
	
//	MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();	 
	
	if (mode.equals("1"))
	{
			//System.err.println("Before adding All");
			//System.err.println("Mode @@@@@@@@@ " + mode);				
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			int size = MultiRecordSet.getSize("DB");
			if( size == 0 )
			{
				//System.err.println("Size ================= 0 ");
				select_All.put("status","N");
				select_All.put("long_desc","All");
				select_All.put("valid","N");
				select_All.put("code","*All");
				select_All.put("associate_yn","N");
				//boolean ret = 
				MultiRecordSet.putObject(select_All);
				//System.err.println("Rec Inserted into MultiRecBean   " + ret );

				select_All = null;
			}
			else
			{
				for(int i=0;i<MultiRecordSet.getSize("DB");i++)
				{
					htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					code	=	(String)	htListRecord.get("code");
					if(!code.equalsIgnoreCase("*All"))
					{
						isAllPresent = false;
						//System.err.println("@@@@@@@@@@@@  != All ");
					}
					else
					{
						isAllPresent = true;
						//System.err.println("@@@@@@@@@@@@  == All ");
						break;
					}
				}
				if( isAllPresent == false)
				{
					//System.err.println("@@@@@@@@@@@@@@@ Anyway Adding All to Bean @@@@@@@@@@@@@");
					select_All.put("status","N");
					select_All.put("long_desc","All");
					select_All.put("valid","N");
					select_All.put("code","*All");
					select_All.put("associate_yn","N");
					//boolean ret = 
					MultiRecordSet.putObject(select_All);
					//System.err.println("Rec Inserted into MultiRecBean   " + ret );
	
					select_All = null;
				}
			}

			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//System.err.println("After adding All");		
			
			//System.err.println("After displaying All");		
		
		}	
	//End  	
	
			//out.println("<script>alert('dbRecordCount :"+dbRecordCount+"');</script>");

			//if(dbRecordCount == 0){

	if(tabVal.equals("S")){
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,exception_type,order_type_code,order_category);	
		row_count			=	MultiRecordSet.getSize("SELECT");
	}else if(tabVal.equals("A")){
		//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,exception_type,order_type_code,order_category);	
		//row_count			=	MultiRecordSet.getSize("SELECT");
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
			
	if (mode.equals("2") && !exception_type.equals("OC"))
	{
			//System.err.println("Before adding All");
			//System.err.println("Mode @@@@@@@@@ " + mode);				
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//MultiRecordSet.clearDBRec();
			int size = MultiRecordSet.getSize("DB");
			if( size == 0 )
			{
				//System.err.println("Size ================= 0 ");
				select_All.put("status","N");
				select_All.put("long_desc","All");
				select_All.put("valid","N");
				select_All.put("code","*All");
				select_All.put("associate_yn","N");
				//boolean ret =
				MultiRecordSet.putObject(select_All);
				//System.err.println("Rec Inserted into MultiRecBean   " + ret );

				select_All = null;
			}
			else
			{
				for(int i=0;i<MultiRecordSet.getSize("DB");i++)
				{
					htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					code	=	(String)	htListRecord.get("code");
					if(!code.equalsIgnoreCase("*All"))
					{
						isAllPresent = false;
						//System.err.println("@@@@@@@@@@@@  != All ");
					}
					else
					{
						isAllPresent = true;
						//System.err.println("@@@@@@@@@@@@  == All ");
						break;
					}
				}
				if( isAllPresent == false)
				{
					for(int i=0;i<MultiRecordSet.getSize("DB");i++)
					{
						htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
						if(htListRecord != null)
						{
							recList.add(i,htListRecord);
						}
						//MultiRecordSet.removeObject(i);
					}
					//boolean x =
					MultiRecordSet.clearDBRec();
					//System.err.println("clear success    " + x);
					
					//System.err.println("@@@@@@@@@@@@@@@ Anyway Adding All to Bean @@@@@@@@@@@@@");
					select_All.put("status","N");
					select_All.put("long_desc","All");
					select_All.put("valid","N");
					select_All.put("code","*All");
					select_All.put("associate_yn","N");
					//boolean ret =
					MultiRecordSet.putObject(select_All);
					//System.err.println("Rec Inserted into MultiRecBean   " + ret );
					select_All = null;
					//boolean ret1 = false;
					for(int i=0;i<recList.size();i++)
					{
						//ret1 = 
							MultiRecordSet.putObject((HashMap )recList.get(i));
					}
				}
			}
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//System.err.println("After adding All");		
			
			//System.err.println("After displaying All");		
		  }	
			row_count			=  MultiRecordSet.getSize("DB");
		}
			
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
		//row_count			=  MultiRecordSet.getSize("DB");
		//System.err.println("Row Count @@@@@@@&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@ " + row_count);
		%>
				
			<script>
				if('<%=row_count%>' <= 0)
				{
					if(!<%=tabVal.equals("A")%>)
					{
						var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");	
						parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
					}
					else
					{
						if(<%= mode.equals("2") %>)
						{
							var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");	
							parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
						}
					}
			}
			</script>
			<%
		/*}else{
			%->
			<script>
			var msg = getMessage("CODE_ALREADY_EXISTS");	
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			</script>
			<-%
		}*/
		}else{
			
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		
		if((dispMode.trim()).equalsIgnoreCase("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if((dispMode.trim()).equalsIgnoreCase("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
	
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		
		MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
		
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				//alteredRecord =
				MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				//alteredDBRecord =
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
	%>
		
	<table cellpadding='3' cellspacing='0' border='0' width='100%'>
	<tr align='right' width='10%'>
	<td class='WHITE'>
	<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
	<A class='gridlink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		
	<%	
	}

	if ( !( (start+row_disp) > row_count ) ){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
						
	<%
	}
	%>
	</td>
	</tr>
	</table> 
	<table cellspacing='0' cellpadding='3' width='100%' border='1' align="center">
	<td class='columnheader' width="75%"><%=display_label%></td><td class='columnheader' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<%
		//String all = "N";
		if(tabVal.equals("S")){
			
			for(int i=fm_disp; i<=to_disp; i++){
			classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
			htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
									
			code				=	(String)	htListRecord.get("code");
			long_desc			=	(String)	htListRecord.get("long_desc");
			valid				=	(String)	htListRecord.get("valid");
			associate_yn		=	(String)	htListRecord.get("associate_yn");

			if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
			//status			=	(String)    htListRecord.get("status");
			stats  				=	MultiRecordSet.containsObject(code);

			if(stats){
				valid = MultiRecordSet.getValidKey(code);
			}
			/********************/
			if(valid.equals("Y")){
				checkValue="checked";
				disabled="disabled";
			}else{
				if(associate_yn.equals("Y")){
					checkValue="checked";
					disabled="";
				}else{
					if((stats)&&(associate_yn.equals("N"))){
						checkValue="checked";
						disabled="";
					}else{
						checkValue="";
						disabled="";
					}
				}
			}
			/**********************/
				
			//out.println("valid :"+valid);
			//out.println("associate_yn :"+associate_yn);
			//out.println("stats :"+stats);
				
			tblrow_id	=	"tblrow_id"+i;
			%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>'><%=((long_desc.equals(""))?"&nbsp;":long_desc)%>
			</td>
			<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%>></td>
			<!--input type=hidden name='strHidden<%=i%>' value="">-->
			</tr>
			<%
			}
			}else if(tabVal.equals("A")){
				
			Vector codeVector = new Vector();
			String strHidden = "";				
			
		//to_disp = MultiRecordSet.getSize("DB");
		//System.err.println("Before Printing #@#@#@#@#@@@     " + to_disp);

		for(int i=fm_disp; i<=to_disp; i++)
				{
					strHidden = "";
					classValue			=	( (i%2)==0 )? "QRYEVEN" : "QRYODD";
					htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					//System.err.println(" List Record @@@@@@@@@@@  " + htListRecord );
					if(htListRecord == null)
					{
						//htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
						break;
					}
					code				=	(String)	htListRecord.get("code");
					//strHidden = strHidden + code + "$";
					codeVector.add( code );
					long_desc			=	(String)	htListRecord.get("long_desc");
					valid				=	(String)	htListRecord.get("valid");
					associate_yn		=	(String)	htListRecord.get("associate_yn");
				//	status_db			=	(String)	htListRecord.get("status");

		
					tblrow_id	=	"tblrow_id"+i;
					if(valid.equals("N")){
						if(associate_yn.equals("Y"))
							checkValue="checked";
						else 
							checkValue="";
					}
					else{
						if(associate_yn.equals("D"))
							checkValue="";
						else 
							checkValue="checked";
					}
					%>
					
					<tr id='<%=tblrow_id%>'>
					<%if(valid.equals("Y")){%>
						<td class='<%=classValue%>' ><b><%=((long_desc.equals(""))?"&nbsp;":long_desc)%></b></td>
					<%}else{%>
						<td class='<%=classValue%>' ><%=((long_desc.equals(""))?"&nbsp;":long_desc)%></td>
					<%}%>
					<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>
					<!--<input type=hidden name='strHidden<%=i%>' id='strHidden<%=i%>' value=<%= strHidden %> >-->
					</tr>
					<%
						classValueCount++;
			  }

			

							
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	
		
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	

		 }
		}else{
		%>
		<script>
		var msg = getMessage("CODE_ALREADY_EXISTS","common");	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		</script>
		<%
		}
	}
	catch(Exception e){
		//e.printStackTrace();
		System.out.println("Exception@ : " + e);
	}
	%>
	</table>
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name%>">
	<input type="hidden" name="dispMode" id="dispMode" value="<%=dispMode%>" > 
	<input type="hidden" name="tabVal" id="tabVal" value="<%=tabVal%>">
	<input type="hidden" name="exception_type" id="exception_type" value="<%=exception_type%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="select_All" id="select_All" value="*All">
	</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

