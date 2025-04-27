Attribute VB_Name = "ModeHISPrint"
Option Explicit
                        
Const FORMAT_MESSAGE_FROM_SYSTEM = &H1000
Global GArgArray(10)
   
Global Const GTestingYN = False
Global GVServerName As String
Global GVShareName As String
Global GVFunctionName As String
Global GVWorkingDir As String
Global GVCopies As Integer
Global GVReportType As String
Global GRetValStr As String
Global GVCmdLine As String
Global GVFontname As String
Global GVFilename As String 'Added by Anil to store filename alone
Global GVLblFontname As String 'Added by Anil. For ZPL reports only

Public Const ERROR_INSUFFICIENT_BUFFER = 122
Public Const PRINTER_STATUS_BUSY = &H200
Public Const PRINTER_STATUS_DOOR_OPEN = &H400000
Public Const PRINTER_STATUS_ERROR = &H2
Public Const PRINTER_STATUS_INITIALIZING = &H8000
Public Const PRINTER_STATUS_IO_ACTIVE = &H100
Public Const PRINTER_STATUS_MANUAL_FEED = &H20
Public Const PRINTER_STATUS_NO_TONER = &H40000
Public Const PRINTER_STATUS_NOT_AVAILABLE = &H1000
Public Const PRINTER_STATUS_OFFLINE = &H80
Public Const PRINTER_STATUS_OUT_OF_MEMORY = &H200000
Public Const PRINTER_STATUS_OUTPUT_BIN_FULL = &H800
Public Const PRINTER_STATUS_PAGE_PUNT = &H80000
Public Const PRINTER_STATUS_PAPER_JAM = &H8
Public Const PRINTER_STATUS_PAPER_OUT = &H10
Public Const PRINTER_STATUS_PAPER_PROBLEM = &H40
Public Const PRINTER_STATUS_PAUSED = &H1
Public Const PRINTER_STATUS_PENDING_DELETION = &H4
Public Const PRINTER_STATUS_PRINTING = &H400
Public Const PRINTER_STATUS_PROCESSING = &H4000
Public Const PRINTER_STATUS_TONER_LOW = &H20000
Public Const PRINTER_STATUS_USER_INTERVENTION = &H100000
Public Const PRINTER_STATUS_WAITING = &H2000
Public Const PRINTER_STATUS_WARMING_UP = &H10000
Public Const JOB_STATUS_PAUSED = &H1
Public Const JOB_STATUS_ERROR = &H2
Public Const JOB_STATUS_DELETING = &H4
Public Const JOB_STATUS_SPOOLING = &H8
Public Const JOB_STATUS_PRINTING = &H10
Public Const JOB_STATUS_OFFLINE = &H20
Public Const JOB_STATUS_PAPEROUT = &H40
Public Const JOB_STATUS_PRINTED = &H80
Public Const JOB_STATUS_DELETED = &H100
Public Const JOB_STATUS_BLOCKED_DEVQ = &H200
Public Const JOB_STATUS_USER_INTERVENTION = &H400
Public Const JOB_STATUS_RESTART = &H800

Dim v_code_str(1000) As Long
Dim v_offset   As Integer
Dim v_highascii      As Integer
Dim v_total      As Integer
Dim v_char             As String
Dim v_ascival  As Integer
Dim v_checkdigit As Integer
Dim v_check      As Integer
Dim v_holder  As Long
Dim v_out As String
Dim v_len As Integer
Dim v_data   As String
Dim i As Integer
Dim v_double_chr As String
Dim v_calc_length As Integer
Dim v_check_sum As Long
Dim v_tempstr As String
Dim p_split_char As String
 
 
Declare Function GetPrivateProfileString Lib "kernel32" Alias "GetPrivateProfileStringA" (ByVal lpApplicationName As String, ByVal lpKeyName As Any, ByVal lpDefault As String, ByVal lpReturnedString As String, ByVal nSize As Long, ByVal lpFileName As String) As Long
Declare Function GetProfileString Lib "kernel32" Alias "GetProfileStringA" (ByVal lpAppName As String, ByVal lpKeyName As String, ByVal lpDefault As String, ByVal lpReturnedString As String, ByVal nSize As Long) As Long

