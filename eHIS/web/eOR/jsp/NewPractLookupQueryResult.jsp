<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script> -->
 <SCRIPT LANGUAGE="JavaScript">
  <!--
  function previous(dispDescFirst,bool_user_sql,from,to,fromLink,pract_type,primary_specialty,pract_id,gender,job_title,toggle_sql2,start_ends_contains,pract_name,radiovalue,temp_practID,pract_retval){

	  for(var i=0;i<14;i++){
			
		  if(eval(parent.frames[1].document.getElementById("chk"+i)).checked == true){
				
			  var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;	
			  var Name = eval(parent.frames[1].document.getElementById("pract_name"+i)).value;	
			  var tel_no = eval(parent.frames[1].document.getElementById("tel_no"+i)).value;	
			  var mobile_no = eval(parent.frames[1].document.getElementById("mobile_no"+i)).value;	
			  var pager_no = eval(parent.frames[1].document.getElementById("pager_no"+i)).value;	
			  var job_title = eval(parent.frames[1].document.getElementById("job_title_practDetails"+i)).value;	
			  var pract_type = eval(parent.frames[1].document.getElementById("pract_type")"+i).value;	
			  var pract_type_desc = eval(parent.frames[1].document.getElementById("pract_type_desc"+i)).value;
			  var position_code = eval(parent.frames[1].document.getElementById("job_code"+i)).value;	
			  var position_desc = eval(parent.frames[1].document.getElementById("job_title"+i)).value;	
			// alert(unescape(Name));
			  while(Name.indexOf("+")!=-1)
			  {
				Name=Name.replace('+'," ");
			  }
			   
			  while(pract_type_desc.indexOf("+")!=-1)
			  {
				pract_type_desc=pract_type_desc.replace('+'," ");
			  }
			  if(pract_retval.indexOf(pract_id) != -1){


			  }else{
			  pract_retval +=pract_id+"~"+unescape(Name)+"~"+tel_no+"~"+mobile_no+"~"+pager_no+"~"+job_title+"~"+pract_type+"~"+pract_type_desc+"~"+position_code+"~"+position_desc+"||";
			  }

		  }else{

				var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;
				if(pract_retval.indexOf(pract_id) != -1){
					var int_val= pract_retval.indexOf(pract_id);
					var tmp_retval="";
					if(int_val!=0){
						tmp_retval= pract_retval.substring(0,int_val);
						//alert("tmp_retval=="+tmp_retval+"==="+pract_retval);
						var tmp_retval1= pract_retval.substring(int_val,(pract_retval.length));
						//alert("tmp_retval1=="+unescape(tmp_retval1));
						var int_val1= unescape(tmp_retval1).indexOf("||");
						//alert(int_val);
						var tmp_retval2= unescape(tmp_retval1).substring((int_val+2),(tmp_retval1.length));
						//alert("tmp_retval1=="+tmp_retval+"==="+tmp_retval2);
						
						pract_retval = tmp_retval+tmp_retval2;
					}else{
						var int_val= unescape(pract_retval).indexOf("||");
						var tmp_retval2= unescape(pract_retval).substring((int_val+2),(pract_retval.length));
						//alert("tmp_retval2===="+tmp_retval2);
						pract_retval = tmp_retval2;
					}
					//alert(pract_retval);
			   }

		  }

	  }
	parent.result_frame.location.href="../../eOR/jsp/NewPractLookupQueryResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+(bool_user_sql)+"&from="+(from)+"&to="+(to)+"&fromLink="+(fromLink)+"&pract_type="+(pract_type)+"&primary_specialty="+(primary_specialty)+"&pract_id="+(pract_id)+"&gender="+(gender)+"&job_title="+(job_title)+"&toggle_sql2="+(toggle_sql2)+"&start_ends_contains="+(start_ends_contains)+"&pract_name="+(pract_name)+"&radiovalue="+radiovalue+"&temp_practID="+temp_practID+"&pract_retval="+(pract_retval)+"";
  }

  function next(dispDescFirst,bool_user_sql,from,to,fromLink,pract_type,primary_specialty,pract_id,gender,job_title,toggle_sql2,start_ends_contains,pract_name,radiovalue,temp_practID,pract_retval){


for(var i=0;i<14;i++){
			
		  if(eval(parent.frames[1].document.getElementById("chk"+i)).checked == true){
				
			  var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;	
			  var Name = eval(parent.frames[1].document.getElementById("pract_name"+i)).value;	
			  var tel_no = eval(parent.frames[1].document.getElementById("tel_no"+i)).value;	
			  var mobile_no = eval(parent.frames[1].document.getElementById("mobile_no"+i)).value;	
			  var pager_no = eval(parent.frames[1].document.getElementById("pager_no"+i)).value;	
			  var job_title = eval(parent.frames[1].document.getElementById("job_title_practDetails"+i)).value;	
			  var pract_type = eval(parent.frames[1].document.getElementById("pract_type"+i)).value;	
			  var pract_type_desc = eval(parent.frames[1].document.getElementById("pract_type_desc"+i)).value;
			  var position_code = eval(parent.frames[1].document.getElementById("job_code"+i)).value;	
			  var position_desc = eval(parent.frames[1].document.getElementById("job_title"+i)).value;	
			// alert(unescape(Name));
			  while(Name.indexOf("+")!=-1)
			  {
				Name=Name.replace('+'," ");
			  }
			   
			  while(pract_type_desc.indexOf("+")!=-1)
			  {
				pract_type_desc=pract_type_desc.replace('+'," ");
			  }
			  if(pract_retval.indexOf(pract_id) != -1){


			  }else{
			  pract_retval +=pract_id+"~"+unescape(Name)+"~"+tel_no+"~"+mobile_no+"~"+pager_no+"~"+job_title+"~"+pract_type+"~"+pract_type_desc+"~"+position_code+"~"+position_desc+"||";
			  }

		  }else{

				var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;
				if(pract_retval.indexOf(pract_id) != -1){
					var int_val= pract_retval.indexOf(pract_id);
					var tmp_retval="";
					if(int_val!=0){
						tmp_retval= pract_retval.substring(0,int_val);
						//alert("tmp_retval=="+tmp_retval+"==="+pract_retval);
						var tmp_retval1= pract_retval.substring(int_val,(pract_retval.length));
						//alert("tmp_retval1=="+unescape(tmp_retval1));
						var int_val1= unescape(tmp_retval1).indexOf("||");
						//alert(int_val);
						var tmp_retval2= unescape(tmp_retval1).substring((int_val+2),(tmp_retval1.length));
						//alert("tmp_retval1=="+tmp_retval+"==="+tmp_retval2);
						
						pract_retval = tmp_retval+tmp_retval2;
					}else{
						var int_val= unescape(pract_retval).indexOf("||");
						var tmp_retval2= unescape(pract_retval).substring((int_val+2),(pract_retval.length));
						//alert("tmp_retval2===="+tmp_retval2);
						pract_retval = tmp_retval2;
					}
					//alert(pract_retval);
			   }

		  }

	  }





	parent.result_frame.location.href="../../eOR/jsp/NewPractLookupQueryResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+(bool_user_sql)+"&from="+(from)+"&to="+(to)+"&fromLink="+(fromLink)+"&pract_type="+(pract_type)+"&primary_specialty="+(primary_specialty)+"&pract_id="+(pract_id)+"&gender="+(gender)+"&job_title="+(job_title)+"&toggle_sql2="+(toggle_sql2)+"&start_ends_contains="+(start_ends_contains)+"&pract_name="+(pract_name)+"&radiovalue="+radiovalue+"&temp_practID="+temp_practID+"&pract_retval="+(pract_retval)+"";
  }
  //-->
  </SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body>
<%
String tel_no="";
String mobile_no="";
String pager_no="";
String job_title_practDetails="";
String pract_type_dtls="";
String pract_type_desc="";
	
java.util.Hashtable htjbtitle=new java.util.Hashtable();
	//String  Dcode="";

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String pract_type					=request.getParameter("pract_type");            
	if(pract_type==null) pract_type="";

	String fromLink					=request.getParameter("fromLink");            
	if(fromLink==null) fromLink="";
	
	
	String primary_specialty		=request.getParameter("primary_specialty");
		if(primary_specialty==null) primary_specialty="";
	
	String pract_id						=request.getParameter("pract_id");                
		if(pract_id==null) pract_id="";
	pract_id=pract_id.trim();
	
	String pract_name				=request.getParameter("pract_name");         
		if(pract_name==null) pract_name="";
		pract_name=pract_name.trim();

//out.println("<script>alert(\"getParam  primary_specialty:-"+primary_specialty+"\")</script>");
//out.println("<script>alert(\"getParam pract_id:-"+pract_id+"\")</script>");

	String start_ends_contains=request.getParameter("start_ends_contains");         
		if(start_ends_contains==null) start_ends_contains="";

	String job_title						=request.getParameter("job_title");         
		if(job_title==null) job_title="";

	String gender						=request.getParameter("gender");         
		if(gender==null) gender="";




//out.println("<script>alert(\"user_sql2 k:-"+user_sql2+"\")</script>");


String bool_user_sql						=request.getParameter("bool_user_sql");         
		if(bool_user_sql==null) bool_user_sql="";

String toggle_sql2						=request.getParameter("toggle_sql2");         
		if(toggle_sql2==null) toggle_sql2="";
	
String radiovalue						=request.getParameter("radiovalue");         
		if(radiovalue==null) radiovalue="";
		
		
//out.println("<script>alert(\"radiovalue k       :-"+radiovalue+"\")</script>");


String user_sql="";
String whereClause="";

if(fromLink.equals("")){
session.putValue("sqlResultPage","");
}

whereClause       = (String) session.getValue("sqlResultPage");
//String whereClause = request.getParameter("whereclause");
if(whereClause==null) whereClause="";






//out.println("<script>alert(\"getParam whereClause    :-"+whereClause+"\")</script>");





if(toggle_sql2.equals("")){

user_sql       = (String) session.getValue("sql");

//String user_sql						=request.getParameter("user_sql1");         
		if(user_sql==null) user_sql="";
user_sql=user_sql;
}

if(toggle_sql2.equals("Yes")){
user_sql       = (String) session.getValue("sqlSec");

//String user_sql						=request.getParameter("user_sql1");         
		if(user_sql==null) user_sql="";
user_sql=user_sql;

}
/***************/
//String user_sql2						=request.getParameter("user_sql2");         
	//	if(user_sql2==null) user_sql2="";
//user_sql2=java.net.URLDecoder.decode(user_sql2);
/***************/

//out.println("<script>alert(\"user_sql k    :-"+user_sql+"\")</script>");



if(bool_user_sql.equals(""))
{
if(user_sql.equals("") ) 
	bool_user_sql="0";
else
	bool_user_sql="1";
}

//out.println("<script> alert(\" out equation user_sql:---"+user_sql+"\"); </script>");
//out.println("<script> alert(\" out equation user_sql2:---"+user_sql2+"\"); </script>");

/*
if((!pract_id.equals("") &&  bool_user_sql.equals("1")) ){

out.println("<script> alert(\" inside equation bool_user_sql:---"+pract_id+"\"); </script>");
out.println("<script> alert(\" inside equation pract_id:---"+pract_id+"\"); </script>");
user_sql=user_sql2;

}
*/


//out.println("<script> alert(\" pract_id:---"+pract_id+"\"); </script>");
//out.println("<script> alert(\" pract_name:---"+pract_name+"\"); </script>");

//out.println("<script> alert(\"pract_type:---"+pract_type+"\"); </script>");
/*

out.println("<script> alert(\" primary_specialty:---"+primary_specialty+"\"); </script>");
out.println("<script> alert(\" job_title:---"+job_title+"\"); </script>");
out.println("<script> alert(\" gender:---"+gender+"\"); </script>");
out.println("<script> alert(\" start_ends_contains:---"+start_ends_contains+"\"); </script>");
out.println("<script> alert(\" bool_user_sql:---"+bool_user_sql+"\"); </script>");
out.println("<script> alert(\" bool_user_sql:---"+user_sql+"\"); </script>");

*/
//out.println("<script> alert(\"bool_user_sql BEGINING:---"+bool_user_sql+"\"); </script>");

//code to incorporate  pract id for starts with etc


if(!pract_id.equals("") &&  bool_user_sql.equals("0") )
{
if(start_ends_contains.equals("S"))
					{
						pract_id=pract_id+"%";
					
					}
				else if(start_ends_contains.equals("E"))
				{
						pract_id="%"+pract_id;
				
				}
				else if(start_ends_contains.equals("C"))
				{
						pract_id="%"+pract_id+"%";
				
				}
}
/////////////////////////////////
//out.println("<script> alert(\"pract_id:---"+pract_id+"\"); </script>");



	//String search_desc =request.getParameter("search_desc");
	//String search_code =request.getParameter("search_code");
	String code="";
	String desc="";



%>
<script>



	function closew(Dcode,Name,tel,mobile,pager,job_title,pract_type,pract_type_desc,position_code,position_desc)
	  {
		
		//this loop is to remove the %20 addition in description feilds
		while(Name.indexOf("+")!=-1)
		  {
			Name=Name.replace('+'," ");
	 	  }
		  while(pract_type_desc.indexOf("+")!=-1)
		  {
			pract_type_desc=pract_type_desc.replace('+'," ");
	 	  }
	
//alert("in closew:-"+job_title)
		window.parent.parent.returnValue=Dcode+"~"+Name+"~"+tel+"~"+mobile+"~"+pager+"~"+job_title+"~"+pract_type+"~"+pract_type_desc+"~"+position_code+"~"+position_desc;
		window.parent.parent.close();
	  }
/******function to show practitioner details*********************/
async function showPractWindow(practID)
{
	var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	var dialogHeight= "30" ;
	var dialogWidth	= "40" ;
	var dialogLeft	="";
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	var reportURL   = await window.showModalDialog( url, arguments, features ) ;
}



 </script>


<%
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;

ResultSet rs_practDetail=null;
PreparedStatement pstmt_practDetail=null;

String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

//out.println("<script> alert(\""+whereClause+"\"); </script>");
//out.println("<script> alert(\""+whereClause+"\"); </script>");


String sql="";
String from = request.getParameter( "from" ) ;
String to	= request.getParameter( "to" ) ;
String temp_practID	= request.getParameter( "temp_practID" )==null?"":request.getParameter( "temp_practID" ) ;
String pract_retval	= request.getParameter( "pract_retval" )==null?"":request.getParameter( "pract_retval" ) ;
//String searchcriteria=request.getParameter("search_criteria");
//out.println("<script> alert(\""+pract_retval+"\"); </script>");
//out.println("<script> alert(\""+temp_practID+"\"); </script>");
searchtext = request.getParameter("searchtext");
if(searchtext == null) searchtext="";

//StringTokenizer token=new StringTokenizer(temp_practID,"*");
//while(token.hasMoreTokens()){
//}

//AND a.job_title=NVL('"+job_title+"',a.job_title) 

//out.println("<script>alert(\"user sql:-----"+user_sql+"\")</script>");


if ( (whereClause == null || whereClause.equals("")) )
{

/* if the  user defined sql is not passed bool_user_sql==0 */
if(bool_user_sql.equals("0"))
	{
		
	//out.println("<script>alert(\"inside default:-----"+bool_user_sql+"\")</script>");


	sql = "SELECT  a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name,b.desc_sysdef practitioner_type ,c.short_desc  primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,    DECODE(a.position_code,'CC','Chief Consultant' ,'CO','Consultant','RG','Registrar','RS','Resident','ST','Specialist','SC','Sr. Consultant','SR','Sr. Resident','SP','Sr. Specialist','TR','Trainee') position_code FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=NVL('"+pract_type+"',a.pract_type) AND a.primary_speciality_code=NVL('"+primary_specialty+"',a.primary_speciality_code) AND a.practitioner_id like upper(NVL('"+pract_id+"',a.practitioner_id)) AND  a.gender=NVL('"+gender+"',a.gender) AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL('"+job_title+"',NVL(a.position_code,'123'))) AND a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND upper(a.practitioner_name) LIKE ";

		
//AND ( (0=DECODE('',NULL,1,0) AND a.job_title LIKE '') OR (1=DECODE('',NULL,1,0) AND 1=1))

				if(start_ends_contains.equals("S"))
					{
						pract_name=pract_name+"%";
						sql=sql+"upper(?)";
					}
				else if(start_ends_contains.equals("E"))
				{
						pract_name="%"+pract_name;
						sql=sql+"upper(?)";
				}
				else if(start_ends_contains.equals("C"))
				{
						pract_name="%"+pract_name+"%";
						sql=sql+"upper(?)";
				}

	
	//System.out.println("sql" + sql);
	
	}
	
	/* here the user defined sql is used*/
	else
		{
		//System.out.println("user_defined" + user_sql);
		String strpart1="";
		String strpart2="";
		String final_str="";
		int index2=0;
		int index3=0;
		int index4=0;
		int index1=user_sql.toUpperCase().indexOf("JOB_TITLE");
		//System.out.println("index1" + index1);

		if(index1>0){
			strpart1=user_sql.substring(0,index1);
			
			strpart2=user_sql.substring(index1+9);
			
			final_str=strpart1+"position_code"+strpart2;

		}

		//System.out.println("final_str" + final_str);


		index2=final_str.toUpperCase().indexOf("JOB_TITLE");

		if(index2>0){
			strpart1=final_str.substring(0,index2);
			
			strpart2=final_str.substring(index2+9);
			
			final_str=strpart1+"position_code"+strpart2;

		}
		//System.out.println("final_str" + final_str);


		index3=final_str.toUpperCase().indexOf("JOB_TITLE");

		if(index3>0){
			strpart1=final_str.substring(0,index3);
			
			strpart2=final_str.substring(index3+9);

			final_str=strpart1+"position_code"+strpart2;


		}

				//System.out.println("final_str" + final_str);


		index4=final_str.toUpperCase().indexOf("JOB_TITLE");

		if(index4>0){
			strpart1=final_str.substring(0,index4);
			
			strpart2=final_str.substring(index4+9);

			final_str=strpart1+"position_code"+strpart2;


		}
		//System.out.println("final_str" + final_str);

		

		//System.out.println("last final_str" + final_str);

		if(index1 >0 || index2 >0 || index3 >0 || index4 >0){
			sql=final_str;
		}else{
			sql=user_sql;
		}


		//out.println("<script>alert(\"in else of def sql null"+sql+"\")</script>");
		}

		//System.out.println(" jitu" + sql);

} 
else
	{
//out.println("<script>alert(\"in else of whereclause"+pract_name+"\")</script>");
//out.println("<script>alert(\"in else of whereclause"+whereClause+"\")</script>");

	
sql = whereClause;
if(bool_user_sql.equals("0"))
{
//out.println("<script>alert(\"in else of whereclause"+pract_name+"\")</script>");
pract_name =pract_name;
}
else
{
	
//out.println("<script>alert('in bool_user 1')</script>");
}
	


	}


//int maxRecord = 0;		
int start = 0 ;
int end = 0 ;
int k=0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	
//sql=sql.toUpperCase();
int sqlind=sql.indexOf("order by");
if(sqlind == -1)
{
	sqlind=sql.indexOf("ORDER BY");
}

if(sqlind != -1)
{
	sql = sql.substring(0,sqlind-1);
}

try{

if(radiovalue.equals("C")){
sql=sql+" order by practitioner_id";
}
else{
sql=sql+" order by practitioner_name";
}


stmt = conn.prepareStatement(sql);



/**********************************************/
//code to setString the preparestatement stuff in both the cases
if(bool_user_sql.equals("0")){
	stmt.setString(1,pract_name);

}else{

//out.println("<script>alert(\"in else of bool user pract_name:-"+pract_name+"\")</script>");
//out.println("<script>alert(\"in else of bool user pract_id:-"+pract_id+"\")</script>");
//out.println("<script>alert(\"in else of bool user toggle_sql2:-"+toggle_sql2+"\")</script>");
	
if(toggle_sql2.equals("")){
	
	if(start_ends_contains.equals("S"))
	{
		pract_name=pract_name+"%";
		pract_id=pract_name+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name="%"+pract_name;
			pract_id="%"+pract_name;

	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name="%"+pract_name+"%";
			pract_id="%"+pract_name+"%";

	}
}else{


	if(start_ends_contains.equals("S"))
	{
		pract_name=pract_name+"%";
		pract_id=pract_id+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name="%"+pract_name;
			pract_id="%"+pract_id;

	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name="%"+pract_name+"%";
			pract_id="%"+pract_id+"%";

	}

}
//out.println("<script>alert(\" after in else of bool user pract_name:-"+pract_name+"\")</script>");
//out.println("<script>alert(\"after bool user pract_id:-"+pract_id+"\")</script>");
//out.println("<script>alert(\"after bool user toggle_sql2:-"+toggle_sql2+"\")</script>");

	if(pract_type.equals("")){
		stmt.setString(1,"%");
	}else{
		stmt.setString(1,pract_type);
	}

//out.println("<script>alert(\"pract_type:-----"+pract_type+"\")</script>");

	if(primary_specialty.equals("")){
		stmt.setString(2,"%");
	}else{
		stmt.setString(2,primary_specialty);
	}

//out.println("<script>alert(\"primary_specialty :-----"+primary_specialty+"\")</script>");

	if(pract_id.equals("")){
		stmt.setString(3,"%");
	}else{
		stmt.setString(3,pract_id);
	}

//out.println("<script>alert(\"pract_id:-----"+pract_id+"\")</script>");

	if(pract_name.equals("")){
		stmt.setString(4,"%");
	}else{
		stmt.setString(4,pract_name);
	}

	//out.println("<script>alert(\"pract name:-----"+pract_name+"\")</script>");

	if(gender.equals("")){
		stmt.setString(5,"%");
	}else{
		stmt.setString(5,gender);
	}

//out.println("<script>alert(\"gender:-----"+gender+"\")</script>");
	if(job_title.equals("")){
		stmt.setString(6,"%");
	}else{
		stmt.setString(6,job_title);
	}

//System.out.println("job_title:-----"+job_title);

    }


/*********************************************************************/

rs1=stmt.executeQuery();

while(rs1.next())
{
	k++;

} if(rs1!=null) rs1.close();
//out.println("<script>alert(\"datavalues k:-"+k+"\")</script>");



if(k == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));  if(parent.frames[0].document.getElementById('radiovalue').value == 'D'){                     if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false; }else if (parent.frames[0].document.getElementById('radiovalue').value == 'C'){if(parent.frames[0].document.getElementById('pract_id'))                   parent.frames[0].document.getElementById('pract_id').readOnly=false; }else {if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false;}                         if(parent.frames[0].document.getElementById('Search'))                                       parent.frames[0].document.getElementById('Search').disabled=false;                                         if(parent.frames[0].document.getElementById('clear'))                                                 parent.frames[0].document.getElementById('clear').disabled=false;	document.location.href='../../eCommon/html/blank.html'</script>");

rs = stmt.executeQuery();
%>

<table align='right'>
<tr>
<td>

<%
//	out.println("<script>alert('"+pract_id+"')</script>");


if ( !(start <= 1) ){
	//out.println("<A HREF='../../eOR/jsp/NewPractLookupQueryResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start-14)+"&to="+(end-14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&pract_id="+URLEncoder.encode(pract_id)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name)+"&radiovalue="+radiovalue+"&temp_practID="+temp_practID+"&pract_retval="+URLEncoder.encode(pract_retval)+"' text-decoration='none'>Previous</A>");
	
	%>
		<a href='#' onClick="previous('<%=dispDescFirst%>','<%=URLEncoder.encode(bool_user_sql)%>','<%=(start-14)%>','<%=(end-14)%>','Yes','<%=URLEncoder.encode(pract_type)%>','<%=URLEncoder.encode(primary_specialty)%>','<%=URLEncoder.encode(pract_id)%>','<%=URLEncoder.encode(gender)%>','<%=URLEncoder.encode(job_title)%>','<%=URLEncoder.encode(toggle_sql2)%>','<%=URLEncoder.encode(start_ends_contains)%>','<%=URLEncoder.encode(pract_name)%>','<%=radiovalue%>','<%=temp_practID%>','<%=URLEncoder.encode(pract_retval)%>')" text-decoration='none'>Previous</a>
		<%
}
if ( !( (start+14) > k ) ){
	//out.println("<A HREF='../../eOR/jsp/NewPractLookupQueryResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start+14)+"&to="+(end+14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_id="+URLEncoder.encode(pract_id)+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name)+"&radiovalue="+radiovalue+"&temp_practID="+temp_practID+"&pract_retval="+URLEncoder.encode(pract_retval)+"' text-decoration='none'>Next</A>");
%>
		<a href='#' onClick="next('<%=dispDescFirst%>','<%=URLEncoder.encode(bool_user_sql)%>','<%=(start+14)%>','<%=(end+14)%>','Yes','<%=URLEncoder.encode(pract_type)%>','<%=URLEncoder.encode(primary_specialty)%>','<%=URLEncoder.encode(pract_id)%>','<%=URLEncoder.encode(gender)%>','<%=URLEncoder.encode(job_title)%>','<%=URLEncoder.encode(toggle_sql2)%>','<%=URLEncoder.encode(start_ends_contains)%>','<%=URLEncoder.encode(pract_name)%>','<%=radiovalue%>','<%=temp_practID%>','<%=URLEncoder.encode(pract_retval)%>')" text-decoration='none'>Next</a>
		<%
}
%>
</td>
</tr>
</table>
<BR>
</P>
<%

String jb_title="select practitioner_id,position_desc,am_practitioner.position_code from am_practitioner ,am_position where am_practitioner.position_code=am_position.POSITION_CODE and am_position.role_type='P' and am_position.eff_status='E'";

pstmt_practDetail   = conn.prepareStatement(jb_title) ;
//pstmt_practDetail.setString( 1, pract_id1);
 rs_practDetail = pstmt_practDetail.executeQuery() ;

if(rs_practDetail != null){
	while(rs_practDetail.next()){
		htjbtitle.put(rs_practDetail.getString("practitioner_id"),rs_practDetail.getString("position_desc"));
		if(rs_practDetail.getString("position_desc") != null){
			//out.println("<script>alert('=="+rs_practDetail.getString(3)+"===')</script>");
htjbtitle.put(rs_practDetail.getString("practitioner_id")+rs_practDetail.getString("position_desc"),rs_practDetail.getString(3));
		}

	}
}       if (rs_practDetail != null) rs_practDetail.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();
%>



	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
	<%if(dispDescFirst.equals("dispDescFirst")) {%>
	<th width='60%'>Description</th>
	<th width='40%'>Code</th>
	<%} else {%>
	<th >+</th>
	<th >Practitioner ID</th>
	<th >Practitioner Name</th>
	<th >Practitioner Type</th>
	<th >Specialty</th>
	<th >Gender</th>
	<th >Position</th>
	<th >Select</th>
	
	<%} %>

	<%String checked="";int x=0;
if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{//out.println("<script>alert('i:---"+j+"---')</script>");
%>
<%  
	String rowclass = "" ;
	String me="";
	String job_code="";
	//String d="/";
		if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;
	code				=	rs.getString("practitioner_type");
	desc				=	rs.getString("primary_specialty");
	String pract_id1	=	rs.getString("practitioner_id");
	String pract_name1	=	rs.getString("practitioner_name");
//	pract_name1=
	String gender1		=	rs.getString("gender");
	String job_title1	=	rs.getString("position_code");
//out.println("<script>alert('pract_id1:-"+pract_id1+"')</script>");
		if(job_title1==null) job_title1="&nbsp;";
	    	

/*************get pther details for practitioner********************/
String sql_pract_detail="select off_tel_num,mobile_num,pager_num,job_title,pract_type, pract_type_desc from am_practitioner_vw  where practitioner_id=? ";


pstmt_practDetail   = conn.prepareStatement(sql_pract_detail) ;
pstmt_practDetail.setString( 1, pract_id1);
rs_practDetail = pstmt_practDetail.executeQuery() ;
 // out.println("resultSet:-"+resultSet); 	 
//out.println("<script>alert('pract_id1:-"+pract_id1+"')</script>");

	if(rs_practDetail != null)
	{
		while(rs_practDetail.next())
		{
			tel_no = rs_practDetail.getString("off_tel_num");
			if(tel_no==null) tel_no="";

	//out.println("<script>alert('"+tel_no+"')</script>");
			
			mobile_no = rs_practDetail.getString("mobile_num");
			if(mobile_no==null) mobile_no="";

			pager_no = rs_practDetail.getString("pager_num");
			if(pager_no==null) pager_no="";
		
			job_title_practDetails = rs_practDetail.getString("job_title");
			if(job_title_practDetails==null) job_title_practDetails="";
		
			pract_type_dtls = rs_practDetail.getString("pract_type");
			if(pract_type_dtls==null) pract_type_dtls="";
		
			pract_type_desc = rs_practDetail.getString("pract_type_desc");
			if(pract_type_desc==null) pract_type_desc="";
		//	a_res_addr_line4 = rs_practDetail.getString("addr1_line4");
		//
		
	//		out.println("<script>alert('job_title_practDetails:-"+job_title_practDetails+"')</script>");
		
		}
	}if (rs_practDetail != null) rs_practDetail.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();

		/**********************************/

		out.println("<tr style='background-color:;' id='pract_details"+k+"'><td class='"+rowclass+"'>");
	//this case is redundant as of now....
		if(dispDescFirst.equals("dispDescFirst")) {
		me=desc+"::"+code;
	%>
		<a href=javascript:closew("<%=me%>")>
	<%	out.println(desc+"</a></td><td width='2%' class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		//used as of now...
		else
		{
		me=code;
		out.println("<a href=\"javascript:showPractWindow('"+pract_id1+"')\">+</a></td>");
		job_title1=(String) htjbtitle.get(pract_id1);
		
		if(job_title1==null || job_title1.equals("null")){
			job_title1="&nbsp;";
			job_code="";
		}else{
			//out.println("<script>alert('=1="+(String) htjbtitle.get(pract_id1+job_title1)+"===')</script>");
			job_code = (String) htjbtitle.get(pract_id1+job_title1);
		}
		%>
		<td class=<%=rowclass%>><!-- <a href=javascript:closew("<%=pract_id1%>","<%=java.net.URLEncoder.encode(pract_name1)%>","<%=java.net.URLEncoder.encode(tel_no)%>","<%=java.net.URLEncoder.encode(mobile_no)%>","<%=java.net.URLEncoder.encode(pager_no)%>","<%=java.net.URLEncoder.encode(job_title_practDetails)%>","<%=java.net.URLEncoder.encode(pract_type_dtls)%>","<%=java.net.URLEncoder.encode(pract_type_desc)%>","<%=java.net.URLEncoder.encode(job_code)%>","<%=java.net.URLEncoder.encode(job_title1)%>")><%=pract_id1%></a> --><%=pract_id1%></td>
		<%
		out.println( "<td class='"+rowclass+"'>");
		
		%>
		<!-- <a href=javascript:closew("<%=pract_id1%>","<%=java.net.URLEncoder.encode(pract_name1)%>","<%=java.net.URLEncoder.encode(tel_no)%>","<%=java.net.URLEncoder.encode(mobile_no)%>","<%=java.net.URLEncoder.encode(pager_no)%>","<%=java.net.URLEncoder.encode(job_title_practDetails)%>","<%=java.net.URLEncoder.encode(pract_type_dtls)%>","<%=java.net.URLEncoder.encode(pract_type_desc)%>","<%=java.net.URLEncoder.encode(job_code)%>","<%=java.net.URLEncoder.encode(job_title1)%>")> -->
		<%
		//out.println( pract_name1	+"</a></td>" );
		out.println( pract_name1	+"</a></td>" );
		out.println("<td class='"+rowclass+"'>");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td>" );
		out.println( "<td class='"+rowclass+"'>"+ gender1			+"</td>" );
		out.println( "<input type='hidden' name='pract_id"+x+"' id='pract_id"+x+"' value='"+pract_id1+"'>" );
		out.println( "<input type='hidden' name='pract_name"+x+"' id='pract_name"+x+"' value='"+pract_name1+"'>" );
		out.println( "<input type='hidden' name='tel_no"+x+"' id='tel_no"+x+"' value='"+tel_no+"'>" );
		out.println( "<input type='hidden' name='mobile_no"+x+"' id='mobile_no"+x+"' value='"+mobile_no+"'>" );
		out.println( "<input type='hidden' name='pager_no"+x+"' id='pager_no"+x+"' value='"+pager_no+"'>" );
		out.println( "<input type='hidden' name='job_title_practDetails"+x+"' id='job_title_practDetails"+x+"' value='"+job_title_practDetails+"'>" );
		out.println( "<input type='hidden' name='pract_type"+x+"' id='pract_type"+x+"' value='"+pract_type_dtls+"'>" );
		out.println( "<input type='hidden' name='pract_type_desc"+x+"' id='pract_type_desc"+x+"' value='"+pract_type_desc+"'>" );
		out.println( "<input type='hidden' name='job_code"+x+"' id='job_code"+x+"' value='"+job_code+"'>" );
		out.println( "<input type='hidden' name='job_title"+x+"' id='job_title"+x+"' value='"+job_title1+"'>" );
		out.println( "<input type='hidden' name='role"+x+"' id='role"+x+"' value=''>" );
		//if(temp_practID.indexOf(pract_id1) != -1)
		if(pract_retval.indexOf(pract_id1) != -1)
			checked= "checked";
		else
			checked= "";
		//out.println( "<td class='"+rowclass+"'>"+ job_title1		+"</td></tr>" );
		//out.println("<script>alert('=x="+x+"===')</script>");
		out.println( "<td class='"+rowclass+"'>"+ job_title1		+"</td>" );
		out.println( "<td class='"+rowclass+"' align=center><input type=checkbox name='chk"+x+"' id='chk"+x+"' "+checked+"></td></tr>" );
		}
		i++;x++;	  
	 }
	out.println( "<input type='hidden' name='pract_retval' id='pract_retval' value='"+pract_retval+"'>" );
  %>
<script>
//if(parent.frames[0].document.getElementById("pract_type"))
//parent.frames[0].document.getElementById("pract_type").disabled=false;                 

//if(parent.frames[0].document.getElementById("primary_specialty"))
//parent.frames[0].document.getElementById("primary_specialty").disabled=false;     

if(parent.frames[0].document.getElementById("pract_id"))
parent.frames[0].document.getElementById("pract_id").readOnly=false;                     

if(parent.frames[0].document.getElementById("pract_name"))
parent.frames[0].document.getElementById("pract_name").readOnly=false;               

//if(parent.frames[0].document.getElementById("job_title"))/
//parent.frames[0].document.getElementById("job_title").disabled=false;                     

//if(parent.frames[0].document.getElementById("gender"))
//parent.frames[0].document.getElementById("gender").disabled=false;

if(parent.frames[0].document.getElementById("Search"))
parent.frames[0].document.getElementById("Search").disabled=false;

if(parent.frames[0].document.getElementById("clear"))
parent.frames[0].document.getElementById("clear").disabled=false;

</script>
	  <%
   
  } if (rs != null) rs.close();if (stmt != null) stmt.close();
}catch(Exception e) { 
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally
	{
	
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();
		if (rs_practDetail != null) rs_practDetail.close();
		if (stmt != null) stmt.close();
	
	
	
	}

session.putValue("sqlResultPage",sql);
%>
</table>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
</BODY>
</html>
<%
}catch(Exception e) {
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

