<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@page import="java.util.*"%>
<%@page import="eBL.ModifyFinancialDetails.request.BLModifyFinancialDetailsRequest"%> 
<%@page import="eBL.ModifyFinancialDetails.response.BLModifyFinancialDetailsResponse"%> 
<%@page import="eBL.ModifyFinancialDetails.dao.BLModifyFinancialDetailsDao"%>
<%@page import="eBL.ModifyFinancialDetails.dao.BLModifyFinancialDetailsDaoImpl"%>
<%@page import="org.jaxen.util.FollowingAxisIterator"%>
<%@page import="eCommon.XSSRequestWrapper"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='StyleSheet' href='../../eCommon/html/IeStyle_new.css' type='text/css' media="all" onload="this.media='all'" />
<script language='javascript' src='../../eCommon/js/jquery.js'></script>
<script language='javascript' src='../../eBL/js/BLModifyFinancialDetails.js'></script>
<style type="text/css">
	.pkgContainer{
	    	background-color:#F7F7F7;
			width: auto;
			height: inherit;
	    }
	    .headercontainer {
			background-color: #0F4C8F;
			height: inherit;
			width: 98%;
			height: inherit;
			border-radius: 1%;
			display: inline-block;
			padding: 1%;
			margin: 1%;
		}
		.pkgsubcontainer{
			background-color: white;
			width: 98%;
			height: inherit;
			border-radius: 1%;
			display: inline-block;
			padding: 1%;
			
		}
		.tablContainer{
			overflow: auto;
			width: 98%;
			height: 25%;
			display: block;
			border-radius: 1%;
			margin: 1%;
		}
		.tabl {
   			display: table;
   			width: 98%;
		}
		.table-hdr{
			display: table-header-group;
			position: sticky; 
			top: 0; 
			background-color: #ccc;
			font-weight: bold;
		}
		.table-bdy-row {
		  display: table-row-group;
		}
		.row{
			 display: table-row;
			 width:98%
		}
		.cellpk {
		   display: table-cell;
		   border: solid; 
		   border-color: white; 
           border-width: thin;   
		}
		
		.rowx,
		.cellpk {
		  padding: 0.5%;
		}
		/* Style input field in grid */
		/* .gridInputs{
			height: 40px;
			width: 50%;
			border: 1px solid #DADCE0;
			border-radius: 2px;
			font-size: 15px;
			padding: 10px 5px; 
			outline: none;
			background: none;
			z-index: 1;
		}    */
		.pkggridcontainer {
			background-color: white;
			width: 98%;
			height: fit-content;
			position: relative;
			display: inline-block;
			border: 1% solid #d3d3d3;
			border-radius: 1%;
			margin: 1%;
			padding: 1%;
		}
		.srchImg{
			position: absolute;
			top: 64%;
			left: 25%;
			width: 4%;
			display: inline-block ;
		}
    
    </style>
