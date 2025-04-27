VERSION 5.00
Object = "{648A5603-2C6E-101B-82B6-000000000014}#1.1#0"; "MSCOMM32.OCX"
Begin VB.Form frmCC 
   Caption         =   "Credit Card Processor"
   ClientHeight    =   8295
   ClientLeft      =   60
   ClientTop       =   435
   ClientWidth     =   11610
   LinkTopic       =   "Form1"
   ScaleHeight     =   8295
   ScaleWidth      =   11610
   StartUpPosition =   3  'Windows Default
   Visible         =   0   'False
   Begin VB.Timer CCIdleTimer 
      Left            =   9960
      Top             =   6480
   End
   Begin VB.Timer RespTimer 
      Left            =   8520
      Top             =   3240
   End
   Begin VB.CheckBox ChkVoid 
      Caption         =   "Void Transaction"
      Height          =   255
      Left            =   2760
      TabIndex        =   14
      Top             =   240
      Width           =   1935
   End
   Begin VB.CheckBox chkResend 
      Caption         =   "Resend Message after 1 sec if No ACK from Terminal"
      Height          =   255
      Left            =   5520
      TabIndex        =   13
      Top             =   240
      Width           =   4455
   End
   Begin VB.ComboBox cmbPort 
      Height          =   315
      Left            =   2760
      Style           =   2  'Dropdown List
      TabIndex        =   1
      Top             =   1920
      Width           =   4335
   End
   Begin VB.TextBox txtTerminal 
      Height          =   495
      Left            =   2760
      TabIndex        =   2
      Top             =   2880
      Width           =   2775
   End
   Begin VB.TextBox txtInvoice 
      Height          =   495
      Left            =   2760
      MaxLength       =   6
      TabIndex        =   0
      Top             =   960
      Width           =   2775
   End
   Begin MSCommLib.MSComm MSComm1 
      Left            =   9120
      Top             =   5160
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      DTREnable       =   -1  'True
   End
   Begin VB.TextBox opt 
      Height          =   1095
      Left            =   1320
      MultiLine       =   -1  'True
      ScrollBars      =   3  'Both
      TabIndex        =   5
      Top             =   6600
      Width           =   7335
   End
   Begin VB.TextBox rec 
      Height          =   2055
      Left            =   2760
      MultiLine       =   -1  'True
      ScrollBars      =   3  'Both
      TabIndex        =   4
      Top             =   4320
      Width           =   5535
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Send"
      Height          =   735
      Left            =   5640
      TabIndex        =   3
      Top             =   2760
      Width           =   2415
   End
   Begin VB.TextBox ipt 
      Height          =   495
      Left            =   2760
      TabIndex        =   6
      Top             =   960
      Width           =   2775
   End
   Begin VB.Label lblAck 
      Appearance      =   0  'Flat
      BackColor       =   &H80000005&
      ForeColor       =   &H80000008&
      Height          =   375
      Left            =   2760
      TabIndex        =   12
      Top             =   3720
      Width           =   2775
   End
   Begin VB.Label Label5 
      Caption         =   "ACK Received"
      Height          =   375
      Left            =   960
      TabIndex        =   11
      Top             =   3720
      Width           =   1335
   End
   Begin VB.Label Label4 
      Caption         =   "Port"
      Height          =   375
      Left            =   960
      TabIndex        =   10
      Top             =   1920
      Width           =   1575
   End
   Begin VB.Label Label3 
      Caption         =   "Terminal ID"
      Height          =   495
      Left            =   960
      TabIndex        =   9
      Top             =   2880
      Width           =   1455
   End
   Begin VB.Label Label2 
      Caption         =   "Hexadecimal Value returned"
      Height          =   495
      Left            =   960
      TabIndex        =   8
      Top             =   4560
      Width           =   1335
   End
   Begin VB.Label Label1 
      Caption         =   "Amount"
      Height          =   495
      Left            =   960
      TabIndex        =   7
      Top             =   1080
      Width           =   1455
   End
End
Attribute VB_Name = "frmCC"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Declare Sub Sleep Lib "kernel32" (ByVal dwMilliseconds As Long)
Dim p_outstr As Variant

Dim trc_flg As String

Dim vlrc As String
Dim Amount_Messg As String
Dim LRC As String
Dim v_term_id As String
Dim a1 As String
Dim pmsgact As String
Dim fieldsep As String
Dim commOverFlag  As String
Dim commOverFlag1  As String
Dim lAck As String
Dim lNoComm As String

Dim OptCntr As Integer

Dim cntTimer As Long


Private Sub Form_Load()
    
    On Error GoTo err
    
    Dim lPort As String

    'For splitting and storing the commnd line arguments
    Dim strArgs() As String
    Dim cmdargs As String
    
    currentdt = Now
    'Storing command line arguments into a string
    cmdargs = Command$

    'Splitting Command line argument and storing into array
    strArgs = Split(cmdargs, " ")

    'Storing the array values to each variables
    gUsername = strArgs(0)
    gPassword = strArgs(1)
    gHost = strArgs(2)
    gWsno = strArgs(3)
    gTraceYn = strArgs(4)
    gFolderpath = strArgs(5)
    gMsgId = strArgs(6)
    
    'MsgBox gUsername + "~" + gPassword + "~" + gHost + "~" + gMsgId + "~" + gTraceYn + "~" + gFolderpath

'    gUsername = "RAYILLA"
'    gPassword = "med123"
'    gHost = "SRDV"
'    gWsno = "INDBGL-W00158"
'    gTraceYn = "Y"
'    gFolderpath = "c:\EHIS\REPORTS"
    
    filelinecnt = 0
    
    WriteLog "Inside CreditCard Processor Form Load..."
    
    WriteLog "Executable Path - " + App.Path
    
    WriteLog "Command Line Arguments..."
    
    WriteLog "gHost - " + gHost
    WriteLog "gWsno - " + gWsno
    WriteLog "gTraceYn - " + gTraceYn
    WriteLog "gFolderpath - " + gFolderpath
    WriteLog "gMsgId - " + gMsgId
    
    Dim count As Integer 'For counting the no of ports
    Dim i As Integer 'Increment variable
    
    'This will check whether the first 16 ports are open or not
    WriteLog "Available Port Numbers..."
    
    For i = 1 To 16
        If IsComPortAvailable(i) Then
            count = count + 1
            cmbPort.AddItem "COM" & i
            lPort = "COM" & i
            WriteLog lPort
        End If
    Next
    
    If cmbPort.ListCount > 0 Then
        cmbPort.ListIndex = 0
    End If
    
    WriteLog "Connection String formation..."
    
    If gUsername <> "" And gPassword <> "" And gHost <> "" Then
        gConnStr = "Provider=MSDAORA.1;Password=" + gPassword + ";User ID=" + gUsername + ";Data Source=" + gHost + ";Persist Security Info=True"
        WriteLog "Connection String formation Successful..."
                
        IntConnParamFetch
        
        ProcessRequest
        
    Else
        WriteLog "Connection String formation not Successful..."
        If gUsername = "" Then
            WriteLog "Database User Name cannot be blank..."
        ElseIf gPassword = "" Then
            WriteLog "Database Password cannot be blank..."
        ElseIf gHost = "" Then
            WriteLog "Database Name cannot be blank..."
        End If
    End If
    GoTo NoError
