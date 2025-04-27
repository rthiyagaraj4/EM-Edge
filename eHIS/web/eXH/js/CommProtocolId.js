//*********************************************************************************
//FUNCTION CREATE
//*********************************************************************************
function create()     
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
		//Protocolframeset.rows="35,300,140,30";	
		document.getElementById("commontoolbarFrame").style.height="7vh";
		document.getElementById("f_query_add_mod").style.height="56vh";
		document.getElementById("f_query_add_mod_detail").style.height="25vh";
		document.getElementById("messageFrame").style.height="7vh";
		
		window.f_query_add_mod.location.href="../../eXH/jsp/CommProtocolIdSelectMaster.jsp?mode=I";		
		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";	
		window.messageFrame.location.href="../../eCommon/html/blank.html";
}
//*********************************************************************************
//FUNCTION QUERY
//*********************************************************************************
function query() 
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none'; 
		//Protocolframeset.rows="35,300,140,30";	
	document.getElementById("commontoolbarFrame").style.height="7vh";
	document.getElementById("f_query_add_mod").style.height="58vh";
	document.getElementById("f_query_add_mod_detail").style.height="25vh";
	document.getElementById("messageFrame").style.height="7vh";
	
	window.f_query_add_mod.location.href="../../eXH/jsp/CommProtocolIdQueryCriteria.jsp";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";	
	window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//		alert("Delete");
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
		apply();
}
//*********************************************************************************
//FUNCTION APPLY()
//*********************************************************************************