<title>Package Encounter Association</title>
</head>
<%
		int pkgCount=0;
		String[] pkgCode;
		String[] pkgSeqNo;
		String[] pkgAssocFlag;
		String[] pkgDesc;
		String[] existPkg;
		String bean_id										= 	"BLModifyFinancialDetailsResponse" ;
		String bean_name									= 	"eBL.ModifyFinancialDetails.response.BLModifyFinancialDetailsResponse";
		BLModifyFinancialDetailsRequest modifyFinancialDetailsRequest = new BLModifyFinancialDetailsRequest();
		BLModifyFinancialDetailsDao modifyFinancialDetailsDao = new BLModifyFinancialDetailsDaoImpl();
		List<BLModifyFinancialDetailsResponse> packageDetailsList = new ArrayList<BLModifyFinancialDetailsResponse>();
		//String disabled="",reloadYN="";
	String pkgCodeStr =request.getParameter("pkgCodeStr")==null?"":request.getParameter("pkgCodeStr");
	System.out.println(pkgCodeStr);
	int length=0;
	if(pkgCodeStr.length()>0){
		//System.out.println("18 "+packageDetailsList.size()); 
		/* if(packageDetailsList.size()>0)
			packageDetailsList.clear(); */
		System.out.println("138 "); 
		BLModifyFinancialDetailsResponse modifyFinancialDetailsResponse = null;
		//String pkgCodeStr =(String)request.getParameter("pkgCodeStr");
		System.out.println("140 "); 
		String pkgSeqNoStr = request.getParameter("pkgSeqNoStr")==null?"":request.getParameter("pkgSeqNoStr");
		String pkgAssocFlagStr =request.getParameter("pkgAssocFlagStr")==null?"":request.getParameter("pkgAssocFlagStr");
		String pkgDescStr=request.getParameter("pkgDescStr")==null?"":request.getParameter("pkgDescStr");
		String existPkgRec=request.getParameter("existPkgRec")==null?"":request.getParameter("existPkgRec");
		System.out.println(pkgSeqNoStr);
		System.out.println(pkgAssocFlagStr);
		System.out.println(pkgDescStr);
		System.out.println(existPkgRec);
		pkgCode=pkgCodeStr.split("\\|");
		pkgSeqNo=pkgSeqNoStr.split("\\|");
		pkgAssocFlag=pkgAssocFlagStr.split("\\|");
		pkgDesc=pkgDescStr.split("\\|");
		existPkg=existPkgRec.split("\\|");
		pkgCount=pkgCode.length;
		String existTotPkgRec=request.getParameter("existTotPkgRec")==null?"0":request.getParameter("existTotPkgRec"); 
		System.out.println("pkgCount "+pkgCount); 
		System.out.println("existTotPkgRec in enc assoc=>"+existTotPkgRec); 
		length=Integer.parseInt(existTotPkgRec);
		System.out.println("length "+length); 
		for(int k=0;k<pkgCount;k++){
			System.out.println("156 "); 
			modifyFinancialDetailsResponse = new BLModifyFinancialDetailsResponse();
			System.out.println("156 "+k); 
			System.out.println("160 "+pkgSeqNo[k]); 
			System.out.println("161 "+pkgCode[k]); 
			System.out.println("1762 "+pkgDesc[k]); 
			System.out.println("1762 "+pkgAssocFlag[k]);
			System.out.println("i3o ");
			
			System.out.println("19889 "+existPkg[k]);
			modifyFinancialDetailsResponse.setPkgSeqNo(pkgSeqNo[k]==null?"":pkgSeqNo[k]);
			modifyFinancialDetailsResponse.setPkgCode(pkgCode[k]==null?"":pkgCode[k]);
			modifyFinancialDetailsResponse.setPkgDesc(pkgDesc[k]==null?"":pkgDesc[k]);
			modifyFinancialDetailsResponse.setPkgAssocYN(pkgAssocFlag[k]==null?"":pkgAssocFlag[k]);
			System.out.println("19889 "+existPkg[k]);
			modifyFinancialDetailsResponse.setExistPkgYN(existPkg[k]==null?"":existPkg[k]);
			System.out.println("168 "+modifyFinancialDetailsResponse.getPkgCode());
			packageDetailsList.add(modifyFinancialDetailsResponse);
			System.out.println("169 "+packageDetailsList.size()); 
		}
		
	}else{
		String episodeType = request.getParameter("episodeType");
		String patientId = (String)request.getParameter("patientId");
		String episodeId = (String)request.getParameter("episodeId");
		String visitId = (String)request.getParameter("visitId");
		String facility_id = (String)request.getParameter("facility_id");
		modifyFinancialDetailsRequest.setEpisodeType(episodeType);
		modifyFinancialDetailsRequest.setPatientID(patientId);
		modifyFinancialDetailsRequest.setEpisodeId(episodeId);
		modifyFinancialDetailsRequest.setVisitId(visitId);
		modifyFinancialDetailsRequest.setFacilityId(facility_id);
		packageDetailsList = modifyFinancialDetailsDao.getpackageDetails(modifyFinancialDetailsRequest);
		length=packageDetailsList.size();
	}
	System.out.println("packageDetailsList.size()::"+packageDetailsList.size());
	
	int i=0;
	
	
	/* 
	System.out.println("packageDetailsList.seqno()::"+packageDetailsList.get(0).getPkgSeqNo());
	 */
	
	%>
