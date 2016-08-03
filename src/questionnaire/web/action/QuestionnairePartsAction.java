package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.web.model.Questionnaire;
import questionnaire.web.model.Typewrite;

public class QuestionnairePartsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Questionnaire> parts1 = null;
	private ArrayList<Questionnaire> parts2 = null;
	private ArrayList<Typewrite> parts3 = null;

	public String edit() {
		return SUCCESS;
	}

	public String save() {
		return SUCCESS;
	}

	public ArrayList<Questionnaire> getParts1() {
		return parts1;
	}

	public void setParts1(ArrayList<Questionnaire> parts1) {
		this.parts1 = parts1;
	}

	public ArrayList<Questionnaire> getParts2() {
		return parts2;
	}

	public void setParts2(ArrayList<Questionnaire> parts2) {
		this.parts2 = parts2;
	}

	public ArrayList<Typewrite> getParts3() {
		return parts3;
	}

	public void setParts3(ArrayList<Typewrite> parts3) {
		this.parts3 = parts3;
	}
}