Declare Function WriteProfileString Lib "kernel32" _
Alias "WriteProfileStringA" _
(ByVal lpszSection As String, _
ByVal lpszKeyName As String, _
ByVal lpszString As String) As Long

Declare Function SendMessage Lib "user32" _
Alias "SendMessageA" _
(ByVal hwnd As Long, _
ByVal wMsg As Long, _
ByVal wParam As Long, _
lparam As String) As Long

Private Declare Function FormatMessage Lib "kernel32" Alias _
      "FormatMessageA" (ByVal dwFlags As Long, lpSource As Long, _
      ByVal dwMessageId As Long, ByVal dwLanguageId As Long, _
      ByVal lpBuffer As String, ByVal nSize As Long, Arguments As Any) _
      As Long


Public Declare Function OpenPrinter Lib "winspool.drv" _
   Alias "OpenPrinterA" _
   (ByVal pPrinterName As String, _
   phPrinter As Long, _
   pDefault As PRINTER_DEFAULTS) _
   As Long

Public Declare Function GetPrinter Lib "winspool.drv" Alias "GetPrinterA" _
   (ByVal hPrinter As Long, _
   ByVal Level As Long, _
   pPrinter As Byte, _
   ByVal cbBuf As Long, _
   pcbNeeded As Long) _
   As Long

Public Declare Function ClosePrinter Lib "winspool.drv" _
   (ByVal hPrinter As Long) _
   As Long

Public Declare Sub CopyMemory Lib "kernel32" Alias "RtlMoveMemory" _
   (Destination As Any, _
   Source As Any, _
   ByVal Length As Long)

Public Declare Function EnumJobs Lib "winspool.drv" Alias "EnumJobsA" _
   (ByVal hPrinter As Long, _
   ByVal FirstJob As Long, _
   ByVal NoJobs As Long, _
   ByVal Level As Long, _
   pJob As Byte, _
   ByVal cdBuf As Long, _
   pcbNeeded As Long, _
   pcReturned As Long) _
   As Long
   
' constants for PRINTER_DEFAULTS structure
Public Const PRINTER_ACCESS_USE = &H8
Public Const PRINTER_ACCESS_ADMINISTER = &H4

' constants for DEVMODE structure
Public Const CCHDEVICENAME = 32
Public Const CCHFORMNAME = 32

Public Type PRINTER_DEFAULTS
   pDatatype As String
   pDevMode As Long
   DesiredAccess As Long
End Type


Type SYSTEMTIME
   wYear As Integer
   wMonth As Integer
   wDayOfWeek As Integer
   wDay As Integer
   wHour As Integer
   wMinute As Integer
   wSecond As Integer
   wMilliseconds As Integer
End Type

Type JOB_INFO_2
   JobId As Long
   pPrinterName As Long
   pMachineName As Long
   pUserName As Long
   pDocument As Long
   pNotifyName As Long
   pDatatype As Long
   pPrintProcessor As Long
   pParameters As Long
   pDriverName As Long
   pDevMode As Long
   pStatus As Long
   pSecurityDescriptor As Long
   Status As Long
   Priority As Long
   Position As Long
   StartTime As Long
   UntilTime As Long
   TotalPages As Long
   Size As Long
   Submitted As SYSTEMTIME
   time As Long
   PagesPrinted As Long
End Type

Type PRINTER_INFO_2
   pServerName As Long
   pPrinterName As Long
   pShareName As Long
   pPortName As Long
   pDriverName As Long
   pComment As Long
   pLocation As Long
   pDevMode As Long
   pSepFile As Long
   pPrintProcessor As Long
   pDatatype As Long
   pParameters As Long
   pSecurityDescriptor As Long
   Attributes As Long
   Priority As Long
   DefaultPriority As Long
   StartTime As Long
   UntilTime As Long
   Status As Long
   cJobs As Long
   AveragePPM As Long
End Type


