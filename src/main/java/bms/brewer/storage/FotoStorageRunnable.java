package bms.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import bms.brewer.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> deferredResult;
	private FotoStorage fotoStorage;
	
	

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> deferredResult, FotoStorage fotoStorage) {
		this.files = files;
		this.deferredResult = deferredResult;
		this.fotoStorage = fotoStorage;
	}



	@Override
	public void run() {
		
		this.fotoStorage.salvarTemporariamente(files);
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		deferredResult.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
