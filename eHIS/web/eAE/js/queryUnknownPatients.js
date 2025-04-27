function query()
 { 
		 f_unknownPatientsCriteria.location.href ="../../eAE/jsp/queryUnknownPatientsCriteria.jsp" ;
 }
function reset() 
  {
	clear(); 
	f_unknownPatientsCriteria.document.forms[0].reset() ;
	f_unknownPatientsCriteria.document.forms[0].search.disabled= false;
  } 

 
function	clear()
{	
//f_unknownPatientsCriteria.document.forms[0].reset() ;
		f_unknownPatientsCriteria.document.forms[0].search.disabled= false;		
		f_unknownPatientsResult.location.href="../../eCommon/html/blank.html" ;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;	
}




  function callSearch(ae_unknown_datefrom,ae_unknown_dateto,ae_unknown_location,messageFrame)
	{
		if(f_unknownPatientsCriteria.AEUnknownPatientsForm.ae_unknown_datefrom.value=='' )
		      {
				alert(getMessage("FROM_DATE_CANNOT_BE_BLANK",'SM'));
			    f_unknownPatientsCriteria.AEUnknownPatientsForm.ae_unknown_datefrom.focus();
			    return false;
		      }
			  if(f_unknownPatientsCriteria.AEUnknownPatientsForm.ae_unknown_dateto.value=='' )
		      {
			    alert(getMessage("TO_DT_NOT_BLANK",'SM'));
			    f_unknownPatientsCriteria.AEUnknownPatientsForm.ae_unknown_dateto.focus();
			    return false;
		      }
        if(mp_parm_reqdate()){
		
			
			f_unknownPatientsCriteria.document.forms[0].search.disabled= true;
			gender=f_unknownPatientsCriteria.document.forms[0].p_gender;
			var sql_query=constructQuery(ae_unknown_datefrom,ae_unknown_dateto,ae_unknown_location,gender);
			f_unknownPatientsResult.location.href="../../eAE/jsp/queryUnknownPatientsResult.jsp?sql_query="+sql_query;
			messageFrame.location.href="../../eCommon/jsp/error.jsp" ;	
		
		}
		else
             return false;
	}
function constructQuery(ae_unknown_datefrom,ae_unknown_dateto,ae_unknown_location,gender)
	{
		var sql_query=' ';
        var andCheck	=	0;            

		if( ! ((trimCheck(ae_unknown_location.value)) == false ))
		{
			sql_query	=' and locn_code = ' +'\''+ae_unknown_location.value+'\' ';
		}
		if( ! ((trimCheck(gender.value)) == false ))
		{
			sql_query	+=' and SEX = ' +'\''+gender.value+'\' ';
		}

		{
		sql_query	= sql_query + "	and trunc(queue_date) between trunc(to_date('"+convertDate(ae_unknown_datefrom.value,"DMY",localeName,"en")+"','dd/mm/yyyy hh24:mi')) and trunc(to_date('"+convertDate(ae_unknown_dateto.value,"DMY",localeName,"en")+"','dd/mm/yyyy hh24:mi')) ";

		}	

		return sql_query;
	}
	
	function disReset()
{
	parent.frames[0].document.getElementById("reset").disabled= true;	
}


function mp_parm_reqdate()
{
	
	//var birthdate=parent.frames[2].frames[1].document.forms[0].ae_unknown_datefrom.value;
	//var sysdate=parent.frames[2].frames[1].document.forms[0].ae_unknown_dateto.value;
	


    var fromarray; var toarray;
    var fromdate = convertDate(parent.frames[2].frames[1].document.forms[0].ae_unknown_datefrom.value,"DMY",localeName,"en");
    var todate = convertDate(parent.frames[2].frames[1].document.forms[0].ae_unknown_dateto.value,"DMY",localeName,"en");
	 var arr = new Array(todate,fromdate)
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			
                 alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;

	
/*	//
		from   = birthdate
	    to = sysdate
		//new
		var a=  from.split(" ")
        splitdate=a[0];
        splittime=a[1]
	    
		
		var splitdate1 =splitdate.split("/")
		//var splittime1= splittime.split(":")
			
			

		//var entered_Date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	//
        
	 
		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]
		splitdate1 =splitdate.split("/")
		//splittime1= splittime.split(":")


		// var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]) )
        
     
	 if(Date.parse(entered_Date) > Date.parse(to_date))
      {
        
	     alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
		 //alert('To Date Cannot be Greater than From Date');
		 parent.frames[2].frames[1].document.forms[0].ae_unknown_datefrom.focus();
		 parent.frames[2].frames[1].document.forms[0].ae_unknown_datefrom.select();
		 return false
		 
      }
	  else
		  return true;
		//
*/
}
