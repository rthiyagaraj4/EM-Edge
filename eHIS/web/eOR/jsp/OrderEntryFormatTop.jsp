<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
The logic of implementing this modal window functionality is based on the array.
There are many array as the number of the columns/objects in the form.
Both in the case of adding new set, a new element is added to all the arrays and
while updating the existing set the corresponding array elements from
all the arrays are accessed and populated 
 
-->
<!--
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
24/12/2013      IN044267		 Nijitha S		Alpha-OR-While creating Order Entry Format Item getting �Exception from contoller Jsp:java.lang.NullPointerException"
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>
<%

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrderEntryFormats.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<SCRIPT LANGUAGE="JavaScript">

var seq_arr				= new Array();
var mnemonic_arr		= new Array();
//var mnemonic_arr1		= new Array();

var agegroup_arr		= new Array();
var label_text_arr		= new Array();
var label_text_arr_value= new Array();

var accept_option_arr	= new Array();
var deflt_value_arr		= new Array();
var deflt_value_arr_value		= new Array();

var object_type_arr		= new Array()
var value_arr1			= new Array();
var value_arr2			= new Array();
var dependency_arr		= new Array();
var occ_no_arr		= new Array();
function callDummy(){}

function onLoadDef(level){//Fill the Array's  when the  Category is Laboratory
	if(level == "L"){
	 if(document.getElementById("defFlag").value == "1"){
		 if(seq_arr.length  == 0){ //only when no values inserted in final String
			 var i = 0;
				seq_arr[i]			= "1";
				mnemonic_arr[i]		= "SPECIMEN_TYPE";
				label_text_arr[i]	= "Specimen Type";	
				setFormatValues("labeltextValue_array"+i,label_text_arr[i]);		
				label_text_arr[i]	= "labeltextValue_array"+i;
				//accept_option_arr[i]= "O";
				accept_option_arr[i]= "R";
				deflt_value_arr[i]	= " ";	
				setFormatValues("descValue_array"+i,deflt_value_arr[i]);		
				deflt_value_arr[i]	= "descValue_array"+i;
				agegroup_arr[i]	= " ";
				dependency_arr[i] = " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";
				i++;


				seq_arr[i]			= "2";
				mnemonic_arr[i]		= "NURSE_COLLECT_YN";
				label_text_arr[i]	= "Nurse Collect";
				//if(record[4]!=null||record[4]!="")
				
				setFormatValues("labeltextValue_array"+i,label_text_arr[i]);		 
				label_text_arr[i]	= "labeltextValue_array"+i;				
				accept_option_arr[i]= "O";
				deflt_value_arr[i]	= " ";
				setFormatValues("descValue_array"+i,deflt_value_arr[i]);		
				deflt_value_arr[i]	= "descValue_array"+i;
				agegroup_arr[i]	= " ";
				dependency_arr[i] = " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";
				i++;

				seq_arr[i]			= "3";
				mnemonic_arr[i]		= "COLLECTION_STAGE";
				label_text_arr[i]	= "Collection Stage";
				

				//if(record[4]!=null||record[4]!="")
				
				setFormatValues("labeltextValue_array"+i,label_text_arr[i]);		 
				label_text_arr[i]	= "labeltextValue_array"+i;
			
				accept_option_arr[i]= "D";
				deflt_value_arr[i]	= "Separate";
				setFormatValues("descValue_array"+i,deflt_value_arr[i]);		
				deflt_value_arr[i]	= "descValue_array"+i;
				agegroup_arr[i]	= " ";
				dependency_arr[i] = " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";

	 }
	}
  }
}


