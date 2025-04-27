<!DOCTYPE html>


<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String retVal =request.getParameter("mesg");


//retVal = retVal.replace("|#","");
//cust_desc =cust_desc.replace(/\#/g,' ');	
//cust_desc =cust_desc.replace(/\&/g,' ');	

//retVal = "SUCCESS$|#ADIBAH BINTI HASHIM$|#780504086208$|#PENTADBIR/KLINIKAL, PEGAWAI PERUBATAN, GRED UD43/UD44/UD47/UD48/UD51/UD52/UD53/UD54$|#$|#Kelas 1 Bilik Seorang$|#UNIT KAWALAN AMALAN PERUBATAN SWASTA (UKAPS)$|#HASHIM B. MOHAMAD SAID$|#411103085083$|#04^Father$|#QB^JKN$!#QB000001^JABATAN KESIHATAN NEGERI SELANGOR$|#UD52$|#HSEL/eGL/100001!S!";

System.out.println(" mesg"+retVal);

String arr[] = retVal.split("$|#");

for(int i=0;i<arr.length;i++)
	System.out.println(" pos :"+i+" value  "+arr[i]);

String  pos1=arr[1].replace("$|","");
String pos2=arr[2].replace("$|","");
String pos3=arr[3].replace("$|","");
String pos4=arr[4].replace("$|","");
String pos5=arr[5].replace("$|","");
String pos6=arr[6].replace("$|","");
String pos7=arr[7].replace("$|","");
String pos8=arr[8].replace("$|","");
String pos9=arr[9].replace("$|","");
String cust_grp_code="";
String cust_grp_desc="";
String cust_code="";
String cust_desc="";
String  relnCode ="";
String  relnDesc ="";
int loc=0;
if(arr[9]!=null && arr[9].length()>0){
	
	  loc= arr[9].indexOf('^');	 
	  	  if(loc != -1)
	{
	 relnCode=arr[9].substring(0,loc);
	 relnDesc=arr[9].substring(loc+1,arr[9].length()-2);
	}
	else
	{
		relnCode = arr[9];
		relnDesc ="SELF";
	}
	}

if(arr[10]!=null && arr[10].length()>0){
	
  loc= arr[10].indexOf('^');
  System.out.println("Location "+loc);
 cust_grp_code=arr[10].substring(0,loc);
 cust_grp_desc=arr[10].substring(loc+1,arr[10].length()-2);
}


if(arr[11]!=null && arr[11].length()>0){
	loc= arr[11].indexOf('^');		
	 cust_code=arr[11].substring(0,loc);
	 cust_desc=arr[11].substring(loc+1,arr[11].length()-2);
	}
	String pos12=arr[12].replace("$|","");

	// Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018
	String pos13=arr[13].replace("$|","");


%>
<title>eGL Confirmation window</title>
<script>

   function confirmeGL()
    {
	   
	   var formObj = document.forms[0];
	   var retVal = formObj.cust_grp_code.value+"^"+formObj.cust_code.value+"^"+formObj.reln_code.value+"^"+formObj.reln_paymnt.value+"^"+formObj.doc_id.value;	  

	   // +"^"+formObj.doc_id.value Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018
	   //alert('confirmGL '+retVal);
	   parent.window.returnValue = retVal;
	   parent.window.close();	  
    }
   
   function canceleGL()
   {
	 //  alert('canceleGL');
	   parent.window.returnValue = 'N';
	   parent.window.close();	  
   }
   
   

	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	
	
</script>
</head>

<body>
      <form name ='eGLConfirmForm' >
			<table width='100%'>
			<tr>
			<td  width='60%' nowrap class="label" align = 'left'>
			<label nowrap style="font-size:12;font-weight:bold"> Nama Pegawai</label></td>
			<td  width='40%' nowrap class="label" align right>:<%=pos1%> 
			<input type='hidden' name=reln_paymnt value ="<%=pos1 %>">
			</td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">No. K/P</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos2%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Jawatan</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos3%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Gred</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos12%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Kelayakan Kelas Wad</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos5%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Nama Tempat Kerja</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos6%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Nama Pesakit</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos7%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">No. Kad Pengenalan Pesakit</label></td>
			<td width='40%' nowrap class="label" align right>:<%=pos8%> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Perhubungan Keluarga</label></td>
			<td width='40%' nowrap class="label" align right>:<%=relnDesc%>
			<input type='hidden' name=reln_code value ="<%=relnCode %>">
			<input type='hidden' name=reln_desc value ="<%=relnDesc %>"> </td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Customer Group</label></td>
			<td width='40%' nowrap class="label" align right>:<%=cust_grp_desc%> 
			<input type='hidden' name=cust_grp_code value ="<%=cust_grp_code %>"></td>			
			</tr>
			<tr>
			<td width='60%' nowrap class="label" align = 'left'><label nowrap style="font-size:12;font-weight:bold">Customer</label></td>
			<td width='40%' nowrap class="label" align right>:<%=cust_desc%> 
			<input type='hidden' name=cust_code value ="<%=cust_code %>"></td>	
			<input type='hidden' name="doc_id" id="doc_id" id="doc_id" value ="<%=pos13 %>"></td>	
			</tr>
			<tr>			
			<td width='60%'>&nbsp;</td>
			<td class='label' width='25%'>
			<input type="button" name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class="button" onClick='confirmeGL(cust_grp_code,cust_code)' >&nbsp;
			<input type="button" name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class="button"  onClick='canceleGL()' >
			</td>
			
			</table></form>
</body>
		
</html>

