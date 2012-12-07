package bdoctor.downloadManager;

import javax.swing.JOptionPane;

public class downloadManager {

	/**
	 * @param args
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	*/
	downloadQueue dq = new downloadQueue();

	public void createDownload(String source, String dest){
		download d = new download(source, dest);
		
		dq.addDownload(d);
		
	}
	
	public String getQueue(){
		return dq.displayQueue();		
	}
	
	public void downloadQueue(){
		dq.downloadFile();
	}
	
	public downloadManager(){
		String source;
		String file;
		
		
		/*DownloadManagerGUI mainWindow = new DownloadManagerGUI();
		
		mainWindow.isVisible();
		
		int x = 0;
		
		while(x == 0){
			source = JOptionPane.showInputDialog("Enter url");
			file = JOptionPane.showInputDialog("Enter destination");
			
			download d = new download(source,file);	
			
			dq.addDownload(d);
			
			x = JOptionPane.showConfirmDialog(null, "Add a download?");
		}		*/
		
		dq.displayQueue();
	}

}