function apply()
{
	var mode = frames[1].document.forms[0].act_mode.value;
	
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="55vh";
	document.getElementById("f_query_add_mod_detail").style.height="25vh";
	document.getElementById("messageFrame").style.height="7vh";

	if(!frames[2].document.forms[0]){
//		var prot_type_disable = frames[1].document.forms[0].protocol_type.disabled;

	/*	if(prot_type_disable==true){
			frames[1].document.forms[0].protocol_type.disabled=false;
		}
		*/
		var fields = new Array ();
		var names = new Array ();

		var formObj	=	 frames[1].document.forms[0];
		fields[0]		=	formObj.protocol_id;
		fields[1]		=	formObj.protocol_name;
	//	fields[2]		=	formObj.datainput_api;
	//	fields[3]		=	formObj.statistics_api;
	//	fields[4]		=	formObj.module_Name;
		fields[2]		=	formObj.ack_type;
	//	fields[6]		=	formObj.sub_module_Name;
		fields[3]		=	formObj.protocol_type;
		fields[4]		=	formObj.protocol_mode;

		names[0]		=	getLabel("Common.identification.label","Common");
		names[1]		=	getLabel("Common.name.label","Common");
	//	names[2]		=	getLabel("eXH.CommDataIOAPI.Label","XH");
	//	names[3]		=   getLabel("eXH.CommStatisticsAPI.Label","XH");
	//	names[4]	   	=   getLabel("eXH.InterfaceDomain.Label","XH");
		names[2]		=	getLabel("eXH.AcknowlegementType.Label","XH");
	//	names[6]		=	getLabel("eXH.SubDomain.Label","XH");
		names[3]		=	getLabel("eXH.ProtocolType.Label","XH");
		names[4]		=	getLabel("Common.mode.label","Common");

		if(frames[1].document.getElementById("tcpip").style.display=='block'){

          if(frames[1].document.getElementById("protocol_mode").value=="I")
			{
			 
			  fields[5]		=	formObj.port_noI;
			  names[5]	=	 getLabel("eXH.PortNumber.Label","XH");
			
			}
			else if(frames[1].document.getElementById("protocol_mode").value=="O")
			{
				fields[5]		=	formObj.ip_address;
			fields[6]		=	formObj.port_noO;
			fields[7]		=	formObj.retry_intrvl;
			fields[8]		=	formObj.max_retries; 

			names[5]		=	 getLabel("eXH.IPAddress.Label","XH");
			names[6]	=	 getLabel("eXH.PortNumber.Label","XH");
			names[7]	=	 getLabel("eXH.RetryInterval.Label","XH");		 
			names[8]	=	 getLabel("eXH.MaximumRetries.Label","XH");	
			}

		}

		else if(frames[1].document.getElementById("file").style.display=='block'){ 
			fields[5]		=	formObj.file_dir;
//			fields[6]		=	formObj.filenaming_api;

			names[5]		=	 getLabel("eXH.FileDirectory.Label","XH");
//			names[6]	=   getLabel("eXH.FileNamingAPI.Label","XH");

//			if(formObj.file_intrvl.value==false && formObj.data_intrvl.readOnly==false){
				fields[6]		=	formObj.file_intrvl;
				names[6]	=   getLabel("eXH.FileInterval.Label","XH");
				fields[7]		=	formObj.data_intrvl;
				names[7]	=	 getLabel("eXH.DataInterval.Label","XH");
				fields[8]		=	formObj.error_dir;
				names[8]	=   getLabel("eXH.ErrorDir.Label","XH");
//			}

		}

		else if(frames[1].document.getElementById("oracle_table").style.display=='block'){ 
			fields[5]		=	formObj.oracle_table_qry;

			names[5]		=	   getLabel("eXH.OracleTableQuery.Label","XH")
		}
		else if(frames[1].document.getElementById("odbc").style.display=='block'){  


			fields[5]		=	formObj.db_conn_string;
			fields[6]		=	formObj.db_driver;
			fields[7]		=	formObj.odbc_uid;
			fields[8]		=	formObj.odbc_pwd;
			fields[9]		=	formObj.odbc_sid;
			

			names[5]		=	 getLabel("eXH.DBCONNSTRING.Label","XH");
			names[6]		=   getLabel("eXH.DBDRIVER.Label","XH");
			names[7]		=	 getLabel("Common.userid.label","common"); 
			names[8]		=   getLabel("Common.password.label","common");
			names[9]		=    getLabel("eXH.ODBCSID.Label","XH"); 
			if(frames[1].document.getElementById("protocol_mode").value=="I")
			{
				fields[10]		=	formObj.oracle_table_qry2;
				names[10]		=    getLabel("eXH.OracleTableQuery.Label","XH"); 
			}
			else
			{

			}
		
		}
		else if(frames[1].document.getElementById("replication").style.display=='block')
		{
			fields[5]		= formObj.dblink_name;
			names[5]		=	 getLabel("eXH.DBLink.Label","XH");    
		}
		else if(frames[1].document.getElementById("webserviceDiv").style.display == 'block')
		{
			fields[5] = formObj.url;
			names[5]  = getLabel("Common.URL.label","common");
			fields[6] = formObj.userName;
			names[6]  = getLabel("Common.username.label","common"); 
			fields[7] = formObj.password;
			names[7]  = getLabel("Common.password.label","common"); 
			fields[8] = formObj.wsRetryInterval;
			names[8]  = getLabel("eXH.RetryInterval.Label","xh_labels"); 
			fields[9] = formObj.wsMaxRetries;
			names[9]  = getLabel("eXH.MaximumRetries.Label","xh_labels");
			
		}// Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 
		else if(frames[1].document.getElementById("javamailDiv").style.display == 'block')
		{
			fields[5] = formObj.mail_uid;
			names[5]  = getLabel("eXH.MailUsername.Label","xh_labels"); 
			fields[6] = formObj.mail_pwd;
			names[6]  = getLabel("eXH.MailPassword.Label","xh_labels"); 
			fields[7] = formObj.mail_host;
			names[7]  = getLabel("eXH.MailHost.Label","xh_labels");
			fields[8] = formObj.mail_port;
			names[8]  = getLabel("eXH.MailPort.Label","xh_labels");
			fields[9] = formObj.mail_smtp_auth_flag;
			names[9]  = getLabel("eXH.MailSMTPAuth.Label","xh_labels");
			fields[10] = formObj.mail_smtp_starttls_flag;
			names[10]  = getLabel("eXH.MailStarttls.Label","xh_labels");			
			fields[11] = formObj.mail_attachment_flag;
			names[11]  = getLabel("eXH.MailAttachment.Label","xh_labels");	
		}


//		if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		{

		}
		else
		{
			if(frames[1].document.getElementById("webserviceDiv").style.display == 'block')
			{
				formObj.retry_intrvl.value = formObj.wsRetryInterval.value;
				formObj.max_retries.value = formObj.wsMaxRetries.value;
				formObj.auto_restart_type.value = formObj.wsAutoRestartType.value;
				formObj.auto_restart_time.value = formObj.wsAutoRestartTime.value;
			}

			if (frames[1].document.getElementById("CommProcessIdleTime"))
			{
				formObj.hidCommProcessIdleTime.value = formObj.CommProcessIdleTime.value;
			}
			else
				formObj.hidCommProcessIdleTime.value = "";
			
			window.f_query_add_mod.document.forms[0].action = '../../servlet/eXH.CommProtocolIdAddModifyServlet';
			window.f_query_add_mod.document.forms[0].submit();

			if(mode == 'I')
			{
				window.f_query_add_mod.document.forms[0].reset();
			}
		}
	}

	window.commontoolbarFrame.document.location.reload();
