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

import java.util.HashMap;
import java.util.Map;

import com.percussion.services.schedule.IPSTaskResult;

public class PSOFeedImporterTaskResult implements IPSTaskResult{

	private Map<String,Object> notificationVariables = new HashMap<String,Object>();
	private String problemDescription;
	private boolean success;
	
	@Override
	public Map<String, Object> getNotificationVariables() {
		return this.notificationVariables;
	}

	@Override
	public String getProblemDescription() {
		return this.problemDescription;
	}

	@Override
	public boolean wasSuccess() {
		return this.success;
	}

	public void setNotificationVariables(Map<String,Object> notificationVariables) {
		this.notificationVariables = notificationVariables;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public void setWasSuccess(boolean wasSuccess) {
		this.success = wasSuccess;
	}

}