err:
    gTmpStr = "Exception Occured while Form Load - " + err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Public Sub ProcessRequest()
    Dim recsetReq As New ADODB.Recordset
    Dim tmpStr As String
    
    On Error GoTo err
    
        WriteLog ("Inside ProcessRequest() Method...")
    
        WriteLog ("Opening Oracle Connection...")
    
    If gCnn.State = 0 Then
        'Opening Oracle DB connection
        gCnn.Open (gConnStr)
        WriteLog ("New Oracle Connection Opened...")
    Else
        WriteLog ("Connection already available...")
    End If
    
    set_meduser_role
    
    WriteLog ("Query Formation...")
    'Query for fetching request_text from XH_INTERACTIVE_INTERACTION (Clob to Varchar2 Conversion)
    gSqlText = "SELECT message_id, SUBSTR(TO_CHAR(REQUEST_TEXT),1,3999) req "
    gSqlText = gSqlText + "FROM XH_INTERACTIVE_INTEGRATION WHERE WS_NO = '" + gWsno + "'"
    gSqlText = gSqlText + "AND RESPONSE_TEXT IS NULL AND ERROR_TEXT IS NULL "
    gSqlText = gSqlText + "AND PGM_ID = 'XBCC' AND  TRX_NO = '" & gMsgId & "'"
    
    WriteLog ("Query - " + gSqlText)
    
    WriteLog "Opening Recordset for fetching Request_text"
    
    recsetReq.Open gSqlText, gCnn, adOpenKeyset, adLockBatchOptimistic
    
    If recsetReq.EOF = True Then
        WriteLog "No Records Found for processing..."
        recsetReq.Close
    Else
        WriteLog "Fetch Records into Recordset..."
        
        'Fetching each record
        Do
            tmpStr = ""
            gRequestText = recsetReq!req
            gMsgId = recsetReq!message_id
            
            WriteLog "gRequestText = " + gRequestText
            WriteLog "gMsgId = " + gMsgId
            
            tmpStr = Mid(gRequestText, InStr(gRequestText, "CC") + 3)
            
            gTrnType = Mid(tmpStr, 1, InStr(tmpStr, "|") - 1)
            WriteLog "gTrnType - " + gTrnType
            
            tmpStr = Mid(tmpStr, InStr(tmpStr, "|") + 1)
            
            gTermId = Mid(tmpStr, 1, InStr(tmpStr, "|") - 1)
            WriteLog "gTermId - " + gTermId
            
            tmpStr = Mid(tmpStr, InStr(tmpStr, "|") + 1)
            
            If gTrnType = "P" Then
                If InStr(tmpStr, "|") > 0 Then
                    gAmtStr = Mid(tmpStr, 1, InStr(tmpStr, "|") - 1)
                Else
                    gAmtStr = tmpStr
                End If
                
                gAmtStr = Format(Val(gAmtStr), "##########.00")
                
                WriteLog "gAmtstr - " + gAmtStr
                
                gAmt = CDbl(gAmtStr)
            
                WriteLog "gAmt - " + CStr(gAmt)
            Else
                If InStr(tmpStr, "|") > 0 Then
                    gInvoiceNo = Mid(tmpStr, 1, InStr(tmpStr, "|") - 1)
                Else
                    gInvoiceNo = tmpStr
                End If
                WriteLog "gInvoiceNo - " + gInvoiceNo
                
            End If
            
            
            WriteLog "Calling CCProcess Method..."
            CCProcess
            WriteLog "CCProcess Method Execution Over..."
            
            'RequestTimer.Enabled = True

            
            recsetReq.MoveNext
        Loop Until recsetReq.EOF = True
    End If
    GoTo NoError
err:
    gTmpStr = "Exception Occured while Processing Request - " + err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Private Sub ChkVoid_Click()
    If ChkVoid.Value = 1 Then
        Label1.Caption = "Invoice Number"
        txtInvoice.Enabled = True
        txtInvoice.Visible = True
        ipt.Enabled = False
        ipt.Visible = False
    ElseIf ChkVoid.Value = 0 Then
        Label1.Caption = "Amount"
        ipt.Enabled = True
        ipt.Visible = True
        txtInvoice.Enabled = False
        txtInvoice.Visible = False
    End If
End Sub

Private Sub ChkVoid_LostFocus()
    If ChkVoid.Value = 1 Then
        txtInvoice.TabIndex = 1
    ElseIf ChkVoid.Value = 0 Then
        ipt.TabIndex = 1
    End If
End Sub