Public Function CheckPrinterStatus(PI2Status As Long) As String
   Dim tempStr As String
   Dim vbCrlf As String
   
   
   If PI2Status = 0 Then   ' Return "Ready"
      vbCrlf = ""
      CheckPrinterStatus = "Ready" & vbCrlf
   Else
      tempStr = ""   ' Clear
      If (PI2Status And PRINTER_STATUS_BUSY) Then
         tempStr = tempStr & "Busy "
      End If
      
      If (PI2Status And PRINTER_STATUS_DOOR_OPEN) Then
         tempStr = tempStr & "Printer Door Open "
      End If
      
      If (PI2Status And PRINTER_STATUS_ERROR) Then
         tempStr = tempStr & "Printer Error "
      End If
      
      If (PI2Status And PRINTER_STATUS_INITIALIZING) Then
         tempStr = tempStr & "Initializing "
      End If
      
      If (PI2Status And PRINTER_STATUS_IO_ACTIVE) Then
         tempStr = tempStr & "I/O Active "
      End If

      If (PI2Status And PRINTER_STATUS_MANUAL_FEED) Then
         tempStr = tempStr & "Manual Feed "
      End If
      
      If (PI2Status And PRINTER_STATUS_NO_TONER) Then
         tempStr = tempStr & "No Toner "
      End If
      
      If (PI2Status And PRINTER_STATUS_NOT_AVAILABLE) Then
         tempStr = tempStr & "Not Available "
      End If
      
      If (PI2Status And PRINTER_STATUS_OFFLINE) Then
         tempStr = tempStr & "Off Line "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUT_OF_MEMORY) Then
         tempStr = tempStr & "Out of Memory "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUTPUT_BIN_FULL) Then
         tempStr = tempStr & "Output Bin Full "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAGE_PUNT) Then
         tempStr = tempStr & "Page Punt "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAPER_JAM) Then
         tempStr = tempStr & "Paper Jam "
      End If

      If (PI2Status And PRINTER_STATUS_PAPER_OUT) Then
         tempStr = tempStr & "Paper Out "
      End If
      
      If (PI2Status And PRINTER_STATUS_OUTPUT_BIN_FULL) Then
         tempStr = tempStr & "Output Bin Full "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAPER_PROBLEM) Then
         tempStr = tempStr & "Page Problem "
      End If
      
      If (PI2Status And PRINTER_STATUS_PAUSED) Then
         tempStr = tempStr & "Paused "
      End If

      If (PI2Status And PRINTER_STATUS_PENDING_DELETION) Then
         tempStr = tempStr & "Pending Deletion "
      End If
      
      If (PI2Status And PRINTER_STATUS_PRINTING) Then
         tempStr = tempStr & "Printing "
      End If
      
      If (PI2Status And PRINTER_STATUS_PROCESSING) Then
         tempStr = tempStr & "Processing "
      End If
      
      If (PI2Status And PRINTER_STATUS_TONER_LOW) Then
         tempStr = tempStr & "Toner Low "
      End If

      If (PI2Status And PRINTER_STATUS_USER_INTERVENTION) Then
         tempStr = tempStr & "User Intervention "
      End If
      
      If (PI2Status And PRINTER_STATUS_WAITING) Then
         tempStr = tempStr & "Waiting "
      End If
      
      If (PI2Status And PRINTER_STATUS_WARMING_UP) Then
         tempStr = tempStr & "Warming Up "
      End If
       
      'Did you find a known status?
      If Len(tempStr) = 0 Then
         tempStr = "Unknown Status of " & PI2Status
      End If
      
      'Return the Status
      CheckPrinterStatus = "Printer Status = " & tempStr & vbCrlf
   End If
End Function


Public Function GetString(ByVal PtrStr As Long) As String
   Dim StrBuff As String * 256
   
   'Check for zero address
   If PtrStr = 0 Then
      GetString = " "
      Exit Function
   End If
   
   'Copy data from PtrStr to buffer.
   CopyMemory ByVal StrBuff, ByVal PtrStr, 256
   
   'Strip any trailing nulls from string.
   GetString = StripNulls(StrBuff)
End Function

Public Function StripNulls(OriginalStr As String) As String
   'Strip any trailing nulls from input string.
   If (InStr(OriginalStr, Chr(0)) > 0) Then
      OriginalStr = Left(OriginalStr, InStr(OriginalStr, Chr(0)) - 1)
   End If

   'Return modified string.
   StripNulls = OriginalStr
End Function
Public Function MessageText(lCode As Long) As String
    Dim sRtrnCode As String
    Dim lRet As Long

    sRtrnCode = Space$(256)
    lRet = FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM, 0&, lCode, 0&, _
              sRtrnCode, 256&, 0&)
    If lRet > 0 Then
       MessageText = Left(sRtrnCode, lRet)
    Else
       MessageText = "Error not found."
    End If

