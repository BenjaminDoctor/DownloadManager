package bdoctor.downloadManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class downloadQueue {

	Queue<download> queue = new LinkedList<download>();
	int activeDownloads = 0;
	
	public downloadQueue(){
		
	}
	
	public void addDownload(download d){
		queue.add(d);		
	}
	
	
	public void downloadFile(){
		//download[] d = new download[2];
		
		while(!queue.isEmpty()){
			//while(activeDownloads < 3){
				try{
					activeDownloads += 1;
					queue.poll().transferFile();
				}catch(IOException e){
					System.out.println("Error: ");
					e.printStackTrace();
				}
			//}
			activeDownloads -= 1;
		}
			/*	for(int i = 0; i < 2; i++){
					//d[i] = queue.poll();
					try {
						activeDownloads += 1;
						queue.poll().transferFile();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} */
			
			/*for(int x = 0; x < d.length; x++){
				if (d[x].downloadCompleted() && !queue.isEmpty())
					d[x] = queue.poll();
				else {
					d[x] = null;
					activeDownloads += -1;
				}
			} */
		
	}
	public String displayQueue(){
			download[] d = queue.toArray(new download[0]);
			String s ="\n";
			
			System.out.println(d.length);
			
			for(int i = 0; i < d.length; i++){
				System.out.println("Int i =" + i + " Source is " + d[i].getSource() + " Destination is " + d[i].getDestination());
				s += "Int i =" + i + " Source is " + d[i].getSource() + " Destination is " + d[i].getDestination() + "\n";
			}		
			
			return s;
	}
}