Private Sub CCProcess()

    Dim p_msg As String
    Dim v_data As String
    Dim v_len_amt As Integer
    Dim v_amt As Double
    Dim v_inv As String
    Dim count As Integer
    
    Dim portChk As String
    
    On Error GoTo err
    
    If gTermId = "" Then
        v_term_id = "1"
    Else
        v_term_id = gTermId
    End If
    
    If gTrnType = "P" Then
        v_len_amt = 13 - Len(gAmtStr)
    
        v_data = ""
        For i = 1 To v_len_amt
            v_data = v_data & "0"
        Next i
        
        v_data = v_data & Mid(gAmtStr, 1, InStr(gAmtStr, ".") - 1) & Mid(gAmtStr, InStr(gAmtStr, ".") + 1)
        v_amt = gAmt
    
        gTmpStr = "v_data - " & v_data
        WriteLog (gTmpStr)
    
        p_msg = "" & Chr$(Val("&H00")) & "A6000000000102000040" & Chr$(Val("&H00")) & "" & v_data & "74" & Chr$(Val("&H00")) & "" & v_term_id & ""
    Else
        v_len_amt = 6 - Len(gInvoiceNo)
    
        v_data = ""
        For i = 1 To v_len_amt
            v_data = v_data & "0"
        Next i
        
        v_data = v_data & gInvoiceNo
        v_inv = gInvoiceNo
    
        gTmpStr = "v_data - " & v_data
        WriteLog (gTmpStr)
        p_msg = "" & Chr$(Val("&H00")) & "56000000000102600065" & Chr$(Val("&H00")) & "" & v_data & "74" & Chr$(Val("&H00")) & "" & v_term_id & ""
    End If
    
    gTmpStr = "Message Before LRC Calculation - " & p_msg
    WriteLog (gTmpStr)
        
    gTmpStr = "LRC Calculation"
    WriteLog (gTmpStr)
    
    If gTrnType = "P" Then
        Call LRC_Char(v_amt)
    Else
        Call LRC_Char_inv(v_inv)
    End If
            
    gTmpStr = "LRC - " & LRC
    WriteLog (gTmpStr)
    
    gTmpStr = "LRC (Ascii) - " & Asc(LRC)
    WriteLog (gTmpStr)
    
    gTmpStr = "LRC (Hexadecimal) - " & Hex(Asc(LRC))
    WriteLog (gTmpStr)
    
    p_msg = p_msg & LRC
    gTmpStr = "Message After Attaching LRC - " & p_msg
    WriteLog (gTmpStr)
    
    Dim v_portnum As String
    
    v_portnum = Mid(cmbPort.Text, 4) 'Fetching port no from List item
    
    If v_portnum = "" Then v_portnum = "1"
        
       
    WriteLog ("v_portnum - " & v_portnum)
   
    With MSComm1
               
        If Not .PortOpen Then
            gTmpStr = "Port open ?" & .PortOpen
            WriteLog (gTmpStr)
            'If .PortOpen = True Then .PortOpen = False
    
            gTmpStr = "Initializing MSCOMM Properties"
            WriteLog (gTmpStr)
            
            .Settings = "9600,n,8,1"
            '.InputLen = 0
            '.RThreshold = 1
            .CommPort = Val(v_portnum) 'Assigning port no fetched from list
            If Not .PortOpen Then .PortOpen = True
            .RThreshold = 1
            '.InputMode = MSCommLib.InputModeConstants.comInputModeText
            '.InBufferSize = 1024
            'MSComm1.Break = False
            '.SThreshold = 1
            '.RTSEnable = True
            '.Handshaking = 2 - comRTS
             gTmpStr = "MsComm1.Settings = " & .Settings & ", MsComm1.RThreshold = " & .RThreshold & ", MsComm1.CommPort = " & .CommPort & ", MsComm1.PortOpen = " & .PortOpen
            WriteLog (gTmpStr)
        End If
    End With
    
    gTmpStr = "Initialization Over"
    WriteLog (gTmpStr)
    
    If MSComm1.PortOpen = True Then
        MSComm1.Output = p_msg
        gTmpStr = "MSComm1.Output = " & p_msg
        WriteLog (gTmpStr)
        
        Sleep 1000
                
        MSComm1_OnComm
        
        If lAck <> "Y" Then 'And chkResend.Value = 1 Then
            gTmpStr = "Waiting for ACK over..."
            WriteLog (gTmpStr)
            
            gTmpStr = "Resending the Message again..."
            WriteLog (gTmpStr)
            
            MSComm1.Output = p_msg
            gTmpStr = "MSComm1.Output = " & p_msg
            WriteLog (gTmpStr)
            
            Sleep 1000
            
            MSComm1_OnComm
            
            If lAck = "Y" Then 'And chkResend.Value = 1 Then
                'MsgBox "No Acknowledgment received from Terminal..."
                gTmpStr = "No Acknowledgment received from Terminal..."
                WriteLog (gTmpStr)
                
                gRespCode = "XX"
                gRespTxt = "Connection Error..."
            
                WriteLog "gRespCode - " + gRespCode
                WriteLog "gRespTxt - " + gRespTxt
            
                WriteLog "Calling ResponseBuilder() Method..."
            
                ResponseBuilder
            
                If MSComm1.PortOpen = False Then
                    MSComm1.PortOpen = False
                End If
            
                WriteLog "Exit XBCC..."
            
                Unload Me
            End If
        End If
    End If
    
    GoTo NoError
err:
    gTmpStr = "Error Occured While Communication - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
    
End Sub

Public Function readData() As String

    gTmpStr = "Inside readData"
    WriteLog (gTmpStr)
    
    If p_outstr <> "" Then
        readData = p_outstr
    End If
        
    
    gTmpStr = "p_outstr value - " & p_outstr
    WriteLog (gTmpStr)
    
End Function
Private Sub MSComm1_OnComm()

    Dim DataRecieved As String
    
    On Error GoTo err
    
    gTmpStr = "MsComm On Communication"
    WriteLog (gTmpStr)
        
    'Sleep 5000


' try the most simple receive
'    Select Case MSComm1.CommEvent
        ' Ereignis-Meldungen
'        Case vbMSCommEvReceive
           
    gTmpStr = "Receiving Data from Credit Card Machine..."
    WriteLog (gTmpStr)
    
       
    Dim a As String
    
    'If MSComm1.CommEvent = comEvReceive Then
     '   a = ""
        a = MSComm1.Input
      '  MSComm1.InBufferCount = 0
        WriteLog (a)
        
        If a <> "" Then
            If OptCntr <= 1 Then
                OptCntr = OptCntr + 1
                WriteLog ("OptCntr - " + Str$(OptCntr))
            Else
                OptCntr = OptCntr + 1
                WriteLog ("OptCntr - " + Str$(OptCntr))
            End If
        Else
            If OptCntr >= 1 Then
                OptCntr = OptCntr + 1
                WriteLog ("OptCntr - " + Str$(OptCntr))
            End If
        End If
            
    'End If
    WriteLog ("Converting the Response to Hexadecimal..")
    
        a1 = ""
        
        For i = 1 To Len(a)
            Dim a2 As String
        
            a2 = ""
            a2 = Hex$(Asc(Mid(a, i, 1)))
        
            If Len(a2) = 1 Then
                a2 = "0" & a2
            End If
        
            If a1 = "" Then
                a1 = a2
            Else
                a1 = a1 & " " & a2
            End If
        
        Next i
    
        WriteLog ("Hexadecimal Response - " & a1)
    
        GrespFulltxt = GrespFulltxt + " " + a1
    
        WriteLog ("GrespFulltxt - " + GrespFulltxt)
    
        If OptCntr = 1 Then
            If a1 = "06" Then
                lblAck.Caption = "Y" + " - 06"
                WriteLog ("ACK Received... - " + a1)
                lAck = "Y"
                WriteLog ("lAck - " + lAck)
            Else
                gRespCode = "XX"
                gRespTxt = "Machine not ready..."
        
                WriteLog "gRespCode - " + gRespCode
                WriteLog "gRespTxt - " + gRespTxt
                
                WriteLog "Calling ResponseBuilder() Method..."
                
                ResponseBuilder
                
                lNoComm = "Y"
                
                Unload Me
            End If
        Else
            rec.Text = a1
        End If
    
    
        'GTmpStr = "MSComm1.Input - " & MSComm1.Input
        'WriteLog (GTmpStr)
        
        
        'p_outstr = MSComm1.Input
        
        If lNoComm <> "Y" Then
            gTmpStr = "p_outstr - " & p_outstr
            WriteLog (gTmpStr)
                      
            'If MSComm1.PortOpen Then
             '   MSComm1.PortOpen = False
            'End If
            
            'opt.Text = readData()
            gTmpStr = "Communication Over"
            WriteLog (gTmpStr)
        End If
        
        GoTo NoError
    