function populateVals(val,finalString,obj,k,substr){	
	var valArray = new Array();
	valArray=val.split("~");	
	parent.list_bottom.list_dtl.dontChk.value			=	k;
	parent.list_bottom.list_dtl.seq_no.value			=	(seq_arr[k]);
	parent.list_bottom.list_dtl.mnemonic.value			=	(mnemonic_arr[k]);
	/*for (var repl=0;repl < label_text_arr[k].length;repl++) {
		if (label_text_arr[k].indexOf("�") != -1) {
			label_text_arr[k] = label_text_arr[k].replace("�","&");
		}
		if (label_text_arr[k].indexOf("!!") != -1) {
			label_text_arr[k] = label_text_arr[k].replace("!!","%");
		}
		if (label_text_arr[k].indexOf("�") != -1) {
			label_text_arr[k] = label_text_arr[k].replace("�","!!");
		}
		if (label_text_arr[k].indexOf("�") != -1) {
			label_text_arr[k] = label_text_arr[k].replace("�","+");
		}
		if (label_text_arr[k].indexOf("�") != -1) {
			label_text_arr[k] = label_text_arr[k].replace("�","\\");
		}
	}*/


			var templist=label_text_arr[k];
			label_text_arr_value[k]=label_text_arr[k];
			var bean_id = "Or_OrderEntryFormats";
			var xmlStr = ""; 
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr += "default_val=\""+ templist +"\" " ;			
			xmlStr +=" /></root>" ;

			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id=" + bean_id + "&validate=getdefValue", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;			
			var templist1=responseText;	
			
			
			if((templist1.indexOf("<option>")>0) &&(templist1.indexOf("</option>")>0))
			{
				templist1=templist1.replace("<option>","");
				templist1=templist1.replace("</option>","");			
				label_text_arr_value[k]=trimString(templist1);
			}


	///
	parent.list_bottom.list_dtl.lbl_txt.value			=	(label_text_arr_value[k]);

	parent.list_bottom.list_dtl.accept_option.value		=	(accept_option_arr[k]);
	object_type_arr[k] = eval("parent.list_bottom.list_dtl.hdn_fld_type"+parent.list_bottom.list_dtl.mnemonic.selectedIndex).value
		if(deflt_value_arr[k] == " "||deflt_value_arr[k] =="null"||deflt_value_arr[k] ==null)
			deflt_value_arr[k] = "";
	// the following method will generate the dynamic html for the
	//default value in the modal window depending on the type of the object(textbox/select/check box)
	//var tempo=beforepopulate3(deflt_value_arr[k]);
			var temp=deflt_value_arr[k];
			deflt_value_arr_value[k]=deflt_value_arr[k];
			var bean_id = "Or_OrderEntryFormats";
			var xmlStr = ""; 
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr += "default_val=\""+ temp +"\" " ;			
			xmlStr +=" /></root>" ;

			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "OrderEntryFormatsValidate.jsp?bean_id=" + bean_id + "&validate=getdefValue", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;			
			var temp1=responseText;	
			
			if((temp1.indexOf("<option>")>0) &&(temp1.indexOf("</option>")>0))
			{
				temp1=temp1.replace("<option>","");
				temp1=temp1.replace("</option>","");			
				deflt_value_arr_value[k]=trimString(temp1);
			}
			//var tmpdef=deflt_value_arr_value[k];
	if(deflt_value_arr_value[k]==null||deflt_value_arr_value[k]=="null")deflt_value_arr_value[k]="";
	populateValues1(value_arr1[k],value_arr2[k], object_type_arr[k], deflt_value_arr_value[k], dependency_arr[k])  		
	var obj = parent.list_bottom.list_dtl.dflt_val;//IN044267
	if(obj!=null && obj.value!=null)//IN044267
	parent.list_bottom.list_dtl.dflt_val.value			=	(deflt_value_arr_value[k]); //-- assign the value for the default value
	
	if(agegroup_arr[k] == " ")agegroup_arr[k] = "";
	parent.list_bottom.list_dtl.agegroup.value			=	(agegroup_arr[k]);

	if(dependency_arr[k] == "" || dependency_arr[k] == "N")
		dependency_arr[k]=" ";
	parent.list_bottom.list_dtl.finalValue.value	=	(dependency_arr[k]);

	parent.list_bottom.list_dtl.old_seq_no.value	=(seq_arr[k]);
	if(((mnemonic_arr[k]=="BLOOD_TRANS_EXP_DATE")||(mnemonic_arr[k]=="TRANSPLANT_DATE")||(mnemonic_arr[k]=="NN_MOTHER_PAT_ID")||(mnemonic_arr[k]=="NN_MOTHER_PAT_NAME")))
	{
		parent.list_bottom.list_dtl.old_dflt_val.value="";
		parent.list_bottom.list_dtl.old_dflt_val.disabled = true;
		parent.list_bottom.list_dtl.dflt_val.value="";
		parent.list_bottom.list_dtl.dflt_val.disabled = true;
	}
	parent.list_bottom.list_dtl.old_mnemonic.value	=(mnemonic_arr[k]);
	parent.list_bottom.list_dtl.old_lbl_txt.value	=(label_text_arr_value[k]);
	parent.list_bottom.list_dtl.old_accept_opt.value=(accept_option_arr[k]);
	parent.list_bottom.list_dtl.old_dflt_val.value	=(deflt_value_arr_value[k]);
	parent.list_bottom.list_dtl.old_agegroup.value	=(agegroup_arr[k]);
	parent.list_bottom.list_dtl.old_order_type.value=(object_type_arr[k]);
	parent.list_bottom.list_dtl.old_finalValue.value=(dependency_arr[k]);
	
	//parent.list_bottom.list_dtl.old_position.value	=(position_arr[k]);
	finalString = finalString.replace(valArray[0]," ");
	finalString = finalString.replace(valArray[1]," ");
	//parent.list_bottom.list_dtl.finalString.value=finalString;

	if (mnemonic_arr[k]	== "SPECIMEN_TYPE" || mnemonic_arr[k] ==  "NURSE_COLLECT_YN" || mnemonic_arr[k] ==  "COLLECTION_STAGE") 
	{
		if((occ_no_arr[k]==1)||(occ_no_arr[k]==undefined)||(occ_no_arr[k]=="undefined"))
		{
			parent.list_bottom.list_dtl.clear.disabled = true;
		}
		else
		{
			parent.list_bottom.list_dtl.clear.disabled =false;
		}
		parent.list_bottom.list_dtl.seq_no.disabled = true;
		parent.list_bottom.list_dtl.mnemonic.disabled = true;
		parent.list_bottom.list_dtl.lbl_txt.focus();
		if ((mnemonic_arr[k]	== "COLLECTION_STAGE") || (mnemonic_arr[k]	== "SPECIMEN_TYPE" ))
		{
			parent.list_bottom.list_dtl.accept_option.disabled = true;
		}
		else
		{
			parent.list_bottom.list_dtl.accept_option.disabled = false;
		}
		if (mnemonic_arr[k]	== "SPECIMEN_TYPE" )
			parent.list_bottom.list_dtl.accept_option.value = "R";
	} 
	else 
	{
		parent.list_bottom.list_dtl.clear.disabled = false;
		parent.list_bottom.list_dtl.seq_no.disabled = false;
		parent.list_bottom.list_dtl.mnemonic.disabled = false;
		parent.list_bottom.list_dtl.accept_option.disabled = false;
		parent.list_bottom.list_dtl.seq_no.focus();
	}
			
	

    var ord_cat = parent.list_bottom.list_dtl.ord_cat.value
    var mnemonic = parent.list_bottom.list_dtl.mnemonic.value
	if (mnemonic == 'PATIENT_DIAGNOSIS') 
	{
		parent.list_bottom.list_dtl.dflt_val.value = "";
		parent.list_bottom.list_dtl.dflt_val.disabled = true;		
	}
    if (ord_cat == 'OT') {
   if (((mnemonic == 'PREF_SURG_DATE') || (mnemonic == 'SURGERY_TYPE'))) {
            //parent.list_bottom.list_dtl.accept_option.value = 'R';
            parent.list_bottom.list_dtl.accept_option.disabled = true;
        } else {
            //parent.list_bottom.list_dtl.accept_option.value = 'O';
            parent.list_bottom.list_dtl.accept_option.disabled = false;
        }
    }

    parent.list_bottom.list_dtl.mode.value='update';
	parent.list_depend.location.href="../../eCommon/html/blank.html";
}


