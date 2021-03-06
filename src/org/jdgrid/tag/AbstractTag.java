package org.jdgrid.tag;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

abstract public class AbstractTag extends SimpleTagSupport implements DynamicAttributes {
	private Map<String, Object> tagAttributes = new HashMap<String, Object>();

	public String getAdditionalAttributes() {
		StringWriter builder = new StringWriter();

		builder.append(" ");
		for (String attrName : tagAttributes.keySet()) {
			builder.append(attrName);
			builder.append("=\"");
			builder.append(tagAttributes.get(attrName).toString());
			builder.append("\" ");
		}

		return builder.toString();
	}
	
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		tagAttributes.put(localName, value);
	}
	
	public Map<String, Object> getDynamicAttribute() {
		return this.tagAttributes;
	}

}
