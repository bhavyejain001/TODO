package com.training.todo.utils;

import java.util.ResourceBundle;
import static com.training.todo.utils.Constants.MESSAGE_BUNDLE_FILE_NAME;;
public interface MessageReader {
	ResourceBundle rb = ResourceBundle.getBundle(MESSAGE_BUNDLE_FILE_NAME);

	public static String getValue(String key) {
		return rb.getString(key);
	}
}