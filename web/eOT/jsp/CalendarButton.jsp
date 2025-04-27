<!DOCTYPE html>
<%@ page import ="eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<style>
TD.USH {
  FONT-FACE: verdana ;
  FONT-SIZE: 8pt ;
  BACKGROUND-COLOR: WHITE;
  COLOR:blue;
}
</style>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript'>
function moveBack1()
{
	var frmObj=document.forms[0];
	var from=parseInt(frmObj.start1.value,10);
	from=from-1;
	frmObj.start1.value=from;
	var date=frmObj.date.value;
	var tmpDate=convertDate(date,from);
	var called_from=frmObj.called_from.value;
	//alert("tmpDate--->"+tmpDate)
var tdate=0;
	var month=0;
	var year=0;
	var dt=tmpDate.split("/");
	tdate=dt[0];
	month=dt[1];
	year=dt[2];
	/*if (year < 100) {
	    if (year > 40) {
		year = year + 1900;
	    }
	    else {
		year = year + 2000;
	    }
	}*/
	if(month==2){
		if (year % 4 == 0) {
			if (year % 100 != 0) {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="29";
			}
		}else if (year % 400 == 0) {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="29";
			}
			} else {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="28";
			}
			}
		} else {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="28";
			}
		}
	}

		if(month==2 || month==4 || month==6 || month==8 || month==9 || month==11 || month==1)
	{
	if(tdate==31){
	tdate="01";
	month=parseInt(month)+parseInt(1);
	}
	}


	var manualDate=tdate+"/"+month+"/"+year;
var param ="sql="+frmObj.sql.value+"&flag="+frmObj.flag.value+"&date="+manualDate+"&speciality_code="+frmObj.speciality_code.value+"&speciality_desc="+frmObj.speciality_desc.value+"&orderid="+frmObj.orderid.value+"&booking_no="+frmObj.booking_no.value+"&called_from="+called_from;
	if(from <0)	
		param+="&from_value=1";
	else 
		param+="&from_value=0";

		parent.schdule_dtl.location.href = '../../eOT/jsp/Calenderslot.jsp?'+param;

}


function moveForward1()
{
	var frmObj=document.forms[0];
	var from=parseInt(frmObj.start1.value,10);
	from=from+1;
	frmObj.start1.value=from;
	var date=frmObj.date.value;
	var tmpDate=convertDate(date,from);
	var tdate=0;
	var month=0;
	var year=0;
	var dt=tmpDate.split("/");
	tdate=dt[0];
	month=dt[1];
	year=dt[2];
/*	if (year < 100) {
	    if (year > 40) {
		year = year + 1900;
	    }
	    else {
		year = year + 2000;
	    }
	}*/
	var called_from=frmObj.called_from.value;
	
	if(month==2){
			
		if (year % 4 == 0) {
			if (year % 100 != 0) {
				
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="29";
			}
		}else if (year % 400 == 0) {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="29";
			}
			} else {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="28";
			}
			}
		} else {
			if(tdate==29 ||tdate==30 ||tdate==31){
			tdate="28";
			}
		}
	}

	if(month==2 || month==4 || month==6 || month==8 || month==9 || month==11 || month==1)
	{
	if(tdate==31){
	tdate="01";
	month=parseInt(month)+parseInt(1);
	}
	}
	var manualDate=tdate+"/"+month+"/"+year;
	var param ="sql="+frmObj.sql.value+"&flag="+frmObj.flag.value+"&date="+manualDate+"&speciality_code="+frmObj.speciality_code.value+"&speciality_desc="+frmObj.speciality_desc.value+"&orderid="+frmObj.orderid.value+"&booking_no="+frmObj.booking_no.value+"&called_from="+called_from;
	if(from <0)	param+="&from_value=1";
	else 	param+="&from_value=0";
	parent.schdule_dtl.location.href = '../../eOT/jsp/Calenderslot.jsp?'+param;
}


function convertDate(date,from){
	var spltDate=new Array();
	spltDate=date.split("/");
	var da=parseInt(spltDate[0],10);
	var mon=parseInt(spltDate[1],10);
	var yea=parseInt(spltDate[2],10);

	if(from<0){ 
		from=from * -1;
		yea = yea - Math.floor(from/12);
		mon= mon - Math.floor(from%12);
		if(mon<=0){
			  mon=mon*-1;
			  mon=12-mon;
			  yea=yea-1;
		}	         
	}else{
		var	add=mon+from;
		var div= Math.floor((add-1)/12);
		yea=yea+div;
		mon=(add-1)%12+1;
	}
	var strDate= da+"/"+mon+"/"+yea;
	return strDate;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form >

<%
//commented this SOP statement by Rajesh on 09/01/09 
String sql=CommonBean.checkForNull(request.getParameter("sql"));
String flag=CommonBean.checkForNull(request.getParameter("flag"));
String date=CommonBean.checkForNull(request.getParameter("date"));
//date = com.ehis.util.DateUtils.convertDate(date,"DMY","en",locale);
String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
String speciality_desc=CommonBean.checkForNull(request.getParameter("speciality_desc"));
String orderid=CommonBean.checkForNull(request.getParameter("orderid"));
String booking_no=CommonBean.checkForNull(request.getParameter("booking_no"));
String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
%>
<table border="0" cellpadding=3 cellspacing="0" width="100%">
<tr>	
	<td align='center' class='USH'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	<input type='button' name='back' id='back' value='<--'   onClick="moveBack1();" class='BUTTON'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type='button' name='forward' id='forward' value='-->' onClick='javascript:moveForward1();' class='BUTTON'>
	</td>
	</tr>
	</table>
	<input type='hidden' name='start1' id='start1' value='0'>
	<input type='hidden' name='sql' id='sql' value="<%=sql%>">
	<input type='hidden' name='flag' id='flag' value="<%=flag%>">
	<input type='hidden' name='date' id='date' value="<%=date%>">
	<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
	<input type='hidden' name='speciality_desc' id='speciality_desc' value="<%=speciality_desc%>">
	<input type='hidden' name='orderid' id='orderid' value="<%=orderid%>">
	<input type='hidden' name='booking_no' id='booking_no' value="<%=booking_no%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">



    </form>
    </body>
</html>

