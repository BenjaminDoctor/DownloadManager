package bdoctor.downloadManager;
		
import java.io.*;
import java.net.*;

public class download {

	/**
	 * @param args
	 */

	private String filename;
	private String urlString;
	private boolean completed = false;
	
	public void transferFile() throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		BufferedInputStream in = null;
        FileOutputStream fout = null;
        try
        {
        	URL aURL = new URL(urlString);
        	
        	System.out.println(urlString);
        	System.out.println("host = " + aURL.getHost());
        	//aURL.
        	
                in = new BufferedInputStream(aURL.openStream());
                fout = new FileOutputStream(filename);

                byte data[] = new byte[1024];
                int count;
                int progress = 0;
                
                while ((count = in.read(data, 0, 1024)) != -1)
                {
                        fout.write(data, 0, count);
                        progress += 1;
                        
                        if(progress%1000 == 0){
                        	System.out.println("Progress " + progress);
                        }
                        
                }
                completed = true;
                System.out.println("Completed " + urlString);
        }
        finally
        {
                if (in != null)
                        in.close();
                if (fout != null)
                        fout.close();
        }
    }


	public String getSource(){
		return this.urlString;
	}
	
	public String getDestination(){
		return this.filename ;
	}
	
	public boolean downloadCompleted(){
		return completed;
	}
	private String formatWebAddress(String webAddress){
		
		
		return webAddress;
	}
	
	public download(String urlString, String filename){
		this.urlString = formatWebAddress(urlString);
		this.filename = filename;
		
	}
}