err:
    gTmpStr = "Error Occured While Reading - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
    If commOverFlag1 = "Y" Then
        
        WriteLog "Closing Port..."
        
        If MSComm1.PortOpen = True Then
            MSComm1.PortOpen = False
        End If
        
        WriteLog "Exiting Application"
        End
    End If
    
    If lNoComm = "Y" Then
        
        WriteLog "Closing Port..."
        If MSComm1.PortOpen = True Then
            MSComm1.PortOpen = False
        End If
        
        WriteLog "Exiting Application"
        End
    End If
End Sub

Private Sub ipt_LostFocus()
    If Val(ipt.Text) <= 0 Then
       ipt.Text = ""
       Exit Sub
    End If
    
    ipt.Text = Format(Val(ipt.Text), "##########.00")
End Sub

Public Sub LRC_Char(p_amt As Double)
    
    On Error GoTo err
    
    Dim lrccalcmsg As Variant
    Dim tmp As Variant
'[STX][T-LLLL]<--------- Message ---------->[ETX][LRC]
    
    lrccalcmsg = ""
    lrccalcmsg = lrccalcmsg + "D000D065"
    lrccalcmsg = lrccalcmsg + "D054" + "D048"     ' 36 30                               : Application Data
    lrccalcmsg = lrccalcmsg + "D048" + "D048" + "D048" + "D048"
                                                          ' 30 30 30 30                         : Fixed Value = "0000"
    lrccalcmsg = lrccalcmsg + "D048" + "D048" + "D048" + "D048"
                                                          ' 30 30 30 30                         : Fixed Value = "0000"
    lrccalcmsg = lrccalcmsg + "D049"              ' 31                                  : Format Version = 31h
    lrccalcmsg = lrccalcmsg + "D048"              ' 30                                  : RRI Value = 30h
    lrccalcmsg = lrccalcmsg + "D050" + "D048"     ' 32 30                               : TrxCode = Purchase
    lrccalcmsg = lrccalcmsg + "D048" + "D048"     ' 30 30                               : RespCode = 3030h
    lrccalcmsg = lrccalcmsg + "D048"              ' 30                                  : MI Value = 30h
    lrccalcmsg = lrccalcmsg + "D028"              ' 1C                                  : FS Value = 1Ch
    lrccalcmsg = lrccalcmsg + "D052" + "D048"     ' 34 30                               : FT Value = 40 (3430h)
    lrccalcmsg = lrccalcmsg + "D000" + "D018"     ' 00 12                               : LLLL = 12 bytes (0012h)
    
    Temp_String$ = Format(Int(p_amt * 100), String(12, "0"))
    Amount_Messg = ""
    For i = 1 To Len(Temp_String$)
        Amount_Messg = Amount_Messg + "D" + Format(Asc(Mid$(Temp_String$, i, 1)), "000")
    Next i
    
    lrccalcmsg = lrccalcmsg + Amount_Messg                                              ': 12 bytes of Amount
    
    'New Additional Fields
    lrccalcmsg = lrccalcmsg + "D028"                                                    ': FS Value = 1Ch
    
    'Temp_String$ = Format(
    'tmp = ""
    'For i = 1 To Len("74")
     '   tmp = tmp + "D" + Format(Asc(Mid$("74", i, 1)), "000")
    'Next i
        
    'MsgBox tmp
    'lrccalcmsg = lrccalcmsg + tmp
    
    
    lrccalcmsg = lrccalcmsg + "D055"
    lrccalcmsg = lrccalcmsg + "D052"
    
    lrccalcmsg = lrccalcmsg + "D000"
    lrccalcmsg = lrccalcmsg + "D001"
    
    'tmp = ""
    'tmp = "D" + Format(Asc(1), "000") 'For 1 character
    
    For i = 1 To Len(v_term_id)
        tmp = tmp + "D" + Format(Asc(Mid$(v_term_id, i, 1)), "000")
    Next i
    
    lrccalcmsg = lrccalcmsg + tmp
    
    lrccalcmsg = lrccalcmsg + "D028"                                                    ': FS Value = 1Ch
    lrccalcmsg = lrccalcmsg + "D003"                                                    ': FS Value = 03h
    
    LRC_Value% = 0
    For i = 1 To Len(lrccalcmsg) / 4
        LRC_Value% = LRC_Value% Xor Val(Mid$(lrccalcmsg, i * 4 - 2, 3))
    Next i
    LRC = Chr(LRC_Value%)
    GoTo NoError
err:
    gTmpStr = "Error Occured While LRC Calculation - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Public Sub LRC_Char_inv(p_inv As String)
    
    On Error GoTo err
    
    Dim lrccalcmsg As Variant
    Dim tmp As Variant