</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//String temp="";
//String tempdesc="";
//int strlength;
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String level =  request.getParameter("level")==null?"":request.getParameter("level");

%>
<!-- onLoad="onLoadDef('<%=level%>')" -->
<body  OnMouseDown="CodeArrest()"; onLoad="onLoadDef('<%=level%>')"; onKeyDown="lockKey()">
<form name=list_top>
<table class='grid' width='100%'>
<tr>
	<th class=' COLUMNHEADER' align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
	<th class=' COLUMNHEADER' align="left"><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
	<th class=' COLUMNHEADER' align="left"><fmt:message key="Common.labelText.label" bundle="${common_labels}"/></td>
	<th class=' COLUMNHEADER' align="left"><fmt:message key="Common.AcceptOption.label" bundle="${common_labels}"/></td>
	<th class=' COLUMNHEADER' align="left"><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
</tr>

<%
//The existing values from databse will be fethced for this combination - begin
     	
	String prev_values ="";
	//StringBuffer prev_values=new StringBuffer();	
	String bean_id = "Or_OrderEntryFormats" ;
//	String bean_name = "eOR.OrderEntryFormats";
    OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id, "eOR.OrderEntryFormats", request) ;
	TreeMap finalValues=bean.getFormatFinalValues();
	int mapSize=finalValues.size();
	//String level =  request.getParameter("level")==null?"":request.getParameter("level");;
	String order_category =  request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	
	String finalString = "";//request.getParameter("finalString");//java.net.URLDecoder.decode(,"UTF-8")
	
	if (finalString==null)finalString="";	

	String res = request.getParameter("age_group_sd")==null ?"" :request.getParameter("age_group_sd");
	String res1 = request.getParameter("age_group_cd")==null ?"" :request.getParameter("age_group_cd");
	
	
	if(finalString.equals("") || finalString == null){
		
		finalString="";
		ArrayList mnemonic_values = new ArrayList();
		mnemonic_values = bean.getMnemonics(level, order_category, order_type, order_catalog);
			
		for(int i=0; i<mnemonic_values.size(); i++){
			
			String[] record = (String [])mnemonic_values.get(i);
		
			if(record[4]!=null||record[4]!="")
				
				//bean.setFormatListValues("descValue_array"+record[0],record[4]);
				bean.setFormatListValues("descValue_array"+i,record[4]);
		
				prev_values =prev_values+ record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+"descValue_array"+i+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"~"+record[9]+"~"+record[11]+"`";
				//prev_values.append(record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+record[4]+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"~"+record[9]+"`");
		}	
	
		if((level.trim()).equals("L") && mnemonic_values.size() == 0 && order_category.equalsIgnoreCase("LB") && (mapSize==0)){//i:e create mode and order_category selected is LB
		%>

		<!-- Build the table -->
		<tr>
			<td class="gridData">1</td><td class="gridData"><a class='gridLink' href='javascript:populateVals("","", this ,"0")'><fmt:message key="Common.SpecimenType.label" bundle="${common_labels}"/></a></td><td class="gridData"><fmt:message key="Common.SpecimenType.label" bundle="${common_labels}"/></td><td class="gridData"><fmt:message key="Common.required.label" bundle="${common_labels}"/></td><td class="gridData"></td><td class="gridData"></td>
		</tr>


		<tr>
			<td class="gridData">2</td><td class="gridData"><a class='gridLink' href='javascript:populateVals("","", this ,"1")'><fmt:message key="eOR.NurseCollect.label" bundle="${or_labels}"/></a></td><td class="gridData"><fmt:message key="eOR.NurseCollect.label" bundle="${or_labels}"/></td><td class="gridData"><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></td><td class="gridData"></td><td class="gridData"></td>
		</tr>


        <tr>
			<td class="gridData">3</td><td class="gridData"><a class='gridLink' href='javascript:populateVals("","", this ,"2")'><fmt:message key="eOR.CollectionStage.label" bundle="${or_labels}"/></a></td><td class="gridData"><fmt:message key="eOR.CollectionStage.label" bundle="${or_labels}"/></td><td class="gridData"><fmt:message key="Common.display.label" bundle="${common_labels}"/></td><td class="gridData"><fmt:message key="Common.Separate.label" bundle="${common_labels}"/></td><td class="gridData"></td>
		</tr>

	<%}else{%>

	<%}//Ends

	} else {//End of final string is null	or empty		
		//bean.setFinalString(finalString);
		//finalString = bean.getFinalString();
	}


	if(order_category.equalsIgnoreCase("LB")){%>
		 <INPUT TYPE="hidden" name="defFlag" id="defFlag" value="1">
	<%}else{%>
		  <INPUT TYPE="hidden" name="defFlag" id="defFlag" value="0">
	<%}
