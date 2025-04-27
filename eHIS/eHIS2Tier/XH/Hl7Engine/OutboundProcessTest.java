import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import HL7Simulator.Common.Common;

public class OutboundProcessTest
{
	public static String getData() {
		String strMsg="" ;
		try
		{
			FileInputStream fileInputStream = new FileInputStream( "c:/bala/xh/OutboundProcessTest.txt" );
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream));
			strMsg = ""+((char)11);
			String strLine = "";

			while(true)
			{
				strLine = 	buffer.readLine();
				if (strLine == null || strLine.equals(""))
				{
					break;
				}
				strMsg += strLine + (char)13;
			}
			strMsg = strMsg+((char)28)+ ((char)13);
			fileInputStream.close();

		} catch ( Exception e ) {
			System.out.println( "Exception in getData():"+e );
		}

		return strMsg ;
	}

	public static void main(String args[]) {

		Common common = new Common() ;
		Socket socket = null ;
		try	{
			if( args.length < 2 || args.length > 3 ) {
				System.out.println( "Syntax : ClientTest <IP Address> <Port No.> [Message to transmit]") ;
				System.exit(0);
			}
			socket = new Socket(args[0], Integer.parseInt(args[1]) );
			InputStream inSocketStream ;
			OutputStream outSocketStream;
			System.out.println("Connection Established ");
			inSocketStream = socket.getInputStream();
			outSocketStream = socket.getOutputStream();
			String strTotalMessage = "";

			if( args.length == 3 )
				strTotalMessage = args[2] ;
			else
				strTotalMessage = getData() ;

			outSocketStream.write(strTotalMessage.getBytes());

			byte byteMsg[] = new byte[999999];
			int intTotBytes ;
			while(true) {
				intTotBytes = inSocketStream.read(byteMsg);
				if (intTotBytes>0)
				{
					byte byteMsgt[] = new byte[intTotBytes];
					int i;
					for(i=0; i<intTotBytes; i++)
						byteMsgt[i] = byteMsg[i] ;
					common.fileOutput( "c:/bala/receive/received.txt", byteMsgt, intTotBytes);
					System.out.println( "Acknowledged to file" );
					break ;
				}
			}

		} catch (Exception e) {
			System.out.println( "Exception:"+e );
		} finally {
			try	{
				socket.close() ;
				System.out.println( "Connection Closed ");
			} catch (Exception e1) {
				System.out.println( "Exception in closing socket : "+e1 );
			}
		}
	}
}
