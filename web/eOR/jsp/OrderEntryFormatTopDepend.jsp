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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           											created
02/07/2014	IN049133		Chowminya									CRF:Disallow user to enter the future date in the LMP date field
--------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
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
var agegroup_arr		=new Array();
var label_text_arr		= new Array();
var label_text_arr_value= new Array();
var accept_option_arr	= new Array();
var deflt_value_arr		= new Array();
var deflt_value_arr_value		= new Array();
var object_type_arr		= new Array()
var value_arr1			= new Array();
var value_arr2			= new Array();
var dependency_arr		= new Array();//IN049133

function callDummy(){
}


function onLoadDef(level){//Fill the Array's  when the  Category is Laboratory
	if(level == "L"){
	/* if(document.getElementById("defFlag").value == "1"){
		 if(seq_arr.length  == 0){ //only when no values inserted in final String
		 var i = 0;
				seq_arr[i]			= "1";
				mnemonic_arr[i]		= "SPECIMEN_TYPE";
				label_text_arr[i]	= "Specimen Type";
				accept_option_arr[i]= "O";
				//accept_option_arr[i]= "R";
				deflt_value_arr[i]	= " ";
				agegroup_arr[i]	= " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";
				i++;


				seq_arr[i]			= "2";
				mnemonic_arr[i]		= "NURSE_COLLECT_YN";
				label_text_arr[i]	= "Nurse Collect";
				accept_option_arr[i]= "O";
				deflt_value_arr[i]	= " ";
				agegroup_arr[i]	= " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";
				i++;

				seq_arr[i]			= "3";
				mnemonic_arr[i]		= "COLLECTION_STAGE";
				label_text_arr[i]	= "Collection Stage";
				accept_option_arr[i]= "D";
				deflt_value_arr[i]	= "Separate";
				agegroup_arr[i]	= " ";
				object_type_arr[i]	= "";
				value_arr1[i]		= "";
				value_arr2[i]		= "";

	 }
	}*/
  }
}


