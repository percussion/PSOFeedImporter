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
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.percussion.cms.objectstore.PSFolder;
import com.percussion.design.objectstore.PSLocator;
import com.percussion.extension.IPSExtensionDef;
import com.percussion.extension.PSExtensionException;
import com.percussion.pso.restservice.IItemRestService;
import com.percussion.pso.restservice.ItemRestServiceLocator;
//import com.percussion.pso.utils.IPSOItemSummaryFinder;
//import com.percussion.pso.utils.PSOItemSummaryFinderWrapper;
import com.percussion.services.contentmgr.IPSContentMgr;
import com.percussion.services.contentmgr.IPSNode;
import com.percussion.services.contentmgr.PSContentMgrConfig;
import com.percussion.services.contentmgr.PSContentMgrLocator;
import com.percussion.services.guidmgr.IPSGuidManager;
import com.percussion.services.guidmgr.PSGuidManagerLocator;
import com.percussion.services.guidmgr.PSGuidUtils;
import com.percussion.services.legacy.IPSCmsObjectMgr;
import com.percussion.services.legacy.PSCmsObjectMgrLocator;
import com.percussion.services.schedule.IPSTask;
import com.percussion.services.schedule.IPSTaskResult;
import com.percussion.utils.guid.IPSGuid;
import com.percussion.webservices.content.IPSContentWs;
import com.percussion.webservices.content.PSContentWsLocator;
import com.percussion.webservices.security.IPSSecurityWs;
import com.percussion.webservices.security.PSSecurityWsLocator;

/***
 * The PSOFeedImporterTask is a scheduled task 
 * that enables the scheduled execution of external 
 * data feeds using the system scheduler.
 *  
 * @author natechadwick
 *
 */
@SuppressWarnings("unused")
public class PSOFeedImporterTask implements IPSTask{
	
	public static String FEED_ID_PARAM = "sys_contentid";
	
	private IPSExtensionDef def;
	private File codeRoot;
	private int i;
	
	@Override
	public void init(IPSExtensionDef def, File codeRoot)
			throws PSExtensionException {
		this.def = def;
		this.codeRoot = codeRoot;
	}
	
	
	

	@Override
	public IPSTaskResult perform(Map<String, String> params) {
		PSOFeedImporterTaskResult ret = new PSOFeedImporterTaskResult();
				
		
		IItemRestService svc = ItemRestServiceLocator.getItemServiceBase();	
	
		//@TODO: Add some deeper logic here to give the user the count of items processed etc.
		Response resp = svc.updateItem(false, Integer.parseInt(params.get(FEED_ID_PARAM)), 0);
			
		if(resp.getStatus()==200)
			ret.setProblemDescription("Feed processing completed.");
		
		ret.setWasSuccess(true);

		return ret;

	}
	
}
