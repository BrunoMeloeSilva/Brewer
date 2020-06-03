package bms.brewer.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import bms.brewer.storage.FotoStorage;


public class FotoStorageLocal implements FotoStorage {

	private Path local;
	private Path localTemporario;
	
	public FotoStorageLocal() {
		this(getDefault().getPath(System.getenv("HOME"), ".brewerfotos"));
	}
	
	public FotoStorageLocal(Path path) {
		this.local = path;
		criarPastas();
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);
			
				System.out.println("Pastas criadas para salvar fotos.");
				System.out.println("Pasta default: " + this.local.toAbsolutePath());
				System.out.println("Pasta temporária: " + this.localTemporario.toAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException("Erro criando pasta para salvar foto", e);
		}
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] files) {
		System.out.println(">>>> salvando a foto temporariamente...");
	}
	
}