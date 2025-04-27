<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
  
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY,eXH.XHIdentify,java.util.Arrays,java.util.regex.Pattern,eXH.XHDBAdapter" %>
 

<head> 
	<link rel="StyleSheet" href="../../eXH/html/dtree.css" type="text/css" />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="StyleSheet" href="../../eXH/html/lris_style.css" type="text/css" />
	<link rel="StyleSheet" href="../../eXH/html/IeStyle.css" type="text/css" />


<script type="text/javascript" src="../../eXH/js/dtree1.js"></script> 

	<script>
	
	</script>  
</head>
<BODY   >
<form name="view_segment_form" id="view_segment_form">
                       
<div class='dtree'>
<script type='text/javascript'>
	d = new dTree('d');
	d.config.useStatusText=true;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='TREEBODY'>
<script> 
var count=1;
<%
int capval=0;
		String locale = ((String)session.getAttribute("LOCALE"));
		locale = "en"; 
		Connection connection = null;
		Statement  segstatement = null;
		String SegType="";
		String SegName="";
		String prof_id="";
		String Standard_code="";
		String System_def_string="";
		HashMap resultsQry = null;
		HashMap resultssegQry = null;
		prof_id=(String)session.getAttribute("Profile_id");
		SegType=(String)session.getAttribute("Segment_id");
		SegName=(String)session.getAttribute("Segment_name");
		Standard_code=(String)session.getAttribute("stand_code");
		
		Pattern Regex = null;
		ResultSet segset=null;
		
		
		
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
     
    }
    catch(Exception exp)
    {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
    }
try
{
	
	    resultsQry=XHIdentify.treeHashMap(connection,locale);
	   resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	   resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	if(prof_id.equals(""))
	{
	  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(prof_id)+"','','ALL');"); 
	}
	else
	{
	  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(prof_id)+"','','"+XHDBAdapter.checkNull(prof_id)+"');"); 
	}
	 int count=2; 

out.println("d.add(1,0,'"+SegName+"','','"+SegName+"');"); 

String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='"+prof_id+"' AND CONFIG_NAME ='"+SegType+"' and STANDARD_CODE='"+Standard_code+"' AND Config_type = 'S'";
//System.out.println("SegmentTypeMessageViewer.jsp segmentqry :"+segmentqry); 

segstatement=connection.createStatement();
segset=segstatement.executeQuery(segmentqry);
		while(segset.next())
	  {
		System_def_string=segset.getString(1);
		String Systemdefstr=System_def_string.replaceAll("#","|");
	 try{
		Regex = Pattern.compile("\\|",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
		System.out.println("(SegmentTypeMessageViewer.jsp:Exception) :"+e);
		}
		String[] array=Regex.split(Systemdefstr);
		for(int check=1;check<array.length;check++)
		{
	
		  if(array[check].equals(""))
		  {
		  }
		  else
		  {
				if(array[check].indexOf("^")!=-1)
			   {			
     
				  try{
						Regex = Pattern.compile("\\^",Pattern.MULTILINE);
					 }
					 catch(Exception e)
					 {
						System.out.println("(SegmentTypeMessageViewer.jsp:Exception) : "+e);
					 } 
                String[] arraycap=Regex.split(array[check]);
             for(int cap=0;cap<arraycap.length;cap++)
		     {
              if(cap==0)
				 {
				  String validation=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:java.net.URLEncoder.encode((String)resultsQry.get(arraycap[cap])); 
                   
                   		 out.println("d.add("+count+",1,replacefun(unescape('"+validation+"')),'','"+arraycap[cap]+"');");
				 capval=count;
		
				}
				else
				 {
					 String validation2=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:java.net.URLEncoder.encode((String)resultsQry.get(arraycap[cap]));
					capval=capval+1; 
				
				   out.println("d.add("+capval+","+count+",replacefun(unescape('"+validation2+"')),'','"+arraycap[cap]+"');");
				 }
		   }
		   count=capval;
		   }
else
				  {
                
					  String validation1=((String)resultsQry.get(array[check]))==null?array[check]:java.net.URLEncoder.encode((String)resultsQry.get(array[check]));
                      if(check==1)
					  {
					  }
					  else
					  {
                         out.println("d.add("+count+",1,replacefun(unescape('"+validation1+"')),'','"+array[check]+"');");
					  }
				  }

				  		count++;
			  }

	} 
		  }

	if(segset!=null)
	{
		segset.close();
	}




	

//out.println("d.add("+count+",2,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');")
	



if(segstatement!=null)
	segstatement.close();
}
catch(Exception exp)
    {
	   exp.printStackTrace(System.err);
    }
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of SegmentTypeMessageViewer.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }

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




</form>

</body>
</div>
</html>