function populateVals(val,finalString,obj,k){
	var valArray = new Array();
	valArray=val.split("$");
	parent.list_bottom.list_dtl.dontChk.value			=	k;
	parent.list_bottom.list_dtl.seq_no.value			=	(seq_arr[k]);
	parent.list_bottom.list_dtl.mnemonic.value			=	(mnemonic_arr[k]);
	parent.list_bottom.list_dtl.finalValue.value		=	(dependency_arr[k]);//IN049133
	
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
			



	parent.list_bottom.list_dtl.lbl_txt.value			=	(label_text_arr_value[k]);
	parent.list_bottom.list_dtl.accept_option.value		=	(accept_option_arr[k]);
	object_type_arr[k] = eval("parent.list_bottom.list_dtl.hdn_fld_type"+parent.list_bottom.list_dtl.mnemonic.selectedIndex).value
		if(deflt_value_arr[k] == " ")
			deflt_value_arr[k] = "";

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
	// the following method will generate the dynamic html for the
	//default value in the modal window depending onthe type of the object(textboc/select/check box)
	//populateValues1(value_arr1[k],value_arr2[k], object_type_arr[k], deflt_value_arr_value[k]) //IN049133
	var flag = "Depend";//IN049133
	populateValues1(value_arr1[k],value_arr2[k], object_type_arr[k], deflt_value_arr_value[k],dependency_arr[k],flag); //IN049133

	parent.list_bottom.list_dtl.dflt_val.value			=	(deflt_value_arr_value[k]); //-- assign the value for the default value
	if(agegroup_arr[k] == " ")agegroup_arr[k] = "";
	parent.list_bottom.list_dtl.agegroup.value				=	(agegroup_arr[k]);

	//alert("object_type_arr : "+object_type_arr[k])
	//alert("position_arr : "+position_arr[k]);


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
	parent.list_bottom.list_dtl.old_dependency_yn.value=(dependency_arr[k]);//IN049133
//	parent.list_bottom.list_dtl.old_position.value	=(position_arr[k]);

	//alert("k = " +k)
	//alert("value_arr1[k] = " +value_arr1[k])
	//alert("value_arr2[k] = " +value_arr2[k])

	finalString = finalString.replace(valArray[0]," ");
	finalString = finalString.replace(valArray[1]," ");

	parent.list_bottom.list_dtl.finalString.value=finalString;
	/*if (mnemonic_arr[k]	== "SPECIMEN_TYPE" || mnemonic_arr[k] ==  "NURSE_COLLECT_YN" || mnemonic_arr[k] ==  "COLLECTION_STAGE") {
		parent.list_bottom.list_dtl.clear.disabled = true;
		parent.list_bottom.list_dtl.seq_no.disabled = true;
		parent.list_bottom.list_dtl.mnemonic.disabled = true;
		if (mnemonic_arr[k]	== "COLLECTION_STAGE")
			parent.list_bottom.list_dtl.accept_option.disabled = true;
	} else {
		parent.list_bottom.list_dtl.clear.disabled = false;
		parent.list_bottom.list_dtl.seq_no.disabled = false;
		parent.list_bottom.list_dtl.mnemonic.disabled = false;
		parent.list_bottom.list_dtl.accept_option.disabled = false;
	}*/

    var ord_cat = parent.list_bottom.list_dtl.ord_cat.value
    var mnemonic = parent.list_bottom.list_dtl.mnemonic.value

    if (ord_cat == 'OT') {
        if (((mnemonic == 'PERFORM_TEAM_SURGEON') || (mnemonic == 'PREF_SURG_DATE'))) {
            //parent.list_bottom.list_dtl.accept_option.value = 'R';
            parent.list_bottom.list_dtl.accept_option.disabled = true;
        } else {
            //parent.list_bottom.list_dtl.accept_option.value = 'O';
            parent.list_bottom.list_dtl.accept_option.disabled = false;
        }
    }

    parent.list_bottom.list_dtl.mode.value='update';

	//alert("dont chk bval "+parent.list_bottom.list_dtl.dontChk.value);
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
<body onLoad="onLoadDef('<%=level%>')" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=list_top>
<table class='grid' width='100%'>
<tr>
	<th class='columnheader' align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="Common.labelText.label" bundle="${common_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="Common.AcceptOption.label" bundle="${common_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></td>
	<th class='columnheader' align="left"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
</tr>

<%
//The existing values from databse will be fethced for this combination - begin
	String prev_values ="";
    //StringBuffer prev_values=new StringBuffer();
	String bean_id = "Or_OrderEntryFormats" ;
//	String bean_name = "eOR.OrderEntryFormats";
    OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id , "eOR.OrderEntryFormats", request) ;
	//String level =  request.getParameter("level")==null?"":request.getParameter("level");;
	String order_category =  request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	String mnemonic = request.getParameter("mnemonic")==null?"":request.getParameter("mnemonic");
	String seq_no = request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
	String value_seq_num = request.getParameter("value_seq_num")==null?"":request.getParameter("value_seq_num");

	String finalString = request.getParameter("finalString");
	String res = request.getParameter("age_group_sd")==null ?"" :request.getParameter("age_group_sd");
	String res1 = request.getParameter("age_group_cd")==null ?"" :request.getParameter("age_group_cd");
	
	if(finalString.equals("Y") ){
		finalString="";
		ArrayList mnemonic_values = new ArrayList();
		mnemonic_values = bean.get1thMnemonic(level, order_category, order_type, order_catalog, seq_no, mnemonic,value_seq_num);
		
		for(int i=0; i<mnemonic_values.size(); i++){
			String[] record = (String [])mnemonic_values.get(i);
			prev_values =prev_values+ record[0]+"$"+record[1]+"$"+record[2]+"$"+record[3]+"$"+record[4]+"$"+record[5]+"$"+record[6]+"$"+record[7]+"$"+record[8]+"$"+record[10]+"!!"; //IN049133 included record[10]
			//prev_values.append(record[0]+"^"+record[1]+"^"+record[2]+"^"+record[3]+"^"+record[4]+"^"+record[5]+"^"+record[6]+"^"+record[7]+"^"+record[8]+"!!");
		}

	} else if(finalString.equals("N") ) {
		finalString="";
	}


	if(order_category.equalsIgnoreCase("LB")){%>
		 <INPUT TYPE="hidden" name="defFlag" id="defFlag" value="1">
	<%}else{%>
		  <INPUT TYPE="hidden" name="defFlag" id="defFlag" value="0">
	<%}

//The existing values from databse will be fethced for this combination - End
  
	finalString = finalString + prev_values;
	//java.net.URLDecoder.decode(finalString,"UTF-8");
     //bean.setFinalString(finalString);
	if(finalString != null){
		StringTokenizer st1		= new StringTokenizer(finalString,"!!");
		StringBuffer	result	= new StringBuffer();
		String			mainStr = "";
		String			subStr	= "";
		int				count	= 0;
		String			classval= "";
		String			tempStr = "";
		int				j		= 0;
		while(st1.hasMoreTokens()){
			if(j%2 == 0){
				classval = "gridData";
			}else{
				classval = "gridData";
			}

			mainStr  = st1.nextToken();			
			StringTokenizer st2 = new StringTokenizer(mainStr,"$");
			result.append("<tr class='"+classval+"'>");
			String[] record = new String[10] ;
			String allValues = "";
			//StringBuffer allValues=new StringBuffer();
			int i=0;

			//this while loop will put the tokenised values to the respective arrays
			while(st2.hasMoreTokens()){
				
				record[i] = st2.nextToken();
				allValues =allValues+record[i] + "$";
				//allValues.append(record[i] + "^");
				if(record[i] == null || record[i].trim().equals("null"))
					record[i] = " ";
				//Fill the arrays
				if(i==0){
					out.println("<script>seq_arr["+j+"]="+record[i]+"</script>");
				}else if(i==1){
					out.println("<script>mnemonic_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==2){
     				//record[i] = record[i].replace('�','&');
					//record[i] = record[i].replace('!!','%');
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
					out.println("<script>object_type_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==7){
					out.println("<script>value_arr1["+j+"]='"+record[i]+"';</script>");
				}else if(i==8){
					out.println("<script>value_arr2["+j+"]='"+record[i]+"';</script>");
				}//IN049133 - Start
				else if(i==9){
					out.println("<script>dependency_arr["+j+"]='"+record[i]+"';</script>");
				}//IN049133 - End
				i++;
			}

			boolean flag = false ;

			subStr = record[1];

			/*if( order_category.trim().equalsIgnoreCase("LB") && (subStr.trim().equalsIgnoreCase("NURSE_COLLECT_YN")) ){ //subStr.trim().equalsIgnoreCase("SPECIMEN_TYPE") ||
				flag = true ;
			}*/


			//this for loop will build the string of "<td>" and thus the final out put of HTML Table
			for(int k=0; k<record.length-1; k++){
				if(k==6 ||k==7 || k==8)
					continue;
		//j	if(k==1)if(tempdesc!=null)record[k]=tempdesc;	
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
						subStr = "&nbsp;";
					if(subStr.equalsIgnoreCase("Y"))
						subStr = "Checked";
					String temp1=subStr;				
					String temp2=bean.getFormatListValues(temp1);					
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
					{ subStr= "&nbsp;"; }
			 	}	
	
				if(flag){
					result.append("<td  class='"+ classval +"'>");
					//if (k==2)
					//	result.append("<script>alert('"+subStr+"')</script>");
					result.append(subStr);
					result.append("</td>");
				}else{
					result.append("<td  class='"+ classval +"'>");
					//if(k==1)if(tempdesc!=null)record[k]=tempdesc;
					if(k==1){
						result.append("<a class='gridLink' href='javascript:populateVals(\""+allValues+"\",\""+ finalString+"\", this ,\""+ j+"\")' >");
						subStr =  bean.getMnemonicDesc(order_category,subStr);
					}
					if(k==2)
					{
						String templabel1=subStr;					
						String templabel2=bean.getFormatListValues(templabel1);				
						subStr=templabel2;						
					}
					result.append(subStr);
 
					if(k==2);
					result.append("</a></td>");
					
					
				}
		}

			i=0;

			j++;
			result.append("</tr>");
			count++;
		}
		out.println(result.toString());
	}putObjectInBean(bean_id,bean,request);
%>
</table>
</form>
</body>
</html>

