<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
29/03/2012						Ramesh G		
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCA.ChartComponentFormulaBean,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id='recordsBean' class='eCA.ChartComponentResultsetBean' scope='session' />
<html>
	<head>
		<title><fmt:message key="eCA.ChartComponentList.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<style>		
		TD.columnfirstHeader{
			COLOR: white ;
			background-color:#83AAB4;		
			padding-left:3px;
			font-family: Verdana;
			font-size: 10pt;
			font-weight:bold;			

		}	
				
		TD.columnData{
			BACKGROUND-COLOR: white;
			COLOR: black ;
			font-family: Verdana;
			font-size: 10pt;
		}
		
	</style>
	<script>
	function graphPram(sobj,mobj,pid,obj){		
		var formatId=obj.value;		
		var st = "document.ViewChartComponentListForm."+pid+"";
		var xScal = "";
		var yScal = "";
		var minY  = "";
		var maxY  = "";
		var disOr = "";
		if(formatId=='G'||formatId=='T'){
			var seqNo= sobj.value;			
			var disMeaCode=mobj.value;			
			var viewChart=document.ViewChartComponentListForm.viewChart.value;
			
			var query_string="SeqNo="+seqNo+"&DisMeaCode="+disMeaCode+"&ViewChart="+viewChart;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr  = "<root><SEARCH ";
			xmlStr +=" /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ViewChartComponentGetData.jsp?"+query_string, false ) ;
			xmlHttp.send(xmlDoc);
			
			if(trimString(xmlHttp.responseText)!="Error")
			{
				var result = trimString(xmlHttp.responseText);				
				var temp_result = result.split("|");
				xScal = trimString(temp_result[0]);
				yScal = trimString(temp_result[1]);
				minY  = trimString(temp_result[2]);
				maxY  = trimString(temp_result[3]);
				disOr  = trimString(temp_result[4]);
			}
		}
		if(formatId=='G'){
			document.getElementById(pid+'t2').innerHTML = "<input type='text' name='"+pid+"DisOrder' id='"+pid+"DisOrder' value='"+disOr+"' onKeyPress=\"return CheckNumber(event);\" maxlength=\"3\" style=\"width:60px;\"/>";
			document.getElementById(pid+'t6').innerHTML = "<input type='text' name='"+pid+"t6XS' id='"+pid+"t6XS' value='"+xScal+"' onKeyPress=\"return CheckNumber(event);\" onblur=\"javascriopt:validateXScal(this)\" maxlength=\"2\" style=\"width:60px;\"/>";
			document.getElementById(pid+'t7').innerHTML = "<input type='text' name='"+pid+"t7YS' id='"+pid+"t7YS' value='"+yScal+"'  onKeyPress=\"return CheckFloat(event,this);\" onblur=\"javascriopt:valideateYScal(this,document.ViewChartComponentListForm."+pid+"t8minY,document.ViewChartComponentListForm."+pid+"t9maxY)\" maxlength=\"5\" style=\"width:60px;\"/>";
			document.getElementById(pid+'t8').innerHTML = "<input type='text' name='"+pid+"t8minY' id='"+pid+"t8minY' value='"+minY+"' onKeyPress=\"return CheckFloat(event,this);\" onblur=\"javascriopt:valideateYMin(document.ViewChartComponentListForm."+pid+"t7YS,this,document.ViewChartComponentListForm."+pid+"t9maxY)\"  maxlength=\"6\" style=\"width:60px;\"/>";
			document.getElementById(pid+'t9').innerHTML = "<input type='text' name='"+pid+"t9maxY' id='"+pid+"t9maxY' value='"+maxY+"' onblur=\"javascriopt:valideateYMax(document.ViewChartComponentListForm."+pid+"t7YS,document.ViewChartComponentListForm."+pid+"t8minY,this)\"  onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/>";	
		}else if(formatId=='T'){
			document.getElementById(pid+'t2').innerHTML = "<input type='text' name='"+pid+"DisOrder' id='"+pid+"DisOrder' value='"+disOr+"' onKeyPress=\"return CheckNumber(event);\"  maxlength=\"3\" style=\"width:60px;\"/>";
			document.getElementById(pid+'t6').innerHTML = '';
			document.getElementById(pid+'t7').innerHTML = '';
			document.getElementById(pid+'t8').innerHTML = '';
			document.getElementById(pid+'t9').innerHTML = '';
		}else{
			document.getElementById(pid+'t2').innerHTML = '';
			document.getElementById(pid+'t6').innerHTML = '';
			document.getElementById(pid+'t7').innerHTML = '';
			document.getElementById(pid+'t8').innerHTML = '';
			document.getElementById(pid+'t9').innerHTML = '';
		}
	}
	function validateXScal(obj){		
		var xScal=obj.value;		
		if(xScal!="" && xScal!=null){			
			if( xScal<2 || xScal>23){
				alert('X-Axis Interval value should be within range 2 to 23 hrs.');
				obj.select();
			}
		}
		
	}
	function valideateYMax(ysObj,minObj,maxObj){		
		var yscal=parseFloat(trimString(ysObj.value));
		var ymin =parseFloat(trimString(minObj.value));		
		var ymax =parseFloat(trimString(maxObj.value));
		var errYscal = document.ViewChartComponentListForm.ErrYscal.value;
		var errYmin = document.ViewChartComponentListForm.ErrYmin.value;
		if(errYscal=="" && errYmin=="" ){
			if(ymax!=""){
				if(ymax<ymin){
					document.ViewChartComponentListForm.ErrYmax.value='Error';
					alert("Max Y-Axis value should be greater than Min Y-Axis value.");
					maxObj.select();
					
				}else if((ymax-ymin)<yscal) {
					document.ViewChartComponentListForm.ErrYmax.value='Error';
					alert("Max Y-Axis value should be greater than or equal to difference of Min Y-Axis value & Max Y-Axis value.");
					maxObj.select();
				}else{
					document.ViewChartComponentListForm.ErrYmax.value='';
				}
			}
				
		}
	}
	function valideateYMin(ysObj,minObj,maxObj){		
		var yscal=parseFloat(trimString(ysObj.value));
		var ymin =parseFloat(trimString(minObj.value));		
		var ymax =parseFloat(trimString(maxObj.value));	
		var errYscal = document.ViewChartComponentListForm.ErrYscal.value;
		var errYmax = document.ViewChartComponentListForm.ErrYmax.value;
		if(errYscal=="" && errYmax=="" ){
			if(ymin!=""){
				if(ymax!=""){
					if(ymin>ymax){
						document.ViewChartComponentListForm.ErrYmin.value='Error';
						alert("Min Y-Axis value should be less than Max Y-Axis value.");
						minObj.select();
					}else if(yscal!=""){
						if((ymax-ymin)<yscal) {
							document.ViewChartComponentListForm.ErrYmin.value='Error';
							alert("Min Y-Axis value should be less than or equal to difference of Min Y-Axis value & Max Y-Axis value.");
							minObj.select();
						}
						else{
							document.ViewChartComponentListForm.ErrYmin.value='';
						}
					}else{
						document.ViewChartComponentListForm.ErrYmin.value='';
					}
				}
			}
			
		}
	}
	function valideateYScal(ysObj,minObj,maxObj){		
		var yscal=parseFloat(trimString(ysObj.value));
		var ymin =parseFloat(trimString(minObj.value));		
		var ymax =parseFloat(trimString(maxObj.value));	
		var errYmin = document.ViewChartComponentListForm.ErrYmin.value;
		var errYmax = document.ViewChartComponentListForm.ErrYmax.value;
		if(errYmin=="" && errYmax=="" ){
			if(yscal!=""){
				if(ymin!="" && ymax!=""){				
					if((ymax-ymin)<yscal) {
						document.ViewChartComponentListForm.ErrYscal.value='Error';
						alert("Y-Axis Interval value should be less than or equal to difference of Min Y-Axis value & Max Y-Axis value.");
						ysObj.select();
					}else{
						document.ViewChartComponentListForm.ErrYscal.value='';
					}				
				}
			}
		}
	}
	function CheckNumber(event){		
		var strCheck = '0123456789';
		var whichCode = (window.Event) ? event.which : event.keyCode;		
		key = String.fromCharCode(whichCode);  // Get key value from key code		
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return true ;
	}
	function CheckFloat(event,obj){		
		var strCheck = '0123456789.';
		var whichCode = (window.Event) ? event.which : event.keyCode;		
		key = String.fromCharCode(whichCode);  // Get key value from key code		
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if((((obj.value).split('.')).length)>1 && (event.keyCode == 46)) return false;		
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);		
		return true ;
	}	
	</script>
	</head>
	
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">	
	<form name='ViewChartComponentListForm' id='ViewChartComponentListForm' action='' method='post'>	
	<TABLE width='100%' height='100%'  cellpadding='0'  cellspacing='0' border='0' >
		<TR>
		<TD valign='top' >
			<TABLE  class='grid' border="1" cellpadding="0"  cellspacing="0" width='100%' >
				<TR>
					<!--<TD style='width:80px;'  class='columnfirstHeader'>Order Sequence No</TD>
					<TD  style='width:150px;'  class='columnfirstHeader'>Discrete Measure Code</TD> -->
					<TD  class = 'columnheadercenter' rowspan="2" >Chart Component</TD>
					<TD class = 'columnheadercenter'  rowspan="2" >Format</TD>
					<TD class = 'columnheadercenter' rowspan="2"  >Display Order<img SRC="../../eCommon/images/mandatory.gif"></TD>
					<TD  colspan='4' class = 'columnheadercenter' align='center'>Graph Details</TD>
				</TR>
				<TR>
					<TD   class = 'columnheadercenter' >X-Axis Interval<img SRC="../../eCommon/images/mandatory.gif"></TD>
					<TD   class = 'columnheadercenter' >Y-Axis Interval<img SRC="../../eCommon/images/mandatory.gif"></TD>
					<TD  class = 'columnheadercenter' >Min Y-Axis Value<img SRC="../../eCommon/images/mandatory.gif"></TD>
					<TD   class = 'columnheadercenter' >Max Y-Axis Value<img SRC="../../eCommon/images/mandatory.gif"></TD>	
				</TR>
				<%				
				Connection con = null;
				PreparedStatement psmt = null;
				ResultSet rset = null;
				int noOfRows = 0;
				//ArrayList grphValues=new ArrayList();
				String viewChartSearch = "";
				StringBuffer sb = new StringBuffer();
				try{
					con = ConnectionManager.getConnection();
					viewChartSearch=  request.getParameter("viewChartSearch")==null ? "" : request.getParameter("viewChartSearch");
					psmt = con.prepareStatement("SELECT CCSC.DISCR_DISP_ORDER_SEQ,CCSC.DISCR_MSR_ID,ADM.LONG_DESC ,CVCC.FORMAT_TYPE,CVCC.DISP_ORD_SEQ_NUM,CVCC.X_AXIS_SCALE,CVCC.Y_AXIS_SCALE,CVCC.MIN_Y_AXIS,CVCC.MAX_Y_AXIS FROM CA_CHART_SECTION_COMP CCSC JOIN AM_DISCR_MSR ADM ON ADM.DISCR_MSR_ID=CCSC.DISCR_MSR_ID LEFT JOIN CA_VIEW_CHART_CONFIG CVCC ON CVCC.CHART_ID=CCSC.CHART_ID AND CCSC.DISCR_MSR_ID=CVCC.DISCR_MSR_ID WHERE CCSC.DISCR_MSR_TYPE IN ('N', 'I') AND CCSC.CHART_ID=? ORDER BY CCSC.DISCR_DISP_ORDER_SEQ");
					psmt.setString(1,viewChartSearch);	
					rset = psmt.executeQuery();
					int r=0;
					while(rset.next())
					{	
						//ArrayList tempGraphData = new ArrayList();
						String order_seq = rset.getString("DISCR_DISP_ORDER_SEQ");
						String discr_msr_id = rset.getString("DISCR_MSR_ID");
						String discr_msr_name = rset.getString("LONG_DESC");
						String formatid = rset.getString("FORMAT_TYPE")==null ? "" : rset.getString("FORMAT_TYPE");
						String dis_ord_seq = rset.getString("DISP_ORD_SEQ_NUM")==null ? "" : rset.getString("DISP_ORD_SEQ_NUM");
						String xscal =  rset.getString("X_AXIS_SCALE")==null ? "" : rset.getString("X_AXIS_SCALE");
						String yscal = rset.getString("Y_AXIS_SCALE")==null ? "" : rset.getString("Y_AXIS_SCALE");
						String ymin = rset.getString("MIN_Y_AXIS")==null ? "" : rset.getString("MIN_Y_AXIS");
						String ymax = rset.getString("MAX_Y_AXIS")==null ? "" : rset.getString("MAX_Y_AXIS");

						/*tempGraphData.add(formatid);
						tempGraphData.add(xscal);
						tempGraphData.add(yscal);
						tempGraphData.add(ymin);
						tempGraphData.add(ymax);
						grphValues.add(tempGraphData);*/
						out.println("<TR id='r"+noOfRows+"'>");
												
						sb.append("<input type='hidden' name='r"+noOfRows+"OrderSeq' id='r"+noOfRows+"OrderSeq' value='"+order_seq+"'/>");						
						sb.append("<input type='hidden' name='r"+noOfRows+"DisMsrId' id='r"+noOfRows+"DisMsrId' value='"+discr_msr_id+"'/>");
						out.println("<TD id='r"+noOfRows+"t3' style='padding-left:5px;width:150px;' class='gridData'>"+discr_msr_name+"</TD>");
						out.println("<TD id='r"+noOfRows+"t4' style='width:150px;'  class='gridData'>");
						out.println("<select name='r"+noOfRows+"format' id='r"+noOfRows+"format' onChange=\"javascript:graphPram(document.ViewChartComponentListForm.r"+noOfRows+"OrderSeq,document.ViewChartComponentListForm.r"+noOfRows+"DisMsrId,'r"+noOfRows+"',this)\" >");
						out.println("<option value=''>-- Select --</option>");
						if("G".equals(formatid))
							out.println("<option value='G' selected >Graph</option>");
						else 
							out.println("<option value='G'>Graph</option>");
						if("T".equals(formatid))
							out.println("<option value='T' selected >Table</option>");
						else 
							out.println("<option value='T'>Table</option>");						
						
						out.println("</select>");
						out.println("</TD>");
						

						if("G".equals(formatid)){
							out.println("<TD id='r"+noOfRows+"t2'  class='gridData'><input type='text' name='r"+noOfRows+"DisOrder' id='r"+noOfRows+"DisOrder' value='"+dis_ord_seq+"' onKeyPress=\"return CheckNumber(event);\" maxlength=\"3\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t6XS' id='r"+noOfRows+"t6XS' value='"+xscal+"' onblur=\"javascript:validateXScal(this);\" onKeyPress=\"return CheckNumber(event);\" maxlength=\"2\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t7YS' id='r"+noOfRows+"t7YS' value='"+yscal+"'   onblur=\"javascriopt:valideateYScal(this,document.ViewChartComponentListForm.r"+noOfRows+"t8minY,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"5\" style=\"width:60px;\"/></TD>");
							//out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t8minY' id='r"+noOfRows+"t8minY' value='"+ymin+"'  onblur=\"javascriopt:valideateYMin(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,this,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t8minY' id='r"+noOfRows+"t8minY' value='"+ymin+"'  onblur=\"javascriopt:valideateYMin(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,this,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\"  onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' ><input type='text'  name='r"+noOfRows+"t9maxY' id='r"+noOfRows+"t9maxY' value='"+ymax+"' onblur=\"javascriopt:valideateYMax(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,document.ViewChartComponentListForm.r"+noOfRows+"t8minY,this)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
						}else if("T".equals(formatid)){
							out.println("<TD id='r"+noOfRows+"t2'  class='gridData'><input type='text' name='r"+noOfRows+"DisOrder' id='r"+noOfRows+"DisOrder' value='"+dis_ord_seq+"' onKeyPress=\"return CheckNumber(event);\" maxlength=\"3\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
						}else{
							out.println("<TD id='r"+noOfRows+"t2'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");

						}
						out.println("</TR>");
						
						

						noOfRows++;
					}					
				}catch(Exception e){					
					System.out.println(e);					
				}finally{
					if(psmt!=null)psmt.close();
					if(rset!=null) rset.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);					
				}

			  %>				
				
			</TABLE>		
		</TD>	
	
		
	</TR>	
	</TABLE>
	<input type='hidden' name='noOfRows' id='noOfRows' value='<%= noOfRows%>'/>
	<input type='hidden' name='viewChart' id='viewChart' value='<%= viewChartSearch%>'/>
	<input type='hidden' name='ErrYscal' id='ErrYscal' value=''/>
	<input type='hidden' name='ErrYmin' id='ErrYmin' value=''/>
	<input type='hidden' name='ErrYmax' id='ErrYmax' value=''/>
	<%
	out.println(sb.toString());
	%>
	</form>
	</body>
</html>


