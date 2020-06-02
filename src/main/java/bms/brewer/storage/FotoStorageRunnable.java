package bms.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<String> deferredResult;
	
	

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<String> deferredResult) {
		this.files = files;
		this.deferredResult = deferredResult;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(">>> files: " + files[0].getSize());
		deferredResult.setResult("OK");
	}

}