'[STX][T-LLLL]<--------- Message ---------->[ETX][LRC]
    
    lrccalcmsg = ""
    lrccalcmsg = lrccalcmsg + "D000D053"
    lrccalcmsg = lrccalcmsg + "D054" + "D048"     ' 36 30                               : Application Data
    lrccalcmsg = lrccalcmsg + "D048" + "D048" + "D048" + "D048"
                                                          ' 30 30 30 30                         : Fixed Value = "0000"
    lrccalcmsg = lrccalcmsg + "D048" + "D048" + "D048" + "D048"
                                                          ' 30 30 30 30                         : Fixed Value = "0000"
    lrccalcmsg = lrccalcmsg + "D049"              ' 31                                  : Format Version = 31h
    lrccalcmsg = lrccalcmsg + "D048"              ' 30                                  : RRI Value = 30h
    lrccalcmsg = lrccalcmsg + "D050" + "D054"     ' 32 36                               : TrxCode = Void
    lrccalcmsg = lrccalcmsg + "D048" + "D048"     ' 30 30                               : RespCode = 3030h
    lrccalcmsg = lrccalcmsg + "D048"              ' 30                                  : MI Value = 30h
    lrccalcmsg = lrccalcmsg + "D028"              ' 1C                                  : FS Value = 1Ch
    lrccalcmsg = lrccalcmsg + "D054" + "D053"     ' 36 35                               : FT Value = 65 (3635h)
    lrccalcmsg = lrccalcmsg + "D000" + "D006"     ' 00 06                               : LLLL = 6 bytes (0006h)
    
    Temp_String$ = Format(p_inv, String(6, "0"))
    Amount_Messg = ""
    For i = 1 To Len(Temp_String$)
        Amount_Messg = Amount_Messg + "D" + Format(Asc(Mid$(Temp_String$, i, 1)), "000")
    Next i
    
    
    lrccalcmsg = lrccalcmsg + Amount_Messg                                              ': 12 bytes of Amount
    
    'New Additional Fields
    lrccalcmsg = lrccalcmsg + "D028"                                                    ': FS Value = 1Ch
    
    'Temp_String$ = Format(
    For i = 1 To Len("74")
        tmp = tmp + "D" + Format(Asc(Mid$("74", i, 1)), "000")
    Next i
        
    lrccalcmsg = lrccalcmsg + tmp
    lrccalcmsg = lrccalcmsg + "D000"
    
    lrccalcmsg = lrccalcmsg + "D001"
    tmp = ""
    
    'tmp = "D" + Format(Asc(1), "000") 'For 1 character
    
    For i = 1 To Len(v_term_id)
        tmp = tmp + "D" + Format(Asc(Mid$(v_term_id, i, 1)), "000")
    Next i
    
    lrccalcmsg = lrccalcmsg + tmp
    
    'lrccalcmsg = lrccalcmsg + "D048" 'for passing 0
    lrccalcmsg = lrccalcmsg + "D028"                                                    ': FS Value = 1Ch
    lrccalcmsg = lrccalcmsg + "D003"                                                    ': FS Value = 03h
    
    LRC_Value% = 0
    For i = 1 To Len(lrccalcmsg) / 4
        LRC_Value% = LRC_Value% Xor Val(Mid$(lrccalcmsg, i * 4 - 2, 3))
    Next i
    LRC = Chr(LRC_Value%)
    GoTo NoError
err:
    gTmpStr = "Error Occured While LRC Calculation - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Private Sub rec_Change()
    Dim tmp_str As String
    Dim tmp_codefetch  As String
    Dim tmpstr1 As Integer
    Dim tmp_fieldfetch_act  As String
    Dim tmpcnt As Integer

    On Error GoTo err
    
    tmp_str = rec.Text
    'tmp_str = "06 02 02 94 36 30 30 30 30 30 30 30 30 30 31 31 32 30 30 30 30 1C 30 32 00 40 41 50 50 52 4F 56 41 4C 20 20 20 20 20 20 58 58 58 58 58 58 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 1C 44 30 00 69 53 49 52 49 52 41 4A 20 48 4F 53 50 49 54 41 4C 20 20 20 20 20 20 20 50 52 41 4E 4E 4F 4B 20 52 44 2C 20 42 41 4E 47 4B 4F 4B 20 20 20 20 54 2E 30 32 2D 34 31 39 34 37 35 32 20 4D 45 52 23 31 20 20 20 20 20 1C 30 33 00 06 30 38 30 39 32 32 1C 30 34 00 06 31 35 34 39 32 36 1C 30 31 00 06 58 58 58 58 58 58 1C 36 35 00 06 30 30 30 30 30 31 1C 31 36 00 08 31 30 37 32 37 33 32 34 1C 44 31 00 15 30 30 30 30 30 31 31 31 30 32 39 31 32 32 36 1C 44 32 00 10 4D 2F 43 20 20 20 20 20 20 20 1C 33 30 00 16 35 35 37 37 35 35 32 39 32 38 31 33 34 31 39 38 1C 33 31 00 04 31 37 30 34 1C 35 30 00 06 30 30 30 30 30 31 1C 44 33 00 12 00 00 00 00 00 00 00 00 00 00 00 00 1C 44 34 00 02 30 32 1C 03 8E"
    tmp_fieldfetch = ""
    tmp_fieldfetch_act = ""
    
    'After population ACK character has to be sent back to the terminal...
    
    If lAck = "Y" Then
        gTmpStr = "Response Message Population Over..."
        WriteLog (gTmpStr)
    
        gTmpStr = "Decoding each fields..."
        WriteLog (gTmpStr)
    
        gTmpStr = "tmp_str - " + tmp_str
        WriteLog (gTmpStr)
    
        fieldsep = "1C"
    
        Call Fieldfetch(tmp_str)
        
        gTmpStr = "Sending ACK (06) Char to terminal..."
        WriteLog (gTmpStr)
        
        With MSComm1
            gTmpStr = "Port open ?" & .PortOpen
            WriteLog (gTmpStr)
            'If .PortOpen = True Then .PortOpen = False
            
            gTmpStr = "Initializing MSCOMM Properties"
            WriteLog (gTmpStr)
            
            '.Settings = "9600,n,8,1"
            '.CommPort = Val(v_portnum) 'Assigning port no fetched from list
            If Not .PortOpen Then .PortOpen = True
            '.RThreshold = 2
            
            gTmpStr = "MsComm1.Settings = " & .Settings & ", MsComm1.RThreshold = " & .RThreshold & ", MsComm1.CommPort = " & .CommPort & ", MsComm1.PortOpen = " & .PortOpen
            WriteLog (gTmpStr)
        End With
    
        gTmpStr = "Initialization Over"
        WriteLog (gTmpStr)
        
        If MSComm1.PortOpen = True Then
            MSComm1.Output = Chr$(Hex$("06"))
            gTmpStr = "MSComm1.Output = " & Chr$(Hex$("06"))
            WriteLog (gTmpStr)
            Sleep 1000
            
            If commOverFlag = "Y" Then
                commOverFlag1 = "Y"
            End If
                
        End If
    Else
        
        gRespCode = "XX"
        gRespTxt = "No Connection..."
        
        WriteLog "gRespCode - " + gRespCode
        WriteLog "gRespTxt - " + gRespTxt
        
        WriteLog "Calling ResponseBuilder() Method..."
        
        ResponseBuilder
        
        lNoComm = "Y"
        
        Unload Me
        
    End If
        
    GoTo NoError
