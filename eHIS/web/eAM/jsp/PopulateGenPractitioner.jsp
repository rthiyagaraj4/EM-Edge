<!DOCTYPE html>
<jsp:useBean id="obj"      scope="session" class="eAM.GenPractSearchServlet"/>
<%@page import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
 <% 
      
     HashMap hash = (HashMap)obj.parseXMLString(request) ;
	String  practName_FValue = (String) hash.get("practName_FValue") ;
	if (practName_FValue==null) practName_FValue ="";

	String  practName_FName = (String) hash.get("practName_FName") ;
	if (practName_FName==null) practName_FName ="";

	String  sql = (String) hash.get("sql") ;
	if (sql==null) sql ="";
    session.putValue("sqlResultPage",sql);
	hash.clear();

%>



var retVal = 	new String();
var dialogHeight= "30" ;
var dialogWidth	= "50" ;
var status = "no";
var arguments	= "" ;
var tit="Pract Search";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;


var sqlArray= new Array();
var practName="<%=practName_FName%>";
var practValue="<%=practName_FValue%>";
var sql="<%=sql%>";
practValue=escape(practValue)
practName=escape(practName)
alert(sql);
sql=escape(sql)

arguments=sqlArray;


	retVal = window.showModalDialog("../../eAM/jsp/GenPractSearchFrame.jsp?practValue="+practValue+"&practName="+practName,arguments,features);
    PractLookupRetVal(retVal,practName);


