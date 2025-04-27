<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");

	String relationship_id	 =	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String facility_id		 = (String)session.getAttribute("facility_id");
	String Sec_Hdg_Code		 = request.getParameter("Sec_Hdg_Code");
	String patient_type		 = request.getParameter("patient_type");

    String Patient_Id        = request.getParameter("Patient_Id");
    String Encounter_Id      = request.getParameter("Encounter_Id");

    String Practitioner_Id   = request.getParameter("Practitioner_Id");
    String Locn_Code         = request.getParameter("Locn_Code");
    String Locn_Type         = request.getParameter("Locn_Type");
    String f_authorize_yn    = request.getParameter("f_authorize_yn");
	String authorize=request.getParameter("authorize")==null?"":request.getParameter("authorize");
	String modal_yn				= request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn");

	if (authorize.equals("Normal Mode")){
			f_authorize_yn="Y";
  	}
	
    String context = request.getParameter("P_context");
	String patient_class    = request.getParameter("patient_class");
	
	String function				= request.getParameter("Function");

    String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
    String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");

    String logicalseqno = request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");

    String scheme       ="";
    String scheme_desc  ="";
	String significant_yn = "";
	significant_yn			=	request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
    String classValue = "";
    String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";
	String diag_type="", temp="";

	String age = request.getParameter("Age")==null?"":request.getParameter("Age");
	String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
%>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../js/rowcolor.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
		srl_no_array = new Array();
		var prev=1;
		var i=0;
		var prev1=0;
		var j=0;

function refer(ro,numofcols)
{
	
		prev1	=ro.rowIndex
		for (var i=0;i<numofcols;i++)
		{
			document.forms[0].dataTable.rows(prev).cells(i).style.backgroundColor=ro.bgColor;
			
		}
		for (var i=1;i<numofcols;i++)
	    {
		ro.cells(i).style.backgroundColor="#B2B6D7";
		}

		prev	=ro.rowIndex
}