//	bean.setFinalString(prev_values);
//The existing values from databse will be fethced for this combination - End

	//finalString = finalString + prev_values;
	//bean.setFinalString(finalString);
	

	//if(finalString != null){
	if(finalValues != null && finalValues.size()>0){
		//StringTokenizer st1		= new StringTokenizer(finalString,"`");
		StringBuffer	result	= new StringBuffer();
		String			mainStr = "";
		String			subStr	= "";
		int				count	= 0;
		String			classval= "";
		String			tempStr = "";
		int				j		= 0;
		Collection c = finalValues.values();     //obtain an Iterator for Collection 
		Iterator itr = c.iterator();     //iterate through TreeMap values iterator  
		while(itr.hasNext())   {   
		//for(int z=0;z<finalValues.size();z++){
		//while(st1.hasMoreTokens()){
			if(j%2 == 0){
				classval = "gridData";
			}else{
				classval = "gridData";
			}

			//mainStr  = st1.nextToken();	
			mainStr = (String)itr.next();
			StringTokenizer st2 = null;
			if(mainStr != null && !mainStr.equals(""))	
			st2 = new StringTokenizer(mainStr,"~");
			result.append("<tr class='"+classval+"'>");
			String[] record = new String[11] ;
			String allValues = "";
			//StringBuffer allValues=new StringBuffer();
			int i=0;

			//this while loop will put the tokenised values to the respective arrays
			
			while(st2 != null && st2.hasMoreTokens()){
				record[i] = st2.nextToken();
				//allValues = allValues+ record[i] + "~";
					//allValues.append(record[i] + "~");				
             
				if(record[i] == null || record[i].trim().equals("null"))
					record[i] = " ";
				//Fill the arrays
				if(i==0){
					out.println("<script>seq_arr["+j+"]="+record[i]+"</script>");
				}else if(i==1){
				   out.println("<script>mnemonic_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==2){					
     				//record[i] = record[i].replace('�','&');
					//record[i] = record[i].replace('s','%');
					//record[i] = record[i].replace('�','!!');
					//record[i] = record[i].replace('�','+');
					//record[i] = record[i].replace('\\','�');
					//tempStr	  = record[i].replace('�','\\');

					tempStr	  = record[i];				
					for (int repl=0;repl < record[i].length();repl++) {
						if(record[i].lastIndexOf("�") != -1) {
							String tempStr1 = record[i].substring(0,record[i].lastIndexOf("�"));
							String tempStr2 = record[i].substring(record[i].lastIndexOf("�")+1,record[i].length());
							record[i] = tempStr1 + "\\\\" + tempStr2;
						}
					}
					
					out.println("<script>label_text_arr["+j+"]='"+record[i]+"';</script>");
					//record[i] = record[i].replace('�','&');
					//record[i] = record[i].replace('!!','%');
					//record[i] = record[i].replace('�','!!');
					//record[i] = record[i].replace('�','+');
					//tempStr	  = record[i].replace('�','\\');
					record[i] = tempStr;
				
				}else if(i==3){
					out.println("<script>accept_option_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==4){
					out.println("<script>deflt_value_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==5){
					out.println("<script>agegroup_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==6){
					out.println("<script>dependency_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==7){
					out.println("<script>object_type_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==8){
					out.println("<script>value_arr1["+j+"]='"+record[i]+"';</script>");
				}else if(i==9){
					out.println("<script>value_arr2["+j+"]='"+record[i]+"';</script>");
				}/*else if(i==10){
					if(record[i].indexOf("||")!=-1)
					{
					strlength=record[i].indexOf("||");
					tempdesc="";	tempdesc=record[i].substring(0,strlength);
					}
				}*/
				else if(i==10)
				{
						out.println("<script>occ_no_arr["+j+"]='"+record[i]+"';</script>");
				}
				i++;
			}

			boolean flag = false ;

			subStr = record[1];

			/*if( order_category.trim().equalsIgnoreCase("LB") && (subStr.trim().equalsIgnoreCase("NURSE_COLLECT_YN")) ){ //subStr.trim().equalsIgnoreCase("SPECIMEN_TYPE") ||
				flag = true ;
			}*/


			//this for loop will build the string of "<td>" and thus the final out put of HTML Table
			for(int k=0; k<record.length-1; k++){
				if(k==6 ||k==7 || k==8 ||k==9)
					continue;				
			
				subStr = record[k];
				
				if (subStr == null || subStr.equals("null")) subStr = " ";
				if(k==3){
			 		if(subStr.equalsIgnoreCase("O"))
						subStr = "Optional";

			 		if(subStr.equalsIgnoreCase("R"))
						subStr = "Required";

			 		if(subStr.equalsIgnoreCase("D"))
						subStr = "Display";

				}

				// this is to remove the space given when there in no value assigned to default value
				if(k==4){
					if(subStr.equals(" ") || subStr.equalsIgnoreCase("N"))
						subStr = "";
					if(subStr.equalsIgnoreCase("Y"))
						subStr = "Checked";	
					String temp1=subStr;					
					String temp2 = bean.checkForNull(bean.getFormatListValues(temp1));
					subStr=temp2;	
				}
				//  this is to assign the agegroup short description for it's appropriate agegroup code				
				if(k==5){
					String val ="";
					String dummy ="";
					StringTokenizer token = new StringTokenizer(res,":");
					final int count2 = token.countTokens();
					String array[] = new String[count2];
					int y = 0;
					ArrayList AgeGroup_Data =  new ArrayList();  
					if(res.equals(""))
					{
						AgeGroup_Data = bean.getAgeGroup();
						for(int x=0; x<AgeGroup_Data.size(); x++){
							String[] record3 = (String [])AgeGroup_Data.get(x);
							if(subStr.equalsIgnoreCase(record3[1]))
							{
								 dummy = record3[0];
							}
						}
						subStr =  dummy;
					}
					if(!res.equals(""))
					{
						while(token.hasMoreTokens())
						{
							val = token.nextToken();
							array[y] = val; 
							y++;
						}
					}
					StringTokenizer token1 = new StringTokenizer(res1,":");
					final int count1 = token1.countTokens();
					String desc[] = new String[count1];
					y= 0;
					if(!res1.equals(""))
					{
						while(token1.hasMoreTokens())
						{
							val = token1.nextToken();
							desc[y] = val; 
							y++;
						}
					}
					y = 0;
					while( y < desc.length)
					{
							if(subStr.equalsIgnoreCase(desc[y]))
							{
									dummy = array[y];
							}
										
								y++;
					}
					subStr= dummy;
					if(subStr.equals(" ")||subStr.equals(""))
					{ subStr= ""; }
			 	}			
				if(flag){
					result.append("<td  class='"+ classval +"'>");
					if (k==2)					
					result.append(subStr);
					result.append("</td>");
				}else{
					result.append("<td  class='"+ classval +"'>");

					if(k==1){
						result.append("<a class='gridLink' href='javascript:populateVals(\""+allValues+"\",\""+ finalString+"\", this ,\""+ j+"\",\""+ subStr+"\")' >");
						subStr =  bean.getMnemonicDesc(order_category,subStr);
					}
					if(k==2)
					{						
						String templabel1=subStr;					
						String templabel2 = bean.checkForNull(bean.getFormatListValues(templabel1));
						subStr=templabel2;	
					}				
					result.append(subStr); 				
					result.append("</a></td>");
			}
		}

			i=0;

			j++;
			result.append("</tr>");
			count++;
		}
		out.println(result.toString());
	}
%>
</table>
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request); 
 
%>

