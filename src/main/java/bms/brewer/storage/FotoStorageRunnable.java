package bms.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import bms.brewer.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> deferredResult;
	
	

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> deferredResult) {
		this.files = files;
		this.deferredResult = deferredResult;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(">>> files: " + files[0].getSize());
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		deferredResult.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