//	}	
}

function applyduplicate()
{
	var mode = frames[1].document.forms[0].act_mode.value;

	if(!frames[2].document.forms[0]){
//		var prot_type_disable = frames[1].document.forms[0].protocol_type.disabled;

	/*	if(prot_type_disable==true){
			frames[1].document.forms[0].protocol_type.disabled=false;
		}
		*/
		var fields = new Array ();
		var names = new Array ();

		var formObj	=	 frames[1].document.forms[0];
			fields[0]		=	formObj.protocol_id;
			fields[1]		=	formObj.protocol_name;
//			fields[2]		=	formObj.datainput_api;
//			fields[3]		=	formObj.statistics_api;
//			fields[2]		=	formObj.module_Name;
			fields[2]		=	formObj.ack_type;
//			fields[4]		=	formObj.sub_module_Name;
			fields[3]		=	formObj.protocol_type;
			fields[4]		=	formObj.protocol_mode;

			names[0]		=	 "ID";
			names[1]		=	 "Name";
	//		names[2]		=	 "Comm Data I/O API";
	//		names[3]		=   "Comm Statistics API";
	//		names[2]	   	=  "Interface Domain";
			names[2]		=	"Acknowlegement Type";
//			names[4]		=	"Sub Domain";
			names[3]		=	 "Communication Type";
			names[4]		=	 "Mode";
		
		if(frames[1].document.getElementById("tcpip").style.display=='block'){
			if(frames[1].document.getElementById("dispIp_Port").style.display=='block'){ 
				fields[5]		=	formObj.ip_address;
				fields[6]		=	formObj.port_noO;
				fields[7]		=	formObj.retry_intrvl;
				fields[8]		=	formObj.max_retries;

				names[5]		=	 "IP Address";
				names[6]		=	 "Port Number";
				names[7]		=	 "Re-try Interval(sec)";		
				names[8]		=	 "Maximum Re-tries";		
			}
			else{
				fields[5]		=	formObj.port_noI;
				names[5]		=	 "Port Number";
			}			
		} // end of TCP/IP

		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		{

		}else
		{
			window.f_query_add_mod.document.forms[0].action = '../../servlet/eXH.CommProtocolIdAddModifyServlet';
			window.f_query_add_mod.document.forms[0].submit();	
				if(mode=='I'){
					window.f_query_add_mod.document.forms[0].reset();
				}
		  } // end of else
//		}
	} // end of if

	window.commontoolbarFrame.document.location.reload();
//	}	
}
//*********************************************************************************
//FUNCTION RESET 
//*********************************************************************************
function reset()
{	 
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
}

//*********************************************************************************
//function setAutoRsrtTime
//*********************************************************************************

function setAutoRsrtTime(obj)
{
	var auto_restart_type = obj.value;
//	alert("auto_restart_type : "+auto_restart_type);

	if(auto_restart_type=='A' || auto_restart_type=='E')
	{
		this.document.forms[0].auto_restart_time.readOnly = false;
		this.document.forms[0].wsAutoRestartTime.readOnly = false;
	}
	else if(auto_restart_type=='N' || auto_restart_type=='')
	{
//		alert("None");
	//	if(obj.auto_restart_time.readOnly == false){
			this.document.forms[0].auto_restart_time.value="";
			this.document.forms[0].wsAutoRestartTime.value="";
			this.document.forms[0].auto_restart_time.readOnly = true;
			this.document.forms[0].wsAutoRestartTime.readOnly = true;
	//	}
	}
}

