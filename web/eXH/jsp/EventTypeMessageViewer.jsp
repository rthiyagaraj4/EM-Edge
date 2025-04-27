<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
  
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY,eXH.XHIdentify,java.util.Arrays,java.util.regex.Pattern;" %>


<head>
<link rel="StyleSheet" href="../../eXH/html/IeStyle.css" type="text/css" />
<link rel="StyleSheet" href="../../eXH/html/dtree.css" type="text/css" />
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel="StyleSheet" href="../../eXH/html/lris_style.css" type="text/css" />
<script type="text/javascript" src="../../eXH/js/dtree1.js"></script> 
 
	<script>
	
	</script>
</head>  
<BODY   >
<form name="view_segment_form" id="view_segment_form">
                        
<div class='dtree'>
	<script type="text/javascript" src="../../eXH/js/dtree1.js"></script>
<script type='text/javascript'>
	d = new dTree('d');
	d.config.useStatusText=true;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='TREEBODY'>
<script>
var count=1;
<%
String locale = ((String)session.getAttribute("LOCALE"));
Connection connection = null;
Statement  oraclestatement = null;
HashMap resultsQry = null;
HashMap resultssegQry = null;
Statement  statement = null;

String eventType="";
String eventName="";
String appl_id="";
String Standard_code="";
String System_def_string="";
String appl_name="";
appl_id=(String)session.getAttribute("appl_id");
appl_name=(String)session.getAttribute("appl_name");
eventType=(String)session.getAttribute("Event_id");
eventName=(String)session.getAttribute("event_name");
Standard_code=(String)session.getAttribute("stand_code");
String profile_id="";
int capval=0;
Pattern Regex = null;

ResultSet rset=null; 

ArrayList seg=new ArrayList();
int countpip=0;
String replacestr="";
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of EventTypeMessageViewer.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
{
	resultsQry=XHIdentify.treeHashMap(connection,locale);
    resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	int k=0;
String profileqry="select PROFILE_ID from XH_APPL_EVENT_SEGMENT where application_ID = '"+appl_id+"' and eVENT_TYPE='"+eventType+"'  AND ROWNUM = 1";

//statement=connection.createStatement();
 oraclestatement=connection.createStatement();
//reset=statement.executeQuery(profileqry);
rset=oraclestatement.executeQuery(profileqry);

while(rset.next())
{ 
	profile_id=rset.getString(1);
}
	 
String usrsql="select segment_type from XH_EVENT_TYPE_SEGMENT where event_type='"+eventType+"' and IN_USE_YN='Y' ";
	
	
	 rset=oraclestatement.executeQuery(usrsql);
while(rset.next())
{
	seg.add(k,rset.getString(1));
	k++;
}
 

if(statement!=null)
	statement.close();
if(oraclestatement!=null) 
	oraclestatement.close();
		 
if(rset!=null)	   
{
	rset.close();
}

  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(appl_name)+"','','"+appl_id+"');"); 
 out.println("d.add(1,0,'"+XHDBAdapter.checkNull(eventName)+"','','"+eventName+"');");
 int count=0;
 int countseg=0;
 countseg=seg.size()+1;
for(int i=0;i<seg.size();i++)
	{ 
count=2+i;


if((String)resultssegQry.get((String)seg.get(i))==null) 
  {
out.println("d.add("+count+",1,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');"); 

  }
  else
	{
	  out.println("d.add("+count+",1,'"+(String)resultssegQry.get((String)seg.get(i))+"','','"+(String)resultssegQry.get(i)+"');"); 
	}
/*String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='SRRHL7P' AND CONFIG_NAME ='NTE' and STANDARD_CODE='SRRHL7' AND Config_type = 'S'";*/
String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='"+profile_id+"' AND CONFIG_NAME ='"+(String)seg.get(i)+"' and STANDARD_CODE='"+Standard_code+"' AND Config_type = 'S'";
//System.out.println("EventTypeMessageViewer.jsp : segmentqry "+segmentqry);
ResultSet segset=null;
Statement  segstatement = null;
segstatement=connection.createStatement();
segset=segstatement.executeQuery(segmentqry);
while(segset.next())
{

   System_def_string=segset.getString(1);
   String Systemdefstr=System_def_string.replace("#","|");
   try{
        Regex = Pattern.compile("\\|",Pattern.MULTILINE);
      }
      catch(Exception e)
      {
        System.out.println(" (EventTypeMessageViewer.jsp:Regexerorr )"+e);
      }
      String[] array=Regex.split(Systemdefstr);
      for(int check=2;check<array.length;check++)
	  {
	    if(array[check].equals(""))
	    {
	    }
	    else
	    {
		  countpip=array.length;
		  countseg=countseg+1;
          // if((String)resultsQry.get(array[check])==null)
         // {
 
        
			if(array[check].indexOf("^")!=-1)
	       {
				 
	            countpip=countpip+1;
          try{
                Regex = Pattern.compile("\\^",Pattern.MULTILINE);
             }
             catch(Exception e)
             {
                System.out.println("(EventTypeMessageViewer.jsp:erorrRegex-2) "+e);
             } 
                String[] arraycap=Regex.split(array[check]);
             for(int cap=0;cap<arraycap.length;cap++)
		     {

                 

				
				 if(cap==0)
				 {
				  String validation=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:((String)resultsQry.get(arraycap[cap])); out.println("d.add("+countseg+","+count+",replacefun(unescape('"+java.net.URLEncoder.encode(validation)+"')),'','"+arraycap[cap]+"');");
				 capval=countseg;
				 }
				else 
				 {
				  capval=capval+1; 
				  String validation2=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:((String)resultsQry.get(arraycap[cap]));
				  
				 out.println("d.add("+(capval)+","+(countseg)+",replacefun(unescape('"+java.net.URLEncoder.encode(validation2)+"')),'','"+arraycap[cap]+"');"); 
				 }
				 
				 //countseg=countseg+1; //out.println("d.add("+countpip+","+countseg+",replacefun(unescape('"+arraycap[cap]+"')),'','"+arraycap[cap]+"');");
		     }
			 countseg=capval+1;
	        }
			else
			  {
					  String validation1=((String)resultsQry.get(array[check]))==null?array[check]:java.net.URLEncoder.encode((String)resultsQry.get(array[check]));
							replacestr=validation1;	 out.println("d.add("+countseg+","+count+",replacefun(unescape('"+replacestr+"')),'','"+array[check]+"');");
			  }
         // }
		 // else
		 // {
         //   replacestr=((String)resultsQry.get(array[check]));
            //out.println("d.add("+countseg+","+count+",replacefun(unescape('"+java.net.URLEncoder.encode(replacestr)+"')),'','"+array[check]+"');");
		 //  }

		   
   	    }
	  	  

	}
}

	if(segset!=null)
	{
		segset.close();
	}
	if(segstatement!=null)
	{
		segstatement.close();
	}



	  }


//out.println("d.add("+count+",2,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');")
	


 
} 
catch(Exception exp)
    {
	   exp.printStackTrace(System.err);
    }
	finally
	{
	 try{
			if(rset!=null)	   
			{
				rset.close();
			}
						
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of EventTypeMessageViewer.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
	}

%>
document.write(d);
d.openAll();




function replacefun(str)
{
if(str.indexOf('+')!=-1)
	{
	var t = /\+/g; 
str=str.replace(t," ");

    
	}
	else
	{

	}
	return str;
}


</script>

</body>


</form>

</body>
</div>
</html>




