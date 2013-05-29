package archant.appian.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.appiancorp.suiteapi.common.Name;
import com.appiancorp.suiteapi.process.exceptions.SmartServiceException;
import com.appiancorp.suiteapi.process.framework.AppianSmartService;
import com.appiancorp.suiteapi.process.framework.Input;
import com.appiancorp.suiteapi.process.framework.MessageContainer;
import com.appiancorp.suiteapi.process.framework.Required;
import com.appiancorp.suiteapi.process.framework.SmartServiceContext;

import com.appiancorp.suiteapi.process.palette.PaletteInfo; 

@PaletteInfo(paletteCategory = "Integration Services", palette = "FileSystem Services") 
public class MoveFile extends AppianSmartService {

	private static final Logger LOG = Logger.getLogger(MoveFile.class);
	private static final boolean createDestDir = false;
	private final SmartServiceContext smartServiceCtx;
	private String filePath;
	private String destination;

	@Override
	public void run() throws SmartServiceException {
		try {
			Path(filePath, destination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Path(String filePath2, String destination2) {
	    File sourceFile = new File(filePath2);
	    File targetFile = new File(destination2);
	    try {
			FileUtils.moveFileToDirectory(sourceFile, targetFile, createDestDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public MoveFile(SmartServiceContext smartServiceCtx) {
		super();
		this.smartServiceCtx = smartServiceCtx;
	}

	public void onSave(MessageContainer messages) {
	}

	public void validate(MessageContainer messages) {
	}

	@Input(required = Required.OPTIONAL)
	@Name("FilePath")
	public void setFilePath(String val) {
		this.filePath = val;
	}

	@Input(required = Required.OPTIONAL)
	@Name("Destination")
	public void setDestination(String val) {
		this.destination = val;
	}

}