err:
    gTmpStr = "Error Occured While Text change - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Private Sub Hexatonormal(pMsg As String)
    Dim tmp As String
    Dim tmp1 As String
    Dim tmp2 As String
    Dim tmp3 As String

    On Error GoTo err
    
    tmp = pMsg
    tmp1 = ""
    tmp2 = ""
    tmp3 = ""
    
    While Len(tmp) > 0
        If Len(tmp) > 2 Then
            tmp1 = Mid(tmp, 1, InStr(tmp, " ") - 1)
            tmp3 = Chr$(CLng("&H" & tmp1))

            tmp2 = tmp2 + tmp3
            tmp = Mid(tmp, InStr(tmp, tmp1) + 3)
        Else
            tmp1 = tmp
            tmp3 = Chr$(CLng("&H" & tmp1))

            tmp2 = tmp2 + tmp3
            tmp = ""
        End If
    Wend

    
    pmsgact = Replace(tmp2, Chr$(Val("&H00")), "*")
    
    GoTo NoError
err:
    gTmpStr = "Error Occured While Converting Hexa to normal - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Private Sub Fieldfetch(pMsg As String)
    Dim tmpStr As String
    Dim tmpmsg As String
    Dim tmpctr As Integer
    Dim tmpcode As String
    Dim tmpbyte As Long
    Dim tmplen As Integer
    Dim tmplen1 As Integer
    Dim tmpresp As String
    
    Dim tmpLRC As String
    
    On Error GoTo err
    tmpmsg = pMsg
    tmpctr = 0
    
    'Response Message LRC also to be validated
    If InStr(GrespFulltxt, "1C 03") > 0 Then
        tmpLRC = Mid(GrespFulltxt, InStr(GrespFulltxt, "1C 03") + 6)
        WriteLog "LRC in Response Text - " + tmpLRC
        
        WriteLog "Calling FetchLRC() Method..."
    
        Call FetchLRC(tmpLRC, GrespFulltxt)
       
        WriteLog "After FetchLRC() Method..."
                
    End If
    
    
    
    While Len(tmpmsg) > 0
    
        tmpctr = tmpctr + 1
               
        If tmpctr = 1 Then
            gRespCode = Mid(tmpmsg, InStr(tmpmsg, fieldsep) - 9, 5)
            WriteLog "gRespCode - " + gRespCode
            
            Call Hexatonormal(gRespCode)
            gRespCode = pmsgact
            WriteLog "gRespCode - " + gRespCode
        End If
        
        tmpStr = Mid(tmpmsg, InStr(tmpmsg, fieldsep) + 3, InStr(Mid(tmpmsg, InStr(tmpmsg, fieldsep) + 3), fieldsep) - 2)
        
        tmpcode = Mid(tmpStr, 1, 5)
        
        tmpStr = Mid(tmpStr, 7)
        
        tmpbyte = Replace(Mid(tmpStr, 1, 5), " ", "")
        
        tmpbyte = (tmpbyte * 3) - 1
        
        tmpStr = Mid(tmpStr, 7, tmpbyte)
        
        Call Hexatonormal(tmpStr)
        
        pmsgact = Replace(pmsgact, Chr$(Val("&H00")), "0")
        
        Call FieldStore(tmpcode, pmsgact)
        
        tmplen = 0
        tmplen1 = 0
        
        tmplen = Len(tmpmsg)
        tmpmsg1 = Replace(tmpmsg, "1C ", "")
        tmplen1 = Len(tmpmsg1)
        If tmplen - tmplen1 > 6 Then
            tmpmsg = Mid(tmpmsg, InStr(tmpmsg, fieldsep) + 3)
        Else
            tmpmsg = ""
        End If
        
        

    Wend
    
    WriteLog "Calling ResponseBuilder Method..."
    
    Call ResponseBuilder
    
    WriteLog "ResponseBuilder Method Execution Over..."
    
    GoTo NoError
err:
    gTmpStr = "Error Occured While Field Value fetch - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub

Private Sub FieldStore(code As String, Value As String)
On Error GoTo err

    If code = "30 32" Then
        gRespTxt = Value
        'MsgBox "gApproval - " + gApproval
        WriteLog "gRespTxt - " + gRespTxt
        
        If GLRCValidFlag <> "Y" Then
            gRespTxt = "Checksum Error..." + gRespTxt
            WriteLog "gRespTxt - " + gRespTxt
            WriteLog "Checksum Error, Changing Response Code..."
            gRespCode = "0C"
            WriteLog "gRespCode - " + gRespCode
        End If
        
    ElseIf code = "44 30" Then
        gMercNmAdd = Value
        'MsgBox "Merchant Name & Address - " + gMercNmAdd
        WriteLog "gMercNmAdd - " + gMercNmAdd
    ElseIf code = "30 33" Then
        gTrnDate = Value
        'MsgBox "Transaction Date - " + gTrnDate
        WriteLog "gTrnDate - " + gTrnDate
    ElseIf code = "30 34" Then
        gTrnTime = Value
        'MsgBox "Transaction Time - " + gTrnTime
        WriteLog "gTrnTime - " + gTrnTime
    ElseIf code = "30 31" Then
        gApprovalCode1 = Value
        'MsgBox "Approval Code - " + gApprovalCode1
        WriteLog "gApprovalCode1 - " + gApprovalCode1
    ElseIf code = "36 35" Then
        gInvNo = Value
        'MsgBox "Invoice No. - " + gInvNo
        WriteLog "gInvNo - " + gInvNo
    ElseIf code = "31 36" Then
        gTerminalIdNo = Value
        'MsgBox "Terminal Identification No - " + gTerminalIdNo
        WriteLog "gTerminalIdNo - " + gTerminalIdNo
    ElseIf code = "44 31" Then
        gMercNo = Value
        'MsgBox "Merchant No. - " + gMercNo
        WriteLog "gMercNo - " + gMercNo
    ElseIf code = "44 32" Then
        gCardIssNm = Value
        'MsgBox "Card Issuer No. - " + gCardIssNm
        WriteLog "gCardIssNm - " + gCardIssNm
        
        'If InStr(gCardIssNm, " ") > 0 Then
        If InStr(gCardIssNm, " ") > 0 Then
            'gCardIssBnk = LTrim(RTrim(Mid(gCardIssNm, InStr(gCardIssNm, " ") + 1)))
            gCardIssNm = LTrim(RTrim(Mid(gCardIssNm, 1, InStr(gCardIssNm, " ") - 1)))
        Else
            gCardIssNm = LTrim(RTrim(gCardIssNm))
        End If
        
        WriteLog "gCardIssNm - " + gCardIssNm
        
        
    ElseIf code = "33 30" Then
        gCardNo = Value
        'MsgBox "Card No. - " + gCardNo
        WriteLog "gCardNo - " + gCardNo
        
        'As told by Siriraj
        gCardIssBnk = Mid(gCardNo, 1, 6)
        WriteLog "gCardIssBnk - " + gCardIssBnk
        
    ElseIf code = "33 31" Then
        gExpDt = Value
        'MsgBox "Expiry Date - " + gExpDt
        WriteLog "gExpDt - " + gExpDt
    ElseIf code = "35 30" Then
        gBatchNo = Value
        'MsgBox "Batch No. - " + gBatchNo
        WriteLog "gBatchNo - " + gBatchNo
    ElseIf code = "44 33" Then
        gRetrievalRefNo = Value
        'MsgBox "Retrieval Ref No. - " + gRetrievalRefNo
        WriteLog "gRetrievalRefNo - " + gRetrievalRefNo
    ElseIf code = "44 34" Then
        gCardIssId = Value
        'MsgBox "Card Issuer Id - " + gCardIssId
        WriteLog "gCardIssId - " + gCardIssId
    ElseIf code = "44 35" Then
        gCardHolderNm = Replace(Value, "*", "")
        
        gCardHolderNm = LTrim(RTrim(gCardHolderNm))
        
        WriteLog "gCardHolderNm - " + gCardHolderNm
    End If
    
    
    GoTo NoError
