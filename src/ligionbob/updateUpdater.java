//Taken from https://iofthestorm.wordpress.com/2008/11/26/how-to-write-an-auto-updater-system-in-java/

package ligionbob;

import java.awt.Dimension;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class updateUpdater extends JFrame{
    String updateurl;
    JProgressBar progress;
    public static void main(){
        updateUpdater up = new updateUpdater("http://www.404nojavafound.ml/files/AdventureGameUpdater.jar");
        up.downloadLatestVersion();

    }
    public updateUpdater(String url){
        updateurl = url;
        this.setPreferredSize(new Dimension(640, 480));
        this.setSize(new Dimension(640, 480));
        this.setTitle("Updater");
        progress = new JProgressBar(0,100);
        progress.setValue(0);
        progress.setStringPainted(true);
        this.add(progress);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.requestFocus(true);
    }
    void downloadLatestVersion(){
        URL url;
        try {
            url = new URL(updateurl);
            HttpURLConnection hConnection = (HttpURLConnection) url
                    .openConnection();
            HttpURLConnection.setFollowRedirects(true);
            if (HttpURLConnection.HTTP_OK == hConnection.getResponseCode()) {
                InputStream in = hConnection.getInputStream();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream("AdventureGameUpdater.jar"));
                int filesize = hConnection.getContentLength();
                progress.setMaximum(filesize);
                byte[] buffer = new byte[4096];
                int numRead;
                long numWritten = 0;
                while ((numRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, numRead);
                    numWritten += numRead;
                    System.out.println((double)numWritten/(double)filesize);
                    progress.setValue((int) numWritten);
                }
                if(filesize!=numWritten)
                    System.out.println("Wrote "+numWritten+" bytes, should have been "+filesize);
                else
                    System.out.println("Downloaded successfully.");
                out.close();
                in.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void downloadFile(String sourceurl, String dest){
        URL url;
        try {
            url = new URL(sourceurl);
            HttpURLConnection hConnection = (HttpURLConnection) url
                    .openConnection();
            HttpURLConnection.setFollowRedirects(true);
            if (HttpURLConnection.HTTP_OK == hConnection.getResponseCode()) {
                InputStream in = hConnection.getInputStream();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(dest));
                int filesize = hConnection.getContentLength();
                byte[] buffer = new byte[4096];
                int numRead;
                long numWritten = 0;
                while ((numRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, numRead);
                    numWritten += numRead;
                    System.out.println((double)numWritten/(double)filesize);
                }
                if(filesize!=numWritten)
                    System.out.println("Wrote "+numWritten+" bytes, should have been "+filesize);
                else
                    System.out.println("Downloaded successfully.");
                out.close();
                in.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}