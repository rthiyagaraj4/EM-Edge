<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="chiefcomplnt" class="eCA.ChiefComplaintSplty" scope='session'/>

<%!int row_count=0;%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintSplty.js'></script>

</head>
<%
	int row_disp=12;
	int start = 0 ;
	int end = 0 ;
	String from= "", to ="" ;
	int fm_disp=0, to_disp=0;

	String classValue;
	String dispMode;
	ArrayList arr=new ArrayList();
	int modval=0;
	String index = request.getParameter( "index")==null?"":request.getParameter( "index" ) ;
	String tabVal = request.getParameter( "tabVal")==null?"":request.getParameter( "tabVal" ) ;
	String complnt_code = request.getParameter( "complnt_code")==null?"":request.getParameter( "complnt_code" ) ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	dispMode		=	request.getParameter( "dispMode")==null?"":request.getParameter( "dispMode" ) ;

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	ArrayList disparry=new ArrayList();
	String sel_mode=request.getParameter( "sel_mode")==null?"":request.getParameter( "sel_mode" ) ;
	//chiefcomplnt.clearList();
	if(tabVal.equals("S")){
		disparry=chiefcomplnt.loadSpclIndex(index,request,complnt_code);
		row_count=disparry.size();
		chiefcomplnt.clearLoadList();
	}else{
		disparry=chiefcomplnt.loadAssociate(complnt_code,request);
		row_count=disparry.size();
		arr=chiefcomplnt.getloadupdtsp();
		modval=arr.size();
	}
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
%>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="formIndexOrderCatalogDtl" id="formIndexOrderCatalogDtl" action='../../servlet/eCA.ChiefComplaintSpltyServlet' method='post' target='messageFrame'>

	<%	
	int size=disparry.size();
	if(size>0){%>

	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<%
//.............................
//		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			
			
		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			
		}
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

	
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);


//..................................
if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td class='WHITE' width='91%'></td>
		<td width='11%'>
		<A HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%
	}
	if ( !( (start+row_disp) > row_count ) ){
	%>	<td class='WHITE' width='94%'></td>
		<td width='11%'>
		<A HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
	%>
	</tr>
	</table>

	<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center'>
	<tr width='10%'>
	<tr width='10%'>
	<td class='columnheader' width='75%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td></tr>
	<%
	for(int i=0;i<size;i++){
		if(i>=fm_disp && i<= to_disp){
		HashMap htable=new HashMap();
		String sp_desc="";
		String associate_yn="";
		String sp_code="";
		htable=(HashMap)disparry.get(i);
		sp_code=(String)htable.get("code");
		sp_desc=(String)htable.get("sp_desc");
		associate_yn=(String)htable.get("associate_yn");

		if(associate_yn.equals("Y"))
			associate_yn="checked";
		else
			associate_yn="";
		if(modval >0){
			for(int k=0;k<modval;k++){
				if(sp_code.equals(arr.get(k))) 
					associate_yn="";
			}
		}

		String disabled="";
		disabled=(String)htable.get("status");
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		%>
		<tr>
		<td class='<%=classValue%>' ><%=sp_desc%></td>
		<td class='<%=classValue%>' ><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' <%=associate_yn%> <%=disabled%> onclick='checksplt(this,"<%=sp_code%>",escape("<%=sp_desc%>"))'></td>
		</tr>
		<%
	}
	}
	}else{%>
	<script>
	var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	</script>
	<%}
	%>
</table>
	<input type="hidden" name="complnt_code" id="complnt_code" value="<%=complnt_code%>">
	<input type="hidden" name="sel_mode" id="sel_mode" value="<%=sel_mode%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type='hidden' name='tabVal' id='tabVal' value="<%=tabVal%>">

</form>
</body>
</html>