err:
    gTmpStr = "Error Occured While Storing Field Values - " & err.Description
    WriteLog (gTmpStr)
    gErrorText = gErrorText + Chr(10) + gTmpStr
NoError:
End Sub
Private Sub ResponseBuilder()
    On Error GoTo err
    
    WriteLog "Inside ResponseBuilder Method..."
    
    gRespMsg = gRequestText + "|" + gRespCode + "|" + gRespTxt + "|" + gMercNmAdd + "|" + gTrnDate + "|" + gTrnTime + "|" + gApprovalCode1 + "|" + gInvNo + "|" + gTerminalIdNo + "|" + gMercNo + "|" + gCardIssNm + "|" + gCardNo + "|" + gExpDt + "|" + gBatchNo + "|" + gRetrievalRefNo + "|" + gCardHolderNm + "|" + gCardIssBnk
    
    WriteLog "gRespMsg - " + gRespMsg
    
    If gRespMsg <> "" Then
        WriteLog "Calling UpdateResponse Method..."
        
        Call UpdateResponse
        
        WriteLog "UpdateResponse Method Execution Over..."
        commOverFlag = "Y"
    End If
    GoTo NoError
err:
    gTmpStr = "Error Occured While Building Response - " & err.Description
    gErrorText = gErrorText + Chr(10) + gTmpStr
    WriteLog (gTmpStr)
NoError:
End Sub
'For application users, this has to be set.
Private Sub set_meduser_role()

    On Error GoTo err
    
    Dim OraroleId As String
    Dim Orarolepwd As String
    
    OraroleId = "MEDUSERS"
    Orarolepwd = ""

    Dim recsetRole As New ADODB.Recordset
    Dim recsetRole1 As New ADODB.Recordset
    Dim recsetRole2 As New ADODB.Recordset

    WriteLog ("Inside Setting Medusers role Method ... ")

    gSqlText = "SELECT ORA_ROLE_PASSWORD FROM SM_ORA_ROLE WHERE ORA_ROLE_ID = '" & OraroleId & "'"

    gTmpStr = "Executing Select Statement..."
    WriteLog (gTmpStr)

    recsetRole.Open gSqlText, gCnn, adOpenDynamic, adLockOptimistic

    Orarolepwd = recsetRole!ora_role_password

    gTmpStr = "Calling Password Decrypt function..."
    WriteLog (gTmpStr)

    gSqlText = "SELECT APP_PASSWORD.DECRYPT('" & Orarolepwd & "') pwd FROM DUAL"

    gTmpStr = "Executing Password Decrypt function..."
    WriteLog (gTmpStr)

    recsetRole1.Open gSqlText, gCnn, adOpenDynamic, adLockOptimistic
    
    gTmpStr = "Function Executed..."
    WriteLog (gTmpStr)

    Orarolepwd = recsetRole1!pwd
    
    WriteLog ("Setting Medusers role...")

    WriteLog ("Set Role Statement Creation...")
    
    gSqlText = "SET ROLE " & OraroleId & " IDENTIFIED BY " & Orarolepwd & ""

    WriteLog ("Set Role Statement Execution...")
    
    recsetRole2.Open gSqlText, gCnn, adOpenDynamic, adLockOptimistic
    
    WriteLog ("Set Role Statement Executed...")
    WriteLog ("Medusers Role Successfully set...")
    GoTo NoError
    
err:
    gTmpStr = "Error Occured while setting Medusers Role - " & err.Description
    gErrorText = gErrorText + Chr(10) + gTmpStr
    WriteLog (gTmpStr)
NoError:
End Sub

Private Sub UpdateResponse()

    Dim recsetParam As New ADODB.Recordset
    Dim OfflinePurgeYn As String
    
    On Error GoTo err
    
    WriteLog "Inside UpdateResponse() Method..."
    
    Dim recsetUpd As New ADODB.Recordset
    
    set_meduser_role
    
    WriteLog "Update Statement Formation..."
    
    gSqlText = "UPDATE xh_interactive_integration "
    gSqlText = gSqlText + "SET response_text = '" + gRespMsg + "'"
    'gSqlText = gSqlText + "error_text = '" + gErrorText + "' "
    gSqlText = gSqlText + "WHERE TRX_NO = '" + gMsgId + "' "
    gSqlText = gSqlText + "AND PGM_ID = 'XBCC'"
    
    WriteLog "gSqlText - " + gSqlText
    
    recsetUpd.Open gSqlText, gCnn, adOpenKeyset, adLockOptimistic
    
    WriteLog "Update Execution Over..."
    
    WriteLog ("Query Formation for fetching Offline_Purge_yn from xh_param...")
    
    gSqlText = "SELECT Offline_Purge_yn FROM xh_param"
    
    WriteLog ("Query - " + gSqlText)
    
    WriteLog "Opening Recordset for fetching offline_purge_yn"
    
    recsetParam.Open gSqlText, gCnn, adOpenKeyset, adLockBatchOptimistic
    
    OfflinePurgeYn = recsetParam!offline_purge_yn
    
    WriteLog "OfflinePurgeYn - " + OfflinePurgeYn
    
    If OfflinePurgeYn = "Y" Then
        'For Purging
        WriteLog "Delete Statement Formation..."
        
        gSqlText = "DELETE xh_interactive_integration "
        gSqlText = gSqlText + "WHERE TRX_NO = '" + gMsgId + "' "
        gSqlText = gSqlText + "AND PGM_ID = 'XBCC'"
        
        WriteLog "gSqlText - " + gSqlText
        
        recsetUpd.Open gSqlText, gCnn, adOpenKeyset, adLockOptimistic
        
        WriteLog "Delete Statement Execution Over..."
    End If
    
    GoTo NoError