<body>
<div class='pkgContainer'>
	<div id="headerDiv" class="headercontainer" style="background-color: #00A0DD;" >
		<div class="lookup-title" style="color: white;">Package Encounter Association</div>
	</div>
	<div class="pkgsubcontainer" id="pkgdtls">
		<div  class="pkggridcontainer" >
			<div class="tabl">
				<div class="table-hdr">
					<div class="cell">Seq&nbsp;No</div>
					<div class="cell">Package&nbsp;Code</div>
					<div class="cell">Package&nbsp;Description</div>
					<div class="cell">Associate&nbsp;Y/N</div>
				</div>
				<div class="table-bdy-row" id="tableDtls" contenteditable="false">
				<%if(packageDetailsList.size()>0) {
						for(i=0;i<packageDetailsList.size();i++){%>
							 <div class="row" id="row_<%=i%>"> 
									<div class="cell">
										<input type="text" class="gridInputs"  id="seqNo_<%=i%>" name="seqNo_<%=i%>" value="<%=packageDetailsList.get(i).getPkgSeqNo()%>" disabled readonly/>
									</div> 
									<div class="cell">
									<%if(packageDetailsList.get(i).getExistPkgYN().equals("Y")){%>
										<input type="text" class="gridInputs"  id="pkgCode_<%=i%>" disabled readonly  name="pkgCode_<%=i%>" value="<%=packageDetailsList.get(i).getPkgCode()%>" />
										<input type='hidden' id='existPkg<%=i%>' name='existPkg<%=i%>' value='Y' />
									<%}else{%>
										<input type="text" class="gridInputs"  id="pkgCode_<%=i%>" name="pkgCode_<%=i%>" value="<%=packageDetailsList.get(i).getPkgCode()%>" onchange="clearPkgValues('<%=i%>')" />
										<button class="gridSerachIcon" type="button" onclick="pkgDtlsLkp('pkgCode_<%=i%>','<%=i%>')" id="pkgicon<%=i%>">
											<span class="mdi mdi-magnify"></span>
										</button>
									<%} %>  
									</div> 
									<div class="cell" >
										<input type="text" class="gridInputs"  id="pkgdesc_<%=i%>" name="pkgdesc_<%=i%>" value="<%=packageDetailsList.get(i).getPkgDesc()%>" disabled readonly/>
									</div> 
									 <div class="cell" align="center">
										 <input type="checkbox" class="row-checkbox" id="selectPkg_<%=i%>" <%if(packageDetailsList.get(i).getPkgAssocYN().equals("Y")){%>checked<%}%> name="selectPkg_<%=i%>"  onclick="selectPkg(this,'<%=i%>')" value="<%=packageDetailsList.get(i).getPkgAssocYN()%>" />
									</div>
							</div>
						<%}
						
					}/* else{
							out.println("<script>alert('No data found');</script>");
							//getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')
						} */
					//it will give data only when package is associated otherwise user need to associate from LOV
				%>
				</div>
			</div>
		</div>
	</div>	
	<div class="buttoncontainer" align="right">
		<input type="Button" class="btn btn-primary" value="Add" onclick="addPkgDtls();" >
		<input type="Button" class="btn btn-primary" value="Save" onclick="savePkgDtls();">
		<input type="Button" class="btn btn-primary" value="Close" onclick="closePopup();" >
		&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	
</div>
	
	<br><br>
	<input type="hidden" id="pkgTotalRows" name="pkgTotalRows" value="<%=packageDetailsList.size()%>"/>
	<%-- <input type="hidden" id="prevPkgAsscRows" name="prevPkgAsscRows" value="<%=packageDetailsList.size()%>"/>  --%>
	<input type="hidden" id="prevPkgAsscRows" name="prevPkgAsscRows" value="<%=length%>"/> 
	<input type='hidden' id='QryString' name='QryString' value='<%=request.getQueryString()%>'>
	<input type='hidden' id='selectRec' name='selectRec' value='[]'>
</body>
</html>