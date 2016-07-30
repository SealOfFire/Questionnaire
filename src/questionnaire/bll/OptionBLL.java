package questionnaire.bll;

import java.util.ArrayList;
import java.util.UUID;

import questionnaire.dal.OptionDAL;
import questionnaire.web.model.Option;

public class OptionBLL {

	/** 插入数据 */
	public Option insert(Option option) {
		option.setOptionID(UUID.randomUUID().toString());
		new OptionDAL().insert(option.getOptionID(), option.getQuestionID(), option.getCaption(), option.getScore());
		return option;
	}

	/** 插入数据 */
	public int delete(String optionID) {
		return new OptionDAL().delete(optionID);
	}

	/**  */
	public ArrayList<Option> selectList(String questionID) {
		return new OptionDAL().selectList(questionID);
	}
}