err:
    gTmpStr = "Error Occured while Updating the response - " & err.Description
    WriteLog (gTmpStr)
NoError:
End Sub

Private Sub RespTimer_Timer()
On Error GoTo err

    ' Initialize
    If RespTimer.Interval <> 30000 Then
        RespTimer.Interval = 30000
    End If
    
    ' Check if program running - backend.
    If gMercNmAdd <> "" Then
        RespTimer.Enabled = False
        
        
        Exit Sub
    End If
    
    
err:
    ' Enable progressbar timer
    RespTimer.Enabled = True
    WriteLog ("Error at RespTimer_Timer() : " & err.Description)
End Sub
Private Sub IntConnParamFetch()
    Dim recsetParam As New ADODB.Recordset
On Error GoTo err

    WriteLog ("Inside IntConnParamFetch() Method...")

    If gCnn.State = 0 Then
        'Opening Oracle DB connection
        gCnn.Open (gConnStr)
        WriteLog ("New Oracle Connection Opened...")
    End If
    
    set_meduser_role
 
    WriteLog ("Query Formation...")
    
    gSqlText = "SELECT comm_process_idle_time FROM xh_interactive_connect_param WHERE plugin_type = 'CC'"
    
    WriteLog ("Query - " + gSqlText)
    
    WriteLog "Opening Recordset for fetching Request_text"
    
    recsetParam.Open gSqlText, gCnn, adOpenKeyset, adLockBatchOptimistic
    
    If recsetParam.EOF = True Then
        WriteLog "No IdleTime Record present in XH_INTERACTIVE_CONNECT_PARAM for CC Interface..."
        recsetParam.Close
        
        WriteLog "Idle Time defaulting to 120 secs..."
        
        GidleTime = CLng(120)
    Else
        WriteLog "Fetch Records into Recordset..."
        
        If recsetParam!comm_process_idle_time <> vbNull Then
            GidleTime = CLng(recsetParam!comm_process_idle_time)
        Else
            GidleTime = 0
        End If
        
        If GidleTime = 0 Then
            WriteLog "No Idle Time set for CC Interface, defaulting to 120 secs..."
            GidleTime = CLng(120)
        End If
    End If
        
    WriteLog "GidleTime - " + CStr(GidleTime)
    
    CCIdleTimer.Interval = 1000
    
    WriteLog "Enabling Timer..."
    
    CCIdleTimer.Enabled = True
    
    WriteLog "IntConnParamFetch() Method Over..."
    
    gCnn.Close
    
    GoTo NoError
err:
    WriteLog ("Error at IntConnParamFetch() : " & err.Description)
    
    WriteLog "Idle Time defaulting to 120 secs..."
    
    GidleTime = CLng(120)
    
    If gCnn.State = 1 Then
        WriteLog ("Closing Oracle Connection")
        gCnn.Close
    End If
NoError:
        
End Sub
Private Sub CCIdleTimer_Timer()

On Error GoTo err

    ' Initialize
    If cntTimer > GidleTime Then
        
        If gRespMsg = "" Then
            
            CCIdleTimer.Enabled = False
            
            WriteLog ("Request Timed Out, No response from CC Machine...")
            
            gErrorText = "Request Timed Out, No response from CC Machine..."
                    
            gRespCode = "XX"
            gRespTxt = "Request Timed Out"
            
            WriteLog "gRespCode - " + gRespCode
            WriteLog "gRespTxt - " + gRespTxt
            
            WriteLog "Calling ResponseBuilder() Method..."
            
            ResponseBuilder
            
            If MSComm1.PortOpen = False Then
                MSComm1.PortOpen = False
            End If
            
            WriteLog "Exit XBCC..."
            
            Unload Me
        End If
    End If
    
    cntTimer = cntTimer + 1
    
    GoTo NoError
err:
    WriteLog ("Error at CCIdleTimer_Timer() : " & err.Description)
NoError:
End Sub

Private Sub FetchLRC(pLRC As String, pResptxt As String)
    
    Dim i As Integer
    Dim LRC As Integer
    Dim tmpHexa As String
    Dim resptxt As String
    
    Dim lenresp As Integer
    
    On Error GoTo err
    
    LRC = 0
    
    WriteLog "Inside FetchLRC() Method..."
    
    resptxt = pResptxt
    
    WriteLog "Response LRC - " + pLRC
    
    WriteLog "Response resptxt - " + resptxt
    
    resptxt = Mid(resptxt, 1, Len(resptxt) - 2)
    
    resptxt = Mid(resptxt, InStr(resptxt, "02") + 3)
    
    WriteLog "Response resptxt After STX/LRC Removal - " + resptxt
    
    For i = 1 To (Len(resptxt) / 3)
        tmpHexa = Val("&H" + (Trim(Mid(resptxt, i * 3 - 2, 2))))
        LRC = LRC Xor tmpHexa
    Next i
    
    'WriteLog "Calculated LRC - " + LRC
    
    
    
    'WriteLog "LRC after Formatting - " + LRC
    
    GRespCalcLRC = Hex$(LRC)
    
    If Len(GRespCalcLRC) = 1 Then
        GRespCalcLRC = "0" + GRespCalcLRC
    End If
    
    WriteLog "Actual LRC  - " + pLRC
    
    WriteLog "Calculated LRC - " + GRespCalcLRC
    
    If GRespCalcLRC = pLRC Then
        GLRCValidFlag = "Y"
    Else
        GLRCValidFlag = "N"
        WriteLog "CheckSum Error, LRC Values not Matching"
    End If
        
    WriteLog "GLRCValidFlag - " + GLRCValidFlag
    
    GoTo NoError
    
err:
    WriteLog ("Error at FetchLRC() : " & err.Description)
    
    GLRCValidFlag = "N"
    WriteLog "GLRCValidFlag - " + GLRCValidFlag
    
NoError:

End Sub
