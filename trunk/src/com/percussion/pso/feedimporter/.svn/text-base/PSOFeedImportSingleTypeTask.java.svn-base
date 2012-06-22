/*******************************************************************************
 * Copyright (c) 1999-2011 Percussion Software.
 * 
 * Permission is hereby granted, free of charge, to use, copy and create derivative works of this software and associated documentation files (the "Software") for internal use only and only in connection with products from Percussion Software. 
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL PERCUSSION SOFTWARE BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package com.percussion.pso.feedimporter;

import java.io.File;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.percussion.extension.IPSExtensionDef;
import com.percussion.extension.PSExtensionException;
import com.percussion.pso.imp.assembler.ImportContentAssemblerMerge;
import com.percussion.pso.restservice.IItemRestService;
import com.percussion.pso.restservice.ItemRestServiceLocator;
import com.percussion.services.schedule.IPSTask;
import com.percussion.services.schedule.IPSTaskResult;


/***
 * Handles importing feed all feed items of a specific content type. 
 * 
 * @author natechadwick
 *
 */
public class PSOFeedImportSingleTypeTask implements IPSTask{
		
		public static String FEED_CT_PARAM = "content_type";
		/**
	    * Logger for this class
	    */
	    private static final Log log = LogFactory.getLog(PSOFeedImportSingleTypeTask.class);

		private IPSExtensionDef def;
		private File codeRoot;
		
		@Override
		public void init(IPSExtensionDef def, File codeRoot)
				throws PSExtensionException {
			this.setDef(def);
			this.setCodeRoot(codeRoot);
		}

		@Override
		public IPSTaskResult perform(Map<String, String> params) {
			log.debug("PARAMS ARE: " +  params.get(FEED_CT_PARAM));
			log.debug("1. before task result");
			PSOFeedImporterTaskResult ret = new PSOFeedImporterTaskResult();
			log.debug("2. after task result");		
			try{
				IItemRestService svc = ItemRestServiceLocator.getItemServiceBase();	
				log.debug("Before updatItem");
		
				//@TODO: Add some deeper logic here to give the user the count of items processed etc.
				
				Response resp = svc.updateItems(false, params.get(FEED_CT_PARAM));
	
				log.debug("Did updateItem");
				//log.debug("Result is :" + resp);
				if(resp.getStatus()!=200){
					ret.setProblemDescription("Feed processing failed.");
					ret.setWasSuccess(false);
				}else{
					ret.setWasSuccess(true);
					ret.setProblemDescription("Feed processing completed.");
				}
//			}catch(Exception ex){
			}catch(Throwable ex){
				log.debug("Found Error");
				log.debug("Error is: " + ex.getMessage());
				log.error(ex,ex);	
				ret.setProblemDescription(ex.getMessage());
				ret.setWasSuccess(false);
			}
			return ret;

		}

		public void setDef(IPSExtensionDef def) {
			this.def = def;
		}

		public IPSExtensionDef getDef() {
			return def;
		}

		public void setCodeRoot(File codeRoot) {
			this.codeRoot = codeRoot;
		}

		public File getCodeRoot() {
			return codeRoot;
		}

		public PSOFeedImportSingleTypeTask(){}
}
