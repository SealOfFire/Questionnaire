package questionnaire.web.model;

import questionnaire.web.enumeration.QuestionnaireType;

public class ListItem {
	private Object key;
	private String value;

	public ListItem() {
	}

	public ListItem(Object key, String value) {
		this.key = key;
		this.value = value;
	}

	public ListItem(QuestionnaireType value) {
		this.key = value;
		this.value = value.getValue();
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
