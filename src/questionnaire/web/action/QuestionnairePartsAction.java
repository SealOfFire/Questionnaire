package questionnaire.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import questionnaire.bll.QuestionnaireBLL;
import questionnaire.bll.QuestionnairePartsBLL;
import questionnaire.bll.TypewriteBLL;
import questionnaire.web.model.Questionnaire;
import questionnaire.web.model.Typewrite;

public class QuestionnairePartsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Questionnaire> parts1 = null;
	private ArrayList<Questionnaire> parts2 = null;
	private ArrayList<Typewrite> parts3 = null;

	private Questionnaire selectParts1 = null;
	private Questionnaire selectParts2 = null;
	private Typewrite selectParts3 = null;

	private String selectedID = null;
	private String partsNo = null;

	/**  */
	public String edit() {
		this.parts1 = new QuestionnaireBLL().selectList();
		this.parts2 = new QuestionnaireBLL().selectList();
		this.parts3 = new TypewriteBLL().selectList();

		this.selectParts1 = new QuestionnairePartsBLL().selectPart1();
		this.selectParts2 = new QuestionnairePartsBLL().selectPart2();
		this.selectParts3 = new QuestionnairePartsBLL().selectPart3();
		return SUCCESS;
	}

	/**  */
	public String save() {
		switch (this.partsNo) {
		case "1":
			new QuestionnairePartsBLL().updatePart1(this.selectedID);
			break;
		case "2":
			new QuestionnairePartsBLL().updatePart2(this.selectedID);
			break;
		case "3":
			new QuestionnairePartsBLL().updatePart3(this.selectedID);
			break;
		}
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

	public Questionnaire getSelectParts1() {
		return selectParts1;
	}

	public void setSelectParts1(Questionnaire selectParts1) {
		this.selectParts1 = selectParts1;
	}

	public Questionnaire getSelectParts2() {
		return selectParts2;
	}

	public void setSelectParts2(Questionnaire selectParts2) {
		this.selectParts2 = selectParts2;
	}

	public Typewrite getSelectParts3() {
		return selectParts3;
	}

	public void setSelectParts3(Typewrite selectParts3) {
		this.selectParts3 = selectParts3;
	}

	public String getSelectedID() {
		return selectedID;
	}

	public void setSelectedID(String selectedID) {
		this.selectedID = selectedID;
	}

	public String getPartsNo() {
		return partsNo;
	}

	public void setPartsNo(String partsNo) {
		this.partsNo = partsNo;
	}
}