function ShowSupportingDiag(associate_codes,title)
{
	var dialogHeight= "10" ;
    var dialogWidth = "35" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;

	window.showModalDialog("../../eCA/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes="+escape(associate_codes)+"&title=" + title,"",features);
}
function rfresh(obj, associate_codes, code_indicator,encounter_clor)
{
	//alert(" -- "+code_indicator);	
	var aut='';
	var authorizeButton=parent.PatProblemQueryTools.document.forms[0].authorizeButton.value;
	if (authorizeButton=='N') aut='';
	else  aut= parent.PatProblemQueryTools.document.forms[0].authorize.value;

	var QueryString =parent.addModifyPatProblem.document.getElementById("QueryString").value;
	//alert('obj.value'+obj.value);
	
	parent.addModifyPatProblem.location.href="addModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&srl_no="+obj.value+"&Patient_Id=<%=Patient_Id%>&relationship_id=<%=relationship_id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&scheme_desc=<%=scheme_desc%>&significant_yn=<%=significant_yn%>&f_authorize_yn=<%=f_authorize_yn%>&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&modal_yn=<%=modal_yn%>&Dob=<%=dob%>&Sex=<%=sex%>&associate_codes=" + associate_codes + "&code_indicator=" + code_indicator + "&QueryString=" + escape(QueryString)+"&encounter_clor="+encounter_clor ;

	parent.PatProblemQueryTools.location.href="PatProblemQueryTools.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&patient_type=<%=patient_type%>&Function=<%=function%>&relationship_id=<%=relationship_id%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&Sec_Hdg_Code=<%=Sec_Hdg_Code%>&P_context=<%=context%>&stage_desc=<%=stagedesc%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&errorModify=Y&authorize="+aut+"&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&code_indicator=" + code_indicator;
	//alert(document.forms[0].modal_yn.value);
if(document.forms[0].modal_yn.value=='Y' || document.forms[0].called_from_ip_result.value=='Y')
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
else
	top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

	function scrollTitle(){
	  var y = parent.PatProblemQueryResult.document.body.scrollTop;

	  if(y == 0){
		parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.position = 'static';
		parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.position = 'relative';
		parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.posTop  = y-2;
	  }

	}
	function alignWidth(){
		var totalRows =  parent.PatProblemQueryResult.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = parent.PatProblemQueryResult.document.getElementById("dataTitleTable").rows(1).cells.length;
		for(var i=0;i<temp;i++) {
			parent.PatProblemQueryResult.document.getElementById("dataTitleTable").rows(1).cells(i).width=parent.PatProblemQueryResult.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
			
		}
	}
async function showEncounterDeatils(Patient_Id,srl_no,diag_code)
{
	var dialogHeight= "10" ;
	var dialogWidth = "37" ;
	var dialogTop = '100'
	var dialogHeight = '20'
	var status = "no";
	var features    = "dialogHeight:" + dialogHeight + ";dialogHeight:"+dialogHeight+";dialogTop:"+dialogTop+"; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await  window.showModalDialog("PatProblemEncDtlMain.jsp?Patient_Id="+Patient_Id+"&srl_no="+srl_no+"&diag_code="+diag_code,arguments,features);
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onScroll='scrollTitle()' >
<form name='query_form' id='query_form'>
<center>
<div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
<tr><td class='columnheader' align='left' colspan='8'><font size=1><fmt:message key="Common.ActiveProblems.label" bundle="${common_labels}"/></font></td></tr>
<tr>
<td class='columnheadercenter' width ='1%'><font size=1>&nbsp;</font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.code.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.primary.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter'><font size=1><fmt:message key="Common.SupportingDiagnosis.label" bundle="${common_labels}"/></font></td>
</tr>
</table>
</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
 <%

        Connection conn 	= null; //(Connection) session.getValue( "connection" ) ;
        PreparedStatement  pstmt = null;
        PreparedStatement  pstmt_1 = null;
        ResultSet  rs_associatecodes = null;
        ResultSet  rs		= null;
        PreparedStatement  stmt_1	= null;
        ResultSet  rs_1		= null;
		try
        {
		conn = ConnectionManager.getConnection(request);

                stmt_1=conn.prepareStatement(sql_1);
                rs_1=stmt_1.executeQuery();
                if(rs_1.next())
                {
                    scheme      = rs_1.getString("scheme");
                    scheme_desc = rs_1.getString("scheme_desc");
                }

        //String sql="select srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc, significant_yn, nvl((select distinct 'Y' from pr_problem_enc_dtl where patient_Id =pr_problem_vw.patient_id and srl_no=pr_problem_vw.srl_no and facility_id= ? and encounter_id= ? ),'N') encounter_clor , decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype,nvl(PRIMARY_YN,'N') primary_diag,diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null) diag_code_desc , code_indicator,ip_diag_stage from pr_problem_vw where patient_Id=? and  nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N'))and diag_code_scheme=?  and nvl(error_yn,'N')='N'  and close_date is null order by diagtype, onset_date desc  ";
//out.println("1"+sql);

		String sql="select srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc, significant_yn, nvl((select distinct 'Y' from pr_problem_enc_dtl where patient_Id =pr_problem_vw.patient_id and srl_no=pr_problem_vw.srl_no and facility_id= ? and encounter_id= ? ),'N') encounter_clor , diag_type  diagtype, nvl(PRIMARY_YN,'N') primary_diag,diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null) diag_code_desc , code_indicator,ip_diag_stage from pr_problem_vw where patient_Id=? and  nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N'))and diag_code_scheme=?  and nvl(error_yn,'N')='N'  and close_date is null order by diagtype, onset_date desc";
		pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,Encounter_Id);
		pstmt.setString(3,Patient_Id);
	//	pstmt.setString(4,Patient_Id);
		pstmt.setString(4,f_authorize_yn);
		pstmt.setString(5,scheme);
		rs = pstmt.executeQuery();

		if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                classValue = "QRYODD" ;
				
				%>
				<!--
                <tr><td class='<%=classValue%>'>&nbsp</td>
				<td class='<%=classValue%>'>&nbsp</td>
				<td class='<%=classValue%>'>&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td class='<%=classValue%>'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				</tr> -->
				<%
                k++;
            }
        }
        else
        {
			String onset_date = "";
			String diag_desc = "";
			String diag_code = "";
			String prim_diag = "";
			String diag_code_desc = "";
			String diag_code_scheme_desc = "";
			String srl_no = "";
			String sensitive_yn = "";
			StringBuffer associate_codes = new StringBuffer();
			String code_indicator = "";
			String encounter_clor = "";
			String ip_diag_stage	="";

            while(rs.next())
            {
				onset_date		=	rs.getString("onset_date1");
				onset_date		=	com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
                diag_desc		=	rs.getString("diag_desc");
                diag_code		=	rs.getString("diag_code");
                prim_diag		=	rs.getString("primary_diag");
				diag_code_desc	=	rs.getString("diag_code_desc");
		 	    diag_type		=	rs.getString("diagtype");
		 	   	if(diag_type == null)	diag_type ="";
				if(diag_type.equals("P"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");

				if(diag_type.equals("D"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				if(diag_type.equals("F"))

					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
                diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
                srl_no 			= 	rs.getString("srl_no");
                sensitive_yn		=	rs.getString("sensitive_yn");
				significant_yn	=	rs.getString("significant_yn");
				if(sensitive_yn==null)	sensitive_yn  = "N";
				if(significant_yn==null)	significant_yn  = "N";
				if(diag_code==null)			diag_code		=	"";
				code_indicator = rs.getString("code_indicator");
				encounter_clor = rs.getString("encounter_clor");	
				ip_diag_stage	= rs.getString("ip_diag_stage");
				if(ip_diag_stage==null)ip_diag_stage="";
				if(ip_diag_stage.equals("A")) 
					ip_diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				else if(ip_diag_stage.equals("I")) 
					ip_diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				else if(ip_diag_stage.equals("D")) 
					ip_diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				else if(ip_diag_stage.equals("")||ip_diag_stage== null)
					ip_diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
					
				String sql_assosicate_code = "select a.support_diag_code , b.short_desc,b.long_desc, b.code_indicator from pr_problem_detail a, mr_icd_code b where a.patient_id =? and   a.srl_no =? and      a.diag_code = ? and b.diag_code_scheme = ? and b.diag_code = a.support_diag_code" ;

				pstmt_1 = conn.prepareStatement(sql_assosicate_code);
				pstmt_1.setString(1, Patient_Id);
				pstmt_1.setString(2, srl_no);
				pstmt_1.setString(3, diag_code);
				pstmt_1.setString(4, scheme);

				rs_associatecodes = pstmt_1.executeQuery();
				int temp_associate_code = 0;
				
				while(rs_associatecodes.next())
				{
					String temp_supporting_code = java.net.URLEncoder.encode((String)rs_associatecodes.getString("support_diag_code"));
					String temp_short_desc = java.net.URLEncoder.encode((String)rs_associatecodes.getString("short_desc"));
                    String long_desc=java.net.URLEncoder.encode((String)rs_associatecodes.getString("long_desc"));
					//code_indicator = rs_associatecodes.getString("code_indicator");
					
					if(temp_associate_code == 0)
						associate_codes.append(temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);
					else
						associate_codes.append("|" + temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);	
					temp_associate_code++;
				}

				//if(sensitive_yn!=null)
                
				if ((!(diag_type.equals(temp))))
				{
				%>
				<tr>

		  			<td colspan='8' class='CAGROUPHEADING' ><font size=1><b><%=diag_type%></b></font></td>
				</tr>
				<script>
				srl_no_array[i] = null;
				i++;
				</script>
				<%
				}
				temp=diag_type;
				%>

			<%
	
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
            else
                classValue = "QRYODD" ;
			
			if(sensitive_yn != null)
				{
			 if(sensitive_yn.equals("Y"))
				classValue="PATQRED";
              else if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
			}
					//onclick='javascript:changeRowColor(this,4)'


					/*(called_from_ip.equals("Y"))
					{
						out.println("<tr style='background-color:;'>");
						if(encounter_clor.equals("Y"))
							out.println("<td width='2%' class='BLUE'></td>");
						else
							out.println("<td width='2%'></td>");

						out.println("<td class='"+classValue+"'><font size=1>"+onset_date+"</font></td><td class='"+classValue+"'><font size=1>"+aname);
			            out.println(diag_desc+"</font></td><td class='"+classValue+"'><font size=1>");
		
					}
					else
					{*/
						out.println("<tr style='background-color:;' onclick='javascript:refer(this,8)'>");

						if(encounter_clor.equals("Y"))
							out.println("<td width = '1%' class='BLUE'><a  href=\"javascript:showEncounterDeatils('"+Patient_Id+"','"+srl_no+"','"+diag_code+"')\" title='Click here to view the Encounter Details'>&nbsp;</a></td>");
						else
							out.println("<td width='7%'><a  href=\"javascript:showEncounterDeatils('"+Patient_Id+"','"+srl_no+"','"+diag_code+"')\" title='Click here to view the Encounter Details'>&nbsp;</a></td>");

						out.println("<td class='"+classValue+"'><font size=1><a name='"+aname+"' href=\"javascript:rfresh(document.forms[0].srl_no"+k+",'" + java.net.URLEncoder.encode(associate_codes.toString()) + "','" + code_indicator + "','"+encounter_clor+"')\">");               
						out.println(onset_date+"</a></font></td><td class='"+classValue+"'width='15%'><font size=1><a name='"+aname+"'  href=\"javascript:rfresh(document.forms[0].srl_no"+k+",'" + java.net.URLEncoder.encode(associate_codes.toString()) + "','" + code_indicator + "','"+encounter_clor+"')\">");
			            out.println(diag_desc+" </a></font></td>");
						out.println("<td class='"+classValue+"' width='12%' ><font size=1>");
						out.println(ip_diag_stage);
						out.println("</font></td>");
						out.println("<td class='"+classValue+"' width='12%'><font size=1>");
					
					//}
					
					out.println((diag_code_desc.equals("")?"&nbsp;":diag_code_desc)+"</font></td><td class='"+classValue+"' width='13%'><font size=1>");
                    out.println(diag_code_scheme_desc);


                    out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'>");
                    out.println("</font></td>");
					out.println("<td class='"+classValue+"' width='13%'><font size=1>");
					out.println(prim_diag);
                    out.println("</font></td>");
					out.println("</font></td>");
					if(temp_associate_code > 0)
					{
					out.println("<td class='"+classValue+"' width='16%'><font size=1>");
					
					out.println("<a href=\"javascript: ShowSupportingDiag('"+java.net.URLEncoder.encode(associate_codes.toString())+"','" + diag_desc+"(" + diag_code_desc+")')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
					out.println("</font></td>");
					}
					else{
					out.println("<td class='"+classValue+"'width='16%'><font size=1>");
					out.println("&nbsp");
					out.println("</font></td>");
					}

					out.println("</tr>");
					%>

					<script>
					srl_no_array[i] = <%=srl_no%>
					i++;
					</script>
					<%

                    k++;
					associate_codes = new StringBuffer();;
              }
			onset_date = null;
			diag_desc = null;
			diag_code = null;
			prim_diag = null;
			diag_code_desc = null;
			diag_code_scheme_desc = null;
			srl_no = null;
			sensitive_yn = null;

        }
    }catch(Exception e)
	{
		//out.print("ERROR"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
    finally
            {
                if(rs!=null)    rs.close();
				if(pstmt!=null)  pstmt.close();
				if(pstmt_1!=null)  pstmt_1.close();
				if(rs_1 !=null) rs_1.close();
				if(rs_associatecodes !=null) rs_associatecodes.close();
				if(stmt_1!=null) stmt_1.close();
				ConnectionManager.returnConnection(conn, request);
            }
%>
<tr style='visibility:hidden'>
<td class='columnheader'  width='1%'><font size=1></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.code.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.primary.label" bundle="${common_labels}"/></font></td>
<td class='columnheader'><font size=1><fmt:message key="Common.SupportingDiagnosis.label" bundle="${common_labels}"/></font></td>
</tr>
</table>
</center>
<input type="hidden" name="help_function_id" id="help_function_id" value="RECORD_DIAGNOSIS">
<input type='hidden' name='modal_yn' id='modal_yn' value="<%=modal_yn%>">
<input type='hidden' name='called_from_ip_result' id='called_from_ip_result' value="<%=called_from_ip%>">


</form>
</body>
</html>
<script>alignWidth();</script>

