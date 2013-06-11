package archant.appian.com;

import java.io.*;

import org.apache.log4j.Logger;

import com.appiancorp.suiteapi.common.Name;
import com.appiancorp.suiteapi.process.exceptions.SmartServiceException;
import com.appiancorp.suiteapi.process.framework.AppianSmartService;
import com.appiancorp.suiteapi.process.framework.Input;
import com.appiancorp.suiteapi.process.framework.MessageContainer;
import com.appiancorp.suiteapi.process.framework.Required;
import com.appiancorp.suiteapi.process.framework.SmartServiceContext;

import com.appiancorp.suiteapi.process.palette.PaletteInfo; 

@PaletteInfo(paletteCategory = "Integration Services", palette = "Connectivity Services") 
public class createDIR extends AppianSmartService {

	private static final Logger LOG = Logger.getLogger(createDIR.class);
	private final SmartServiceContext smartServiceCtx;
	private String newDIRpath;
	private String result;

	@Override
	public void run() throws SmartServiceException {
		// TODO Auto-generated method stub
		try {
			createDIR(newDIRpath);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}
	
	private void createDIR(String newDIRpath2) {
		// TODO Auto-generated method stub
		
	}

	// create File object
	private void createDIR2(String newDIRpath){
		File newDIRpath2 = new File(newDIRpath);

	boolean dirFlag = false;
	try {
	   dirFlag = newDIRpath2.mkdir();
	} catch (SecurityException Se) {
	System.out.println("Error while creating directory in Java:" + Se);
	}

	if (dirFlag)
	   System.out.println("Directory created successfully");
	else
	   System.out.println("Directory was not created successfully");
	
	}

	public createDIR(SmartServiceContext smartServiceCtx) {
		super();
		this.smartServiceCtx = smartServiceCtx;
	}

	public void onSave(MessageContainer messages) {
	}

	public void validate(MessageContainer messages) {
	}

	@Input(required = Required.ALWAYS)
	@Name("newDIRpath")
	public void setNewDIRpath(String val) {
		this.newDIRpath = val;
	}

	@Name("result")
	public String getResult() {
		return result;
	}

}
