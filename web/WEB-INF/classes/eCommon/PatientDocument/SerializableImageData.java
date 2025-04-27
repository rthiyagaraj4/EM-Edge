package eCommon.PatientDocument;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.zip.*;

public class SerializableImageData implements java.io.Serializable {


    int width;
    int height;

    byte compressedData[];
    long checksum;


    public SerializableImageData(){
    }

    public SerializableImageData(Image i){
        this(new ImageIcon(i));
    }

    public SerializableImageData(ImageIcon i){
        BufferedImage bi = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        i.paintIcon(null,bi.createGraphics(),0,0);
        setImageData(bi);
    }

    public SerializableImageData(BufferedImage i){
        setImageData(i);
    }

    public void setImageData(BufferedImage i){
        width = i.getWidth();
        height = i.getHeight();

        int data[][] = new int[width][height];

        for (int w=0; w<width; w++)
            for (int h=0; h<height; h++)
                data[w][h] = i.getRGB(w,h);

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(baos, 512*1024));
            oos.writeObject(data);
            oos.close();

            compressedData = baos.toByteArray();

            makeCheckSum();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected int[][] getUncompressedData(){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
            ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(bais,512*1024));
            int data[][] = (int[][])ois.readObject();
            ois.close();

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 

    public BufferedImage getImage(){

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int data[][] = getUncompressedData();

        for (int w=0; w<width; w++)
            for (int h=0; h<height; h++)
                bi.setRGB(w,h,data[w][h]);

        return bi;
    }


    public void makeCheckSum(){
        Adler32 a32 = new Adler32();
        a32.update(compressedData);
        checksum = a32.getValue();
    }

    public boolean equals(Object obj){
        if (obj instanceof SerializableImageData) {
            SerializableImageData id = (SerializableImageData)obj;
            return(id.checksum == this.checksum);

        } else {
            return false;
        }
    }

}