//********************************************************************************************
//function onLoadOfpage
//********************************************************************************************
function onLoadOfpage()
{
	
	var mode = this.document.forms[0].act_mode.value;
	var prot_type = this.document.forms[0].protocol_type.value;
    
	if(mode=='U' && prot_type=='F'){ 
		document.getElementById("addFileCtrlStr").style.display='block';	    
	}
	else{
		document.getElementById("addFileCtrlStr").style.display='none';	    
	}

	var tcpip_disp=document.getElementById("tcpip");
	var file_disp=document.getElementById("file");
	var fax_disp=document.getElementById("fax");
	var mail_disp=document.getElementById("mail");
	var odbc_disp=document.getElementById("odbc");
	var orclTabl_disp=document.getElementById("oracle_table");
	var repl_disp=document.getElementById("replication");
	var webserviceDiv = document.getElementById('webserviceDiv');
	
	var javamailDiv = document.getElementById('javamailDiv'); /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */

    //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification ** combined all if loops into one if-else
    if(prot_type=='T')
	{	   
	    tcpip_disp.style.display='block';
		file_disp.style.display='none';
		fax_disp.style.display='none';
   	    mail_disp.style.display='none';
	    odbc_disp.style.display='none';
   	    orclTabl_disp.style.display='none';
   	    repl_disp.style.display='none';
   	    webserviceDiv.style.display = 'none';
		
		javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
		
		//document.getElementById('commonFieldsDiv').style.display = 'none'; //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
		parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
	 else if(prot_type=='F')
	{
	    file_disp.style.display='block'; 
	    tcpip_disp.style.display='none';
	    fax_disp.style.display='none';
		mail_disp.style.display='none';
		odbc_disp.style.display='none';
		orclTabl_disp.style.display='none';
   	    repl_disp.style.display='none';
   	    webserviceDiv.style.display = 'none';
		
		javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
		
		//document.getElementById('commonFieldsDiv').style.display = 'none';  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
//	   parent.f_query_add_mod_detail.location.href="../../eXH/jsp/CommProtocolIdMainTab.jsp";		
	}
	else if(prot_type=='R')
	{
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none'; 
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
	   odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
       repl_disp.style.display='none';
       webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none'; //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
 	   parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='X')
	{
	   fax_disp.style.display='block';
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   mail_disp.style.display='none';
   	   odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
       repl_disp.style.display='none';
       webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none'; //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
       parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='M')
	{
	   mail_disp.style.display='block';
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
  	   odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
   	   repl_disp.style.display='none';
   	   webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none';  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
       parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='S')
	{
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
       odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
 	   repl_disp.style.display='none';
 	   webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none';  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
       parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='D')
	{
	   odbc_disp.style.display='block';
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
       repl_disp.style.display='none';
       webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none';  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
   	   parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='OT')
	{
	   oracle_table.style.display='block';
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
   	   odbc_disp.style.display='none';
       repl_disp.style.display='none';
       webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none'; //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
	   parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
    else if(prot_type=='RP')
	{
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
	   odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
       repl_disp.style.display='block';
       webserviceDiv.style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	   
	   
	   //document.getElementById('commonFieldsDiv').style.display = 'none';  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
       parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
	else if(prot_type == 'W' || prot_type == 'H' || prot_type == 'SL' || prot_type == 'SO')
	{
		tcpip_disp.style.display	= 'none';
		file_disp.style.display		= 'none';
		fax_disp.style.display		= 'none';
		mail_disp.style.display		= 'none';
		odbc_disp.style.display		= 'none';
		orclTabl_disp.style.display	= 'none';
		repl_disp.style.display		= 'none';
		document.getElementById('labelhdr').innerHTML = document.getElementById('protocol_type').options[document.getElementById('protocol_type').selectedIndex].text;
		document.getElementById('webserviceDiv').style.display = 'block';
		if(prot_type == 'SO')
		{
         document.getElementById('soaptr1').style.display = 'block';
		 document.getElementById('soaptr2').style.display = 'block';
		 document.getElementById('soaptr3').style.display = 'block';
		}
		else{
           document.getElementById('soaptr1').style.display = 'none';
		   document.getElementById('soaptr2').style.display = 'none';
		   document.getElementById('soaptr3').style.display = 'none';
		}
		
		javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
		
		parent.f_query_add_mod_detail.location.href = "../../eCommon/html/blank.html";		
	}
	else if(prot_type=='')
	{
	   tcpip_disp.style.display='none';
	   file_disp.style.display='none';
   	   fax_disp.style.display='none';
   	   mail_disp.style.display='none';
	   odbc_disp.style.display='none';
   	   orclTabl_disp.style.display='none';
       repl_disp.style.display='none';
	   document.getElementById('webserviceDiv').style.display = 'none';
	   
	   javamailDiv.style.display='none'; /* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
       
	   parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
	/* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
	else if(prot_type=='JM')
	{	   
	    javamailDiv.style.display='block';
	    tcpip_disp.style.display='none';
		file_disp.style.display='none';
		fax_disp.style.display='none';
   	    mail_disp.style.display='none';
	    odbc_disp.style.display='none';
   	    orclTabl_disp.style.display='none';
   	    repl_disp.style.display='none';
   	    webserviceDiv.style.display = 'none';
		//document.getElementById('commonFieldsDiv').style.display = 'none'; //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification unavailable div
		parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
	}
	/* Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 */
    parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//*******************************************************************************************
//function dispSolicited
//*****************************************************************************************
function dispSolicited()
{
	//alert("dispSolicited");
	prot_mode=document.forms[0].protocol_mode.value;	
	prot_type = document.forms[0].protocol_type.value;	
	var tcpip_disp=document.getElementById("tcpip");
	var file_disp=document.getElementById("file");
	var fax_disp=document.getElementById("fax");
	var mail_disp=document.getElementById("mail");
	var odbc_disp=document.getElementById("odbc");
	var orclTabl_disp=document.getElementById("oracle_table");
	var repl_disp=document.getElementById("replication");
	
	
	
	
	if(prot_mode == "I"){
			document.getElementById('solicitedYN').style.display='block';
	}
	else if(prot_mode == "O"){
			document.getElementById('solicitedYN').style.display='none';
	}
   
	if(prot_type=='T'){
		if(prot_mode == "I"){
			document.getElementById('tcpip').style.display='block';		
			document.getElementById('dispIp_Port').style.display='none';
			document.getElementById('disp_Port').style.display='block';
			document.getElementById('disp_Retry').style.display='none';
		}
		else if(prot_mode == "O"){
			document.getElementById('tcpip').style.display='block';
			document.getElementById('dispIp_Port').style.display='block';
			document.getElementById('disp_Port').style.display='none';
			document.getElementById('disp_Retry').style.display='block';
		} 
		else{
		document.getElementById('solicitedYN').style.display='none';
		document.getElementById('tcpip').style.display='none';		
		}
	} // end of TCP/IP
	else if(prot_type=='D'){

			if(prot_mode == "I"){
			document.getElementById("oralceQuery").style.display='block';
			}
			else if(prot_mode == "O"){
			document.getElementById("oralceQuery").style.display='none';
			} 
	}
	else{
		
	   tcpip_disp.style.display='none';
	 //  file_disp.style.display='none';
   	   odbc_disp.style.display='none';
   	 
     
	} 
}
//*******************************************************************************************
//function dispStyleShtPath

//*****************************************************************************************
function dispStyleShtPath()
{
//	alert("dispStyleShtPath ");
	protocol_type=document.getElementById('protocol_type').value;	
	prot_mode=document.getElementById('protocol_mode').value;	
	file_type=document.getElementById('file_type').value;	
	if((protocol_type == 'F')&&(prot_mode == 'I')&&(file_type=='X')){	
//		alert("disp StyleShtPath .... ");
		document.getElementById('styleshtPath').style.display='block';
	}
	else{
		document.getElementById('styleshtPath').style.display='none';
	}
}
//*******************************************************************************************

//********************************************************************************************
//function checkAutoRstrtTm
//********************************************************************************************
  function checkAutoRstrtTm(obj){
	 
	var auto_res_type = document.forms[0].auto_restart_type.value;
	if(auto_res_type=='A'||auto_res_type=='E'){
		
		checkt(obj);
	}

  }

//********************************************************************************************
//function checkt
//********************************************************************************************
  function checkt(obj)
 {
    var val=obj.value;
//	alert("obj.value : "+obj.value);
	var arr;

		if(val!='')
		{
		  if((val.length==1) && (!isNaN(val))){
				obj.value="0"+val+":00";
//		         obj.focus();

		  }
		  else if((val.length==2) && (!(isNaN(val))&&(val<=24)) ) 
		  {
				obj.value=val+":00";
//		         obj.focus();

		  }
		  else
		  {
			arr=val.split(':');
			   if((arr.length>2)||(arr.length==0)) 
			  {
					alert(getMessage('XH1026','XH'));
	//				alert('APP-XH1026 Invalid Time Format(hh:mm)');
					obj.focus();
				    return false;
			  }
			   else
			   {   
				if((!(isNaN(arr[0])))&&(arr[0]<24))
					{ 
//			         obj.focus();
					}
				else
				{		
					 alert(getMessage('XH1026','XH'));
 	//				 alert('APP-XH1026 Invalid Time Format(hh:mm)');
			         obj.focus();
					 return false;
				}

				if((arr[1].length==1) && (!isNaN(arr[1]))){
					 obj.value=arr[0]+":0"+arr[1];
//					 obj.focus();
				 }
				else if((arr[1].length==2) && (!(isNaN(arr[1]))&&(arr[1]<=60)) ) 
				{
					 obj.value=arr[0]+":"+arr[1];
//					 obj.focus();
				}
				else
				{		
					 alert(getMessage('XH1026','XH'));
 	//				 alert('APP-XH1026 Invalid Time Format(hh:mm)');
			         obj.focus();
					 return false;
				}
			   }
		  } // end of else
		} // end of if
}

//********************************************************************************************
// function validDir
//********************************************************************************************
 function validDir(obj,label)
 {
//	 alert("obj lbl : "+obj.label);
  var val=obj.value;
  if(val!='')
  {
   var len=val.length;
  if(val.charAt(len-1)!='/')
  {
//    alert(getMessage('XH1033','XH'));
//	 var dirPath=parent.frames[0].getMessage("XH1033",'XH');
 	 var dirPathAlert=getMessage("XH1033","XH");
		dirPathAlert = dirPathAlert.replace("$",label);
     alert(dirPathAlert);
	 obj.focus();
	return false;
   }
  }			 
 }

 //********************************************************************************************
// function validXMLStyleSht Path
//********************************************************************************************
 function validXMLStyleSht(obj)
 {
  var val=obj.value;
  if(val!='')
  {
   var len=val.length;
   var arr = val.split('.');
   var file_path = arr[0];
   var xtnsn = arr[1];
   if((file_path.charAt(file_path.length-2)!='/')||(xtnsn!='xsl'))
	{
		 alert(getMessage('XH1034','XH'));
		 obj.focus();
		 return false;
	}
  }			 
 }

//********************************************************************************************
//function searchInterfaceDomain
//*******************************************************************************************

async function searchInterfaceDomain(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
   			var tit	= "Interface Domain";
            var target=this.document.forms[0].module_Name;
            var module_id=this.document.forms[0].module_Id;
        
//			sql="SELECT distinct a.MODULE_ID code,b.MODULE_NAME description FROM SM_MODULES_FACILITY a,SM_MODULE b WHERE UPPER(a.MODULE_ID) LIKE UPPER(?) AND UPPER(b.MODULE_NAME) LIKE UPPER(?) AND a.OPERATIONAL_YN='Y' AND a.MODULE_ID=b.MODULE_ID ORDER BY 1 ";
			
			sql="SELECT distinct a.MODULE_ID code,b.MODULE_NAME description FROM SM_MODULES_FACILITY a,SM_MODULE b WHERE UPPER(a.MODULE_ID) LIKE UPPER(?) AND UPPER(b.MODULE_NAME) LIKE UPPER(?) AND a.OPERATIONAL_YN='Y' AND a.MODULE_ID=b.MODULE_ID AND MODULE_GROUP_ID ='XS'  ORDER BY 1 ";

	/*		if(module_id.value!=""){
				dataNameArray[0]	= "MODULE_ID" ;
				dataValueArray[0]	= module_id.value;
				dataTypeArray[0]	= STRING ;
			}
*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                module_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                module_id.value=tcode;
            }
}// End of searchInterfaceDomain

//********************************************************************************************
//function searchSubDomain
//*******************************************************************************************

async function searchSubDomain(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
   			var tit	= "Sub Domain";
            var target=this.document.forms[0].sub_module_Name;
			var module_id = this.document.forms[0].module_Id.value;
//			alert("mod id : "+module_id);
            var sub_module_id=this.document.forms[0].sub_module_Id;
        
			sql="SELECT INTERFACE_MODULE_ID code,INTERFACE_DESC description FROM XH_INTERFACE WHERE UPPER(INTERFACE_MODULE_ID) LIKE UPPER(?) AND UPPER(INTERFACE_DESC) LIKE UPPER(?) AND MODULE_ID='"+module_id+"' ORDER BY 1 ";

/*			if(sub_module_id.value!=""){
				dataNameArray[0]	= "SUB_MODULE_ID" ;
				dataValueArray[0]	= sub_module_id.value;
				dataTypeArray[0]	= STRING ;
			}
*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                sub_module_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                sub_module_id.value=tcode;
            }
}// End of searchSubDomain


//********************************************************************************************
//function searchFileNamingConv
//*******************************************************************************************

async function searchFileNamingConv(){
  //   alert("searchFileNamingConv");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("eXH.FileNamingAPI.Label","XH");		 	
            var target=this.document.forms[0].filenaming_api;
            var file_api_id=this.document.forms[0].filenaming_api_id;
/*
            sql="SELECT API_DESC description,API_CODE code FROM XH_API "+
                    "   WHERE API_TYPE='F' AND UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
            sql="SELECT API_CODE code,API_DESC description FROM XH_API  WHERE API_TYPE='F' AND UPPER(API_CODE) LIKE UPPER(?) AND  UPPER(API_DESC) LIKE UPPER(?)  ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                file_api_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                file_api_id.value=tcode;
            }
}// End of searchFileNamingConv
  
//********************************************************************************************
//function searchDataInputAPI
//*******************************************************************************************

async function searchDataInputAPI(){
  //   alert("searchDataInputAPI");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ; 
            var tit= "Comm Data I/O API";
            var target=this.document.forms[0].datainput_api;
            var DataIp_api_id=this.document.forms[0].datainput_api_id;

            sql="SELECT API_CODE code,API_DESC description FROM XH_API  WHERE API_TYPE='D' AND UPPER(API_CODE) LIKE UPPER(?) AND  UPPER(API_DESC) LIKE UPPER(?)  ORDER BY 1 ";
			
//			alert(sql);
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
//			alert(retVal);
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                DataIp_api_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                DataIp_api_id.value=tcode;
            }
}// End of searchDataInputAPI

//********************************************************************************************
//function searchCommStatAPI
//*******************************************************************************************

async function searchCommStatAPI(){
  //   alert("searchCommStatAPI");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Comm Statistics API";
            var target=this.document.forms[0].statistics_api;
            var stat_api_id=this.document.forms[0].statistics_api_id;
/*
            sql="SELECT API_DESC description,API_CODE code FROM XH_API "+
                    "   WHERE API_TYPE='S' AND UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
            sql="SELECT API_CODE code,API_DESC description FROM XH_API  WHERE API_TYPE='S' AND UPPER(API_CODE) LIKE UPPER(?) AND  UPPER(API_DESC) LIKE UPPER(?)    ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
 	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                stat_api_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                stat_api_id.value=tcode;
            }
}// End of searchCommStatAPI

//********************************************************************************************
//function searchFaxId
//*******************************************************************************************

async function searchFaxId(){

			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Fax";
            var target=this.document.forms[0].recipient_name;
            var fax_id=this.document.forms[0].fax_id;

	        sql="SELECT FAX_ID code,RECIPIENT_NAME description FROM sm_fax "+
                    "   WHERE UPPER(FAX_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(RECIPIENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
/*
			if(fax_id.value!=""){
				dataNameArray[0]	= "FAX_ID" ;
				dataValueArray[0]	= fax_id.value;
				dataTypeArray[0]	= STRING ;
			}
*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
  	        argumentArray[4] = "1,2";
 //           argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                fax_id.value=arr[0];
    //            target.value=arr[0];
    //            fax_id.value=arr[1];
            }
            else{
	            target.value=tdesc;
                fax_id.value=tcode;
	//	        target.value=tcode;
    //          fax_id.value=tdesc;
            }
}// End of searchFaxId

//********************************************************************************************
//function searchMailId
//*******************************************************************************************

async function searchMailId(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Mail";
            var target=this.document.forms[0].to_mail;
            var mail_id=this.document.forms[0].mail_id;

	        sql="SELECT MAIL_ID code,TO_MAIL description FROM sm_mail "+
                    "   WHERE UPPER(MAIL_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(TO_MAIL) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
/*
			if(mail_id.value!=""){
				dataNameArray[0]	= "MAIL_ID" ;
				dataValueArray[0]	= mail_id.value;
				dataTypeArray[0]	= STRING ;
			}
*/
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
 //           argumentArray[4] = "2,1";
			argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                mail_id.value=arr[0];
            }
            else{
	            target.value=tdesc;
                mail_id.value=tcode;
            }
}// End of searchMailId

//********************************************************************************************
//function searchDBLink
//*******************************************************************************************

async function searchDBLink(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "DB Link";
            var target=this.document.forms[0].dblink_name;
            var dblink_id=this.document.forms[0].dblink_id;

	        sql="SELECT DB_LINK code,DB_LINK description FROM xh_appl_for_facility WHERE OUTBOUND_COMM_MODE='R' AND UPPER(DB_LINK) LIKE UPPER(?) AND  UPPER(DB_LINK) LIKE UPPER(?)  ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                dblink_id.value=arr[0];
            }
            else{
	            target.value=tdesc;
                dblink_id.value=tcode;
            }
}// End of searchDBLink


//********************************************************************************************
//function funSubmit
//*******************************************************************************************

function funSubmit()
{
	// #MOD#01

	var act = '../../eXH/jsp/CommProtocolIdQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
/*
	var act = '../../eXH/jsp/CommProtFileCtrlStructureSearchResult.jsp';
    parent.f_query_add_mod_detail.document.forms[0].action = act;
	parent.f_query_add_mod_detail.document.forms[0].submit();
*/
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02 
	//parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

//	alert("obj : "+obj);
//	alert("fn Mdfy protocol_id : "+obj.getAttribute('protocol_id'));
	
	parent.document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.document.getElementById("f_query_add_mod").style.height="56vh";
	parent.document.getElementById("f_query_add_mod_detail").style.height="25vh";
	parent.document.getElementById("messageFrame").style.height="7vh";

	this.document.forms[0].protocol_id.value = obj.getAttribute('protocol_id');
	this.document.forms[0].protocol_name.value = obj.getAttribute('protocol_name');
	this.document.forms[0].protocol_type.value = obj.getAttribute('protocol_type');
	this.document.forms[0].protocol_mode.value = obj.getAttribute('protocol_mode');
	this.document.forms[0].file_dir.value = obj.getAttribute('file_dir');
	this.document.forms[0].file_type.value = obj.getAttribute('file_type');
	this.document.forms[0].ip_address.value = obj.getAttribute('ip_address');
	this.document.forms[0].port_no.value = obj.getAttribute('port_no');
	this.document.forms[0].ack_type.value = obj.getAttribute('ack_type');
	this.document.forms[0].retry_intrvl.value = obj.getAttribute('retry_intrvl');
	this.document.forms[0].max_retries.value = obj.getAttribute('max_retries');
	this.document.forms[0].file_intrvl.value = obj.getAttribute('file_intrvl');
	this.document.forms[0].filenaming_api.value = obj.getAttribute('filenaming_api');
	this.document.forms[0].data_intrvl.value = obj.getAttribute('data_intrvl');
//	this.document.forms[0].datainput_api.value = obj.getAttribute('datainput_api');
	this.document.forms[0].statistics_api.value = obj.getAttribute('statistics_api');
	this.document.forms[0].auto_restart_type.value = obj.getAttribute('auto_restart_type');
	this.document.forms[0].auto_restart_time.value = obj.getAttribute('auto_restart_time');
	this.document.forms[0].module_Id.value = obj.getAttribute('module_Id');
	this.document.forms[0].db_conn_string.value = obj.getAttribute('db_conn_string');
	this.document.forms[0].db_driver.value = obj.getAttribute('db_driver');
	this.document.forms[0].fax_id.value = obj.getAttribute('fax_id');
	this.document.forms[0].mail_id.value = obj.getAttribute('mail_id');
//	alert("module_Name : "+obj.getAttribute('module_Name'));
	this.document.forms[0].module_Name.value = obj.getAttribute('module_Name');
	this.document.forms[0].recipient_name.value = obj.getAttribute('recipient_name');
	this.document.forms[0].to_mail.value = obj.getAttribute('to_mail');
	this.document.forms[0].solicitedYN.value = obj.getAttribute('solicitedYN');
	this.document.forms[0].oracle_table_qry.value = obj.getAttribute('oracle_table_qry');
	this.document.forms[0].oracle_table_ins_qry.value = obj.getAttribute('oracle_table_ins_qry');
	this.document.forms[0].ack_dir.value = obj.getAttribute('ack_dir');	
	this.document.forms[0].stylesht_path.value = obj.getAttribute('stylesht_path');	
	this.document.forms[0].sub_module_Id.value = obj.getAttribute('sub_module_Id');	
	this.document.forms[0].sub_module_Name.value = obj.getAttribute('sub_module_Name');	
	this.document.forms[0].error_dir.value = obj.getAttribute('error_dir');	
	this.document.forms[0].odbc_uid.value = obj.getAttribute('odbc_uid');	
	this.document.forms[0].odbc_pwd.value = obj.getAttribute('odbc_pwd');	
	this.document.forms[0].odbc_sid.value = obj.getAttribute('odbc_sid');	
	this.document.forms[0].dblink_name.value = obj.getAttribute('dblink_name');
	//changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification 
	this.document.forms[0].httpUserAgent.value = obj.getAttribute('httpUserAgent');
	this.document.forms[0].httpContentType.value = obj.getAttribute('httpContentType');
	this.document.forms[0].httpTransferEncoding.value = obj.getAttribute('httpTransferEncoding');
	this.document.forms[0].httpSoapAction.value = obj.getAttribute('httpSoapAction');
	this.document.forms[0].httpContentLength.value = obj.getAttribute('httpContentLength');
	
	//Added By Niveditha on 22/01/2020 for AAKH-CRF-0113
	this.document.forms[0].mail_host.value = obj.getAttribute('mail_host');
	this.document.forms[0].mail_port.value = obj.getAttribute('mail_port');
	this.document.forms[0].mail_config.value = obj.getAttribute('mail_config');
	this.document.forms[0].mail_smtp_auth_flag.value = obj.getAttribute('mail_smtp_auth_flag');
	this.document.forms[0].mail_smtp_starttls_flag.value = obj.getAttribute('mail_smtp_starttls_flag');
	this.document.forms[0].mail_attachment_flag.value = obj.getAttribute('mail_attachment_flag');

	
	var act = '../../eXH/jsp/CommProtocolIdSelectMaster.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************