End Function
        
Public Sub GetCommandLine(Optional MaxArgs)
    Dim GVWorkingDir As String
    Dim LCMDFileName As String
    Dim CMDFSO As FileSystemObject
    Dim CMDFile As File
    
    'Declare variables.
   Dim C, CmdLnLen, InArg, i, NumArgs
   'See if MaxArgs was provided.
   If IsMissing(MaxArgs) Then MaxArgs = 10
   
   'Make array of the correct size.
   NumArgs = 0: InArg = False
    
    'Get the font name from eHIS.ini file.
    GVFontname = GetSysIni("Reports", "Font")
    GVLblFontname = GetSysIni("Reports", "LabelFont") 'Added by Anil for ZPL reports
   
   'Get command line from FunctionName.CMD
    GVWorkingDir = GetSysIni("Reports", "Dir")
    If Right(GVWorkingDir, 1) = "\" Then
        GVWorkingDir = Mid(GVWorkingDir, 1, Len(GVWorkingDir) - 1)
    End If
    LCMDFileName = GVWorkingDir & "\eHISPRINT.CMD"
    Close #3
    Open LCMDFileName For Input As 3
    Line Input #3, GVCmdLine
    Close #3
   
    CmdLnLen = Len(GVCmdLine)
   
   'Go thru command line one character
   'at a time.
    '  MsgBox (CmdLnLen)
   
   For i = 1 To CmdLnLen
      C = Mid(GVCmdLine, i, 1)
      'Test for ; (delimiter)
      If (C <> ";") Then
         If Not InArg Then
         'New argument begins.
         'Test for too many arguments.
            If NumArgs = MaxArgs Then Exit For
            NumArgs = NumArgs + 1
            InArg = True
         End If
         'Concatenate character to current argument.
         GArgArray(NumArgs) = GArgArray(NumArgs) & C
      Else
         'Found a space or tab.
         'Set InArg flag to False.
         InArg = False
      End If
   Next i
   
    'For I = 1 To NumArgs
    '    MsgBox GArgArray(I)
    'Next I
   
    '
    ' Remove CMD File.
    '
    'Set CMDFSO = New FileSystemObject
    'Set CMDFile = CMDFSO.GetFile(LCMDFileName)
    'CMDFile.Delete
   
End Sub
Function GetSysIni(section As String, key As String) As String
Dim retVal As String, AppName As String, worked As Integer
    retVal = String$(255, 0)
    worked = GetPrivateProfileString(section, key, "", retVal, Len(retVal), "eHIS.ini")
    If worked = 0 Then
        GetSysIni = "unknown"
    Else
        GetSysIni = Left(retVal, worked)
    End If
End Function


Function get_barcode(p_raw_Data As String) As String
      v_offset = 32
      v_highascii = 18
      v_total = 104
      v_holder = 0
      v_out = ""
   '   v_code_str(0) = 50593
      v_code_str(0) = 154
      
  For i = 1 To Len(p_raw_Data)
      
        v_char = Mid(p_raw_Data, i, 1)

         If Asc(v_char) = "14844061" Or Asc(v_char) = "148" Then
            v_ascival = "148"
         Else
            v_ascival = Asc(v_char)
         End If

         If Asc(v_char) = "14844588" Or Asc(v_char) = "128" Then
            v_ascival = "128"
         Else
            v_ascival = Asc(v_char)
         End If

         If v_ascival >= 127 Then
            v_checkdigit = ((v_ascival - v_offset - v_highascii) * (i))
         Else
            v_checkdigit = ((v_ascival - v_offset) * (i))
         End If

         v_total = v_total + v_checkdigit
         v_code_str(i) = v_ascival
    
  Next
  
  
  
  
            v_check = v_total Mod 103

      'Start
      If (v_check + v_offset) >= 127 Then
             v_check_sum = v_check + v_offset + v_highascii
      Else
         v_check_sum = v_check + v_offset
      End If
      
v_calc_length = Len(p_raw_Data) + 1
        v_code_str(v_calc_length) = v_check_sum
 '       v_holder = 50579
        v_holder = 156
     '( Stop Indicator) Indi106 + v_offset + v_highascii;
v_calc_length = v_calc_length + 1
         v_code_str(v_calc_length) = v_holder
    

     
     
