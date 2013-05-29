package archant.appian.com;

import java.io.*;

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
import com.appiancorp.suiteapi.type.AppianType;
import com.appiancorp.suiteapi.process.palette.PaletteInfo; 

 
@PaletteInfo(paletteCategory = "Integration Services", palette = "FileSystem Services") 
public class deleteDIR extends AppianSmartService {
      
	private static final Logger LOG = Logger.getLogger(deleteDIR.class);
	private final SmartServiceContext smartServiceCtx;
	private String directoryPath;//this the file path to be deleted in the server set given in the the input field in the Appian  

	@Override
	public void run() throws SmartServiceException {
		 	try {
		 		removeDirectory(directoryPath);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			} 
	  }
	   
	 private void removeDirectory(String directoryPath2) {
			// TODO Auto-generated method stub
		 File targetDir = new File(directoryPath2);
		 FileUtils.deleteQuietly(targetDir);{
			} 
		}
		
		public deleteDIR(SmartServiceContext smartServiceCtx) { super(); this.smartServiceCtx = smartServiceCtx;}
		public void onSave(MessageContainer messages) {}
		public void validate(MessageContainer messages) {}

		@Input(required = Required.OPTIONAL)
		@Name("directoryPath")
		public void setdirectoryPath(String val) {
			this.directoryPath = val;
		}

 }