'    For i = 0 To v_calc_length
'
'         If v_code_str(i) = 32 Then
'            v_code_str(i) = 14844588
'         ElseIf v_code_str(i) = 128 Then
'            v_code_str(i) = 14844588
'         ElseIf v_code_str(i) = 130 Then
'            v_code_str(i) = 14844058
'         ElseIf v_code_str(i) = 131 Then
'            v_code_str(i) = 50834
'         ElseIf v_code_str(i) = 132 Then
'            v_code_str(i) = 14844062
'         ElseIf v_code_str(i) = 133 Then
'            v_code_str(i) = 14844070
'         ElseIf v_code_str(i) = 134 Then
'            v_code_str(i) = 14844064
'         ElseIf v_code_str(i) = 135 Then
'            v_code_str(i) = 14844065
'         ElseIf v_code_str(i) = 136 Then
'            v_code_str(i) = 52102
'         ElseIf v_code_str(i) = 137 Then
'            v_code_str(i) = 14844080
'         ElseIf v_code_str(i) = 138 Then
'            v_code_str(i) = 50592
'         ElseIf v_code_str(i) = 139 Then
'            v_code_str(i) = 14844089
'         ElseIf v_code_str(i) = 140 Then
'            v_code_str(i) = 50578
'         ElseIf v_code_str(i) = 142 Then
'            v_code_str(i) = 50621
'         ElseIf v_code_str(i) = 145 Then
'            v_code_str(i) = 14844056
'         ElseIf v_code_str(i) = 146 Then
'            v_code_str(i) = 14844057
'         ElseIf v_code_str(i) = 147 Then
'            v_code_str(i) = 14844060
'         ElseIf v_code_str(i) = 148 Then
'            v_code_str(i) = 14844061
'         ElseIf v_code_str(i) = 149 Then
'            v_code_str(i) = 14844066
'         ElseIf v_code_str(i) = 150 Then
'            v_code_str(i) = 14844051
'         ElseIf v_code_str(i) = 151 Then
'            v_code_str(i) = 14844052
'         ElseIf v_code_str(i) = 152 Then
'            v_code_str(i) = 52124
'         ElseIf v_code_str(i) = 153 Then
'            v_code_str(i) = 14845090
'         ElseIf v_code_str(i) = 154 Then
'            v_code_str(i) = 50593
'         ElseIf v_code_str(i) = 155 Then
'            v_code_str(i) = 14844090
'         ElseIf v_code_str(i) = 156 Then
'            v_code_str(i) = 50579
'         ElseIf v_code_str(i) = 158 Then
'            v_code_str(i) = 50622
'         ElseIf v_code_str(i) = 159 Then
'            v_code_str(i) = 50616
'         ElseIf v_code_str(i) = 161 Then
'            v_code_str(i) = 49825
'         ElseIf v_code_str(i) = 162 Then
'            v_code_str(i) = 49826
'         ElseIf v_code_str(i) = 163 Then
'            v_code_str(i) = 49827
'         ElseIf v_code_str(i) = 164 Then
'            v_code_str(i) = 49828
'         ElseIf v_code_str(i) = 165 Then
'            v_code_str(i) = 49829
'         ElseIf v_code_str(i) = 166 Then
'            v_code_str(i) = 49830
'         ElseIf v_code_str(i) = 167 Then
'            v_code_str(i) = 49831
'         ElseIf v_code_str(i) = 168 Then
'            v_code_str(i) = 49832
'         ElseIf v_code_str(i) = 169 Then
'            v_code_str(i) = 49833
'         ElseIf v_code_str(i) = 170 Then
'            v_code_str(i) = 49834
'         ElseIf v_code_str(i) = 171 Then
'            v_code_str(i) = 49835
'         ElseIf v_code_str(i) = 172 Then
'            v_code_str(i) = 49836
'         ElseIf v_code_str(i) = 173 Then
'            v_code_str(i) = 49837
'         ElseIf v_code_str(i) = 174 Then
'            v_code_str(i) = 49838
'         ElseIf v_code_str(i) = 175 Then
'            v_code_str(i) = 49839
'         ElseIf v_code_str(i) = 176 Then
'            v_code_str(i) = 49840
'         ElseIf v_code_str(i) = 177 Then
'            v_code_str(i) = 49841
'         ElseIf v_code_str(i) = 178 Then
'            v_code_str(i) = 49842
'         ElseIf v_code_str(i) = 179 Then
'            v_code_str(i) = 49843
'         ElseIf v_code_str(i) = 180 Then
'            v_code_str(i) = 49844
'         ElseIf v_code_str(i) = 181 Then
'            v_code_str(i) = 49845
'         ElseIf v_code_str(i) = 182 Then
'            v_code_str(i) = 49846
'         ElseIf v_code_str(i) = 183 Then
'            v_code_str(i) = 49847
'         ElseIf v_code_str(i) = 184 Then
'            v_code_str(i) = 49848
'         ElseIf v_code_str(i) = 185 Then
'            v_code_str(i) = 49849
'         ElseIf v_code_str(i) = 186 Then
'            v_code_str(i) = 49850
'         ElseIf v_code_str(i) = 187 Then
'            v_code_str(i) = 49851
'         ElseIf v_code_str(i) = 188 Then
'            v_code_str(i) = 49852
'         ElseIf v_code_str(i) = 189 Then
'            v_code_str(i) = 49853
'         ElseIf v_code_str(i) = 190 Then
'            v_code_str(i) = 49854
'         ElseIf v_code_str(i) = 191 Then
'            v_code_str(i) = 49855
'         ElseIf v_code_str(i) = 192 Then
'            v_code_str(i) = 50048
'         ElseIf v_code_str(i) = 193 Then
'            v_code_str(i) = 50049
'         ElseIf v_code_str(i) = 194 Then
'            v_code_str(i) = 50050
'         ElseIf v_code_str(i) = 195 Then
'            v_code_str(i) = 50051
'         ElseIf v_code_str(i) = 196 Then
'            v_code_str(i) = 50052
'         ElseIf v_code_str(i) = 197 Then
'            v_code_str(i) = 50053
'         ElseIf v_code_str(i) = 198 Then
'            v_code_str(i) = 50054
'         ElseIf v_code_str(i) = 199 Then
'            v_code_str(i) = 50055
'         ElseIf v_code_str(i) = 200 Then
'            v_code_str(i) = 50056
'         ElseIf v_code_str(i) = 201 Then
'            v_code_str(i) = 50057
'         ElseIf v_code_str(i) = 202 Then
'            v_code_str(i) = 50058
'         ElseIf v_code_str(i) = 203 Then
'            v_code_str(i) = 50059
'         ElseIf v_code_str(i) = 204 Then
'            v_code_str(i) = 50060
'         ElseIf v_code_str(i) = 205 Then
'            v_code_str(i) = 50061
'         ElseIf v_code_str(i) = 206 Then
'            v_code_str(i) = 50062
'         ElseIf v_code_str(i) = 207 Then
'            v_code_str(i) = 50063
'         ElseIf v_code_str(i) = 208 Then
'            v_code_str(i) = 50064
'         ElseIf v_code_str(i) = 209 Then
'            v_code_str(i) = 50065
'         ElseIf v_code_str(i) = 210 Then
'            v_code_str(i) = 50066
'         ElseIf v_code_str(i) = 211 Then
'            v_code_str(i) = 50067
'         ElseIf v_code_str(i) = 212 Then
'            v_code_str(i) = 50068
'         ElseIf v_code_str(i) = 213 Then
'            v_code_str(i) = 50069
'         ElseIf v_code_str(i) = 214 Then
'            v_code_str(i) = 50070
'         ElseIf v_code_str(i) = 215 Then
'            v_code_str(i) = 50071
'         ElseIf v_code_str(i) = 216 Then
'            v_code_str(i) = 50072
'         ElseIf v_code_str(i) = 217 Then
'            v_code_str(i) = 50073
'         ElseIf v_code_str(i) = 218 Then
'            v_code_str(i) = 50074
'         ElseIf v_code_str(i) = 219 Then
'            v_code_str(i) = 50075
'         ElseIf v_code_str(i) = 220 Then
'            v_code_str(i) = 50076
'         ElseIf v_code_str(i) = 221 Then
'            v_code_str(i) = 50077
'         ElseIf v_code_str(i) = 222 Then
'            v_code_str(i) = 50078
'         ElseIf v_code_str(i) = 223 Then
'            v_code_str(i) = 50079
'         ElseIf v_code_str(i) = 224 Then
'            v_code_str(i) = 50080
'         ElseIf v_code_str(i) = 225 Then
'            v_code_str(i) = 50081
'         ElseIf v_code_str(i) = 226 Then
'            v_code_str(i) = 50082
'         ElseIf v_code_str(i) = 227 Then
'            v_code_str(i) = 50083
'         ElseIf v_code_str(i) = 228 Then
'            v_code_str(i) = 50084
'         ElseIf v_code_str(i) = 229 Then
'            v_code_str(i) = 50085
'         ElseIf v_code_str(i) = 230 Then
'            v_code_str(i) = 50086
'         ElseIf v_code_str(i) = 231 Then
'            v_code_str(i) = 50087
'         ElseIf v_code_str(i) = 232 Then
'            v_code_str(i) = 50088
'         ElseIf v_code_str(i) = 233 Then
'            v_code_str(i) = 50089
'         ElseIf v_code_str(i) = 234 Then
'            v_code_str(i) = 50090
'         ElseIf v_code_str(i) = 235 Then
'            v_code_str(i) = 50091
'         ElseIf v_code_str(i) = 236 Then
'            v_code_str(i) = 50092
'         ElseIf v_code_str(i) = 237 Then
'            v_code_str(i) = 50093
'         ElseIf v_code_str(i) = 238 Then
'            v_code_str(i) = 50094
'         ElseIf v_code_str(i) = 239 Then
'            v_code_str(i) = 50095
'         ElseIf v_code_str(i) = 240 Then
'            v_code_str(i) = 50096
'         ElseIf v_code_str(i) = 241 Then
'            v_code_str(i) = 50097
'         ElseIf v_code_str(i) = 242 Then
'            v_code_str(i) = 50098
'         ElseIf v_code_str(i) = 243 Then
'            v_code_str(i) = 50099
'         ElseIf v_code_str(i) = 244 Then
'            v_code_str(i) = 50100
'         ElseIf v_code_str(i) = 245 Then
'            v_code_str(i) = 50101
'         ElseIf v_code_str(i) = 246 Then
'            v_code_str(i) = 50102
'         ElseIf v_code_str(i) = 247 Then
'            v_code_str(i) = 50103
'         ElseIf v_code_str(i) = 248 Then
'            v_code_str(i) = 50104
'         ElseIf v_code_str(i) = 249 Then
'            v_code_str(i) = 50105
'         ElseIf v_code_str(i) = 250 Then
'            v_code_str(i) = 50106
'         ElseIf v_code_str(i) = 251 Then
'            v_code_str(i) = 50107
'         ElseIf v_code_str(i) = 252 Then
'            v_code_str(i) = 50108
'         ElseIf v_code_str(i) = 253 Then
'            v_code_str(i) = 50109
'         ElseIf v_code_str(i) = 254 Then
'            v_code_str(i) = 50110
'         ElseIf v_code_str(i) = 255 Then
'            v_code_str(i) = 50111
'         End If
'      Next
'
    
    
      For i = 0 To v_calc_length

'Debug.Print (v_code_str(i))
'Debug.Print ("\n")

'If i = 0 Or i = v_calc_length Then
'    If i = 0 Then
'        v_double_chr = Chr("50593")
'    Else
'        v_double_chr = Chr("50579")
'    End If
'    Debug.Print (i & "     " & v_double_chr)
'Else
   '    v_double_chr = Chr(v_code_str(i))
'End If


'       v_double_chr = Chr(v_code_str(i))
        'v_out = v_out & Chr(v_code_str(i))
        v_double_chr = Chr(v_code_str(i))
        
         v_out = v_out & v_double_chr
        
   'Debug.Print (v_out)
  'Debug.Print ("\n")
       Next
    
    v_len = 0
    
    For i = Len(v_out) To 0
        If (Mid(v_out, i, 1) = ",") Then
           v_len = v_len + 1
    Else
                Exit For
            End If
    Next
    
    v_tempstr = Mid(v_out, 1, (Len(v_out) - v_len))
      get_barcode = v_tempstr
      
   'Debug.Print (v_out)
   
End Function


Function code128b(p_data As String) As String

      v_data = Replace(p_data, p_split_char, Asc(34) & "m")
      
      code128b = get_barcode(v_data)

End Function



